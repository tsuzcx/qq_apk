package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;

final class CrashVersionUtils$1
  implements Runnable
{
  public void run()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("238de83eac", "1.8.0.158-release_qq_8.6.5");
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.crash.CrashVersionUtils.1
 * JD-Core Version:    0.7.0.1
 */