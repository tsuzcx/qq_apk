package com.tencent.mobileqq.triton.render;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback2;
import android.view.SurfaceView;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.utils.ThreadUtil;
import com.tencent.mobileqq.triton.touch.TouchEventManager;

public class TritonSurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback2, RenderContext.IFixedSizeListener
{
  private static final String TAG = "TritonSurfaceView";
  private RenderContext mRenderContext;
  private TouchEventManager mTouchEventManager;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public TritonSurfaceView(Context paramContext, RenderContext paramRenderContext, TouchEventManager paramTouchEventManager)
  {
    super(paramContext);
    this.mTouchEventManager = paramTouchEventManager;
    this.mRenderContext = paramRenderContext;
    this.mRenderContext.setFixedSizeListener(this);
    getHolder().addCallback(this);
    getHolder().setFixedSize((int)(this.mRenderContext.getScreenWidth() / this.mRenderContext.getScreenScale()), (int)(this.mRenderContext.getScreenHeight() / this.mRenderContext.getScreenScale()));
  }
  
  public void onFixedSize(int paramInt1, int paramInt2)
  {
    if (ThreadUtil.isMainThread())
    {
      TTLog.i("TritonSurfaceView", "setFixedSize canvasWidth=" + paramInt1 + ", canvasHeight=" + paramInt2);
      getHolder().setFixedSize(paramInt1, paramInt2);
    }
    while (this.mUIHandler == null) {
      return;
    }
    this.mUIHandler.post(new TritonSurfaceView.1(this, paramInt1, paramInt2));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = this.mRenderContext.getScreenWidth();
    int j = this.mRenderContext.getScreenHeight();
    int k = this.mRenderContext.getCanvasWidth();
    int m = this.mRenderContext.getCanvasHeight();
    if ((m == 0) || (k == 0))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if ((k == i) && (j == m))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    float f1 = i * 1.0F / j;
    float f2 = k * 1.0F / m;
    if (f2 > f1)
    {
      paramInt2 = (int)(j * f2);
      paramInt1 = j;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = (int)(i / f2);
      paramInt2 = i;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mTouchEventManager.onTouchEvent(paramMotionEvent);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mRenderContext.surfaceChanged(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mRenderContext.initRenderContext(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mRenderContext.destroyRenderContext();
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.render.TritonSurfaceView
 * JD-Core Version:    0.7.0.1
 */