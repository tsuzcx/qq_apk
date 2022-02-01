package com.tencent.mobileqq.troop.utils;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable
  implements Runnable
{
  volatile boolean a;
  WeakReference<TroopChatPie> b;
  WeakReference<QQAppInterface> c;
  
  public TroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable(TroopChatPie paramTroopChatPie, QQAppInterface paramQQAppInterface)
  {
    this.b = new WeakReference(paramTroopChatPie);
    this.c = new WeakReference(paramQQAppInterface);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (paramBoolean) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this);
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CheckHighFreqInteractionRunnable", 2, "checkHighFreqInteractionUinTask start");
    }
    Object localObject = (TroopChatPie)this.b.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.c.get();
    if ((localObject != null) && (localQQAppInterface != null))
    {
      if (this.a) {
        return;
      }
      String str = ((TroopChatPie)localObject).ah.b;
      int i = ((TroopChatPie)localObject).ah.a;
      long l1 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k().m * 60;
      long l2 = NetConnInfoCenter.getServerTime();
      localObject = localQQAppInterface.getMessageFacade().a(str, i, ((TroopChatPie)localObject).bP, 250, String.format("time>=%d and (extLong & 2)=%d", new Object[] { Long.valueOf(l2 - l1), Integer.valueOf(0) }));
      ArrayList localArrayList = TroopBatchAddFriendMgr.a((List)localObject, localQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("CheckHighFreqInteractionRunnable", 2, String.format("checkHighFreqInteractionUinTask msgSize=%d uins = ", new Object[] { Integer.valueOf(((List)localObject).size()), Arrays.toString(localArrayList.toArray()) }));
      }
      if ((localArrayList.size() > 0) && (!this.a)) {
        ((ITroopBatchAddFriendService)localQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().a(str, localArrayList, 3);
      }
      if ((!this.a) && (this.b.get() != null) && (this.c.get() != null)) {
        ThreadManager.getSubThreadHandler().postDelayed(this, l1 * 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable
 * JD-Core Version:    0.7.0.1
 */