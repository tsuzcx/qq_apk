package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class CommonUtil
{
  public static final Uri a()
  {
    String str = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("LastScreenShotUri", "");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public static String a(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(((Time)localObject).year);
    localStringBuilder.append(((Time)localObject).month + 1);
    localStringBuilder.append(((Time)localObject).monthDay);
    localStringBuilder.append(((Time)localObject).hour);
    if (paramBoolean) {
      localStringBuilder.append(((Time)localObject).minute - 1);
    } else {
      localStringBuilder.append(((Time)localObject).minute);
    }
    if (paramArrayList == null) {
      paramArrayList = "null";
    } else {
      paramArrayList = paramArrayList.toString();
    }
    localStringBuilder.append(paramArrayList);
    paramArrayList = MD5.toMD5(localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramArrayList);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    return MD5.toMD5(((StringBuilder)localObject).toString());
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong1 != 0L)
    {
      if (paramLong2 == 0L) {
        return false;
      }
      long l = System.currentTimeMillis();
      bool1 = bool2;
      if (l >= paramLong1)
      {
        bool1 = bool2;
        if (l <= paramLong2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (!paramString.equals(a(paramArrayList, false))) {
        return paramString.equals(a(paramArrayList, true));
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(ArrayList<String> paramArrayList, Context paramContext)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return true;
      }
      paramContext = MobileQQ.processName;
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (paramContext.equals(paramArrayList.get(i))) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    return true;
  }
  
  public static String b()
  {
    Time localTime = new Time();
    localTime.setToNow();
    localTime.switchTimezone("Asia/Shanghai");
    return localTime.format("%Y%m%d%H%M%S");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.CommonUtil
 * JD-Core Version:    0.7.0.1
 */