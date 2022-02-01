package com.tencent.mobileqq.soload.util;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.api.impl.DownSoLoader;
import com.tencent.mobileqq.soload.api.impl.ISoLoader;
import com.tencent.mobileqq.soload.api.impl.SoloadServiceImpl;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class SoCrashUtils
{
  private static ISoLoader a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (SoloadServiceImpl.LOADER_IN_LOADING)
    {
      Object localObject2 = new LinkedList(SoloadServiceImpl.LOADER_IN_LOADING.values());
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ISoLoader)((Iterator)???).next();
        if ((localObject2 != null) && (((ISoLoader)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = DownSoLoader.a().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = "lib" + str1 + ".so";
      if ((!TextUtils.isEmpty(str2)) && (paramString.contains(str2))) {
        return str1;
      }
    }
    return null;
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    paramString2 = null;
    if (TextUtils.isEmpty(paramString3)) {
      return;
    }
    for (;;)
    {
      try
      {
        String str = a(paramString3);
        if (TextUtils.isEmpty(str))
        {
          localObject = a(paramString3);
          paramString2 = (String)localObject;
          if (localObject == null)
          {
            if (!paramString3.contains("com.tencent.mobileqq.soload")) {
              break;
            }
            paramString2 = (String)localObject;
          }
        }
        Object localObject = MobileQQ.processName;
        paramString1 = "process:" + (String)localObject + "msg:" + paramString1 + paramString3;
        if (!TextUtils.isEmpty(str))
        {
          paramString2 = DownSoLoader.a(str);
          SoCrashInfo.a(str, paramString2, 1);
          SoReportUtil.a("ver=" + paramString2, "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
          SoReportUtil.a(paramString1);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      if (paramString2 != null) {
        paramString2.a(paramString1);
      } else {
        SoReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", "SoLoadWidget", 2, paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoCrashUtils
 * JD-Core Version:    0.7.0.1
 */