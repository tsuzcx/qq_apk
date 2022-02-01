package com.tencent.mobileqq.vashealth.api.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigBean;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class SportManagerImpl
  implements ISportManager
{
  static final int MAX_CALLBACK_VALUE = 99999999;
  public static final int MSG_REPORT = 1;
  public static final String TAG = "SportManager";
  static SensorManager sSensorManager;
  public static volatile boolean sStepCounterEnable = true;
  BusinessObserver RefreshStepsObserver = new SportManagerImpl.3(this);
  long lastCallRefresh = 0L;
  AlarmManager mAlarmManager = null;
  AppRuntime mApp;
  Handler.Callback mCallBack = new SportManagerImpl.4(this);
  Handler mHandler;
  PendingIntent mReportIntent1 = null;
  PendingIntent mReportIntent2 = null;
  StepAlarmReceiver mStepAlarmReceiver;
  int mTimer2ReportTimes;
  
  public static boolean isSupportStepCounter(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return false;
    }
    if (sSensorManager == null) {
      sSensorManager = (SensorManager)paramContext.getSystemService("sensor");
    }
    return sSensorManager.getDefaultSensor(19) != null;
  }
  
  public void doOnLogin()
  {
    if (this.mStepAlarmReceiver == null) {
      this.mStepAlarmReceiver = new StepAlarmReceiver(this.mApp);
    }
    Object localObject1 = this.mApp.getApplication().getApplicationContext();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_sport_timer1");
    localIntentFilter.addAction("action_sport_timer2");
    localIntentFilter.addAction("StepAlarmReceiver_long_time_report");
    localIntentFilter.addAction("action_step_compare_report");
    try
    {
      ((Context)localObject1).registerReceiver(this.mStepAlarmReceiver, localIntentFilter);
    }
    catch (Exception localException)
    {
      QLog.e("SportManager", 1, "registerReceiver error", localException);
    }
    HealthTimerConfigBean localHealthTimerConfigBean = HealthTimerConfigProcessor.a();
    boolean bool = localHealthTimerConfigBean.a();
    if (bool)
    {
      Object localObject2 = new Intent("action_sport_timer1");
      Intent localIntent = new Intent("action_sport_timer2");
      if (this.mReportIntent1 == null) {
        this.mReportIntent1 = PendingIntent.getBroadcast((Context)localObject1, 0, (Intent)localObject2, 0);
      }
      if (this.mReportIntent2 == null) {
        this.mReportIntent2 = PendingIntent.getBroadcast((Context)localObject1, 0, localIntent, 0);
      }
      if (this.mAlarmManager == null) {
        this.mAlarmManager = ((AlarmManager)((Context)localObject1).getSystemService("alarm"));
      }
      int j = localHealthTimerConfigBean.i();
      int i = j;
      if (j <= 0) {
        i = 20;
      }
      i = new Random().nextInt(i);
      j = new Random().nextInt(59);
      localObject1 = Calendar.getInstance();
      ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      ((Calendar)localObject1).set(11, localHealthTimerConfigBean.c());
      ((Calendar)localObject1).set(12, localHealthTimerConfigBean.d() + i);
      ((Calendar)localObject1).set(13, j);
      ((Calendar)localObject1).set(14, 0);
      long l = ((Calendar)localObject1).getTimeInMillis();
      this.mAlarmManager.set(1, l, this.mReportIntent1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("register AlarmManager, alarmTime1:");
      ((StringBuilder)localObject2).append(l);
      QLog.i("SportManager", 1, ((StringBuilder)localObject2).toString());
      ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      i = new Random().nextInt(25);
      j = new Random().nextInt(59);
      ((Calendar)localObject1).set(12, i + 5);
      ((Calendar)localObject1).set(13, j);
      ((Calendar)localObject1).set(14, 0);
      if (((Calendar)localObject1).get(11) < localHealthTimerConfigBean.k()) {
        ((Calendar)localObject1).set(11, 0);
      } else {
        ((Calendar)localObject1).set(11, localHealthTimerConfigBean.j());
      }
      l = ((Calendar)localObject1).getTimeInMillis();
      this.mAlarmManager.set(1, l, this.mReportIntent2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("register AlarmManager, alarmTime2:");
      ((StringBuilder)localObject1).append(l);
      QLog.i("SportManager", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isConfigReady:");
    ((StringBuilder)localObject1).append(bool);
    QLog.e("SportManager", 1, ((StringBuilder)localObject1).toString());
  }
  
  public void doOnTimer1()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SportManager", 2, "doOnTimer1");
    }
    Object localObject1 = HealthTimerConfigProcessor.a();
    int i = ((HealthTimerConfigBean)localObject1).g();
    int j = ((HealthTimerConfigBean)localObject1).h();
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    ((Calendar)localObject2).set(11, ((HealthTimerConfigBean)localObject1).e());
    ((Calendar)localObject2).set(12, ((HealthTimerConfigBean)localObject1).f());
    ((Calendar)localObject2).set(13, 0);
    ((Calendar)localObject2).set(14, 0);
    long l = ((Calendar)localObject2).getTimeInMillis();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("do on timer 1,interval:");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(",increment:");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append(",enable:");
    ((StringBuilder)localObject1).append(sStepCounterEnable);
    QLog.i("SportManager", 1, ((StringBuilder)localObject1).toString());
    if ((sStepCounterEnable) && (j != 0))
    {
      if (i == 0) {
        return;
      }
      localObject1 = new SportManagerImpl.2(this, l, i, j);
      localObject2 = sSensorManager;
      if (localObject2 != null)
      {
        localObject2 = ((SensorManager)localObject2).getDefaultSensor(19);
        try
        {
          if (Build.VERSION.SDK_INT > 19)
          {
            sSensorManager.registerListener((SensorEventListener)localObject1, (Sensor)localObject2, 3, 60000);
            return;
          }
        }
        catch (Exception localException)
        {
          QLog.e("SportManager", 1, localException, new Object[0]);
        }
      }
    }
  }
  
  public void doOnTimer2()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SportManager", 2, "doOnTimer2");
    }
    this.mTimer2ReportTimes = 0;
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(1);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this.mCallBack);
    ThreadManager.post(new SportManagerImpl.1(this), 5, null, true);
  }
  
  public void onDestroy()
  {
    Object localObject = this.mAlarmManager;
    if (localObject != null)
    {
      PendingIntent localPendingIntent = this.mReportIntent1;
      if ((localPendingIntent != null) && (this.mReportIntent2 != null))
      {
        ((AlarmManager)localObject).cancel(localPendingIntent);
        this.mAlarmManager.cancel(this.mReportIntent2);
        this.mAlarmManager = null;
        this.mReportIntent1 = null;
      }
    }
    if (this.mStepAlarmReceiver != null) {}
    try
    {
      this.mApp.getApplication().getApplicationContext().unregisterReceiver(this.mStepAlarmReceiver);
      this.mStepAlarmReceiver.a();
      this.mStepAlarmReceiver = null;
    }
    catch (Exception localException)
    {
      label90:
      break label90;
    }
    localObject = this.mHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    sSensorManager = null;
  }
  
  public void refreshCurrentStep(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshCurrentStep call from:");
    localStringBuilder.append(paramString);
    QLog.i("SportManager", 1, localStringBuilder.toString());
    if (this.mApp != null)
    {
      if (System.currentTimeMillis() - this.lastCallRefresh < 10000L) {
        return;
      }
      this.lastCallRefresh = System.currentTimeMillis();
      paramString = new NewIntent(this.mApp.getApplication().getApplicationContext(), StepCounterServlert.class);
      paramString.putExtra("msf_cmd_type", "cmd_refresh_steps");
      paramString.setObserver(this.RefreshStepsObserver);
      this.mApp.startServlet(paramString);
    }
  }
  
  public void setStepCounterEnable(boolean paramBoolean)
  {
    sStepCounterEnable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.SportManagerImpl
 * JD-Core Version:    0.7.0.1
 */