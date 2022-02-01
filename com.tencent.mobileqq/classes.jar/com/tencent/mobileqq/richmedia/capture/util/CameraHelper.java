package com.tencent.mobileqq.richmedia.capture.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class CameraHelper
{
  public static int a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4);
    long l = localSharedPreferences.getLong("key_open_camera_time", 0L);
    if ((l != 0L) && (System.currentTimeMillis() - l < 300000L)) {
      return localSharedPreferences.getInt("camera", 2);
    }
    return 2;
  }
  
  public static void a()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("camera", paramInt);
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).contains("camera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CameraHelper
 * JD-Core Version:    0.7.0.1
 */