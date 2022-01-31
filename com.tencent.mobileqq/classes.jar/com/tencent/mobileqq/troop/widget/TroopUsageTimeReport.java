package com.tencent.mobileqq.troop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import azmj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

@Deprecated
public class TroopUsageTimeReport
  extends BroadcastReceiver
{
  private long jdField_a_of_type_Long;
  private IntentFilter jdField_a_of_type_AndroidContentIntentFilter = new IntentFilter();
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private long b;
  public boolean b;
  private long c;
  private long d;
  
  private TroopUsageTimeReport()
  {
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
    this.jdField_a_of_type_AndroidContentIntentFilter.addAction("android.intent.action.QUICKBOOT_POWEROFF");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      long l = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000L;
      int j = (int)l;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo != null)
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "time", "aio_time", 0, i, 0, localSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopUsageTimeReport-->AioUseTime", 2, "uin=" + this.jdField_a_of_type_JavaLangString + ",mTroopUin=" + localSessionInfo.jdField_a_of_type_JavaLangString + ",time=" + l + "s");
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.d = System.currentTimeMillis();
      long l = (this.d - this.c) / 1000L;
      int j = (int)l;
      int i = j;
      if (j <= 0) {
        i = 1;
      }
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo != null)
      {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "time", "grp_time", 0, i, 0, localSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("TroopUsageTimeReport-->TroopUseTime", 2, "uin=" + this.jdField_a_of_type_JavaLangString + ",mTroopUin=" + localSessionInfo.jdField_a_of_type_JavaLangString + ",time=" + l + "s");
        }
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("android.intent.action.ACTION_SHUTDOWN".equals(paramContext)) || ("android.intent.action.QUICKBOOT_POWEROFF".equals(paramContext)))
    {
      a();
      b();
    }
    do
    {
      do
      {
        return;
      } while (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(paramContext));
      paramContext = paramIntent.getStringExtra("reason");
    } while ((paramContext == null) || (!paramContext.equals("homekey")));
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopUsageTimeReport
 * JD-Core Version:    0.7.0.1
 */