package com.tencent.ttpic.openapi.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.view.RendererUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class ActVideoDecoder
{
  private static final String TAG = "ActVideoDecoder";
  private static final int TIMEOUT_MS = 2500;
  private static final int TIMEOUT_US = 10000;
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private ByteBuffer[] inputBuffers;
  private volatile boolean isDecoding;
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
  private int mRotation;
  private SurfaceTextureFilter mSurfaceTexFilter = new SurfaceTextureFilter();
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
    this.mSurfaceTexFilter.apply();
    this.mSurfaceTexFilter.setRotationAndFlip(0, 0, 1);
    ??? = new HandlerThread(ActVideoDecoder.class.getSimpleName(), 10);
    ???.start();
    this.mHandler = new Handler(???.getLooper());
    this.mHandler.post(new ActVideoDecoder.1(this));
    synchronized (this.mInitLock)
    {
      for (;;)
      {
        boolean bool = this.mInited;
        if (bool) {
          break;
        }
        try
        {
          this.mInitLock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
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
        return;
      }
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private int decodeNext()
  {
    if (this.mDecoder == null)
    {
      if (!AEOpenRenderConfig.DEBUG) {
        return -1;
      }
      throw new RuntimeException("ActVideoDecoder init fail!");
    }
    int k = 0;
    int i = 0;
    do
    {
      for (;;)
      {
        j = k;
        if (Thread.interrupted()) {
          return j;
        }
        BenchUtil.benchStart("[decodeNext] dequeueInputBuffer");
        if (!this.isEOS)
        {
          j = this.mDecoder.dequeueInputBuffer(10000L);
          if (j >= 0)
          {
            localObject = this.inputBuffers[j];
            int m = this.mExtractor.readSampleData((ByteBuffer)localObject, 0);
            if (m < 0)
            {
              LogUtils.d(TAG, "extractor read sample to EOS");
              this.mDecoder.queueInputBuffer(j, 0, 0, 0L, 4);
              this.isEOS = true;
            }
            else
            {
              this.mDecoder.queueInputBuffer(j, 0, m, this.mExtractor.getSampleTime(), 0);
              this.mExtractor.advance();
            }
          }
        }
        BenchUtil.benchEnd("[decodeNext] dequeueInputBuffer");
        BenchUtil.benchStart("[decodeNext] wait");
        j = this.mDecoder.dequeueOutputBuffer(this.info, 10000L);
        BenchUtil.benchEnd("[decodeNext] wait");
        if ((this.info.flags & 0x4) != 0) {
          return 0;
        }
        if ((j != -3) && (j != -2))
        {
          if (j == -1) {
            break;
          }
          this.mCurFrameIndex += 1L;
          if (this.mCurFrameIndex == this.mLastFrameIndex)
          {
            this.mHasNewFrame = true;
            this.mDecoder.releaseOutputBuffer(j, true);
            return 0;
          }
          this.mDecoder.releaseOutputBuffer(j, false);
        }
      }
      j = i + 1;
      i = j;
    } while (j <= 10);
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dequeueOutputBuffer timed out! eos = ");
    localStringBuilder.append(this.isEOS);
    LogUtils.e((String)localObject, localStringBuilder.toString());
    int j = -1;
    return j;
  }
  
  private void prepare()
  {
    int i = 0;
    while (i < this.mExtractor.getTrackCount())
    {
      localObject = this.mExtractor.getTrackFormat(i);
      String str1 = ((MediaFormat)localObject).getString("mime");
      if (str1.startsWith("video/"))
      {
        this.mExtractor.selectTrack(i);
        LogUtils.d(TAG, "extractor video track selected");
        this.mWidth = ((MediaFormat)localObject).getInteger("width");
        this.mHeight = ((MediaFormat)localObject).getInteger("height");
        i = this.mRotation;
        if ((i == 90) || (i == 270))
        {
          i = this.mWidth;
          this.mWidth = this.mHeight;
          this.mHeight = i;
        }
        this.mDuration = (((MediaFormat)localObject).getLong("durationUs") / 1000L);
        String str2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("width = ");
        localStringBuilder.append(this.mWidth);
        localStringBuilder.append(", height = ");
        localStringBuilder.append(this.mHeight);
        localStringBuilder.append(", mDuration = ");
        localStringBuilder.append(this.mDuration);
        LogUtils.d(str2, localStringBuilder.toString());
        this.mDecoder = MediaCodec.createDecoderByType(str1);
        ((MediaFormat)localObject).setInteger("max-input-size", 0);
        this.mDecoder.configure((MediaFormat)localObject, this.mDecoderSurface, null, 0);
        break;
      }
      i += 1;
    }
    Object localObject = this.mDecoder;
    if (localObject == null)
    {
      LogUtils.e(TAG, "Can't find video info!");
      return;
    }
    try
    {
      ((MediaCodec)localObject).start();
      this.inputBuffers = this.mDecoder.getInputBuffers();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.isEOS = false;
  }
  
  private static void setExtractorDataSource(MediaExtractor paramMediaExtractor, String paramString)
  {
    if (paramString.startsWith("assets://"))
    {
      paramString = paramString.substring(9);
      paramString = AEModule.getContext().getAssets().openFd(paramString);
      paramMediaExtractor.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      paramString.close();
      return;
    }
    paramMediaExtractor.setDataSource(paramString);
  }
  
  public void decodeFrame(long paramLong)
  {
    if (this.mDecoderSurface != null)
    {
      if (paramLong <= this.mLastFrameIndex) {
        return;
      }
      this.mLastFrameIndex = paramLong;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG);
        localStringBuilder.append("[decodeNext]");
        BenchUtil.benchStart(localStringBuilder.toString());
        decodeNext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG);
        localStringBuilder.append("[decodeNext]");
        BenchUtil.benchEnd(localStringBuilder.toString());
        return;
      }
      catch (Exception localException)
      {
        LogUtils.e(TAG, "decodeNext error: ", localException, new Object[0]);
        return;
      }
    }
    throw new RuntimeException("You haven't set surfaceTexture?!");
  }
  
  public void decodeFrameAsync(long paramLong)
  {
    if (this.mDecoderSurface != null)
    {
      if (!this.isDecoding)
      {
        if (paramLong <= this.mLastFrameIndex) {
          return;
        }
        this.isDecoding = true;
        this.mLastFrameIndex = paramLong;
        this.mHandler.post(new ActVideoDecoder.2(this));
      }
      return;
    }
    throw new RuntimeException("You haven't set surfaceTexture?!");
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public Frame getFrame()
  {
    return this.mFrame;
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
    Object localObject = this.mDecoderSurface;
    if (localObject != null) {
      ((Surface)localObject).release();
    }
    localObject = this.mExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).release();
    }
    localObject = this.mDecoder;
    if (localObject != null) {}
    try
    {
      ((MediaCodec)localObject).stop();
      this.mDecoder.release();
      LogUtils.i(TAG, "mDecoder stop and release");
      this.mDecoder = null;
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    this.mDecoder = null;
    localObject = this.mHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.mHandler.post(new ActVideoDecoder.4(this));
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.mExtractor != null) {
        this.mExtractor.seekTo(0L, 0);
      }
      if (this.mDecoder != null) {
        this.mDecoder.flush();
      }
    }
    catch (Exception localException)
    {
      if (!TextUtils.isEmpty(localException.getMessage())) {
        LogUtils.d(TAG, localException.getMessage());
      }
    }
    this.isEOS = false;
    this.mCurFrameIndex = -1L;
    this.mLastFrameIndex = -1L;
  }
  
  public void resetAsync()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.post(new ActVideoDecoder.3(this));
    }
  }
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
    if ((paramInt == 90) || (paramInt == 270))
    {
      paramInt = this.mWidth;
      this.mWidth = this.mHeight;
      this.mHeight = paramInt;
    }
  }
  
  public boolean updateFrame()
  {
    boolean bool1 = this.mHasNewFrame;
    if (bool1)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(TAG);
      ((StringBuilder)???).append("[updateFrame] wait");
      BenchUtil.benchStart(((StringBuilder)???).toString());
      synchronized (this.mUpdateFrameLock)
      {
        for (;;)
        {
          boolean bool2 = this.mFrameAvailable;
          if (!bool2) {
            try
            {
              this.mUpdateFrameLock.wait(2500L);
              if (!this.mFrameAvailable)
              {
                LogUtils.e(TAG, "frame wait timed out");
                return false;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new RuntimeException(localInterruptedException);
            }
          }
        }
        this.mFrameAvailable = false;
        ??? = new StringBuilder();
        ((StringBuilder)???).append(TAG);
        ((StringBuilder)???).append("[updateFrame] wait");
        BenchUtil.benchEnd(((StringBuilder)???).toString());
        ??? = new StringBuilder();
        ((StringBuilder)???).append(TAG);
        ((StringBuilder)???).append("[updateFrame] render");
        BenchUtil.benchStart(((StringBuilder)???).toString());
      }
    }
    try
    {
      this.mSurfaceTexture.updateTexImage();
      label175:
      this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.updateMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.RenderProcess(this.mTempTex, getWidth(), getHeight(), this.mDstTex, 0.0D, this.mFrame);
      this.mHasNewFrame = false;
      ??? = new StringBuilder();
      ((StringBuilder)???).append(TAG);
      ((StringBuilder)???).append("[updateFrame] render");
      BenchUtil.benchEnd(((StringBuilder)???).toString());
      return bool1;
      localObject2 = finally;
      throw localObject2;
      return bool1;
    }
    catch (Exception localException)
    {
      break label175;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder
 * JD-Core Version:    0.7.0.1
 */