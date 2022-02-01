package com.tencent.mobileqq.wholepeople;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.Locale;

public class WholePeopleLebaEntryChecker
  implements Handler.Callback
{
  public static int a;
  public static boolean c = false;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public boolean a;
  int b;
  public volatile boolean b;
  
  static
  {
    jdField_a_of_type_Int = 42080;
  }
  
  public WholePeopleLebaEntryChecker(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_a_of_type_Boolean = paramQQAppInterface.getPreferences().getBoolean(paramQQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", false);
      if (QLog.isColorLevel()) {
        QLog.i("WholePeopleLebaEntryChecker", 2, "WholePeopleLebaEntryChecker init switch:" + this.jdField_a_of_type_Boolean);
      }
    } while (!c);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (c) {
        this.jdField_a_of_type_Boolean = true;
      }
      paramQQAppInterface.getPreferences().edit().putBoolean(paramQQAppInterface.getCurrentAccountUin() + "whole_people_vote_switch", paramBoolean).apply();
    } while (!QLog.isColorLevel());
    QLog.i("WholePeopleLebaEntryChecker", 2, String.format(Locale.getDefault(), "update show: %b", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008824", "0X8008824", 0, this.jdField_b_of_type_Int, 0, "", "", "", "");
    this.jdField_b_of_type_Int = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker
 * JD-Core Version:    0.7.0.1
 */