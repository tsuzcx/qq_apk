package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import android.view.Surface;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.FrameRateUtil.DOWNGRADE_LEVEL;
import java.nio.ByteBuffer;

@TargetApi(18)
public class MyRecorder
{
  private static final String TAG = MyRecorder.class.getSimpleName();
  private MediaCodec.BufferInfo mBufferInfo = null;
  private MediaCodec mMediaCodec = null;
  private MediaMuxer mMediaMuxer = null;
  private boolean mMuxerStarted = false;
  private String mOutput;
  private float mPlayRate = 1.0F;
  private Surface mSurface;
  private int mTrackIndex = -1;
  private final VideoParam mVideoParam = new VideoParam();
  
  public MyRecorder(Camera.Parameters paramParameters, String paramString)
  {
    this.mVideoParam.init(paramParameters);
    this.mOutput = paramString;
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    if (!isValid()) {
      return;
    }
    if (paramBoolean) {}
    int i;
    label151:
    label345:
    do
    {
      MediaFormat localMediaFormat;
      for (;;)
      {
        try
        {
          this.mMediaCodec.signalEndOfInputStream();
          ByteBuffer[] arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
          i = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
          if (i == -1)
          {
            if (paramBoolean) {
              continue;
            }
            return;
          }
          if (i == -3)
          {
            arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
            continue;
          }
          if (i != -2) {
            break label151;
          }
          if (this.mMuxerStarted)
          {
            Log.e(TAG, "format changed twice");
            this.mMediaCodec.releaseOutputBuffer(i, false);
            continue;
          }
          localMediaFormat = this.mMediaCodec.getOutputFormat();
        }
        catch (RuntimeException localRuntimeException)
        {
          Log.e(TAG, localRuntimeException.toString());
          return;
        }
        this.mTrackIndex = this.mMediaMuxer.addTrack(localMediaFormat);
        this.mMediaMuxer.start();
        this.mMuxerStarted = true;
        continue;
        localMediaFormat = localRuntimeException[i];
        if (localMediaFormat == null)
        {
          Log.e(TAG, "encoderOutputBuffer " + i + " was null");
          this.mMediaCodec.releaseOutputBuffer(i, false);
        }
        else
        {
          if ((this.mBufferInfo.flags & 0x2) != 0) {
            this.mBufferInfo.size = 0;
          }
          if (this.mBufferInfo.size == 0) {
            break label345;
          }
          if (this.mMuxerStarted) {
            break;
          }
          Log.e(TAG, "muxer hasn't started");
          this.mMediaCodec.releaseOutputBuffer(i, false);
        }
      }
      localMediaFormat.position(this.mBufferInfo.offset);
      localMediaFormat.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
      if (Float.compare(this.mPlayRate, 1.0F) != 0) {
        this.mBufferInfo.presentationTimeUs = (((float)this.mBufferInfo.presentationTimeUs * this.mPlayRate));
      }
      this.mMediaMuxer.writeSampleData(this.mTrackIndex, localMediaFormat, this.mBufferInfo);
      this.mMediaCodec.releaseOutputBuffer(i, false);
      i = this.mBufferInfo.flags;
    } while ((i & 0x4) == 0);
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
    if (this.mMediaCodec != null) {
      Log.e(TAG, "prepareEncoder called twice?");
    }
    for (;;)
    {
      return true;
      if (this.mVideoParam.mMime == null)
      {
        Log.e(TAG, "MIME type error!");
        return false;
      }
      this.mBufferInfo = new MediaCodec.BufferInfo();
      try
      {
        MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mVideoParam.mMime, paramInt1, paramInt2);
        localMediaFormat.setInteger("color-format", 2130708361);
        localMediaFormat.setInteger("bitrate", FrameRateUtil.getRenderLevel().bps);
        localMediaFormat.setInteger("frame-rate", 18);
        localMediaFormat.setInteger("i-frame-interval", this.mVideoParam.mIfi);
        this.mMediaCodec = MediaCodec.createEncoderByType(this.mVideoParam.mMime);
        this.mMediaCodec.configure(localMediaFormat, null, null, 1);
        this.mMediaMuxer = new MediaMuxer(this.mOutput, 0);
        this.mMuxerStarted = false;
        if ((this.mSurface == null) && (this.mMediaCodec != null))
        {
          this.mSurface = this.mMediaCodec.createInputSurface();
          return true;
        }
      }
      catch (Exception localException)
      {
        releaseEncoder();
        localException.printStackTrace();
      }
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
      Log.e(TAG, "releaseEncoder error!");
    }
  }
  
  public void setPlayRate(float paramFloat)
  {
    this.mPlayRate = paramFloat;
  }
  
  public void start()
  {
    if (this.mMediaCodec != null) {
      this.mMediaCodec.start();
    }
  }
  
  public void stop()
  {
    drainEncoder(true);
    releaseEncoder();
  }
  
  public void swapBuffers()
  {
    if ((!isRecording()) || (!isValid())) {
      return;
    }
    drainEncoder(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.MyRecorder
 * JD-Core Version:    0.7.0.1
 */