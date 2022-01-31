package com.tencent.mobileqq.camera.adapter;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera;
import anws;
import anwt;
import com.tencent.qphone.base.util.QLog;

public class CameraWrapper$1
  implements Runnable
{
  public CameraWrapper$1(anwt paramanwt, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int i = Camera.getNumberOfCameras();
    anws.a().c();
    if ((anws.a().d) || (anws.a().e))
    {
      QLog.d("Q.camera.CameraWrapper", 1, new Object[] { "getNumberOfCameras, readCamNumException:", Boolean.valueOf(anws.a().d) });
      i = 1;
    }
    anwt.a(i);
    this.a.edit().putInt("localsp_camera_num", i).commit();
    QLog.d("Q.camera.CameraWrapper", 1, new Object[] { "getNumberOfCameras init, return ", Integer.valueOf(anwt.c()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraWrapper.1
 * JD-Core Version:    0.7.0.1
 */