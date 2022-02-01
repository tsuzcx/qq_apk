package com.tencent.mobileqq.flashshow.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Set;

public class FSSpUtil
{
  public static SharedPreferences a(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str = "sp_qqcircle";
    if (paramBoolean1)
    {
      str = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_qqcircle");
      localStringBuilder.append("_");
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
    }
    int j = 0;
    int i = j;
    if (paramBoolean2)
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 11) {
        i = 4;
      }
    }
    if (RFApplication.getApplication() != null) {
      return RFApplication.getApplication().getSharedPreferences(str, i);
    }
    return null;
  }
  
  public static Object a(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    SharedPreferences localSharedPreferences = a(paramBoolean1, paramBoolean2);
    if (localSharedPreferences != null)
    {
      if ((paramObject instanceof Integer)) {
        return Integer.valueOf(localSharedPreferences.getInt(paramString, ((Integer)paramObject).intValue()));
      }
      if ((paramObject instanceof String)) {
        return localSharedPreferences.getString(paramString, (String)paramObject);
      }
      if ((paramObject instanceof Boolean)) {
        return Boolean.valueOf(localSharedPreferences.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
      }
      if ((paramObject instanceof Float)) {
        return Float.valueOf(localSharedPreferences.getFloat(paramString, ((Float)paramObject).floatValue()));
      }
      if ((paramObject instanceof Long)) {
        return Long.valueOf(localSharedPreferences.getLong(paramString, ((Long)paramObject).longValue()));
      }
      if ((paramObject instanceof Set)) {
        return localSharedPreferences.getStringSet(paramString, (Set)paramObject);
      }
    }
    return null;
  }
  
  public static boolean a(String paramString, Object paramObject)
  {
    Object localObject = a(true, true);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if ((paramObject instanceof Integer)) {
        ((SharedPreferences.Editor)localObject).putInt(paramString, ((Integer)paramObject).intValue());
      } else if ((paramObject instanceof String)) {
        ((SharedPreferences.Editor)localObject).putString(paramString, (String)paramObject);
      } else if ((paramObject instanceof Boolean)) {
        ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramObject).booleanValue());
      } else if ((paramObject instanceof Float)) {
        ((SharedPreferences.Editor)localObject).putFloat(paramString, ((Float)paramObject).floatValue());
      } else if ((paramObject instanceof Long)) {
        ((SharedPreferences.Editor)localObject).putLong(paramString, ((Long)paramObject).longValue());
      } else if ((paramObject instanceof Set)) {
        ((SharedPreferences.Editor)localObject).putStringSet(paramString, (Set)paramObject);
      }
      return ((SharedPreferences.Editor)localObject).commit();
    }
    return false;
  }
  
  public static Object b(String paramString, Object paramObject)
  {
    return a(paramString, paramObject, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.utils.FSSpUtil
 * JD-Core Version:    0.7.0.1
 */