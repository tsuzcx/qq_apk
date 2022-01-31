package com.tencent.video.decode;

import android.graphics.Bitmap;
import android.media.AudioTrack;
import android.os.SystemClock;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public class YuvAVDecode
  extends AbstractAVDecode
{
  public static final String TAG = "YuvAVDecode";
  private byte[] audioBuffer = null;
  AVDecodeOption mAVOption;
  private ByteBuffer mConvertBuffer = null;
  int mCurrentDropped = 0;
  int mDropSectionSize;
  int mNeedDropCount;
  boolean mNeedDropFrame;
  float mRealFps = -1.0F;
  int mSingleAudioByteNum;
  VideoSourceHelper mSourceHelper;
  int mTotalNeedDrop = 0;
  float mVideoFps = -1.0F;
  
  private YuvAVDecode(AVDecodeOption paramAVDecodeOption)
  {
    this.mSourceHelper = new VideoSourceHelper(paramAVDecodeOption.mVfPath, paramAVDecodeOption.mAfPath);
    this.mAVOption = paramAVDecodeOption;
    this.mSourceHelper.initHelperParam();
    int[] arrayOfInt = this.mSourceHelper.getSourceVideoParam();
    this.mVideoFps = (paramAVDecodeOption.mVideoFrames * 1000.0F / paramAVDecodeOption.mTotalTime);
    this.videoParam.errcode = 0;
    this.videoParam.stream_kind = 1447642447;
    this.videoParam.width = arrayOfInt[0];
    this.videoParam.height = arrayOfInt[1];
    this.videoParam.frame_index = 0;
    this.videoParam.rotation = 0;
    float f1 = this.mVideoFps;
    if ((paramAVDecodeOption.wantedFps >= f1 / 2.0F) && (paramAVDecodeOption.wantedFps < f1) && (Math.abs(f1 - paramAVDecodeOption.wantedFps) > 2.0F))
    {
      this.mNeedDropFrame = true;
      float f2 = f1 / (f1 - paramAVDecodeOption.wantedFps);
      this.mDropSectionSize = ((int)f2);
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "YuvAVDecode,fps = " + f1 + ",wantedFps = " + paramAVDecodeOption.wantedFps + ",mDropSectionSize = " + this.mDropSectionSize + " dropSize=" + f2);
      }
      this.mNeedDropCount = ((int)(f1 / this.mDropSectionSize));
      paramAVDecodeOption.wantedFps = (f1 - this.mNeedDropCount);
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "YuvAVDecode,fps = " + f1 + ",wantedFps = " + paramAVDecodeOption.wantedFps + ",mDropSectionSize = " + this.mDropSectionSize + " , mNeedDropCount=" + this.mNeedDropCount);
      }
      this.mTotalNeedDrop = ((int)(this.mNeedDropCount * (paramAVDecodeOption.mTotalTime / 1000.0F)));
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "YuvAVDecode,mTotalNeedDrop = " + this.mTotalNeedDrop);
      }
      this.mRealFps = paramAVDecodeOption.wantedFps;
      this.videoParam.fps_num = ((int)(this.mRealFps * 1000.0F));
      this.videoParam.fps_den = 1000;
      this.videoParam.duration = getVideoDuration(this.mRealFps);
      this.audioParam.errcode = 0;
      this.audioParam.stream_kind = 1096108367;
      this.audioParam.duration = -1;
      this.audioParam.sample_rate = this.mSourceHelper.mSampleRate;
      this.audioParam.numsample = 0;
      if (this.mSourceHelper.mPCMFormat != 3) {
        break label913;
      }
      this.mSingleAudioByteNum = 1;
      label518:
      this.audioParam.channels = this.mSourceHelper.mChannel;
      if (this.mSourceHelper.mChannel != 2) {
        break label932;
      }
      this.audioParam.channels = 1;
    }
    for (;;)
    {
      this.audioParam.frameIndex = 0;
      initMediaBuffer();
      paramAVDecodeOption = new StringBuilder();
      paramAVDecodeOption.append("[");
      paramAVDecodeOption.append(" videoParam.duration: " + this.videoParam.duration);
      paramAVDecodeOption.append(" videoParam.width: " + this.videoParam.width);
      paramAVDecodeOption.append(" videoParam.height: " + this.videoParam.height);
      paramAVDecodeOption.append(" videoParam.fps_num: " + this.videoParam.fps_num);
      paramAVDecodeOption.append(" videoParam.fps_den: " + this.videoParam.fps_den);
      paramAVDecodeOption.append(" audioParam.sample_rate: " + this.audioParam.sample_rate);
      paramAVDecodeOption.append(" audioParam.channels: " + this.audioParam.channels);
      paramAVDecodeOption.append("] ");
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "YuvAVDecode, " + paramAVDecodeOption.toString());
      }
      return;
      this.mNeedDropFrame = false;
      this.mTotalNeedDrop = 0;
      this.mRealFps = this.mVideoFps;
      paramAVDecodeOption.wantedFps = this.mRealFps;
      this.videoParam.fps_num = ((int)(this.mRealFps * 1000.0F));
      this.videoParam.fps_den = 1000;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("YuvAVDecode", 2, "YuvAVDecode,do not drop frame,fps = " + f1 + ",wantedFps = " + paramAVDecodeOption.wantedFps + ",mRealFps = " + this.mRealFps);
      break;
      label913:
      if (this.mSourceHelper.mPCMFormat != 2) {
        break label518;
      }
      this.mSingleAudioByteNum = 2;
      break label518;
      label932:
      if (this.mSourceHelper.mChannel == 3)
      {
        this.audioParam.channels = 2;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("YuvAVDecode", 2, "YuvAVDecode,mSourceHelper.mChannel " + this.mSourceHelper.mChannel);
        }
        this.audioParam.channels = 2;
      }
    }
  }
  
  private int getAudioDuration(int paramInt)
  {
    return paramInt * 1000 / (this.audioParam.sample_rate * this.audioParam.channels * this.mSingleAudioByteNum);
  }
  
  private int getNextFrameDrop(Bitmap paramBitmap)
  {
    int j = this.mSourceHelper.getNextVideoFrameBitmap(paramBitmap);
    int i;
    if (j == -1) {
      i = j;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            AVVideoParam localAVVideoParam = this.videoParam;
            localAVVideoParam.frame_index += 1;
            i = j;
          } while (!this.mNeedDropFrame);
          i = j;
        } while (this.videoParam.frame_index % this.mDropSectionSize != 0);
        i = j;
      } while (this.mCurrentDropped >= this.mTotalNeedDrop);
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "getNextFrameDrop,drop a frame,videoParam.frame_index  = " + this.videoParam.frame_index);
      }
      this.mCurrentDropped += 1;
      j = this.mSourceHelper.getNextVideoFrameBitmap(paramBitmap);
      i = j;
    } while (j != 0);
    paramBitmap = this.videoParam;
    paramBitmap.frame_index += 1;
    return j;
  }
  
  private int getVideoDuration(float paramFloat)
  {
    return (int)(1000.0F / paramFloat);
  }
  
  private boolean initMediaBuffer()
  {
    boolean bool = true;
    int[] arrayOfInt = this.mSourceHelper.getBufferSize();
    if ((arrayOfInt == null) || (arrayOfInt.length < 2)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 4, "initMediaBuffer videosize=" + arrayOfInt[0] + ", audiosize=" + arrayOfInt[1]);
      }
      try
      {
        if (this.audioBuffer == null)
        {
          int i = calcuAudioBufferSize();
          this.audioBuffer = new byte[i];
          this.mConvertBuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
          return true;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    return false;
  }
  
  public static YuvAVDecode newInstance(AVDecodeOption paramAVDecodeOption)
  {
    try
    {
      checkSoLoaded();
      paramAVDecodeOption = new YuvAVDecode(paramAVDecodeOption);
      return paramAVDecodeOption;
    }
    catch (UnsatisfiedLinkError paramAVDecodeOption)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("YuvAVDecode", 2, "YuvAVDecode,newInstance err = " + paramAVDecodeOption);
        return null;
      }
    }
    catch (AVideoException paramAVDecodeOption)
    {
      paramAVDecodeOption.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "YuvAVDecode,newInstance ep = " + paramAVDecodeOption);
      }
    }
    return null;
  }
  
  private void resetVideoSource()
  {
    int i = this.mSourceHelper.resetDataSource();
    if (i == -1) {
      throw new AVideoException(i, -1, "reset error");
    }
    this.videoParam.frame_index = 0;
    this.audioParam.frameIndex = 0;
    this.mCurrentDropped = 0;
  }
  
  int calcuAudioBufferSize()
  {
    int i;
    int j;
    if (this.audioParam.channels <= 1)
    {
      i = 2;
      j = this.audioParam.sample_rate;
      if (j > 0) {
        break label71;
      }
      if (QLog.isColorLevel()) {
        QLog.e("YuvAVDecode", 2, "calcuAudioBufferSize(), sampleRateInHz=" + j + ", <= 0, return...");
      }
      j = 2000;
    }
    label71:
    do
    {
      return j;
      i = 3;
      break;
      j = AudioTrack.getMinBufferSize(j, i, 2);
      i = j;
      if (j < 1024)
      {
        if (QLog.isColorLevel()) {
          QLog.d("YuvAVDecode", 2, "calcuAudioBufferSize(), minBufSize=" + j + " < 1024, so mutiply 2");
        }
        j *= 2;
        i = j;
        if (j < 1024) {
          i = 1024;
        }
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("YuvAVDecode", 2, "calcuAudioBufferSize() primePlaySize: " + i);
    return i;
  }
  
  public void close()
  {
    this.mSourceHelper.closeHelper();
  }
  
  public void resetVideoPlayer(AVDecodeOption paramAVDecodeOption)
  {
    this.mSourceHelper.resetDataSource();
  }
  
  public byte[] seekToNextAudioByteFrame()
  {
    if (QLog.isColorLevel()) {
      QLog.d("YuvAVDecode", 2, "seekToNextAudioByteFrame ");
    }
    int i = this.mSourceHelper.getNextAudioFrame(this.audioBuffer);
    if (i > 0)
    {
      this.audioParam.numsample = (i / this.mSingleAudioByteNum);
      AVAudioParam localAVAudioParam = this.audioParam;
      localAVAudioParam.frameIndex += 1;
    }
    return this.audioBuffer;
  }
  
  public float[] seekToNextAudioFloatFrame()
  {
    return null;
  }
  
  public short[] seekToNextAudioShortFrame()
  {
    long l1 = SystemClock.elapsedRealtime();
    int i = this.mSourceHelper.getNextAudioFrame(this.audioBuffer);
    long l2 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("YuvAVDecode", 2, "seekToNextAudioShortFrame,byteNum = " + i);
    }
    if (i > 0)
    {
      this.audioParam.numsample = (i / this.mSingleAudioByteNum);
      Object localObject = this.audioParam;
      ((AVAudioParam)localObject).frameIndex += 1;
      this.audioParam.duration = getAudioDuration(i);
      this.mConvertBuffer.position(0);
      this.mConvertBuffer.put(this.audioBuffer, 0, i);
      this.mConvertBuffer.position(0);
      localObject = new short[i / 2];
      this.mConvertBuffer.asShortBuffer().get((short[])localObject);
      long l3 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("YuvAVDecode", 2, "seekToNextAudioShortFrame,byteNum = " + i + ",duration = " + this.audioParam.duration + ", nativeCost = " + (l2 - l1) + ",convertCost = " + (l3 - l2));
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("YuvAVDecode", 2, "seekToNextAudioShortFrame throw exception");
    }
    throw new AVideoException(-116, -1, " seekToNextAudioShortFrame error");
  }
  
  public void seekToNextFrame(Bitmap paramBitmap)
  {
    long l = SystemClock.elapsedRealtime();
    int i = getNextFrameDrop(paramBitmap);
    if (i == -1)
    {
      this.videoParam.frame_count = this.videoParam.frame_index;
      if (this.mAVOption.cycle)
      {
        resetVideoSource();
        i = getNextFrameDrop(paramBitmap);
        if (i == -1) {
          throw new AVideoException(i, -1, "recycle getNextFrameDrop error");
        }
      }
      else
      {
        throw new AVideoException(-110, i, " getNextFrameDrop error");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("YuvAVDecode", 2, "seekToNextFrame,cost = " + (SystemClock.elapsedRealtime() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.video.decode.YuvAVDecode
 * JD-Core Version:    0.7.0.1
 */