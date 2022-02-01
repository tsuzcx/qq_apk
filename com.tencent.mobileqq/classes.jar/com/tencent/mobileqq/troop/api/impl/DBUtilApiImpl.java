package com.tencent.mobileqq.troop.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.api.IDBUtilApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DBUtilApiImpl
  implements IDBUtilApi
{
  private static final String TAG = "DBUtilApiImpl";
  
  public void setTroopLuckyCharacterStatus(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTroopLuckyCharacterStatus troopUin = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", wording = ");
      ((StringBuilder)localObject).append(paramString3);
      QLog.d("DBUtilApiImpl", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      localObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("troop_lucky_character_status");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("time");
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), l);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("troop_lucky_character_status");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("wording");
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString3);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.DBUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */