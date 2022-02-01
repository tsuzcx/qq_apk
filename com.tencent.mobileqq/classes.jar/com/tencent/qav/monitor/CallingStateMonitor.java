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
  private static CallingStateMonitor jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  private IQQServiceForAV jdField_a_of_type_ComTencentAvServiceIQQServiceForAV = null;
  private PhoneStatusMonitor jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = null;
  private CallingStateMonitor.CallingStateListener jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor$CallingStateListener = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static CallingStateMonitor a()
  {
    if (jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor == null) {
          jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor = new CallingStateMonitor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new CallingStateMonitor.2(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CallingStateMonitor", 2, "registerVideoChatReceiver", localThrowable);
    }
  }
  
  private void e()
  {
    BroadcastReceiver localBroadcastReceiver = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localBroadcastReceiver != null)
    {
      try
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(localBroadcastReceiver);
      }
      catch (Throwable localThrowable)
      {
        QLog.i("CallingStateMonitor", 2, "unregisterVideoChatReceiver", localThrowable);
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "bindQQServiceForAV");
    }
    if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
      this.jdField_a_of_type_AndroidContentServiceConnection = new CallingStateMonitor.3(this);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getQQServiceForAVClass());
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  private void g()
  {
    ServiceConnection localServiceConnection = this.jdField_a_of_type_AndroidContentServiceConnection;
    if (localServiceConnection != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unbindService(localServiceConnection);
      this.jdField_a_of_type_AndroidContentServiceConnection = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("destroy, init[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append("]");
      QLog.i("CallingStateMonitor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor;
    if (localObject != null)
    {
      ((PhoneStatusMonitor)localObject).a();
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor = null;
    }
    e();
    g();
    this.jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor$CallingStateListener = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor = null;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setup, init[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("], bBindQQServiceForAV[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("CallingStateMonitor", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      new Handler(Looper.getMainLooper()).post(new CallingStateMonitor.1(this));
      d();
      if (paramBoolean) {
        f();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(CallingStateMonitor.CallingStateListener paramCallingStateListener)
  {
    this.jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor$CallingStateListener = paramCallingStateListener;
  }
  
  public void a(boolean paramBoolean)
  {
    AVLog.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    CallingStateMonitor.CallingStateListener localCallingStateListener = this.jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor$CallingStateListener;
    if (localCallingStateListener != null) {
      localCallingStateListener.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.e();
        return bool;
      }
    }
    catch (Exception localException)
    {
      AVLog.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "clearTillEnd");
    }
    PhoneStatusMonitor localPhoneStatusMonitor = this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor;
    if (localPhoneStatusMonitor != null) {
      localPhoneStatusMonitor.d();
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor != null) {
        return this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a();
      }
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.f();
        return bool;
      }
    }
    catch (Exception localException)
    {
      AVLog.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
  
  public void c()
  {
    PhoneStatusMonitor localPhoneStatusMonitor = this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor;
    if ((localPhoneStatusMonitor != null) && (localPhoneStatusMonitor.a())) {
      localPhoneStatusMonitor.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor
 * JD-Core Version:    0.7.0.1
 */