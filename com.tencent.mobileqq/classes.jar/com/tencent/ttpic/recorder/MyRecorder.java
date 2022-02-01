package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.util.RenderLevelHelper;
import com.tencent.ttpic.openapi.util.RenderLevelHelper.DOWNGRADE_LEVEL;
import java.nio.ByteBuffer;

@TargetApi(18)
public class MyRecorder
{
  private static final String TAG = "MyRecorder";
  private int index;
  private MediaCodec.BufferInfo mBufferInfo = null;
  private MediaCodec mMediaCodec = null;
  private MediaMuxer mMediaMuxer = null;
  private boolean mMuxerStarted = false;
  private String mOutput;
  private float mPlayRate = 1.0F;
  private Surface mSurface;
  private int mTrackIndex = -1;
  
  public MyRecorder(String paramString)
  {
    this.mOutput = paramString;
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    if (!isValid()) {
      return;
    }
    if (paramBoolean) {}
    try
    {
      this.mMediaCodec.signalEndOfInputStream();
      ByteBuffer[] arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
      int i;
      label346:
      do
      {
        Object localObject;
        for (;;)
        {
          i = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
          if (i == -1)
          {
            if (paramBoolean) {}
          }
          else if (i == -3)
          {
            arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
          }
          else if (i == -2)
          {
            if (this.mMuxerStarted)
            {
              LogUtils.e(TAG, "format changed twice");
              this.mMediaCodec.releaseOutputBuffer(i, false);
            }
            else
            {
              localObject = this.mMediaCodec.getOutputFormat();
              this.mTrackIndex = this.mMediaMuxer.addTrack((MediaFormat)localObject);
              this.mMediaMuxer.start();
              this.mMuxerStarted = true;
            }
          }
          else
          {
            localObject = arrayOfByteBuffer[i];
            if (localObject == null)
            {
              localObject = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("encoderOutputBuffer ");
              localStringBuilder.append(i);
              localStringBuilder.append(" was null");
              LogUtils.e((String)localObject, localStringBuilder.toString());
              this.mMediaCodec.releaseOutputBuffer(i, false);
            }
            else
            {
              if ((this.mBufferInfo.flags & 0x2) != 0) {
                this.mBufferInfo.size = 0;
              }
              if (this.mBufferInfo.size == 0) {
                break label346;
              }
              if (this.mMuxerStarted) {
                break;
              }
              LogUtils.e(TAG, "muxer hasn't started");
              this.mMediaCodec.releaseOutputBuffer(i, false);
            }
          }
        }
        ((ByteBuffer)localObject).position(this.mBufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.mBufferInfo.offset + this.mBufferInfo.size);
        if (Float.compare(this.mPlayRate, 1.0F) != 0) {
          this.mBufferInfo.presentationTimeUs = (((float)this.mBufferInfo.presentationTimeUs * this.mPlayRate));
        }
        this.mMediaMuxer.writeSampleData(this.mTrackIndex, (ByteBuffer)localObject, this.mBufferInfo);
        this.mMediaCodec.releaseOutputBuffer(i, false);
        i = this.mBufferInfo.flags;
      } while ((i & 0x4) == 0);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      LogUtils.e(TAG, localRuntimeException.toString());
    }
  }
  
  private boolean isValid()
  {
    return (this.mMediaCodec != null) && (this.mMediaMuxer != null) && (this.mBufferInfo != null);
  }
  
  public Surface getInputSurface()
  {
    return this.mSurface;
  }
  
  public String getOutputPath()
  {
    return this.mOutput;
  }
  
  public boolean isRecording()
  {
    return this.mMediaCodec != null;
  }
  
  public boolean prepareEncoder(int paramInt1, int paramInt2)
  {
    if (this.mMediaCodec != null)
    {
      LogUtils.e(TAG, "prepareEncoder called twice?");
      return true;
    }
    this.mBufferInfo = new MediaCodec.BufferInfo();
    try
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat(VideoParam.mMime, paramInt1, paramInt2);
      localMediaFormat.setInteger("color-format", 2130708361);
      localMediaFormat.setInteger("bitrate", RenderLevelHelper.getRenderLevel().bps);
      localMediaFormat.setInteger("frame-rate", 18);
      localMediaFormat.setInteger("i-frame-interval", VideoParam.mIfi);
      this.mMediaCodec = MediaCodec.createEncoderByType(VideoParam.mMime);
      if (this.mMediaCodec != null) {
        this.mMediaCodec.configure(localMediaFormat, null, null, 1);
      }
      this.mMediaMuxer = new MediaMuxer(this.mOutput, 0);
      this.mMuxerStarted = false;
      if ((this.mSurface == null) && (this.mMediaCodec != null)) {
        this.mSurface = this.mMediaCodec.createInputSurface();
      }
      return true;
    }
    catch (Exception localException)
    {
      releaseEncoder();
      localException.printStackTrace();
    }
    return false;
  }
  
  public void releaseEncoder()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      if (this.mMediaMuxer != null)
      {
        this.mMediaMuxer.stop();
        this.mMediaMuxer.release();
        this.mMediaMuxer = null;
      }
      this.mBufferInfo = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      label58:
      break label58;
    }
    LogUtils.e(TAG, "releaseEncoder error!");
  }
  
  public void setPlayRate(float paramFloat)
  {
    this.mPlayRate = paramFloat;
  }
  
  public void start()
  {
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.start();
    }
  }
  
  public void stop()
  {
    drainEncoder(true);
    releaseEncoder();
  }
  
  public void swapBuffers()
  {
    if (isRecording())
    {
      if (!isValid()) {
        return;
      }
      drainEncoder(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.recorder.MyRecorder
 * JD-Core Version:    0.7.0.1
 */