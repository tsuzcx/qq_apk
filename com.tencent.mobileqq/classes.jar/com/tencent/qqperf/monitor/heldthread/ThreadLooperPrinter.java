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
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  
  ThreadLooperPrinter(int paramInt, String paramString)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
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
    jdField_a_of_type_Int = paramInt;
  }
  
  public void println(String paramString)
  {
    if (paramString.startsWith(">>"))
    {
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_JavaLangString = paramString;
      if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_c_of_type_Int)) {
        UnifiedMonitor.a().reportStackIfTimeout(this.jdField_c_of_type_Int);
      }
    }
    else if ((this.jdField_c_of_type_Long != 0L) && (paramString.startsWith("<<")))
    {
      this.jdField_a_of_type_Long += 1L;
      long l = SystemClock.uptimeMillis() - this.jdField_c_of_type_Long;
      this.jdField_c_of_type_Long = 0L;
      this.jdField_b_of_type_Long += l;
      Object localObject = null;
      paramString = (String)localObject;
      if (QLog.isColorLevel()) {
        if (ThreadSetting.logcatBgTaskMonitor)
        {
          paramString = a(this.jdField_a_of_type_JavaLangString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
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
            paramString = a(this.jdField_a_of_type_JavaLangString);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" OOT cost=");
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append(paramString);
            QLog.e("AutoMonitor", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if (l > jdField_a_of_type_Int)
      {
        if (!UnifiedMonitor.a().whetherReportThisTime(this.jdField_c_of_type_Int))
        {
          this.jdField_b_of_type_Int = 0;
          return;
        }
        localObject = paramString;
        if (paramString == null) {
          localObject = a(this.jdField_a_of_type_JavaLangString);
        }
        HashMap localHashMap = new HashMap(8);
        paramString = Foreground.getTopActivity();
        if (paramString != null) {
          paramString = paramString.getClass().getName();
        } else {
          paramString = "";
        }
        localHashMap.put("act", paramString);
        UnifiedMonitor.a().addEvent(this.jdField_c_of_type_Int, (String)localObject, (int)l, this.jdField_b_of_type_Int, localHashMap);
        this.jdField_b_of_type_Int = 0;
        return;
      }
      if (UnifiedMonitor.a().whetherStackEnabled(this.jdField_c_of_type_Int)) {
        UnifiedMonitor.a().notifyNotTimeout(this.jdField_c_of_type_Int);
      }
      this.jdField_b_of_type_Int += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(msgCount = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", totalCost = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.heldthread.ThreadLooperPrinter
 * JD-Core Version:    0.7.0.1
 */