package com.tencent.rmonitor.common.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class CrashProtector$1
  implements Runnable
{
  CrashProtector$1(SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putInt(this.b, 0);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.common.util.CrashProtector.1
 * JD-Core Version:    0.7.0.1
 */