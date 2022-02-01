package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class FloatWindowUtil
{
  public static void a()
  {
    Object localObject = new FloatWindowUtil.SharePreferenceUtil(BaseApplicationImpl.getContext(), "floatwindow_setting");
    int i = ((FloatWindowUtil.SharePreferenceUtil)localObject).a().getInt("open_permission_count", 0);
    localObject = ((FloatWindowUtil.SharePreferenceUtil)localObject).a();
    ((SharedPreferences.Editor)localObject).putLong("last_open_permission_time", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject).putInt("open_permission_count", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static boolean a()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = new FloatWindowUtil.SharePreferenceUtil(BaseApplicationImpl.getContext(), "floatwindow_setting").a();
    long l = localSharedPreferences.getLong("last_open_permission_time", 0L);
    int i = localSharedPreferences.getInt("open_permission_count", 0);
    boolean bool1 = bool2;
    if (System.currentTimeMillis() - l >= 86400000L)
    {
      bool1 = bool2;
      if (i <= 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.floatwindow.FloatWindowUtil
 * JD-Core Version:    0.7.0.1
 */