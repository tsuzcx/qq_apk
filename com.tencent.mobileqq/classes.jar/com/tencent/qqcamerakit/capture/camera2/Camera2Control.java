package com.tencent.qqcamerakit.capture.camera2;

import android.annotation.TargetApi;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.tencent.qqcamerakit.capture.CameraHandler.TakePictureData;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.cameraextend.FocusOperator.CameraFocusParams;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraFpsStrategy;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class Camera2Control
{
  public static String a;
  public static int b = 0;
  private static int e = -1;
  private static boolean f = false;
  private static boolean g = false;
  private static int h = 0;
  private static String i = "";
  private static String j = "";
  private static Camera2Control k;
  private static HashMap<String, Camera2Control.Camera2Info> s = new HashMap();
  private boolean A = false;
  private int B = 4;
  private SurfaceTexture C;
  private HandlerThread D;
  private Handler E;
  private CameraPreviewCallBack F;
  private CameraHandler.TakePictureData G;
  private boolean H = false;
  private CaptureStateCallBack I = new CaptureStateCallBack(this);
  private long J = 0L;
  private int K = -1;
  private Rect L = null;
  private int M = -1;
  private Semaphore N = new Semaphore(1);
  private float O = 0.4F;
  private CameraCaptureSession.CaptureCallback P = new Camera2Control.6(this);
  public Camera2Control.Camera2Listener c;
  public int d = 100;
  private CaptureRequest.Builder l;
  private CaptureRequest m;
  private CameraCaptureSession n;
  private CameraDevice o;
  private ImageReader p;
  private ImageReader q;
  private Camera2Control.Camera2Info r;
  private CameraSize t;
  private CameraSize u;
  private CameraSize v;
  private Range<Integer> w;
  private volatile boolean x = false;
  private volatile boolean y = false;
  private boolean z = false;
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  private Rect a(float paramFloat)
  {
    Rect localRect = (Rect)this.r.b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    float f2 = ((Float)this.r.b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
    float f1 = f2 - 1.0F;
    paramFloat = paramFloat * f1 + 1.0F;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activeRect: ");
    localStringBuilder.append(localRect);
    QLog.c("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxZoom: ");
    localStringBuilder.append(f2);
    QLog.c("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("zoomLevel: ");
    localStringBuilder.append(paramFloat);
    QLog.c("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    int i3 = (int)(localRect.width() / f2);
    int i1 = (int)(localRect.height() / f2);
    int i4 = localRect.width();
    int i2 = localRect.height();
    f2 = i4 - i3;
    paramFloat -= 1.0F;
    i3 = (int)(f2 * paramFloat / f1 / 2.0F);
    i1 = (int)((i2 - i1) * paramFloat / f1 / 2.0F);
    return new Rect(i3, i1, localRect.width() - i3, localRect.height() - i1);
  }
  
  public static Camera2Control a()
  {
    if (k == null) {
      try
      {
        if (k == null) {
          k = new Camera2Control();
        }
      }
      finally {}
    }
    return k;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return i;
      }
      if (c()) {
        return i;
      }
    }
    else if (b())
    {
      return j;
    }
    return "1";
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.r = ((Camera2Control.Camera2Info)s.get(paramString));
    }
  }
  
  public static boolean b()
  {
    q();
    return (h > 0) && (!TextUtils.isEmpty(j));
  }
  
  public static boolean c()
  {
    q();
    return (h > 0) && (!TextUtils.isEmpty(i));
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private int g(int paramInt)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            i1 = i2;
          } else {
            i1 = 270;
          }
        }
        else {
          i1 = 180;
        }
      }
      else {
        i1 = 90;
      }
    }
    return (((Integer)this.r.b.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - i1 + 360) % 360;
  }
  
  public static int n()
  {
    if (f) {
      return e;
    }
    int i2 = -2;
    int i1 = i2;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      android.hardware.camera2.CameraManager localCameraManager = (android.hardware.camera2.CameraManager)CameraProxy.a().getSystemService("camera");
      try
      {
        String[] arrayOfString = localCameraManager.getCameraIdList();
        i1 = i2;
        if (arrayOfString.length <= 0) {
          break label284;
        }
        int i5 = arrayOfString.length;
        int i3 = 0;
        i1 = -2;
        for (;;)
        {
          i2 = i1;
          if (i3 >= i5) {
            break label282;
          }
          i2 = i1;
          try
          {
            localObject1 = localCameraManager.getCameraCharacteristics(arrayOfString[i3]);
            i2 = i1;
            Object localObject2 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_FACING);
            if (localObject2 != null)
            {
              i2 = i1;
              if (((Integer)localObject2).intValue() == 2)
              {
                i4 = i1;
                break label240;
              }
            }
            i2 = i1;
            localObject1 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            i2 = i1;
            if (!QLog.a()) {
              break label296;
            }
            i2 = i1;
            localObject2 = new StringBuilder();
            i2 = i1;
            ((StringBuilder)localObject2).append("[Camera2]initCamera2SupportLevel supportLevel:");
            i2 = i1;
            ((StringBuilder)localObject2).append(localObject1);
            i2 = i1;
            QLog.c("Camera2Control", 2, new Object[] { ((StringBuilder)localObject2).toString() });
            break label296;
            i2 = i1;
            i1 = ((Integer)localObject1).intValue();
            int i4 = i1;
            i2 = i1;
            if (((Integer)localObject1).intValue() != 1)
            {
              i2 = i1;
              int i6 = ((Integer)localObject1).intValue();
              i4 = i1;
              if (i6 != 3)
              {
                i2 = i1;
                break label282;
              }
            }
            label240:
            i3 += 1;
            i1 = i4;
          }
          catch (Throwable localThrowable1)
          {
            i1 = i2;
          }
        }
        i2 = i1;
      }
      catch (Throwable localThrowable2)
      {
        i1 = -2;
      }
      if (QLog.a())
      {
        QLog.a("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", localThrowable2);
        i2 = i1;
      }
    }
    label282:
    for (i1 = i2;; i1 = -1)
    {
      label284:
      e = i1;
      f = true;
      return e;
      label296:
      if (localObject1 != null) {
        break;
      }
    }
  }
  
  private boolean p()
  {
    try
    {
      boolean bool = ((DevicePolicyManager)CameraProxy.a().getSystemService("device_policy")).getCameraDisabled(null);
      return bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      if (QLog.a()) {
        QLog.a("Camera2Control", 2, "checkCameraDisabled, ", localNoClassDefFoundError);
      }
    }
    catch (Exception localException)
    {
      if (QLog.a()) {
        QLog.a("Camera2Control", 2, "checkCameraDisabled, ", localException);
      }
    }
    return true;
  }
  
  private static void q()
  {
    if (g) {
      return;
    }
    try
    {
      if (!d()) {
        break label272;
      }
      localObject = (android.hardware.camera2.CameraManager)CameraProxy.a().getSystemService("camera");
      arrayOfString = ((android.hardware.camera2.CameraManager)localObject).getCameraIdList();
      i2 = arrayOfString.length;
      i1 = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String[] arrayOfString;
        int i2;
        int i1;
        String str;
        CameraCharacteristics localCameraCharacteristics;
        Integer localInteger;
        label272:
        continue;
        i1 += 1;
      }
    }
    if (i1 < i2)
    {
      str = arrayOfString[i1];
      localCameraCharacteristics = ((android.hardware.camera2.CameraManager)localObject).getCameraCharacteristics(str);
      localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
      if ((localInteger != null) && (localInteger.intValue() == 0) && ("1".equals(str)))
      {
        s.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
        j = str;
        h += 1;
      }
      else if ((localInteger != null) && (localInteger.intValue() == 1) && ("0".equals(str)))
      {
        s.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
        i = str;
        h += 1;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]initCamera2Ability front:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", back:");
      ((StringBuilder)localObject).append(i);
      QLog.a("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
      break label272;
      h = 1;
      i = "1";
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2]initCamera2Ability exception!" });
      g = true;
      return;
    }
  }
  
  private void r()
  {
    this.D = new HandlerThread("Camera2_Background_Thread");
    this.D.start();
    this.E = new Handler(this.D.getLooper());
  }
  
  private void s()
  {
    this.D.quitSafely();
    try
    {
      this.D.join();
      this.D = null;
      this.E = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void t()
  {
    CameraCaptureSession localCameraCaptureSession = this.n;
    if (localCameraCaptureSession != null)
    {
      localCameraCaptureSession.close();
      this.n = null;
    }
  }
  
  private void u()
  {
    this.p = ImageReader.newInstance(this.u.a, this.u.b, 256, 2);
    this.p.setOnImageAvailableListener(new Camera2Control.3(this), this.E);
    this.q = ImageReader.newInstance(this.t.a, this.t.b, 35, 2);
    this.q.setOnImageAvailableListener(new Camera2Control.4(this), null);
  }
  
  private void v()
  {
    if (this.o == null) {
      return;
    }
    try
    {
      this.n.setRepeatingRequest(this.l.build(), null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]updatePreview exp:");
      localStringBuilder.append(localException);
      QLog.a("Camera2Control", 1, new Object[] { localStringBuilder.toString() });
    }
  }
  
  private void w()
  {
    try
    {
      this.l.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.I.a(1);
      this.n.capture(this.l.build(), this.I, this.E);
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      localCameraAccessException.printStackTrace();
    }
  }
  
  private void x()
  {
    try
    {
      this.l.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      this.l.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      this.n.capture(this.l.build(), null, null);
      this.n.setRepeatingRequest(this.m, null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a(int paramInt, Camera2Control.Camera2Listener paramCamera2Listener)
  {
    if ((!this.x) && (!this.y))
    {
      boolean bool = p();
      int i1 = 5;
      if (bool)
      {
        if (QLog.a()) {
          QLog.c("Camera2Control", 2, new Object[] { "openCamera failed, camera disable" });
        }
        return 5;
      }
      this.y = true;
      long l1 = System.currentTimeMillis();
      q();
      a(paramCamera2Listener);
      r();
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2]openCamera2" });
      try
      {
        if (this.N.tryAcquire(2500L, TimeUnit.MILLISECONDS))
        {
          b = paramInt;
          paramCamera2Listener = a(paramInt);
          a = paramCamera2Listener;
          a(paramCamera2Listener);
          ((android.hardware.camera2.CameraManager)CameraProxy.a().getSystemService("camera")).openCamera(paramCamera2Listener, new Camera2Control.1(this, l1), this.E);
          return 0;
        }
        throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
      }
      catch (Exception paramCamera2Listener)
      {
        this.x = false;
        this.y = false;
        this.o = null;
        this.N.release();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]openCamera2 exception:");
        ((StringBuilder)localObject).append(paramCamera2Listener);
        QLog.a("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
        if ((paramCamera2Listener instanceof CameraAccessException)) {
          paramInt = i1;
        } else if ((paramCamera2Listener instanceof IllegalArgumentException)) {
          paramInt = 9;
        } else if ((paramCamera2Listener instanceof SecurityException)) {
          paramInt = 8;
        } else {
          paramInt = 3;
        }
        localObject = this.c;
        if (localObject != null) {
          ((Camera2Control.Camera2Listener)localObject).a(1, paramInt, paramCamera2Listener.getMessage(), new Object[0]);
        }
        return 0;
      }
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]openCamera2 hasOpened!" });
    return 6;
  }
  
  public CameraSize a(CameraSize paramCameraSize)
  {
    if ((paramCameraSize != null) && (paramCameraSize.a > 0) && (paramCameraSize.b > 0))
    {
      b(paramCameraSize);
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setViewSize:");
        localStringBuilder.append(paramCameraSize.toString());
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      return this.v;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] setViewSize params error!" });
    return null;
  }
  
  public List<CameraSize> a(boolean paramBoolean)
  {
    Object localObject = this.r;
    if ((localObject != null) && (((Camera2Control.Camera2Info)localObject).a()))
    {
      localObject = (StreamConfigurationMap)this.r.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
      if (localObject == null)
      {
        QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getPreviewSizes map null, isJPEG: ", Boolean.valueOf(paramBoolean) });
        return null;
      }
      if (paramBoolean) {
        localObject = ((StreamConfigurationMap)localObject).getOutputSizes(256);
      } else {
        localObject = ((StreamConfigurationMap)localObject).getOutputSizes(SurfaceTexture.class);
      }
      if (localObject == null)
      {
        QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getPreviewSizes choices is null, isJPEG: ", Boolean.valueOf(paramBoolean) });
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        CameraSize localCameraSize = localObject[i1];
        localCameraSize = new CameraSize(localCameraSize.getWidth(), localCameraSize.getHeight());
        localArrayList.add(localCameraSize);
        if (QLog.a()) {
          QLog.d("Camera2Control", 2, new Object[] { "getPreviewSizes, isJPEG: ", Boolean.valueOf(paramBoolean), " ", localCameraSize });
        }
        i1 += 1;
      }
      return localArrayList;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getPreviewSizes error, camera2Info: ", this.r, " isJPEG: ", Boolean.valueOf(paramBoolean) });
    return null;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.C = paramSurfaceTexture;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    try
    {
      this.N.acquire();
      if ((this.o != null) && (this.x))
      {
        if (paramSurfaceTexture == null)
        {
          QLog.a("Camera2Control", 1, new Object[] { "[Camera2] startPreview params exception!" });
          if (this.c != null) {
            this.c.a(3, 40, "[Camera2]no surface", new Object[0]);
          }
          this.N.release();
          return;
        }
        a(paramSurfaceTexture);
        u();
        this.F = paramCameraPreviewCallBack;
        t();
        this.C.setDefaultBufferSize(this.t.a, this.t.b);
        paramSurfaceTexture = new Surface(this.C);
        this.l = this.o.createCaptureRequest(3);
        this.l.addTarget(paramSurfaceTexture);
        this.l.addTarget(this.q.getSurface());
        this.l.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, Integer.valueOf(com.tencent.qqcamerakit.capture.CameraManager.a));
        paramCameraPreviewCallBack = new StringBuilder();
        paramCameraPreviewCallBack.append("[Camera2] face detect mode : ");
        paramCameraPreviewCallBack.append(this.l.get(CaptureRequest.STATISTICS_FACE_DETECT_MODE));
        QLog.a("Camera2Control", 2, new Object[] { paramCameraPreviewCallBack.toString() });
        this.o.createCaptureSession(Arrays.asList(new Surface[] { paramSurfaceTexture, this.q.getSurface(), this.p.getSurface() }), new Camera2Control.2(this), this.E);
        return;
      }
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2] startPreview mCameraDevice null!" });
      if (this.c != null)
      {
        paramSurfaceTexture = this.c;
        paramCameraPreviewCallBack = new StringBuilder();
        paramCameraPreviewCallBack.append("[Camera2]error camera, isopend:");
        paramCameraPreviewCallBack.append(this.x);
        paramSurfaceTexture.a(3, 41, paramCameraPreviewCallBack.toString(), new Object[0]);
      }
      this.N.release();
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramCameraPreviewCallBack = new StringBuilder();
      paramCameraPreviewCallBack.append("[Camera2]startPreview exception:");
      paramCameraPreviewCallBack.append(paramSurfaceTexture);
      QLog.a("Camera2Control", 1, new Object[] { paramCameraPreviewCallBack.toString() });
      this.z = false;
      this.N.release();
      paramCameraPreviewCallBack = this.c;
      if (paramCameraPreviewCallBack != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]");
        localStringBuilder.append(paramSurfaceTexture.getMessage());
        paramCameraPreviewCallBack.a(3, 42, localStringBuilder.toString(), new Object[0]);
      }
    }
  }
  
  public void a(CameraHandler.TakePictureData paramTakePictureData)
  {
    if (!this.x)
    {
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2] takePicture fail, camera not open" });
      return;
    }
    if (this.H)
    {
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2] takePicture fail, taking status" });
      return;
    }
    if (QLog.a()) {
      QLog.d("Camera2Control", 2, new Object[] { "[Camera2] takePicture request" });
    }
    if (paramTakePictureData == null)
    {
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2] takePicture request exception" });
      return;
    }
    this.H = true;
    this.G = paramTakePictureData;
    if (this.A)
    {
      QLog.c("Camera2Control", 1, new Object[] { "[Camera2] takePicture AutoFocusing" });
      j();
      return;
    }
    w();
  }
  
  public void a(Camera2Control.Camera2Listener paramCamera2Listener)
  {
    this.c = paramCamera2Listener;
  }
  
  public void a(FocusOperator.CameraFocusParams paramCameraFocusParams)
  {
    if (this.o == null) {
      return;
    }
    if ((this.z) && (!this.A))
    {
      this.A = true;
      Object localObject = b(paramCameraFocusParams);
      if (localObject != null) {}
      try
      {
        this.l.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.l.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.l.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        this.l.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.l.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        this.l.setTag(paramCameraFocusParams);
        this.n.setRepeatingRequest(this.l.build(), this.P, this.E);
        return;
      }
      catch (Exception paramCameraFocusParams)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2] autoFocus e:");
        ((StringBuilder)localObject).append(paramCameraFocusParams);
        QLog.a("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
        paramCameraFocusParams.printStackTrace();
        return;
      }
    }
    paramCameraFocusParams = new StringBuilder();
    paramCameraFocusParams.append("[Camera2] autoFocus not preview, mPreview:");
    paramCameraFocusParams.append(this.z);
    paramCameraFocusParams.append(", mIsAutoFocusing:");
    paramCameraFocusParams.append(this.A);
    QLog.a("Camera2Control", 1, new Object[] { paramCameraFocusParams.toString() });
  }
  
  /* Error */
  public boolean a(com.tencent.qqcamerakit.capture.CameraHandler.ParamCamera2Cache paramParamCamera2Cache)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   4: invokevirtual 609	java/util/concurrent/Semaphore:acquire	()V
    //   7: aload_0
    //   8: getfield 90	com/tencent/qqcamerakit/capture/camera2/Camera2Control:x	Z
    //   11: ifne +54 -> 65
    //   14: new 165	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc_w 724
    //   26: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 90	com/tencent/qqcamerakit/capture/camera2/Camera2Control:x	Z
    //   35: invokevirtual 671	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 177
    //   41: iconst_1
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 360	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   60: invokevirtual 517	java/util/concurrent/Semaphore:release	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: aload_1
    //   66: ifnull +72 -> 138
    //   69: aload_1
    //   70: getfield 728	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:b	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   73: ifnull +65 -> 138
    //   76: aload_1
    //   77: getfield 730	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:c	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   80: ifnull +58 -> 138
    //   83: aload_1
    //   84: getfield 732	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:d	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   87: ifnonnull +6 -> 93
    //   90: goto +48 -> 138
    //   93: ldc 177
    //   95: iconst_1
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 734
    //   105: aastore
    //   106: invokestatic 596	com/tencent/qqcamerakit/common/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: aload_1
    //   111: getfield 728	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:b	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   114: invokevirtual 737	com/tencent/qqcamerakit/capture/camera2/Camera2Control:e	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   117: pop
    //   118: aload_0
    //   119: aload_1
    //   120: getfield 730	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:c	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   123: invokevirtual 739	com/tencent/qqcamerakit/capture/camera2/Camera2Control:d	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   126: pop
    //   127: aload_0
    //   128: aload_1
    //   129: getfield 732	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:d	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   132: invokevirtual 741	com/tencent/qqcamerakit/capture/camera2/Camera2Control:c	(Lcom/tencent/qqcamerakit/capture/CameraSize;)V
    //   135: goto +47 -> 182
    //   138: ldc 177
    //   140: iconst_1
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc_w 743
    //   150: aastore
    //   151: invokestatic 360	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   154: goto -98 -> 56
    //   157: astore_1
    //   158: goto +33 -> 191
    //   161: astore_1
    //   162: ldc 177
    //   164: iconst_1
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: ldc_w 745
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_1
    //   178: aastore
    //   179: invokestatic 596	com/tencent/qqcamerakit/common/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   186: invokevirtual 517	java/util/concurrent/Semaphore:release	()V
    //   189: iconst_1
    //   190: ireturn
    //   191: aload_0
    //   192: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   195: invokevirtual 517	java/util/concurrent/Semaphore:release	()V
    //   198: goto +5 -> 203
    //   201: aload_1
    //   202: athrow
    //   203: goto -2 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	Camera2Control
    //   0	206	1	paramParamCamera2Cache	com.tencent.qqcamerakit.capture.CameraHandler.ParamCamera2Cache
    // Exception table:
    //   from	to	target	type
    //   0	56	157	finally
    //   69	90	157	finally
    //   93	135	157	finally
    //   138	154	157	finally
    //   162	182	157	finally
    //   0	56	161	java/lang/Exception
    //   69	90	161	java/lang/Exception
    //   93	135	161	java/lang/Exception
    //   138	154	161	java/lang/Exception
  }
  
  public Rect b(FocusOperator.CameraFocusParams paramCameraFocusParams)
  {
    if (paramCameraFocusParams == null) {
      return null;
    }
    double d6 = paramCameraFocusParams.a;
    double d4 = paramCameraFocusParams.b;
    paramCameraFocusParams.e = g(paramCameraFocusParams.e);
    int i1 = this.t.a;
    int i2 = this.t.b;
    if ((90 == paramCameraFocusParams.e) || (270 == paramCameraFocusParams.e))
    {
      i1 = this.t.b;
      i2 = this.t.a;
    }
    int i3 = paramCameraFocusParams.c;
    int i4 = paramCameraFocusParams.d;
    double d5 = 0.0D;
    if (i3 * i2 > i4 * i1)
    {
      d1 = paramCameraFocusParams.c;
      Double.isNaN(d1);
      d2 = i1;
      Double.isNaN(d2);
      d2 = d1 * 1.0D / d2;
      d1 = i2;
      d3 = paramCameraFocusParams.d;
      Double.isNaN(d3);
      d3 /= d2;
      Double.isNaN(d1);
      d3 = (d1 - d3) / 2.0D;
      d1 = 0.0D;
    }
    else
    {
      d1 = paramCameraFocusParams.d;
      Double.isNaN(d1);
      d2 = i2;
      Double.isNaN(d2);
      d2 = d1 * 1.0D / d2;
      d1 = i1;
      d3 = paramCameraFocusParams.c;
      Double.isNaN(d3);
      d3 /= d2;
      Double.isNaN(d1);
      d1 = (d1 - d3) / 2.0D;
      d3 = 0.0D;
    }
    Double.isNaN(d6);
    double d1 = d6 / d2 + d1;
    Double.isNaN(d4);
    double d2 = d4 / d2 + d3;
    if (90 == paramCameraFocusParams.e)
    {
      d3 = this.t.b;
      Double.isNaN(d3);
      d1 = d3 - d1;
    }
    else if (270 == paramCameraFocusParams.e)
    {
      d3 = this.t.a;
      Double.isNaN(d3);
      d2 = d3 - d2;
    }
    else
    {
      d3 = d2;
      d2 = d1;
      d1 = d3;
    }
    Rect localRect = (Rect)this.m.get(CaptureRequest.SCALER_CROP_REGION);
    paramCameraFocusParams = localRect;
    if (localRect == null)
    {
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getMeteringRect can't get crop region" });
      paramCameraFocusParams = (Rect)this.r.b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }
    i1 = paramCameraFocusParams.width();
    i2 = paramCameraFocusParams.height();
    if (this.t.b * i1 > this.t.a * i2)
    {
      d3 = i2;
      Double.isNaN(d3);
      d4 = this.t.b;
      Double.isNaN(d4);
      d3 = d3 * 1.0D / d4;
      d4 = i1;
      d5 = this.t.a;
      Double.isNaN(d5);
      Double.isNaN(d4);
      d5 = (d4 - d5 * d3) / 2.0D;
      d4 = 0.0D;
    }
    else
    {
      d3 = i1;
      Double.isNaN(d3);
      d4 = this.t.a;
      Double.isNaN(d4);
      d3 = d3 * 1.0D / d4;
      d4 = i2;
      d6 = this.t.b;
      Double.isNaN(d6);
      Double.isNaN(d4);
      d4 = (d4 - d6 * d3) / 2.0D;
    }
    d6 = paramCameraFocusParams.left;
    Double.isNaN(d6);
    d2 = d2 * d3 + d5 + d6;
    d5 = paramCameraFocusParams.top;
    Double.isNaN(d5);
    d1 = d1 * d3 + d4 + d5;
    localRect = new Rect();
    double d3 = paramCameraFocusParams.width();
    Double.isNaN(d3);
    localRect.left = a((int)(d2 - d3 * 0.05D), 0, paramCameraFocusParams.width());
    d3 = paramCameraFocusParams.width();
    Double.isNaN(d3);
    localRect.right = a((int)(d2 + d3 * 0.05D), 0, paramCameraFocusParams.width());
    d2 = paramCameraFocusParams.height();
    Double.isNaN(d2);
    localRect.top = a((int)(d1 - d2 * 0.05D), 0, paramCameraFocusParams.height());
    d2 = paramCameraFocusParams.height();
    Double.isNaN(d2);
    localRect.bottom = a((int)(d1 + 0.05D * d2), 0, paramCameraFocusParams.height());
    return localRect;
  }
  
  public void b(CameraSize paramCameraSize)
  {
    for (;;)
    {
      int i1;
      Object localObject2;
      try
      {
        localObject1 = (StreamConfigurationMap)this.r.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 != null)
        {
          Size[] arrayOfSize = ((StreamConfigurationMap)localObject1).getOutputSizes(35);
          if (arrayOfSize != null)
          {
            i1 = 0;
            localObject1 = arrayOfSize[0];
            int i2 = arrayOfSize.length;
            if (i1 < i2)
            {
              Size localSize = arrayOfSize[i1];
              localObject2 = localObject1;
              if (localSize.getHeight() < paramCameraSize.b / 3) {
                break label153;
              }
              localObject2 = localObject1;
              if (localSize.getHeight() * localSize.getWidth() >= ((Size)localObject1).getWidth() * ((Size)localObject1).getHeight()) {
                break label153;
              }
              localObject2 = localSize;
              break label153;
            }
            c(new CameraSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()));
          }
        }
        if (this.v == null) {
          c(this.t);
        }
        return;
      }
      catch (Exception paramCameraSize)
      {
        return;
      }
      label153:
      i1 += 1;
      Object localObject1 = localObject2;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.z) && (this.l != null))
    {
      if ((paramBoolean) && (this.M != 2))
      {
        this.M = 2;
      }
      else
      {
        if (paramBoolean) {
          break label51;
        }
        this.M = 0;
      }
      boolean bool = true;
      break label53;
      label51:
      bool = false;
      label53:
      Object localObject;
      if (QLog.a())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", mode:");
        QLog.a("Camera2Control", 2, new Object[] { "[Camera2]setFlashOn: ", ((StringBuilder)localObject).toString(), Integer.valueOf(this.M), ", needUpdateView:", Boolean.valueOf(bool) });
      }
      if (bool)
      {
        localObject = this.l;
        if (localObject != null)
        {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.M));
          v();
        }
      }
      return;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]setFlashOn error status!" });
  }
  
  public boolean b(int paramInt)
  {
    int[] arrayOfInt = CameraFpsStrategy.a(paramInt);
    StringBuilder localStringBuilder;
    if (QLog.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamsPreviewFps[fps_wanted=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" force=false]");
      QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
    }
    if ((arrayOfInt != null) && (arrayOfInt.length >= 2))
    {
      this.w = new Range(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
      if (QLog.a())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setPreviewFps:[");
        localStringBuilder.append(arrayOfInt[0]);
        localStringBuilder.append(" ");
        localStringBuilder.append(arrayOfInt[1]);
        localStringBuilder.append("]");
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      return true;
    }
    if (QLog.a()) {
      QLog.c("Camera2Control", 2, new Object[] { "setParamsPreviewFps[getFpsRange=null]" });
    }
    return false;
  }
  
  public void c(int paramInt)
  {
    if (QLog.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]setFocusMode:");
      localStringBuilder.append(paramInt);
      QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
    }
    this.B = paramInt;
  }
  
  public void c(CameraSize paramCameraSize)
  {
    if (QLog.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]setDarkModeSize:");
      String str;
      if (paramCameraSize != null) {
        str = paramCameraSize.toString();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
    }
    this.v = paramCameraSize;
  }
  
  public void d(int paramInt)
  {
    paramInt = this.K + paramInt;
    if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.toUpperCase().contains("PEGM00")))
    {
      e(paramInt);
      return;
    }
    f(paramInt);
  }
  
  public boolean d(CameraSize paramCameraSize)
  {
    if ((paramCameraSize != null) && (paramCameraSize.a > 0) && (paramCameraSize.b > 0))
    {
      this.u = paramCameraSize;
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setRawPictureSize:");
        localStringBuilder.append(paramCameraSize.toString());
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      return true;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] setRawPictureSize params error!" });
    return false;
  }
  
  public List<int[]> e()
  {
    Object localObject1 = this.r;
    if ((localObject1 != null) && (((Camera2Control.Camera2Info)localObject1).a()))
    {
      localObject1 = (Range[])this.r.b.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        int i2 = localObject1.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Object localObject2 = localObject1[i1];
          localArrayList.add(new int[] { ((Integer)localObject2.getLower()).intValue(), ((Integer)localObject2.getUpper()).intValue() });
          i1 += 1;
        }
      }
      return localArrayList;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getPreviewFps error, camera2Info: ", this.r });
    return null;
  }
  
  public void e(int paramInt)
  {
    QLog.c("Camera2Control", 1, new Object[] { "set zoom with new method" });
    float f1 = Math.min(100, Math.max(0, paramInt)) / 100.0F;
    QLog.c("Camera2Control", 1, new Object[] { "target zoom ratio is: ", Float.valueOf(f1) });
    this.L = a(f1);
    if (!this.L.isEmpty())
    {
      this.l.set(CaptureRequest.SCALER_CROP_REGION, this.L);
      v();
    }
  }
  
  public boolean e(CameraSize paramCameraSize)
  {
    if ((paramCameraSize != null) && (paramCameraSize.a > 0) && (paramCameraSize.b > 0))
    {
      this.t = paramCameraSize;
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setPreviewSize:");
        localStringBuilder.append(paramCameraSize.toString());
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      return true;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] setPreviewSize params error!" });
    return false;
  }
  
  public CameraSize f()
  {
    return this.v;
  }
  
  public void f(int paramInt)
  {
    QLog.c("Camera2Control", 1, new Object[] { "set zoom with old method" });
    Rect localRect1 = (Rect)this.r.b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    int i1 = ((Float)this.r.b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
    this.K = paramInt;
    paramInt = this.K;
    if (paramInt <= 0)
    {
      this.K = 0;
    }
    else
    {
      i2 = this.d;
      if (paramInt >= i2) {
        this.K = i2;
      }
    }
    float f2 = this.K / this.d / this.O;
    int i2 = localRect1.centerX();
    paramInt = localRect1.centerY();
    float f3 = localRect1.right;
    float f1 = i2 * f2;
    i2 = (int)(f3 - f1 - 1.0F - (f1 + 16.0F));
    f3 = localRect1.bottom;
    f2 *= paramInt;
    paramInt = (int)(f3 - f2 - 1.0F - (16.0F + f2));
    if ((i2 >= localRect1.right / i1) && (paramInt >= localRect1.bottom / i1))
    {
      Rect localRect2 = new Rect((int)(f1 + 40.0F), (int)(40.0F + f2), localRect1.right - (int)f1 - 1, localRect1.bottom - (int)f2 - 1);
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2] setZoom mZoomValue:");
        localStringBuilder.append(this.K);
        localStringBuilder.append(", realRadio:");
        localStringBuilder.append(i1);
        localStringBuilder.append(", minWidth:");
        localStringBuilder.append(i2);
        localStringBuilder.append(", minHeight:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", rect:");
        localStringBuilder.append(localRect1);
        localStringBuilder.append(", destRect:");
        localStringBuilder.append(localRect2);
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      this.L = localRect2;
      this.l.set(CaptureRequest.SCALER_CROP_REGION, localRect2);
      v();
      return;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] setZoom out of region!" });
  }
  
  public CameraSize g()
  {
    return this.t;
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   4: invokevirtual 609	java/util/concurrent/Semaphore:acquire	()V
    //   7: aload_0
    //   8: invokespecial 619	com/tencent/qqcamerakit/capture/camera2/Camera2Control:t	()V
    //   11: aload_0
    //   12: getfield 209	com/tencent/qqcamerakit/capture/camera2/Camera2Control:o	Landroid/hardware/camera2/CameraDevice;
    //   15: ifnull +15 -> 30
    //   18: aload_0
    //   19: getfield 209	com/tencent/qqcamerakit/capture/camera2/Camera2Control:o	Landroid/hardware/camera2/CameraDevice;
    //   22: invokevirtual 923	android/hardware/camera2/CameraDevice:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 209	com/tencent/qqcamerakit/capture/camera2/Camera2Control:o	Landroid/hardware/camera2/CameraDevice;
    //   30: aload_0
    //   31: getfield 525	com/tencent/qqcamerakit/capture/camera2/Camera2Control:c	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Listener;
    //   34: ifnull +8 -> 42
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 525	com/tencent/qqcamerakit/capture/camera2/Camera2Control:c	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Listener;
    //   42: aload_0
    //   43: getfield 414	com/tencent/qqcamerakit/capture/camera2/Camera2Control:p	Landroid/media/ImageReader;
    //   46: ifnull +15 -> 61
    //   49: aload_0
    //   50: getfield 414	com/tencent/qqcamerakit/capture/camera2/Camera2Control:p	Landroid/media/ImageReader;
    //   53: invokevirtual 924	android/media/ImageReader:close	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 414	com/tencent/qqcamerakit/capture/camera2/Camera2Control:p	Landroid/media/ImageReader;
    //   61: aload_0
    //   62: getfield 425	com/tencent/qqcamerakit/capture/camera2/Camera2Control:q	Landroid/media/ImageReader;
    //   65: ifnull +15 -> 80
    //   68: aload_0
    //   69: getfield 425	com/tencent/qqcamerakit/capture/camera2/Camera2Control:q	Landroid/media/ImageReader;
    //   72: invokevirtual 924	android/media/ImageReader:close	()V
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 425	com/tencent/qqcamerakit/capture/camera2/Camera2Control:q	Landroid/media/ImageReader;
    //   80: aload_0
    //   81: getfield 605	com/tencent/qqcamerakit/capture/camera2/Camera2Control:C	Landroid/graphics/SurfaceTexture;
    //   84: ifnull +8 -> 92
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 605	com/tencent/qqcamerakit/capture/camera2/Camera2Control:C	Landroid/graphics/SurfaceTexture;
    //   92: aload_0
    //   93: getfield 137	com/tencent/qqcamerakit/capture/camera2/Camera2Control:r	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Info;
    //   96: ifnull +8 -> 104
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 137	com/tencent/qqcamerakit/capture/camera2/Camera2Control:r	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Info;
    //   104: aload_0
    //   105: getfield 273	com/tencent/qqcamerakit/capture/camera2/Camera2Control:F	Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;
    //   108: ifnull +8 -> 116
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 273	com/tencent/qqcamerakit/capture/camera2/Camera2Control:F	Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;
    //   116: aload_0
    //   117: getfield 106	com/tencent/qqcamerakit/capture/camera2/Camera2Control:L	Landroid/graphics/Rect;
    //   120: ifnull +8 -> 128
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 106	com/tencent/qqcamerakit/capture/camera2/Camera2Control:L	Landroid/graphics/Rect;
    //   128: aload_0
    //   129: getfield 212	com/tencent/qqcamerakit/capture/camera2/Camera2Control:m	Landroid/hardware/camera2/CaptureRequest;
    //   132: ifnull +8 -> 140
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 212	com/tencent/qqcamerakit/capture/camera2/Camera2Control:m	Landroid/hardware/camera2/CaptureRequest;
    //   140: aload_0
    //   141: invokespecial 926	com/tencent/qqcamerakit/capture/camera2/Camera2Control:s	()V
    //   144: aload_0
    //   145: iconst_m1
    //   146: putfield 104	com/tencent/qqcamerakit/capture/camera2/Camera2Control:K	I
    //   149: aload_0
    //   150: iconst_m1
    //   151: putfield 108	com/tencent/qqcamerakit/capture/camera2/Camera2Control:M	I
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 90	com/tencent/qqcamerakit/capture/camera2/Camera2Control:x	Z
    //   159: aload_0
    //   160: iconst_0
    //   161: putfield 92	com/tencent/qqcamerakit/capture/camera2/Camera2Control:y	Z
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 94	com/tencent/qqcamerakit/capture/camera2/Camera2Control:z	Z
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 100	com/tencent/qqcamerakit/capture/camera2/Camera2Control:H	Z
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 96	com/tencent/qqcamerakit/capture/camera2/Camera2Control:A	Z
    //   179: aload_0
    //   180: lconst_0
    //   181: putfield 102	com/tencent/qqcamerakit/capture/camera2/Camera2Control:J	J
    //   184: ldc 177
    //   186: iconst_1
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: ldc_w 928
    //   196: aastore
    //   197: invokestatic 596	com/tencent/qqcamerakit/common/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   200: goto +67 -> 267
    //   203: astore_1
    //   204: goto +71 -> 275
    //   207: astore_1
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 90	com/tencent/qqcamerakit/capture/camera2/Camera2Control:x	Z
    //   213: aload_0
    //   214: iconst_0
    //   215: putfield 94	com/tencent/qqcamerakit/capture/camera2/Camera2Control:z	Z
    //   218: aload_0
    //   219: iconst_0
    //   220: putfield 100	com/tencent/qqcamerakit/capture/camera2/Camera2Control:H	Z
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 96	com/tencent/qqcamerakit/capture/camera2/Camera2Control:A	Z
    //   228: new 165	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   235: astore_2
    //   236: aload_2
    //   237: ldc_w 930
    //   240: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_2
    //   245: aload_1
    //   246: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 177
    //   252: iconst_1
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload_2
    //   260: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 360	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   267: aload_0
    //   268: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   271: invokevirtual 517	java/util/concurrent/Semaphore:release	()V
    //   274: return
    //   275: aload_0
    //   276: getfield 115	com/tencent/qqcamerakit/capture/camera2/Camera2Control:N	Ljava/util/concurrent/Semaphore;
    //   279: invokevirtual 517	java/util/concurrent/Semaphore:release	()V
    //   282: aload_1
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	Camera2Control
    //   203	1	1	localObject	Object
    //   207	76	1	localException	Exception
    //   235	25	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	30	203	finally
    //   30	42	203	finally
    //   42	61	203	finally
    //   61	80	203	finally
    //   80	92	203	finally
    //   92	104	203	finally
    //   104	116	203	finally
    //   116	128	203	finally
    //   128	140	203	finally
    //   140	200	203	finally
    //   208	267	203	finally
    //   0	30	207	java/lang/Exception
    //   30	42	207	java/lang/Exception
    //   42	61	207	java/lang/Exception
    //   61	80	207	java/lang/Exception
    //   80	92	207	java/lang/Exception
    //   92	104	207	java/lang/Exception
    //   104	116	207	java/lang/Exception
    //   116	128	207	java/lang/Exception
    //   128	140	207	java/lang/Exception
    //   140	200	207	java/lang/Exception
  }
  
  public int i()
  {
    Camera2Control.Camera2Info localCamera2Info = this.r;
    if ((localCamera2Info != null) && (localCamera2Info.b != null)) {
      return ((Integer)this.r.b.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }
    QLog.a("Camera2Control", 1, new Object[] { "getCameraOrientation fail, return 0" });
    return 0;
  }
  
  public void j()
  {
    try
    {
      boolean bool = QLog.a();
      if (bool) {
        QLog.c("Camera2Control", 2, new Object[] { "[Camera2]captureStillPicture request!" });
      }
      if (this.J > 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]captureStillPicture on id:");
        ((StringBuilder)localObject).append(this.J);
        QLog.c("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
        return;
      }
      this.J = System.currentTimeMillis();
      Object localObject = this.o.createCaptureRequest(2);
      ((CaptureRequest.Builder)localObject).addTarget(this.p.getSurface());
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      if (this.M > -1) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.M));
      }
      if (this.L != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.SCALER_CROP_REGION, this.L);
      }
      Camera2Control.5 local5 = new Camera2Control.5(this);
      this.n.capture(((CaptureRequest.Builder)localObject).build(), local5, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void k()
  {
    try
    {
      if (this.l != null)
      {
        this.l.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        v();
        QLog.c("Camera2Control", 1, new Object[] { "[Camera2] setFocusDefaultMode!" });
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.a("Camera2Control", 1, "[Camera2] setFocusDefaultMode exp:", localException);
    }
  }
  
  public void l()
  {
    try
    {
      if (this.l != null)
      {
        this.l.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
        v();
        QLog.c("Camera2Control", 1, new Object[] { "[Camera2] setFocusRecordMode!" });
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.a("Camera2Control", 1, "[Camera2] setFocusRecordMode exp:", localException);
    }
  }
  
  public void m()
  {
    if (this.o == null)
    {
      QLog.c("Camera2Control", 1, new Object[] { "[Camera2] stopRecordVideo device null!" });
      return;
    }
    this.l.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    v();
  }
  
  public CameraCharacteristics o()
  {
    Camera2Control.Camera2Info localCamera2Info = this.r;
    if (localCamera2Info != null) {
      return localCamera2Info.b;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control
 * JD-Core Version:    0.7.0.1
 */