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
  public static int e = 42080;
  public static boolean f = false;
  QQAppInterface a;
  WeakReferenceHandler b;
  public boolean c;
  public volatile boolean d = false;
  int g = 0;
  
  public WholePeopleLebaEntryChecker(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.a = paramQQAppInterface;
    this.b = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this);
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("whole_people_vote_switch");
    this.c = localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("WholePeopleLebaEntryChecker init switch:");
      paramQQAppInterface.append(this.c);
      QLog.i("WholePeopleLebaEntryChecker", 2, paramQQAppInterface.toString());
    }
    if (f) {
      this.c = true;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.c = paramBoolean;
    if (f) {
      this.c = true;
    }
    SharedPreferences.Editor localEditor = paramQQAppInterface.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("whole_people_vote_switch");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).apply();
    if (QLog.isColorLevel()) {
      QLog.i("WholePeopleLebaEntryChecker", 2, String.format(Locale.getDefault(), "update show: %b", new Object[] { Boolean.valueOf(this.c) }));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return false;
    }
    ReportController.b(this.a, "dc00898", "", "", "0X8008824", "0X8008824", 0, this.g, 0, "", "", "", "");
    this.g = 0;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker
 * JD-Core Version:    0.7.0.1
 */