package com.tencent.qav.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.IQQServiceForAV;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.PhoneStatusMonitor.PhoneStatusListener;
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
    if (jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor == null) {
        jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor = new CallingStateMonitor();
      }
      return jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor;
    }
    finally {}
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
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("CallingStateMonitor", 2, "unregisterVideoChatReceiver", localThrowable);
      }
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
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQServiceForAV.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_a_of_type_AndroidContentServiceConnection = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "destroy, init[" + this.jdField_a_of_type_Boolean + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor != null)
    {
      this.jdField_a_of_type_ComTencentAvUtilsPhoneStatusMonitor.a();
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
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "setup, init[" + this.jdField_a_of_type_Boolean + "], bBindQQServiceForAV[" + paramBoolean + "]");
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
    if (this.jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor$CallingStateListener != null) {
      this.jdField_a_of_type_ComTencentQavMonitorCallingStateMonitor$CallingStateListener.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV != null) {
        bool = this.jdField_a_of_type_ComTencentAvServiceIQQServiceForAV.e();
      }
      return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.monitor.CallingStateMonitor
 * JD-Core Version:    0.7.0.1
 */