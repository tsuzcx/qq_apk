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
  private static ArrayList<Class<? extends ICamera>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ICamera jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(IdentificationCamera.class);
  }
  
  public FaceCameraProxy()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera = ((ICamera)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FaceCameraProxy", 1, "FaceCameraProxy new instance error : ", localException);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a();
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramBitmap);
  }
  
  public Camera a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, OutPreviewCallback paramOutPreviewCallback, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramSurfaceTexture, paramSurfaceHolder, paramOutPreviewCallback, paramBoolean);
  }
  
  public void a(CaptureListener paramCaptureListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramCaptureListener);
  }
  
  public void a(CaptureParam paramCaptureParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramCaptureParam);
  }
  
  public void a(SizeListener paramSizeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramSizeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceApiICamera.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.impl.FaceCameraProxy
 * JD-Core Version:    0.7.0.1
 */