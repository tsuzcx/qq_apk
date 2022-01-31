package com.tencent.vbox.encode.hard;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;

@TargetApi(18)
public class VideoGenerator
{
  private static final String TAG = VideoGenerator.class.getSimpleName();
  private boolean first = true;
  private int index = 0;
  private MediaCodec.BufferInfo mBufferInfo;
  private EncoderSurface mEncoderSurface;
  private ArrayList<Long> mFramestampList = new ArrayList();
  private int mHeight;
  private MediaCodec mMediaCodec;
  private MediaMuxer mMediaMuxer;
  private boolean mMuxerStarted = false;
  private String mOriginalVideoPath;
  private String mPath;
  public SurfaceRender mSurfaceRender;
  private int mTotalSize = 0;
  private int mTrackIndex = -1;
  private int mWidth;
  
  public VideoGenerator(String paramString, int paramInt1, int paramInt2)
  {
    this.mPath = paramString;
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    initEncoder();
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    if (paramBoolean) {}
    label141:
    label477:
    label480:
    for (;;)
    {
      int i;
      try
      {
        this.mMediaCodec.signalEndOfInputStream();
        ByteBuffer[] arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
        i = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
        if (i == -1)
        {
          if (paramBoolean) {
            break label477;
          }
          return;
        }
        if (i == -3)
        {
          arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
          break label480;
        }
        if (i != -2) {
          break label141;
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
        Log.e(TAG, "MediaCodec encode error");
        return;
      }
      this.mTrackIndex = this.mMediaMuxer.addTrack(localMediaFormat);
      this.mMediaMuxer.start();
      this.mMuxerStarted = true;
      break label480;
      MediaFormat localMediaFormat = localRuntimeException[i];
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
        if (this.mBufferInfo.size != 0)
        {
          if (!this.mMuxerStarted)
          {
            Log.e(TAG, "muxer hasn't started");
            this.mMediaCodec.releaseOutputBuffer(i, false);
          }
          else
          {
            localMediaFormat.position(this.mBufferInfo.offset);
            localMediaFormat.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
            if ((this.index > 0) && (((Long)this.mFramestampList.get(this.index)).longValue() < ((Long)this.mFramestampList.get(this.index - 1)).longValue())) {
              this.mFramestampList.add(this.index, Long.valueOf(((Long)this.mFramestampList.get(this.index - 1)).longValue() + 100000L));
            }
            this.mBufferInfo.presentationTimeUs = ((Long)this.mFramestampList.get(this.index)).longValue();
            this.mMediaMuxer.writeSampleData(this.mTrackIndex, localMediaFormat, this.mBufferInfo);
            this.index += 1;
          }
        }
        else
        {
          this.mMediaCodec.releaseOutputBuffer(i, false);
          if ((this.mBufferInfo.flags & 0x4) != 0)
          {
            Log.i(TAG, "total encode " + this.index + " frames");
            return;
          }
        }
      }
    }
  }
  
  private void initEncoder()
  {
    this.mBufferInfo = new MediaCodec.BufferInfo();
    try
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", this.mWidth, this.mHeight);
      localMediaFormat.setInteger("color-format", 2130708361);
      localMediaFormat.setInteger("bitrate", 5242880);
      localMediaFormat.setInteger("frame-rate", 25);
      localMediaFormat.setInteger("i-frame-interval", 1);
      localMediaFormat.setInteger("max-input-size", 0);
      this.mMediaCodec = MediaCodec.createEncoderByType("video/avc");
      this.mMediaCodec.configure(localMediaFormat, null, null, 1);
      this.mMediaMuxer = new MediaMuxer(this.mPath, 0);
      this.mMuxerStarted = false;
      return;
    }
    catch (Exception localException)
    {
      releaseEncoder();
      localException.printStackTrace();
    }
  }
  
  private void releaseEncoder()
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
  
  private void releaseEncoderSurface()
  {
    if (this.mEncoderSurface != null)
    {
      this.mEncoderSurface.release();
      this.mEncoderSurface = null;
    }
  }
  
  public void encodeFrame(long paramLong)
  {
    this.mFramestampList.add(Long.valueOf(paramLong * 1000L));
    if (this.first)
    {
      this.mMediaCodec.start();
      this.first = false;
    }
    this.mEncoderSurface.setPresentationTime(paramLong * 1000L * 1000L);
    this.mSurfaceRender.draw();
    drainEncoder(false);
  }
  
  public void prepare(int paramInt)
  {
    this.mEncoderSurface = new EncoderSurface(this.mMediaCodec.createInputSurface());
    this.mSurfaceRender = new SurfaceRender(this.mWidth, this.mHeight, paramInt, this.mEncoderSurface);
  }
  
  public void release()
  {
    releaseEncoder();
    releaseEncoderSurface();
  }
  
  public void stop()
  {
    drainEncoder(true);
    release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.encode.hard.VideoGenerator
 * JD-Core Version:    0.7.0.1
 */