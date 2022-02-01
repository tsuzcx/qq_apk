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
  private static int jdField_a_of_type_Int = -1;
  private static Camera2Control jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
  public static String a;
  private static HashMap<String, Camera2Control.Camera2Info> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static int jdField_b_of_type_Int = 0;
  private static String jdField_b_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean = false;
  private static String jdField_c_of_type_JavaLangString = "";
  private static boolean jdField_c_of_type_Boolean = false;
  private static boolean jdField_d_of_type_Boolean = false;
  private static boolean jdField_e_of_type_Boolean = false;
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
  
  public Camera2Control()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static int a()
  {
    if (jdField_d_of_type_Boolean) {
      return jdField_a_of_type_Int;
    }
    int n = -2;
    int k = n;
    if (Build.VERSION.SDK_INT >= 23)
    {
      CameraManager localCameraManager = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      int m = n;
      try
      {
        String[] arrayOfString = localCameraManager.getCameraIdList();
        m = n;
        k = n;
        if (arrayOfString.length > 0)
        {
          m = n;
          int i2 = arrayOfString.length;
          int i1 = 0;
          for (;;)
          {
            k = n;
            if (i1 >= i2) {
              break;
            }
            m = n;
            Object localObject1 = localCameraManager.getCameraCharacteristics(arrayOfString[i1]);
            m = n;
            Object localObject2 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_FACING);
            if (localObject2 != null)
            {
              m = n;
              if (((Integer)localObject2).intValue() == 2)
              {
                k = n;
                break label231;
              }
            }
            m = n;
            localObject1 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            m = n;
            localObject2 = new StringBuilder();
            m = n;
            ((StringBuilder)localObject2).append("[Camera2]initCamera2SupportLevel supportLevel:");
            m = n;
            ((StringBuilder)localObject2).append(localObject1);
            m = n;
            Camera2Utils.a(1, ((StringBuilder)localObject2).toString());
            if (localObject1 == null)
            {
              k = -1;
              break;
            }
            m = n;
            n = ((Integer)localObject1).intValue();
            m = n;
            k = n;
            if (((Integer)localObject1).intValue() == 1) {
              break;
            }
            m = n;
            int i3 = ((Integer)localObject1).intValue();
            k = n;
            if (i3 == 3)
            {
              k = n;
              break;
            }
            label231:
            i1 += 1;
            n = k;
          }
        }
        jdField_a_of_type_Int = k;
      }
      catch (Throwable localThrowable)
      {
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.e("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", localThrowable);
          k = m;
        }
      }
    }
    jdField_d_of_type_Boolean = true;
    return jdField_a_of_type_Int;
  }
  
  private int a(int paramInt)
  {
    int m = 0;
    int k = m;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            k = m;
          } else {
            k = 270;
          }
        }
        else {
          k = 180;
        }
      }
      else {
        k = 90;
      }
    }
    return (((Integer)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - k + 360) % 360;
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
    if (jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control == null) {
          jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control = new Camera2Control();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return jdField_b_of_type_JavaLangString;
      }
      if (d()) {
        return jdField_b_of_type_JavaLangString;
      }
    }
    else if (c())
    {
      return jdField_c_of_type_JavaLangString;
    }
    return "1";
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info = ((Camera2Control.Camera2Info)jdField_a_of_type_JavaUtilHashMap.get(paramString));
    }
  }
  
  public static boolean a()
  {
    if (jdField_c_of_type_Boolean) {
      return jdField_b_of_type_Boolean;
    }
    int k = a();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (k != 1) {
      if (k == 3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    jdField_b_of_type_Boolean = bool1;
    return jdField_b_of_type_Boolean;
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
      int k = localObject2[1] - localObject2[0];
      if (k > paramInt)
      {
        localObject1 = localObject2;
        paramInt = k;
      }
    }
    if (localObject1 != null) {
      return localObject1;
    }
    return a(paramList);
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
    try
    {
      if ((!VersionUtils.k()) || (!a())) {
        break label261;
      }
      localObject = (CameraManager)BaseApplicationImpl.getApplication().getSystemService("camera");
      arrayOfString = ((CameraManager)localObject).getCameraIdList();
      m = arrayOfString.length;
      k = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String[] arrayOfString;
        int m;
        int k;
        String str;
        CameraCharacteristics localCameraCharacteristics;
        Integer localInteger;
        label261:
        continue;
        k += 1;
      }
    }
    if (k < m)
    {
      str = arrayOfString[k];
      localCameraCharacteristics = ((CameraManager)localObject).getCameraCharacteristics(str);
      localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
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
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]initCamera2Ability front:");
      ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", back:");
      ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
      break label261;
      jdField_b_of_type_Int = 1;
      jdField_b_of_type_JavaLangString = "1";
      Camera2Utils.a(2, "[Camera2]initCamera2Ability exception!");
      jdField_e_of_type_Boolean = true;
      return;
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
    try
    {
      localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      CaptureRequest localCaptureRequest;
      if (this.jdField_a_of_type_Boolean) {
        localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
      } else {
        localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
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
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CaptureStateCallBack.a(1);
      CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      CaptureRequest localCaptureRequest;
      if (this.jdField_a_of_type_Boolean) {
        localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
      } else {
        localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
      }
      localCameraCaptureSession.capture(localCaptureRequest, this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2CaptureStateCallBack, this.jdField_a_of_type_AndroidOsHandler);
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
      CaptureRequest localCaptureRequest;
      if (this.jdField_a_of_type_Boolean) {
        localCaptureRequest = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
      } else {
        localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
      }
      localCameraCaptureSession.capture(localCaptureRequest, null, null);
      localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
      if (this.jdField_a_of_type_Boolean) {
        localCaptureRequest = this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;
      } else {
        localCaptureRequest = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
      }
      localCameraCaptureSession.setRepeatingRequest(localCaptureRequest, null, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  private void k()
  {
    CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
    if (localCameraCaptureSession != null)
    {
      localCameraCaptureSession.close();
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
    if ((DeviceInfoUtil.i()) && (Build.VERSION.SDK_INT >= 28)) {}
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString)))
        {
          boolean bool2 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), jdField_c_of_type_JavaLangString, 1);
          boolean bool3 = SCamera.getInstance().isFeatureEnabled(BaseApplicationImpl.getApplication(), jdField_b_of_type_JavaLangString, 1);
          if ((!bool2) || (!bool3)) {
            break label279;
          }
          bool1 = true;
          this.jdField_a_of_type_Boolean = bool1;
          Size localSize = (Size)Collections.max(Arrays.asList(((StreamConfigurationMap)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256)), new Camera2Control.CompareSizesByArea());
          if (this.jdField_a_of_type_Boolean)
          {
            this.jdField_f_of_type_Int = (localSize.getHeight() * localSize.getWidth());
            this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor = SCameraCaptureProcessor.getInstance();
            this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.initialize(BaseApplicationImpl.getApplication(), jdField_a_of_type_JavaLangString, localSize);
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
        this.jdField_a_of_type_Boolean = false;
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
    if ((!this.jdField_f_of_type_Boolean) && (!this.g))
    {
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
        if (this.jdField_a_of_type_JavaUtilConcurrentSemaphore.tryAcquire(2500L, TimeUnit.MILLISECONDS))
        {
          String str = a(paramInt);
          jdField_a_of_type_JavaLangString = str;
          a(str);
          n();
          localObject = new Camera2Control.1(this, l);
          AEQLog.b("Camera2Control", "【Camera2 Open】");
          paramCamera2Listener = (Camera2Control.Camera2Listener)localObject;
          if (this.jdField_a_of_type_Boolean) {
            paramCamera2Listener = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.createStateCallback((CameraDevice.StateCallback)localObject, this.jdField_a_of_type_AndroidOsHandler);
          }
          localCameraManager.openCamera(str, paramCamera2Listener, this.jdField_a_of_type_AndroidOsHandler);
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
        this.jdField_f_of_type_Boolean = false;
        this.g = false;
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice = null;
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        paramCamera2Listener = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener;
        if (paramCamera2Listener != null) {
          paramCamera2Listener.a(-102);
        }
        return 0;
      }
    }
    Camera2Utils.a(2, "[Camera2]openCamera2 hasOpened!");
    return -104;
  }
  
  public Rect a(CameraProxy.FocusData paramFocusData)
  {
    if ((paramFocusData != null) && (paramFocusData.a != null))
    {
      double d6 = paramFocusData.a.jdField_a_of_type_Float;
      double d4 = paramFocusData.a.jdField_b_of_type_Float;
      paramFocusData.a.jdField_c_of_type_Int = a(paramFocusData.a.jdField_c_of_type_Int);
      int k = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
      int m = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
      if ((90 == paramFocusData.a.jdField_c_of_type_Int) || (270 == paramFocusData.a.jdField_c_of_type_Int))
      {
        k = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
        m = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
      }
      int n = paramFocusData.a.jdField_a_of_type_Int;
      int i1 = paramFocusData.a.jdField_b_of_type_Int;
      double d5 = 0.0D;
      if (n * m > i1 * k)
      {
        d1 = paramFocusData.a.jdField_a_of_type_Int;
        Double.isNaN(d1);
        d2 = k;
        Double.isNaN(d2);
        d2 = d1 * 1.0D / d2;
        d1 = m;
        d3 = paramFocusData.a.jdField_b_of_type_Int;
        Double.isNaN(d3);
        d3 /= d2;
        Double.isNaN(d1);
        d3 = (d1 - d3) / 2.0D;
        d1 = 0.0D;
      }
      else
      {
        d1 = paramFocusData.a.jdField_b_of_type_Int;
        Double.isNaN(d1);
        d2 = m;
        Double.isNaN(d2);
        d2 = d1 * 1.0D / d2;
        d1 = k;
        d3 = paramFocusData.a.jdField_a_of_type_Int;
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
      if (90 == paramFocusData.a.jdField_c_of_type_Int)
      {
        d3 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
        Double.isNaN(d3);
        d1 = d3 - d1;
      }
      else if (270 == paramFocusData.a.jdField_c_of_type_Int)
      {
        d3 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
        Double.isNaN(d3);
        d2 = d3 - d2;
      }
      else
      {
        d3 = d2;
        d2 = d1;
        d1 = d3;
      }
      if (this.jdField_a_of_type_Boolean) {
        paramFocusData = this.jdField_b_of_type_AndroidHardwareCamera2CaptureRequest;
      } else {
        paramFocusData = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
      }
      Rect localRect = (Rect)paramFocusData.get(CaptureRequest.SCALER_CROP_REGION);
      paramFocusData = localRect;
      if (localRect == null)
      {
        Camera2Utils.a(2, "[Camera2]getMeteringRect can't get crop region");
        paramFocusData = this.jdField_a_of_type_AndroidGraphicsRect;
      }
      k = paramFocusData.width();
      m = paramFocusData.height();
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int * k > this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int * m)
      {
        d3 = m;
        Double.isNaN(d3);
        d4 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
        Double.isNaN(d4);
        d3 = d3 * 1.0D / d4;
        d4 = k;
        d5 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
        Double.isNaN(d5);
        Double.isNaN(d4);
        d5 = (d4 - d5 * d3) / 2.0D;
        d4 = 0.0D;
      }
      else
      {
        d3 = k;
        Double.isNaN(d3);
        d4 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int;
        Double.isNaN(d4);
        d3 = d3 * 1.0D / d4;
        d4 = m;
        d6 = this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int;
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
    if ((paramCustomSize != null) && (paramCustomSize.jdField_a_of_type_Int > 0) && (paramCustomSize.jdField_b_of_type_Int > 0))
    {
      b(paramCustomSize);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setViewSize:");
        localStringBuilder.append(paramCustomSize.toString());
        QLog.i("Camera2Control", 2, localStringBuilder.toString());
      }
      return this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize;
    }
    Camera2Utils.a(2, "[Camera2] setViewSize params error!");
    return null;
  }
  
  public List<int[]> a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info;
    if ((localObject1 != null) && (((Camera2Control.Camera2Info)localObject1).a()))
    {
      localObject1 = (Range[])this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        int m = localObject1.length;
        int k = 0;
        while (k < m)
        {
          Object localObject2 = localObject1[k];
          localArrayList.add(new int[] { ((Integer)localObject2.getLower()).intValue(), ((Integer)localObject2.getUpper()).intValue() });
          k += 1;
        }
      }
      return localArrayList;
    }
    QLog.e("Camera2Control", 1, new Object[] { "[Camera2]getPreviewFps error, camera2Info: ", this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info });
    return null;
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
  
  public void a(int paramInt)
  {
    Rect localRect1 = (Rect)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    int k = ((Float)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
    this.jdField_d_of_type_Int += paramInt;
    paramInt = this.jdField_d_of_type_Int;
    if (paramInt <= 0) {
      this.jdField_d_of_type_Int = 0;
    } else if (paramInt >= 100) {
      this.jdField_d_of_type_Int = 100;
    }
    float f2 = this.jdField_d_of_type_Int / 100.0F;
    int m = localRect1.centerX();
    paramInt = localRect1.centerY();
    float f3 = localRect1.right;
    float f1 = m * f2 / 0.4F;
    m = (int)(f3 - f1 - 1.0F - (f1 + 16.0F));
    f3 = localRect1.bottom;
    f2 = f2 * paramInt / 0.4F;
    paramInt = (int)(f3 - f2 - 1.0F - (16.0F + f2));
    if ((m >= localRect1.right / k) && (paramInt >= localRect1.bottom / k))
    {
      Rect localRect2 = new Rect((int)(f1 + 40.0F), (int)(40.0F + f2), localRect1.right - (int)f1 - 1, localRect1.bottom - (int)f2 - 1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Camera2] setZoom mZoomValue:");
      localStringBuilder.append(this.jdField_d_of_type_Int);
      localStringBuilder.append(", realRadio:");
      localStringBuilder.append(k);
      localStringBuilder.append(", minWidth:");
      localStringBuilder.append(m);
      localStringBuilder.append(", minHeight:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", rect:");
      localStringBuilder.append(localRect1.toString());
      localStringBuilder.append(", destRect:");
      localStringBuilder.append(localRect2.toString());
      Camera2Utils.a(1, localStringBuilder.toString());
      this.jdField_b_of_type_AndroidGraphicsRect = localRect2;
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.SCALER_CROP_REGION, localRect2);
      h();
      return;
    }
    Camera2Utils.a(1, "[Camera2] setZoom out of region!");
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.acquire();
      if ((this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice != null) && (this.jdField_f_of_type_Boolean))
      {
        if (paramSurfaceTexture == null)
        {
          Camera2Utils.a(2, "[Camera2] startPreview params exception!");
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener.a(-203);
          }
          this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
          return;
        }
        b(paramSurfaceTexture);
        g();
        k();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setDefaultBufferSize(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize.jdField_b_of_type_Int);
        paramSurfaceTexture = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(3);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(paramSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(this.jdField_b_of_type_AndroidMediaImageReader.getSurface());
        localObject = new Camera2Control.2(this);
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.createSessionConfiguration(Arrays.asList(new OutputConfiguration[] { new OutputConfiguration(paramSurfaceTexture), new OutputConfiguration(this.jdField_b_of_type_AndroidMediaImageReader.getSurface()) }), (CameraCaptureSession.StateCallback)localObject, this.jdField_a_of_type_AndroidOsHandler));
          return;
        }
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(Arrays.asList(new Surface[] { paramSurfaceTexture, this.jdField_b_of_type_AndroidMediaImageReader.getSurface(), this.jdField_a_of_type_AndroidMediaImageReader.getSurface() }), (CameraCaptureSession.StateCallback)localObject, this.jdField_a_of_type_AndroidOsHandler);
        return;
      }
      Camera2Utils.a(2, "[Camera2] startPreview mCameraDevice null!");
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener.a(-203);
      }
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]startPreview exception:");
      ((StringBuilder)localObject).append(paramSurfaceTexture);
      Camera2Utils.a(2, ((StringBuilder)localObject).toString());
      this.h = false;
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      paramSurfaceTexture = this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.a(-202);
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
    this.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
  }
  
  public void a(CameraProxy.FocusData paramFocusData)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    if ((this.h) && (!this.i))
    {
      this.i = true;
      this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
      Object localObject = a(paramFocusData);
      if (localObject != null) {}
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.setTag(paramFocusData);
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
        if (this.jdField_a_of_type_Boolean) {
          paramFocusData = this.jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor.buildCaptureRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder);
        } else {
          paramFocusData = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build();
        }
        ((CameraCaptureSession)localObject).setRepeatingRequest(paramFocusData, this.jdField_b_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback, this.jdField_a_of_type_AndroidOsHandler);
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
    paramFocusData.append(this.h);
    paramFocusData.append(", mIsAutoFocusing:");
    paramFocusData.append(this.i);
    Camera2Utils.a(2, paramFocusData.toString());
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.h) && (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null))
    {
      boolean bool = false;
      if ((paramBoolean) && (this.jdField_e_of_type_Int != 2))
      {
        this.jdField_e_of_type_Int = 2;
      }
      else
      {
        if (paramBoolean) {
          break label50;
        }
        this.jdField_e_of_type_Int = 0;
      }
      bool = true;
      label50:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]setFlashOn: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", mode:");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append(", needUpdateView:");
      ((StringBuilder)localObject).append(bool);
      Camera2Utils.a(1, ((StringBuilder)localObject).toString());
      if (bool)
      {
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder;
        if (localObject != null)
        {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.jdField_e_of_type_Int));
          h();
        }
      }
      return;
    }
    Camera2Utils.a(1, "[Camera2]setFlashOn error status!");
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = a().a();
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
      this.jdField_a_of_type_AndroidUtilRange = new Range(Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]));
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
  
  public boolean a(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize != null) && (paramCustomSize.jdField_a_of_type_Int > 0) && (paramCustomSize.jdField_b_of_type_Int > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
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
  
  public boolean a(CameraProxy.ParamCamera2Cache paramParamCamera2Cache)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      paramParamCamera2Cache = new StringBuilder();
      paramParamCamera2Cache.append("[Camera2] setCamera2ParamOnce mIsOpened:");
      paramParamCamera2Cache.append(this.jdField_f_of_type_Boolean);
      Camera2Utils.a(2, paramParamCamera2Cache.toString());
      return false;
    }
    if ((paramParamCamera2Cache != null) && (paramParamCamera2Cache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize != null) && (paramParamCamera2Cache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize != null) && (paramParamCamera2Cache.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize != null))
    {
      Camera2Utils.a(1, "[Camera2] setCamera2ParamOnce!");
      a(paramParamCamera2Cache.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
      b(paramParamCamera2Cache.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
      a(paramParamCamera2Cache.jdField_c_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize);
      return true;
    }
    Camera2Utils.a(2, "[Camera2] setCamera2ParamOnce error!");
    return false;
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
  
  public void b(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
  }
  
  public void b(CameraControl.CustomSize paramCustomSize)
  {
    for (;;)
    {
      int k;
      Object localObject2;
      try
      {
        localObject1 = (StreamConfigurationMap)this.jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 != null)
        {
          Size[] arrayOfSize = ((StreamConfigurationMap)localObject1).getOutputSizes(35);
          if (arrayOfSize != null)
          {
            k = 0;
            localObject1 = arrayOfSize[0];
            int m = arrayOfSize.length;
            if (k < m)
            {
              Size localSize = arrayOfSize[k];
              localObject2 = localObject1;
              if (localSize.getHeight() < paramCustomSize.jdField_b_of_type_Int / 3) {
                break label153;
              }
              localObject2 = localObject1;
              if (localSize.getHeight() * localSize.getWidth() >= ((Size)localObject1).getWidth() * ((Size)localObject1).getHeight()) {
                break label153;
              }
              localObject2 = localSize;
              break label153;
            }
            a(new CameraControl.CustomSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()));
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
      label153:
      k += 1;
      Object localObject1 = localObject2;
    }
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public boolean b(CameraControl.CustomSize paramCustomSize)
  {
    if ((paramCustomSize != null) && (paramCustomSize.jdField_a_of_type_Int > 0) && (paramCustomSize.jdField_b_of_type_Int > 0))
    {
      this.jdField_b_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl$CustomSize = paramCustomSize;
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
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]captureStillPicture on id:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        Camera2Utils.a(1, ((StringBuilder)localObject).toString());
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
  
  /* Error */
  public void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 237	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 237	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor;
    //   11: invokevirtual 938	com/samsung/android/sdk/camera/SCameraCaptureProcessor:deinitialize	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 237	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComSamsungAndroidSdkCameraSCameraCaptureProcessor	Lcom/samsung/android/sdk/camera/SCameraCaptureProcessor;
    //   19: aload_0
    //   20: getfield 93	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   23: invokevirtual 744	java/util/concurrent/Semaphore:acquire	()V
    //   26: aload_0
    //   27: invokespecial 752	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:k	()V
    //   30: aload_0
    //   31: getfield 222	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraDevice	Landroid/hardware/camera2/CameraDevice;
    //   34: ifnull +15 -> 49
    //   37: aload_0
    //   38: getfield 222	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraDevice	Landroid/hardware/camera2/CameraDevice;
    //   41: invokevirtual 939	android/hardware/camera2/CameraDevice:close	()V
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 222	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraDevice	Landroid/hardware/camera2/CameraDevice;
    //   49: aload_0
    //   50: getfield 596	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Listener;
    //   53: ifnull +8 -> 61
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 596	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Listener	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Listener;
    //   61: aload_0
    //   62: getfield 360	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   65: ifnull +15 -> 80
    //   68: aload_0
    //   69: getfield 360	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   72: invokevirtual 940	android/media/ImageReader:close	()V
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 360	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   80: aload_0
    //   81: getfield 371	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   84: ifnull +15 -> 99
    //   87: aload_0
    //   88: getfield 371	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   91: invokevirtual 940	android/media/ImageReader:close	()V
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 371	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   99: aload_0
    //   100: getfield 754	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   103: ifnull +8 -> 111
    //   106: aload_0
    //   107: aconst_null
    //   108: putfield 754	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   111: aload_0
    //   112: getfield 200	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;
    //   115: ifnull +8 -> 123
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 200	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_ComTencentMobileqqShortvideoCamera2Camera2Control$Camera2Info	Lcom/tencent/mobileqq/shortvideo/camera2/Camera2Control$Camera2Info;
    //   123: aload_0
    //   124: getfield 215	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera$PreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   127: ifnull +8 -> 135
    //   130: aload_0
    //   131: aconst_null
    //   132: putfield 215	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera$PreviewCallback	Landroid/hardware/Camera$PreviewCallback;
    //   135: aload_0
    //   136: getfield 84	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   139: ifnull +8 -> 147
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 84	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   147: aload_0
    //   148: getfield 313	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CaptureRequest	Landroid/hardware/camera2/CaptureRequest;
    //   151: ifnull +8 -> 159
    //   154: aload_0
    //   155: aconst_null
    //   156: putfield 313	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CaptureRequest	Landroid/hardware/camera2/CaptureRequest;
    //   159: aload_0
    //   160: getfield 228	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidHardwareCamera2CaptureRequest	Landroid/hardware/camera2/CaptureRequest;
    //   163: ifnull +8 -> 171
    //   166: aload_0
    //   167: aconst_null
    //   168: putfield 228	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_b_of_type_AndroidHardwareCamera2CaptureRequest	Landroid/hardware/camera2/CaptureRequest;
    //   171: aload_0
    //   172: getfield 942	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback	Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;
    //   175: ifnull +8 -> 183
    //   178: aload_0
    //   179: aconst_null
    //   180: putfield 942	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback	Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;
    //   183: aload_0
    //   184: invokespecial 944	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:m	()V
    //   187: aload_0
    //   188: iconst_m1
    //   189: putfield 82	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_d_of_type_Int	I
    //   192: aload_0
    //   193: iconst_m1
    //   194: putfield 86	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_e_of_type_Int	I
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 61	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_f_of_type_Boolean	Z
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 65	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:h	Z
    //   207: aload_0
    //   208: iconst_0
    //   209: putfield 71	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:j	Z
    //   212: aload_0
    //   213: iconst_0
    //   214: putfield 67	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:i	Z
    //   217: aload_0
    //   218: lconst_0
    //   219: putfield 73	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_Long	J
    //   222: iconst_1
    //   223: ldc_w 946
    //   226: invokestatic 184	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(ILjava/lang/String;)V
    //   229: goto +58 -> 287
    //   232: astore_1
    //   233: goto +62 -> 295
    //   236: astore_1
    //   237: aload_0
    //   238: iconst_0
    //   239: putfield 61	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_f_of_type_Boolean	Z
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 65	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:h	Z
    //   247: aload_0
    //   248: iconst_0
    //   249: putfield 71	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:j	Z
    //   252: aload_0
    //   253: iconst_0
    //   254: putfield 67	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:i	Z
    //   257: new 165	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   264: astore_2
    //   265: aload_2
    //   266: ldc_w 948
    //   269: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload_2
    //   274: aload_1
    //   275: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: iconst_1
    //   280: aload_2
    //   281: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 184	com/tencent/mobileqq/shortvideo/camera2/Camera2Utils:a	(ILjava/lang/String;)V
    //   287: aload_0
    //   288: getfield 93	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   291: invokevirtual 594	java/util/concurrent/Semaphore:release	()V
    //   294: return
    //   295: aload_0
    //   296: getfield 93	com/tencent/mobileqq/shortvideo/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   299: invokevirtual 594	java/util/concurrent/Semaphore:release	()V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.camera2.Camera2Control
 * JD-Core Version:    0.7.0.1
 */