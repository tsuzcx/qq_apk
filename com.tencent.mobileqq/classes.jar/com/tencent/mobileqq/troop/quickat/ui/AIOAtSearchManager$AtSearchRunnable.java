package com.tencent.mobileqq.troop.quickat.ui;

import ajtt;
import android.os.Handler;
import android.os.Message;
import bfjk;
import bfjw;
import bfjx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AIOAtSearchManager$AtSearchRunnable
  implements Runnable
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private List<TroopMemberInfo> jdField_a_of_type_JavaUtilList;
  public volatile boolean a;
  private boolean b;
  private boolean c;
  
  public AIOAtSearchManager$AtSearchRunnable(String paramString, List<TroopMemberInfo> paramList, Handler paramHandler, QQAppInterface paramQQAppInterface, boolean paramBoolean1, SessionInfo paramSessionInfo, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.c = paramBoolean1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.b = paramBoolean2;
  }
  
  private ArrayList<ajtt> a(List<TroopMemberInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
      localArrayList.add(bfjk.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localTroopMemberInfo));
    }
    return localArrayList;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("AIOAtSearchManager", 2, "taa AtSearchRunnable start: " + System.currentTimeMillis());
    }
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      bfjx localbfjx;
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
        localbfjx = new bfjw(a(this.jdField_a_of_type_JavaUtilList)).a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString, this.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.b);
      } while (this.jdField_a_of_type_Boolean);
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = localbfjx;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    } while (!QLog.isColorLevel());
    QLog.e("AIOAtSearchManager", 2, "taa AtSearchRunnable end: " + System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager.AtSearchRunnable
 * JD-Core Version:    0.7.0.1
 */