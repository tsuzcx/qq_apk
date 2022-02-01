package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.PreviewCallback;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl.CustomSize;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.FocusData;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.ParamCamera2Cache;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<[I>;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@TargetApi(23)
public class Camera2Control
{
  private static int jdField_a_of_type_Int;
  private static Camera2Control jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
  public static String a;
  private static HashMap<String, Camera2Control.Camera2Info> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  private static String jdField_c_of_type_JavaLangString;
  private static boolean jdField_c_of_type_Boolean = false;
  private static boolean jdField_d_of_type_Boolean;
  private static boolean jdField_e_of_type_Boolean;
  private long jdField_a_of_type_Long = 0L;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 1, 1);
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Camera.PreviewCallback jdField_a_of_type_AndroidHardwareCamera$PreviewCallback;
  CameraCaptureSession.CaptureCallback jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback;
  private CameraCaptureSession jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
  private CameraDevice jdField_a_of_type_AndroidHardwareCamera2CameraDevice;
  private CaptureRequest.Builder jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder;
  private CaptureRequest jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
  private ImageReader jdField_a_of_type_AndroidMediaImageReader;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Range<Integer> jdField_a_of_type_AndroidUtilRange;
  private SCameraCaptureProcessor jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor;
  private Camera2Control.Camera2Info jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info;
  public Camera2Control.Camera2Listener a;
  private Camera2Control.Camera2PictureData jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData;
  private CaptureStateCallBack jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CaptureStateCallBack = new CaptureStateCallBack(this);
  private CameraControl.CustomSize jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  private Semaphore jdField_a_of_type_JavaUtilConcurrentSemaphore = new Semaphore(1);
  public boolean a;
  private long jdField_b_of_type_Long = 0L;
  private Rect jdField_b_of_type_AndroidGraphicsRect = null;
  private CameraCaptureSession.CaptureCallback jdField_b_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = new Camera2Control.5(this);
  private CaptureRequest jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;
  private ImageReader jdField_b_of_type_AndroidMediaImageReader;
  private CameraControl.CustomSize jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  private int jdField_c_of_type_Int = -1;
  private CameraControl.CustomSize jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  private int jdField_d_of_type_Int = -1;
  private int jdField_e_of_type_Int = -1;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_b_of_type_Int = 0;
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
  }
  
  public Camera2Control()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    if (jdField_d_of_type_Boolean) {
      return jdField_a_of_type_Int;
    }
    int m = -2;
    int k = m;
    CameraManager localCameraManager;
    int n;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      n = m;
    }
    for (;;)
    {
      int i1;
      try
      {
        String[] arrayOfString = localCameraManager.getCameraIdList();
        k = m;
        n = m;
        if (arrayOfString.length > 0)
        {
          n = m;
          int i2 = arrayOfString.length;
          i1 = 0;
          k = m;
          if (i1 < i2)
          {
            n = m;
            localObject = localCameraManager.getCameraCharacteristics(arrayOfString[i1]);
            n = m;
            Integer localInteger = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.LENS_FACING);
            if (localInteger != null)
            {
              n = m;
              if (localInteger.intValue() == 2)
              {
                k = m;
                break label249;
              }
            }
            n = m;
            localObject = (Integer)((CameraCharacteristics)localObject).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            n = m;
            Camera2Utils.a(1, "[Camera2]initCamera2SupportLevel supportLevel:" + localObject);
            if (localObject != null) {
              continue;
            }
            k = -1;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i3;
        k = n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", localThrowable);
        k = n;
        continue;
      }
      jdField_a_of_type_Int = k;
      jdField_d_of_type_Boolean = true;
      return jdField_a_of_type_Int;
      n = m;
      m = ((Integer)localObject).intValue();
      k = m;
      n = m;
      if (((Integer)localObject).intValue() != 1)
      {
        n = m;
        i3 = ((Integer)localObject).intValue();
        k = m;
        if (i3 != 3)
        {
          k = m;
          label249:
          i1 += 1;
          m = k;
        }
      }
    }
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      return (((Integer)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - paramInt + 360) % 360;
      paramInt = 0;
      continue;
      paramInt = 90;
      continue;
      paramInt = 180;
      continue;
      paramInt = 270;
    }
  }
  
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
    if (jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null) {
        jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control = new Camera2Control();
      }
      return jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
    }
    finally {}
  }
  
  public static String a(int paramInt)
  {
    String str = "1";
    switch (paramInt)
    {
    default: 
      str = jdField_b_of_type_JavaLangString;
    }
    do
    {
      do
      {
        return str;
      } while (!c());
      return jdField_c_of_type_JavaLangString;
    } while (!d());
    return jdField_b_of_type_JavaLangString;
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info = ((Camera2Control.Camera2Info)jdField_a_of_type_JavaUtilHashMap.get(paramString));
    }
  }
  
  public static boolean a()
  {
    boolean bool2 = true;
    if (jdField_c_of_type_Boolean) {
      return jdField_b_of_type_Boolean;
    }
    int k = a();
    boolean bool1 = bool2;
    if (k != 1) {
      if (k != 3) {
        break label38;
      }
    }
    label38:
    for (bool1 = bool2;; bool1 = false)
    {
      jdField_b_of_type_Boolean = bool1;
      return jdField_b_of_type_Boolean;
    }
  }
  
  private static int[] a(List<int[]> paramList)
  {
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<int[]>)localObject;
    if (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      if (paramList == null) {
        localObject = arrayOfInt;
      }
      for (;;)
      {
        paramList = (List<int[]>)localObject;
        break;
        if (arrayOfInt[0] <= 15)
        {
          localObject = arrayOfInt;
          if (arrayOfInt[1] - arrayOfInt[0] > paramList[1] - paramList[0]) {}
        }
        else
        {
          localObject = paramList;
        }
      }
    }
    return paramList;
  }
  
  private static int[] a(List<int[]> paramList, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      if (arrayOfInt[1] >= paramInt) {
        ((List)localObject2).add(arrayOfInt);
      }
    }
    localIterator = ((List)localObject2).iterator();
    paramInt = 0;
    if (localIterator.hasNext())
    {
      localObject2 = (int[])localIterator.next();
      int k = localObject2[1] - localObject2[0];
      if (k <= paramInt) {
        break label129;
      }
      localObject1 = localObject2;
      paramInt = k;
    }
    label129:
    for (;;)
    {
      break;
      if (localObject1 != null) {
        return localObject1;
      }
      return a(paramList);
    }
  }
  
  public static boolean c()
  {
    return (jdField_b_of_type_Int > 0) && (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString));
  }
  
  public static boolean d()
  {
    return (jdField_b_of_type_Int > 0) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString));
  }
  
  private static void f()
  {
    if (jdField_e_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      int k;
      try
      {
        if ((VersionUtils.k()) && (a()))
        {
          CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
          String[] arrayOfString = localCameraManager.getCameraIdList();
          int m = arrayOfString.length;
          k = 0;
          if (k >= m) {
            break label216;
          }
          String str = arrayOfString[k];
          CameraCharacteristics localCameraCharacteristics = localCameraManager.getCameraCharacteristics(str);
          Integer localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
          if ((localInteger != null) && (localInteger.intValue() == 0) && ("1".equals(str)))
          {
            jdField_a_of_type_JavaUtilHashMap.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
            jdField_c_of_type_JavaLangString = str;
            jdField_b_of_type_Int += 1;
          }
          else if ((localInteger != null) && (localInteger.intValue() == 1) && ("0".equals(str)))
          {
            jdField_a_of_type_JavaUtilHashMap.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
            jdField_b_of_type_JavaLangString = str;
            jdField_b_of_type_Int += 1;
          }
        }
      }
      catch (Exception localException)
      {
        jdField_b_of_type_Int = 1;
        jdField_b_of_type_JavaLangString = "1";
        Camera2Utils.a(2, "[Camera2]initCamera2Ability exception!");
      }
      for (;;)
      {
        jdField_e_of_type_Boolean = true;
        return;
        label216:
        Camera2Utils.a(1, "[Camera2]initCamera2Ability front:" + jdField_c_of_type_JavaLangString + ", back:" + jdField_b_of_type_JavaLangString);
      }
      k += 1;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidMediaImageReader = ImageReader.newInstance(this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int, 256, 2);
    this.jdField_a_of_type_AndroidMediaImageReader.setOnImageAvailableListener(new Camera2Control.3(this), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidMediaImageReader = ImageReader.newInstance(this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int, 35, 2);
    this.jdField_b_of_type_AndroidMediaImageReader.setOnImageAvailableListener(new Camera2Control.4(this), null);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    for (;;)
    {
      try
      {
        CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (this.jdField_a_of_type_Boolean)
        {
          CaptureRequest localCaptureRequest1 = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
          localCameraCaptureSession.setRepeatingRequest(localCaptureRequest1, null, null);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        Camera2Utils.a(2, "[Camera2]updatePreview exp:" + localException);
        return;
      }
      CaptureRequest localCaptureRequest2 = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
    }
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CaptureStateCallBack.a(1);
      CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      if (this.jdField_a_of_type_Boolean) {}
      for (CaptureRequest localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);; localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build())
      {
        localCameraCaptureSession.capture(localCaptureRequest, this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CaptureStateCallBack, this.jdField_a_of_type_AndroidOsHandler);
        return;
      }
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      localCameraAccessException.printStackTrace();
    }
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      if (this.jdField_a_of_type_Boolean)
      {
        localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
        localCameraCaptureSession.capture(localCaptureRequest, null, null);
        localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (!this.jdField_a_of_type_Boolean) {
          break label97;
        }
      }
      label97:
      for (CaptureRequest localCaptureRequest = this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;; localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest)
      {
        localCameraCaptureSession.setRepeatingRequest(localCaptureRequest, null, null);
        return;
        localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
        break;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession != null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.close();
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession = null;
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Camera2_Background_Thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.join();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      this.jdField_a_of_type_AndroidOsHandler = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    boolean bool1 = true;
    if ((DeviceInfoUtil.g()) && (Build.VERSION.SDK_INT >= 28)) {}
    try
    {
      boolean bool2;
      boolean bool3;
      if ((!TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
      {
        bool2 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), jdField_c_of_type_JavaLangString, 1);
        bool3 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), jdField_b_of_type_JavaLangString, 1);
        if ((!bool2) || (!bool3)) {
          break label208;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool1;
        Size localSize = (Size)Collections.max(Arrays.asList(((StreamConfigurationMap)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256)), new Camera2Control.CompareSizesByArea());
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_f_of_type_Int = (localSize.getHeight() * localSize.getWidth());
          this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor = SCameraCaptureProcessor.getInstance();
          this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.initialize(BaseApplicationImpl.getApplication(), jdField_a_of_type_JavaLangString, localSize);
        }
        Camera2Utils.a(1, "[Camera2]openCamera2 Samsung Sfront:" + bool2 + ", Sback:" + bool3 + ", picSize:" + localSize.toString());
        return;
        label208:
        bool1 = false;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Camera2Utils.a(2, "[Camera2]openCamera2 Samsung Phone e:" + localThrowable.getCause());
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public int a(int paramInt, Camera2Control.Camera2Listener paramCamera2Listener)
  {
    if (FlowCameraMqqAction.a())
    {
      Camera2Utils.a(2, "[Camera2]openCamera2 AVcamera2Used!");
      return -101;
    }
    if ((this.jdField_f_of_type_Boolean) || (this.g))
    {
      Camera2Utils.a(2, "[Camera2]openCamera2 hasOpened!");
      return -104;
    }
    this.g = true;
    long l = System.currentTimeMillis();
    if (paramCamera2Listener == null)
    {
      Camera2Utils.a(2, "[Camera2]openCamera2 params Error!");
      return -103;
    }
    f();
    a(paramCamera2Listener);
    l();
    CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
    try
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentSemaphore.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
        throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
      }
    }
    catch (Exception paramCamera2Listener)
    {
      Camera2Utils.a(2, "[Camera2]openCamera2 exception:" + paramCamera2Listener);
      AEQLog.b("Camera2Control", "【Camera2 Open】openCamera2 exception:" + paramCamera2Listener);
      this.jdField_f_of_type_Boolean = false;
      this.g = false;
      this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice = null;
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener.a(-102);
      }
    }
    for (;;)
    {
      return 0;
      String str = a(paramInt);
      jdField_a_of_type_JavaLangString = str;
      a(str);
      n();
      Camera2Control.1 local1 = new Camera2Control.1(this, l);
      AEQLog.b("Camera2Control", "【Camera2 Open】");
      paramCamera2Listener = local1;
      if (this.jdField_a_of_type_Boolean) {
        paramCamera2Listener = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.createStateCallback(local1, this.jdField_a_of_type_AndroidOsHandler);
      }
      localCameraManager.openCamera(str, paramCamera2Listener, this.jdField_a_of_type_AndroidOsHandler);
    }
  }
  
  public Rect a(CameraProxy.FocusData paramFocusData)
  {
    if ((paramFocusData == null) || (paramFocusData.a == null)) {
      return null;
    }
    double d5 = paramFocusData.a.jdField_a_of_type_Float;
    double d4 = paramFocusData.a.jdField_b_of_type_Float;
    paramFocusData.a.jdField_c_of_type_Int = a(paramFocusData.a.jdField_c_of_type_Int);
    int m = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
    int k = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
    if ((90 == paramFocusData.a.jdField_c_of_type_Int) || (270 == paramFocusData.a.jdField_c_of_type_Int))
    {
      m = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
      k = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
    }
    double d2;
    double d1;
    double d3;
    if (paramFocusData.a.jdField_a_of_type_Int * k > paramFocusData.a.jdField_b_of_type_Int * m)
    {
      d2 = paramFocusData.a.jdField_a_of_type_Int * 1.0D / m;
      d1 = (k - paramFocusData.a.jdField_b_of_type_Int / d2) / 2.0D;
      d3 = 0.0D;
      d3 += d5 / d2;
      d1 += d4 / d2;
      if (90 != paramFocusData.a.jdField_c_of_type_Int) {
        break label552;
      }
      d2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
      d3 = d2 - d3;
      d2 = d1;
      d1 = d3;
    }
    for (;;)
    {
      label227:
      label239:
      Rect localRect;
      if (this.jdField_a_of_type_Boolean)
      {
        paramFocusData = this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;
        localRect = (Rect)paramFocusData.get(CaptureRequest.SCALER_CROP_REGION);
        paramFocusData = localRect;
        if (localRect == null)
        {
          Camera2Utils.a(2, "[Camera2]getMeteringRect can't get crop region");
          paramFocusData = this.jdField_a_of_type_AndroidGraphicsRect;
        }
        k = paramFocusData.width();
        m = paramFocusData.height();
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int * k <= this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int * m) {
          break label591;
        }
        d4 = m * 1.0D / this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
        d3 = 0.0D;
        d5 = (k - this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int * d4) / 2.0D;
      }
      for (;;)
      {
        d2 = d2 * d4 + d5 + paramFocusData.left;
        d1 = d1 * d4 + d3 + paramFocusData.top;
        localRect = new Rect();
        localRect.left = a((int)(d2 - 0.1D / 2.0D * paramFocusData.width()), 0, paramFocusData.width());
        localRect.right = a((int)(d2 + 0.1D / 2.0D * paramFocusData.width()), 0, paramFocusData.width());
        localRect.top = a((int)(d1 - 0.1D / 2.0D * paramFocusData.height()), 0, paramFocusData.height());
        localRect.bottom = a((int)(d1 + 0.1D / 2.0D * paramFocusData.height()), 0, paramFocusData.height());
        return localRect;
        d2 = paramFocusData.a.jdField_b_of_type_Int * 1.0D / k;
        d3 = (m - paramFocusData.a.jdField_a_of_type_Int / d2) / 2.0D;
        d1 = 0.0D;
        break;
        label552:
        if (270 != paramFocusData.a.jdField_c_of_type_Int) {
          break label634;
        }
        d2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int - d1;
        d1 = d3;
        break label227;
        paramFocusData = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
        break label239;
        label591:
        d4 = k * 1.0D / this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
        d5 = 0.0D;
        d3 = (m - this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int * d4) / 2.0D;
      }
      label634:
      d2 = d3;
    }
  }
  
  public Camera2Control.Camera2Info a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info;
  }
  
  public CameraControl.CustomSize a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public CameraControl.CustomSize a(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize == null) || (paramCustomSize.jdField_a_of_type_Int <= 0) || (paramCustomSize.jdField_b_of_type_Int <= 0))
    {
      Camera2Utils.a(2, "[Camera2] setViewSize params error!");
      return null;
    }
    b(paramCustomSize);
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setViewSize:" + paramCustomSize.toString());
    }
    return this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public List<int[]> a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info == null) || (!this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a()))
    {
      QLog.e("Camera2Control", 1, new Object[] { "[Camera2]getPreviewFps error, camera2Info: ", this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info });
      return null;
    }
    Range[] arrayOfRange = (Range[])this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    ArrayList localArrayList = new ArrayList();
    if (arrayOfRange != null)
    {
      int m = arrayOfRange.length;
      int k = 0;
      while (k < m)
      {
        Range localRange = arrayOfRange[k];
        localArrayList.add(new int[] { ((Integer)localRange.getLower()).intValue(), ((Integer)localRange.getUpper()).intValue() });
        k += 1;
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        h();
        Camera2Utils.a(1, "[Camera2] setFocusDefaultMode!");
      }
      return;
    }
    catch (Exception localException)
    {
      Camera2Utils.a(2, "[Camera2] setFocusDefaultMode exp:" + localException);
    }
  }
  
  public void a(int paramInt)
  {
    Rect localRect1 = (Rect)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    int k = ((Float)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
    this.jdField_d_of_type_Int += paramInt;
    if (this.jdField_d_of_type_Int <= 0) {
      this.jdField_d_of_type_Int = 0;
    }
    float f1;
    int m;
    int n;
    int i1;
    for (;;)
    {
      f1 = this.jdField_d_of_type_Int / 100.0F;
      paramInt = localRect1.centerX();
      m = localRect1.centerY();
      n = (int)(localRect1.right - paramInt * f1 / 0.4F - 1.0F - (paramInt * f1 / 0.4F + 16.0F));
      i1 = (int)(localRect1.bottom - m * f1 / 0.4F - 1.0F - (m * f1 / 0.4F + 16.0F));
      if ((n >= localRect1.right / k) && (i1 >= localRect1.bottom / k)) {
        break;
      }
      Camera2Utils.a(1, "[Camera2] setZoom out of region!");
      return;
      if (this.jdField_d_of_type_Int >= 100) {
        this.jdField_d_of_type_Int = 100;
      }
    }
    Rect localRect2 = new Rect((int)(paramInt * f1 / 0.4F + 40.0F), (int)(m * f1 / 0.4F + 40.0F), localRect1.right - (int)(paramInt * f1 / 0.4F) - 1, localRect1.bottom - (int)(f1 * m / 0.4F) - 1);
    Camera2Utils.a(1, "[Camera2] setZoom mZoomValue:" + this.jdField_d_of_type_Int + ", realRadio:" + k + ", minWidth:" + n + ", minHeight:" + i1 + ", rect:" + localRect1.toString() + ", destRect:" + localRect2.toString());
    this.jdField_b_of_type_AndroidGraphicsRect = localRect2;
    this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.SCALER_CROP_REGION, localRect2);
    h();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.acquire();
      if ((this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) || (!this.jdField_f_of_type_Boolean))
      {
        Camera2Utils.a(2, "[Camera2] startPreview mCameraDevice null!");
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener.a(-203);
        }
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        return;
      }
      if (paramSurfaceTexture == null)
      {
        Camera2Utils.a(2, "[Camera2] startPreview params exception!");
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener.a(-203);
        }
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        return;
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      Camera2Utils.a(2, "[Camera2]startPreview exception:" + paramSurfaceTexture);
      this.h = false;
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener.a(-202);
        return;
        b(paramSurfaceTexture);
        g();
        k();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setDefaultBufferSize(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int);
        paramSurfaceTexture = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(3);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(paramSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(this.jdField_b_of_type_AndroidMediaImageReader.getSurface());
        Camera2Control.2 local2 = new Camera2Control.2(this);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.createSessionConfiguration(Arrays.asList(new OutputConfiguration[] { new OutputConfiguration(paramSurfaceTexture), new OutputConfiguration(this.jdField_b_of_type_AndroidMediaImageReader.getSurface()) }), local2, this.jdField_a_of_type_AndroidOsHandler));
          return;
        }
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(Arrays.asList(new Surface[] { paramSurfaceTexture, this.jdField_b_of_type_AndroidMediaImageReader.getSurface(), this.jdField_a_of_type_AndroidMediaImageReader.getSurface() }), local2, this.jdField_a_of_type_AndroidOsHandler);
      }
    }
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback)
  {
    this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = paramPreviewCallback;
  }
  
  public void a(Camera2Control.Camera2Listener paramCamera2Listener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener = paramCamera2Listener;
  }
  
  public void a(Camera2Control.Camera2PictureData paramCamera2PictureData)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      Camera2Utils.a(2, "[Camera2] camera not open");
      return;
    }
    if (this.j)
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
    this.j = true;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2PictureData = paramCamera2PictureData;
    if (this.i)
    {
      Camera2Utils.a(1, "[Camera2] takePicture AutoFocusing!");
      d();
      return;
    }
    i();
  }
  
  public void a(CameraControl.CustomSize paramCustomSize)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("[Camera2]setDarkModeSize:");
      if (paramCustomSize == null) {
        break label49;
      }
    }
    label49:
    for (String str = paramCustomSize.toString();; str = "")
    {
      QLog.i("Camera2Control", 2, str);
      this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
      return;
    }
  }
  
  public void a(CameraProxy.FocusData paramFocusData)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    if ((!this.h) || (this.i))
    {
      Camera2Utils.a(2, "[Camera2] autoFocus not preview, mPreview:" + this.h + ", mIsAutoFocusing:" + this.i);
      return;
    }
    this.i = true;
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    Object localObject = a(paramFocusData);
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.setTag(paramFocusData);
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (this.jdField_a_of_type_Boolean)
        {
          paramFocusData = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
          ((CameraCaptureSession)localObject).setRepeatingRequest(paramFocusData, this.jdField_b_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback, this.jdField_a_of_type_AndroidOsHandler);
          return;
        }
      }
      catch (Exception paramFocusData)
      {
        Camera2Utils.a(2, "[Camera2] autoFocus e:" + paramFocusData);
        paramFocusData.printStackTrace();
        return;
      }
      paramFocusData = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.h) || (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder == null))
    {
      Camera2Utils.a(1, "[Camera2]setFlashOn error status!");
      return;
    }
    if ((paramBoolean) && (this.jdField_e_of_type_Int != 2))
    {
      this.jdField_e_of_type_Int = 2;
      bool = true;
    }
    for (;;)
    {
      Camera2Utils.a(1, "[Camera2]setFlashOn: " + paramBoolean + ", mode:" + this.jdField_e_of_type_Int + ", needUpdateView:" + bool);
      if ((!bool) || (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder == null)) {
        break;
      }
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.jdField_e_of_type_Int));
      h();
      return;
      if (!paramBoolean)
      {
        this.jdField_e_of_type_Int = 0;
        bool = true;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = a().a();
    if (localObject == null) {
      QLog.e("Camera2Control", 1, "[Camera2]getPreviewFps error, listPreviewFpsRange null");
    }
    do
    {
      return false;
      localObject = a((List)localObject, paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("Camera2Control", 2, "setParamsPreviewFps[fps_wanted=" + paramInt + " force=false]");
      }
      if ((localObject != null) && (localObject.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Camera2Control", 2, "setParamsPreviewFps[getFpsRange=null]");
    return false;
    this.jdField_a_of_type_AndroidUtilRange = new Range(Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]));
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setPreviewFps:[" + localObject[0] + " " + localObject[1] + "]");
    }
    return true;
  }
  
  public boolean a(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize == null) || (paramCustomSize.jdField_a_of_type_Int <= 0) || (paramCustomSize.jdField_b_of_type_Int <= 0))
    {
      Camera2Utils.a(2, "[Camera2] setPreviewSize params error!");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setPreviewSize:" + paramCustomSize.toString());
    }
    return true;
  }
  
  public boolean a(CameraProxy.ParamCamera2Cache paramParamCamera2Cache)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      Camera2Utils.a(2, "[Camera2] setCamera2ParamOnce mIsOpened:" + this.jdField_f_of_type_Boolean);
      return false;
    }
    if ((paramParamCamera2Cache == null) || (paramParamCamera2Cache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null) || (paramParamCamera2Cache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null) || (paramParamCamera2Cache.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null))
    {
      Camera2Utils.a(2, "[Camera2] setCamera2ParamOnce error!");
      return false;
    }
    Camera2Utils.a(1, "[Camera2] setCamera2ParamOnce!");
    a(paramParamCamera2Cache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
    b(paramParamCamera2Cache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
    a(paramParamCamera2Cache.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
    return true;
  }
  
  public CameraControl.CustomSize b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
        h();
        Camera2Utils.a(1, "[Camera2] setFocusRecordMode!");
      }
      return;
    }
    catch (Exception localException)
    {
      Camera2Utils.a(2, "[Camera2] setFocusRecordMode exp:" + localException);
    }
  }
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
  }
  
  public void b(CameraControl.CustomSize paramCustomSize)
  {
    for (;;)
    {
      int k;
      try
      {
        Object localObject = (StreamConfigurationMap)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject != null)
        {
          Size[] arrayOfSize = ((StreamConfigurationMap)localObject).getOutputSizes(35);
          if (arrayOfSize != null)
          {
            localObject = arrayOfSize[0];
            int m = arrayOfSize.length;
            k = 0;
            if (k < m)
            {
              Size localSize = arrayOfSize[k];
              if ((localSize.getHeight() < paramCustomSize.jdField_b_of_type_Int / 3) || (localSize.getHeight() * localSize.getWidth() >= ((Size)localObject).getWidth() * ((Size)localObject).getHeight())) {
                break label145;
              }
              localObject = localSize;
              break label145;
            }
            a(new CameraControl.CustomSize(((Size)localObject).getWidth(), ((Size)localObject).getHeight()));
          }
        }
        if (this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize == null) {
          a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
        }
        return;
      }
      catch (Exception paramCustomSize)
      {
        return;
      }
      label145:
      k += 1;
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public boolean b(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize == null) || (paramCustomSize.jdField_a_of_type_Int <= 0) || (paramCustomSize.jdField_b_of_type_Int <= 0))
    {
      Camera2Utils.a(2, "[Camera2] setRawPictureSize params error!");
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
    if (QLog.isColorLevel()) {
      QLog.i("Camera2Control", 2, "[Camera2]setRawPictureSize:" + paramCustomSize.toString());
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null)
    {
      Camera2Utils.a(2, "[Camera2] stopRecordVideo device null!");
      return;
    }
    this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    h();
  }
  
  public void d()
  {
    try
    {
      Camera2Utils.a(1, "[Camera2]captureStillPicture request!");
      if (this.jdField_a_of_type_Long > 0L)
      {
        Camera2Utils.a(1, "[Camera2]captureStillPicture on id:" + this.jdField_a_of_type_Long);
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(2);
        ((CaptureRequest.Builder)localObject).addTarget(this.jdField_a_of_type_AndroidMediaImageReader.getSurface());
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        if (this.jdField_e_of_type_Int > -1) {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.jdField_e_of_type_Int));
        }
        if (this.jdField_b_of_type_AndroidGraphicsRect != null) {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.SCALER_CROP_REGION, this.jdField_b_of_type_AndroidGraphicsRect);
        }
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        Camera2Control.6 local6 = new Camera2Control.6(this);
        this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.capture(((CaptureRequest.Builder)localObject).build(), local6, null);
        return;
      }
      Object localObject = new ArrayList();
      ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4)));
      if (this.jdField_e_of_type_Int > -1) {
        ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.FLASH_MODE, Integer.valueOf(this.jdField_e_of_type_Int)));
      }
      if (this.jdField_b_of_type_AndroidGraphicsRect != null) {
        ((List)localObject).add(new SCameraCaptureProcessor.CaptureParameter(CaptureRequest.SCALER_CROP_REGION, this.jdField_b_of_type_AndroidGraphicsRect));
      }
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.capture(this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession, new Camera2Control.7(this, l), null, (List)localObject);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void e()
  {
    try
    {
      if (this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor != null)
      {
        this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.deinitialize();
        this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.acquire();
      k();
      if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.close();
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener = null;
      }
      if (this.jdField_a_of_type_AndroidMediaImageReader != null)
      {
        this.jdField_a_of_type_AndroidMediaImageReader.close();
        this.jdField_a_of_type_AndroidMediaImageReader = null;
      }
      if (this.jdField_b_of_type_AndroidMediaImageReader != null)
      {
        this.jdField_b_of_type_AndroidMediaImageReader.close();
        this.jdField_b_of_type_AndroidMediaImageReader = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info = null;
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback != null) {
        this.jdField_a_of_type_AndroidHardwareCamera$PreviewCallback = null;
      }
      if (this.jdField_b_of_type_AndroidGraphicsRect != null) {
        this.jdField_b_of_type_AndroidGraphicsRect = null;
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest != null) {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest = null;
      }
      if (this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest != null) {
        this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest = null;
      }
      if (this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback != null) {
        this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = null;
      }
      m();
      this.jdField_d_of_type_Int = -1;
      this.jdField_e_of_type_Int = -1;
      this.jdField_f_of_type_Boolean = false;
      this.h = false;
      this.j = false;
      this.i = false;
      this.jdField_a_of_type_Long = 0L;
      Camera2Utils.a(1, "[Camera2]closeCamera2!");
      return;
    }
    catch (Exception localException)
    {
      this.jdField_f_of_type_Boolean = false;
      this.h = false;
      this.j = false;
      this.i = false;
      Camera2Utils.a(1, "[Camera2]closeCamera2 exception:" + localException);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control
 * JD-Core Version:    0.7.0.1
 */