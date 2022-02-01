package com.tencent.qqcamerakit.capture.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.common.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraAbility
{
  private static int b = 0;
  private static int c = -1;
  private static int d = -1;
  private static CameraAbility f;
  private Camera.Parameters e;
  
  static
  {
    int j = 0;
    try
    {
      Object localObject = CameraProxy.a();
      if (localObject != null)
      {
        SharedPreferences localSharedPreferences = ((Context)localObject).getSharedPreferences("qcamera_local", 0);
        if (localSharedPreferences.contains("localsp_camera_num")) {
          b = localSharedPreferences.getInt("localsp_camera_num", 0);
        }
      }
      int i = j;
      if (b == 0)
      {
        b = Camera.getNumberOfCameras();
        i = j;
        if (localObject != null)
        {
          ((Context)localObject).getSharedPreferences("qcamera_local", 0).edit().putInt("localsp_camera_num", b).commit();
          i = j;
        }
      }
      while (i < b)
      {
        localObject = new Camera.CameraInfo();
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if ((((Camera.CameraInfo)localObject).facing == 0) && (c == -1)) {
          c = i;
        } else if (1 == ((Camera.CameraInfo)localObject).facing) {
          d = i;
        }
        i += 1;
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.a()) {
        QLog.a("CameraAbility", 2, "", localRuntimeException);
      }
      b = 1;
    }
  }
  
  public static CameraAbility a()
  {
    if (f == null) {
      try
      {
        if (f == null) {
          f = new CameraAbility();
        }
      }
      finally {}
    }
    return f;
  }
  
  public static boolean b()
  {
    return b > 0;
  }
  
  public static boolean c()
  {
    return (b()) && (c != -1);
  }
  
  public static boolean d()
  {
    return (b()) && (d != -1);
  }
  
  public static int e()
  {
    return d;
  }
  
  public static int f()
  {
    return c;
  }
  
  public List<CameraSize> a(boolean paramBoolean)
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    if (paramBoolean) {}
    try
    {
      localList = this.e.getSupportedPictureSizes();
    }
    catch (Exception localException)
    {
      List localList;
      QLog.a("CameraAbility", 1, localException, new Object[] { "getPreviewSizes, isPicture: ", Boolean.valueOf(paramBoolean) });
      localIterator = null;
    }
    localList = this.e.getSupportedPreviewSizes();
    Iterator localIterator;
    ArrayList localArrayList = new ArrayList();
    if (localIterator != null)
    {
      localIterator = localIterator.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Camera.Size)localIterator.next();
        localObject = new CameraSize(((Camera.Size)localObject).width, ((Camera.Size)localObject).height);
        localArrayList.add(localObject);
        if (QLog.a()) {
          QLog.d("CameraAbility", 2, new Object[] { "getPreviewSizes, isPicture: ", Boolean.valueOf(paramBoolean), " ", localObject });
        }
      }
    }
    return localArrayList;
  }
  
  public boolean a(int paramInt)
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.e.getSupportedPreviewFormats();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(Integer.valueOf(paramInt));
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(Camera paramCamera)
  {
    j();
    boolean bool = false;
    if (paramCamera == null) {
      return false;
    }
    try
    {
      this.e = paramCamera.getParameters();
    }
    catch (Exception paramCamera)
    {
      paramCamera.printStackTrace();
      this.e = null;
    }
    if (this.e != null) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.e.getSupportedFocusModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(paramString);
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean g()
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    try
    {
      boolean bool = this.e.isZoomSupported();
      return bool;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return false;
  }
  
  public boolean h()
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    boolean bool1 = false;
    try
    {
      List localList = this.e.getSupportedFlashModes();
      if (localList == null) {
        return false;
      }
      boolean bool2 = localList.contains("torch");
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public List<int[]> i()
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.e.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return null;
  }
  
  public void j()
  {
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.camera.CameraAbility
 * JD-Core Version:    0.7.0.1
 */