package com.tencent.mobileqq.soload.util;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.api.impl.ISoLoader;
import com.tencent.mobileqq.soload.api.impl.SoLoaderLogic;
import com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl;
import com.tencent.mobileqq.soload.entity.SoCrashInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class SoCrashUtils
{
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = SoLoaderLogic.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lib");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".so");
      localObject = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramString.contains((CharSequence)localObject))) {
        return str;
      }
    }
    return null;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Object localObject1 = null;
    try
    {
      String str = a(paramString2);
      if (TextUtils.isEmpty(str))
      {
        localObject2 = b(paramString2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if (!paramString2.contains("com.tencent.mobileqq.soload")) {
            return;
          }
          localObject1 = localObject2;
        }
      }
      Object localObject2 = MobileQQ.processName;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("process:");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("msg:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      if (!TextUtils.isEmpty(str))
      {
        paramString2 = SoLoaderLogic.c(str);
        SoCrashInfo.a(str, paramString2, 1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ver=");
        ((StringBuilder)localObject1).append(paramString2);
        SoReportUtil.a(((StringBuilder)localObject1).toString(), "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
      }
      else if (localObject1 != null)
      {
        ((ISoLoader)localObject1).b(paramString1);
      }
      else
      {
        SoReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", "SoLoadWidget", 2, paramString1);
      }
      SoReportUtil.a(paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static ISoLoader b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (SoLoaderServiceImpl.LOADER_IN_LOADING)
    {
      Object localObject2 = new LinkedList(SoLoaderServiceImpl.LOADER_IN_LOADING.values());
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ISoLoader)((Iterator)???).next();
        if ((localObject2 != null) && (((ISoLoader)localObject2).a(paramString))) {
          return localObject2;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoCrashUtils
 * JD-Core Version:    0.7.0.1
 */