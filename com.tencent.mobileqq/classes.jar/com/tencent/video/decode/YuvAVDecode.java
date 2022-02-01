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
    Object localObject = this.mSourceHelper.getSourceVideoParam();
    this.mVideoFps = (paramAVDecodeOption.mVideoFrames * 1000.0F / paramAVDecodeOption.mTotalTime);
    this.videoParam.errcode = 0;
    this.videoParam.stream_kind = 1447642447;
    this.videoParam.width = localObject[0];
    this.videoParam.height = localObject[1];
    this.videoParam.frame_index = 0;
    this.videoParam.rotation = 0;
    float f1 = this.mVideoFps;
    if ((paramAVDecodeOption.wantedFps >= f1 / 2.0F) && (paramAVDecodeOption.wantedFps < f1) && (Math.abs(f1 - paramAVDecodeOption.wantedFps) > 2.0F))
    {
      this.mNeedDropFrame = true;
      float f2 = f1 / (f1 - paramAVDecodeOption.wantedFps);
      this.mDropSectionSize = ((int)f2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("YuvAVDecode,fps = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(",wantedFps = ");
        ((StringBuilder)localObject).append(paramAVDecodeOption.wantedFps);
        ((StringBuilder)localObject).append(",mDropSectionSize = ");
        ((StringBuilder)localObject).append(this.mDropSectionSize);
        ((StringBuilder)localObject).append(" dropSize=");
        ((StringBuilder)localObject).append(f2);
        QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
      }
      this.mNeedDropCount = ((int)(f1 / this.mDropSectionSize));
      paramAVDecodeOption.wantedFps = (f1 - this.mNeedDropCount);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("YuvAVDecode,fps = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(",wantedFps = ");
        ((StringBuilder)localObject).append(paramAVDecodeOption.wantedFps);
        ((StringBuilder)localObject).append(",mDropSectionSize = ");
        ((StringBuilder)localObject).append(this.mDropSectionSize);
        ((StringBuilder)localObject).append(" , mNeedDropCount=");
        ((StringBuilder)localObject).append(this.mNeedDropCount);
        QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
      }
      this.mTotalNeedDrop = ((int)(this.mNeedDropCount * (paramAVDecodeOption.mTotalTime / 1000.0F)));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("YuvAVDecode,mTotalNeedDrop = ");
        ((StringBuilder)localObject).append(this.mTotalNeedDrop);
        QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
      }
      this.mRealFps = paramAVDecodeOption.wantedFps;
      this.videoParam.fps_num = ((int)(this.mRealFps * 1000.0F));
      this.videoParam.fps_den = 1000;
    }
    else
    {
      this.mNeedDropFrame = false;
      this.mTotalNeedDrop = 0;
      this.mRealFps = this.mVideoFps;
      paramAVDecodeOption.wantedFps = this.mRealFps;
      this.videoParam.fps_num = ((int)(this.mRealFps * 1000.0F));
      this.videoParam.fps_den = 1000;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("YuvAVDecode,do not drop frame,fps = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(",wantedFps = ");
        ((StringBuilder)localObject).append(paramAVDecodeOption.wantedFps);
        ((StringBuilder)localObject).append(",mRealFps = ");
        ((StringBuilder)localObject).append(this.mRealFps);
        QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
      }
    }
    this.videoParam.duration = getVideoDuration(this.mRealFps);
    this.audioParam.errcode = 0;
    this.audioParam.stream_kind = 1096108367;
    this.audioParam.duration = -1;
    this.audioParam.sample_rate = this.mSourceHelper.mSampleRate;
    this.audioParam.numsample = 0;
    if (this.mSourceHelper.mPCMFormat == 3) {
      this.mSingleAudioByteNum = 1;
    } else if (this.mSourceHelper.mPCMFormat == 2) {
      this.mSingleAudioByteNum = 2;
    }
    this.audioParam.channels = this.mSourceHelper.mChannel;
    if (this.mSourceHelper.mChannel == 2)
    {
      this.audioParam.channels = 1;
    }
    else if (this.mSourceHelper.mChannel == 3)
    {
      this.audioParam.channels = 2;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramAVDecodeOption = new StringBuilder("YuvAVDecode,mSourceHelper.mChannel ");
        paramAVDecodeOption.append(this.mSourceHelper.mChannel);
        QLog.d("YuvAVDecode", 2, paramAVDecodeOption.toString());
      }
      this.audioParam.channels = 2;
    }
    this.audioParam.frameIndex = 0;
    initMediaBuffer();
    paramAVDecodeOption = new StringBuilder();
    paramAVDecodeOption.append("[");
    localObject = new StringBuilder(" videoParam.duration: ");
    ((StringBuilder)localObject).append(this.videoParam.duration);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder(" videoParam.width: ");
    ((StringBuilder)localObject).append(this.videoParam.width);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder(" videoParam.height: ");
    ((StringBuilder)localObject).append(this.videoParam.height);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder(" videoParam.fps_num: ");
    ((StringBuilder)localObject).append(this.videoParam.fps_num);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder(" videoParam.fps_den: ");
    ((StringBuilder)localObject).append(this.videoParam.fps_den);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder(" audioParam.sample_rate: ");
    ((StringBuilder)localObject).append(this.audioParam.sample_rate);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder(" audioParam.channels: ");
    ((StringBuilder)localObject).append(this.audioParam.channels);
    paramAVDecodeOption.append(((StringBuilder)localObject).toString());
    paramAVDecodeOption.append("] ");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("YuvAVDecode, ");
      ((StringBuilder)localObject).append(paramAVDecodeOption.toString());
      QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private int getAudioDuration(int paramInt)
  {
    return paramInt * 1000 / (this.audioParam.sample_rate * this.audioParam.channels * this.mSingleAudioByteNum);
  }
  
  private int getNextFrameDrop(Bitmap paramBitmap)
  {
    int j = this.mSourceHelper.getNextVideoFrameBitmap(paramBitmap);
    if (j == -1) {
      return j;
    }
    Object localObject = this.videoParam;
    ((AVVideoParam)localObject).frame_index += 1;
    int i = j;
    if (this.mNeedDropFrame)
    {
      i = j;
      if (this.videoParam.frame_index % this.mDropSectionSize == 0)
      {
        i = j;
        if (this.mCurrentDropped < this.mTotalNeedDrop)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("getNextFrameDrop,drop a frame,videoParam.frame_index  = ");
            ((StringBuilder)localObject).append(this.videoParam.frame_index);
            QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
          }
          this.mCurrentDropped += 1;
          j = this.mSourceHelper.getNextVideoFrameBitmap(paramBitmap);
          i = j;
          if (j == 0)
          {
            paramBitmap = this.videoParam;
            paramBitmap.frame_index += 1;
            i = j;
          }
        }
      }
    }
    return i;
  }
  
  private int getVideoDuration(float paramFloat)
  {
    return (int)(1000.0F / paramFloat);
  }
  
  private boolean initMediaBuffer()
  {
    int[] arrayOfInt = this.mSourceHelper.getBufferSize();
    if (arrayOfInt != null)
    {
      if (arrayOfInt.length < 2) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("initMediaBuffer videosize=");
        localStringBuilder.append(arrayOfInt[0]);
        localStringBuilder.append(", audiosize=");
        localStringBuilder.append(arrayOfInt[1]);
        QLog.d("YuvAVDecode", 4, localStringBuilder.toString());
      }
      try
      {
        if (this.audioBuffer == null)
        {
          int i = calcuAudioBufferSize();
          this.audioBuffer = new byte[i];
          this.mConvertBuffer = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        return true;
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
    catch (AVideoException paramAVDecodeOption)
    {
      paramAVDecodeOption.printStackTrace();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("YuvAVDecode,newInstance ep = ");
        localStringBuilder.append(paramAVDecodeOption);
        QLog.d("YuvAVDecode", 2, localStringBuilder.toString());
        return null;
      }
    }
    catch (UnsatisfiedLinkError paramAVDecodeOption)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("YuvAVDecode,newInstance err = ");
        localStringBuilder.append(paramAVDecodeOption);
        QLog.d("YuvAVDecode", 2, localStringBuilder.toString());
      }
    }
    return null;
  }
  
  private void resetVideoSource()
  {
    int i = this.mSourceHelper.resetDataSource();
    if (i != -1)
    {
      this.videoParam.frame_index = 0;
      this.audioParam.frameIndex = 0;
      this.mCurrentDropped = 0;
      return;
    }
    throw new AVideoException(i, -1, "reset error");
  }
  
  int calcuAudioBufferSize()
  {
    if (this.audioParam.channels <= 1) {
      i = 2;
    } else {
      i = 3;
    }
    int j = this.audioParam.sample_rate;
    StringBuilder localStringBuilder;
    if (j <= 0)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("calcuAudioBufferSize(), sampleRateInHz=");
        localStringBuilder.append(j);
        localStringBuilder.append(", <= 0, return...");
        QLog.e("YuvAVDecode", 2, localStringBuilder.toString());
      }
      return 2000;
    }
    j = AudioTrack.getMinBufferSize(j, i, 2);
    int i = j;
    if (j < 1024)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("calcuAudioBufferSize(), minBufSize=");
        localStringBuilder.append(j);
        localStringBuilder.append(" < 1024, so mutiply 2");
        QLog.d("YuvAVDecode", 2, localStringBuilder.toString());
      }
      j *= 2;
      i = j;
      if (j < 1024) {
        i = 1024;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("calcuAudioBufferSize() primePlaySize: ");
      localStringBuilder.append(i);
      QLog.d("YuvAVDecode", 2, localStringBuilder.toString());
    }
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("seekToNextAudioShortFrame,byteNum = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("YuvAVDecode", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 0)
    {
      this.audioParam.numsample = (i / this.mSingleAudioByteNum);
      localObject = this.audioParam;
      ((AVAudioParam)localObject).frameIndex += 1;
      this.audioParam.duration = getAudioDuration(i);
      this.mConvertBuffer.position(0);
      this.mConvertBuffer.put(this.audioBuffer, 0, i);
      this.mConvertBuffer.position(0);
      localObject = new short[i / 2];
      this.mConvertBuffer.asShortBuffer().get((short[])localObject);
      long l3 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("seekToNextAudioShortFrame,byteNum = ");
        localStringBuilder.append(i);
        localStringBuilder.append(",duration = ");
        localStringBuilder.append(this.audioParam.duration);
        localStringBuilder.append(", nativeCost = ");
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append(",convertCost = ");
        localStringBuilder.append(l3 - l2);
        QLog.d("YuvAVDecode", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder("seekToNextFrame,cost = ");
      paramBitmap.append(SystemClock.elapsedRealtime() - l);
      QLog.d("YuvAVDecode", 2, paramBitmap.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.video.decode.YuvAVDecode
 * JD-Core Version:    0.7.0.1
 */