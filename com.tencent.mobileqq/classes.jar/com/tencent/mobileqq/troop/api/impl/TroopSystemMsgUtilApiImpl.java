package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;

public class TroopSystemMsgUtilApiImpl
  implements ITroopSystemMsgUtilApi
{
  public long getTroopFlagExtFromSP(Context paramContext, String paramString)
  {
    long l = 0L;
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_flagEx_" + paramString;
    if (paramContext.contains(paramString)) {
      l = paramContext.getLong(paramString, 0L);
    }
    return l;
  }
  
  public String getTroopNameFromSP(Context paramContext, String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    paramString = "troop_name_" + paramString;
    paramContext = localObject;
    if (localSharedPreferences.contains(paramString)) {
      paramContext = localSharedPreferences.getString(paramString, null);
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopSystemMsgUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */