package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import com.tencent.filter.Frame;
import com.tencent.filter.SurfaceTextrueFilter;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.LogUtil;
import com.tencent.view.RendererUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class ActVideoDecoder
{
  private static final String TAG = ActVideoDecoder.class.getSimpleName();
  private static final int TIMEOUT_MS = 2500;
  private static final int TIMEOUT_US = 10000;
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private ByteBuffer[] inputBuffers;
  private boolean isEOS = false;
  private long mCurFrameIndex = -1L;
  private MediaCodec mDecoder;
  private Surface mDecoderSurface;
  private int mDstTex;
  private long mDuration;
  private MediaExtractor mExtractor;
  private String mFilename;
  private Frame mFrame = new Frame();
  private boolean mFrameAvailable;
  private Handler mHandler;
  private boolean mHasNewFrame;
  private int mHeight;
  private final Object mInitLock = new Object();
  private boolean mInited;
  private long mLastFrameIndex = -1L;
  private SurfaceTextrueFilter mSurfaceTexFilter = new SurfaceTextrueFilter();
  private SurfaceTexture mSurfaceTexture;
  private int mTempTex;
  private final float[] mTransformMatrix = new float[16];
  private final Object mUpdateFrameLock = new Object();
  private int mWidth;
  
  public ActVideoDecoder(String arg1, int paramInt)
  {
    this.mFilename = ???;
    this.mDstTex = paramInt;
    this.mTempTex = RendererUtils.createTexture();
    this.mSurfaceTexFilter.ApplyGLSLFilter();
    this.mSurfaceTexFilter.nativeSetRotationAndFlip(0, 0, 1);
    ??? = new HandlerThread("ActVideoDecoder rt");
    ???.start();
    this.mHandler = new Handler(???.getLooper());
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        ActVideoDecoder.access$002(ActVideoDecoder.this, new SurfaceTexture(ActVideoDecoder.this.mTempTex));
        ActVideoDecoder.this.mSurfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener()
        {
          public void onFrameAvailable(SurfaceTexture arg1)
          {
            synchronized (ActVideoDecoder.this.mUpdateFrameLock)
            {
              if (ActVideoDecoder.this.mFrameAvailable) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
              }
            }
            ActVideoDecoder.access$302(ActVideoDecoder.this, true);
            ActVideoDecoder.this.mUpdateFrameLock.notifyAll();
          }
        });
        synchronized (ActVideoDecoder.this.mInitLock)
        {
          ActVideoDecoder.this.mInitLock.notifyAll();
          ActVideoDecoder.access$502(ActVideoDecoder.this, true);
          return;
        }
      }
    });
    synchronized (this.mInitLock)
    {
      for (;;)
      {
        boolean bool = this.mInited;
        if (!bool) {
          try
          {
            this.mInitLock.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    this.mDecoderSurface = new Surface(this.mSurfaceTexture);
    this.mExtractor = new MediaExtractor();
    try
    {
      setExtractorDataSource(this.mExtractor, this.mFilename);
      prepare();
      return;
    }
    catch (IOException ???)
    {
      ???.printStackTrace();
    }
  }
  
  private int decodeNext()
  {
    int k = 0;
    int i = 0;
    if (this.mDecoder == null)
    {
      Log.e("ActVideoDecoder", "init failed!");
      return -1;
      this.mDecoder.releaseOutputBuffer(j, false);
    }
    label30:
    int j = k;
    int m;
    if (!Thread.interrupted())
    {
      BenchUtil.benchStart("[decodeNext] dequeueInputBuffer");
      if (!this.isEOS)
      {
        j = this.mDecoder.dequeueInputBuffer(10000L);
        if (j >= 0)
        {
          ByteBuffer localByteBuffer = this.inputBuffers[j];
          m = this.mExtractor.readSampleData(localByteBuffer, 0);
          Log.d(TAG, "[decodeNext]");
          if (m >= 0) {
            break label175;
          }
          LogUtil.d(TAG, "extractor read sample to EOS");
          this.mDecoder.queueInputBuffer(j, 0, 0, 0L, 4);
          this.isEOS = true;
        }
      }
      label125:
      BenchUtil.benchEnd("[decodeNext] dequeueInputBuffer");
      BenchUtil.benchStart("[decodeNext] wait");
      j = this.mDecoder.dequeueOutputBuffer(this.info, 10000L);
      BenchUtil.benchEnd("[decodeNext] wait");
      if ((this.info.flags & 0x4) == 0) {
        break label205;
      }
      j = k;
    }
    for (;;)
    {
      return j;
      label175:
      this.mDecoder.queueInputBuffer(j, 0, m, this.mExtractor.getSampleTime(), 0);
      this.mExtractor.advance();
      break label125;
      switch (j)
      {
      case -3: 
      case -2: 
      default: 
        this.mCurFrameIndex += 1L;
        if (this.mCurFrameIndex != this.mLastFrameIndex) {
          break;
        }
        this.mHasNewFrame = true;
        this.mDecoder.releaseOutputBuffer(j, true);
        j = k;
        break;
      case -1: 
        label205:
        j = i + 1;
        i = j;
        if (j <= 10) {
          break label30;
        }
        LogUtil.e(TAG, "dequeueOutputBuffer timed out! eos = " + this.isEOS);
        j = -1;
      }
    }
  }
  
  private void prepare()
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mExtractor.getTrackCount())
      {
        MediaFormat localMediaFormat = this.mExtractor.getTrackFormat(i);
        String str = localMediaFormat.getString("mime");
        if (str.startsWith("video/"))
        {
          this.mExtractor.selectTrack(i);
          LogUtil.d(TAG, "extractor video track selected");
          this.mWidth = localMediaFormat.getInteger("width");
          this.mHeight = localMediaFormat.getInteger("height");
          this.mDuration = (localMediaFormat.getLong("durationUs") / 1000L);
          LogUtil.d(TAG, "width = " + this.mWidth + ", height = " + this.mHeight + ", mDuration = " + this.mDuration);
          this.mDecoder = MediaCodec.createDecoderByType(str);
          localMediaFormat.setInteger("max-input-size", 0);
          this.mDecoder.configure(localMediaFormat, this.mDecoderSurface, null, 0);
        }
      }
      else
      {
        if (this.mDecoder != null) {
          break;
        }
        LogUtil.e(TAG, "Can't find video info!");
        return;
      }
      i += 1;
    }
    this.mDecoder.start();
    this.inputBuffers = this.mDecoder.getInputBuffers();
    this.isEOS = false;
  }
  
  private static void setExtractorDataSource(MediaExtractor paramMediaExtractor, String paramString)
    throws IOException
  {
    if (paramString.startsWith("assets://"))
    {
      paramString = paramString.substring("assets://".length());
      paramString = VideoGlobalContext.getContext().getAssets().openFd(paramString);
      paramMediaExtractor.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      paramString.close();
      return;
    }
    paramMediaExtractor.setDataSource(paramString);
  }
  
  public void decodeFrame(long paramLong)
  {
    if (this.mDecoderSurface == null) {
      throw new RuntimeException("You haven't set surfaceTexture?!");
    }
    if (paramLong == this.mLastFrameIndex) {
      return;
    }
    this.mLastFrameIndex = paramLong;
    try
    {
      BenchUtil.benchStart(TAG + "[decodeNext]");
      decodeNext();
      BenchUtil.benchEnd(TAG + "[decodeNext]");
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, "decodeNext error: ", localException);
    }
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isLive()
  {
    return this.mDecoder != null;
  }
  
  public void release()
  {
    RendererUtils.clearTexture(this.mTempTex);
    this.mSurfaceTexFilter.clearGLSLSelf();
    this.mFrame.clear();
    if (this.mDecoderSurface != null) {
      this.mDecoderSurface.release();
    }
    if (this.mExtractor != null) {
      this.mExtractor.release();
    }
    if (this.mDecoder != null) {}
    try
    {
      this.mDecoder.stop();
      this.mDecoder.release();
      LogUtil.i(TAG, "mDecoder stop and release");
      this.mDecoder = null;
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (ActVideoDecoder.this.mSurfaceTexture != null) {
              ActVideoDecoder.this.mSurfaceTexture.release();
            }
            ActVideoDecoder.this.mHandler.getLooper().quit();
            ActVideoDecoder.access$602(ActVideoDecoder.this, null);
          }
        });
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mDecoder = null;
      }
    }
  }
  
  public void reset()
  {
    if (this.mExtractor != null) {}
    try
    {
      this.mExtractor.seekTo(0L, 0);
      if (this.mDecoder == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.mDecoder.flush();
        this.isEOS = false;
        this.mCurFrameIndex = -1L;
        this.mLastFrameIndex = -1L;
        return;
        localException1 = localException1;
        Log.e("ActVideoDecoder", "reset exception!");
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("ActVideoDecoder", "reset mDecoder exception!");
        }
      }
    }
  }
  
  public void updateFrame()
  {
    if (this.mHasNewFrame)
    {
      BenchUtil.benchStart(TAG + "[updateFrame] wait");
      synchronized (this.mUpdateFrameLock)
      {
        for (;;)
        {
          boolean bool = this.mFrameAvailable;
          if (!bool) {
            try
            {
              this.mUpdateFrameLock.wait(2500L);
              if (!this.mFrameAvailable) {
                throw new RuntimeException("frame wait timed out");
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new RuntimeException(localInterruptedException);
            }
          }
        }
      }
      this.mFrameAvailable = false;
      BenchUtil.benchEnd(TAG + "[updateFrame] wait");
      BenchUtil.benchStart(TAG + "[updateFrame] render");
      this.mSurfaceTexture.updateTexImage();
      this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.nativeUpdateMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.RenderProcess(this.mTempTex, getWidth(), getHeight(), this.mDstTex, 0.0D, this.mFrame);
      this.mHasNewFrame = false;
      BenchUtil.benchEnd(TAG + "[updateFrame] render");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder
 * JD-Core Version:    0.7.0.1
 */