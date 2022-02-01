package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

public class CrashVersionUtils
{
  public static void a()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("238de83eac", "1.5.4.117-release_qq_8.5.5");
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash.CrashVersionUtils
 * JD-Core Version:    0.7.0.1
 */