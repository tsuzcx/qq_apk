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
  private static CameraWrapper jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper = null;
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
    if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper == null) {
        jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper = new CameraWrapper();
      }
      return jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraWrapper;
    }
    finally {}
  }
  
  private boolean e()
  {
    for (;;)
    {
      try
      {
        int j = b();
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        i = 0;
        if (i >= j) {
          continue;
        }
        Camera.getCameraInfo(i, localCameraInfo);
        int k = localCameraInfo.facing;
        if (k == 0) {
          bool = true;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        QLog.i("Q.camera.CameraWrapper", 1, "getBlackCameraExistBySysCall fail", localException1);
        continue;
        bool = false;
        continue;
      }
      try
      {
        CameraUtils.b(BaseApplicationImpl.getContext()).edit().putBoolean("localsp_camera_back_exist", this.jdField_b_of_type_Boolean).commit();
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.CameraWrapper", 2, new Object[] { "getBlackCameraExistBySysCall, return ", Boolean.valueOf(bool) });
        }
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return 21;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    QLog.d("Q.camera.CameraWrapper", 2, "[getCameraOrientation] cameraId = " + paramInt1 + ", cameraOrientation = " + paramInt2);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt1, localCameraInfo);
    paramInt1 = localCameraInfo.orientation;
    CameraAttrs.a().d();
    if (localCameraInfo.facing == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "is FRONT camera, orientation = " + paramInt1);
      }
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "return orientation = " + paramInt1);
      }
      return paramInt1;
      if (CameraAttrs.a().jdField_b_of_type_Int != -1)
      {
        paramInt1 = CameraAttrs.a().jdField_b_of_type_Int;
        QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate0 = " + paramInt1);
        continue;
        if (CameraAttrs.a().jdField_c_of_type_Int != -1)
        {
          paramInt1 = CameraAttrs.a().jdField_c_of_type_Int;
          QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate90 = " + paramInt1);
          continue;
          if (CameraAttrs.a().d != -1)
          {
            paramInt1 = CameraAttrs.a().d;
            QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate180 = " + paramInt1);
            continue;
            if (CameraAttrs.a().e != -1)
            {
              paramInt1 = CameraAttrs.a().e;
              QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate270 = " + paramInt1);
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("Q.camera.CameraWrapper", 2, "is BACK camera, orientation = " + paramInt1);
              }
              switch (paramInt2)
              {
              default: 
                break;
              case -1: 
              case 0: 
                if (CameraAttrs.a().f != -1)
                {
                  paramInt1 = CameraAttrs.a().f;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate0 = " + paramInt1);
                }
                break;
              case 90: 
                if (CameraAttrs.a().jdField_g_of_type_Int != -1)
                {
                  paramInt1 = CameraAttrs.a().jdField_g_of_type_Int;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate90 = " + paramInt1);
                }
                break;
              case 180: 
                if (CameraAttrs.a().h != -1)
                {
                  paramInt1 = CameraAttrs.a().h;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate180 = " + paramInt1);
                }
                break;
              case 270: 
                if (CameraAttrs.a().i != -1)
                {
                  paramInt1 = CameraAttrs.a().i;
                  QLog.d("Q.camera.CameraWrapper", 2, "reset BACK Cam backCamRotate270 = " + paramInt1);
                }
                break;
              }
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    CameraAttrs.a().a(CameraUtils.a(BaseApplicationImpl.getContext()), paramBoolean);
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraWrapper", 2, "[isSysVersionValid] ENTER sysCamerOn=" + CameraAttrs.a().jdField_b_of_type_Boolean + " sysMinVersion=" + CameraAttrs.a().a + " sysMaxVersion=" + CameraAttrs.a().jdField_b_of_type_JavaLangString + " currVersion=" + Build.VERSION.RELEASE);
    }
    CameraAttrs.a().a();
    boolean bool1 = bool3;
    if (CameraAttrs.a().jdField_b_of_type_Boolean) {}
    try
    {
      String[] arrayOfString2 = CameraAttrs.a().a.split("\\.");
      String[] arrayOfString3 = CameraAttrs.a().jdField_b_of_type_JavaLangString.split("\\.");
      String[] arrayOfString1;
      int j;
      int i;
      if (Build.VERSION.RELEASE != null)
      {
        arrayOfString1 = Build.VERSION.RELEASE.split("\\.");
        bool1 = bool3;
        if (arrayOfString1 != null)
        {
          bool1 = bool3;
          if (arrayOfString2.length == 3)
          {
            bool1 = bool3;
            if (arrayOfString3.length == 3)
            {
              j = Integer.parseInt(arrayOfString2[0]);
              int i3 = Integer.parseInt(arrayOfString2[1]);
              int i4 = Integer.parseInt(arrayOfString2[2]);
              int k = Integer.parseInt(arrayOfString1[0]);
              int m = Integer.parseInt(arrayOfString1[1]);
              if (arrayOfString1.length != 3) {
                break label356;
              }
              i = Integer.parseInt(arrayOfString1[2]);
              label231:
              int n = Integer.parseInt(arrayOfString3[0]);
              int i1 = Integer.parseInt(arrayOfString3[1]);
              int i2 = Integer.parseInt(arrayOfString3[2]);
              if ((k <= j) && ((k != j) || (m <= i3)) && ((j != k) || (i3 != m) || (i < i4))) {
                break label361;
              }
              j = 1;
              label295:
              if ((k >= n) && ((k != n) || (m >= i1)) && ((n != k) || (i1 != m) || (i > i2))) {
                break label366;
              }
              i = 1;
              label335:
              if ((j == 0) || (i == 0)) {
                break label371;
              }
            }
          }
        }
      }
      label356:
      label361:
      label366:
      label371:
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        arrayOfString1 = null;
        break;
        i = 0;
        break label231;
        j = 0;
        break label295;
        i = 0;
        break label335;
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int b()
  {
    int j;
    if (jdField_a_of_type_Int != -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] sNumberOfCameras = " + jdField_a_of_type_Int);
      }
      j = jdField_a_of_type_Int;
      return j;
    }
    SharedPreferences localSharedPreferences = CameraUtils.b(BaseApplicationImpl.getContext());
    int i;
    if (localSharedPreferences.contains("localsp_camera_num"))
    {
      j = localSharedPreferences.getInt("localsp_camera_num", 0);
      i = j;
      if (j < 1)
      {
        i = Camera.getNumberOfCameras();
        StatisticCollector.report("event_camera_num_less_two");
      }
    }
    for (;;)
    {
      jdField_a_of_type_Int = i;
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.camera.CameraWrapper", 2, new Object[] { "getNumberOfCameras, return ", Integer.valueOf(jdField_a_of_type_Int) });
      return i;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        ThreadManager.excute(new CameraWrapper.1(this, localSharedPreferences), 64, null, false);
      }
      i = 2;
    }
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
    if (localSharedPreferences.contains("localsp_camera_back_exist")) {
      this.jdField_b_of_type_Boolean = localSharedPreferences.getBoolean("localsp_camera_back_exist", false);
    }
    for (;;)
    {
      if ((!this.jdField_b_of_type_Boolean) && (QLog.isColorLevel())) {
        QLog.i("Q.camera.CameraWrapper", 1, "check back camera exist, return false");
      }
      return this.jdField_b_of_type_Boolean;
      this.jdField_c_of_type_Boolean = true;
      ThreadManager.excute(new CameraWrapper.2(this), 64, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraWrapper
 * JD-Core Version:    0.7.0.1
 */