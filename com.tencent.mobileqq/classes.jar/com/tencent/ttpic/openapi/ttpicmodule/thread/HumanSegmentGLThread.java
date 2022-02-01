package com.tencent.ttpic.openapi.ttpicmodule.thread;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.gles.EglCore;
import com.tencent.ttpic.baseutils.gles.OffscreenSurface;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.baseutils.thread.HandlerThreadManager;
import com.tencent.ttpic.openapi.filter.ExpFilter;
import com.tencent.ttpic.openapi.gles.GLSegSharedData;
import com.tencent.ttpic.openapi.gles.SegmentDataPipe;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.HumanSegmentInitializer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@TargetApi(18)
public class HumanSegmentGLThread
{
  private static final int SEGMENT_HEIGHT = 256;
  private static final int SEGMENT_WIDTH = 256;
  private static final String TAG = "HumanSegmentGLThread";
  private ExpFilter expFilter = new ExpFilter();
  private final String htName = "HumanSegmentGLThread" + System.currentTimeMillis();
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mCopyFrame;
  private EglCore mCore;
  private Handler mHandler = new Handler(HandlerThreadManager.getInstance().getHandlerThread(this.htName).getLooper());
  HumanSegmentInitializer mHumanSegmentInitializer;
  private HumanSegmentGLThread.OnSegDataReadyListener mListener;
  private Bitmap mMaskBitmap;
  private Bitmap mMaskBitmapHorizon;
  private OffscreenSurface mOffscreenSurface;
  private BaseFilter mRotateFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame[] mRotateFrame = new Frame[2];
  private Bitmap mSegBitmap;
  private Bitmap mSegBitmapHorizon;
  private Frame mSegFrame;
  private Frame mTempFrame;
  private int[] mTempTexId = new int[2];
  private GLSegSharedData sharedData;
  
  public HumanSegmentGLThread(EGLContext paramEGLContext, HumanSegmentInitializer paramHumanSegmentInitializer)
  {
    this.mHandler.post(new HumanSegmentGLThread.1(this, paramEGLContext, paramHumanSegmentInitializer));
  }
  
  public void destroy()
  {
    CountDownLatch localCountDownLatch;
    if (this.mHandler != null)
    {
      localCountDownLatch = new CountDownLatch(1);
      this.mHandler.post(new HumanSegmentGLThread.3(this, localCountDownLatch));
    }
    try
    {
      localCountDownLatch.await(HandlerThreadManager.THREAD_DESTROY_TIME_OUT_MILLS, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ReportUtil.report("HumanSegmentGLThread destroy time out!");
    }
  }
  
  public SegmentDataPipe getCurrentDataPipe()
  {
    if (this.sharedData == null) {
      return null;
    }
    return this.sharedData.getCurrentTexturePile();
  }
  
  public boolean needWait()
  {
    if (this.sharedData == null) {
      return true;
    }
    SegmentDataPipe[] arrayOfSegmentDataPipe = this.sharedData.mTexturePile;
    int j = arrayOfSegmentDataPipe.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label55;
      }
      SegmentDataPipe localSegmentDataPipe = arrayOfSegmentDataPipe[i];
      if ((localSegmentDataPipe.isBusy()) || (localSegmentDataPipe.isReady())) {
        break;
      }
      i += 1;
    }
    label55:
    return false;
  }
  
  public void postJob(Runnable paramRunnable)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(paramRunnable);
  }
  
  public void postSegJob(Frame paramFrame, int paramInt1, int paramInt2)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new HumanSegmentGLThread.2(this, paramInt1, paramFrame, paramInt2));
  }
  
  public void reset()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new HumanSegmentGLThread.4(this));
    }
  }
  
  public void setOnDataReadyListener(HumanSegmentGLThread.OnSegDataReadyListener paramOnSegDataReadyListener)
  {
    this.mListener = paramOnSegDataReadyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.thread.HumanSegmentGLThread
 * JD-Core Version:    0.7.0.1
 */