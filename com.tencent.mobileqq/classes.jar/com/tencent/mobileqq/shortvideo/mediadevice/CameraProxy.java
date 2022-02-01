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
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control.Camera2Listener;
import com.tencent.mobileqq.shortvideo.camera2.Camera2RequestData;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Utils;
import com.tencent.mobileqq.shortvideo.camera2.CameraFocusParams;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
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
      String str = this.jdField_c_of_type_JavaLangString;
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = paramParameters.get(str);
      }
    }
    if (StringUtil.a((String)localObject1)) {
      this.jdField_d_of_type_Boolean = false;
    }
    if (QLog.isColorLevel())
    {
      paramParameters = new StringBuilder();
      paramParameters.append("getCurrentISO=");
      paramParameters.append((String)localObject1);
      QLog.i("CameraProxy", 2, paramParameters.toString());
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
      paramCameraProxyCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (paramCameraProxyCallBack != null) {
        paramCameraProxyCallBack.a(paramSurfaceTexture);
      }
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
    }
    else if (paramParameters.contains("iso-mode-values"))
    {
      this.jdField_b_of_type_JavaLangString = "iso-mode-values";
      this.jdField_c_of_type_JavaLangString = "iso";
    }
    else if (paramParameters.contains("iso-speed-values"))
    {
      this.jdField_b_of_type_JavaLangString = "iso-speed-values";
      this.jdField_c_of_type_JavaLangString = "iso-speed";
    }
    else if (paramParameters.contains("nv-picture-iso-values"))
    {
      this.jdField_b_of_type_JavaLangString = "nv-picture-iso-values";
      this.jdField_c_of_type_JavaLangString = "nv-picture-iso";
    }
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      paramParameters = paramParameters.substring(paramParameters.indexOf(this.jdField_b_of_type_JavaLangString));
      Object localObject = paramParameters.substring(paramParameters.indexOf("=") + 1);
      paramParameters = (Camera.Parameters)localObject;
      if (((String)localObject).contains(";")) {
        paramParameters = ((String)localObject).substring(0, ((String)localObject).indexOf(";"));
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = paramParameters.split(",");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init iso key=");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" value key");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" Values=");
        ((StringBuilder)localObject).append(paramParameters);
        QLog.i("CameraProxy", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.jdField_d_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "init iso not support");
      }
    }
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
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0) {
          localObject1 = arrayOfString[(arrayOfString.length - 1)];
        }
      }
    }
    if ((!StringUtil.a(localObject1)) && (this.jdField_c_of_type_JavaLangString != null)) {
      return a(paramParameters, localObject1);
    }
    return false;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!StringUtil.a(paramString)) && (this.jdField_c_of_type_JavaLangString != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set iso to =");
        localStringBuilder.append(paramString);
        QLog.i("CameraProxy", 2, localStringBuilder.toString());
      }
      paramParameters.set(this.jdField_c_of_type_JavaLangString, paramString);
      return true;
    }
    return false;
  }
  
  @TargetApi(9)
  private boolean a(Camera.Parameters paramParameters, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length != 2) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setFpsRange ");
        localStringBuilder.append(paramArrayOfInt[0]);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramArrayOfInt[1]);
        QLog.i("CameraProxy", 2, localStringBuilder.toString());
      }
      paramParameters.setPreviewFpsRange(paramArrayOfInt[0], paramArrayOfInt[1]);
      return true;
    }
    return false;
  }
  
  @TargetApi(9)
  private int[] a(Camera.Parameters paramParameters)
  {
    int[] arrayOfInt = new int[2];
    paramParameters.getPreviewFpsRange(arrayOfInt);
    if (QLog.isColorLevel())
    {
      paramParameters = new StringBuilder();
      paramParameters.append("getCurrentFpsRange ");
      paramParameters.append(arrayOfInt[0]);
      paramParameters.append(" ");
      paramParameters.append(arrayOfInt[1]);
      QLog.i("CameraProxy", 2, paramParameters.toString());
    }
    return arrayOfInt;
  }
  
  private void b(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      e();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(paramSurfaceTexture);
      }
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
    Object localObject2 = paramParameters.getSupportedPreviewFpsRange();
    paramParameters = new int[2];
    Object localObject1 = paramParameters;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      int i = 2147483647;
      for (;;)
      {
        localObject1 = paramParameters;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (int[])((Iterator)localObject2).next();
        if (localObject1[0] < i)
        {
          i = localObject1[0];
          paramParameters = (Camera.Parameters)localObject1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramParameters = new StringBuilder();
      paramParameters.append("getCurrentFpsRange ");
      paramParameters.append(localObject1[0]);
      paramParameters.append(" ");
      paramParameters.append(localObject1[1]);
      QLog.i("CameraProxy", 2, paramParameters.toString());
    }
    return localObject1;
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  private void e()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  @TargetApi(14)
  private void f()
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
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = CameraControl.a().a();
    if ((b(localParameters)) && (!StringUtil.a(this.jdField_a_of_type_JavaLangString))) {
      a(localParameters, this.jdField_a_of_type_JavaLangString);
    }
    int i = this.jdField_d_of_type_Int;
    if (i != 2147483647) {
      localParameters.setExposureCompensation(i);
    }
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    if (arrayOfInt != null) {
      a(localParameters, arrayOfInt);
    }
    CameraControl.a().a.setParameters(localParameters);
  }
  
  private void h()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]initIsSupportCamera2:");
      localStringBuilder.append(this.jdField_e_of_type_Boolean);
      Camera2Utils.a(1, localStringBuilder.toString());
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int k = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCamera2ForceOpenSdkVersion();
    int j = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCamera2SwitchValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]initIsSupportCamera2 sdkVersion:");
    localStringBuilder.append(k);
    localStringBuilder.append(", camera2Switch:");
    localStringBuilder.append(j);
    localStringBuilder.append(", version:");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    Camera2Utils.a(1, localStringBuilder.toString());
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if ((k > -1) && (j > -1))
    {
      int i = j;
      if (DeviceInfoUtil.i())
      {
        i = j;
        if (Build.VERSION.SDK_INT >= 28)
        {
          i = j;
          if (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSamSungCameraOpen()) {
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]initIsSupportCamera2 result:");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      Camera2Utils.a(1, localStringBuilder.toString());
      return;
    }
    this.jdField_b_of_type_Boolean = false;
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Timeout waiting ");
    ((StringBuilder)???).append(paramLong);
    ((StringBuilder)???).append("ms for ");
    ((StringBuilder)???).append(paramString);
    paramString = ((StringBuilder)???).toString();
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      CameraProxy.WaitDoneBundle localWaitDoneBundle = new CameraProxy.WaitDoneBundle();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.post(localWaitDoneBundle.jdField_a_of_type_JavaLangRunnable);
      synchronized (localWaitDoneBundle.jdField_a_of_type_JavaLangObject)
      {
        localWaitDoneBundle.jdField_a_of_type_JavaLangObject.wait(paramLong);
        if (SystemClock.uptimeMillis() <= l) {
          return;
        }
        throw new IllegalStateException(paramString);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label125:
      break label125;
    }
    if (SystemClock.uptimeMillis() <= l) {
      return;
    }
    throw new IllegalStateException(paramString);
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(paramSurfaceTexture);
      }
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
  
  public void a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler;
        if (paramBoolean)
        {
          i = 1;
          ((CameraProxy.Camera2Handler)localObject).obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
          return;
        }
      }
      catch (RuntimeException paramPreviewCallback)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
        if (localObject != null) {
          ((CameraExceptionHandler)localObject).a(paramPreviewCallback);
        }
        return;
      }
      int i = 0;
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(paramSurfaceHolder);
      }
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
      paramCameraProxyCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (paramCameraProxyCallBack != null) {
        paramCameraProxyCallBack.a(paramSurfaceHolder);
      }
    }
  }
  
  public void a(CameraFocusParams paramCameraFocusParams, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack)
  {
    try
    {
      CameraProxy.FocusData localFocusData = new CameraProxy.FocusData(this);
      int i;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 1030;
        if ((paramCameraFocusParams != null) && (paramCameraFocusParams.jdField_a_of_type_Boolean) && (paramCameraAutoFocusCallBack != null))
        {
          paramCameraAutoFocusCallBack.a(true, true);
          return;
        }
        Camera2RequestData localCamera2RequestData = new Camera2RequestData();
        localCamera2RequestData.jdField_a_of_type_Int = 1;
        localCamera2RequestData.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener = new CameraProxy.2(this, paramCameraAutoFocusCallBack);
        localFocusData.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2RequestData = localCamera2RequestData;
        localFocusData.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CameraFocusParams = paramCameraFocusParams;
      }
      else
      {
        i = 103;
        if ((paramCameraFocusParams != null) && (paramCameraFocusParams.a()))
        {
          localFocusData.jdField_a_of_type_AndroidGraphicsRect = paramCameraFocusParams.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramCameraFocusParams.jdField_a_of_type_Float, paramCameraFocusParams.jdField_b_of_type_Float, paramCameraFocusParams.jdField_a_of_type_Int, paramCameraFocusParams.jdField_b_of_type_Int, 1.0F);
          localFocusData.b = paramCameraFocusParams.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraOperator.a(paramCameraFocusParams.jdField_a_of_type_Float, paramCameraFocusParams.jdField_b_of_type_Float, paramCameraFocusParams.jdField_a_of_type_Int, paramCameraFocusParams.jdField_b_of_type_Int, 1.5F);
        }
        localFocusData.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new CameraProxy.3(this, paramCameraAutoFocusCallBack);
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(i, localFocusData).sendToTarget();
      return;
    }
    catch (RuntimeException paramCameraFocusParams)
    {
      paramCameraAutoFocusCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (paramCameraAutoFocusCallBack != null) {
        paramCameraAutoFocusCallBack.a(paramCameraFocusParams);
      }
    }
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
      paramCustomSize2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (paramCustomSize2 != null) {
        paramCustomSize2.a(paramCustomSize1);
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
    else
    {
      localTakePictureData.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(301, localTakePictureData).sendToTarget();
    }
    if (QLog.isColorLevel())
    {
      paramRect = new StringBuilder();
      paramRect.append("takePicture : file = ");
      paramRect.append(paramFile);
      paramRect.append(" ; orientation = ");
      paramRect.append(paramInt1);
      QLog.d("CameraProxy", 2, paramRect.toString());
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(paramString);
      }
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.jdField_f_of_type_Boolean), " id:", Integer.valueOf(paramInt) });
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (((IAsyncControl)QRoute.api(IAsyncControl.class)).isCameraCreated())
        {
          Object localObject1;
          if (((IAsyncControl)QRoute.api(IAsyncControl.class)).isCameraCreatedResult()) {
            localObject1 = Boolean.valueOf(((IAsyncControl)QRoute.api(IAsyncControl.class)).isCameraCreatedResult());
          } else {
            localObject1 = ((IAsyncControl)QRoute.api(IAsyncControl.class)).getCameraCreatedResultInfo();
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(1, new Object[] { localObject1 });
          if (QLog.isColorLevel()) {
            QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
          }
        }
        return;
      }
      this.jdField_f_of_type_Boolean = true;
      h();
      if (this.jdField_b_of_type_Boolean) {
        d(paramInt);
      } else {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void b(Observer paramObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraPreviewObservable.a(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, new Object[] { "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
      }
      boolean bool = this.jdField_f_of_type_Boolean;
      if (!bool) {
        return;
      }
      this.jdField_f_of_type_Boolean = false;
      try
      {
        if (this.jdField_b_of_type_Boolean)
        {
          c();
        }
        else if (!paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.sendEmptyMessage(2);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(2).sendToTarget();
          a(3500L, "release camera");
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler.a(localRuntimeException);
        }
      }
      ThreadManager.excute(new CameraProxy.1(this), 16, null, false);
      return;
    }
    finally {}
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = this.jdField_b_of_type_Boolean;
    int i = 1;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    CameraProxy.Camera2Handler localCamera2Handler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$Camera2Handler;
    if (!paramBoolean) {
      i = 2;
    }
    localCamera2Handler.obtainMessage(401, i, 0).sendToTarget();
  }
  
  public void d()
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
      CameraExceptionHandler localCameraExceptionHandler = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]setCamera2Usable:");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    Camera2Utils.a(1, localStringBuilder.toString());
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraProxy.CameraProxyCallBack localCameraProxyCallBack = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy$CameraProxyCallBack;
    if (localCameraProxyCallBack != null) {
      localCameraProxyCallBack.a(paramArrayOfByte, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy
 * JD-Core Version:    0.7.0.1
 */