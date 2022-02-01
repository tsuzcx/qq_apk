package com.tencent.qq.effect.alphavideo.videoplayer.decoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.utils.LogUtil;
import java.nio.ByteBuffer;

public class HardwareFileDecoder
  implements IVideoFileDecoder
{
  private String TAG = "VideoPlayer|HardwareFileDecoder";
  private IVideoFileDecodeListener mDecodeListener = null;
  private MediaExtractor mExtractor = null;
  private long mFirstFrameSysTime = 0L;
  private long mFirstFrameTimeUS = 0L;
  private MediaFormat mFormat = null;
  private ByteBuffer[] mInputBuffers = null;
  private boolean mLoop = false;
  private MediaCodec mMediaCodec = null;
  private String mMime = null;
  private ByteBuffer[] mOutputBuffers = null;
  private long mPresentationTimeUs = 0L;
  private long mSamplePresentationTimeUs = 0L;
  private boolean mStart = false;
  
  public HardwareFileDecoder() {}
  
  public HardwareFileDecoder(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  private void releaseCodec()
  {
    if (this.mMediaCodec != null) {}
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mMediaCodec stop + release begin!");
      localStringBuilder.append(hashCode());
      LogUtil.i(str, localStringBuilder.toString());
      this.mMediaCodec.stop();
      this.mMediaCodec.release();
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label61:
      break label61;
    }
    LogUtil.e(this.TAG, "Failed to stop MediaCodec");
    this.mMediaCodec = null;
  }
  
  private void releaseExtractor()
  {
    MediaExtractor localMediaExtractor = this.mExtractor;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.mExtractor = null;
    }
  }
  
  public int createDecoder(String paramString, Object paramObject)
  {
    int k = -1;
    label620:
    for (;;)
    {
      try
      {
        this.mExtractor = new MediaExtractor();
        this.mExtractor.setDataSource(paramString);
        int i = 0;
        StringBuilder localStringBuilder;
        try
        {
          int m = this.mExtractor.getTrackCount();
          int j = k;
          if (i < m)
          {
            if (!this.mExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
              break label620;
            }
            this.mExtractor.selectTrack(i);
            j = i;
          }
          this.mFormat = this.mExtractor.getTrackFormat(j);
          if (this.mFormat != null) {
            this.mMime = this.mFormat.getString("mime");
          }
          this.mExtractor.selectTrack(j);
          if ((this.mFormat != null) && (this.mMime.startsWith("video/")))
          {
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoFormat(this.mFormat);
            }
            i = this.mFormat.getInteger("width");
            j = this.mFormat.getInteger("height");
            paramString = this.mDecodeListener;
            if (paramString != null) {
              paramString.onVideoSize(i, j);
            }
            try
            {
              this.mMediaCodec = MediaCodec.createDecoderByType(this.mMime);
              paramString = this.TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("mMediaCodec configure begin!");
              localStringBuilder.append(hashCode());
              LogUtil.i(paramString, localStringBuilder.toString());
              this.mMediaCodec.configure(this.mFormat, (Surface)paramObject, null, 0);
              paramString = this.TAG;
              paramObject = new StringBuilder();
              paramObject.append("mMediaCodec start begin!");
              paramObject.append(hashCode());
              LogUtil.i(paramString, paramObject.toString());
              this.mMediaCodec.start();
              this.mInputBuffers = this.mMediaCodec.getInputBuffers();
              this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
              LogUtil.i(this.TAG, "get mMediaCodec mInputBuffers & mOutputBuffers ");
              paramString = this.mDecodeListener;
              if (paramString != null) {
                paramString.onVideoDecoderCreated(true);
              }
              return 1;
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              paramString = this.mDecodeListener;
              if (paramString != null) {
                paramString.onVideoDecodeError(-5);
              }
              if (this.mMediaCodec != null)
              {
                paramString = this.TAG;
                paramObject = new StringBuilder();
                paramObject.append("mMediaCodec release begin!");
                paramObject.append(hashCode());
                LogUtil.i(paramString, paramObject.toString());
                this.mMediaCodec.release();
                this.mMediaCodec = null;
              }
              this.mInputBuffers = null;
              this.mOutputBuffers = null;
              releaseExtractor();
              return -5;
            }
          }
          LogUtil.e(this.TAG, "error: not a video type file, end !");
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-3);
          }
          releaseExtractor();
          return -3;
        }
        catch (Exception paramString)
        {
          paramObject = this.TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("error read video file and info ");
          localStringBuilder.append(paramString.getMessage());
          LogUtil.e(paramObject, localStringBuilder.toString());
          paramString = this.mDecodeListener;
          if (paramString != null) {
            paramString.onVideoDecodeError(-2);
          }
          releaseExtractor();
          return -2;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        paramObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" error mExtractor.setDataSource file path ");
        localStringBuilder.append(paramString.getMessage());
        LogUtil.e(paramObject, localStringBuilder.toString());
        paramString = this.mDecodeListener;
        if (paramString != null) {
          paramString.onVideoDecodeError(-1);
        }
        releaseExtractor();
        return -1;
      }
    }
  }
  
  public void decode()
  {
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    Object localObject1 = this.mDecodeListener;
    if (localObject1 != null) {
      ((IVideoFileDecodeListener)localObject1).onVideoDecodeStart();
    }
    this.mFirstFrameSysTime = 0L;
    this.mFirstFrameTimeUS = 0L;
    for (;;)
    {
      try
      {
        this.mStart = true;
        j = 0;
        i = 0;
        n = 1;
        if (j == 0) {
          if (!this.mStart) {
            LogUtil.i(this.TAG, "decode stop!");
          } else {
            if (i != 0) {
              continue;
            }
          }
        }
      }
      finally
      {
        int j;
        int i;
        int n;
        int i2;
        int k;
        int m;
        Object localObject4;
        StringBuilder localStringBuilder;
        IVideoFileDecodeListener localIVideoFileDecodeListener;
        continue;
        throw localObject3;
        continue;
        int i1 = 0;
        continue;
        continue;
      }
      try
      {
        i2 = this.mMediaCodec.dequeueInputBuffer(1000L);
        if (i2 < 0) {
          continue;
        }
        localObject1 = this.mInputBuffers[i2];
        k = this.mExtractor.readSampleData((ByteBuffer)localObject1, 0);
        if (k < 0)
        {
          LogUtil.d(this.TAG, "saw input EOS. Stopping playback");
          k = 1;
          i = 0;
        }
        else
        {
          localObject1 = this.mExtractor;
        }
      }
      catch (RuntimeException localRuntimeException4)
      {
        continue;
      }
      try
      {
        this.mSamplePresentationTimeUs = ((MediaExtractor)localObject1).getSampleTime();
        m = i;
        i = k;
        k = m;
        m = k;
        try
        {
          localObject1 = this.mMediaCodec;
          m = k;
          long l1 = this.mSamplePresentationTimeUs;
          if (k == 0) {
            continue;
          }
          i1 = 4;
          m = k;
          ((MediaCodec)localObject1).queueInputBuffer(i2, 0, i, l1, i1);
          i = k;
          if (k == 0)
          {
            m = k;
            this.mExtractor.advance();
            i = k;
          }
          k = j;
          m = i;
          i1 = this.mMediaCodec.dequeueOutputBuffer(localBufferInfo, 1000L);
          if (i1 >= 0)
          {
            m = i;
            if (this.mFirstFrameSysTime == 0L)
            {
              m = i;
              this.mFirstFrameSysTime = System.currentTimeMillis();
              m = i;
              this.mFirstFrameTimeUS = localBufferInfo.presentationTimeUs;
            }
            else
            {
              m = i;
              l1 = System.currentTimeMillis() - this.mFirstFrameSysTime;
              m = i;
              long l2 = (localBufferInfo.presentationTimeUs - this.mFirstFrameTimeUS) / 1000L;
              if (l1 < l2)
              {
                m = i;
                try
                {
                  Thread.sleep(l2 - l1);
                }
                catch (InterruptedException localInterruptedException)
                {
                  m = i;
                  localInterruptedException.printStackTrace();
                }
              }
            }
            m = i;
            this.mPresentationTimeUs = localBufferInfo.presentationTimeUs;
            m = i;
            this.mMediaCodec.releaseOutputBuffer(i1, true);
            m = i;
            if (this.mDecodeListener != null)
            {
              m = i;
              this.mDecodeListener.onVideoDecodeFrame(this.mPresentationTimeUs, null);
            }
            m = i;
            if ((localBufferInfo.flags & 0x4) != 0)
            {
              m = i;
              LogUtil.d(this.TAG, "decode output EOS. End");
              m = i;
              boolean bool = this.mLoop;
              if (bool) {
                try
                {
                  this.mFirstFrameSysTime = 0L;
                  this.mFirstFrameTimeUS = 0L;
                  this.mPresentationTimeUs = 0L;
                  this.mExtractor.seekTo(0L, 2);
                  this.mMediaCodec.flush();
                  j = k;
                  i = 0;
                }
                catch (RuntimeException localRuntimeException1)
                {
                  i = 0;
                  continue;
                }
              } else {
                j = 1;
              }
            }
            else
            {
              j = k;
            }
          }
          else
          {
            if (i1 == -3)
            {
              m = i;
              this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
              m = i;
              LogUtil.d(this.TAG, "output buffers have changed.");
            }
            else
            {
              Object localObject2;
              if (i1 == -2)
              {
                m = i;
                localObject2 = this.mMediaCodec.getOutputFormat();
                m = i;
                localObject4 = this.TAG;
                m = i;
                localStringBuilder = new StringBuilder();
                m = i;
                localStringBuilder.append("output mFormat has changed to ");
                m = i;
                localStringBuilder.append(localObject2);
                m = i;
                LogUtil.d((String)localObject4, localStringBuilder.toString());
              }
              else if (i1 == -1)
              {
                m = i;
                LogUtil.d(this.TAG, "dequeueOutputBuffer timed out! MediaCodec.INFO_TRY_AGAIN_LATER ");
              }
              else
              {
                m = i;
                localObject2 = this.TAG;
                m = i;
                localObject4 = new StringBuilder();
                m = i;
                ((StringBuilder)localObject4).append(" dequeueOutputBuffer returned ");
                m = i;
                ((StringBuilder)localObject4).append(i1);
                m = i;
                LogUtil.d((String)localObject2, ((StringBuilder)localObject4).toString());
              }
            }
            j = k;
          }
        }
        catch (RuntimeException localRuntimeException2)
        {
          i = m;
        }
      }
      catch (RuntimeException localRuntimeException3)
      {
        continue;
      }
      localObject4 = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decoding error:");
      localStringBuilder.append(localRuntimeException2.getMessage());
      LogUtil.e((String)localObject4, localStringBuilder.toString());
      localIVideoFileDecodeListener = this.mDecodeListener;
      if (localIVideoFileDecodeListener != null) {
        localIVideoFileDecodeListener.onVideoDecodeError(-101);
      }
      this.mStart = false;
      n = 0;
    }
    if (this.mStart) {
      this.mStart = false;
    }
    releaseCodec();
    releaseExtractor();
    this.mMime = null;
    this.mFormat = null;
    this.mInputBuffers = null;
    this.mOutputBuffers = null;
    this.mSamplePresentationTimeUs = 0L;
    this.mPresentationTimeUs = 0L;
    this.mFirstFrameTimeUS = 0L;
    this.mFirstFrameSysTime = 0L;
    if (n != 0)
    {
      localIVideoFileDecodeListener = this.mDecodeListener;
      if (localIVideoFileDecodeListener != null) {
        localIVideoFileDecodeListener.onVideoDecodeEnd();
      }
    }
  }
  
  public long getCurPresentationTimeUs()
  {
    return this.mPresentationTimeUs;
  }
  
  public IVideoFileDecodeListener getDecodeListener()
  {
    return this.mDecodeListener;
  }
  
  public void release()
  {
    releaseCodec();
    releaseExtractor();
  }
  
  public void setDecodeListener(IVideoFileDecodeListener paramIVideoFileDecodeListener)
  {
    this.mDecodeListener = paramIVideoFileDecodeListener;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
  }
  
  public void stop()
  {
    try
    {
      this.mStart = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.decoder.HardwareFileDecoder
 * JD-Core Version:    0.7.0.1
 */