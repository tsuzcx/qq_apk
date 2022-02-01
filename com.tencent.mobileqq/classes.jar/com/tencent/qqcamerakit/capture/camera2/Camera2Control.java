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
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
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
  public static int a = 0;
  private static Camera2Control jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control;
  public static String a;
  private static HashMap<String, Camera2Control.Camera2Info> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static boolean jdField_a_of_type_Boolean = false;
  private static String jdField_b_of_type_JavaLangString = "";
  private static boolean jdField_b_of_type_Boolean = false;
  private static int jdField_c_of_type_Int = -1;
  private static String jdField_c_of_type_JavaLangString = "";
  private static int jdField_d_of_type_Int;
  private float jdField_a_of_type_Float = 0.4F;
  private long jdField_a_of_type_Long = 0L;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private CameraCaptureSession.CaptureCallback jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback = new Camera2Control.6(this);
  private CameraCaptureSession jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
  private CameraDevice jdField_a_of_type_AndroidHardwareCamera2CameraDevice;
  private CaptureRequest.Builder jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder;
  private CaptureRequest jdField_a_of_type_AndroidHardwareCamera2CaptureRequest;
  private ImageReader jdField_a_of_type_AndroidMediaImageReader;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private Range<Integer> jdField_a_of_type_AndroidUtilRange;
  private CameraHandler.TakePictureData jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler$TakePictureData;
  private CameraPreviewCallBack jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack;
  private CameraSize jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize;
  private Camera2Control.Camera2Info jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info;
  public Camera2Control.Camera2Listener a;
  private CaptureStateCallBack jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2CaptureStateCallBack = new CaptureStateCallBack(this);
  private Semaphore jdField_a_of_type_JavaUtilConcurrentSemaphore = new Semaphore(1);
  public int b;
  private ImageReader jdField_b_of_type_AndroidMediaImageReader;
  private CameraSize jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize;
  private CameraSize jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = false;
  private boolean g = false;
  
  public Camera2Control()
  {
    this.jdField_b_of_type_Int = 100;
  }
  
  private int a(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            i = j;
          } else {
            i = 270;
          }
        }
        else {
          i = 180;
        }
      }
      else {
        i = 90;
      }
    }
    return (((Integer)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue() - i + 360) % 360;
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
    if (jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control == null) {
          jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control = new Camera2Control();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return jdField_b_of_type_JavaLangString;
      }
      if (b()) {
        return jdField_b_of_type_JavaLangString;
      }
    }
    else if (a())
    {
      return jdField_c_of_type_JavaLangString;
    }
    return "1";
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info = ((Camera2Control.Camera2Info)jdField_a_of_type_JavaUtilHashMap.get(paramString));
    }
  }
  
  public static boolean a()
  {
    f();
    return (jdField_d_of_type_Int > 0) && (!TextUtils.isEmpty(jdField_c_of_type_JavaLangString));
  }
  
  public static int b()
  {
    if (jdField_a_of_type_Boolean) {
      return jdField_c_of_type_Int;
    }
    int j = -2;
    int i = j;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 23)
    {
      CameraManager localCameraManager = (CameraManager)CameraProxy.a().getSystemService("camera");
      try
      {
        String[] arrayOfString = localCameraManager.getCameraIdList();
        i = j;
        if (arrayOfString.length <= 0) {
          break label281;
        }
        int n = arrayOfString.length;
        int k = 0;
        i = -2;
        for (;;)
        {
          j = i;
          if (k >= n) {
            break label279;
          }
          j = i;
          try
          {
            localObject1 = localCameraManager.getCameraCharacteristics(arrayOfString[k]);
            j = i;
            Object localObject2 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.LENS_FACING);
            if (localObject2 != null)
            {
              j = i;
              if (((Integer)localObject2).intValue() == 2)
              {
                m = i;
                break label238;
              }
            }
            j = i;
            localObject1 = (Integer)((CameraCharacteristics)localObject1).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            j = i;
            if (!QLog.a()) {
              break label293;
            }
            j = i;
            localObject2 = new StringBuilder();
            j = i;
            ((StringBuilder)localObject2).append("[Camera2]initCamera2SupportLevel supportLevel:");
            j = i;
            ((StringBuilder)localObject2).append(localObject1);
            j = i;
            QLog.c("Camera2Control", 2, new Object[] { ((StringBuilder)localObject2).toString() });
            break label293;
            j = i;
            i = ((Integer)localObject1).intValue();
            int m = i;
            j = i;
            if (((Integer)localObject1).intValue() != 1)
            {
              j = i;
              int i1 = ((Integer)localObject1).intValue();
              m = i;
              if (i1 != 3)
              {
                j = i;
                break label279;
              }
            }
            label238:
            k += 1;
            i = m;
          }
          catch (Throwable localThrowable1)
          {
            i = j;
          }
        }
        j = i;
      }
      catch (Throwable localThrowable2)
      {
        i = -2;
      }
      if (QLog.a())
      {
        QLog.a("Camera2Control", 2, "[Camera2]initCamera2SupportLevel exception:", localThrowable2);
        j = i;
      }
    }
    label279:
    for (i = j;; i = -1)
    {
      label281:
      jdField_c_of_type_Int = i;
      jdField_a_of_type_Boolean = true;
      return jdField_c_of_type_Int;
      label293:
      if (localObject1 != null) {
        break;
      }
    }
  }
  
  public static boolean b()
  {
    f();
    return (jdField_d_of_type_Int > 0) && (!TextUtils.isEmpty(jdField_b_of_type_JavaLangString));
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  private boolean d()
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
  
  private static void f()
  {
    if (jdField_b_of_type_Boolean) {
      return;
    }
    try
    {
      if (!c()) {
        break label271;
      }
      localObject = (CameraManager)CameraProxy.a().getSystemService("camera");
      arrayOfString = ((CameraManager)localObject).getCameraIdList();
      j = arrayOfString.length;
      i = 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String[] arrayOfString;
        int j;
        int i;
        String str;
        CameraCharacteristics localCameraCharacteristics;
        Integer localInteger;
        label271:
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      str = arrayOfString[i];
      localCameraCharacteristics = ((CameraManager)localObject).getCameraCharacteristics(str);
      localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
      if ((localInteger != null) && (localInteger.intValue() == 0) && ("1".equals(str)))
      {
        jdField_a_of_type_JavaUtilHashMap.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
        jdField_c_of_type_JavaLangString = str;
        jdField_d_of_type_Int += 1;
      }
      else if ((localInteger != null) && (localInteger.intValue() == 1) && ("0".equals(str)))
      {
        jdField_a_of_type_JavaUtilHashMap.put(str, new Camera2Control.Camera2Info(str, localCameraCharacteristics));
        jdField_b_of_type_JavaLangString = str;
        jdField_d_of_type_Int += 1;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[Camera2]initCamera2Ability front:");
      ((StringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(", back:");
      ((StringBuilder)localObject).append(jdField_b_of_type_JavaLangString);
      QLog.a("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
      break label271;
      jdField_d_of_type_Int = 1;
      jdField_b_of_type_JavaLangString = "1";
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2]initCamera2Ability exception!" });
      jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Camera2_Background_Thread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private void h()
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
  
  private void i()
  {
    CameraCaptureSession localCameraCaptureSession = this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession;
    if (localCameraCaptureSession != null)
    {
      localCameraCaptureSession.close();
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession = null;
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidMediaImageReader = ImageReader.newInstance(this.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int, this.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int, 256, 2);
    this.jdField_a_of_type_AndroidMediaImageReader.setOnImageAvailableListener(new Camera2Control.3(this), this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_b_of_type_AndroidMediaImageReader = ImageReader.newInstance(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int, 35, 2);
    this.jdField_b_of_type_AndroidMediaImageReader.setOnImageAvailableListener(new Camera2Control.4(this), null);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.setRepeatingRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build(), null, null);
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
  
  private void l()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2CaptureStateCallBack.a(1);
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.capture(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build(), this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2CaptureStateCallBack, this.jdField_a_of_type_AndroidOsHandler);
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      localCameraAccessException.printStackTrace();
    }
  }
  
  private void m()
  {
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.capture(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build(), null, null);
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.setRepeatingRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest, null, null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    Camera2Control.Camera2Info localCamera2Info = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info;
    if ((localCamera2Info != null) && (localCamera2Info.a != null)) {
      return ((Integer)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }
    QLog.a("Camera2Control", 1, new Object[] { "getCameraOrientation fail, return 0" });
    return 0;
  }
  
  public int a(int paramInt, Camera2Control.Camera2Listener paramCamera2Listener)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      boolean bool = d();
      int i = 5;
      if (bool)
      {
        if (QLog.a()) {
          QLog.c("Camera2Control", 2, new Object[] { "openCamera failed, camera disable" });
        }
        return 5;
      }
      this.jdField_d_of_type_Boolean = true;
      long l = System.currentTimeMillis();
      f();
      a(paramCamera2Listener);
      g();
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2]openCamera2" });
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentSemaphore.tryAcquire(2500L, TimeUnit.MILLISECONDS))
        {
          jdField_a_of_type_Int = paramInt;
          paramCamera2Listener = a(paramInt);
          jdField_a_of_type_JavaLangString = paramCamera2Listener;
          a(paramCamera2Listener);
          ((CameraManager)CameraProxy.a().getSystemService("camera")).openCamera(paramCamera2Listener, new Camera2Control.1(this, l), this.jdField_a_of_type_AndroidOsHandler);
          return 0;
        }
        throw new Exception("[Camera2]openCamera2 time out waiting to lock camera opening.");
      }
      catch (Exception paramCamera2Listener)
      {
        this.jdField_c_of_type_Boolean = false;
        this.jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice = null;
        this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]openCamera2 exception:");
        ((StringBuilder)localObject).append(paramCamera2Listener);
        QLog.a("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
        if ((paramCamera2Listener instanceof CameraAccessException)) {
          paramInt = i;
        } else if ((paramCamera2Listener instanceof IllegalArgumentException)) {
          paramInt = 9;
        } else if ((paramCamera2Listener instanceof SecurityException)) {
          paramInt = 8;
        } else {
          paramInt = 3;
        }
        localObject = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener;
        if (localObject != null) {
          ((Camera2Control.Camera2Listener)localObject).a(1, paramInt, paramCamera2Listener.getMessage(), new Object[0]);
        }
        return 0;
      }
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]openCamera2 hasOpened!" });
    return 6;
  }
  
  public Rect a(FocusOperator.CameraFocusParams paramCameraFocusParams)
  {
    if (paramCameraFocusParams == null) {
      return null;
    }
    double d6 = paramCameraFocusParams.jdField_a_of_type_Float;
    double d4 = paramCameraFocusParams.jdField_b_of_type_Float;
    paramCameraFocusParams.jdField_c_of_type_Int = a(paramCameraFocusParams.jdField_c_of_type_Int);
    int i = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int;
    if ((90 == paramCameraFocusParams.jdField_c_of_type_Int) || (270 == paramCameraFocusParams.jdField_c_of_type_Int))
    {
      i = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int;
      j = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int;
    }
    int k = paramCameraFocusParams.jdField_a_of_type_Int;
    int m = paramCameraFocusParams.jdField_b_of_type_Int;
    double d5 = 0.0D;
    if (k * j > m * i)
    {
      d1 = paramCameraFocusParams.jdField_a_of_type_Int;
      Double.isNaN(d1);
      d2 = i;
      Double.isNaN(d2);
      d2 = d1 * 1.0D / d2;
      d1 = j;
      d3 = paramCameraFocusParams.jdField_b_of_type_Int;
      Double.isNaN(d3);
      d3 /= d2;
      Double.isNaN(d1);
      d3 = (d1 - d3) / 2.0D;
      d1 = 0.0D;
    }
    else
    {
      d1 = paramCameraFocusParams.jdField_b_of_type_Int;
      Double.isNaN(d1);
      d2 = j;
      Double.isNaN(d2);
      d2 = d1 * 1.0D / d2;
      d1 = i;
      d3 = paramCameraFocusParams.jdField_a_of_type_Int;
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
    if (90 == paramCameraFocusParams.jdField_c_of_type_Int)
    {
      d3 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int;
      Double.isNaN(d3);
      d1 = d3 - d1;
    }
    else if (270 == paramCameraFocusParams.jdField_c_of_type_Int)
    {
      d3 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int;
      Double.isNaN(d3);
      d2 = d3 - d2;
    }
    else
    {
      d3 = d2;
      d2 = d1;
      d1 = d3;
    }
    Rect localRect = (Rect)this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest.get(CaptureRequest.SCALER_CROP_REGION);
    paramCameraFocusParams = localRect;
    if (localRect == null)
    {
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getMeteringRect can't get crop region" });
      paramCameraFocusParams = (Rect)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    }
    i = paramCameraFocusParams.width();
    j = paramCameraFocusParams.height();
    if (this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int * i > this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int * j)
    {
      d3 = j;
      Double.isNaN(d3);
      d4 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int;
      Double.isNaN(d4);
      d3 = d3 * 1.0D / d4;
      d4 = i;
      d5 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int;
      Double.isNaN(d5);
      Double.isNaN(d4);
      d5 = (d4 - d5 * d3) / 2.0D;
      d4 = 0.0D;
    }
    else
    {
      d3 = i;
      Double.isNaN(d3);
      d4 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int;
      Double.isNaN(d4);
      d3 = d3 * 1.0D / d4;
      d4 = j;
      d6 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int;
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
  
  public CameraCharacteristics a()
  {
    Camera2Control.Camera2Info localCamera2Info = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info;
    if (localCamera2Info != null) {
      return localCamera2Info.a;
    }
    return null;
  }
  
  public CameraSize a()
  {
    return this.jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize;
  }
  
  public CameraSize a(CameraSize paramCameraSize)
  {
    if ((paramCameraSize != null) && (paramCameraSize.jdField_a_of_type_Int > 0) && (paramCameraSize.jdField_b_of_type_Int > 0))
    {
      a(paramCameraSize);
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2]setViewSize:");
        localStringBuilder.append(paramCameraSize.toString());
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      return this.jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] setViewSize params error!" });
    return null;
  }
  
  public List<int[]> a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info;
    if ((localObject1 != null) && (((Camera2Control.Camera2Info)localObject1).a()))
    {
      localObject1 = (Range[])this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
      ArrayList localArrayList = new ArrayList();
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          localArrayList.add(new int[] { ((Integer)localObject2.getLower()).intValue(), ((Integer)localObject2.getUpper()).intValue() });
          i += 1;
        }
      }
      return localArrayList;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getPreviewFps error, camera2Info: ", this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info });
    return null;
  }
  
  public List<CameraSize> a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info;
    if ((localObject != null) && (((Camera2Control.Camera2Info)localObject).a()))
    {
      localObject = (StreamConfigurationMap)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
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
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        CameraSize localCameraSize = localObject[i];
        localCameraSize = new CameraSize(localCameraSize.getWidth(), localCameraSize.getHeight());
        localArrayList.add(localCameraSize);
        if (QLog.a()) {
          QLog.d("Camera2Control", 2, new Object[] { "getPreviewSizes, isJPEG: ", Boolean.valueOf(paramBoolean), " ", localCameraSize });
        }
        i += 1;
      }
      return localArrayList;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]getPreviewSizes error, camera2Info: ", this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info, " isJPEG: ", Boolean.valueOf(paramBoolean) });
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   4: invokevirtual 618	java/util/concurrent/Semaphore:acquire	()V
    //   7: aload_0
    //   8: invokespecial 620	com/tencent/qqcamerakit/capture/camera2/Camera2Control:i	()V
    //   11: aload_0
    //   12: getfield 131	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraDevice	Landroid/hardware/camera2/CameraDevice;
    //   15: ifnull +15 -> 30
    //   18: aload_0
    //   19: getfield 131	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraDevice	Landroid/hardware/camera2/CameraDevice;
    //   22: invokevirtual 623	android/hardware/camera2/CameraDevice:close	()V
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 131	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CameraDevice	Landroid/hardware/camera2/CameraDevice;
    //   30: aload_0
    //   31: getfield 463	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Listener;
    //   34: ifnull +8 -> 42
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 463	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Listener;
    //   42: aload_0
    //   43: getfield 349	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   46: ifnull +15 -> 61
    //   49: aload_0
    //   50: getfield 349	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   53: invokevirtual 624	android/media/ImageReader:close	()V
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 349	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   61: aload_0
    //   62: getfield 360	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_b_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   65: ifnull +15 -> 80
    //   68: aload_0
    //   69: getfield 360	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_b_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   72: invokevirtual 624	android/media/ImageReader:close	()V
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield 360	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_b_of_type_AndroidMediaImageReader	Landroid/media/ImageReader;
    //   80: aload_0
    //   81: getfield 626	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   84: ifnull +8 -> 92
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 626	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   92: aload_0
    //   93: getfield 101	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Info;
    //   96: ifnull +8 -> 104
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 101	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info	Lcom/tencent/qqcamerakit/capture/camera2/Camera2Control$Camera2Info;
    //   104: aload_0
    //   105: getfield 146	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack	Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;
    //   108: ifnull +8 -> 116
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 146	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack	Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;
    //   116: aload_0
    //   117: getfield 72	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   120: ifnull +8 -> 128
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 72	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   128: aload_0
    //   129: getfield 137	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CaptureRequest	Landroid/hardware/camera2/CaptureRequest;
    //   132: ifnull +8 -> 140
    //   135: aload_0
    //   136: aconst_null
    //   137: putfield 137	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_AndroidHardwareCamera2CaptureRequest	Landroid/hardware/camera2/CaptureRequest;
    //   140: aload_0
    //   141: invokespecial 628	com/tencent/qqcamerakit/capture/camera2/Camera2Control:h	()V
    //   144: aload_0
    //   145: iconst_m1
    //   146: putfield 70	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_e_of_type_Int	I
    //   149: aload_0
    //   150: iconst_m1
    //   151: putfield 74	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_f_of_type_Int	I
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 58	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_c_of_type_Boolean	Z
    //   159: aload_0
    //   160: iconst_0
    //   161: putfield 60	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_d_of_type_Boolean	Z
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 62	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_e_of_type_Boolean	Z
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 66	com/tencent/qqcamerakit/capture/camera2/Camera2Control:g	Z
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 64	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_f_of_type_Boolean	Z
    //   179: aload_0
    //   180: lconst_0
    //   181: putfield 68	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_Long	J
    //   184: ldc 239
    //   186: iconst_1
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: ldc_w 630
    //   196: aastore
    //   197: invokestatic 610	com/tencent/qqcamerakit/common/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   200: goto +67 -> 267
    //   203: astore_1
    //   204: goto +71 -> 275
    //   207: astore_1
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 58	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_c_of_type_Boolean	Z
    //   213: aload_0
    //   214: iconst_0
    //   215: putfield 62	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_e_of_type_Boolean	Z
    //   218: aload_0
    //   219: iconst_0
    //   220: putfield 66	com/tencent/qqcamerakit/capture/camera2/Camera2Control:g	Z
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 64	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_f_of_type_Boolean	Z
    //   228: new 227	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   235: astore_2
    //   236: aload_2
    //   237: ldc_w 632
    //   240: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_2
    //   245: aload_1
    //   246: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 239
    //   252: iconst_1
    //   253: iconst_1
    //   254: anewarray 4	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload_2
    //   260: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 293	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   267: aload_0
    //   268: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   271: invokevirtual 455	java/util/concurrent/Semaphore:release	()V
    //   274: return
    //   275: aload_0
    //   276: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   279: invokevirtual 455	java/util/concurrent/Semaphore:release	()V
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
  
  public void a(int paramInt)
  {
    b(this.jdField_e_of_type_Int + paramInt);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.acquire();
      if ((this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice != null) && (this.jdField_c_of_type_Boolean))
      {
        if (paramSurfaceTexture == null)
        {
          QLog.a("Camera2Control", 1, new Object[] { "[Camera2] startPreview params exception!" });
          if (this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener != null) {
            this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener.a(3, 40, "[Camera2]no surface", new Object[0]);
          }
          this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
          return;
        }
        a(paramSurfaceTexture);
        j();
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack = paramCameraPreviewCallBack;
        i();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setDefaultBufferSize(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int);
        paramSurfaceTexture = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(3);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(paramSurfaceTexture);
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.addTarget(this.jdField_b_of_type_AndroidMediaImageReader.getSurface());
        this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureSession(Arrays.asList(new Surface[] { paramSurfaceTexture, this.jdField_b_of_type_AndroidMediaImageReader.getSurface(), this.jdField_a_of_type_AndroidMediaImageReader.getSurface() }), new Camera2Control.2(this), this.jdField_a_of_type_AndroidOsHandler);
        return;
      }
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2] startPreview mCameraDevice null!" });
      if (this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener != null)
      {
        paramSurfaceTexture = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener;
        paramCameraPreviewCallBack = new StringBuilder();
        paramCameraPreviewCallBack.append("[Camera2]error camera, isopend:");
        paramCameraPreviewCallBack.append(this.jdField_c_of_type_Boolean);
        paramSurfaceTexture.a(3, 41, paramCameraPreviewCallBack.toString(), new Object[0]);
      }
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      paramCameraPreviewCallBack = new StringBuilder();
      paramCameraPreviewCallBack.append("[Camera2]startPreview exception:");
      paramCameraPreviewCallBack.append(paramSurfaceTexture);
      QLog.a("Camera2Control", 1, new Object[] { paramCameraPreviewCallBack.toString() });
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentSemaphore.release();
      paramCameraPreviewCallBack = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener;
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
    if (!this.jdField_c_of_type_Boolean)
    {
      QLog.a("Camera2Control", 1, new Object[] { "[Camera2] takePicture fail, camera not open" });
      return;
    }
    if (this.g)
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
    this.g = true;
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraHandler$TakePictureData = paramTakePictureData;
    if (this.jdField_f_of_type_Boolean)
    {
      QLog.c("Camera2Control", 1, new Object[] { "[Camera2] takePicture AutoFocusing" });
      b();
      return;
    }
    l();
  }
  
  public void a(CameraSize paramCameraSize)
  {
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        localObject1 = (StreamConfigurationMap)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (localObject1 != null)
        {
          Size[] arrayOfSize = ((StreamConfigurationMap)localObject1).getOutputSizes(35);
          if (arrayOfSize != null)
          {
            i = 0;
            localObject1 = arrayOfSize[0];
            int j = arrayOfSize.length;
            if (i < j)
            {
              Size localSize = arrayOfSize[i];
              localObject2 = localObject1;
              if (localSize.getHeight() < paramCameraSize.jdField_b_of_type_Int / 3) {
                break label153;
              }
              localObject2 = localObject1;
              if (localSize.getHeight() * localSize.getWidth() >= ((Size)localObject1).getWidth() * ((Size)localObject1).getHeight()) {
                break label153;
              }
              localObject2 = localSize;
              break label153;
            }
            b(new CameraSize(((Size)localObject1).getWidth(), ((Size)localObject1).getHeight()));
          }
        }
        if (this.jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize == null) {
          b(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize);
        }
        return;
      }
      catch (Exception paramCameraSize)
      {
        return;
      }
      label153:
      i += 1;
      Object localObject1 = localObject2;
    }
  }
  
  public void a(Camera2Control.Camera2Listener paramCamera2Listener)
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Listener = paramCamera2Listener;
  }
  
  public void a(FocusOperator.CameraFocusParams paramCameraFocusParams)
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null) {
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = true;
      Object localObject = a(paramCameraFocusParams);
      if (localObject != null) {}
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[] { new MeteringRectangle((Rect)localObject, 1000) });
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.setTag(paramCameraFocusParams);
        this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.setRepeatingRequest(this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.build(), this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession$CaptureCallback, this.jdField_a_of_type_AndroidOsHandler);
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
    paramCameraFocusParams.append(this.jdField_e_of_type_Boolean);
    paramCameraFocusParams.append(", mIsAutoFocusing:");
    paramCameraFocusParams.append(this.jdField_f_of_type_Boolean);
    QLog.a("Camera2Control", 1, new Object[] { paramCameraFocusParams.toString() });
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null))
    {
      if ((paramBoolean) && (this.jdField_f_of_type_Int != 2))
      {
        this.jdField_f_of_type_Int = 2;
      }
      else
      {
        if (paramBoolean) {
          break label51;
        }
        this.jdField_f_of_type_Int = 0;
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
        QLog.a("Camera2Control", 2, new Object[] { "[Camera2]setFlashOn: ", ((StringBuilder)localObject).toString(), Integer.valueOf(this.jdField_f_of_type_Int), ", needUpdateView:", Boolean.valueOf(bool) });
      }
      if (bool)
      {
        localObject = this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder;
        if (localObject != null)
        {
          ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.jdField_f_of_type_Int));
          k();
        }
      }
      return;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2]setFlashOn error status!" });
  }
  
  public boolean a(int paramInt)
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
      this.jdField_a_of_type_AndroidUtilRange = new Range(Integer.valueOf(arrayOfInt[0]), Integer.valueOf(arrayOfInt[1]));
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
  
  /* Error */
  public boolean a(com.tencent.qqcamerakit.capture.CameraHandler.ParamCamera2Cache paramParamCamera2Cache)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   4: invokevirtual 618	java/util/concurrent/Semaphore:acquire	()V
    //   7: aload_0
    //   8: getfield 58	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_c_of_type_Boolean	Z
    //   11: ifne +54 -> 65
    //   14: new 227	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: ldc_w 768
    //   26: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: aload_0
    //   32: getfield 58	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_c_of_type_Boolean	Z
    //   35: invokevirtual 683	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: ldc 239
    //   41: iconst_1
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: aastore
    //   53: invokestatic 293	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   60: invokevirtual 455	java/util/concurrent/Semaphore:release	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: aload_1
    //   66: ifnull +72 -> 138
    //   69: aload_1
    //   70: getfield 771	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   73: ifnull +65 -> 138
    //   76: aload_1
    //   77: getfield 772	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   80: ifnull +58 -> 138
    //   83: aload_1
    //   84: getfield 773	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   87: ifnonnull +6 -> 93
    //   90: goto +48 -> 138
    //   93: ldc 239
    //   95: iconst_1
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 775
    //   105: aastore
    //   106: invokestatic 610	com/tencent/qqcamerakit/common/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   109: aload_0
    //   110: aload_1
    //   111: getfield 771	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   114: invokevirtual 778	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   117: pop
    //   118: aload_0
    //   119: aload_1
    //   120: getfield 772	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   123: invokevirtual 780	com/tencent/qqcamerakit/capture/camera2/Camera2Control:a	(Lcom/tencent/qqcamerakit/capture/CameraSize;)Z
    //   126: pop
    //   127: aload_0
    //   128: aload_1
    //   129: getfield 773	com/tencent/qqcamerakit/capture/CameraHandler$ParamCamera2Cache:jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize	Lcom/tencent/qqcamerakit/capture/CameraSize;
    //   132: invokevirtual 704	com/tencent/qqcamerakit/capture/camera2/Camera2Control:b	(Lcom/tencent/qqcamerakit/capture/CameraSize;)V
    //   135: goto +47 -> 182
    //   138: ldc 239
    //   140: iconst_1
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: ldc_w 782
    //   150: aastore
    //   151: invokestatic 293	com/tencent/qqcamerakit/common/QLog:a	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   154: goto -98 -> 56
    //   157: astore_1
    //   158: goto +33 -> 191
    //   161: astore_1
    //   162: ldc 239
    //   164: iconst_1
    //   165: iconst_2
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: ldc_w 784
    //   174: aastore
    //   175: dup
    //   176: iconst_1
    //   177: aload_1
    //   178: aastore
    //   179: invokestatic 610	com/tencent/qqcamerakit/common/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   182: aload_0
    //   183: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   186: invokevirtual 455	java/util/concurrent/Semaphore:release	()V
    //   189: iconst_1
    //   190: ireturn
    //   191: aload_0
    //   192: getfield 81	com/tencent/qqcamerakit/capture/camera2/Camera2Control:jdField_a_of_type_JavaUtilConcurrentSemaphore	Ljava/util/concurrent/Semaphore;
    //   195: invokevirtual 455	java/util/concurrent/Semaphore:release	()V
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
  
  public boolean a(CameraSize paramCameraSize)
  {
    if ((paramCameraSize != null) && (paramCameraSize.jdField_a_of_type_Int > 0) && (paramCameraSize.jdField_b_of_type_Int > 0))
    {
      this.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize = paramCameraSize;
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
  
  public CameraSize b()
  {
    return this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize;
  }
  
  public void b()
  {
    try
    {
      boolean bool = QLog.a();
      if (bool) {
        QLog.c("Camera2Control", 2, new Object[] { "[Camera2]captureStillPicture request!" });
      }
      if (this.jdField_a_of_type_Long > 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Camera2]captureStillPicture on id:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        QLog.c("Camera2Control", 1, new Object[] { ((StringBuilder)localObject).toString() });
        return;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      Object localObject = this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice.createCaptureRequest(2);
      ((CaptureRequest.Builder)localObject).addTarget(this.jdField_a_of_type_AndroidMediaImageReader.getSurface());
      ((CaptureRequest.Builder)localObject).set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      if (this.jdField_f_of_type_Int > -1) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.jdField_f_of_type_Int));
      }
      if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
        ((CaptureRequest.Builder)localObject).set(CaptureRequest.SCALER_CROP_REGION, this.jdField_a_of_type_AndroidGraphicsRect);
      }
      Camera2Control.5 local5 = new Camera2Control.5(this);
      this.jdField_a_of_type_AndroidHardwareCamera2CameraCaptureSession.capture(((CaptureRequest.Builder)localObject).build(), local5, null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b(int paramInt)
  {
    Rect localRect1 = (Rect)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    int i = ((Float)this.jdField_a_of_type_ComTencentQqcamerakitCaptureCamera2Camera2Control$Camera2Info.a.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).intValue();
    this.jdField_e_of_type_Int = paramInt;
    paramInt = this.jdField_e_of_type_Int;
    if (paramInt <= 0)
    {
      this.jdField_e_of_type_Int = 0;
    }
    else
    {
      j = this.jdField_b_of_type_Int;
      if (paramInt >= j) {
        this.jdField_e_of_type_Int = j;
      }
    }
    float f2 = this.jdField_e_of_type_Int / this.jdField_b_of_type_Int / this.jdField_a_of_type_Float;
    int j = localRect1.centerX();
    paramInt = localRect1.centerY();
    float f3 = localRect1.right;
    float f1 = j * f2;
    j = (int)(f3 - f1 - 1.0F - (f1 + 16.0F));
    f3 = localRect1.bottom;
    f2 *= paramInt;
    paramInt = (int)(f3 - f2 - 1.0F - (16.0F + f2));
    if ((j >= localRect1.right / i) && (paramInt >= localRect1.bottom / i))
    {
      Rect localRect2 = new Rect((int)(f1 + 40.0F), (int)(40.0F + f2), localRect1.right - (int)f1 - 1, localRect1.bottom - (int)f2 - 1);
      if (QLog.a())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Camera2] setZoom mZoomValue:");
        localStringBuilder.append(this.jdField_e_of_type_Int);
        localStringBuilder.append(", realRadio:");
        localStringBuilder.append(i);
        localStringBuilder.append(", minWidth:");
        localStringBuilder.append(j);
        localStringBuilder.append(", minHeight:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", rect:");
        localStringBuilder.append(localRect1);
        localStringBuilder.append(", destRect:");
        localStringBuilder.append(localRect2);
        QLog.c("Camera2Control", 2, new Object[] { localStringBuilder.toString() });
      }
      this.jdField_a_of_type_AndroidGraphicsRect = localRect2;
      this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.SCALER_CROP_REGION, localRect2);
      k();
      return;
    }
    QLog.a("Camera2Control", 1, new Object[] { "[Camera2] setZoom out of region!" });
  }
  
  public void b(CameraSize paramCameraSize)
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
    this.jdField_c_of_type_ComTencentQqcamerakitCaptureCameraSize = paramCameraSize;
  }
  
  public boolean b(CameraSize paramCameraSize)
  {
    if ((paramCameraSize != null) && (paramCameraSize.jdField_a_of_type_Int > 0) && (paramCameraSize.jdField_b_of_type_Int > 0))
    {
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize = paramCameraSize;
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
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        k();
        QLog.c("Camera2Control", 1, new Object[] { "[Camera2] setFocusDefaultMode!" });
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.a("Camera2Control", 1, "[Camera2] setFocusDefaultMode exp:", localException);
    }
  }
  
  public void d()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
        k();
        QLog.c("Camera2Control", 1, new Object[] { "[Camera2] setFocusRecordMode!" });
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.a("Camera2Control", 1, "[Camera2] setFocusRecordMode exp:", localException);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera2CameraDevice == null)
    {
      QLog.c("Camera2Control", 1, new Object[] { "[Camera2] stopRecordVideo device null!" });
      return;
    }
    this.jdField_a_of_type_AndroidHardwareCamera2CaptureRequest$Builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera2.Camera2Control
 * JD-Core Version:    0.7.0.1
 */