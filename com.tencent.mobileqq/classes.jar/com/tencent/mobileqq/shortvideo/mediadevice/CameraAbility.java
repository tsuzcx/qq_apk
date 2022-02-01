package com.tencent.mobileqq.shortvideo.mediadevice;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.qphone.base.util.QLog;
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
      long l = System.currentTimeMillis();
      Object localObject = CameraUtils.c(BaseApplicationImpl.getContext());
      if (((SharedPreferences)localObject).contains("local_sp_camera_num")) {
        b = ((SharedPreferences)localObject).getInt("local_sp_camera_num", 0);
      } else {
        b = Camera.getNumberOfCameras();
      }
      int i = j;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getNumberOfCameras cost: ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.i("CameraAbility", 2, ((StringBuilder)localObject).toString());
        i = j;
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
      if (QLog.isColorLevel()) {
        QLog.i("CameraAbility", 2, "", localRuntimeException);
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
    l();
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
    return this.e != null;
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
  
  public boolean b(String paramString)
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.e.getSupportedSceneModes();
      if ((localList != null) && (!localList.isEmpty()))
      {
        boolean bool = localList.contains(paramString);
        return bool;
      }
    }
    catch (Exception paramString)
    {
      label55:
      break label55;
    }
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
  
  public List<Camera.Size> i()
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    List<Camera.Size> localList1;
    try
    {
      List localList = this.e.getSupportedPreviewSizes();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localList1 = null;
    }
    if ((localList1 != null) && (QLog.isColorLevel()))
    {
      Iterator localIterator = localList1.iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        if (localSize != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPreviewSizes:w=");
          localStringBuilder.append(localSize.width);
          localStringBuilder.append(",h=");
          localStringBuilder.append(localSize.height);
          localStringBuilder.append(" w/h=");
          localStringBuilder.append(localSize.width / localSize.height);
          QLog.d("CameraAbility", 2, localStringBuilder.toString());
        }
      }
    }
    return localList1;
  }
  
  public List<Camera.Size> j()
  {
    if ((!a) && (this.e == null)) {
      throw new AssertionError();
    }
    List<Camera.Size> localList1;
    try
    {
      List localList = this.e.getSupportedPictureSizes();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localList1 = null;
    }
    if ((localList1 != null) && (QLog.isColorLevel()))
    {
      Iterator localIterator = localList1.iterator();
      while (localIterator.hasNext())
      {
        Camera.Size localSize = (Camera.Size)localIterator.next();
        if (localSize != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[@] getPictureSizes:w=");
          localStringBuilder.append(localSize.width);
          localStringBuilder.append(",h=");
          localStringBuilder.append(localSize.height);
          localStringBuilder.append(" w/h=");
          localStringBuilder.append(localSize.width / localSize.height);
          QLog.d("CameraAbility", 2, localStringBuilder.toString());
        }
      }
    }
    return localList1;
  }
  
  @TargetApi(9)
  public List<int[]> k()
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
  
  public void l()
  {
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility
 * JD-Core Version:    0.7.0.1
 */