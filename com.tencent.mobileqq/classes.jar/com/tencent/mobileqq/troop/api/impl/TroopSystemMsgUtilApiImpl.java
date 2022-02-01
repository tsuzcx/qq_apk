package com.tencent.mobileqq.troop.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;

public class TroopSystemMsgUtilApiImpl
  implements ITroopSystemMsgUtilApi
{
  public String getTroopAnswerFromSP(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_answer_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramContext.contains(paramString)) {
      return paramContext.getString(paramString, null);
    }
    return null;
  }
  
  public long getTroopFlagExtFromSP(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_flagEx_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramContext.contains(paramString)) {
      return paramContext.getLong(paramString, 0L);
    }
    return 0L;
  }
  
  public String getTroopNameFromSP(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_name_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramContext.contains(paramString)) {
      return paramContext.getString(paramString, null);
    }
    return null;
  }
  
  public String getTroopQuestionFromSP(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_question_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramContext.contains(paramString)) {
      return paramContext.getString(paramString, null);
    }
    return null;
  }
  
  public void saveTroopAnswerToSP(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_answer_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public void saveTroopFlagExToSP(Context paramContext, String paramString, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_flagEx_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramContext.edit().putLong(paramString, paramLong).commit();
  }
  
  public void saveTroopNameToSP(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_name_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
  
  public void saveTroopOptionToSP(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_option_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    paramContext.edit().putInt(paramString, paramInt).commit();
  }
  
  public void saveTroopQuestionToSP(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences(String.valueOf(AppConstants.SYSTEM_MSG_UIN), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_question_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    paramContext.edit().putString(paramString1, paramString2).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopSystemMsgUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */