package com.tencent.ttpic.openapi.recorder;

import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.WindowSurface;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.baseutils.thread.HandlerThreadTag;
import com.tencent.ttpic.recorder.MyRecorder;
import com.tencent.ttpic.util.HandlerUtil;

@TargetApi(18)
public class RenderSrfTex
{
  private static final String TAG = RenderSrfTex.class.getSimpleName();
  private int[] alterWidths;
  private Handler handler;
  private double mAspectRatio = 0.0D;
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame = new Frame();
  private EglCore mCore;
  private int mFboTexH;
  private int mFboTexW;
  private int mFrameCount;
  private HandlerThread mGlThread;
  private boolean mIgnoreWatermark;
  private WindowSurface mInputSurface;
  private long mRecordStartTime = -1L;
  private final MyRecorder mRecorder;
  private long mSampleTimeMs = -1L;
  private RenderSrfTex.ProcessMode processMode;
  
  public RenderSrfTex(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    this.mRecorder = new MyRecorder(paramString);
    this.mFboTexW = Math.max(paramInt1, 1);
    this.mFboTexH = Math.max(paramInt2, 1);
    if ((paramInt3 == 90) || (paramInt3 == 270))
    {
      paramInt1 = this.mFboTexW;
      this.mFboTexW = this.mFboTexH;
      this.mFboTexH = paramInt1;
    }
    this.alterWidths = new int[0];
    this.mIgnoreWatermark = paramBoolean;
    this.processMode = RenderSrfTex.ProcessMode.ASYNC;
  }
  
  private void initGL()
  {
    GlUtil.checkGlError("initGL_S");
    LogUtils.d(TAG, "[record] mCopyFilter.applyFilterChain() begin");
    this.mCopyFilter.apply();
    LogUtils.d(TAG, "[record] mCopyFilter.applyFilterChain() end");
    LogUtils.d(TAG, "[record] setRotationAndFlip begin");
    this.mCopyFilter.setRotationAndFlip(0, 0, 1);
    LogUtils.d(TAG, "[record] setRotationAndFlip end");
    GlUtil.checkGlError("initGL_E");
  }
  
  public void draw(int paramInt)
  {
    draw(paramInt, System.nanoTime());
  }
  
  public void draw(int paramInt, long paramLong)
  {
    if (paramInt < 0) {
      return;
    }
    queue(new RenderSrfTex.1(this, paramInt, paramLong));
  }
  
  public int getFrameCount()
  {
    return this.mFrameCount;
  }
  
  public int getHeight()
  {
    return this.mFboTexH;
  }
  
  public int getWidth()
  {
    return this.mFboTexW;
  }
  
  public boolean ignoreWatermark()
  {
    return this.mIgnoreWatermark;
  }
  
  public void initGlThread(EGLContext paramEGLContext)
  {
    paramEGLContext = new RenderSrfTex.2(this, paramEGLContext);
    if (this.mGlThread != null) {
      LogUtils.e(TAG, "[record] mGlThread != null");
    }
    if (this.mGlThread == null)
    {
      this.mGlThread = HandlerThreadManager.getInstance().getHandlerThread(HandlerThreadTag.CAMERA_VIDEO_SAVE);
      this.handler = new Handler(this.mGlThread.getLooper());
      this.handler.post(paramEGLContext);
    }
  }
  
  public boolean prepare()
  {
    int k = this.mFboTexH;
    int j = this.mFboTexW;
    float f = k / j;
    int i = 0;
    boolean bool;
    for (;;)
    {
      bool = this.mRecorder.prepareEncoder(j, k);
      if ((bool) || (i >= this.alterWidths.length)) {
        break;
      }
      if (j > k)
      {
        k = this.alterWidths[i];
        j = (int)(k / f);
        i += 1;
      }
      else
      {
        j = this.alterWidths[i];
        k = (int)(j * f);
        i += 1;
      }
    }
    this.mFboTexW = Math.max(j, 1);
    this.mFboTexH = Math.max(k, 1);
    return bool;
  }
  
  public void queue(Runnable paramRunnable)
  {
    if (this.handler != null) {
      this.handler.post(paramRunnable);
    }
    if (this.processMode == RenderSrfTex.ProcessMode.SYNC) {
      HandlerUtil.waitDone(this.handler);
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
  
  public void setProcessMode(RenderSrfTex.ProcessMode paramProcessMode)
  {
    this.processMode = paramProcessMode;
  }
  
  public void setSampleTime(long paramLong)
  {
    this.mSampleTimeMs = paramLong;
  }
  
  public void stop(VideoRecorderListener paramVideoRecorderListener)
  {
    queue(new RenderSrfTex.3(this, paramVideoRecorderListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.RenderSrfTex
 * JD-Core Version:    0.7.0.1
 */