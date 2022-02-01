package com.tencent.mobileqq.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class FaceSharedPreUtils
  extends BaseSharedPreUtil
{
  public static String a()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("identification_download_path_other_new", "");
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putInt("identification_download_version", paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("identification_download_path_other_new", paramString);
    localEditor.commit();
  }
  
  public static int b()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getInt("identification_download_version", 0);
  }
  
  public static void b(int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putInt("identification_download_res_mode", paramInt);
    localEditor.commit();
  }
  
  public static int c()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getInt("identification_download_res_mode", 0);
  }
  
  public static String d()
  {
    return BaseApplication.getContext().getSharedPreferences("short_video_resource_cfg", 4).getString("short_video_res_config_key", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceSharedPreUtils
 * JD-Core Version:    0.7.0.1
 */