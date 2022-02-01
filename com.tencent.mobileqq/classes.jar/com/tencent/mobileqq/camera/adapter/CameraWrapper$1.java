package com.tencent.mobileqq.camera.adapter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import com.tencent.qphone.base.util.QLog;

class CameraWrapper$1
  implements Runnable
{
  CameraWrapper$1(CameraWrapper paramCameraWrapper, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int i = Camera.getNumberOfCameras();
    CameraAttrs.a().d();
    if ((CameraAttrs.a().g) || (CameraAttrs.a().h))
    {
      QLog.d("Q.camera.CameraWrapper", 1, new Object[] { "getNumberOfCameras, readCamNumException:", Boolean.valueOf(CameraAttrs.a().g) });
      i = 1;
    }
    CameraWrapper.a(i);
    this.a.edit().putInt("local_sp_camera_num", i).commit();
    QLog.d("Q.camera.CameraWrapper", 1, new Object[] { "getNumberOfCameras init, return ", Integer.valueOf(CameraWrapper.h()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraWrapper.1
 * JD-Core Version:    0.7.0.1
 */