package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsMsg;
import android.app.AlarmManager;
import android.app.AlarmManager.AlarmClockInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.biz.QQReminderAlarmReceiver;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;

public class QQReminderAlarmServiceImpl
  implements IQQReminderAlarmService
{
  public static final String NOTIFICATION_ALRAM_ACTION = "notification_alram_action";
  public static final String SP_KEY_ALRMAIDS = "sp_key_alarmids";
  private static final String TAG = "ActivateFriends.Manager";
  private CopyOnWriteArraySet<String> mAlarmIds;
  private AlarmManager mAlarmManager;
  private AppRuntime mApp;
  private Context mContext;
  private QQReminderAlarmReceiver mReminderAlarmReceiver;
  private SharedPreferences pref;
  
  private void registAlarmBroadcastReceiver()
  {
    if (this.mReminderAlarmReceiver == null) {
      this.mReminderAlarmReceiver = new QQReminderAlarmReceiver(this.mApp);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("notification_alram_action");
    this.mContext.registerReceiver(this.mReminderAlarmReceiver, localIntentFilter);
  }
  
  private void unRegistAlarmBroadcastReceiver()
  {
    QQReminderAlarmReceiver localQQReminderAlarmReceiver = this.mReminderAlarmReceiver;
    if (localQQReminderAlarmReceiver != null) {
      this.mContext.unregisterReceiver(localQQReminderAlarmReceiver);
    }
  }
  
  public void cancelAlarmById(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cancelAlarmById alarmId: ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = String.valueOf(paramInt);
      if (this.mAlarmIds.contains(localObject)) {
        this.mAlarmIds.remove(localObject);
      }
      localObject = this.pref.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_alarmids");
      localStringBuilder.append(this.mApp.getAccount());
      ((SharedPreferences.Editor)localObject).putStringSet(localStringBuilder.toString(), this.mAlarmIds).apply();
      localObject = new Intent();
      ((Intent)localObject).setAction("notification_alram_action");
      localObject = PendingIntent.getBroadcast(this.mContext, paramInt, (Intent)localObject, 0);
      this.mAlarmManager.cancel((PendingIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cancelAlarmById throw an exceptio: ");
        localStringBuilder.append(localThrowable);
        QLog.e("ActivateFriends.Manager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void clearAllAlarm()
  {
    try
    {
      Object localObject = this.pref;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_alarmids");
      localStringBuilder.append(this.mApp.getAccount());
      if (!((SharedPreferences)localObject).getStringSet(localStringBuilder.toString(), new HashSet()).isEmpty())
      {
        localObject = this.mAlarmIds.iterator();
        while (((Iterator)localObject).hasNext()) {
          cancelAlarmById(Integer.parseInt((String)((Iterator)localObject).next()));
        }
      }
      if ((this.mAlarmIds != null) && (!this.mAlarmIds.isEmpty())) {
        this.mAlarmIds.clear();
      }
      localObject = this.pref.edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_alarmids");
      localStringBuilder.append(this.mApp.getAccount());
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).apply();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearAllAlarm throw an exception: ");
      localStringBuilder.append(localException);
      QLog.e("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onCreate---");
    }
    this.mAlarmIds = new CopyOnWriteArraySet();
    this.mApp = paramAppRuntime;
    paramAppRuntime = this.mApp.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_act_frd");
    localStringBuilder.append(this.mApp.getAccount());
    this.pref = paramAppRuntime.getSharedPreferences(localStringBuilder.toString(), 0);
    this.mContext = this.mApp.getApplicationContext();
    this.mAlarmManager = ((AlarmManager)this.mContext.getSystemService("alarm"));
    registAlarmBroadcastReceiver();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onDestroy---");
    }
    unRegistAlarmBroadcastReceiver();
    clearAllAlarm();
  }
  
  public void setAlarmTimer(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg != null)
    {
      if (paramAcsMsg.type == 1) {
        return;
      }
      try
      {
        long l1 = paramAcsMsg.notice_time * 1000L;
        int i = paramAcsMsg.msg_id.hashCode();
        localObject1 = paramAcsMsg.title;
        long l2 = NetConnInfoCenter.getServerTimeMillis();
        if (l1 > l2)
        {
          Object localObject2 = String.valueOf(i);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("setAlarmTimer at ");
            localStringBuilder.append(QQReminderUtil.a(l1, "yyyyMMdd HH:mm:ss"));
            localStringBuilder.append(" msg: ");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(" alarmId: ");
            localStringBuilder.append(i);
            QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
          }
          if (!this.mAlarmIds.contains(localObject2))
          {
            this.mAlarmIds.add(localObject2);
            localObject2 = this.pref.edit();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("sp_key_alarmids");
            localStringBuilder.append(this.mApp.getAccount());
            ((SharedPreferences.Editor)localObject2).putStringSet(localStringBuilder.toString(), this.mAlarmIds).apply();
          }
          localObject2 = new Intent();
          ((Intent)localObject2).setAction("notification_alram_action");
          ((Intent)localObject2).putExtra("msg", (String)localObject1);
          ((Intent)localObject2).putExtra("msg_id", QQReminderUtil.a(paramAcsMsg));
          paramAcsMsg = PendingIntent.getBroadcast(this.mContext, i, (Intent)localObject2, 0);
          if (this.mAlarmManager != null)
          {
            if (Build.VERSION.SDK_INT >= 23)
            {
              this.mAlarmManager.setExactAndAllowWhileIdle(0, l1, paramAcsMsg);
              return;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject1 = new AlarmManager.AlarmClockInfo(l1, paramAcsMsg);
              this.mAlarmManager.setAlarmClock((AlarmManager.AlarmClockInfo)localObject1, paramAcsMsg);
              return;
            }
            if (Build.VERSION.SDK_INT >= 19)
            {
              this.mAlarmManager.setExact(0, l1, paramAcsMsg);
              return;
            }
            this.mAlarmManager.set(0, l1, paramAcsMsg);
          }
        }
        else if (QLog.isColorLevel())
        {
          paramAcsMsg = new StringBuilder();
          paramAcsMsg.append("has already setAlarmTimer at ");
          paramAcsMsg.append(QQReminderUtil.a(l1, "yyyyMMdd HH:mm:ss"));
          QLog.d("ActivateFriends.Manager", 2, paramAcsMsg.toString());
          return;
        }
      }
      catch (Throwable paramAcsMsg)
      {
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setAlarmTimer throw an exceptio: ");
          ((StringBuilder)localObject1).append(paramAcsMsg);
          QLog.e("ActivateFriends.Manager", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderAlarmServiceImpl
 * JD-Core Version:    0.7.0.1
 */