package com.tencent.qqcamerakit.capture;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.tencent.qqcamerakit.common.Observer;

public class CameraProxy
{
  private static Context a;
  private CameraManager b;
  
  public CameraProxy(Context paramContext, Handler paramHandler)
  {
    a = paramContext.getApplicationContext();
    this.b = new CameraManager(paramHandler, true);
  }
  
  public CameraProxy(Context paramContext, Handler paramHandler, boolean paramBoolean)
  {
    a = paramContext.getApplicationContext();
    this.b = new CameraManager(paramHandler, paramBoolean);
  }
  
  public static Context a()
  {
    return a;
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    this.b.a(paramActivity, paramBoolean);
  }
  
  public void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    this.b.a(paramMatrix, paramCameraAutoFocusCallBack, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    this.b.a(paramSurfaceTexture, paramCameraPreviewCallBack);
  }
  
  @RequiresApi(api=21)
  public void a(CameraSize paramCameraSize, int paramInt)
  {
    this.b.a(paramCameraSize, paramCameraSize, paramCameraSize, paramInt, "continuous-picture", 4, 0);
  }
  
  public void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.b.a(paramCameraSize1, paramCameraSize2, paramCameraSize3, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    this.b.a(paramCameraSize, paramBoolean, paramString, paramInt, paramPictureCallback);
  }
  
  public void a(Observer paramObserver)
  {
    this.b.a(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public Object b()
  {
    return this.b.d();
  }
  
  public void b(int paramInt)
  {
    this.b.b(paramInt);
  }
  
  public void b(Observer paramObserver)
  {
    this.b.b(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.b(paramBoolean);
  }
  
  public void c()
  {
    this.b.a();
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  public void d()
  {
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraProxy
 * JD-Core Version:    0.7.0.1
 */