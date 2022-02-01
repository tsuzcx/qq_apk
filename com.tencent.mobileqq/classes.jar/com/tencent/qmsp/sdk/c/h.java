package com.tencent.qmsp.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.qmsp.sdk.a.c;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.g;
import com.tencent.qmsp.sdk.f.l;

public class h
{
  private static SharedPreferences a;
  private static final int b;
  
  static
  {
    int j = Build.VERSION.SDK_INT;
    int i = 23;
    if (j < 23) {
      i = 9;
    }
    b = i;
  }
  
  private static void a()
  {
    try
    {
      String[] arrayOfString = new String[b];
      f.a(10L, 0L, 0L, 0L, null, null, null, arrayOfString);
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      int i = 0;
      for (;;)
      {
        int j = arrayOfString.length;
        if (i >= j) {
          break;
        }
        arrayOfString[i] = l.a(arrayOfString[i]);
        localStringBuilder1.append(arrayOfString[i]);
        localStringBuilder1.append(",");
        if (i == 0)
        {
          localStringBuilder2.append(String.format("k%d:", new Object[] { Integer.valueOf(i + 1) }));
          localObject = arrayOfString[i];
        }
        else
        {
          localStringBuilder2.append(String.format(";k%d:", new Object[] { Integer.valueOf(i + 1) }));
          localObject = arrayOfString[i];
        }
        localStringBuilder2.append((String)localObject);
        i += 1;
      }
      localStringBuilder2.append(String.format(";k%d:", new Object[] { Integer.valueOf(arrayOfString.length + 1) }));
      localStringBuilder2.append("4.1");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append(",");
      localStringBuilder1.append(c.a(localStringBuilder2.toString()));
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Java -- cbid: ");
      ((StringBuilder)localObject).append(localStringBuilder1.toString());
      ((StringBuilder)localObject).append(" bidMd5: ");
      ((StringBuilder)localObject).append(c.a(localStringBuilder2.toString()));
      g.b("cbid", 0, ((StringBuilder)localObject).toString());
      com.tencent.qmsp.sdk.a.f.a(localStringBuilder1.toString(), 5);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(long paramLong)
  {
    f.i().c().postDelayed(new h.b(), paramLong);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b.a);
      localStringBuilder.append("qmsp_cbid_time");
      a = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
      b();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b()
  {
    for (;;)
    {
      long l3;
      try
      {
        boolean bool = QmspSDK.getTaskStatus();
        if (!bool)
        {
          g.a("cbid", 1, "Cbid Task Finish！");
          return;
        }
        if (a != null)
        {
          bool = f.i().a(1002).booleanValue();
          long l2 = 28800000L;
          if (!bool)
          {
            a(28800000L);
            return;
          }
          Object localObject = a;
          l1 = 0L;
          l3 = ((SharedPreferences)localObject).getLong("cbid_last_time", 0L);
          long l4 = System.currentTimeMillis();
          l3 = l4 - l3;
          if (l3 >= 0L) {
            break label200;
          }
          if (l1 <= 28800000L) {
            break label206;
          }
          a();
          localObject = a.edit();
          ((SharedPreferences.Editor)localObject).putLong("cbid_last_time", l4);
          ((SharedPreferences.Editor)localObject).commit();
          l1 = l2;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cbid rpt after: ");
          ((StringBuilder)localObject).append(l1);
          g.a("cbid", 1, ((StringBuilder)localObject).toString());
          f.i().c().postDelayed(new h.a(), l1);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label200:
      long l1 = l3;
      continue;
      label206:
      l1 = 28800000L - l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.c.h
 * JD-Core Version:    0.7.0.1
 */