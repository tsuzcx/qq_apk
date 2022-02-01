package com.tencent.mobileqq.camera.adapter;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class CameraWrapper
{
  private static int jdField_a_of_type_Int = -1;
  private static CameraWrapper jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  private volatile boolean c;
  
  private CameraWrapper()
  {
    this.jdField_b_of_type_Boolean = true;
    a(false);
  }
  
  public static CameraWrapper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper == null) {
          jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper = new CameraWrapper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper;
  }
  
  private boolean e()
  {
    boolean bool;
    try
    {
      int j = b();
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      int i = 0;
      while (i < j)
      {
        Camera.getCameraInfo(i, localCameraInfo);
        int k = localCameraInfo.facing;
        if (k == 0)
        {
          bool = true;
          break label53;
        }
        i += 1;
      }
      bool = false;
      try
      {
        label53:
        CameraUtils.b(BaseApplicationImpl.getContext()).edit().putBoolean("local_sp_camera_back_exist", this.jdField_b_of_type_Boolean).commit();
      }
      catch (Exception localException1) {}
      QLog.i("Q.camera.CameraWrapper", 1, "getBlackCameraExistBySysCall fail", localException2);
    }
    catch (Exception localException2)
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraWrapper", 2, new Object[] { "getBlackCameraExistBySysCall, return ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public int a()
  {
    return 21;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getCameraOrientation] cameraId = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", cameraOrientation = ");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
    localObject = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt1, (Camera.CameraInfo)localObject);
    paramInt1 = ((Camera.CameraInfo)localObject).orientation;
    CameraAttrs.a().d();
    if (((Camera.CameraInfo)localObject).facing == 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("is FRONT camera, orientation = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramInt2 != -1) && (paramInt2 != 0))
      {
        if (paramInt2 != 90)
        {
          if (paramInt2 != 180)
          {
            if ((paramInt2 == 270) && (CameraAttrs.a().e != -1))
            {
              paramInt1 = CameraAttrs.a().e;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("reset FRONT Cam frontCamRotate270 = ");
              ((StringBuilder)localObject).append(paramInt1);
              QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
            }
          }
          else if (CameraAttrs.a().d != -1)
          {
            paramInt1 = CameraAttrs.a().d;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("reset FRONT Cam frontCamRotate180 = ");
            ((StringBuilder)localObject).append(paramInt1);
            QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (CameraAttrs.a().jdField_c_of_type_Int != -1)
        {
          paramInt1 = CameraAttrs.a().jdField_c_of_type_Int;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reset FRONT Cam frontCamRotate90 = ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (CameraAttrs.a().jdField_b_of_type_Int != -1)
      {
        paramInt1 = CameraAttrs.a().jdField_b_of_type_Int;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reset FRONT Cam frontCamRotate0 = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("is BACK camera, orientation = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramInt2 != -1) && (paramInt2 != 0))
      {
        if (paramInt2 != 90)
        {
          if (paramInt2 != 180)
          {
            if ((paramInt2 == 270) && (CameraAttrs.a().i != -1))
            {
              paramInt1 = CameraAttrs.a().i;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("reset BACK Cam backCamRotate270 = ");
              ((StringBuilder)localObject).append(paramInt1);
              QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
            }
          }
          else if (CameraAttrs.a().h != -1)
          {
            paramInt1 = CameraAttrs.a().h;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("reset BACK Cam backCamRotate180 = ");
            ((StringBuilder)localObject).append(paramInt1);
            QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
          }
        }
        else if (CameraAttrs.a().jdField_g_of_type_Int != -1)
        {
          paramInt1 = CameraAttrs.a().jdField_g_of_type_Int;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("reset BACK Cam backCamRotate90 = ");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (CameraAttrs.a().f != -1)
      {
        paramInt1 = CameraAttrs.a().f;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reset BACK Cam backCamRotate0 = ");
        ((StringBuilder)localObject).append(paramInt1);
        QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("return orientation = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
    }
    return paramInt1;
  }
  
  public void a(boolean paramBoolean)
  {
    CameraAttrs.a().a(CameraUtils.a(BaseApplicationImpl.getContext()), paramBoolean);
  }
  
  public boolean a()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[isSysVersionValid] ENTER sysCamerOn=");
      ((StringBuilder)localObject1).append(CameraAttrs.a().jdField_b_of_type_Boolean);
      ((StringBuilder)localObject1).append(" sysMinVersion=");
      ((StringBuilder)localObject1).append(CameraAttrs.a().a);
      ((StringBuilder)localObject1).append(" sysMaxVersion=");
      ((StringBuilder)localObject1).append(CameraAttrs.a().jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(" currVersion=");
      ((StringBuilder)localObject1).append(Build.VERSION.RELEASE);
      QLog.i("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject1).toString());
    }
    CameraAttrs.a().a();
    boolean bool1 = CameraAttrs.a().jdField_b_of_type_Boolean;
    boolean bool2 = false;
    if (bool1) {}
    for (;;)
    {
      try
      {
        String[] arrayOfString1 = CameraAttrs.a().a.split("\\.");
        String[] arrayOfString2 = CameraAttrs.a().jdField_b_of_type_JavaLangString.split("\\.");
        if (Build.VERSION.RELEASE == null) {
          break label401;
        }
        localObject1 = Build.VERSION.RELEASE.split("\\.");
        if ((localObject1 != null) && (arrayOfString1.length == 3) && (arrayOfString2.length == 3))
        {
          int j = Integer.parseInt(arrayOfString1[0]);
          int i3 = Integer.parseInt(arrayOfString1[1]);
          int i4 = Integer.parseInt(arrayOfString1[2]);
          int k = Integer.parseInt(localObject1[0]);
          int m = Integer.parseInt(localObject1[1]);
          if (localObject1.length != 3) {
            break label407;
          }
          i = Integer.parseInt(localObject1[2]);
          int n = Integer.parseInt(arrayOfString2[0]);
          int i1 = Integer.parseInt(arrayOfString2[1]);
          int i2 = Integer.parseInt(arrayOfString2[2]);
          if ((k <= j) && ((k != j) || (m <= i3)) && ((j != k) || (i3 != m) || (i < i4))) {
            j = 0;
          } else {
            j = 1;
          }
          if ((k >= n) && ((k != n) || (m >= i1)) && ((n != k) || (i1 != m) || (i > i2))) {
            i = 0;
          } else {
            i = 1;
          }
          bool1 = bool2;
          if (j != 0)
          {
            bool1 = bool2;
            if (i != 0) {
              bool1 = true;
            }
          }
          return bool1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
      label401:
      Object localObject2 = null;
      continue;
      label407:
      int i = 0;
    }
  }
  
  public int b()
  {
    if (jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getNumberOfCameras] sNumberOfCameras = ");
        ((StringBuilder)localObject).append(jdField_a_of_type_Int);
        QLog.d("Q.camera.CameraWrapper", 2, ((StringBuilder)localObject).toString());
      }
      return jdField_a_of_type_Int;
    }
    Object localObject = CameraUtils.b(BaseApplicationImpl.getContext());
    int i;
    if (((SharedPreferences)localObject).contains("local_sp_camera_num"))
    {
      int j = ((SharedPreferences)localObject).getInt("local_sp_camera_num", 0);
      i = j;
      if (j < 1)
      {
        i = Camera.getNumberOfCameras();
        StatisticCollector.report("event_camera_num_less_two");
      }
    }
    else
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        ThreadManager.excute(new CameraWrapper.1(this, (SharedPreferences)localObject), 64, null, false);
      }
      i = 2;
    }
    jdField_a_of_type_Int = i;
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraWrapper", 2, new Object[] { "getNumberOfCameras, return ", Integer.valueOf(jdField_a_of_type_Int) });
    }
    return i;
  }
  
  public boolean b()
  {
    CameraAttrs.a().e();
    return CameraAttrs.a().jdField_g_of_type_Boolean;
  }
  
  public boolean c()
  {
    CameraAttrs.a().b();
    return CameraAttrs.a().jdField_c_of_type_Boolean;
  }
  
  public boolean d()
  {
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_b_of_type_Boolean;
    }
    SharedPreferences localSharedPreferences = CameraUtils.b(BaseApplicationImpl.getContext());
    if (localSharedPreferences.contains("local_sp_camera_back_exist"))
    {
      this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("local_sp_camera_back_exist", false);
    }
    else
    {
      this.jdField_c_of_type_Boolean = true;
      ThreadManager.excute(new CameraWrapper.2(this), 64, null, false);
    }
    if ((!this.jdField_b_of_type_Boolean) && (QLog.isColorLevel())) {
      QLog.i("Q.camera.CameraWrapper", 1, "check back camera exist, return false");
    }
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraWrapper
 * JD-Core Version:    0.7.0.1
 */