package com.tencent.mobileqq.richmedia.capture.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class CameraHelper
{
  public static int a()
  {
    return b(2);
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putInt("camera", paramInt);
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putBoolean("camera_flash_on", paramBoolean);
    localEditor.apply();
  }
  
  public static int b(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4);
    long l = localSharedPreferences.getLong("key_open_camera_time", 0L);
    int i = paramInt;
    if (l != 0L)
    {
      i = paramInt;
      if (System.currentTimeMillis() - l < 300000L) {
        i = localSharedPreferences.getInt("camera", paramInt);
      }
    }
    return i;
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getBoolean("camera_flash_on", false);
  }
  
  public static boolean c()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).contains("camera");
  }
  
  public static void d()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit();
    localEditor.putLong("key_open_camera_time", System.currentTimeMillis());
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CameraHelper
 * JD-Core Version:    0.7.0.1
 */