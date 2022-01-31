package com.tencent.mobileqq.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class LightDpcConfig
{
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 4).edit();
    paramContext.putBoolean("SUPPORT_MTA", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 4).getBoolean("SUPPORT_MTA", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LightDpcConfig
 * JD-Core Version:    0.7.0.1
 */