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
  private static HandlerThread s;
  private static final Object t = new Object();
  private boolean A = false;
  private int[] B;
  private int[] C;
  private Camera.FaceDetectionListener D;
  private boolean E = false;
  private volatile boolean F = false;
  private CameraProxy.CameraProxyCallBack G;
  public volatile int a;
  public boolean b = false;
  public int c = 0;
  public int d = 0;
  CameraProxy.ParamCache e = new CameraProxy.ParamCache();
  public CameraProxy.ParamCache f = new CameraProxy.ParamCache();
  public CameraProxy.ParamCache g = new CameraProxy.ParamCache();
  CameraProxy.ParamCache h = new CameraProxy.ParamCache();
  CameraProxy.ParamCache i = new CameraProxy.ParamCache();
  CameraProxy.ParamCache j = new CameraProxy.ParamCache();
  CameraProxy.ParamCache k = new CameraProxy.ParamCache();
  CameraProxy.ParamCache l = new CameraProxy.ParamCache();
  public Map<String, CameraProxy.ParamCache> m = new HashMap();
  public Map<String, CameraProxy.ParamCamera2Cache> n = new HashMap();
  public final CameraProxy.Camera2Handler o;
  public final CameraProxy.CameraPreviewObservable p;
  public CameraExceptionHandler q;
  public boolean r = false;
  private int u = 2147483647;
  private String v = "";
  private String[] w = null;
  private String x = null;
  private String y = null;
  private boolean z = false;
  
  public CameraProxy(Context arg1, Handler paramHandler)
  {
    synchronized (t)
    {
      if (s == null)
      {
        s = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
        s.start();
      }
      this.p = new CameraProxy.CameraPreviewObservable(paramHandler);
      this.o = new CameraProxy.Camera2Handler(this, s.getLooper());
      return;
    }
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
      this.o.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      paramCameraProxyCallBack = this.q;
      if (paramCameraProxyCallBack != null) {
        paramCameraProxyCallBack.a(paramSurfaceTexture);
      }
    }
  }
  
  private void a(CameraProxy.CameraProxyCallBack paramCameraProxyCallBack)
  {
    this.G = paramCameraProxyCallBack;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!StringUtil.isEmpty(paramString)) && (this.y != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set iso to =");
        localStringBuilder.append(paramString);
        QLog.i("CameraProxy", 2, localStringBuilder.toString());
      }
      paramParameters.set(this.y, paramString);
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
      f();
      this.o.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(paramSurfaceTexture);
      }
    }
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
      int i1 = 2147483647;
      for (;;)
      {
        localObject1 = paramParameters;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (int[])((Iterator)localObject2).next();
        if (localObject1[0] < i1)
        {
          i1 = localObject1[0];
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
  
  private boolean c(Camera.Parameters paramParameters)
  {
    if (!this.z) {
      f(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.A)
    {
      String[] arrayOfString = this.w;
      localObject1 = localObject2;
      if (arrayOfString != null)
      {
        localObject1 = localObject2;
        if (arrayOfString.length > 0) {
          localObject1 = arrayOfString[(arrayOfString.length - 1)];
        }
      }
    }
    if ((!StringUtil.isEmpty(localObject1)) && (this.y != null)) {
      return a(paramParameters, localObject1);
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    try
    {
      AEQLog.b("CameraProxy", "camera2 open out.");
      this.o.obtainMessage(1001, new Object[] { Integer.valueOf(paramInt), this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  private boolean d(Camera.Parameters paramParameters)
  {
    if (!this.z) {
      f(paramParameters);
    }
    return this.A;
  }
  
  private String e(Camera.Parameters paramParameters)
  {
    if (!this.z) {
      f(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.A)
    {
      String str = this.y;
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = paramParameters.get(str);
      }
    }
    if (StringUtil.isEmpty((String)localObject1)) {
      this.A = false;
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
  
  private void f()
  {
    try
    {
      this.o.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  private void f(Camera.Parameters paramParameters)
  {
    this.z = true;
    paramParameters = paramParameters.flatten();
    if (paramParameters.contains("iso-values"))
    {
      this.x = "iso-values";
      this.y = "iso";
    }
    else if (paramParameters.contains("iso-mode-values"))
    {
      this.x = "iso-mode-values";
      this.y = "iso";
    }
    else if (paramParameters.contains("iso-speed-values"))
    {
      this.x = "iso-speed-values";
      this.y = "iso-speed";
    }
    else if (paramParameters.contains("nv-picture-iso-values"))
    {
      this.x = "nv-picture-iso-values";
      this.y = "nv-picture-iso";
    }
    if (this.y != null)
    {
      paramParameters = paramParameters.substring(paramParameters.indexOf(this.x));
      Object localObject = paramParameters.substring(paramParameters.indexOf("=") + 1);
      paramParameters = (Camera.Parameters)localObject;
      if (((String)localObject).contains(";")) {
        paramParameters = ((String)localObject).substring(0, ((String)localObject).indexOf(";"));
      }
      this.w = paramParameters.split(",");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init iso key=");
        ((StringBuilder)localObject).append(this.y);
        ((StringBuilder)localObject).append(" value key");
        ((StringBuilder)localObject).append(this.x);
        ((StringBuilder)localObject).append(" Values=");
        ((StringBuilder)localObject).append(paramParameters);
        QLog.i("CameraProxy", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      this.A = false;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "init iso not support");
      }
    }
  }
  
  @TargetApi(14)
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "enterNightMode");
    }
    Camera.Parameters localParameters = CameraControl.a().l();
    if (d(localParameters))
    {
      if (StringUtil.isEmpty(this.v)) {
        this.v = e(localParameters);
      }
      c(localParameters);
    }
    if (this.u == 2147483647) {
      this.u = localParameters.getExposureCompensation();
    }
    localParameters.setExposureCompensation(localParameters.getMaxExposureCompensation());
    if (this.B == null) {
      this.B = a(localParameters);
    }
    if (this.C == null) {
      this.C = b(localParameters);
    }
    a(localParameters, this.C);
    CameraControl.a().d.setParameters(localParameters);
  }
  
  @TargetApi(14)
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = CameraControl.a().l();
    if ((d(localParameters)) && (!StringUtil.isEmpty(this.v))) {
      a(localParameters, this.v);
    }
    int i1 = this.u;
    if (i1 != 2147483647) {
      localParameters.setExposureCompensation(i1);
    }
    int[] arrayOfInt = this.B;
    if (arrayOfInt != null) {
      a(localParameters, arrayOfInt);
    }
    CameraControl.a().d.setParameters(localParameters);
  }
  
  private void i()
  {
    if (!this.E)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]initIsSupportCamera2:");
      localStringBuilder.append(this.E);
      Camera2Utils.a(1, localStringBuilder.toString());
      this.r = false;
      return;
    }
    int i3 = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCamera2ForceOpenSdkVersion();
    int i2 = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getCamera2SwitchValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]initIsSupportCamera2 sdkVersion:");
    localStringBuilder.append(i3);
    localStringBuilder.append(", camera2Switch:");
    localStringBuilder.append(i2);
    localStringBuilder.append(", version:");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    Camera2Utils.a(1, localStringBuilder.toString());
    if (Build.VERSION.SDK_INT < 23)
    {
      this.r = false;
      return;
    }
    if ((i3 > -1) && (i2 > -1))
    {
      int i1 = i2;
      if (DeviceInfoUtil.V())
      {
        i1 = i2;
        if (Build.VERSION.SDK_INT >= 28)
        {
          i1 = i2;
          if (((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).isSamSungCameraOpen()) {
            i1 = 1;
          }
        }
      }
      if ((i3 >= 23) && (Build.VERSION.SDK_INT >= i3) && (i1 != 2))
      {
        this.r = Camera2Control.b();
        return;
      }
      if (i1 == 0)
      {
        this.r = false;
        return;
      }
      this.r = Camera2Control.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]initIsSupportCamera2 result:");
      localStringBuilder.append(this.r);
      Camera2Utils.a(1, localStringBuilder.toString());
      return;
    }
    this.r = false;
  }
  
  public void a()
  {
    b(FlowCameraConstant.b);
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.o.obtainMessage(1070, paramInt, 0).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
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
      this.o.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
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
    long l1 = SystemClock.uptimeMillis() + paramLong;
    try
    {
      CameraProxy.WaitDoneBundle localWaitDoneBundle = new CameraProxy.WaitDoneBundle();
      this.o.post(localWaitDoneBundle.a);
      synchronized (localWaitDoneBundle.b)
      {
        localWaitDoneBundle.b.wait(paramLong);
        if (SystemClock.uptimeMillis() <= l1) {
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
    if (SystemClock.uptimeMillis() <= l1) {
      return;
    }
    throw new IllegalStateException(paramString);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.o.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(paramSurfaceTexture);
      }
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, CameraProxy.CameraProxyCallBack paramCameraProxyCallBack, boolean paramBoolean)
  {
    if (this.r)
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
        localObject = this.o;
        if (paramBoolean)
        {
          i1 = 1;
          ((CameraProxy.Camera2Handler)localObject).obtainMessage(203, i1, 0, paramPreviewCallback).sendToTarget();
          return;
        }
      }
      catch (RuntimeException paramPreviewCallback)
      {
        Object localObject = this.q;
        if (localObject != null) {
          ((CameraExceptionHandler)localObject).a(paramPreviewCallback);
        }
        return;
      }
      int i1 = 0;
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.o.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
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
      this.o.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      paramCameraProxyCallBack = this.q;
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
      int i1;
      if (this.r)
      {
        i1 = 1030;
        if ((paramCameraFocusParams != null) && (paramCameraFocusParams.g) && (paramCameraAutoFocusCallBack != null))
        {
          paramCameraAutoFocusCallBack.a(true, true);
          return;
        }
        Camera2RequestData localCamera2RequestData = new Camera2RequestData();
        localCamera2RequestData.a = 1;
        localCamera2RequestData.b = new CameraProxy.2(this, paramCameraAutoFocusCallBack);
        localFocusData.e = localCamera2RequestData;
        localFocusData.c = paramCameraFocusParams;
      }
      else
      {
        i1 = 103;
        if ((paramCameraFocusParams != null) && (paramCameraFocusParams.a()))
        {
          localFocusData.a = paramCameraFocusParams.f.a(paramCameraFocusParams.a, paramCameraFocusParams.b, paramCameraFocusParams.c, paramCameraFocusParams.d, 1.0F);
          localFocusData.b = paramCameraFocusParams.f.a(paramCameraFocusParams.a, paramCameraFocusParams.b, paramCameraFocusParams.c, paramCameraFocusParams.d, 1.5F);
        }
        localFocusData.d = new CameraProxy.3(this, paramCameraAutoFocusCallBack);
      }
      this.o.obtainMessage(i1, localFocusData).sendToTarget();
      return;
    }
    catch (RuntimeException paramCameraFocusParams)
    {
      paramCameraAutoFocusCallBack = this.q;
      if (paramCameraAutoFocusCallBack != null) {
        paramCameraAutoFocusCallBack.a(paramCameraFocusParams);
      }
    }
  }
  
  public void a(Observer paramObserver)
  {
    this.p.a(paramObserver, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14 });
  }
  
  public void a(CameraControl.CustomSize paramCustomSize1, CameraControl.CustomSize paramCustomSize2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.r)
      {
        this.o.obtainMessage(1005, new Object[] { paramCustomSize1, paramCustomSize2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
        return;
      }
      this.o.obtainMessage(7, new Object[] { paramCustomSize1, paramCustomSize2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException paramCustomSize1)
    {
      paramCustomSize2 = this.q;
      if (paramCustomSize2 != null) {
        paramCustomSize2.a(paramCustomSize1);
      }
    }
  }
  
  public void a(CameraExceptionHandler paramCameraExceptionHandler)
  {
    this.q = paramCameraExceptionHandler;
  }
  
  public void a(File paramFile, Rect paramRect, CameraCover.PictureCallback paramPictureCallback, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    CameraProxy.TakePictureData localTakePictureData = new CameraProxy.TakePictureData(this, null);
    localTakePictureData.a = paramFile;
    localTakePictureData.b = paramRect;
    localTakePictureData.c = paramPictureCallback;
    localTakePictureData.d = paramInt1;
    localTakePictureData.e = paramBoolean;
    localTakePictureData.f = paramInt2;
    if (this.r)
    {
      localTakePictureData.d = paramInt3;
      this.o.obtainMessage(1010, localTakePictureData).sendToTarget();
    }
    else
    {
      localTakePictureData.d = paramInt1;
      this.o.obtainMessage(301, localTakePictureData).sendToTarget();
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
      this.o.obtainMessage(701, new Object[] { paramString }).sendToTarget();
      return;
    }
    catch (RuntimeException paramString)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
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
      if (!this.r)
      {
        if (!paramBoolean)
        {
          this.o.sendEmptyMessage(205);
          return;
        }
        this.o.obtainMessage(205).sendToTarget();
        a(3500L, "stop preview");
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
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
        QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.F), " id:", Integer.valueOf(paramInt) });
      }
      if (this.F)
      {
        if (((IAsyncControl)QRoute.api(IAsyncControl.class)).isCameraCreated())
        {
          Object localObject1;
          if (((IAsyncControl)QRoute.api(IAsyncControl.class)).isCameraCreatedResult()) {
            localObject1 = Boolean.valueOf(((IAsyncControl)QRoute.api(IAsyncControl.class)).isCameraCreatedResult());
          } else {
            localObject1 = ((IAsyncControl)QRoute.api(IAsyncControl.class)).getCameraCreatedResultInfo();
          }
          this.p.a(1, new Object[] { localObject1 });
          if (QLog.isColorLevel()) {
            QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
          }
        }
        return;
      }
      this.F = true;
      i();
      if (this.r) {
        d(paramInt);
      } else {
        try
        {
          this.o.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException)
        {
          if (this.q != null) {
            this.q.a(localRuntimeException);
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void b(Observer paramObserver)
  {
    this.p.a(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, new Object[] { "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.F) });
      }
      boolean bool = this.F;
      if (!bool) {
        return;
      }
      this.F = false;
      try
      {
        if (this.r)
        {
          c();
        }
        else if (!paramBoolean)
        {
          this.o.sendEmptyMessage(2);
        }
        else
        {
          this.o.obtainMessage(2).sendToTarget();
          a(3500L, "release camera");
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        if (this.q != null) {
          this.q.a(localRuntimeException);
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
      this.o.obtainMessage(1003).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void c(int paramInt)
  {
    int i1 = 601;
    try
    {
      if (this.r) {
        i1 = 1040;
      }
      this.o.obtainMessage(i1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = this.r;
    int i1 = 1;
    if (bool)
    {
      this.o.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    CameraProxy.Camera2Handler localCamera2Handler = this.o;
    if (!paramBoolean) {
      i1 = 2;
    }
    localCamera2Handler.obtainMessage(401, i1, 0).sendToTarget();
  }
  
  public void d()
  {
    try
    {
      if (this.r)
      {
        this.o.obtainMessage(1031).sendToTarget();
        return;
      }
      this.o.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      CameraExceptionHandler localCameraExceptionHandler = this.q;
      if (localCameraExceptionHandler != null) {
        localCameraExceptionHandler.a(localRuntimeException);
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.E = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[Camera2]setCamera2Usable:");
    localStringBuilder.append(this.E);
    Camera2Utils.a(1, localStringBuilder.toString());
  }
  
  public CameraProxy.Camera2Handler e()
  {
    return this.o;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraProxy.CameraProxyCallBack localCameraProxyCallBack = this.G;
    if (localCameraProxyCallBack != null) {
      localCameraProxyCallBack.a(paramArrayOfByte, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy
 * JD-Core Version:    0.7.0.1
 */