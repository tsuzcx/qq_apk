package com.tencent.qav.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;

public class CallingStateMonitor
  implements PhoneStatusMonitor.PhoneStatusListener
{
  private static CallingStateMonitor a;
  private Context b = null;
  private CallingStateMonitor.CallingStateListener c = null;
  private boolean d = false;
  private PhoneStatusMonitor e = null;
  private BroadcastReceiver f = null;
  private ServiceConnection g = null;
  private IQQServiceForAV h = null;
  
  public static CallingStateMonitor a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new CallingStateMonitor();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void g()
  {
    if (this.f == null) {
      this.f = new CallingStateMonitor.2(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      this.b.registerReceiver(this.f, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CallingStateMonitor", 2, "registerVideoChatReceiver", localThrowable);
    }
  }
  
  private void h()
  {
    BroadcastReceiver localBroadcastReceiver = this.f;
    if (localBroadcastReceiver != null)
    {
      try
      {
        this.b.unregisterReceiver(localBroadcastReceiver);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("CallingStateMonitor", 2, "unregisterVideoChatReceiver", localThrowable);
      }
      this.f = null;
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "bindQQServiceForAV");
    }
    if (this.g == null) {
      this.g = new CallingStateMonitor.3(this);
    }
    Intent localIntent = new Intent(this.b, ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getQQServiceForAVClass());
    this.b.bindService(localIntent, this.g, 1);
  }
  
  private void j()
  {
    ServiceConnection localServiceConnection = this.g;
    if (localServiceConnection != null)
    {
      this.b.unbindService(localServiceConnection);
      this.g = null;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setup, init[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("], bBindQQServiceForAV[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("CallingStateMonitor", 2, localStringBuilder.toString());
    }
    if (!this.d)
    {
      this.b = paramContext;
      new Handler(Looper.getMainLooper()).post(new CallingStateMonitor.1(this));
      g();
      if (paramBoolean) {
        i();
      }
      this.d = true;
    }
  }
  
  public void a(CallingStateMonitor.CallingStateListener paramCallingStateListener)
  {
    this.c = paramCallingStateListener;
  }
  
  public void a(boolean paramBoolean)
  {
    AVLog.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    CallingStateMonitor.CallingStateListener localCallingStateListener = this.c;
    if (localCallingStateListener != null) {
      localCallingStateListener.d(paramBoolean);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroy, init[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]");
      QLog.i("CallingStateMonitor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((PhoneStatusMonitor)localObject).a();
      this.e = null;
    }
    h();
    j();
    this.c = null;
    this.b = null;
    this.d = false;
    a = null;
  }
  
  public boolean c()
  {
    try
    {
      if (this.h != null)
      {
        boolean bool = this.h.n();
        return bool;
      }
    }
    catch (Exception localException)
    {
      AVLog.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public boolean d()
  {
    try
    {
      if (this.e != null) {
        return this.e.c();
      }
      if (this.h != null)
      {
        boolean bool = this.h.o();
        return bool;
      }
    }
    catch (Exception localException)
    {
      AVLog.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "clearTillEnd");
    }
    PhoneStatusMonitor localPhoneStatusMonitor = this.e;
    if (localPhoneStatusMonitor != null) {
      localPhoneStatusMonitor.e();
    }
  }
  
  public void f()
  {
    PhoneStatusMonitor localPhoneStatusMonitor = this.e;
    if ((localPhoneStatusMonitor != null) && (localPhoneStatusMonitor.c())) {
      localPhoneStatusMonitor.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor
 * JD-Core Version:    0.7.0.1
 */