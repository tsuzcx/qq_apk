package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QUA;

public class CrashVersionUtils
{
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("BuglySdkInfos", 0);
    if (!((SharedPreferences)localObject).contains("c87e09e876"))
    {
      String str = QUA.getQUA3();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString("c87e09e876", str);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CrashVersionUtils
 * JD-Core Version:    0.7.0.1
 */