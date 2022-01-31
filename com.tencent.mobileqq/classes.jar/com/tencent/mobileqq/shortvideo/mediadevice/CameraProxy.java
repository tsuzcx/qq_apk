package com.tencent.mobileqq.shortvideo.mediadevice;

import aiha;
import aihd;
import aihe;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraProxy
{
  public static HandlerThread a;
  public volatile int a;
  public final aiha a;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener;
  public CameraExceptionHandler a;
  public final CameraProxy.CameraPreviewObservable a;
  public CameraProxy.ParamCache a;
  private String jdField_a_of_type_JavaLangString = "";
  public Map a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  public CameraProxy.ParamCache b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt;
  public int c;
  public CameraProxy.ParamCache c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  public CameraProxy.ParamCache d;
  private int e;
  public CameraProxy.ParamCache e;
  public CameraProxy.ParamCache f = new CameraProxy.ParamCache();
  public CameraProxy.ParamCache g = new CameraProxy.ParamCache();
  public CameraProxy.ParamCache h = new CameraProxy.ParamCache();
  
  public CameraProxy(Context paramContext, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_d_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_e_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_Int = 2147483647;
    if (jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      jdField_a_of_type_AndroidOsHandlerThread.start();
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable = new CameraProxy.CameraPreviewObservable(paramHandler);
    this.jdField_a_of_type_Aiha = new aiha(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private String a(Camera.Parameters paramParameters)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (this.jdField_c_of_type_JavaLangString != null) {
        localObject1 = paramParameters.get(this.jdField_c_of_type_JavaLangString);
      }
    }
    if (StringUtil.a((String)localObject1)) {
      this.jdField_c_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentISO=" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void a(Camera.Parameters paramParameters)
  {
    this.jdField_b_of_type_Boolean = true;
    paramParameters = paramParameters.flatten();
    if (paramParameters.contains("iso-values"))
    {
      this.jdField_b_of_type_JavaLangString = "iso-values";
      this.jdField_c_of_type_JavaLangString = "iso";
      if (this.jdField_c_of_type_JavaLangString == null) {
        break label225;
      }
      paramParameters = paramParameters.substring(paramParameters.indexOf(this.jdField_b_of_type_JavaLangString));
      String str = paramParameters.substring(paramParameters.indexOf("=") + 1);
      paramParameters = str;
      if (str.contains(";")) {
        paramParameters = str.substring(0, str.indexOf(";"));
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = paramParameters.split(",");
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "init iso key=" + this.jdField_c_of_type_JavaLangString + " value key" + this.jdField_b_of_type_JavaLangString + " Values=" + paramParameters);
      }
    }
    label225:
    do
    {
      return;
      if (paramParameters.contains("iso-mode-values"))
      {
        this.jdField_b_of_type_JavaLangString = "iso-mode-values";
        this.jdField_c_of_type_JavaLangString = "iso";
        break;
      }
      if (paramParameters.contains("iso-speed-values"))
      {
        this.jdField_b_of_type_JavaLangString = "iso-speed-values";
        this.jdField_c_of_type_JavaLangString = "iso-speed";
        break;
      }
      if (!paramParameters.contains("nv-picture-iso-values")) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = "nv-picture-iso-values";
      this.jdField_c_of_type_JavaLangString = "nv-picture-iso";
      break;
      this.jdField_c_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.i("CameraProxy", 2, "init iso not support");
  }
  
  private boolean a(Camera.Parameters paramParameters)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)];
        }
      }
    }
    if ((!StringUtil.a((String)localObject1)) && (this.jdField_c_of_type_JavaLangString != null)) {
      return a(paramParameters, (String)localObject1);
    }
    return false;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!StringUtil.a(paramString)) && (this.jdField_c_of_type_JavaLangString != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "set iso to =" + paramString);
      }
      paramParameters.set(this.jdField_c_of_type_JavaLangString, paramString);
      return true;
    }
    return false;
  }
  
  @TargetApi(9)
  private boolean a(Camera.Parameters paramParameters, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "setFpsRange " + paramArrayOfInt[0] + " " + paramArrayOfInt[1]);
    }
    paramParameters.setPreviewFpsRange(paramArrayOfInt[0], paramArrayOfInt[1]);
    return true;
  }
  
  @TargetApi(9)
  private int[] a(Camera.Parameters paramParameters)
  {
    int[] arrayOfInt = new int[2];
    paramParameters.getPreviewFpsRange(arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentFpsRange " + arrayOfInt[0] + " " + arrayOfInt[1]);
    }
    return arrayOfInt;
  }
  
  private boolean b(Camera.Parameters paramParameters)
  {
    if (!this.jdField_b_of_type_Boolean) {
      a(paramParameters);
    }
    return this.jdField_c_of_type_Boolean;
  }
  
  @TargetApi(9)
  private int[] b(Camera.Parameters paramParameters)
  {
    new ArrayList();
    Object localObject = paramParameters.getSupportedPreviewFpsRange();
    paramParameters = new int[2];
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      int i = 2147483647;
      localObject = paramParameters;
      if (!localIterator.hasNext()) {
        break label73;
      }
      localObject = (int[])localIterator.next();
      if (localObject[0] >= i) {
        break label119;
      }
      i = localObject[0];
      paramParameters = (Camera.Parameters)localObject;
    }
    label73:
    label119:
    for (;;)
    {
      break;
      localObject = paramParameters;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "getCurrentFpsRange " + localObject[0] + " " + localObject[1]);
      }
      return localObject;
    }
  }
  
  @TargetApi(14)
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "enterNightMode");
    }
    Camera.Parameters localParameters = CameraControl.a().a();
    if (b(localParameters))
    {
      if (StringUtil.a(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = a(localParameters);
      }
      a(localParameters);
    }
    if (this.jdField_d_of_type_Int == 2147483647) {
      this.jdField_d_of_type_Int = localParameters.getExposureCompensation();
    }
    localParameters.setExposureCompensation(localParameters.getMaxExposureCompensation());
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = a(localParameters);
    }
    if (this.jdField_b_of_type_ArrayOfInt == null) {
      this.jdField_b_of_type_ArrayOfInt = b(localParameters);
    }
    a(localParameters, this.jdField_b_of_type_ArrayOfInt);
    CameraControl.a().a.setParameters(localParameters);
  }
  
  @TargetApi(14)
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = CameraControl.a().a();
    if ((b(localParameters)) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
      a(localParameters, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_Int != 2147483647) {
      localParameters.setExposureCompensation(this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      a(localParameters, this.jdField_a_of_type_ArrayOfInt);
    }
    CameraControl.a().a.setParameters(localParameters);
  }
  
  public aiha a()
  {
    return this.jdField_a_of_type_Aiha;
  }
  
  public void a()
  {
    a(FlowCameraConstant.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    paramString = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      CameraProxy.WaitDoneBundle localWaitDoneBundle = new CameraProxy.WaitDoneBundle();
      this.jdField_a_of_type_Aiha.post(localWaitDoneBundle.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      synchronized (localWaitDoneBundle.jdField_a_of_type_JavaLangObject)
      {
        localWaitDoneBundle.jdField_a_of_type_JavaLangObject.wait(paramLong);
        if (SystemClock.uptimeMillis() > l)
        {
          throw new IllegalStateException(paramString);
          localInterruptedException = localInterruptedException;
          if (SystemClock.uptimeMillis() > l) {
            throw new IllegalStateException(paramString);
          }
        }
      }
    }
  }
  
  public void a(Rect paramRect1, Rect paramRect2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    try
    {
      aihd localaihd = new aihd(this, null);
      localaihd.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = paramAutoFocusCallback;
      localaihd.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
      localaihd.b = paramRect2;
      this.jdField_a_of_type_Aiha.obtainMessage(103, localaihd).sendToTarget();
      return;
    }
    catch (RuntimeException paramRect1)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramRect1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture);
    }
    if (paramPreviewCallback != null) {
      a(paramPreviewCallback, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, paramPreviewCallback, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, paramPreviewCallback, paramBoolean);
  }
  
  public void a(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    this.jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = paramFaceDetectionListener;
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    int i = 0;
    try
    {
      aiha localaiha = this.jdField_a_of_type_Aiha;
      if (paramBoolean) {
        i = 1;
      }
      localaiha.obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramPreviewCallback);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceHolder);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    a(paramSurfaceHolder);
    a(paramPreviewCallback, paramBoolean);
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceHolder);
    }
  }
  
  public void a(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(paramObserver, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12 });
  }
  
  public void a(CameraControl.CustomSize paramCustomSize1, CameraControl.CustomSize paramCustomSize2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(7, new Object[] { paramCustomSize1, paramCustomSize2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException paramCustomSize1)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramCustomSize1);
    }
  }
  
  public void a(CameraExceptionHandler paramCameraExceptionHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = paramCameraExceptionHandler;
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    aihe localaihe = new aihe(this, null);
    localaihe.jdField_a_of_type_JavaIoFile = paramFile;
    localaihe.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    localaihe.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback = paramPictureCallback;
    localaihe.jdField_a_of_type_Int = paramInt1;
    localaihe.jdField_a_of_type_Boolean = paramBoolean;
    localaihe.b = paramInt2;
    this.jdField_a_of_type_Aiha.obtainMessage(301, localaihe).sendToTarget();
    if (QLog.isColorLevel()) {
      QLog.d("CameraProxy", 2, "takePicture : file = " + paramFile + " ; orientation = " + paramInt1);
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(701, new Object[] { paramString }).sendToTarget();
      return;
    }
    catch (RuntimeException paramString)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Aiha.sendEmptyMessage(205);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
    this.jdField_a_of_type_Aiha.obtainMessage(205).sendToTarget();
    a(3500L, "stop preview");
    return;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(601, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void b(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      this.jdField_a_of_type_Aiha.sendEmptyMessage(2);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
    this.jdField_a_of_type_Aiha.obtainMessage(2).sendToTarget();
    a(3500L, "release camera");
    return;
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    aiha localaiha = this.jdField_a_of_type_Aiha;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localaiha.obtainMessage(401, i, 0).sendToTarget();
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aiha.obtainMessage(502, 2, 0).sendToTarget();
  }
  
  public void d(boolean paramBoolean)
  {
    aiha localaiha = this.jdField_a_of_type_Aiha;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localaiha.obtainMessage(402, i, 0).sendToTarget();
      return;
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(102).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_Aiha.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy
 * JD-Core Version:    0.7.0.1
 */