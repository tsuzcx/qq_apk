package com.tencent.mobileqq.qshadow.utils;

import android.content.Context;
import android.content.Intent;

public class QShadowSender
{
  public static void a(Context paramContext, String paramString, Throwable paramThrowable, int paramInt)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH");
    localIntent.putExtra("qshadow_plugin_id", paramString);
    localIntent.putExtra("qshadow_plugin_throwable", paramThrowable);
    localIntent.putExtra("qshadow_plugin_error_code", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.QShadowSender
 * JD-Core Version:    0.7.0.1
 */