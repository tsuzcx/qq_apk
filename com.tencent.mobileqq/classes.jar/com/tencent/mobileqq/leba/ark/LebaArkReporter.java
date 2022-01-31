package com.tencent.mobileqq.leba.ark;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.LebaUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class LebaArkReporter
  implements Handler.Callback
{
  public static int a;
  public static long a;
  private static LebaArkReporter jdField_a_of_type_ComTencentMobileqqLebaArkLebaArkReporter;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private int b;
  
  static
  {
    jdField_a_of_type_Long = 3000L;
    jdField_a_of_type_Int = 5;
  }
  
  public LebaArkReporter()
  {
    int i = c();
    int j = LebaUtils.a(0);
    if (i != j)
    {
      this.b = 0;
      a(0);
      b(j);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaArkReporter", 2, "LebaArkReporter oldCrashCount=" + this.b);
      }
      if (a() > 0)
      {
        this.b += 1;
        a(this.b);
        b(j);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
      }
      if (!a()) {
        StatisticCollector.a(BaseApplication.getContext()).a("", "newleba_feeds_ark_crash_threshold", false, 0L, 0L, null, "");
      }
      return;
      this.b = b();
    }
  }
  
  public static LebaArkReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqLebaArkLebaArkReporter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqLebaArkLebaArkReporter == null) {
        jdField_a_of_type_ComTencentMobileqqLebaArkLebaArkReporter = new LebaArkReporter();
      }
      return jdField_a_of_type_ComTencentMobileqqLebaArkLebaArkReporter;
    }
    finally {}
  }
  
  public int a()
  {
    try
    {
      int i = BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0).getInt("show_count", 0);
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("LebaArkReporter", 1, "getShowCount exception", localException);
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaArkReporter", 2, "setCrashCount " + paramInt);
    }
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0).edit().putInt("crash_count_7.6.8", paramInt).apply();
      if (QLog.isColorLevel()) {
        QLog.i("LebaArkReporter", 2, "setCrashCount n=" + paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("LebaArkReporter", 1, "setCrashCount exception", localException);
    }
  }
  
  public boolean a()
  {
    if (this.b <= jdField_a_of_type_Int) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaArkReporter", 2, "canShowArk=" + bool + ", mCrashCount=" + this.b + ", sCrashThreshold=" + jdField_a_of_type_Int);
      }
      return bool;
    }
  }
  
  public int b()
  {
    try
    {
      int i = BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0).getInt("crash_count_7.6.8", 0);
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("LebaArkReporter", 1, "getShowCount exception", localException);
    }
    return 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, jdField_a_of_type_Long);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaArkReporter", 2, "setCrashTime " + paramInt);
    }
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0).edit().putInt("crash_time", paramInt).apply();
      if (QLog.isColorLevel()) {
        QLog.i("LebaArkReporter", 2, "setCrashTime n=" + paramInt);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("LebaArkReporter", 1, "setCrashTime exception", localException);
    }
  }
  
  public int c()
  {
    try
    {
      int i = BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0).getInt("crash_time", 0);
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("LebaArkReporter", 1, "getShowCount exception", localException);
    }
    return 0;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      int i;
      try
      {
        paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0);
        i = paramMessage.getInt("show_count", 0);
        paramMessage.edit().putInt("show_count", i + 1).apply();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("LebaArkReporter", 2, "MSG_INC_COUNT n=" + (i + 1));
        return true;
      }
      catch (Exception paramMessage)
      {
        QLog.e("LebaArkReporter", 1, "MSG_INC_COUNT exception", paramMessage);
        return true;
      }
      try
      {
        paramMessage = BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0);
        i = paramMessage.getInt("show_count", 0);
        paramMessage.edit().putInt("show_count", i - 1).apply();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("LebaArkReporter", 2, "MSG_DESC_COUNT n=" + (i - 1));
        return true;
      }
      catch (Exception paramMessage)
      {
        QLog.e("LebaArkReporter", 1, "MSG_DESC_COUNT exception", paramMessage);
        return true;
      }
      try
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("Leba_ark", 0).edit().putInt("show_count", 0).apply();
        if (QLog.isColorLevel())
        {
          QLog.i("LebaArkReporter", 2, "MSG_RESET_COUNT done");
          return true;
        }
      }
      catch (Exception paramMessage)
      {
        QLog.e("LebaArkReporter", 1, "MSG_RESET_COUNT exception", paramMessage);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.ark.LebaArkReporter
 * JD-Core Version:    0.7.0.1
 */