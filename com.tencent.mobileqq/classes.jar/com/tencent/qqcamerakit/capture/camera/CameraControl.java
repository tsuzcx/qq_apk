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
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqcamerakit.capture.CameraHandler.ParamCache;
import com.tencent.qqcamerakit.capture.CameraHandler.TakePictureData;
import com.tencent.qqcamerakit.capture.CameraManager;
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
  public static String a = "CameraControl";
  private static CameraControl f;
  public boolean b;
  public int c = -1;
  public int d;
  private boolean g;
  private Camera h;
  private int i;
  private CameraSize j;
  private byte[] k;
  private byte[] l;
  private CameraSize m;
  private int[] n;
  private CameraPreviewCallBack o;
  
  public static CameraControl a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new CameraControl();
        }
      }
      finally {}
    }
    return f;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Camera localCamera = this.h;
    if ((localCamera != null) && (paramArrayOfByte != null)) {
      localCamera.addCallbackBuffer(paramArrayOfByte);
    }
  }
  
  public static String b(int paramInt)
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
  
  private int g(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return CameraAbility.f();
      }
      if (CameraAbility.c()) {
        return CameraAbility.f();
      }
    }
    else if (CameraAbility.d())
    {
      return CameraAbility.e();
    }
    return -1;
  }
  
  private boolean h(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    for (;;)
    {
      try
      {
        if ((this.k == null) || (this.k.length != paramInt)) {
          this.k = new byte[paramInt];
        }
        if ((this.l == null) || (this.l.length != paramInt))
        {
          this.l = new byte[paramInt];
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
        if ((this.k == null) || (this.k.length != paramInt)) {
          this.k = new byte[paramInt];
        }
        if ((this.l == null) || (this.l.length != paramInt)) {
          this.l = new byte[paramInt];
        }
        return true;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        str = a;
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
  
  private boolean s()
  {
    try
    {
      boolean bool = ((DevicePolicyManager)CameraProxy.a().getSystemService("device_policy")).getCameraDisabled(null);
      return bool;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      if (QLog.a()) {
        QLog.a(a, 2, "checkCameraDisabled, ", localNoClassDefFoundError);
      }
    }
    catch (Exception localException)
    {
      if (QLog.a()) {
        QLog.a(a, 2, "checkCameraDisabled, ", localException);
      }
    }
    return true;
  }
  
  private int t()
  {
    Object localObject = Build.MODEL.toUpperCase();
    int i1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && ((((String)localObject).contains("RLI-AN00")) || (((String)localObject).contains("RLI-N29")) || (((String)localObject).contains("TAH-AN00")) || (((String)localObject).contains("TAH-N29")))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = 90;
    if (i1 == 0)
    {
      i1 = i2;
      if (Build.VERSION.SDK_INT < 29) {}
    }
    else
    {
      localObject = new Camera.CameraInfo();
      Camera.getCameraInfo(this.c, (Camera.CameraInfo)localObject);
      int i3 = ((WindowManager)CameraProxy.a().getSystemService("window")).getDefaultDisplay().getRotation();
      if (i3 != 0)
      {
        i1 = i2;
        if (i3 != 1) {
          if (i3 != 2)
          {
            if (i3 != 3) {
              i1 = i2;
            } else {
              i1 = 270;
            }
          }
          else {
            i1 = 180;
          }
        }
      }
      else
      {
        i1 = 0;
      }
      if (((Camera.CameraInfo)localObject).facing == 1) {
        i1 = (360 - (((Camera.CameraInfo)localObject).orientation + i1) % 360) % 360;
      } else {
        i1 = (((Camera.CameraInfo)localObject).orientation - i1 + 360) % 360;
      }
    }
    boolean bool2;
    boolean bool1;
    if (this.c == 1)
    {
      boolean bool3 = CameraCompatible.a(CameraCompatibleConfig.KEY.a);
      boolean bool4 = CameraCompatible.c(CameraCompatibleConfig.KEY.b);
      if (!bool3)
      {
        bool2 = bool3;
        i2 = i1;
        bool1 = bool4;
        if (!bool4) {}
      }
      else
      {
        i2 = i1 + 180;
        bool2 = bool3;
        bool1 = bool4;
      }
    }
    else
    {
      bool2 = CameraCompatible.a(CameraCompatibleConfig.KEY.c);
      i2 = i1;
      if (bool2) {
        i2 = i1 + 180;
      }
      bool1 = false;
    }
    if (QLog.a())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDisplayOrientation degrees=");
      localStringBuilder.append(i2);
      localStringBuilder.append(" blackPhone = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" rom_black = ");
      localStringBuilder.append(bool1);
      QLog.c((String)localObject, 2, new Object[] { localStringBuilder.toString() });
    }
    return i2;
  }
  
  private int u()
  {
    int i1 = ImageFormat.getBitsPerPixel(this.i);
    float f1 = i1 * 1.0F / 8.0F;
    int i2 = (int)(this.j.b * this.j.a * f1);
    if (QLog.a())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startPreview getPreviewBufferSize:bitpixel=");
      localStringBuilder.append(i1);
      localStringBuilder.append(" byteNum=");
      localStringBuilder.append(f1);
      localStringBuilder.append(" bufSize=");
      localStringBuilder.append(i2);
      QLog.c(str, 2, new Object[] { localStringBuilder.toString() });
    }
    return i2;
  }
  
  private boolean v()
  {
    return CameraCompatible.a(CameraCompatibleConfig.KEY.d) ^ true;
  }
  
  public int a(int paramInt)
  {
    String str;
    Object localObject;
    if (this.g)
    {
      if (QLog.a())
      {
        str = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openCamera: Camera is opened, Camera object:");
        ((StringBuilder)localObject).append(this.h);
        QLog.c(str, 2, new Object[] { ((StringBuilder)localObject).toString() });
      }
      return 6;
    }
    if (!CameraAbility.b())
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "openCamera failed, hasCameras = false" });
      }
      return 2;
    }
    if (s())
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "openCamera failed, camera disable" });
      }
      return 5;
    }
    int i2 = 0;
    int i1 = 0;
    for (;;)
    {
      if (i2 < 10)
      {
        if (QLog.a())
        {
          str = a;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("openCamera: currentCount = ");
          ((StringBuilder)localObject).append(i2);
          QLog.d(str, 2, new Object[] { ((StringBuilder)localObject).toString() });
        }
        try
        {
          this.d = paramInt;
          this.c = g(paramInt);
          this.h = Camera.open(this.c);
          i1 = 0;
        }
        catch (Exception localException)
        {
          this.h = null;
          i2 += 1;
          if (QLog.a())
          {
            localObject = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openCamera failed, currentCount =");
            localStringBuilder.append(i2);
            QLog.a((String)localObject, 2, localStringBuilder.toString(), localException);
          }
          if (i2 >= 10) {}
        }
      }
      try
      {
        Thread.sleep(300L);
        label296:
        i1 = 3;
        continue;
        if (this.h == null)
        {
          if (QLog.a()) {
            QLog.c(a, 2, new Object[] { "openCamera failed, mCamera = null" });
          }
          return i1;
        }
        if (!CameraAbility.a().a(this.h))
        {
          if (QLog.a()) {
            QLog.c(a, 2, new Object[] { "openCamera failed, bindCamera = false" });
          }
          return 4;
        }
        this.g = true;
        return 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label296;
      }
    }
  }
  
  public void a(Rect paramRect1, Rect paramRect2, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack)
  {
    if (QLog.a()) {
      QLog.c(a, 2, new Object[] { "[handleMessage]SET_FOCUS_MODE_REQUEST_FOCUS" });
    }
    Camera.Parameters localParameters = a().c();
    if (paramRect1 != null)
    {
      if (QLog.a())
      {
        localObject = a;
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
      a().h.setParameters(localParameters);
    }
    a().a(new CameraControl.2(this, paramCameraAutoFocusCallBack));
  }
  
  public void a(CameraHandler.TakePictureData paramTakePictureData)
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      if (QLog.a())
      {
        paramTakePictureData = a;
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
      QLog.c(a, 1, new Object[] { "[takePicture]enableShutterSound error, ", localException });
    }
    try
    {
      this.b = false;
      this.h.takePicture(null, null, null, new CameraControl.1(this, paramTakePictureData));
      return;
    }
    catch (RuntimeException paramTakePictureData)
    {
      QLog.a(a, 1, "", paramTakePictureData);
    }
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture)
  {
    Camera localCamera = this.h;
    if (localCamera != null)
    {
      if (paramSurfaceTexture == null) {
        return false;
      }
      if (this.b)
      {
        if (QLog.a()) {
          QLog.c(a, 2, new Object[] { "[setPreviewTexture] mIsPreviewing true" });
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
        QLog.a(a, 1, "[setPreviewTexture] exp: ", paramSurfaceTexture);
      }
    }
    return false;
  }
  
  public boolean a(Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    if ((this.h != null) && (this.b)) {
      if (!v()) {
        return false;
      }
    }
    try
    {
      this.h.cancelAutoFocus();
      Camera localCamera = this.h;
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
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    if (paramParameters == null) {
      return false;
    }
    try
    {
      this.h.setParameters(paramParameters);
      return true;
    }
    catch (Exception paramParameters)
    {
      QLog.a(a, 1, paramParameters, new Object[0]);
    }
    return false;
  }
  
  public boolean a(CameraHandler.ParamCache paramParamCache)
  {
    Camera.Parameters localParameters = c();
    if (localParameters == null)
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "setParamsPreviewFormat failed, getCameraParameters = null" });
      }
      return false;
    }
    localParameters.setPreviewFormat(paramParamCache.b);
    localParameters.setPreviewSize(paramParamCache.e.a, paramParamCache.e.b);
    localParameters.setPreviewFpsRange(paramParamCache.c, paramParamCache.d);
    if (paramParamCache.f) {
      localParameters.setPictureSize(paramParamCache.g.a, paramParamCache.g.b);
    }
    boolean bool = a(localParameters);
    if (bool)
    {
      this.i = paramParamCache.b;
      this.j = paramParamCache.e;
      this.n = new int[] { paramParamCache.c, paramParamCache.d };
      this.m = paramParamCache.g;
    }
    return bool;
  }
  
  public boolean a(CameraPreviewCallBack paramCameraPreviewCallBack, boolean paramBoolean)
  {
    Camera localCamera = this.h;
    if (localCamera != null)
    {
      if (paramCameraPreviewCallBack == null) {
        return false;
      }
      try
      {
        this.o = paramCameraPreviewCallBack;
        if (paramBoolean)
        {
          if (h(u()))
          {
            this.h.addCallbackBuffer(this.k);
            this.h.addCallbackBuffer(this.l);
            this.h.setPreviewCallbackWithBuffer(this);
          }
          else
          {
            this.h.setPreviewCallback(this);
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
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    Object localObject = c();
    if (localObject == null)
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "setParamsPreviewSize failed, getCameraParameters = null" });
      }
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPreviewSize(paramCameraSize.a, paramCameraSize.b);
      this.j = paramCameraSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      QLog.a(a, 1, "setParamsPreviewSize", paramCameraSize);
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    if (!v()) {
      return false;
    }
    try
    {
      this.h.cancelAutoFocus();
    }
    catch (RuntimeException localRuntimeException)
    {
      QLog.a(a, 1, "", localRuntimeException);
    }
    Object localObject1 = c();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((Camera.Parameters)localObject1).getFocusMode();
    if (QLog.a())
    {
      String str = a;
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
      localObject1 = a;
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
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().h())
    {
      Camera.Parameters localParameters = c();
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
  
  public boolean b()
  {
    return c(t());
  }
  
  public boolean b(CameraSize paramCameraSize)
  {
    Object localObject = c();
    if (localObject == null)
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "setRawPictureSize failed, getCameraParameters = null" });
      }
      return false;
    }
    try
    {
      ((Camera.Parameters)localObject).setPictureSize(paramCameraSize.a, paramCameraSize.b);
      this.m = paramCameraSize;
      boolean bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      QLog.a(a, 1, "setParamsPictureSize", paramCameraSize);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (QLog.a())
    {
      str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setDefaultFocusMode] ");
      localStringBuilder.append(paramString);
      QLog.c(str, 2, new Object[] { localStringBuilder.toString() });
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = i();
    }
    return (a(str)) || (a("auto")) || (a().a(null));
  }
  
  public Camera.Parameters c()
  {
    try
    {
      Camera.Parameters localParameters = this.h.getParameters();
      return localParameters;
    }
    catch (Exception localException)
    {
      QLog.a(a, 1, localException, new Object[0]);
    }
    return null;
  }
  
  public boolean c(int paramInt)
  {
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    try
    {
      this.h.setDisplayOrientation(paramInt);
      return true;
    }
    catch (Exception localException)
    {
      QLog.a(a, 1, "setDisplayOrientation error, ", localException);
    }
    return false;
  }
  
  public boolean d()
  {
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    Object localObject = c();
    if (localObject == null)
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "[@] setParamsPreviewFormat[failed]getCameraParameters=null" });
      }
      return false;
    }
    boolean bool;
    StringBuilder localStringBuilder;
    if (CameraAbility.a().a(17))
    {
      ((Camera.Parameters)localObject).setPreviewFormat(17);
      this.i = 17;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      this.i = 842094169;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      this.i = 20;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      this.i = 4;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      this.i = 256;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
      this.i = 16;
      bool = a((Camera.Parameters)localObject);
      if (QLog.a())
      {
        localObject = a;
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
  
  public boolean d(int paramInt)
  {
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    Camera.Parameters localParameters = c();
    if (localParameters == null)
    {
      QLog.c(a, 1, new Object[] { "setPreviewFps failed, getCameraParameters null" });
      return false;
    }
    int[] arrayOfInt = CameraFpsStrategy.a(paramInt);
    if ((arrayOfInt != null) && (arrayOfInt.length >= 2))
    {
      if (QLog.a()) {
        QLog.c(a, 2, new Object[] { "setPreviewFps[low fps=", Integer.valueOf(arrayOfInt[0]), " high fps=", Integer.valueOf(arrayOfInt[1]), "]" });
      }
      try
      {
        localParameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
        this.n = arrayOfInt;
        boolean bool = a(localParameters);
        return bool;
      }
      catch (Exception localException)
      {
        QLog.a(a, 1, "setPreviewFps, setPreviewFps error, ", localException);
        return false;
      }
    }
    QLog.c(a, 1, new Object[] { "setPreviewFps, getFpsRange null" });
    return false;
  }
  
  public int e()
  {
    return this.i;
  }
  
  public boolean e(int paramInt)
  {
    if (CameraAbility.a().g())
    {
      Camera.Parameters localParameters = c();
      if (localParameters == null) {
        return false;
      }
      return f(localParameters.getZoom() + paramInt);
    }
    return false;
  }
  
  public CameraSize f()
  {
    return this.j;
  }
  
  public boolean f(int paramInt)
  {
    if ((!e) && (this.h == null)) {
      throw new AssertionError();
    }
    if (CameraAbility.a().g())
    {
      Camera.Parameters localParameters = c();
      if (localParameters == null) {
        return false;
      }
      int i2 = localParameters.getMaxZoom();
      int i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
      paramInt = i1;
      if (i1 > i2) {
        paramInt = i2;
      }
      localParameters.setZoom(paramInt);
      return a(localParameters);
    }
    return false;
  }
  
  public CameraSize g()
  {
    return this.m;
  }
  
  public int[] h()
  {
    return this.n;
  }
  
  public String i()
  {
    return "continuous-picture";
  }
  
  public boolean j()
  {
    return (a(i())) || (a("auto")) || (a().a(null));
  }
  
  public boolean k()
  {
    return (a(l())) || (a("auto")) || (a().a(null));
  }
  
  public String l()
  {
    if (QLog.a())
    {
      String str = a;
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
  
  public boolean m()
  {
    Camera localCamera = this.h;
    if (localCamera == null) {
      return false;
    }
    if (this.b) {
      return true;
    }
    try
    {
      localCamera.startPreview();
      this.b = true;
      if (CameraManager.a > 0) {
        n();
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void n()
  {
    Camera.Parameters localParameters = this.h.getParameters();
    if (QLog.a()) {
      QLog.c(a, 2, new Object[] { "startFaceDetection" });
    }
    if (localParameters.getMaxNumDetectedFaces() > 0) {
      this.h.startFaceDetection();
    }
  }
  
  /* Error */
  public boolean o()
  {
    // Byte code:
    //   0: aload_0
    //   1: aconst_null
    //   2: putfield 461	com/tencent/qqcamerakit/capture/camera/CameraControl:o	Lcom/tencent/qqcamerakit/capture/CameraPreviewCallBack;
    //   5: aload_0
    //   6: getfield 59	com/tencent/qqcamerakit/capture/camera/CameraControl:h	Landroid/hardware/Camera;
    //   9: ifnonnull +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: getfield 391	com/tencent/qqcamerakit/capture/camera/CameraControl:b	Z
    //   18: ifne +5 -> 23
    //   21: iconst_1
    //   22: ireturn
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 391	com/tencent/qqcamerakit/capture/camera/CameraControl:b	Z
    //   28: aload_0
    //   29: invokespecial 411	com/tencent/qqcamerakit/capture/camera/CameraControl:v	()Z
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +10 -> 44
    //   37: aload_0
    //   38: getfield 59	com/tencent/qqcamerakit/capture/camera/CameraControl:h	Landroid/hardware/Camera;
    //   41: invokevirtual 414	android/hardware/Camera:cancelAutoFocus	()V
    //   44: aload_0
    //   45: getfield 59	com/tencent/qqcamerakit/capture/camera/CameraControl:h	Landroid/hardware/Camera;
    //   48: invokevirtual 623	android/hardware/Camera:stopPreview	()V
    //   51: aload_0
    //   52: getfield 59	com/tencent/qqcamerakit/capture/camera/CameraControl:h	Landroid/hardware/Camera;
    //   55: aconst_null
    //   56: invokevirtual 472	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   59: aload_0
    //   60: getfield 59	com/tencent/qqcamerakit/capture/camera/CameraControl:h	Landroid/hardware/Camera;
    //   63: aconst_null
    //   64: invokevirtual 627	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
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
      paramCamera = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onAutoFocus]success ");
      localStringBuilder.append(paramBoolean);
      QLog.c(paramCamera, 2, new Object[] { localStringBuilder.toString() });
    }
    a(i());
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    CameraPreviewCallBack localCameraPreviewCallBack = this.o;
    if (localCameraPreviewCallBack != null) {
      localCameraPreviewCallBack.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    a(paramArrayOfByte);
  }
  
  public void p()
  {
    this.o = null;
    if (QLog.a()) {
      QLog.c(a, 2, new Object[] { "release camera" });
    }
    if (!this.g) {
      return;
    }
    CameraAbility.a().j();
    Camera localCamera = this.h;
    if (localCamera == null) {
      return;
    }
    try
    {
      localCamera.release();
      this.h = null;
      this.i = -1;
      this.n = null;
      this.j = null;
      this.g = false;
      q();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void q()
  {
    this.k = null;
    this.l = null;
    if (QLog.a()) {
      QLog.c(a, 2, new Object[] { "releasePreviewFrameBuffer" });
    }
  }
  
  public int r()
  {
    Object localObject = new Camera.CameraInfo();
    Camera.getCameraInfo(this.c, (Camera.CameraInfo)localObject);
    int i1 = ((Camera.CameraInfo)localObject).orientation;
    if (QLog.a())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("return orientation = ");
      localStringBuilder.append(i1);
      QLog.d((String)localObject, 2, new Object[] { localStringBuilder.toString() });
    }
    return i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraControl
 * JD-Core Version:    0.7.0.1
 */