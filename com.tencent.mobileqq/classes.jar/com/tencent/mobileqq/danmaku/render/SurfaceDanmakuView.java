package com.tencent.mobileqq.danmaku.render;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.danmaku.DanmakuDependImp;
import com.tencent.mobileqq.danmaku.IDanmakuDepend;
import com.tencent.mobileqq.danmaku.inject.VideoDanmakuConfig;
import com.tencent.mobileqq.danmaku.util.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceDanmakuView
  implements SurfaceHolder.Callback, IDanmakuView
{
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private SurfaceView jdField_a_of_type_AndroidViewSurfaceView;
  private IDanmakuView.CallBack jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack;
  private volatile Object jdField_a_of_type_JavaLangObject;
  private volatile ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile Object jdField_b_of_type_JavaLangObject;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public SurfaceDanmakuView(SurfaceView paramSurfaceView)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView = paramSurfaceView;
    this.jdField_a_of_type_AndroidViewSurfaceView.setWillNotCacheDrawing(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setDrawingCacheEnabled(false);
    this.jdField_a_of_type_AndroidViewSurfaceView.setWillNotDraw(true);
    this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setFormat(-2);
  }
  
  private boolean a()
  {
    c();
    return (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock != null) && (this.jdField_a_of_type_JavaLangObject != null) && (this.jdField_b_of_type_JavaLangObject != null);
  }
  
  private Canvas b()
  {
    Object localObject2;
    if (DanmakuDependImp.a().a().b())
    {
      localObject2 = this.jdField_a_of_type_AndroidViewSurfaceHolder.lockHardwareCanvas();
      return localObject2;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    e();
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangObject != null)) {}
    for (;;)
    {
      try
      {
        Canvas localCanvas = this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().lockHardwareCanvas();
        localObject2 = localCanvas;
        if (localCanvas != null) {
          break;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
        return null;
      }
      catch (Exception localException)
      {
        Logger.a("SurfaceDanmakuView", "Exception locking surface", localException);
      }
      Object localObject1 = null;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (DanmakuDependImp.a().a().b()) {
      this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramCanvas);
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().unlockCanvasAndPost(paramCanvas);
    } while (this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock == null);
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
  }
  
  private boolean b()
  {
    return (VideoDanmakuConfig.a()) && (((Build.VERSION.SDK_INT == 23) && (a())) || (DanmakuDependImp.a().a().b()));
  }
  
  private void c()
  {
    d();
    e();
  }
  
  private void d()
  {
    Object localObject = DanmakuDependImp.a().a().a(SurfaceView.class, "mSurfaceLock", this.jdField_a_of_type_AndroidViewSurfaceView);
    if ((localObject instanceof ReentrantLock)) {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = ((ReentrantLock)localObject);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaLangObject = DanmakuDependImp.a().a().a(SurfaceView.class, "mDrawingStopped", this.jdField_a_of_type_AndroidViewSurfaceView);
    this.jdField_b_of_type_JavaLangObject = DanmakuDependImp.a().a().a(SurfaceView.class, "mWindow", this.jdField_a_of_type_AndroidViewSurfaceView);
    if ((this.jdField_a_of_type_JavaLangObject instanceof Boolean)) {
      this.jdField_a_of_type_Boolean = ((Boolean)this.jdField_a_of_type_JavaLangObject).booleanValue();
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidViewSurfaceView.getY();
  }
  
  public Canvas a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return b();
    }
    return this.jdField_a_of_type_AndroidViewSurfaceHolder.lockCanvas();
  }
  
  public void a()
  {
    ReentrantLock localReentrantLock = (ReentrantLock)DanmakuDependImp.a().a().a(SurfaceView.class, "mSurfaceLock", this.jdField_a_of_type_AndroidViewSurfaceView);
    Surface localSurface = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder().getSurface();
    try
    {
      Method localMethod = Surface.class.getDeclaredMethod("nativeRelease", new Class[] { Long.TYPE });
      localMethod.setAccessible(true);
      Field localField = Surface.class.getDeclaredField("mLockedObject");
      localField.setAccessible(true);
      Long localLong = (Long)localField.get(localSurface);
      Logger.c("surface_lock", "SurfaceDanmakuView unlock lockObjectValue = " + localLong);
      if (localLong.longValue() != 0L) {
        localMethod.invoke(null, new Object[] { localLong });
      }
      localField.setLong(localSurface, 0L);
      Logger.b("surface_lock", "SurfaceDanmakuView unlock: release success");
      return;
    }
    catch (Exception localException)
    {
      Logger.a("surface_lock", "SurfaceDanmakuView unlock:release failed", localException);
      return;
    }
    finally
    {
      Logger.c("surface_lock", "SurfaceDanmakuView unlock surfaceLock = " + localReentrantLock);
      if ((localReentrantLock != null) && (localReentrantLock.isLocked()))
      {
        Logger.c("surface_lock", "SurfaceDanmakuView unlock");
        localReentrantLock.unlock();
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramCanvas);
      return;
    }
    this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewSurfaceView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IDanmakuView.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack = paramCallBack;
  }
  
  public void b() {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack.j();
    }
    Logger.c("SurfaceDanmakuView", "surfaceChanged, width = " + paramInt2 + ", height = " + paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack.i();
    }
    this.jdField_b_of_type_Boolean = b();
    Logger.c("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = " + this.jdField_b_of_type_Boolean);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack != null) {
      this.jdField_a_of_type_ComTencentMobileqqDanmakuRenderIDanmakuView$CallBack.k();
    }
    Logger.c("SurfaceDanmakuView", "surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.danmaku.render.SurfaceDanmakuView
 * JD-Core Version:    0.7.0.1
 */