package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.PreviewCallback;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import com.samsung.android.sdk.camera.SCamera;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor;
import com.samsung.android.sdk.camera.SCameraCaptureProcessor.CaptureParameter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.FocusData;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.ParamCamera2Cache;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(23)
public class Camera2Control
{
  public static String a;
  private static boolean e = false;
  private static boolean f = false;
  private static int g = -1;
  private static boolean h = false;
  private static boolean i = false;
  private static int j = 0;
  private static String k = "";
  private static String l = "";
  private static Camera2Control m;
  private static HashMap<String, Camera2Control.Camera2Info> u = new HashMap();
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private int D = -1;
  private SurfaceTexture E;
  private HandlerThread F;
  private Handler G;
  private Camera.PreviewCallback H;
  private Camera2Control.Camera2PictureData I;
  private boolean J = false;
  private CaptureStateCallBack K = new CaptureStateCallBack(this);
  private long L = 0L;
  private Rect M = new Rect(0, 0, 1, 1);
  private int N = -1;
  private Rect O = null;
  private int P = -1;
  private Semaphore Q = new Semaphore(1);
  private SCameraCaptureProcessor R;
  private CaptureRequest S;
  private long T = 0L;
  private int U = 0;
  private CameraCaptureSession.CaptureCallback V = new Camera2Control.5(this);
  public Camera2Control.Camera2Listener b;
  CameraCaptureSession.CaptureCallback c;
  public boolean d = false;
  private CaptureRequest.Builder n;
  private CaptureRequest o;
  private CameraCaptureSession p;
  private CameraDevice q;
  private ImageReader r;
  private ImageReader s;
  private Camera2Control.Camera2Info t;
  private CameraControl.CustomSize v;
  private CameraControl.CustomSize w;
  private CameraControl.CustomSize x;
  private Range<Integer> y;
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
  
  public static Camera2Control a()
  {
    if (m == null) {
      try
      {
        if (m == null) {
          m = new Camera2Control();
        }
      }
      finally {}
    }
    return m;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.t = ((Camera2Control.Camera2Info)u.get(paramString));
    }
  }
  
  private static int[] a(List<int[]> paramList)
  {
    Iterator localIterator = paramList.iterator();
    label9:
    int[] arrayOfInt;
    for (paramList = null; localIterator.hasNext(); paramList = arrayOfInt)
    {
      arrayOfInt = (int[])localIterator.next();
      if ((paramList != null) && ((arrayOfInt[0] > 15) || (arrayOfInt[1] - arrayOfInt[0] <= paramList[1] - paramList[0]))) {
        break label9;
      }
    }
    return paramList;
  }
  
  private static int[] a(List<int[]> paramList, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (int[])((Iterator)localObject2).next();
      if (localObject3[1] >= paramInt) {
        ((List)localObject1).add(localObject3);
      }
    }
    Object localObject3 = ((List)localObject1).iterator();
    localObject1 = null;
    paramInt = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = (int[])((Iterator)localObject3).next();
      int i1 = localObject2[1] - localObject2[0];
      if (i1 > paramInt)
      {
        localObject1 = localObject2;
        paramInt = i1;
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return a(paramList);
  }
  
  public static String b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return k;
      }
      if (n()) {
        return k;
      }
    }
    else if (m())
    {
      return l;
    }
    return "1";
  }
  
  public static boolean b()
  {
    if (f) {
      return e;
    }
    int i1 = c();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i1 != 1) {
      if (i1 == 3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    e = bool1;
    return e;
  }
  
  public static int c()
  {
    if (h) {
      return g;
    }
    int i3 = -2;
    int i1 = i3;
    if (Build.VERSION.SDK_INT >= 23)
    {
      CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      int i2 = i3;
      try
      {
        String[] arrayOfString = localCameraManager.getCameraIdList();
        i2 = i3;
        i1 = i3;
        if (arrayOfString.length > 0)
        {
          i2 = i3;
          int i5 = arrayOfString.length;
          int i4 = 0;
          for (;;)
          {
            i1 = i3;
            if (i4 >= i5) {
              break;
            }
            i2 = i3;
            Object localObject1 = localCameraManager.getCameraCharacteristics(arrayOfString[i4]);
            i2 = i3;
            Object localObject2 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_FACING);
            if (localObject2 != null)
            {
              i2 = i3;
              if (((Integer)localObject2).intValue() == 2)
              {
                i1 = i3;
                break label232;
              }
            }
            i2 = i3;
            localObject1 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            i2 = i3;
            localObject2 = new StringBuilder();
            i2 = i3;
            ((StringBuilder)localObject2).append("[Camera2]initCamera2SupportLevel supportLevel:");
            i2 = i3;
            ((StringBuilder)localObject2).append(localObject1);
            i2 = i3;
            Camera2Utils.a(1, ((StringBuilder)localObject2).toString());
            if (localObject1 == null)
            {
              i1 = -1;
              break;
            }
            i2 = i3;
            i3 = ((Integer)localObject1).intValue();
            i2 = i3;
            i1 = i3;
            if (((Integer)localObject1).intValue() == 1) {
              break;
            }
            i2 = i3;
            int i6 = ((Integer)localObject1).intValue();
            i1 = i3;
            if (i6 == 3)
            {
              i1 = i3;
              break;
            }
            label232:
            i4 += 1;
            i3 = i1;
          }
        }
        g = i1;
      }
      catch (Throwable localThrowable)
      {
        i1 = i2;
        if (QLog.isColorLevel())
        {
          QLog.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", localThrowable);
          i1 = i2;
        }
      }
    }
    h = true;
    return g;
  }
  
  private int d(int paramInt)
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
    return (((Integer)this.t.b.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - i1 + 360) % 360;
  }
  
  public static boolean m()
  {
    return (j > 0) && (!TextUtils.isEmpty(l));
  }
  
  public static boolean n()
  {
    return (j > 0) && (!TextUtils.isEmpty(k));
  }
  
  private static void p()
  {
    if (i) {
      return;
    }
    try
    {
      if ((!VersionUtils.k()) || (!b())) {
        break label259;
      }
      localObject = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      arrayOfString = ((CameraManager)localObject).getCameraIdList();
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
        label259:
        continue;
        i1 += 1;
      }
    }
    if (i1 < i2)
    {
      str = arrayOfString[i1];
      localCameraCharacteristics = ((CameraManager)localObject).getCameraCharacteristics(str);
      localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
      if ((localInteger != null) && (localInteger.intValue() == 0) && ("1".equals(str)))
      {
        u.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
        l = str;
        j += 1;
      }
      else if ((localInteger != null) && (localInteger.intValue() == 1) && ("0".equals(str)))
      {
        u.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
        k = str;
        j += 1;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]initCamera2Ability front:");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", back:");
      ((StringBuilder)localObject).append(k);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
      break label259;
      j = 1;
      k = "1";
      Camera2Utils.a(2, "[Camera2]initCamera2Ability exception!");
      i = true;
      return;
    }
  }
  
  private void q()
  {
    this.r = ImageReader.newInstance(this.w.a, this.w.b, 256, 2);
    this.r.setOnImageAvailableListener(new Camera2Control.3(this), this.G);
    this.s = ImageReader.newInstance(this.x.a, this.x.b, 35, 2);
    this.s.setOnImageAvailableListener(new Camera2Control.4(this), null);
  }
  
  private void r()
  {
    if (this.q == null) {
      return;
    }
    try
    {
      localObject = this.p;
      CaptureRequest localCaptureRequest;
      if (this.d) {
        localCaptureRequest = this.R.buildCaptureRequest(this.n);
      } else {
        localCaptureRequest = this.n.build();
      }
      ((CameraCaptureSession)localObject).setRepeatingRequest(localCaptureRequest, null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]updatePreview exp:");
      ((StringBuilder)localObject).append(localException);
      Camera2Utils.a(2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void s()
  {
    try
    {
      this.n.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.K.a(1);
      CameraCaptureSession localCameraCaptureSession = this.p;
      CaptureRequest localCaptureRequest;
      if (this.d) {
        localCaptureRequest = this.R.buildCaptureRequest(this.n);
      } else {
        localCaptureRequest = this.n.build();
      }
      localCameraCaptureSession.capture(localCaptureRequest, this.K, this.G);
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      localCameraAccessException.printStackTrace();
    }
  }
  
  private void t()
  {
    try
    {
      this.n.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      this.n.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      CameraCaptureSession localCameraCaptureSession = this.p;
      CaptureRequest localCaptureRequest;
      if (this.d) {
        localCaptureRequest = this.R.buildCaptureRequest(this.n);
      } else {
        localCaptureRequest = this.n.build();
      }
      localCameraCaptureSession.capture(localCaptureRequest, null, null);
      localCameraCaptureSession = this.p;
      if (this.d) {
        localCaptureRequest = this.S;
      } else {
        localCaptureRequest = this.o;
      }
      localCameraCaptureSession.setRepeatingRequest(localCaptureRequest, null, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void u()
  {
    CameraCaptureSession localCameraCaptureSession = this.p;
    if (localCameraCaptureSession != null)
    {
      localCameraCaptureSession.close();
      this.p = null;
    }
  }
  
  private void v()
  {
    this.F = new HandlerThread("Camera2_Background_Thread");
    this.F.start();
    this.G = new Handler(this.F.getLooper());
  }
  
  private void w()
  {
    this.F.quitSafely();
    try
    {
      this.F.join();
      this.F = null;
      this.G = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void x()
  {
    if ((DeviceInfoUtil.V()) && (Build.VERSION.SDK_INT >= 28)) {}
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(l)) && (!TextUtils.isEmpty(k)))
        {
          boolean bool2 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), l, 1);
          boolean bool3 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), k, 1);
          if ((!bool2) || (!bool3)) {
            break label279;
          }
          bool1 = true;
          this.d = bool1;
          Size localSize = (Size)Collections.max(Arrays.asList(((StreamConfigurationMap)this.t.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256)), new Camera2Control.CompareSizesByArea());
          if (this.d)
          {
            this.U = (localSize.getHeight() * localSize.getWidth());
            this.R = SCameraCaptureProcessor.getInstance();
            this.R.initialize(BaseApplicationImpl.getApplication(), a, localSize);
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[Camera2]openCamera2 Samsung Sfront:");
          localStringBuilder.append(bool2);
          localStringBuilder.append(", Sback:");
          localStringBuilder.append(bool3);
          localStringBuilder.append(", picSize:");
          localStringBuilder.append(localSize.toString());
          Camera2Utils.a(1, localStringBuilder.toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]openCamera2 Samsung Phone e:");
        localStringBuilder.append(localThrowable.getCause());
        Camera2Utils.a(2, localStringBuilder.toString());
        this.d = false;
      }
      return;
      label279:
      boolean bool1 = false;
    }
  }
  
  public int a(int paramInt, Camera2Control.Camera2Listener paramCamera2Listener)
  {
    if (FlowCameraMqqAction.a())
    {
      Camera2Utils.a(2, "[Camera2]openCamera2 AVcamera2Used!");
      return -101;
    }
    if ((!this.z) && (!this.A))
    {
      this.A = true;
      long l1 = System.currentTimeMillis();
      if (paramCamera2Listener == null)
      {
        Camera2Utils.a(2, "[Camera2]openCamera2 params Error!");
        return -103;
      }
      p();
      a(paramCamera2Listener);
      v();
      CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      try
      {
        if (this.Q.tryAcquire(2500L, TimeUnit.MILLISECONDS))
        {
          String str = b(paramInt);
          a = str;
          a(str);
          x();
          localObject = new Camera2Control.1(this, l1);
          AEQLog.b("Camera2Control", "【Camera2 Open】");
          paramCamera2Listener = (Camera2Control.Camera2Listener)localObject;
          if (this.d) {
            paramCamera2Listener = this.R.createStateCallback((CameraDevice.StateCallback)localObject, this.G);
          }
          localCameraManager.openCamera(str, paramCamera2Listener, this.G);
          return 0;
        }
        throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
      }
      catch (Exception paramCamera2Listener)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]openCamera2 exception:");
        ((StringBuilder)localObject).append(paramCamera2Listener);
        Camera2Utils.a(2, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("【Camera2 Open】openCamera2 exception:");
        ((StringBuilder)localObject).append(paramCamera2Listener);
        AEQLog.b("Camera2Control", ((StringBuilder)localObject).toString());
        this.z = false;
        this.A = false;
        this.q = null;
        this.Q.release();
        paramCamera2Listener = this.b;
        if (paramCamera2Listener != null) {
          paramCamera2Listener.a(-102);
        }
        return 0;
      }
    }
    Camera2Utils.a(2, "[Camera2]openCamera2 hasOpened!");
    return -104;
  }
  
  public CameraControl.CustomSize a(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize != null) && (paramCustomSize.a > 0) && (paramCustomSize.b > 0))
    {
      e(paramCustomSize);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setViewSize:");
        localStringBuilder.append(paramCustomSize.toString());
        QLog.i("Camera2Control", 2, localStringBuilder.toString());
      }
      return this.x;
    }
    Camera2Utils.a(2, "[Camera2] setViewSize params error!");
    return null;
  }
  
  public void a(int paramInt)
  {
    Rect localRect1 = (Rect)this.t.b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    int i1 = ((Float)this.t.b.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
    this.N += paramInt;
    paramInt = this.N;
    if (paramInt <= 0) {
      this.N = 0;
    } else if (paramInt >= 100) {
      this.N = 100;
    }
    float f2 = this.N / 100.0F;
    int i2 = localRect1.centerX();
    paramInt = localRect1.centerY();
    float f3 = localRect1.right;
    float f1 = i2 * f2 / 0.4F;
    i2 = (int)(f3 - f1 - 1.0F - (f1 + 16.0F));
    f3 = localRect1.bottom;
    f2 = f2 * paramInt / 0.4F;
    paramInt = (int)(f3 - f2 - 1.0F - (16.0F + f2));
    if ((i2 >= localRect1.right / i1) && (paramInt >= localRect1.bottom / i1))
    {
      Rect localRect2 = new Rect((int)(f1 + 40.0F), (int)(40.0F + f2), localRect1.right - (int)f1 - 1, localRect1.bottom - (int)f2 - 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] setZoom mZoomValue:");
      localStringBuilder.append(this.N);
      localStringBuilder.append(", realRadio:");
      localStringBuilder.append(i1);
      localStringBuilder.append(", minWidth:");
      localStringBuilder.append(i2);
      localStringBuilder.append(", minHeight:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", rect:");
      localStringBuilder.append(localRect1.toString());
      localStringBuilder.append(", destRect:");
      localStringBuilder.append(localRect2.toString());
      Camera2Utils.a(1, localStringBuilder.toString());
      this.O = localRect2;
      this.n.set(CaptureRequest.SCALER_CROP_REGION, localRect2);
      r();
      return;
    }
    Camera2Utils.a(1, "[Camera2] setZoom out of region!");
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.Q.acquire();
      if ((this.q != null) && (this.z))
      {
        if (paramSurfaceTexture == null)
        {
          Camera2Utils.a(2, "[Camera2] startPreview params exception!");
          if (this.b != null) {
            this.b.a(-203);
          }
          this.Q.release();
          return;
        }
        b(paramSurfaceTexture);
        q();
        u();
        this.E.setDefaultBufferSize(this.v.a, this.v.b);
        paramSurfaceTexture = new Surface(this.E);
        this.n = this.q.createCaptureRequest(3);
        this.n.addTarget(paramSurfaceTexture);
        this.n.addTarget(this.s.getSurface());
        localObject = new Camera2Control.2(this);
        if (this.d)
        {
          this.q.createCaptureSession(this.R.createSessionConfiguration(Arrays.asList(new OutputConfiguration[] { new OutputConfiguration(paramSurfaceTexture), new OutputConfiguration(this.s.getSurface()) }), (CameraCaptureSession.StateCallback)localObject, this.G));
          return;
        }
        this.q.createCaptureSession(Arrays.asList(new Surface[] { paramSurfaceTexture, this.s.getSurface(), this.r.getSurface() }), (CameraCaptureSession.StateCallback)localObject, this.G);
        return;
      }
      Camera2Utils.a(2, "[Camera2] startPreview mCameraDevice null!");
      if (this.b != null) {
        this.b.a(-203);
      }
      this.Q.release();
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]startPreview exception:");
      ((StringBuilder)localObject).append(paramSurfaceTexture);
      Camera2Utils.a(2, ((StringBuilder)localObject).toString());
      this.B = false;
      this.Q.release();
      paramSurfaceTexture = this.b;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.a(-202);
      }
    }
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback)
  {
    this.H = paramPreviewCallback;
  }
  
  public void a(Camera2Control.Camera2Listener paramCamera2Listener)
  {
    this.b = paramCamera2Listener;
  }
  
  public void a(Camera2Control.Camera2PictureData paramCamera2PictureData)
  {
    if (!this.z)
    {
      Camera2Utils.a(2, "[Camera2] camera not open");
      return;
    }
    if (this.J)
    {
      Camera2Utils.a(2, "[Camera2] taking status!");
      return;
    }
    Camera2Utils.a(1, "[Camera2] takePicture request!");
    if (paramCamera2PictureData == null)
    {
      Camera2Utils.a(2, "[Camera2] takePicture request exception!");
      return;
    }
    this.J = true;
    this.I = paramCamera2PictureData;
    if (this.C)
    {
      Camera2Utils.a(1, "[Camera2] takePicture AutoFocusing!");
      j();
      return;
    }
    s();
  }
  
  public void a(CameraProxy.FocusData paramFocusData)
  {
    if (this.q == null) {
      return;
    }
    if ((this.B) && (!this.C))
    {
      this.C = true;
      this.M = ((Rect)this.t.b.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
      Object localObject = b(paramFocusData);
      if (localObject != null) {}
      try
      {
        this.n.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.n.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.n.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        this.n.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.n.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        this.n.setTag(paramFocusData);
        localObject = this.p;
        if (this.d) {
          paramFocusData = this.R.buildCaptureRequest(this.n);
        } else {
          paramFocusData = this.n.build();
        }
        ((CameraCaptureSession)localObject).setRepeatingRequest(paramFocusData, this.V, this.G);
        return;
      }
      catch (Exception paramFocusData)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2] autoFocus e:");
        ((StringBuilder)localObject).append(paramFocusData);
        Camera2Utils.a(2, ((StringBuilder)localObject).toString());
        paramFocusData.printStackTrace();
        return;
      }
    }
    paramFocusData = new StringBuilder();
    paramFocusData.append("[Camera2] autoFocus not preview, mPreview:");
    paramFocusData.append(this.B);
    paramFocusData.append(", mIsAutoFocusing:");
    paramFocusData.append(this.C);
    Camera2Utils.a(2, paramFocusData.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.B) && (this.n != null))
    {
      boolean bool = false;
      if ((paramBoolean) && (this.P != 2))
      {
        this.P = 2;
      }
      else
      {
        if (paramBoolean) {
          break label50;
        }
        this.P = 0;
      }
      bool = true;
      label50:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]setFlashOn: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", mode:");
      ((StringBuilder)localObject).append(this.P);
      ((StringBuilder)localObject).append(", needUpdateView:");
      ((StringBuilder)localObject).append(bool);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
      if (bool)
      {
        localObject = this.n;
        if (localObject != null)
        {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.P));
          r();
        }
      }
      return;
    }
    Camera2Utils.a(1, "[Camera2]setFlashOn error status!");
  }
  
  public boolean a(CameraProxy.ParamCamera2Cache paramParamCamera2Cache)
  {
    if (!this.z)
    {
      paramParamCamera2Cache = new StringBuilder();
      paramParamCamera2Cache.append("[Camera2] setCamera2ParamOnce mIsOpened:");
      paramParamCamera2Cache.append(this.z);
      Camera2Utils.a(2, paramParamCamera2Cache.toString());
      return false;
    }
    if ((paramParamCamera2Cache != null) && (paramParamCamera2Cache.b != null) && (paramParamCamera2Cache.c != null) && (paramParamCamera2Cache.d != null))
    {
      Camera2Utils.a(1, "[Camera2] setCamera2ParamOnce!");
      c(paramParamCamera2Cache.b);
      d(paramParamCamera2Cache.c);
      b(paramParamCamera2Cache.d);
      return true;
    }
    Camera2Utils.a(2, "[Camera2] setCamera2ParamOnce error!");
    return false;
  }
  
  public Rect b(CameraProxy.FocusData paramFocusData)
  {
    if ((paramFocusData != null) && (paramFocusData.c != null))
    {
      double d6 = paramFocusData.c.a;
      double d4 = paramFocusData.c.b;
      paramFocusData.c.e = d(paramFocusData.c.e);
      int i1 = this.v.a;
      int i2 = this.v.b;
      if ((90 == paramFocusData.c.e) || (270 == paramFocusData.c.e))
      {
        i1 = this.v.b;
        i2 = this.v.a;
      }
      int i3 = paramFocusData.c.c;
      int i4 = paramFocusData.c.d;
      double d5 = 0.0D;
      if (i3 * i2 > i4 * i1)
      {
        d1 = paramFocusData.c.c;
        Double.isNaN(d1);
        d2 = i1;
        Double.isNaN(d2);
        d2 = d1 * 1.0D / d2;
        d1 = i2;
        d3 = paramFocusData.c.d;
        Double.isNaN(d3);
        d3 /= d2;
        Double.isNaN(d1);
        d3 = (d1 - d3) / 2.0D;
        d1 = 0.0D;
      }
      else
      {
        d1 = paramFocusData.c.d;
        Double.isNaN(d1);
        d2 = i2;
        Double.isNaN(d2);
        d2 = d1 * 1.0D / d2;
        d1 = i1;
        d3 = paramFocusData.c.c;
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
      if (90 == paramFocusData.c.e)
      {
        d3 = this.v.b;
        Double.isNaN(d3);
        d1 = d3 - d1;
      }
      else if (270 == paramFocusData.c.e)
      {
        d3 = this.v.a;
        Double.isNaN(d3);
        d2 = d3 - d2;
      }
      else
      {
        d3 = d2;
        d2 = d1;
        d1 = d3;
      }
      if (this.d) {
        paramFocusData = this.S;
      } else {
        paramFocusData = this.o;
      }
      Rect localRect = (Rect)paramFocusData.get(CaptureRequest.SCALER_CROP_REGION);
      paramFocusData = localRect;
      if (localRect == null)
      {
        Camera2Utils.a(2, "[Camera2]getMeteringRect can't get crop region");
        paramFocusData = this.M;
      }
      i1 = paramFocusData.width();
      i2 = paramFocusData.height();
      if (this.v.b * i1 > this.v.a * i2)
      {
        d3 = i2;
        Double.isNaN(d3);
        d4 = this.v.b;
        Double.isNaN(d4);
        d3 = d3 * 1.0D / d4;
        d4 = i1;
        d5 = this.v.a;
        Double.isNaN(d5);
        Double.isNaN(d4);
        d5 = (d4 - d5 * d3) / 2.0D;
        d4 = 0.0D;
      }
      else
      {
        d3 = i1;
        Double.isNaN(d3);
        d4 = this.v.a;
        Double.isNaN(d4);
        d3 = d3 * 1.0D / d4;
        d4 = i2;
        d6 = this.v.b;
        Double.isNaN(d6);
        Double.isNaN(d4);
        d4 = (d4 - d6 * d3) / 2.0D;
      }
      d6 = paramFocusData.left;
      Double.isNaN(d6);
      d2 = d2 * d3 + d5 + d6;
      d5 = paramFocusData.top;
      Double.isNaN(d5);
      d1 = d1 * d3 + d4 + d5;
      localRect = new Rect();
      double d3 = paramFocusData.width();
      Double.isNaN(d3);
      localRect.left = a((int)(d2 - d3 * 0.05D), 0, paramFocusData.width());
      d3 = paramFocusData.width();
      Double.isNaN(d3);
      localRect.right = a((int)(d2 + d3 * 0.05D), 0, paramFocusData.width());
      d2 = paramFocusData.height();
      Double.isNaN(d2);
      localRect.top = a((int)(d1 - d2 * 0.05D), 0, paramFocusData.height());
      d2 = paramFocusData.height();
      Double.isNaN(d2);
      localRect.bottom = a((int)(d1 + 0.05D * d2), 0, paramFocusData.height());
      return localRect;
    }
    return null;
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    this.E = paramSurfaceTexture;
  }
  
  public void b(CameraControl.CustomSize paramCustomSize)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2]setDarkModeSize:");
      String str;
      if (paramCustomSize != null) {
        str = paramCustomSize.toString();
      } else {
        str = "";
      }
      localStringBuilder.append(str);
      QLog.i("Camera2Control", 2, localStringBuilder.toString());
    }
    this.x = paramCustomSize;
  }
  
  public boolean c(int paramInt)
  {
    Object localObject = a().o();
    if (localObject == null)
    {
      QLog.e("Camera2Control", 1, "[Camera2]getPreviewFps error, listPreviewFpsRange null");
      return false;
    }
    localObject = a((List)localObject, paramInt);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamsPreviewFps[fps_wanted=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" force=false]");
      QLog.i("Camera2Control", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (localObject.length >= 2))
    {
      this.y = new Range(Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setPreviewFps:[");
        localStringBuilder.append(localObject[0]);
        localStringBuilder.append(" ");
        localStringBuilder.append(localObject[1]);
        localStringBuilder.append("]");
        QLog.i("Camera2Control", 2, localStringBuilder.toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "setParamsPreviewFps[getFpsRange=null]");
    }
    return false;
  }
  
  public boolean c(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize != null) && (paramCustomSize.a > 0) && (paramCustomSize.b > 0))
    {
      this.v = paramCustomSize;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setPreviewSize:");
        localStringBuilder.append(paramCustomSize.toString());
        QLog.i("Camera2Control", 2, localStringBuilder.toString());
      }
      return true;
    }
    Camera2Utils.a(2, "[Camera2] setPreviewSize params error!");
    return false;
  }
  
  public boolean d()
  {
    return this.A;
  }
  
  public boolean d(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize != null) && (paramCustomSize.a > 0) && (paramCustomSize.b > 0))
    {
      this.w = paramCustomSize;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setRawPictureSize:");
        localStringBuilder.append(paramCustomSize.toString());
        QLog.i("Camera2Control", 2, localStringBuilder.toString());
      }
      return true;
    }
    Camera2Utils.a(2, "[Camera2] setRawPictureSize params error!");
    return false;
  }
  
  public CameraControl.CustomSize e()
  {
    return this.x;
  }
  
  public void e(CameraControl.CustomSize paramCustomSize)
  {
    for (;;)
    {
      int i1;
      Object localObject2;
      try
      {
        localObject1 = (StreamConfigurationMap)this.t.b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
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
              if (localSize.getHeight() < paramCustomSize.b / 3) {
                break label153;
              }
              localObject2 = localObject1;
              if (localSize.getHeight() * localSize.getWidth() >= ((Size)localObject1).getWidth() * ((Size)localObject1).getHeight()) {
                break label153;
              }
              localObject2 = localSize;
              break label153;
            }
            b(new CameraControl.CustomSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()));
          }
        }
        if (this.x == null) {
          b(this.v);
        }
        return;
      }
      catch (Exception paramCustomSize)
      {
        return;
      }
      label153:
      i1 += 1;
      Object localObject1 = localObject2;
    }
  }
  
  public CameraControl.CustomSize f()
  {
    return this.v;
  }
  
  public void g()
  {
    try
    {
      if (this.n != null)
      {
        this.n.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        r();
        Camera2Utils.a(1, "[Camera2] setFocusDefaultMode!");
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] setFocusDefaultMode exp:");
      localStringBuilder.append(localException);
      Camera2Utils.a(2, localStringBuilder.toString());
    }
  }
  
  public void h()
  {
    try
    {
      if (this.n != null)
      {
        this.n.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
        r();
        Camera2Utils.a(1, "[Camera2] setFocusRecordMode!");
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] setFocusRecordMode exp:");
      localStringBuilder.append(localException);
      Camera2Utils.a(2, localStringBuilder.toString());
    }
  }
  
  public void i()
  {
    if (this.q == null)
    {
      Camera2Utils.a(2, "[Camera2] stopRecordVideo device null!");
      return;
    }
    this.n.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    r();
  }
  
  public void j()
  {
    try
    {
      Camera2Utils.a(1, "[Camera2]captureStillPicture request!");
      if (this.L > 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]captureStillPicture on id:");
        ((StringBuilder)localObject).append(this.L);
        Camera2Utils.a(1, ((StringBuilder)localObject).toString());
        return;
      }
      this.L = System.currentTimeMillis();
      if (!this.d)
      {
        localObject = this.q.createCaptureRequest(2);
        ((CaptureRequest.Builder)localObject).addTarget(this.r.getSurface());
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        if (this.P > -1) {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.P));
        }
        if (this.O != null) {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.SCALER_CROP_REGION, this.O);
        }
        this.T = System.currentTimeMillis();
        Camera2Control.6 local6 = new Camera2Control.6(this);
        this.p.capture(((CaptureRequest.Builder)localObject).build(), local6, null);
        return;
      }
      Object localObject = new ArrayList();
      ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4)));
      if (this.P > -1) {
        ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.FLASH_MODE, Integer.valueOf(this.P)));
      }
      if (this.O != null) {
        ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.SCALER_CROP_REGION, this.O));
      }
      long l1 = System.currentTimeMillis();
      this.R.capture(this.p, new Camera2Control.7(this, l1), null, (List)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 330	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:R	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 330	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:R	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor;
    //   11: invokevirtual 958	com/samsung/android/sdk/camera/SCameraCaptureProcessor:deinitialize	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 330	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:R	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor;
    //   19: aload_0
    //   20: getfield 129	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:Q	Ljava/util/concurrent/Semaphore;
    //   23: invokevirtual 698	java/util/concurrent/Semaphore:acquire	()V
    //   26: aload_0
    //   27: invokespecial 706	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:u	()V
    //   30: aload_0
    //   31: getfield 155	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:q	Landroid/hardware/camera2/CameraDevice;
    //   34: ifnull +15 -> 49
    //   37: aload_0
    //   38: getfield 155	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:q	Landroid/hardware/camera2/CameraDevice;
    //   41: invokevirtual 959	android/hardware/camera2/CameraDevice:close	()V
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 155	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:q	Landroid/hardware/camera2/CameraDevice;
    //   49: aload_0
    //   50: getfield 631	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:b	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Listener;
    //   53: ifnull +8 -> 61
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 631	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:b	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Listener;
    //   61: aload_0
    //   62: getfield 397	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:r	Landroid/media/ImageReader;
    //   65: ifnull +15 -> 80
    //   68: aload_0
    //   69: getfield 397	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:r	Landroid/media/ImageReader;
    //   72: invokevirtual 960	android/media/ImageReader:close	()V
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 397	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:r	Landroid/media/ImageReader;
    //   80: aload_0
    //   81: getfield 408	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:s	Landroid/media/ImageReader;
    //   84: ifnull +15 -> 99
    //   87: aload_0
    //   88: getfield 408	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:s	Landroid/media/ImageReader;
    //   91: invokevirtual 960	android/media/ImageReader:close	()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 408	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:s	Landroid/media/ImageReader;
    //   99: aload_0
    //   100: getfield 708	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:E	Landroid/graphics/SurfaceTexture;
    //   103: ifnull +8 -> 111
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 708	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:E	Landroid/graphics/SurfaceTexture;
    //   111: aload_0
    //   112: getfield 178	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:t	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;
    //   115: ifnull +8 -> 123
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 178	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:t	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;
    //   123: aload_0
    //   124: getfield 347	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:H	Landroid/hardware/Camera$PreviewCallback;
    //   127: ifnull +8 -> 135
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 347	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:H	Landroid/hardware/Camera$PreviewCallback;
    //   135: aload_0
    //   136: getfield 120	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:O	Landroid/graphics/Rect;
    //   139: ifnull +8 -> 147
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 120	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:O	Landroid/graphics/Rect;
    //   147: aload_0
    //   148: getfield 216	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:o	Landroid/hardware/camera2/CaptureRequest;
    //   151: ifnull +8 -> 159
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield 216	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:o	Landroid/hardware/camera2/CaptureRequest;
    //   159: aload_0
    //   160: getfield 158	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:S	Landroid/hardware/camera2/CaptureRequest;
    //   163: ifnull +8 -> 171
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 158	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:S	Landroid/hardware/camera2/CaptureRequest;
    //   171: aload_0
    //   172: getfield 962	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:c	Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;
    //   175: ifnull +8 -> 183
    //   178: aload_0
    //   179: aconst_null
    //   180: putfield 962	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:c	Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;
    //   183: aload_0
    //   184: invokespecial 964	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:w	()V
    //   187: aload_0
    //   188: iconst_m1
    //   189: putfield 118	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:N	I
    //   192: aload_0
    //   193: iconst_m1
    //   194: putfield 122	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:P	I
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 97	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:z	Z
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 101	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:B	Z
    //   207: aload_0
    //   208: iconst_0
    //   209: putfield 107	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:J	Z
    //   212: aload_0
    //   213: iconst_0
    //   214: putfield 103	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:C	Z
    //   217: aload_0
    //   218: lconst_0
    //   219: putfield 109	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:L	J
    //   222: iconst_1
    //   223: ldc_w 966
    //   226: invokestatic 305	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(ILjava/lang/String;)V
    //   229: goto +58 -> 287
    //   232: astore_1
    //   233: goto +62 -> 295
    //   236: astore_1
    //   237: aload_0
    //   238: iconst_0
    //   239: putfield 97	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:z	Z
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 101	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:B	Z
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 107	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:J	Z
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 103	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:C	Z
    //   257: new 286	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   264: astore_2
    //   265: aload_2
    //   266: ldc_w 968
    //   269: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_2
    //   274: aload_1
    //   275: invokevirtual 296	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: iconst_1
    //   280: aload_2
    //   281: invokevirtual 300	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 305	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(ILjava/lang/String;)V
    //   287: aload_0
    //   288: getfield 129	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:Q	Ljava/util/concurrent/Semaphore;
    //   291: invokevirtual 629	java/util/concurrent/Semaphore:release	()V
    //   294: return
    //   295: aload_0
    //   296: getfield 129	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:Q	Ljava/util/concurrent/Semaphore;
    //   299: invokevirtual 629	java/util/concurrent/Semaphore:release	()V
    //   302: aload_1
    //   303: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	Camera2Control
    //   232	1	1	localObject	Object
    //   236	67	1	localException	Exception
    //   264	17	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	19	232	finally
    //   19	49	232	finally
    //   49	61	232	finally
    //   61	80	232	finally
    //   80	99	232	finally
    //   99	111	232	finally
    //   111	123	232	finally
    //   123	135	232	finally
    //   135	147	232	finally
    //   147	159	232	finally
    //   159	171	232	finally
    //   171	183	232	finally
    //   183	229	232	finally
    //   237	287	232	finally
    //   0	19	236	java/lang/Exception
    //   19	49	236	java/lang/Exception
    //   49	61	236	java/lang/Exception
    //   61	80	236	java/lang/Exception
    //   80	99	236	java/lang/Exception
    //   99	111	236	java/lang/Exception
    //   111	123	236	java/lang/Exception
    //   123	135	236	java/lang/Exception
    //   135	147	236	java/lang/Exception
    //   147	159	236	java/lang/Exception
    //   159	171	236	java/lang/Exception
    //   171	183	236	java/lang/Exception
    //   183	229	236	java/lang/Exception
  }
  
  public Camera2Control.Camera2Info l()
  {
    return this.t;
  }
  
  public List<int[]> o()
  {
    Object localObject1 = this.t;
    if ((localObject1 != null) && (((Camera2Control.Camera2Info)localObject1).a()))
    {
      localObject1 = (Range[])this.t.b.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
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
    QLog.e("Camera2Control", 1, new Object[] { "[Camera2]getPreviewFps error, camera2Info: ", this.t });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control
 * JD-Core Version:    0.7.0.1
 */