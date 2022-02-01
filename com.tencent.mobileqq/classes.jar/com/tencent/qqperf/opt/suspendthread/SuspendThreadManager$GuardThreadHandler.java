package com.tencent.qqperf.opt.suspendthread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class SuspendThreadManager$GuardThreadHandler
  extends Handler
{
  private final float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private SuspendThreadManager.WatchdogHandler jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$WatchdogHandler;
  private File jdField_a_of_type_JavaIoFile = null;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private Thread jdField_b_of_type_JavaLangThread;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = true;
  
  public SuspendThreadManager$GuardThreadHandler(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(",createCheckFile");
      QLog.d("TSManager", 1, localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(",deleteCheckFile");
      QLog.d("TSManager", 1, localStringBuilder.toString());
    }
    if (paramBoolean) {}
    try
    {
      if (this.jdField_a_of_type_JavaIoFile.exists()) {
        return;
      }
      this.jdField_a_of_type_JavaIoFile.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      QLog.e("TSManager", 1, "createOrDelSuspendCheckFile failed", paramString);
    }
    if (this.jdField_a_of_type_JavaIoFile.exists())
    {
      this.jdField_a_of_type_JavaIoFile.delete();
      return;
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_error_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_error_count", i + 1);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, SuspendThreadManager.d());
  }
  
  private void a(boolean paramBoolean)
  {
    SuspendThreadManager.a(0);
    try
    {
      if (SuspendThreadManager.a().isEmpty())
      {
        e();
        SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, paramBoolean);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaIoFile.exists();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
  
  private void c()
  {
    SuspendThreadManager.a().a(ThreadManager.getSubThread().getName());
    SuspendThreadManager.a().a(ThreadManager.getRecentThread().getName());
    SuspendThreadManager.a().a("MSF-Receiver");
    SuspendThreadManager.a().a("QQ_DB");
    SuspendThreadManager.a().a("QQ_FILE_RW");
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        System.loadLibrary("threadsuspend");
        this.jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.getContext().getSharedPreferences("suspend_thread_pref_file", 0);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(MobileQQ.getContext().getFilesDir().getPath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("suspend_check_file");
        this.jdField_a_of_type_JavaIoFile = new File(localStringBuilder.toString());
        this.jdField_d_of_type_Boolean = DeviceOptSwitch.g;
        this.e = DeviceOptSwitch.h;
        if ((Build.VERSION.SDK_INT <= 23) && (DeviceOptSwitch.f))
        {
          SuspendThreadManager.jdField_a_of_type_Int |= 0x1;
          bool1 = true;
        }
        else
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label711;
          }
          SuspendThreadManager.jdField_a_of_type_Int |= 0x2;
          break label711;
        }
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspendCrashCount", 0);
        if (this.jdField_b_of_type_Int > SuspendThreadManager.b())
        {
          SuspendThreadManager.jdField_a_of_type_Int |= 0x8;
          bool1 = false;
        }
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("notResumeCountNew", 0);
        if (a())
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("notResumeCountNew", this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
          l();
        }
        b();
        if (this.jdField_a_of_type_Int > SuspendThreadManager.c())
        {
          SuspendThreadManager.jdField_a_of_type_Int |= 0x10;
          bool1 = false;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mCurrentNotResumeCount = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(",mCurrentCrashCount = ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append(",tempInitedSuccessful = ");
        localStringBuilder.append(bool1);
        QLog.d("TSManager", 1, localStringBuilder.toString());
        if (bool1)
        {
          Process.setThreadPriority(-2);
          if (Math.random() >= 0.1000000014901161D) {
            break label716;
          }
          bool2 = true;
          this.jdField_c_of_type_Boolean = bool2;
          SuspendThreadManager.a(SuspendThreadManager.a());
          this.jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
          this.jdField_b_of_type_JavaLangThread = SuspendThreadManager.a().getLooper().getThread();
          this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("suspendWatchdogThread");
          this.jdField_a_of_type_AndroidOsHandlerThread.start();
          this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$WatchdogHandler = new SuspendThreadManager.WatchdogHandler(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), Thread.currentThread(), this);
          SuspendThreadManager.b(SuspendThreadManager.a(this.jdField_a_of_type_AndroidOsHandlerThread));
          SuspendThreadManager.c(SuspendThreadManager.a(SuspendThreadManager.a()));
          SuspendThreadManager.d(SuspendThreadManager.a(this.jdField_a_of_type_JavaLangThread));
          this.jdField_d_of_type_Int = SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, SuspendThreadManager.b(), SuspendThreadManager.d());
          k();
          SuspendThreadManager.b().add(this.jdField_a_of_type_JavaLangThread);
          SuspendThreadManager.b().add(this.jdField_b_of_type_JavaLangThread);
          SuspendThreadManager.b().add(this.jdField_a_of_type_AndroidOsHandlerThread);
          c();
        }
        SuspendThreadManager.b(bool1);
        QLog.d("TSManager", 1, new Object[] { "init finished:", "mNativeApiSupportValue = ", Integer.valueOf(this.jdField_d_of_type_Int), ",sGuardThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.d()), ",sMainThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.e()), ",mFetchMainStackThisTime = ", Boolean.valueOf(this.jdField_c_of_type_Boolean), ",bDalvikVm = ", Boolean.valueOf(SuspendThreadManager.b()), ",sInitedSuccessful = ", Boolean.valueOf(SuspendThreadManager.c()), ",bIsFakeSuspendUser = ", Boolean.valueOf(this.jdField_d_of_type_Boolean), ",bSuspendWhiteListThreadOnly = ", Boolean.valueOf(this.e) });
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TSManager", 1, "libthreadsuspend load failed !!!", localThrowable);
        SuspendThreadManager.b(false);
        SuspendThreadManager.jdField_a_of_type_Int |= 0x20;
        return;
      }
      label711:
      boolean bool1 = false;
      continue;
      label716:
      boolean bool2 = false;
    }
  }
  
  private void e()
  {
    synchronized ()
    {
      SuspendThreadManager.a().clear();
      SuspendThreadManager.a().clear();
      SuspendThreadManager.b().clear();
      a("preSuspendThread", true);
      this.jdField_c_of_type_Int = 0;
      h();
      this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$WatchdogHandler.a();
      return;
    }
  }
  
  private void f()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.a().size() > 0)
    {
      SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, SuspendThreadManager.d());
      a(1);
    }
  }
  
  private void g()
  {
    if (SuspendThreadManager.a().size() > 0)
    {
      SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, SuspendThreadManager.d());
      a(2);
    }
  }
  
  private void h()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    sendMessageDelayed(localMessage, SuspendThreadManager.a());
  }
  
  private void i()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.a().size() > 0)
    {
      ??? = this.jdField_a_of_type_JavaLangThread.getState();
      this.jdField_c_of_type_Int += 1;
      Object localObject3;
      if (??? == Thread.State.BLOCKED)
      {
        if ((!this.jdField_b_of_type_Boolean) && (!SuspendThreadManager.b()) && (!SuspendThreadManager.a().isEmpty()))
        {
          int i = SuspendThreadManager.a(SuspendThreadManager.a(), SuspendThreadManager.e());
          Thread localThread1 = (Thread)SuspendThreadManager.a().get(Integer.valueOf(i));
          if ((localThread1 != null) && (SuspendThreadManager.a().contains(localThread1)))
          {
            i = SuspendThreadManager.a(SuspendThreadManager.a(), localThread1, SuspendThreadManager.d());
            if ((1 == i) || (2 == i)) {
              synchronized (SuspendThreadManager.a())
              {
                SuspendThreadManager.a().remove(localThread1);
              }
            }
          }
          this.jdField_b_of_type_Boolean = true;
        }
        else
        {
          if (this.jdField_c_of_type_Boolean)
          {
            ??? = SuspendThreadManager.a(this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager, this.jdField_a_of_type_JavaLangThread, "Blocked");
            localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences$Editor;
            if (localObject3 != null)
            {
              ((SharedPreferences.Editor)localObject3).putString("main_thread_stack", (String)???);
              this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
            }
          }
          g();
        }
      }
      else if ((??? != Thread.State.WAITING) && (??? != Thread.State.TIMED_WAITING))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_c_of_type_Int * SuspendThreadManager.a() > 1000L)
        {
          g();
          this.jdField_c_of_type_Int = 0;
        }
      }
      else if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          localObject3 = this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager;
          Thread localThread2 = this.jdField_a_of_type_JavaLangThread;
          if (??? == Thread.State.WAITING) {
            ??? = "Waiting";
          } else {
            ??? = "TimedWaiting";
          }
          ??? = SuspendThreadManager.a((SuspendThreadManager)localObject3, localThread2, (String)???);
          localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences$Editor;
          if (localObject3 != null)
          {
            ((SharedPreferences.Editor)localObject3).putString("main_thread_stack", (String)???);
            this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
          }
        }
        g();
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
      }
    }
    if (!SuspendThreadManager.a().isEmpty()) {
      h();
    }
  }
  
  private void j()
  {
    a(3);
  }
  
  private void k()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap;
    if (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_report_time", 0L) > 86400000L)
    {
      localHashMap = new HashMap(10);
      localHashMap.put("api_support_cond", String.valueOf(this.jdField_d_of_type_Int));
      localHashMap.put("resume_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("normal_resume_count", 0)));
      localHashMap.put("timeout_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_resume_count", 0)));
      localHashMap.put("watchdog_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("watchdog_resume_count", 0)));
      localHashMap.put("main_thread_stack", this.jdField_a_of_type_AndroidContentSharedPreferences.getString("main_thread_stack", ""));
      localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("crash_count", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("report_time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("suspend_error_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_error_count", 0)));
      localHashMap.put("resume_error_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_error_count", 0)));
      boolean bool = this.jdField_d_of_type_Boolean;
      String str2 = "1";
      if (bool) {
        str1 = "1";
      } else {
        str1 = "-1";
      }
      localHashMap.put("fake_suspend", str1);
      if (this.e) {
        str1 = str2;
      } else {
        str1 = "-1";
      }
      localHashMap.put("white_list_only", str1);
    }
    try
    {
      str1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }
    catch (Throwable localThrowable)
    {
      label330:
      break label330;
    }
    QLog.e("TSManager", 1, "getAccount faild ！！！");
    String str1 = "";
    localHashMap.put("qq_num", str1);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(str1, "suspendThreadMonitor", true, this.jdField_d_of_type_Int, 0L, localHashMap, null);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_report_time", l);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("normal_resume_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_resume_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_error_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_error_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  private void l()
  {
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("not_resume_time", String.valueOf(System.currentTimeMillis()));
    boolean bool = this.jdField_d_of_type_Boolean;
    String str2 = "1";
    if (bool) {
      str1 = "1";
    } else {
      str1 = "-1";
    }
    localHashMap.put("fake_suspend", str1);
    if (this.e) {
      str1 = str2;
    } else {
      str1 = "-1";
    }
    localHashMap.put("white_list_only", str1);
    try
    {
      str1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    }
    catch (Throwable localThrowable)
    {
      label116:
      break label116;
    }
    QLog.e("TSManager", 1, "getAccount faild ！！！");
    String str1 = "";
    localHashMap.put("qq_num", str1);
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(str1, "suspendThreadNotResume", true, 0L, 0L, localHashMap, null);
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    sendMessage(localMessage);
  }
  
  public void a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("watchdog_resume_count", 0);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("watchdog_resume_count", paramInt + 1);
          this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$WatchdogHandler.b();
          if (SuspendThreadManager.f() == 1)
          {
            a("afterResumeThread Watchdog", false);
            SuspendThreadManager.a(0);
          }
        }
      }
      else
      {
        paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_resume_count", 0);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_resume_count", paramInt + 1);
        this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$WatchdogHandler.b();
        a("afterResumeThread Timeout", false);
      }
    }
    else
    {
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("normal_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("normal_resume_count", paramInt + 1);
      this.jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$WatchdogHandler.b();
      a("afterResumeThread Normal", false);
    }
    if (SuspendThreadManager.d())
    {
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_error_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_error_count", paramInt + 1);
      SuspendThreadManager.c(false);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return;
            }
            if (!this.jdField_d_of_type_Boolean)
            {
              j();
              return;
            }
            a("fake afterResumeThread Watchdog", false);
            return;
          }
          if (!this.jdField_d_of_type_Boolean)
          {
            i();
            return;
          }
          a("fake afterResumeThread Timeout", false);
          return;
        }
        if (!this.jdField_d_of_type_Boolean)
        {
          f();
          return;
        }
        a("fake afterResumeThread Normal", false);
        return;
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        a(this.e);
        return;
      }
      a("fake preSuspendThread", true);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.SuspendThreadManager.GuardThreadHandler
 * JD-Core Version:    0.7.0.1
 */