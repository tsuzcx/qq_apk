package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.Camera2Listener;
import com.tencent.mobileqq.shortvideo.camera2.Camera2RequestData;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Utils;
import com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.control.CaptureAsyncControl;
import dov.com.tencent.mobileqq.richmedia.capture.util.DovSVParamManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraProxy
  implements Camera.PreviewCallback, Camera2Control.Camera2Listener
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public volatile int a;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener;
  public CameraExceptionHandler a;
  public final CameraProxy.Camera2Handler a;
  public final CameraProxy.CameraPreviewObservable a;
  private CameraProxy.CameraProxyCallBack jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraProxyCallBack;
  CameraProxy.ParamCache jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
  private String jdField_a_of_type_JavaLangString = "";
  public Map<String, CameraProxy.ParamCache> a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  public int b;
  public CameraProxy.ParamCache b;
  private String jdField_b_of_type_JavaLangString = null;
  public Map<String, CameraProxy.ParamCamera2Cache> b;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt;
  public int c;
  public CameraProxy.ParamCache c;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 2147483647;
  CameraProxy.ParamCache jdField_d_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
  private boolean jdField_d_of_type_Boolean = false;
  CameraProxy.ParamCache jdField_e_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
  private boolean jdField_e_of_type_Boolean = false;
  CameraProxy.ParamCache jdField_f_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
  private volatile boolean jdField_f_of_type_Boolean = false;
  CameraProxy.ParamCache g = new CameraProxy.ParamCache();
  CameraProxy.ParamCache h = new CameraProxy.ParamCache();
  
  public CameraProxy(Context arg1, Handler paramHandler)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$ParamCache = new CameraProxy.ParamCache();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_Boolean = false;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable = new CameraProxy.CameraPreviewObservable(paramHandler);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler = new CameraProxy.Camera2Handler(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return;
    }
  }
  
  private String a(Camera.Parameters paramParameters)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_d_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (this.jdField_c_of_type_JavaLangString != null) {
        localObject1 = paramParameters.get(this.jdField_c_of_type_JavaLangString);
      }
    }
    if (StringUtil.a((String)localObject1)) {
      this.jdField_d_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentISO=" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, CameraProxy.CameraProxyCallBack paramCameraProxyCallBack, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture);
    }
    if (paramCameraProxyCallBack != null)
    {
      a(paramCameraProxyCallBack);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  private void a(Camera.Parameters paramParameters)
  {
    this.jdField_c_of_type_Boolean = true;
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
      this.jdField_d_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.i("CameraProxy", 2, "init iso not support");
  }
  
  private void a(CameraProxy.CameraProxyCallBack paramCameraProxyCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraProxyCallBack = paramCameraProxyCallBack;
  }
  
  private boolean a(Camera.Parameters paramParameters)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_d_of_type_Boolean)
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
  
  private void b(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      j();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  private boolean b(Camera.Parameters paramParameters)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramParameters);
    }
    return this.jdField_d_of_type_Boolean;
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
        break label121;
      }
      i = localObject[0];
      paramParameters = (Camera.Parameters)localObject;
    }
    label73:
    label121:
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
  
  private void d(int paramInt)
  {
    try
    {
      AEQLog.b("CameraProxy", "camera2 open out.");
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1001, new Object[] { Integer.valueOf(paramInt), this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  @TargetApi(14)
  private void k()
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
  private void l()
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
  
  private void m()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      Camera2Utils.a(1, "[Camera2]initIsSupportCamera2:" + this.jdField_e_of_type_Boolean);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int k = MediaCodecDPC.c();
    int j = MediaCodecDPC.d();
    Camera2Utils.a(1, "[Camera2]initIsSupportCamera2 sdkVersion:" + k + ", camera2Switch:" + j + ", version:" + Build.VERSION.SDK_INT);
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if ((k <= -1) || (j <= -1))
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int i = j;
    if (DeviceInfoUtil.g())
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 28)
      {
        i = j;
        if (DovSVParamManager.a().b()) {
          i = 1;
        }
      }
    }
    if ((k >= 23) && (Build.VERSION.SDK_INT >= k) && (i != 2))
    {
      this.jdField_b_of_type_Boolean = Camera2Control.a();
      return;
    }
    if (i == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = Camera2Control.a();
    Camera2Utils.a(1, "[Camera2]initIsSupportCamera2 result:" + this.jdField_b_of_type_Boolean);
  }
  
  public CameraProxy.Camera2Handler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler;
  }
  
  public void a()
  {
    b(FlowCameraConstant.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1070, paramInt, 0).sendToTarget();
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, String paramString)
  {
    paramString = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      CameraProxy.WaitDoneBundle localWaitDoneBundle = new CameraProxy.WaitDoneBundle();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.post(localWaitDoneBundle.jdField_a_of_type_JavaLangRunnable);
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
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, CameraProxy.CameraProxyCallBack paramCameraProxyCallBack, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramSurfaceTexture == null)
      {
        a(-201);
        return;
      }
      if (paramCameraProxyCallBack != null) {
        a(paramCameraProxyCallBack);
      }
      b(paramSurfaceTexture);
      return;
    }
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, paramCameraProxyCallBack, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, paramCameraProxyCallBack, paramBoolean);
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
      CameraProxy.Camera2Handler localCamera2Handler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler;
      if (paramBoolean) {
        i = 1;
      }
      localCamera2Handler.obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
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
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceHolder);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, CameraProxy.CameraProxyCallBack paramCameraProxyCallBack, boolean paramBoolean)
  {
    if (paramSurfaceHolder != null) {
      a(paramSurfaceHolder);
    }
    if (paramCameraProxyCallBack != null)
    {
      a(paramCameraProxyCallBack);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramSurfaceHolder);
    }
  }
  
  public void a(CameraFocusParams paramCameraFocusParams, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack)
  {
    try
    {
      localFocusData = new CameraProxy.FocusData(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label118;
      }
      i = 1030;
      if ((paramCameraFocusParams != null) && (paramCameraFocusParams.jdField_a_of_type_Boolean) && (paramCameraAutoFocusCallBack != null))
      {
        paramCameraAutoFocusCallBack.onAutoFocusCallback(true, true);
        return;
      }
      Camera2RequestData localCamera2RequestData = new Camera2RequestData();
      localCamera2RequestData.jdField_a_of_type_Int = 1;
      localCamera2RequestData.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener = new CameraProxy.2(this, paramCameraAutoFocusCallBack);
      localFocusData.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2RequestData = localCamera2RequestData;
      localFocusData.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CameraFocusParams = paramCameraFocusParams;
    }
    catch (RuntimeException paramCameraFocusParams)
    {
      CameraProxy.FocusData localFocusData;
      int i;
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramCameraFocusParams);
        return;
        label118:
        if ((paramCameraFocusParams != null) && (paramCameraFocusParams.a()))
        {
          localFocusData.jdField_a_of_type_AndroidGraphicsRect = paramCameraFocusParams.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramCameraFocusParams.jdField_a_of_type_Float, paramCameraFocusParams.jdField_b_of_type_Float, paramCameraFocusParams.jdField_a_of_type_Int, paramCameraFocusParams.jdField_b_of_type_Int, 1.0F);
          localFocusData.b = paramCameraFocusParams.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramCameraFocusParams.jdField_a_of_type_Float, paramCameraFocusParams.jdField_b_of_type_Float, paramCameraFocusParams.jdField_a_of_type_Int, paramCameraFocusParams.jdField_b_of_type_Int, 1.5F);
        }
        localFocusData.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new CameraProxy.3(this, paramCameraAutoFocusCallBack);
        i = 103;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(i, localFocusData).sendToTarget();
    return;
  }
  
  public void a(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(paramObserver, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14 });
  }
  
  public void a(CameraControl.CustomSize paramCustomSize1, CameraControl.CustomSize paramCustomSize2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1005, new Object[] { paramCustomSize1, paramCustomSize2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(7, new Object[] { paramCustomSize1, paramCustomSize2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException paramCustomSize1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(paramCustomSize1);
      }
    }
  }
  
  public void a(CameraExceptionHandler paramCameraExceptionHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler = paramCameraExceptionHandler;
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    CameraProxy.TakePictureData localTakePictureData = new CameraProxy.TakePictureData(this, null);
    localTakePictureData.jdField_a_of_type_JavaIoFile = paramFile;
    localTakePictureData.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    localTakePictureData.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback = paramPictureCallback;
    localTakePictureData.jdField_a_of_type_Int = paramInt1;
    localTakePictureData.jdField_a_of_type_Boolean = paramBoolean;
    localTakePictureData.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_b_of_type_Boolean)
    {
      localTakePictureData.jdField_a_of_type_Int = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1010, localTakePictureData).sendToTarget();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, "takePicture : file = " + paramFile + " ; orientation = " + paramInt1);
      }
      return;
      localTakePictureData.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(301, localTakePictureData).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(701, new Object[] { paramString }).sendToTarget();
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
    try
    {
      a(null);
      if (!this.jdField_b_of_type_Boolean)
      {
        if (!paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.sendEmptyMessage(205);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(205).sendToTarget();
        a(3500L, "stop preview");
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.jdField_f_of_type_Boolean), " id:", Integer.valueOf(paramInt) });
        }
        if (this.jdField_f_of_type_Boolean)
        {
          Object localObject1 = PeakAppInterface.a;
          if (CaptureAsyncControl.jdField_d_of_type_Boolean)
          {
            localObject1 = PeakAppInterface.a;
            if (!CaptureAsyncControl.jdField_e_of_type_Boolean) {
              continue;
            }
            localObject1 = PeakAppInterface.a;
            localObject1 = Boolean.valueOf(CaptureAsyncControl.jdField_e_of_type_Boolean);
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { localObject1 });
            if (QLog.isColorLevel()) {
              QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
            }
          }
          return;
          localObject1 = PeakAppInterface.a;
          localObject1 = CaptureAsyncControl.jdField_b_of_type_JavaLangString;
          continue;
        }
        this.jdField_f_of_type_Boolean = true;
        m();
        if (this.jdField_b_of_type_Boolean)
        {
          d(paramInt);
          continue;
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      finally {}
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void b(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(paramObserver);
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 153	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 155
    //   10: iconst_2
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 635
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 94	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_f_of_type_Boolean	Z
    //   27: invokestatic 566	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: invokestatic 612	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 94	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_f_of_type_Boolean	Z
    //   38: istore_2
    //   39: iload_2
    //   40: ifne +6 -> 46
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 94	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_f_of_type_Boolean	Z
    //   51: aload_0
    //   52: getfield 96	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_b_of_type_Boolean	Z
    //   55: ifeq +30 -> 85
    //   58: aload_0
    //   59: invokevirtual 637	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:c	()V
    //   62: new 639	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 640	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$1:<init>	(Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy;)V
    //   70: bipush 16
    //   72: aconst_null
    //   73: iconst_0
    //   74: invokestatic 644	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   77: goto -34 -> 43
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    //   85: iload_1
    //   86: ifne +34 -> 120
    //   89: aload_0
    //   90: getfield 129	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler;
    //   93: iconst_2
    //   94: invokevirtual 597	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:sendEmptyMessage	(I)Z
    //   97: pop
    //   98: goto -36 -> 62
    //   101: astore_3
    //   102: aload_0
    //   103: getfield 195	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraExceptionHandler;
    //   106: ifnull -44 -> 62
    //   109: aload_0
    //   110: getfield 195	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraExceptionHandler;
    //   113: aload_3
    //   114: invokevirtual 200	com/tencent/mobileqq/shortvideo/mediadevice/CameraExceptionHandler:a	(Ljava/lang/RuntimeException;)V
    //   117: goto -55 -> 62
    //   120: aload_0
    //   121: getfield 129	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler	Lcom/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler;
    //   124: iconst_2
    //   125: invokevirtual 188	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$Camera2Handler:obtainMessage	(I)Landroid/os/Message;
    //   128: invokevirtual 193	android/os/Message:sendToTarget	()V
    //   131: aload_0
    //   132: ldc2_w 598
    //   135: ldc_w 646
    //   138: invokevirtual 603	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy:a	(JLjava/lang/String;)V
    //   141: goto -79 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	CameraProxy
    //   0	144	1	paramBoolean	boolean
    //   38	2	2	bool	boolean
    //   80	4	3	localObject	Object
    //   101	13	3	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	34	80	finally
    //   34	39	80	finally
    //   46	51	80	finally
    //   51	62	80	finally
    //   62	77	80	finally
    //   89	98	80	finally
    //   102	117	80	finally
    //   120	141	80	finally
    //   51	62	101	java/lang/RuntimeException
    //   89	98	101	java/lang/RuntimeException
    //   120	141	101	java/lang/RuntimeException
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1003).sendToTarget();
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
    int i = 601;
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        i = 1040;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(i, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    CameraProxy.Camera2Handler localCamera2Handler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler;
    if (paramBoolean) {}
    for (;;)
    {
      localCamera2Handler.obtainMessage(401, i, 0).sendToTarget();
      return;
      i = 2;
    }
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    CameraProxy.Camera2Handler localCamera2Handler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localCamera2Handler.obtainMessage(402, i, 0).sendToTarget();
      return;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(502, 2, 0).sendToTarget();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    Camera2Utils.a(1, "[Camera2]setCamera2Usable:" + this.jdField_e_of_type_Boolean);
  }
  
  public void f()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(102).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1032).sendToTarget();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(104).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1031).sendToTarget();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void i()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1021).sendToTarget();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler == null) {}
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraProxy.CameraProxyCallBack localCameraProxyCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraProxyCallBack;
    if (localCameraProxyCallBack != null) {
      localCameraProxyCallBack.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy
 * JD-Core Version:    0.7.0.1
 */