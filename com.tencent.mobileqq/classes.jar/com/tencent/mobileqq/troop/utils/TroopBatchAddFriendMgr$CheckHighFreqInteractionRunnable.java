package com.tencent.mobileqq.troop.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable
  implements Runnable
{
  WeakReference<TroopChatPie> jdField_a_of_type_MqqUtilWeakReference;
  volatile boolean jdField_a_of_type_Boolean;
  WeakReference<QQAppInterface> b;
  
  public TroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable(TroopChatPie paramTroopChatPie, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramTroopChatPie);
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
    Object localObject = (TroopChatPie)this.jdField_a_of_type_MqqUtilWeakReference.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.b.get();
    if ((localObject == null) || (localQQAppInterface == null) || (this.jdField_a_of_type_Boolean)) {}
    long l1;
    do
    {
      return;
      String str = ((TroopChatPie)localObject).a.jdField_a_of_type_JavaLangString;
      int i = ((TroopChatPie)localObject).a.jdField_a_of_type_Int;
      l1 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a().i * 60;
      long l2 = NetConnInfoCenter.getServerTime();
      localObject = localQQAppInterface.getMessageFacade().a(str, i, ((TroopChatPie)localObject).c, 250, String.format("time>=%d and (extLong & 2)=%d", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(0) }));
      ArrayList localArrayList = TroopBatchAddFriendMgr.a((List)localObject, localQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("CheckHighFreqInteractionRunnable", 2, String.format("checkHighFreqInteractionUinTask msgSize=%d uins = ", new Object[] { Integer.valueOf(((List)localObject).size()), Arrays.toString(localArrayList.toArray()) }));
      }
      if ((localArrayList.size() > 0) && (!this.jdField_a_of_type_Boolean)) {
        ((TroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a().a(str, localArrayList, 3);
      }
    } while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null) || (this.b.get() == null));
    ThreadManager.getSubThreadHandler().postDelayed(this, 1000L * l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable
 * JD-Core Version:    0.7.0.1
 */