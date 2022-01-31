package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.gles.EglCore;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.WindowSurface;
import com.tencent.ttpic.util.FrameRateUtil;

@TargetApi(18)
public class RenderSrfTex
{
  private static final String TAG = RenderSrfTex.class.getSimpleName();
  private int[] alterWidths;
  private Handler handler;
  private double mAspectRatio = 0.0D;
  private BaseFilter mCopyFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
  private Frame mCopyFrame = new Frame();
  private EglCore mCore;
  private int mFboTexH;
  private int mFboTexW;
  private HandlerThread mGlThread;
  private WindowSurface mInputSurface;
  private final MyRecorder mRecorder;
  private long mSampleTimeMs = -1L;
  
  public RenderSrfTex(int paramInt1, int paramInt2, Camera.Parameters paramParameters, String paramString, int paramInt3)
  {
    this.mRecorder = new MyRecorder(paramParameters, paramString);
    this.mFboTexW = Math.max(paramInt1, 1);
    this.mFboTexH = Math.max(paramInt2, 1);
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      paramInt1 = this.mFboTexW;
      this.mFboTexW = this.mFboTexH;
      this.mFboTexH = paramInt1;
    }
    this.alterWidths = new int[0];
  }
  
  private void initGL()
  {
    GlUtil.checkGlError("initGL_S");
    Log.d(TAG, "[record] mCopyFilter.ApplyGLSLFilter() begin");
    this.mCopyFilter.ApplyGLSLFilter();
    Log.d(TAG, "[record] mCopyFilter.ApplyGLSLFilter() end");
    Log.d(TAG, "[record] nativeSetRotationAndFlip begin");
    this.mCopyFilter.nativeSetRotationAndFlip(0, 0, 1);
    Log.d(TAG, "[record] nativeSetRotationAndFlip end");
    GlUtil.checkGlError("initGL_E");
  }
  
  public void draw(final int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    queue(new Runnable()
    {
      public void run()
      {
        if (FrameRateUtil.mRecordStartTime == -1L)
        {
          FrameRateUtil.mRecordStartTime = System.currentTimeMillis();
          FrameRateUtil.mFrameCount = 0;
        }
        if ((RenderSrfTex.this.mSampleTimeMs > 0L) && (System.currentTimeMillis() - FrameRateUtil.mRecordStartTime < FrameRateUtil.mFrameCount * RenderSrfTex.this.mSampleTimeMs)) {
          return;
        }
        FrameRateUtil.mFrameCount += 1;
        RenderSrfTex.this.mCopyFilter.RenderProcess(paramInt, RenderSrfTex.this.mFboTexW, RenderSrfTex.this.mFboTexH, 0, RenderSrfTex.this.mAspectRatio, RenderSrfTex.this.mCopyFrame);
        if (RenderSrfTex.this.mInputSurface != null)
        {
          RenderSrfTex.this.mInputSurface.swapBuffers();
          RenderSrfTex.this.mInputSurface.setPresentationTime(System.nanoTime());
        }
        RenderSrfTex.this.mRecorder.swapBuffers();
        GlUtil.checkGlError("draw_E");
      }
    });
  }
  
  public int getHeight()
  {
    return this.mFboTexH;
  }
  
  public int getWidth()
  {
    return this.mFboTexW;
  }
  
  public void initGlThread(final EGLContext paramEGLContext)
  {
    paramEGLContext = new Runnable()
    {
      public void run()
      {
        Log.d(RenderSrfTex.TAG, "[record] mRecorder.getInputSurface() begin");
        Surface localSurface = RenderSrfTex.this.mRecorder.getInputSurface();
        Log.d(RenderSrfTex.TAG, "[record] mRecorder.getInputSurface() end");
        if (localSurface == null)
        {
          RenderSrfTex.access$602(RenderSrfTex.this, null);
          Log.e(RenderSrfTex.TAG, "[record] mInputSurface = null!");
          return;
        }
        Log.d(RenderSrfTex.TAG, "[record] new InputSurface begin");
        RenderSrfTex.access$902(RenderSrfTex.this, new EglCore(paramEGLContext, 0));
        RenderSrfTex.access$602(RenderSrfTex.this, new WindowSurface(RenderSrfTex.this.mCore, RenderSrfTex.this.mRecorder.getInputSurface(), true));
        Log.d(RenderSrfTex.TAG, "[record] new InputSurface end");
        Log.d(RenderSrfTex.TAG, "[record] makeCurrent begin");
        RenderSrfTex.this.mInputSurface.makeCurrent();
        Log.d(RenderSrfTex.TAG, "[record] makeCurrent end");
        Log.d(RenderSrfTex.TAG, "[record] initGL begin");
        RenderSrfTex.this.initGL();
        Log.d(RenderSrfTex.TAG, "[record] initGL end");
        try
        {
          Log.d(RenderSrfTex.TAG, "[record] mRecorder.start() begin");
          RenderSrfTex.this.mRecorder.start();
          Log.d(RenderSrfTex.TAG, "[record] mRecorder.start() end");
          Log.d(RenderSrfTex.TAG, "[record] initGlThread");
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e(RenderSrfTex.TAG, "[record] mRecorder.start() exception!");
            RenderSrfTex.this.mRecorder.releaseEncoder();
            localException.printStackTrace();
          }
        }
      }
    };
    if (this.mGlThread != null) {
      Log.e(TAG, "[record] mGlThread != null");
    }
    if (this.mGlThread == null)
    {
      this.mGlThread = new HandlerThread("VideoGlThread");
      this.mGlThread.start();
      this.handler = new Handler(this.mGlThread.getLooper());
      this.handler.post(paramEGLContext);
    }
  }
  
  public boolean prepare()
  {
    int j = this.mFboTexH;
    int k = this.mFboTexW;
    float f = j / k;
    int i = 0;
    boolean bool;
    for (;;)
    {
      bool = this.mRecorder.prepareEncoder(k, j);
      if ((bool) || (i >= this.alterWidths.length)) {
        break;
      }
      if (k > j)
      {
        j = this.alterWidths[i];
        k = (int)(j / f);
        i += 1;
      }
      else
      {
        k = this.alterWidths[i];
        j = (int)(k * f);
        i += 1;
      }
    }
    this.mFboTexW = Math.max(k, 1);
    this.mFboTexH = Math.max(j, 1);
    return bool;
  }
  
  public void queue(Runnable paramRunnable)
  {
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
  }
  
  public void setAlternativeWidth(int[] paramArrayOfInt)
  {
    this.alterWidths = paramArrayOfInt;
  }
  
  public void setPlayRate(float paramFloat)
  {
    if (this.mRecorder != null) {
      this.mRecorder.setPlayRate(paramFloat);
    }
  }
  
  public void setSampleTime(long paramLong)
  {
    this.mSampleTimeMs = paramLong;
  }
  
  public void stop(final RecorderListener paramRecorderListener)
  {
    queue(new Runnable()
    {
      public void run()
      {
        if (RenderSrfTex.this.mRecorder != null) {
          RenderSrfTex.this.mRecorder.stop();
        }
        if (RenderSrfTex.this.mInputSurface != null) {
          RenderSrfTex.this.mInputSurface.release();
        }
        if (RenderSrfTex.this.mCore != null) {
          RenderSrfTex.this.mCore.release();
        }
        RenderSrfTex.this.mCopyFilter.clearGLSLSelf();
        RenderSrfTex.this.mCopyFrame.clear();
        if ((paramRecorderListener != null) && (RenderSrfTex.this.mRecorder != null)) {
          paramRecorderListener.onRecordFinish(RenderSrfTex.this.mRecorder.getOutputPath());
        }
        if (RenderSrfTex.this.mGlThread != null)
        {
          RenderSrfTex.this.mGlThread.quit();
          RenderSrfTex.access$1102(RenderSrfTex.this, null);
        }
        if (RenderSrfTex.this.handler != null) {
          RenderSrfTex.access$1202(RenderSrfTex.this, null);
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.recorder.RenderSrfTex
 * JD-Core Version:    0.7.0.1
 */