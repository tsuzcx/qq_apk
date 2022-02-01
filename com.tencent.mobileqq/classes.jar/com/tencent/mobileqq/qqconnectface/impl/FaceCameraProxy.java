package com.tencent.mobileqq.qqconnectface.impl;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.identification.IdentificationCamera;
import com.tencent.mobileqq.qqconnectface.api.ICamera;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.richmedia.capture.view.CaptureListener;
import com.tencent.mobileqq.richmedia.capture.view.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.OutPreviewCallback;
import com.tencent.mobileqq.richmedia.capture.view.SizeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class FaceCameraProxy
  implements ICamera
{
  @ConfigInject(configPath="Business/qqconnectface-api/src/main/resources/Inject_connect_face_config.yml", version=1)
  private static ArrayList<Class<? extends ICamera>> a = new ArrayList();
  private ICamera b;
  
  static
  {
    a.add(IdentificationCamera.class);
  }
  
  public FaceCameraProxy()
  {
    try
    {
      this.b = ((ICamera)((Class)a.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FaceCameraProxy", 1, "FaceCameraProxy new instance error : ", localException);
    }
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return this.b.a(paramBitmap);
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, OutPreviewCallback paramOutPreviewCallback, boolean paramBoolean)
  {
    this.b.a(paramSurfaceTexture, paramSurfaceHolder, paramOutPreviewCallback, paramBoolean);
  }
  
  public void a(CaptureListener paramCaptureListener)
  {
    this.b.a(paramCaptureListener);
  }
  
  public void a(CaptureParam paramCaptureParam)
  {
    this.b.a(paramCaptureParam);
  }
  
  public void a(SizeListener paramSizeListener)
  {
    this.b.a(paramSizeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void b()
  {
    this.b.b();
  }
  
  public boolean c()
  {
    return this.b.c();
  }
  
  public Camera d()
  {
    return this.b.d();
  }
  
  public int e()
  {
    return this.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.impl.FaceCameraProxy
 * JD-Core Version:    0.7.0.1
 */