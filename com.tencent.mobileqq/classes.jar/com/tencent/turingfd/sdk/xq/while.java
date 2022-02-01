package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

public class while
{
  public static int Gf = -1;
  
  public static int p(Context paramContext)
  {
    try
    {
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext == null) {
        return Gf;
      }
      if (!TextUtils.equals(paramContext.getAction(), "android.intent.action.BATTERY_CHANGED")) {
        return Gf;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      int j;
      label92:
      label96:
      break label96;
    }
    try
    {
      i = paramContext.getIntExtra("level", 0);
      j = paramContext.getIntExtra("scale", 100);
      if (j == 0) {
        return Gf;
      }
      j = i * 100 / j;
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = i;
      if (i > 100) {
        j = 100;
      }
      return j;
    }
    catch (Throwable paramContext)
    {
      break label92;
    }
    return Gf;
    return Gf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.while
 * JD-Core Version:    0.7.0.1
 */