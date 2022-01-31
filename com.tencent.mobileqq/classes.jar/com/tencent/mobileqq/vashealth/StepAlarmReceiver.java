package com.tencent.mobileqq.vashealth;

import akrx;
import akry;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class StepAlarmReceiver
  extends BroadcastReceiver
{
  public static String a;
  public int a;
  public long a;
  public QQAppInterface a;
  
  public StepAlarmReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 7200000L;
    this.jdField_a_of_type_Int = 1000;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!SportManager.a()) {}
    do
    {
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          if (!"action_sport_timer1".equals(paramContext)) {
            break;
          }
        } while ((!SSOHttpUtils.a(2)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        ThreadManager.post(new akrx(this), 5, null, true);
        return;
        if (!"action_sport_timer2".equals(paramContext)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ((SportManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(259)).c();
      return;
    } while (!"StepAlarmReceiver_long_time_report".equals(paramContext));
    if (QLog.isColorLevel()) {
      QLog.i("StepAlarmReceiver", 2, "StepAlarmReceiver_long_time_report!");
    }
    if (!paramIntent.getBooleanExtra("VerifyResult", true)) {
      SSOHttpUtils.a(-1000, "verifyFailed");
    }
    ThreadManager.post(new akry(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */