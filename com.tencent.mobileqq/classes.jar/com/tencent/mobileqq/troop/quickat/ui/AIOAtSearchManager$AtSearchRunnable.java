package com.tencent.mobileqq.troop.quickat.ui;

import agau;
import android.os.Handler;
import android.os.Message;
import baeq;
import baer;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class AIOAtSearchManager$AtSearchRunnable
  implements Runnable
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<agau> jdField_a_of_type_JavaUtilList;
  public volatile boolean a;
  private boolean b;
  private boolean c;
  
  public AIOAtSearchManager$AtSearchRunnable(String paramString, List<agau> paramList, Handler paramHandler, QQAppInterface paramQQAppInterface, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.c = paramBoolean1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.b = paramBoolean2;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AIOAtSearchManager", 2, "taa AtSearchRunnable start: " + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      baer localbaer;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
        localbaer = new baeq(this.jdField_a_of_type_JavaUtilList).a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.b);
      } while (this.jdField_a_of_type_Boolean);
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localbaer;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.e("AIOAtSearchManager", 2, "taa AtSearchRunnable end: " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager.AtSearchRunnable
 * JD-Core Version:    0.7.0.1
 */