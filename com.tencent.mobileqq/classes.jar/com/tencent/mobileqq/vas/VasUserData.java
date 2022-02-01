package com.tencent.mobileqq.vas;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class VasUserData
{
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("get, key=");
      localStringBuilder1.append(paramString);
      QLog.d("VasUserData", 2, localStringBuilder1.toString());
    }
    StringBuilder localStringBuilder1 = null;
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString)))
    {
      Context localContext = paramAppRuntime.getApplication().getApplicationContext();
      if (localContext == null) {
        return null;
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getUserDataString());
      localStringBuilder2.append("/");
      localStringBuilder2.append(paramAppRuntime.getAccount());
      paramAppRuntime = Uri.parse(localStringBuilder2.toString());
      paramString = localContext.getContentResolver().query(paramAppRuntime, null, "key=?", new String[] { paramString }, null);
      paramAppRuntime = localStringBuilder1;
      if (paramString != null)
      {
        paramAppRuntime = localStringBuilder1;
        if (paramString.moveToFirst()) {
          paramAppRuntime = paramString.getString(paramString.getColumnIndex("value"));
        }
      }
      if (paramString != null) {
        paramString.close();
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[Performance] get, duration=");
        paramString.append(SystemClock.uptimeMillis() - l);
        QLog.d("VasUserData", 2, paramString.toString());
      }
      return paramAppRuntime;
    }
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("get, app and key MUST NOT be null, context=");
    localStringBuilder1.append(paramAppRuntime);
    localStringBuilder1.append(", key=");
    localStringBuilder1.append(paramString);
    QLog.d("VasUserData", 1, localStringBuilder1.toString());
    return null;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("set, key=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", value=");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("VasUserData", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool = false;
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      localObject1 = paramAppRuntime.getApplication().getApplicationContext();
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getUserDataString());
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(paramAppRuntime.getAccount());
      localObject2 = Uri.parse(((StringBuilder)localObject2).toString());
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("key", paramString1);
      paramAppRuntime = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramAppRuntime = "";
      }
      localContentValues.put("value", paramAppRuntime);
      int i = ((Context)localObject1).getContentResolver().update((Uri)localObject2, localContentValues, null, null);
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("[Performance] set, duration=");
        paramAppRuntime.append(SystemClock.uptimeMillis() - l);
        paramAppRuntime.append(", result=");
        paramAppRuntime.append(i);
        QLog.d("VasUserData", 2, paramAppRuntime.toString());
      }
      if (i >= 1) {
        bool = true;
      }
      return bool;
    }
    paramString2 = new StringBuilder();
    paramString2.append("get, app and key MUST NOT be null, context=");
    paramString2.append(paramAppRuntime);
    paramString2.append(", key=");
    paramString2.append(paramString1);
    QLog.d("VasUserData", 1, paramString2.toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasUserData
 * JD-Core Version:    0.7.0.1
 */