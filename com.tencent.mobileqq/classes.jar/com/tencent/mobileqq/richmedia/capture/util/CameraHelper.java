package com.tencent.mobileqq.richmedia.capture.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;

public class CameraHelper
{
  public static int a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", 2);
  }
  
  public static void a(int paramInt)
  {
    SharedPreUtils.a(BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit().putInt("camera", paramInt));
  }
  
  public static int b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.CameraHelper
 * JD-Core Version:    0.7.0.1
 */