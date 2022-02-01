package com.tencent.mobileqq.statistics;

import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.util.IUtilApi;
import com.tencent.util.UtilApi;
import java.util.Iterator;
import java.util.LinkedList;

public class ViewExposeUtil
{
  public static LinkedList<ViewExposeUtil.ViewExposeUnit> a = new LinkedList();
  
  public static ViewExposeUtil.ViewExposeUnit a(Class paramClass, int paramInt)
  {
    if (paramClass == null) {
      return null;
    }
    int i = a.size() - 1;
    while (i >= 0)
    {
      ViewExposeUtil.ViewExposeUnit localViewExposeUnit = (ViewExposeUtil.ViewExposeUnit)a.get(i);
      if ((paramClass == localViewExposeUnit.a) && (paramInt == localViewExposeUnit.b))
      {
        a.remove(i);
        return localViewExposeUnit;
      }
      i -= 1;
    }
    return null;
  }
  
  public static void a(long paramLong)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      ViewExposeUtil.ViewExposeUnit localViewExposeUnit = (ViewExposeUtil.ViewExposeUnit)localIterator.next();
      localViewExposeUnit.c += paramLong;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Class paramClass, int paramInt1, String paramString, int paramInt2)
  {
    a(paramAppInterface, paramClass, paramInt1, paramString, paramInt2, "");
  }
  
  public static void a(AppInterface paramAppInterface, Class paramClass, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramClass == null) {
      return;
    }
    int i = a.size();
    if (i > 0)
    {
      i -= 1;
      while (i >= 0)
      {
        ViewExposeUtil.ViewExposeUnit localViewExposeUnit = (ViewExposeUtil.ViewExposeUnit)a.get(i);
        if (localViewExposeUnit.a == paramClass)
        {
          if ((paramAppInterface instanceof BaseQQAppInterface)) {
            ReportController.b((BaseQQAppInterface)paramAppInterface, "CliOper", "", "", localViewExposeUnit.d, localViewExposeUnit.d, localViewExposeUnit.e, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.c), "", "");
          } else if (paramAppInterface != null) {
            UtilApi.b.a(paramAppInterface, "CliOper", "", "", localViewExposeUnit.d, localViewExposeUnit.d, localViewExposeUnit.e, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.c), "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", localViewExposeUnit.d, localViewExposeUnit.d, localViewExposeUnit.e, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - localViewExposeUnit.c), "", "");
          }
          a.remove(i);
        }
        i -= 1;
      }
    }
    paramAppInterface = new ViewExposeUtil.ViewExposeUnit();
    paramAppInterface.a = paramClass;
    paramAppInterface.b = paramInt1;
    paramAppInterface.c = SystemClock.elapsedRealtime();
    paramAppInterface.d = paramString1;
    paramAppInterface.e = paramInt2;
    a.add(paramAppInterface);
  }
  
  public static void a(Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    if (paramClass != null)
    {
      if (paramString == null) {
        return;
      }
      String str;
      if (paramString.contains("/qunactivity/")) {
        str = "0X8004EC8";
      } else {
        str = null;
      }
      if (paramString.contains("/hotchat/"))
      {
        paramInt2 = 2;
        str = "0X8004410";
      }
      if (str != null) {
        a(null, paramClass, paramInt1, str, paramInt2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.ViewExposeUtil
 * JD-Core Version:    0.7.0.1
 */