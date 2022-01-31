package com.tencent.mobileqq.camera.adapter;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class CameraWrapper
{
  private static CameraWrapper a;
  
  private CameraWrapper()
  {
    a();
  }
  
  public static CameraWrapper a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new CameraWrapper();
      }
      return a;
    }
    finally {}
  }
  
  public int a()
  {
    return 16;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    QLog.d("Q.camera.CameraWrapper", 2, "[getCameraOrientation] cameraId = " + paramInt1 + ", cameraOrientation = " + paramInt2);
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt1, localCameraInfo);
    paramInt1 = localCameraInfo.orientation;
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
          if (CameraAttrs.a().jdField_d_of_type_Int != -1)
          {
            paramInt1 = CameraAttrs.a().jdField_d_of_type_Int;
            QLog.d("Q.camera.CameraWrapper", 2, "reset FRONT Cam frontCamRotate180 = " + paramInt1);
            continue;
            if (CameraAttrs.a().jdField_e_of_type_Int != -1)
            {
              paramInt1 = CameraAttrs.a().jdField_e_of_type_Int;
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
                if (CameraAttrs.a().g != -1)
                {
                  paramInt1 = CameraAttrs.a().g;
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
  
  public void a()
  {
    CameraAttrs.a().a(CameraUtils.a(BaseApplicationImpl.getContext()));
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraWrapper", 2, "[isSysVersionValid] ENTER sysCamerOn=" + CameraAttrs.a().jdField_b_of_type_Boolean + " sysMinVersion=" + CameraAttrs.a().a + " sysMaxVersion=" + CameraAttrs.a().jdField_b_of_type_JavaLangString + " currVersion=" + Build.VERSION.RELEASE);
    }
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
                break label350;
              }
              i = Integer.parseInt(arrayOfString1[2]);
              label225:
              int n = Integer.parseInt(arrayOfString3[0]);
              int i1 = Integer.parseInt(arrayOfString3[1]);
              int i2 = Integer.parseInt(arrayOfString3[2]);
              if ((k <= j) && ((k != j) || (m <= i3)) && ((j != k) || (i3 != m) || (i < i4))) {
                break label355;
              }
              j = 1;
              label289:
              if ((k >= n) && ((k != n) || (m >= i1)) && ((n != k) || (i1 != m) || (i > i2))) {
                break label360;
              }
              i = 1;
              label329:
              if ((j == 0) || (i == 0)) {
                break label365;
              }
            }
          }
        }
      }
      label350:
      label355:
      label360:
      label365:
      for (bool1 = bool2;; bool1 = false)
      {
        return bool1;
        arrayOfString1 = null;
        break;
        i = 0;
        break label225;
        j = 0;
        break label289;
        i = 0;
        break label329;
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
    int i = Camera.getNumberOfCameras();
    if ((CameraAttrs.a().jdField_d_of_type_Boolean) || (CameraAttrs.a().jdField_e_of_type_Boolean))
    {
      QLog.w("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] readCamNumWrong || cannotOpenFrontCam");
      i = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraWrapper", 2, "[getNumberOfCameras] return = " + i);
    }
    return i;
  }
  
  public boolean b()
  {
    return CameraAttrs.a().q;
  }
  
  public boolean c()
  {
    return CameraAttrs.a().jdField_c_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraWrapper
 * JD-Core Version:    0.7.0.1
 */