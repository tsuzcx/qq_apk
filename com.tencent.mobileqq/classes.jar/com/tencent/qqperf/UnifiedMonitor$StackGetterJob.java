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
  private int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString = "android.support.v4.";
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(1024);
  private Thread jdField_a_of_type_JavaLangThread;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { "java.", "android.", "com.android.", "dalvik.", "com.google", "libcore.", "sun.", "com.qihoo360.", "com.lbe." };
  private int b;
  private int c;
  private final int d;
  
  public UnifiedMonitor$StackGetterJob(UnifiedMonitor paramUnifiedMonitor, int paramInt, Thread paramThread)
  {
    this.jdField_d_of_type_Int = 10;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;
    int i;
    if (UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int > UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int) {
      i = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int - UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_a_of_type_Int;
    } else {
      i = UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].jdField_d_of_type_Int;
    }
    this.c = i;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(UnifiedMonitor.a(paramUnifiedMonitor)[paramInt].c);
    this.jdField_a_of_type_JavaLangThread = paramThread;
  }
  
  private String a(boolean paramBoolean)
  {
    for (;;)
    {
      int k;
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        localObject = this.jdField_a_of_type_JavaLangThread.getStackTrace();
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
        int m;
        if (!QLog.isColorLevel()) {
          break label269;
        }
        QLog.d("UnifiedMonitor_QAPM", 2, "", localThrowable);
      }
      if (k < localObject.length)
      {
        str = localObject[k].toString();
        arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label291;
        }
        if (!str.startsWith(arrayOfString[j])) {
          break label284;
        }
        if (str.startsWith("android.support.v4."))
        {
          break label291;
          this.jdField_a_of_type_JavaUtilArrayList.add(str);
          break label317;
        }
      }
      else
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          j = UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].i;
          i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j;
          if ((i >= 0) && (i > this.jdField_a_of_type_JavaUtilArrayList.size() - 1 - j - UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].c))
          {
            localObject = this.jdField_a_of_type_JavaLangStringBuilder;
            ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
            ((StringBuilder)localObject).append(",");
            i -= 1;
            continue;
          }
          if (this.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
          {
            localObject = this.jdField_a_of_type_JavaLangStringBuilder.toString();
            return localObject;
          }
          return null;
        }
        label269:
        return null;
        label271:
        k = 0;
        i = 0;
        continue;
      }
      int j = 1;
      break label293;
      label284:
      j += 1;
      continue;
      label291:
      j = 0;
      label293:
      if (j != 0)
      {
        j = i;
        if (i == 0) {}
      }
      else
      {
        j = i;
        if (i != 0) {
          continue;
        }
        j = 1;
        continue;
      }
      label317:
      k += 1;
      int i = j;
    }
  }
  
  public void run()
  {
    Random localRandom = new Random();
    for (;;)
    {
      if (UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].g >= UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Int)
      {
        UnifiedMonitor.a(this.this$0, this.jdField_a_of_type_Int);
        return;
      }
      if (UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long == 0L) {}
      try
      {
        Thread.sleep(this.jdField_b_of_type_Int);
      }
      catch (InterruptedException localInterruptedException)
      {
        label85:
        long l1;
        long l2;
        Object localObject;
        int i;
        break label85;
      }
      continue;
      l1 = UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long;
      if (l1 == 0L)
      {
        Thread.sleep(this.jdField_b_of_type_Int);
      }
      else
      {
        l2 = SystemClock.uptimeMillis() - UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long - UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_a_of_type_Int;
        if (l2 < -10L)
        {
          l2 = -l2;
          Thread.sleep(l2);
        }
        if (l1 == UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long)
        {
          localObject = UnifiedMonitor.a(this.this$0);
          i = this.jdField_a_of_type_Int;
          localObject[i].jdField_b_of_type_Boolean = this.this$0.whetherReportThisTime(i, false);
          i = this.jdField_a_of_type_Int;
          if (((i == 0) || (i == 10) || (i == 14) || (i == 19)) && (QLog.isColorLevel()))
          {
            Thread.sleep(200L);
            if (l1 == UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long)
            {
              localObject = a(true);
              QLog.w("UnifiedMonitor_QAPM", 2, (String)localObject);
              UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = ((String)localObject);
              localObject = Message.obtain(UnifiedMonitor.a(this.this$0), 2);
              ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
              UnifiedMonitor.a(this.this$0).sendMessageDelayed((Message)localObject, -SystemClock.uptimeMillis() + l1 + 3000L);
            }
          }
          else if (UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Boolean)
          {
            l2 = localRandom.nextInt(this.c);
            Thread.sleep(l2);
            if (l1 == UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long) {
              if (UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_d_of_type_Boolean)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangThread);
                ((StringBuilder)localObject).append(" held: ");
                ((StringBuilder)localObject).append(a(true));
                QLog.e("UnifiedMonitor_QAPM", 1, ((StringBuilder)localObject).toString());
                this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangThread);
              }
              else
              {
                UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = a(true);
              }
            }
          }
          if (l1 == UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long) {
            UnifiedMonitor.a(this.this$0)[this.jdField_a_of_type_Int].jdField_b_of_type_Long = 0L;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.UnifiedMonitor.StackGetterJob
 * JD-Core Version:    0.7.0.1
 */