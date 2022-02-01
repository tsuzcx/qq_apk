package com.tencent.qqperf;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class UnifiedMonitor$StackGetterJob
  implements Runnable
{
  private int a;
  private int b;
  private int c;
  private final int d = 10;
  private ArrayList<String> e;
  private StringBuilder f = new StringBuilder(1024);
  private Thread g;
  private final String[] h = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private final String i = "android.support.v4.";
  
  public UnifiedMonitor$StackGetterJob(UnifiedMonitor paramUnifiedMonitor, int paramInt, Thread paramThread)
  {
    this.a = paramInt;
    this.b = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].a;
    int j;
    if (UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].f > UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].a) {
      j = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].f - UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].a;
    } else {
      j = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].f;
    }
    this.c = j;
    this.e = new ArrayList(UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].e);
    this.g = paramThread;
  }
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      int m;
      try
      {
        this.e.clear();
        localObject = this.g.getStackTrace();
        if (localObject == null) {
          return null;
        }
        if (!paramBoolean) {
          break label271;
        }
        return Arrays.toString((Object[])localObject);
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        String str;
        String[] arrayOfString;
        int n;
        if (!QLog.isColorLevel()) {
          break label269;
        }
        QLog.d("UnifiedMonitor_QAPM", 2, "", localThrowable);
      }
      if (m < localObject.length)
      {
        str = localObject[m].toString();
        arrayOfString = this.h;
        n = arrayOfString.length;
        k = 0;
        if (k >= n) {
          break label291;
        }
        if (!str.startsWith(arrayOfString[k])) {
          break label284;
        }
        if (str.startsWith("android.support.v4."))
        {
          break label291;
          this.e.add(str);
          break label317;
        }
      }
      else
      {
        if (this.e.size() > 0)
        {
          this.f.setLength(0);
          k = UnifiedMonitor.a(this.this$0)[this.a].s;
          j = this.e.size() - 1 - k;
          if ((j >= 0) && (j > this.e.size() - 1 - k - UnifiedMonitor.a(this.this$0)[this.a].e))
          {
            localObject = this.f;
            ((StringBuilder)localObject).append((String)this.e.get(j));
            ((StringBuilder)localObject).append(",");
            j -= 1;
            continue;
          }
          if (this.f.length() > 0)
          {
            localObject = this.f.toString();
            return localObject;
          }
          return null;
        }
        label269:
        return null;
        label271:
        m = 0;
        j = 0;
        continue;
      }
      int k = 1;
      break label293;
      label284:
      k += 1;
      continue;
      label291:
      k = 0;
      label293:
      if (k != 0)
      {
        k = j;
        if (j == 0) {}
      }
      else
      {
        k = j;
        if (j != 0) {
          continue;
        }
        k = 1;
        continue;
      }
      label317:
      m += 1;
      int j = k;
    }
  }
  
  public void run()
  {
    Random localRandom = new Random();
    for (;;)
    {
      if (UnifiedMonitor.a(this.this$0)[this.a].i >= UnifiedMonitor.a(this.this$0)[this.a].b)
      {
        UnifiedMonitor.a(this.this$0, this.a);
        return;
      }
      if (UnifiedMonitor.a(this.this$0)[this.a].o == 0L) {}
      try
      {
        Thread.sleep(this.b);
      }
      catch (InterruptedException localInterruptedException)
      {
        label85:
        long l1;
        long l2;
        Object localObject;
        int j;
        break label85;
      }
      continue;
      l1 = UnifiedMonitor.a(this.this$0)[this.a].o;
      if (l1 == 0L)
      {
        Thread.sleep(this.b);
      }
      else
      {
        l2 = SystemClock.uptimeMillis() - UnifiedMonitor.a(this.this$0)[this.a].o - UnifiedMonitor.a(this.this$0)[this.a].a;
        if (l2 < -10L)
        {
          l2 = -l2;
          Thread.sleep(l2);
        }
        if (l1 == UnifiedMonitor.a(this.this$0)[this.a].o)
        {
          localObject = UnifiedMonitor.a(this.this$0);
          j = this.a;
          localObject[j].m = this.this$0.whetherReportThisTime(j, false);
          j = this.a;
          if (((j == 0) || (j == 10) || (j == 14) || (j == 19)) && (QLog.isColorLevel()))
          {
            Thread.sleep(200L);
            if (l1 == UnifiedMonitor.a(this.this$0)[this.a].o)
            {
              localObject = a(true);
              QLog.w("UnifiedMonitor_QAPM", 2, (String)localObject);
              UnifiedMonitor.a(this.this$0)[this.a].n = ((String)localObject);
              localObject = Message.obtain(UnifiedMonitor.b(this.this$0), 2);
              ((Message)localObject).arg1 = this.a;
              UnifiedMonitor.b(this.this$0).sendMessageDelayed((Message)localObject, -SystemClock.uptimeMillis() + l1 + 3000L);
            }
          }
          else if (UnifiedMonitor.a(this.this$0)[this.a].m)
          {
            l2 = localRandom.nextInt(this.c);
            Thread.sleep(l2);
            if (l1 == UnifiedMonitor.a(this.this$0)[this.a].o) {
              if (UnifiedMonitor.a(this.this$0)[this.a].t)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.g);
                ((StringBuilder)localObject).append(" held: ");
                ((StringBuilder)localObject).append(a(true));
                QLog.e("UnifiedMonitor_QAPM", 1, ((StringBuilder)localObject).toString());
                this.this$0.a(this.a, this.g);
              }
              else
              {
                UnifiedMonitor.a(this.this$0)[this.a].n = a(true);
              }
            }
          }
          if (l1 == UnifiedMonitor.a(this.this$0)[this.a].o) {
            UnifiedMonitor.a(this.this$0)[this.a].o = 0L;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor.StackGetterJob
 * JD-Core Version:    0.7.0.1
 */