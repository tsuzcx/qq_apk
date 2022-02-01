package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.v4.content.SharedPreferencesCompat.EditorCompat;

public class UssnUtils
{
  private static final int DEFAULT_NO_USSN = 0;
  private static final String DT_USSN_SP_KEY = "dt_ussn_sp_key";
  private static final String USSN_SP_PROFILE = "ussn_sp_profile";
  private static volatile long sUssn;
  public static SharedPreferences sp;
  
  private static long generateNewUssnAndCache()
  {
    try
    {
      long l = System.currentTimeMillis() * 1000L;
      saveUssn(l);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static long generateUssn()
  {
    try
    {
      if (sUssn > 0L)
      {
        sUssn = updateUssnAndCache(sUssn);
        l = sUssn;
        return l;
      }
      long l = getUssnFromSP();
      if (l > 0L)
      {
        sUssn = updateUssnAndCache(l);
        l = sUssn;
        return l;
      }
      sUssn = generateNewUssnAndCache();
      l = sUssn;
      return l;
    }
    finally {}
  }
  
  private static long getUssnFromSP()
  {
    Context localContext = ReportUtils.getContext();
    if (localContext == null) {
      return 0L;
    }
    return init(localContext).getLong("dt_ussn_sp_key", 0L);
  }
  
  private static SharedPreferences init(@NonNull Context paramContext)
  {
    SharedPreferences localSharedPreferences = sp;
    if (localSharedPreferences == null)
    {
      paramContext = paramContext.getSharedPreferences("ussn_sp_profile", 0);
      sp = paramContext;
      return paramContext;
    }
    return localSharedPreferences;
  }
  
  private static void saveUssn(long paramLong)
  {
    try
    {
      Object localObject1 = ReportUtils.getContext();
      if (localObject1 == null) {
        return;
      }
      localObject1 = init((Context)localObject1).edit();
      ((SharedPreferences.Editor)localObject1).putLong("dt_ussn_sp_key", paramLong);
      SharedPreferencesCompat.EditorCompat.getInstance().apply((SharedPreferences.Editor)localObject1);
      return;
    }
    finally {}
  }
  
  private static long updateUssnAndCache(long paramLong)
  {
    paramLong += 1L;
    try
    {
      saveUssn(paramLong);
      return paramLong;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.UssnUtils
 * JD-Core Version:    0.7.0.1
 */