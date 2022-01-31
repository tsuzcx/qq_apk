package com.tencent.mobileqq.troop.utils;

import aejb;
import ajtg;
import akhd;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable
  implements Runnable
{
  WeakReference<aejb> jdField_a_of_type_MqqUtilWeakReference;
  volatile boolean jdField_a_of_type_Boolean;
  WeakReference<QQAppInterface> b;
  
  public TroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable(aejb paramaejb, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaejb);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CheckHighFreqInteractionRunnable", 2, "checkHighFreqInteractionUinTask start");
    }
    Object localObject = (aejb)this.jdField_a_of_type_MqqUtilWeakReference.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((localObject == null) || (localQQAppInterface == null) || (this.jdField_a_of_type_Boolean)) {}
    long l1;
    do
    {
      return;
      String str = ((aejb)localObject).a.jdField_a_of_type_JavaLangString;
      int i = ((aejb)localObject).a.jdField_a_of_type_Int;
      l1 = ((TroopManager)localQQAppInterface.getManager(52)).a().i * 60;
      long l2 = NetConnInfoCenter.getServerTime();
      localObject = TroopBatchAddFriendMgr.a(localQQAppInterface.a().a(str, i, ((aejb)localObject).h, 250, String.format("time>=%d", new Object[] { Long.valueOf(l2 - l1) })), localQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("CheckHighFreqInteractionRunnable", 2, "checkHighFreqInteractionUinTask uins = " + Arrays.toString(((ArrayList)localObject).toArray()));
      }
      if ((((ArrayList)localObject).size() > 0) && (!this.jdField_a_of_type_Boolean)) {
        ((ajtg)localQQAppInterface.a(20)).a().a(str, (List)localObject, 3);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (this.b.get() == null));
    ThreadManager.getSubThreadHandler().postDelayed(this, 1000L * l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable
 * JD-Core Version:    0.7.0.1
 */