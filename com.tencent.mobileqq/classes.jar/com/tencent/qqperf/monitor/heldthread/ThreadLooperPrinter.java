package com.tencent.qqperf.monitor.heldthread;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.UnifiedMonitor;
import java.util.HashMap;
import java.util.Map;
import mqq.app.Foreground;

class ThreadLooperPrinter
  implements Printer
{
  public static int a = 200;
  private long b;
  private long c;
  private long d;
  private String e;
  private int f = 0;
  private int g = 0;
  private String h;
  
  ThreadLooperPrinter(int paramInt, String paramString)
  {
    this.g = paramInt;
    this.h = paramString;
  }
  
  private static String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (!paramString.startsWith(">>>")) {
        return null;
      }
      int i = paramString.indexOf('(');
      if (i == -1) {
        return null;
      }
      int j = paramString.indexOf(')', i);
      if (j == -1) {
        return null;
      }
      String str1 = paramString.substring(i + 1, j);
      i = paramString.indexOf("} ", j);
      if (i == -1) {
        return null;
      }
      int k = i + 2;
      j = paramString.indexOf('@', k);
      i = j;
      if (j == -1)
      {
        j = paramString.indexOf(':', k);
        i = j;
        if (j == -1)
        {
          i = paramString.indexOf(' ', k);
          if (i == -1) {
            return null;
          }
        }
      }
      String str2 = paramString.substring(k, i);
      i = paramString.indexOf(": ", i);
      if (i == -1) {
        return null;
      }
      return String.format("%s|%s|%s", new Object[] { str1, str2, paramString.substring(i + 2) });
    }
    return null;
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting threshold, threshold=");
      localStringBuilder.append(paramInt);
      QLog.d("TM.global.LooperPrinter", 2, localStringBuilder.toString());
    }
    a = paramInt;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.d = SystemClock.uptimeMillis();
      this.e = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.g)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.g);
      }
    }
    else if ((this.d != 0L) && (paramString.startsWith("<<")))
    {
      this.b += 1L;
      long l = SystemClock.uptimeMillis() - this.d;
      this.d = 0L;
      this.c += l;
      Object localObject = null;
      paramString = (String)localObject;
      if (QLog.isColorLevel()) {
        if (ThreadSetting.logcatBgTaskMonitor)
        {
          paramString = a(this.e);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.h);
          ((StringBuilder)localObject).append(", cost=");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("AutoMonitor", 2, ((StringBuilder)localObject).toString());
        }
        else
        {
          paramString = (String)localObject;
          if (l >= 200L)
          {
            paramString = a(this.e);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.h);
            ((StringBuilder)localObject).append(" OOT cost=");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append(paramString);
            QLog.e("AutoMonitor", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if (l > a)
      {
        if (!UnifiedMonitor.a().whetherReportThisTime(this.g))
        {
          this.f = 0;
          return;
        }
        localObject = paramString;
        if (paramString == null) {
          localObject = a(this.e);
        }
        HashMap localHashMap = new HashMap(8);
        paramString = Foreground.getTopActivity();
        if (paramString != null) {
          paramString = paramString.getClass().getName();
        } else {
          paramString = "";
        }
        localHashMap.put("act", paramString);
        UnifiedMonitor.a().addEvent(this.g, (String)localObject, (int)l, this.f, localHashMap);
        this.f = 0;
        return;
      }
      if (UnifiedMonitor.a().whetherStackEnabled(this.g)) {
        UnifiedMonitor.a().notifyNotTimeout(this.g);
      }
      this.f += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(msgCount = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", totalCost = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.heldthread.ThreadLooperPrinter
 * JD-Core Version:    0.7.0.1
 */