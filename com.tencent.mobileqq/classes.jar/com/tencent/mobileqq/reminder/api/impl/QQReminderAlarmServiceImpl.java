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
    if (this.mReminderAlarmReceiver != null) {
      this.mContext.unregisterReceiver(this.mReminderAlarmReceiver);
    }
  }
  
  public void cancelAlarmById(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "cancelAlarmById alarmId: " + paramInt);
      }
      Object localObject = String.valueOf(paramInt);
      if (this.mAlarmIds.contains(localObject)) {
        this.mAlarmIds.remove(localObject);
      }
      this.pref.edit().putStringSet("sp_key_alarmids" + this.mApp.getAccount(), this.mAlarmIds).apply();
      localObject = new Intent();
      ((Intent)localObject).setAction("notification_alram_action");
      localObject = PendingIntent.getBroadcast(this.mContext, paramInt, (Intent)localObject, 0);
      this.mAlarmManager.cancel((PendingIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ActivateFriends.Manager", 2, "cancelAlarmById throw an exceptio: " + localThrowable);
    }
  }
  
  public void clearAllAlarm()
  {
    try
    {
      if (!this.pref.getStringSet("sp_key_alarmids" + this.mApp.getAccount(), new HashSet()).isEmpty())
      {
        Iterator localIterator = this.mAlarmIds.iterator();
        while (localIterator.hasNext()) {
          cancelAlarmById(Integer.parseInt((String)localIterator.next()));
        }
      }
      if (this.mAlarmIds == null) {
        break label136;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ActivateFriends.Manager", 2, "clearAllAlarm throw an exception: " + localException);
      return;
    }
    if (!this.mAlarmIds.isEmpty()) {
      this.mAlarmIds.clear();
    }
    label136:
    this.pref.edit().remove("sp_key_alarmids" + this.mApp.getAccount()).apply();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "ActivateFriends.Manager--onCreate---");
    }
    this.mAlarmIds = new CopyOnWriteArraySet();
    this.mApp = paramAppRuntime;
    this.pref = this.mApp.getApplicationContext().getSharedPreferences("pref_act_frd" + this.mApp.getAccount(), 0);
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
    if ((paramAcsMsg == null) || (paramAcsMsg.type == 1)) {}
    long l;
    label292:
    label352:
    do
    {
      Object localObject1;
      do
      {
        for (;;)
        {
          return;
          try
          {
            l = paramAcsMsg.notice_time * 1000L;
            int i = paramAcsMsg.msg_id.hashCode();
            localObject1 = paramAcsMsg.title;
            if (l <= NetConnInfoCenter.getServerTimeMillis()) {
              break label352;
            }
            Object localObject2 = String.valueOf(i);
            if (QLog.isColorLevel()) {
              QLog.d("ActivateFriends.Manager", 2, "setAlarmTimer at " + QQReminderUtil.a(l, "yyyyMMdd HH:mm:ss") + " msg: " + (String)localObject1 + " alarmId: " + i);
            }
            if (!this.mAlarmIds.contains(localObject2))
            {
              this.mAlarmIds.add(localObject2);
              this.pref.edit().putStringSet("sp_key_alarmids" + this.mApp.getAccount(), this.mAlarmIds).apply();
            }
            localObject2 = new Intent();
            ((Intent)localObject2).setAction("notification_alram_action");
            ((Intent)localObject2).putExtra("msg", (String)localObject1);
            ((Intent)localObject2).putExtra("msg_id", QQReminderUtil.a(paramAcsMsg));
            paramAcsMsg = PendingIntent.getBroadcast(this.mContext, i, (Intent)localObject2, 0);
            if (this.mAlarmManager != null)
            {
              if (Build.VERSION.SDK_INT < 23) {
                break label292;
              }
              this.mAlarmManager.setExactAndAllowWhileIdle(0, l, paramAcsMsg);
              return;
            }
          }
          catch (Throwable paramAcsMsg) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("ActivateFriends.Manager", 2, "setAlarmTimer throw an exceptio: " + paramAcsMsg);
      return;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject1 = new AlarmManager.AlarmClockInfo(l, paramAcsMsg);
        this.mAlarmManager.setAlarmClock((AlarmManager.AlarmClockInfo)localObject1, paramAcsMsg);
        return;
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        this.mAlarmManager.setExact(0, l, paramAcsMsg);
        return;
      }
      this.mAlarmManager.set(0, l, paramAcsMsg);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("ActivateFriends.Manager", 2, "has already setAlarmTimer at " + QQReminderUtil.a(l, "yyyyMMdd HH:mm:ss"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderAlarmServiceImpl
 * JD-Core Version:    0.7.0.1
 */