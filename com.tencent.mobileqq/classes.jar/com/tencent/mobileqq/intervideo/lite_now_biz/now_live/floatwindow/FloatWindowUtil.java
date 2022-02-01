package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class FloatWindowUtil
{
  public static boolean a()
  {
    SharedPreferences localSharedPreferences = new FloatWindowUtil.SharePreferenceUtil(BaseApplicationImpl.getContext(), "floatwindow_setting").a();
    long l = localSharedPreferences.getLong("last_open_permission_time", 0L);
    int i = localSharedPreferences.getInt("open_permission_count", 0);
    return (System.currentTimeMillis() - l >= 86400000L) && (i <= 3);
  }
  
  public static void b()
  {
    Object localObject = new FloatWindowUtil.SharePreferenceUtil(BaseApplicationImpl.getContext(), "floatwindow_setting");
    int i = ((FloatWindowUtil.SharePreferenceUtil)localObject).a().getInt("open_permission_count", 0);
    localObject = ((FloatWindowUtil.SharePreferenceUtil)localObject).b();
    ((SharedPreferences.Editor)localObject).putLong("last_open_permission_time", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).putInt("open_permission_count", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow.FloatWindowUtil
 * JD-Core Version:    0.7.0.1
 */