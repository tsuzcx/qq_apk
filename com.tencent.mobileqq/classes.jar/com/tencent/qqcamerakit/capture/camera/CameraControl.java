package com.tencent.qqcamerakit.capture.camera;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqcamerakit.capture.CameraHandler.ParamCache;
import com.tencent.qqcamerakit.capture.CameraHandler.TakePictureData;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraCompatible;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraCompatibleConfig.KEY;
import com.tencent.qqcamerakit.capture.camerastrategy.CameraFpsStrategy;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.List;

public class CameraControl
  implements Camera.AutoFocusCallback, Camera.PreviewCallback
{
  private static CameraControl jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl;
  public static String a;
  public int a;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private CameraPreviewCallBack jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack;
  private CameraSize jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int[] jdField_a_of_type_ArrayOfInt;
  public int b;
  private CameraSize jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "CameraControl";
  }
  
  public CameraControl()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static CameraControl a()
  {
    if (jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl == null) {
          jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl = new CameraControl();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqcamerakitCaptureCameraCameraControl;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return "";
            }
            return "CAMERA_OPEN_POLICY_DISABLED";
          }
          return "CAMERA_OPEN_GET_PARAM";
        }
        return "CAMERA_OPEN_FAILED";
      }
      return "CAMERA_OPEN_COUNT_ZERO";
    }
    return "CAMERA_OPEN_USED_AV";
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if ((localCamera != null) && (paramArrayOfByte != null)) {
      localCamera.addCallbackBuffer(paramArrayOfByte);
    }
  }
  
  private int b(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return CameraAbility.b();
      }
      if (CameraAbility.b()) {
        return CameraAbility.b();
      }
    }
    else if (CameraAbility.c())
    {
      return CameraAbility.a();
    }
    return -1;
  }
  
  private int c()
  {
    Object localObject = Build.MODEL.toUpperCase();
    int i;
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && ((((String)localObject).contains("RLI-AN00")) || (((String)localObject).contains("RLI-N29")) || (((String)localObject).contains("TAH-AN00")) || (((String)localObject).contains("TAH-N29")))) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 90;
    if (i == 0)
    {
      i = j;
      if (Build.VERSION.SDK_INT < 29) {}
    }
    else
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(this.jdField_a_of_type_Int, (Camera.CameraInfo)localObject);
      int k = ((WindowManager)CameraProxy.a().getSystemService("window")).getDefaultDisplay().getRotation();
      if (k != 0)
      {
        i = j;
        if (k != 1) {
          if (k != 2)
          {
            if (k != 3) {
              i = j;
            } else {
              i = 270;
            }
          }
          else {
            i = 180;
          }
        }
      }
      else
      {
        i = 0;
      }
      if (((Camera.CameraInfo)localObject).facing == 1) {
        i = (360 - (((Camera.CameraInfo)localObject).orientation + i) % 360) % 360;
      } else {
        i = (((Camera.CameraInfo)localObject).orientation - i + 360) % 360;
      }
    }
    boolean bool2;
    boolean bool1;
    if (this.jdField_a_of_type_Int == 1)
    {
      boolean bool3 = CameraCompatible.a(CameraCompatibleConfig.KEY.jdField_a_of_type_JavaLangString);
      boolean bool4 = CameraCompatible.c(CameraCompatibleConfig.KEY.b);
      if (!bool3)
      {
        bool2 = bool3;
        j = i;
        bool1 = bool4;
        if (!bool4) {}
      }
      else
      {
        j = i + 180;
        bool2 = bool3;
        bool1 = bool4;
      }
    }
    else
    {
      bool2 = CameraCompatible.a(CameraCompatibleConfig.KEY.c);
      j = i;
      if (bool2) {
        j = i + 180;
      }
      bool1 = false;
    }
    if (QLog.a())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDisplayOrientation degrees=");
      localStringBuilder.append(j);
      localStringBuilder.append(" blackPhone = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" rom_black = ");
      localStringBuilder.append(bool1);
      QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
    }
    return j;
  }
  
  private int d()
  {
    int i = ImageFormat.getBitsPerPixel(this.jdField_c_of_type_Int);
    float f = i * 1.0F / 8.0F;
    int j = (int)(this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int * this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int * f);
    if (QLog.a())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPreview getPreviewBufferSize:bitpixel=");
      localStringBuilder.append(i);
      localStringBuilder.append(" byteNum=");
      localStringBuilder.append(f);
      localStringBuilder.append(" bufSize=");
      localStringBuilder.append(j);
      QLog.c(str, 2, new Object[] { localStringBuilder.toString() });
    }
    return j;
  }
  
  private boolean e(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
          this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
        }
        if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt))
        {
          this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
          return true;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        String str;
        StringBuilder localStringBuilder;
        continue;
      }
      try
      {
        if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramInt)) {
          this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
        }
        if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != paramInt)) {
          this.jdField_b_of_type_ArrayOfByte = new byte[paramInt];
        }
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("allocateFrame failed , size:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", ");
        localStringBuilder.append(localOutOfMemoryError1.getMessage());
        QLog.a(str, 2, new Object[] { localStringBuilder.toString() });
        return false;
      }
    }
  }
  
  private boolean g()
  {
    try
    {
      boolean bool = ((DevicePolicyManager)CameraProxy.a().getSystemService("device_policy")).getCameraDisabled(null);
      return bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      if (QLog.a()) {
        QLog.a(jdField_a_of_type_JavaLangString, 2, "checkCameraDisabled, ", localNoClassDefFoundError);
      }
    }
    catch (Exception localException)
    {
      if (QLog.a()) {
        QLog.a(jdField_a_of_type_JavaLangString, 2, "checkCameraDisabled, ", localException);
      }
    }
    return true;
  }
  
  private boolean h()
  {
    return CameraCompatible.a(CameraCompatibleConfig.KEY.d) ^ true;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    String str;
    Object localObject;
    if (this.jdField_c_of_type_Boolean)
    {
      if (QLog.a())
      {
        str = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openCamera: Camera is opened, Camera object:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidHardwareCamera);
        QLog.c(str, 2, new Object[] { ((StringBuilder)localObject).toString() });
      }
      return 6;
    }
    if (!CameraAbility.a())
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "openCamera failed, hasCameras = false" });
      }
      return 2;
    }
    if (g())
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "openCamera failed, camera disable" });
      }
      return 5;
    }
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < 10)
      {
        if (QLog.a())
        {
          str = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openCamera: currentCount = ");
          ((StringBuilder)localObject).append(j);
          QLog.d(str, 2, new Object[] { ((StringBuilder)localObject).toString() });
        }
        try
        {
          this.jdField_b_of_type_Int = paramInt;
          this.jdField_a_of_type_Int = b(paramInt);
          this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(this.jdField_a_of_type_Int);
          i = 0;
        }
        catch (Exception localException)
        {
          this.jdField_a_of_type_AndroidHardwareCamera = null;
          j += 1;
          if (QLog.a())
          {
            localObject = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openCamera failed, currentCount =");
            localStringBuilder.append(j);
            QLog.a((String)localObject, 2, localStringBuilder.toString(), localException);
          }
          if (j >= 10) {}
        }
      }
      try
      {
        Thread.sleep(300L);
        label296:
        i = 3;
        continue;
        if (this.jdField_a_of_type_AndroidHardwareCamera == null)
        {
          if (QLog.a()) {
            QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "openCamera failed, mCamera = null" });
          }
          return i;
        }
        if (!CameraAbility.a().a(this.jdField_a_of_type_AndroidHardwareCamera))
        {
          if (QLog.a()) {
            QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "openCamera failed, bindCamera = false" });
          }
          return 4;
        }
        this.jdField_c_of_type_Boolean = true;
        return 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label296;
      }
    }
  }
  
  public Camera.Parameters a()
  {
    try
    {
      Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return null;
  }
  
  public CameraSize a()
  {
    return this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize;
  }
  
  public String a()
  {
    return "continuous-picture";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack = null;
    if (QLog.a()) {
      QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "release camera" });
    }
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    CameraAbility.a().a();
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera == null) {
      return;
    }
    try
    {
      localCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_ArrayOfInt = null;
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize = null;
      this.jdField_c_of_type_Boolean = false;
      b();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(Rect paramRect1, Rect paramRect2, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack)
  {
    if (QLog.a()) {
      QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS" });
    }
    Camera.Parameters localParameters = a().a();
    if (paramRect1 != null)
    {
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleMessage] focus area = ");
        localStringBuilder.append(paramRect1);
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      localParameters.setFocusMode("auto");
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(new Camera.Area(paramRect1, 1000));
      localParameters.setFocusAreas((List)localObject);
      if ((localParameters.getMaxNumMeteringAreas() > 0) && (paramRect2 != null))
      {
        paramRect1 = new ArrayList(1);
        paramRect1.add(new Camera.Area(new Rect(paramRect2), 1000));
        localParameters.setMeteringAreas(paramRect1);
      }
      a().jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    }
    a().a(new CameraControl.2(this, paramCameraAutoFocusCallBack));
  }
  
  public void a(CameraHandler.TakePictureData paramTakePictureData)
  {
    Object localObject = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localObject == null)
    {
      if (QLog.a())
      {
        paramTakePictureData = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[takePicture]mCamera ");
        ((StringBuilder)localObject).append(null);
        QLog.c(paramTakePictureData, 2, new Object[] { ((StringBuilder)localObject).toString() });
      }
      return;
    }
    try
    {
      ((Camera)localObject).enableShutterSound(false);
    }
    catch (Exception localException)
    {
      QLog.c(jdField_a_of_type_JavaLangString, 1, new Object[] { "[takePicture]enableShutterSound error, ", localException });
    }
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidHardwareCamera.takePicture(null, null, null, new CameraControl.1(this, paramTakePictureData));
      return;
    }
    catch (RuntimeException paramTakePictureData)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, "", paramTakePictureData);
    }
  }
  
  public boolean a()
  {
    return a(c());
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(paramInt);
      return true;
    }
    catch (Exception localException)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, "setDisplayOrientation error, ", localException);
    }
    return false;
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera != null)
    {
      if (paramSurfaceTexture == null) {
        return false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.a()) {
          QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "[setPreviewTexture] mIsPreviewing true" });
        }
        return true;
      }
      try
      {
        localCamera.setPreviewTexture(paramSurfaceTexture);
        return true;
      }
      catch (Exception paramSurfaceTexture)
      {
        QLog.a(jdField_a_of_type_JavaLangString, 1, "[setPreviewTexture] exp: ", paramSurfaceTexture);
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.jdField_a_of_type_AndroidHardwareCamera != null) && (this.jdField_a_of_type_Boolean)) {
      if (!h()) {
        return false;
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
      Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
      Object localObject = paramAutoFocusCallback;
      if (paramAutoFocusCallback == null) {
        localObject = this;
      }
      localCamera.autoFocus((Camera.AutoFocusCallback)localObject);
      return true;
    }
    catch (Exception paramAutoFocusCallback) {}
    return false;
    return false;
  }
  
  public boolean a(Camera.Parameters paramParameters)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, paramParameters, new Object[0]);
    }
    return false;
  }
  
  public boolean a(CameraHandler.ParamCache paramParamCache)
  {
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "setParamsPreviewFormat failed, getCameraParameters = null" });
      }
      return false;
    }
    localParameters.setPreviewFormat(paramParamCache.jdField_a_of_type_Int);
    localParameters.setPreviewSize(paramParamCache.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int, paramParamCache.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int);
    localParameters.setPreviewFpsRange(paramParamCache.jdField_b_of_type_Int, paramParamCache.jdField_c_of_type_Int);
    if (paramParamCache.jdField_a_of_type_Boolean) {
      localParameters.setPictureSize(paramParamCache.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_a_of_type_Int, paramParamCache.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize.jdField_b_of_type_Int);
    }
    boolean bool = a(localParameters);
    if (bool)
    {
      this.jdField_c_of_type_Int = paramParamCache.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize = paramParamCache.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize;
      this.jdField_a_of_type_ArrayOfInt = new int[] { paramParamCache.jdField_b_of_type_Int, paramParamCache.jdField_c_of_type_Int };
      this.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize = paramParamCache.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize;
    }
    return bool;
  }
  
  public boolean a(CameraPreviewCallBack paramCameraPreviewCallBack, boolean paramBoolean)
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera != null)
    {
      if (paramCameraPreviewCallBack == null) {
        return false;
      }
      try
      {
        this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack = paramCameraPreviewCallBack;
        if (paramBoolean)
        {
          if (e(d()))
          {
            this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_a_of_type_ArrayOfByte);
            this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(this.jdField_b_of_type_ArrayOfByte);
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this);
          }
          else
          {
            this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this);
          }
        }
        else {
          localCamera.setPreviewCallback(this);
        }
        return true;
      }
      catch (Exception paramCameraPreviewCallBack)
      {
        paramCameraPreviewCallBack.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean a(CameraSize paramCameraSize)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "setParamsPreviewSize failed, getCameraParameters = null" });
      }
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPreviewSize(paramCameraSize.jdField_a_of_type_Int, paramCameraSize.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraSize = paramCameraSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setParamsPreviewSize, result = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", size = ");
        localStringBuilder.append(paramCameraSize);
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    catch (Exception paramCameraSize)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, "setParamsPreviewSize", paramCameraSize);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (!h()) {
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidHardwareCamera.cancelAutoFocus();
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, "", localRuntimeException);
    }
    Object localObject1 = a();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((Camera.Parameters)localObject1).getFocusMode();
    if (QLog.a())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setParamsFocusMode getFocusMode=");
      localStringBuilder.append((String)localObject2);
      QLog.c(str, 2, new Object[] { localStringBuilder.toString() });
    }
    if ((localObject2 != null) && (((String)localObject2).equals(paramString))) {
      return true;
    }
    boolean bool2 = CameraAbility.a().a(paramString);
    boolean bool1;
    if (bool2)
    {
      ((Camera.Parameters)localObject1).setFocusMode(paramString);
      bool1 = a((Camera.Parameters)localObject1);
    }
    else
    {
      bool1 = false;
    }
    if (QLog.a())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setParamsFocusMode support=");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(" success=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" setTo=");
      ((StringBuilder)localObject2).append(paramString);
      QLog.c((String)localObject1, 2, new Object[] { ((StringBuilder)localObject2).toString() });
    }
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().e())
    {
      Camera.Parameters localParameters = a();
      String str;
      if (paramBoolean) {
        str = "torch";
      } else {
        str = "off";
      }
      localParameters.setFlashMode(str);
      return a(localParameters);
    }
    return false;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int b()
  {
    Object localObject = new Camera.CameraInfo();
    Camera.getCameraInfo(this.jdField_a_of_type_Int, (Camera.CameraInfo)localObject);
    int i = ((Camera.CameraInfo)localObject).orientation;
    if (QLog.a())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("return orientation = ");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, new Object[] { localStringBuilder.toString() });
    }
    return i;
  }
  
  public CameraSize b()
  {
    return this.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize;
  }
  
  public String b()
  {
    if (QLog.a())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] getRecordingFocusMode: Build.MANUFACTURER=");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("VERSION.SDK_INT=");
      localStringBuilder.append(Build.VERSION.SDK_INT);
      QLog.c(str, 2, new Object[] { localStringBuilder.toString() });
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {
      return "continuous-picture";
    }
    return "continuous-video";
  }
  
  public void b()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    if (QLog.a()) {
      QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "releasePreviewFrameBuffer" });
    }
  }
  
  public boolean b()
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "[@] setParamsPreviewFormat[failed]getCameraParameters=null" });
      }
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (CameraAbility.a().a(17))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(17);
      this.jdField_c_of_type_Int = 17;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append(", isSupportPreviewFormat=NV21 ok");
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    if (CameraAbility.a().a(842094169))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(842094169);
      this.jdField_c_of_type_Int = 842094169;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=YV12 OK");
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    if (CameraAbility.a().a(20))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(20);
      this.jdField_c_of_type_Int = 20;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=YUY2 OK");
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    if (CameraAbility.a().a(4))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(4);
      this.jdField_c_of_type_Int = 4;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=RGB_565 OK");
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    if (CameraAbility.a().a(256))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(256);
      this.jdField_c_of_type_Int = 256;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=JPEG OK");
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    if (CameraAbility.a().a(16))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(16);
      this.jdField_c_of_type_Int = 16;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[@] setParamsPreviewFormat:success=");
        localStringBuilder.append(bool);
        localStringBuilder.append("isSupportPreviewFormat=NV16 OK");
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    return false;
  }
  
  public boolean b(int paramInt)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = a();
    if (localParameters == null)
    {
      QLog.c(jdField_a_of_type_JavaLangString, 1, new Object[] { "setPreviewFps failed, getCameraParameters null" });
      return false;
    }
    int[] arrayOfInt = CameraFpsStrategy.a(paramInt);
    if ((arrayOfInt != null) && (arrayOfInt.length >= 2))
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "setPreviewFps[low fps=", Integer.valueOf(arrayOfInt[0]), " high fps=", Integer.valueOf(arrayOfInt[1]), "]" });
      }
      try
      {
        localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
        boolean bool = a(localParameters);
        return bool;
      }
      catch (Exception localException)
      {
        QLog.a(jdField_a_of_type_JavaLangString, 1, "setPreviewFps, setPreviewFps error, ", localException);
        return false;
      }
    }
    QLog.c(jdField_a_of_type_JavaLangString, 1, new Object[] { "setPreviewFps, getFpsRange null" });
    return false;
  }
  
  public boolean b(CameraSize paramCameraSize)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.a()) {
        QLog.c(jdField_a_of_type_JavaLangString, 2, new Object[] { "setRawPictureSize failed, getCameraParameters = null" });
      }
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPictureSize(paramCameraSize.jdField_a_of_type_Int, paramCameraSize.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentQqcamerakitCaptureCameraSize = paramCameraSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setRawPictureSize, result = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", size = ");
        localStringBuilder.append(paramCameraSize);
        QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
      }
      return bool;
    }
    catch (Exception paramCameraSize)
    {
      QLog.a(jdField_a_of_type_JavaLangString, 1, "setParamsPictureSize", paramCameraSize);
    }
    return false;
  }
  
  public boolean c()
  {
    return (a(a())) || (a("auto")) || (a().a(null));
  }
  
  public boolean c(int paramInt)
  {
    if (CameraAbility.a().d())
    {
      Camera.Parameters localParameters = a();
      if (localParameters == null) {
        return false;
      }
      return d(localParameters.getZoom() + paramInt);
    }
    return false;
  }
  
  public boolean d()
  {
    return (a(b())) || (a("auto")) || (a().a(null));
  }
  
  public boolean d(int paramInt)
  {
    if ((!jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().d())
    {
      Camera.Parameters localParameters = a();
      if (localParameters == null) {
        return false;
      }
      int j = localParameters.getMaxZoom();
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramInt = i;
      if (i > j) {
        paramInt = j;
      }
      localParameters.setZoom(paramInt);
      return a(localParameters);
    }
    return false;
  }
  
  public boolean e()
  {
    Camera localCamera = this.jdField_a_of_type_AndroidHardwareCamera;
    if (localCamera == null) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      localCamera.startPreview();
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 315	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack	Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;
    //   5: aload_0
    //   6: getfield 60	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   9: ifnonnull +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: getfield 398	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_Boolean	Z
    //   18: ifne +5 -> 23
    //   21: iconst_1
    //   22: ireturn
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 398	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_Boolean	Z
    //   28: aload_0
    //   29: invokespecial 430	com/tencent/qqcamerakit/capture/camera/CameraControl:h	()Z
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +10 -> 44
    //   37: aload_0
    //   38: getfield 60	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   41: invokevirtual 433	android/hardware/Camera:cancelAutoFocus	()V
    //   44: aload_0
    //   45: getfield 60	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   48: invokevirtual 599	android/hardware/Camera:stopPreview	()V
    //   51: aload_0
    //   52: getfield 60	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   55: aconst_null
    //   56: invokevirtual 478	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   59: aload_0
    //   60: getfield 60	com/tencent/qqcamerakit/capture/camera/CameraControl:jdField_a_of_type_AndroidHardwareCamera	Landroid/hardware/Camera;
    //   63: aconst_null
    //   64: invokevirtual 603	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   67: iconst_1
    //   68: ireturn
    //   69: astore_2
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_2
    //   73: goto -29 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	CameraControl
    //   32	2	1	bool	boolean
    //   69	1	2	localException	Exception
    //   72	1	2	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   23	33	69	java/lang/Exception
    //   37	44	69	java/lang/Exception
    //   44	67	69	java/lang/Exception
    //   37	44	72	java/lang/RuntimeException
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    if (QLog.a())
    {
      paramCamera = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAutoFocus]success ");
      localStringBuilder.append(paramBoolean);
      QLog.c(paramCamera, 2, new Object[] { localStringBuilder.toString() });
    }
    a(a());
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraPreviewCallBack localCameraPreviewCallBack = this.jdField_a_of_type_ComTencentQqcamerakitCaptureCameraPreviewCallBack;
    if (localCameraPreviewCallBack != null) {
      localCameraPreviewCallBack.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraControl
 * JD-Core Version:    0.7.0.1
 */