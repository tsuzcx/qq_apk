package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;

public class MediaCodecDecoder
{
  private static final String TAG = "MediaCodecDecoder";
  private MediaCodec.BufferInfo mAACDecBufferInfo = null;
  private MediaCodec mAudioAACDecoder = null;
  private int mChannels = 2;
  private ByteBuffer mDecInBuffer = ByteBuffer.allocateDirect(16384);
  private ByteBuffer mDecOutBuffer = ByteBuffer.allocateDirect(16384);
  ByteBuffer mInputBuffer = null;
  ByteBuffer mOutputBuffer = null;
  private int mSampleRate = 44100;
  private byte[] mTempBufDec = new byte[16384];
  
  @SuppressLint({"NewApi"})
  public int createAACDecoder(int paramInt1, int paramInt2)
  {
    try
    {
      this.mAudioAACDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
      Object localObject = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
      ((MediaFormat)localObject).setInteger("sample-rate", paramInt1);
      ((MediaFormat)localObject).setInteger("channel-count", paramInt2);
      ((MediaFormat)localObject).setInteger("aac-profile", 2);
      ((MediaFormat)localObject).setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 17, -112 }));
      this.mAudioAACDecoder.configure((MediaFormat)localObject, null, null, 0);
      if (this.mAudioAACDecoder != null)
      {
        this.mAudioAACDecoder.start();
        this.mAACDecBufferInfo = new MediaCodec.BufferInfo();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("createAACDecoder succeed!!! : (");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(")");
          QLog.w("MediaCodecDecoder", 2, ((StringBuilder)localObject).toString());
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      label155:
      break label155;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "Error when creating aac decode stream");
    }
    return -1;
  }
  
  public int decodeAACFrame(int paramInt)
  {
    this.mDecInBuffer.get(this.mTempBufDec, 0, paramInt);
    paramInt = decodeInternalAACFrame(paramInt);
    this.mDecOutBuffer.rewind();
    if (paramInt > 0)
    {
      this.mDecOutBuffer.put(this.mTempBufDec, 0, paramInt);
      return paramInt;
    }
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public int decodeInternalAACFrame(int paramInt)
  {
    for (;;)
    {
      try
      {
        i = this.mAudioAACDecoder.dequeueInputBuffer(200L);
        if (i >= 0)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            this.mInputBuffer = this.mAudioAACDecoder.getInputBuffer(i);
          } else {
            this.mInputBuffer = this.mAudioAACDecoder.getInputBuffers()[i];
          }
          this.mInputBuffer.clear();
          this.mInputBuffer.put(this.mTempBufDec, 0, paramInt);
          this.mDecInBuffer.rewind();
          this.mAudioAACDecoder.queueInputBuffer(i, 0, paramInt, 0L, 0);
        }
        i = this.mAudioAACDecoder.dequeueOutputBuffer(this.mAACDecBufferInfo, 10000L);
        if (i < 0) {
          return 0;
        }
        if (Build.VERSION.SDK_INT >= 21) {
          this.mOutputBuffer = this.mAudioAACDecoder.getOutputBuffer(i);
        } else {
          this.mOutputBuffer = this.mAudioAACDecoder.getOutputBuffers()[i];
        }
        j = this.mAACDecBufferInfo.size;
      }
      catch (Exception localException1)
      {
        int i;
        int j;
        continue;
      }
      try
      {
        this.mOutputBuffer.limit(j);
        this.mOutputBuffer.get(this.mTempBufDec, 0, j);
        this.mOutputBuffer.position(0);
        this.mAudioAACDecoder.releaseOutputBuffer(i, false);
        return j;
      }
      catch (Exception localException2)
      {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "Error when decoding aac stream");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "decode failed.");
    }
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public int releaseAACDecoder()
  {
    try
    {
      if (this.mAudioAACDecoder == null) {
        break label56;
      }
      this.mAudioAACDecoder.stop();
      this.mAudioAACDecoder.release();
      this.mAudioAACDecoder = null;
      if (QLog.isColorLevel()) {
        QLog.w("MediaCodecDecoder", 2, "releaseAACDecoder, release aac decode stream succeed!!");
      }
      return 0;
    }
    catch (Exception localException)
    {
      label42:
      label56:
      break label42;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "release aac decoder failed.");
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "releaseAACDecoder, Error when releasing aac decode stream");
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */