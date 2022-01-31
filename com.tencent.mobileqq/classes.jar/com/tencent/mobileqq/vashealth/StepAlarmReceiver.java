package com.tencent.mobileqq.vashealth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bdug;
import bduj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class StepAlarmReceiver
  extends BroadcastReceiver
{
  static String jdField_a_of_type_JavaLangString;
  int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 7200000L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public StepAlarmReceiver(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!bduj.a()) {
      QLog.e("StepAlarmReceiver", 1, "onReceive:step counter not support");
    }
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
        } while ((!bdug.a(2)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        ThreadManager.post(new StepAlarmReceiver.1(this), 5, null, true);
        return;
        if (!"action_sport_timer2".equals(paramContext)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      ((bduj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(260)).c();
      return;
    } while (!"StepAlarmReceiver_long_time_report".equals(paramContext));
    QLog.i("StepAlarmReceiver", 1, "StepAlarmReceiver_long_time_report!");
    if (!paramIntent.getBooleanExtra("VerifyResult", true)) {
      bdug.a(-1000, "verifyFailed");
    }
    ThreadManager.post(new StepAlarmReceiver.2(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */