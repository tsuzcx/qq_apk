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
  private Thread b;
  private Thread c;
  private boolean d = false;
  private boolean e = false;
  private SharedPreferences f;
  private SharedPreferences.Editor g;
  private boolean h = false;
  private final float i = 0.1F;
  private int j = 0;
  private int k = 0;
  private int l = 0;
  private HandlerThread m;
  private SuspendThreadManager.WatchdogHandler n;
  private int o;
  private File p = null;
  private boolean q = false;
  private boolean r = true;
  
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
      if (this.p.exists()) {
        return;
      }
      this.p.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      QLog.e("TSManager", 1, "createOrDelSuspendCheckFile failed", paramString);
    }
    if (this.p.exists())
    {
      this.p.delete();
      return;
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    int i1 = this.f.getInt("suspend_error_count", 0);
    this.g.putInt("suspend_error_count", i1 + 1);
    this.g.commit();
    SuspendThreadManager.a(this.a, SuspendThreadManager.m());
  }
  
  private void a(boolean paramBoolean)
  {
    SuspendThreadManager.a(0);
    try
    {
      if (SuspendThreadManager.g().isEmpty())
      {
        f();
        SuspendThreadManager.a(this.a, paramBoolean);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  private boolean b()
  {
    return this.p.exists();
  }
  
  private void c()
  {
    if (this.p.exists()) {
      this.p.delete();
    }
  }
  
  private void d()
  {
    SuspendThreadManager.a().a(ThreadManager.getSubThread().getName());
    SuspendThreadManager.a().a(ThreadManager.getRecentThread().getName());
    SuspendThreadManager.a().a("MSF-Receiver");
    SuspendThreadManager.a().a("QQ_DB");
    SuspendThreadManager.a().a("QQ_FILE_RW");
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        System.loadLibrary("threadsuspend");
        this.f = MobileQQ.getContext().getSharedPreferences("suspend_thread_pref_file", 0);
        this.g = this.f.edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(MobileQQ.getContext().getFilesDir().getPath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("suspend_check_file");
        this.p = new File(localStringBuilder.toString());
        this.q = DeviceOptSwitch.h;
        this.r = DeviceOptSwitch.i;
        if ((Build.VERSION.SDK_INT <= 23) && (DeviceOptSwitch.g))
        {
          SuspendThreadManager.a |= 0x1;
          bool1 = true;
        }
        else
        {
          if (Build.VERSION.SDK_INT < 24) {
            break label713;
          }
          SuspendThreadManager.a |= 0x2;
          break label713;
        }
        this.k = this.f.getInt("suspendCrashCount", 0);
        if (this.k > SuspendThreadManager.h())
        {
          SuspendThreadManager.a |= 0x8;
          bool1 = false;
        }
        this.j = this.f.getInt("notResumeCountNew", 0);
        if (b())
        {
          this.j += 1;
          this.g.putInt("notResumeCountNew", this.j);
          this.g.commit();
          m();
        }
        c();
        if (this.j > SuspendThreadManager.i())
        {
          SuspendThreadManager.a |= 0x10;
          bool1 = false;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("mCurrentNotResumeCount = ");
        localStringBuilder.append(this.j);
        localStringBuilder.append(",mCurrentCrashCount = ");
        localStringBuilder.append(this.k);
        localStringBuilder.append(",tempInitedSuccessful = ");
        localStringBuilder.append(bool1);
        QLog.d("TSManager", 1, localStringBuilder.toString());
        if (bool1)
        {
          Process.setThreadPriority(-2);
          if (Math.random() >= 0.1000000014901161D) {
            break label718;
          }
          bool2 = true;
          this.h = bool2;
          SuspendThreadManager.a(SuspendThreadManager.j());
          this.b = Looper.getMainLooper().getThread();
          this.c = SuspendThreadManager.k().getLooper().getThread();
          this.m = new HandlerThread("suspendWatchdogThread");
          this.m.start();
          this.n = new SuspendThreadManager.WatchdogHandler(this.a, this.m.getLooper(), Thread.currentThread(), this);
          SuspendThreadManager.b(SuspendThreadManager.a(this.m));
          SuspendThreadManager.c(SuspendThreadManager.a(SuspendThreadManager.k()));
          SuspendThreadManager.d(SuspendThreadManager.a(this.b));
          this.o = SuspendThreadManager.a(this.a, SuspendThreadManager.l(), SuspendThreadManager.m());
          l();
          SuspendThreadManager.n().add(this.b);
          SuspendThreadManager.n().add(this.c);
          SuspendThreadManager.n().add(this.m);
          d();
        }
        SuspendThreadManager.b(bool1);
        QLog.d("TSManager", 1, new Object[] { "init finished:", "mNativeApiSupportValue = ", Integer.valueOf(this.o), ",sGuardThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.m()), ",sMainThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.o()), ",mFetchMainStackThisTime = ", Boolean.valueOf(this.h), ",bDalvikVm = ", Boolean.valueOf(SuspendThreadManager.l()), ",sInitedSuccessful = ", Boolean.valueOf(SuspendThreadManager.p()), ",bIsFakeSuspendUser = ", Boolean.valueOf(this.q), ",bSuspendWhiteListThreadOnly = ", Boolean.valueOf(this.r) });
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TSManager", 1, "libthreadsuspend load failed !!!", localThrowable);
        SuspendThreadManager.b(false);
        SuspendThreadManager.a |= 0x20;
        return;
      }
      label713:
      boolean bool1 = false;
      continue;
      label718:
      boolean bool2 = false;
    }
  }
  
  private void f()
  {
    synchronized ()
    {
      SuspendThreadManager.g().clear();
      SuspendThreadManager.q().clear();
      SuspendThreadManager.r().clear();
      a("preSuspendThread", true);
      this.l = 0;
      i();
      this.n.a();
      return;
    }
  }
  
  private void g()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.g().size() > 0)
    {
      SuspendThreadManager.a(this.a, SuspendThreadManager.m());
      a(1);
    }
  }
  
  private void h()
  {
    if (SuspendThreadManager.g().size() > 0)
    {
      SuspendThreadManager.a(this.a, SuspendThreadManager.m());
      a(2);
    }
  }
  
  private void i()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    sendMessageDelayed(localMessage, SuspendThreadManager.u());
  }
  
  private void j()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.g().size() > 0)
    {
      ??? = this.b.getState();
      this.l += 1;
      Object localObject3;
      if (??? == Thread.State.BLOCKED)
      {
        if ((!this.e) && (!SuspendThreadManager.l()) && (!SuspendThreadManager.q().isEmpty()))
        {
          int i1 = SuspendThreadManager.b(SuspendThreadManager.a(), SuspendThreadManager.o());
          Thread localThread1 = (Thread)SuspendThreadManager.q().get(Integer.valueOf(i1));
          if ((localThread1 != null) && (SuspendThreadManager.g().contains(localThread1)))
          {
            i1 = SuspendThreadManager.a(SuspendThreadManager.a(), localThread1, SuspendThreadManager.m());
            if ((1 == i1) || (2 == i1)) {
              synchronized (SuspendThreadManager.g())
              {
                SuspendThreadManager.g().remove(localThread1);
              }
            }
          }
          this.e = true;
        }
        else
        {
          if (this.h)
          {
            ??? = SuspendThreadManager.a(this.a, this.b, "Blocked");
            localObject3 = this.g;
            if (localObject3 != null)
            {
              ((SharedPreferences.Editor)localObject3).putString("main_thread_stack", (String)???);
              this.g.commit();
            }
          }
          h();
        }
      }
      else if ((??? != Thread.State.WAITING) && (??? != Thread.State.TIMED_WAITING))
      {
        this.d = false;
        this.e = false;
        if (this.l * SuspendThreadManager.u() > 1000L)
        {
          h();
          this.l = 0;
        }
      }
      else if (this.d)
      {
        if (this.h)
        {
          localObject3 = this.a;
          Thread localThread2 = this.b;
          if (??? == Thread.State.WAITING) {
            ??? = "Waiting";
          } else {
            ??? = "TimedWaiting";
          }
          ??? = SuspendThreadManager.a((SuspendThreadManager)localObject3, localThread2, (String)???);
          localObject3 = this.g;
          if (localObject3 != null)
          {
            ((SharedPreferences.Editor)localObject3).putString("main_thread_stack", (String)???);
            this.g.commit();
          }
        }
        h();
      }
      else
      {
        this.d = true;
      }
    }
    if (!SuspendThreadManager.g().isEmpty()) {
      i();
    }
  }
  
  private void k()
  {
    a(3);
  }
  
  private void l()
  {
    long l1 = System.currentTimeMillis();
    HashMap localHashMap;
    if (l1 - this.f.getLong("last_report_time", 0L) > 86400000L)
    {
      localHashMap = new HashMap(10);
      localHashMap.put("api_support_cond", String.valueOf(this.o));
      localHashMap.put("resume_count", String.valueOf(this.f.getInt("normal_resume_count", 0)));
      localHashMap.put("timeout_count", String.valueOf(this.f.getInt("timeout_resume_count", 0)));
      localHashMap.put("watchdog_count", String.valueOf(this.f.getInt("watchdog_resume_count", 0)));
      localHashMap.put("main_thread_stack", this.f.getString("main_thread_stack", ""));
      localHashMap.put("not_resume_count", String.valueOf(this.j));
      localHashMap.put("crash_count", String.valueOf(this.k));
      localHashMap.put("report_time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("suspend_error_count", String.valueOf(this.f.getInt("suspend_error_count", 0)));
      localHashMap.put("resume_error_count", String.valueOf(this.f.getInt("resume_error_count", 0)));
      boolean bool = this.q;
      String str2 = "1";
      if (bool) {
        str1 = "1";
      } else {
        str1 = "-1";
      }
      localHashMap.put("fake_suspend", str1);
      if (this.r) {
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
    StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(str1, "suspendThreadMonitor", true, this.o, 0L, localHashMap, null);
    this.g.putLong("last_report_time", l1);
    this.g.putInt("normal_resume_count", 0);
    this.g.putInt("timeout_resume_count", 0);
    this.g.putInt("suspend_error_count", 0);
    this.g.putInt("resume_error_count", 0);
    this.g.commit();
  }
  
  private void m()
  {
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("not_resume_count", String.valueOf(this.j));
    localHashMap.put("not_resume_time", String.valueOf(System.currentTimeMillis()));
    boolean bool = this.q;
    String str2 = "1";
    if (bool) {
      str1 = "1";
    } else {
      str1 = "-1";
    }
    localHashMap.put("fake_suspend", str1);
    if (this.r) {
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
          paramInt = this.f.getInt("watchdog_resume_count", 0);
          this.g.putInt("watchdog_resume_count", paramInt + 1);
          this.n.b();
          if (SuspendThreadManager.s() == 1)
          {
            a("afterResumeThread Watchdog", false);
            SuspendThreadManager.a(0);
          }
        }
      }
      else
      {
        paramInt = this.f.getInt("timeout_resume_count", 0);
        this.g.putInt("timeout_resume_count", paramInt + 1);
        this.n.b();
        a("afterResumeThread Timeout", false);
      }
    }
    else
    {
      paramInt = this.f.getInt("normal_resume_count", 0);
      this.g.putInt("normal_resume_count", paramInt + 1);
      this.n.b();
      a("afterResumeThread Normal", false);
    }
    if (SuspendThreadManager.t())
    {
      paramInt = this.f.getInt("resume_error_count", 0);
      this.g.putInt("resume_error_count", paramInt + 1);
      SuspendThreadManager.c(false);
    }
    this.g.commit();
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return;
            }
            if (!this.q)
            {
              k();
              return;
            }
            a("fake afterResumeThread Watchdog", false);
            return;
          }
          if (!this.q)
          {
            j();
            return;
          }
          a("fake afterResumeThread Timeout", false);
          return;
        }
        if (!this.q)
        {
          g();
          return;
        }
        a("fake afterResumeThread Normal", false);
        return;
      }
      if (!this.q)
      {
        a(this.r);
        return;
      }
      a("fake preSuspendThread", true);
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.SuspendThreadManager.GuardThreadHandler
 * JD-Core Version:    0.7.0.1
 */