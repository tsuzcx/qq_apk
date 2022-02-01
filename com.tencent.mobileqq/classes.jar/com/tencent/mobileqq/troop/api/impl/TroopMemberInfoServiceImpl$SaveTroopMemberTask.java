package com.tencent.mobileqq.troop.api.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;

public class TroopMemberInfoServiceImpl$SaveTroopMemberTask
  implements Runnable
{
  TroopMemberInfo a;
  boolean b;
  volatile boolean c = false;
  
  TroopMemberInfoServiceImpl$SaveTroopMemberTask(TroopMemberInfoServiceImpl paramTroopMemberInfoServiceImpl, TroopMemberInfo paramTroopMemberInfo, boolean paramBoolean)
  {
    this.a = paramTroopMemberInfo;
    this.b = paramBoolean;
  }
  
  public void run()
  {
    this.c = true;
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    if (this.a.getStatus() == 1000) {
      localEntityManager.persistOrReplace(this.a);
    } else {
      localEntityManager.update(this.a);
    }
    localEntityManager.close();
    new Handler(Looper.getMainLooper()).post(new TroopMemberInfoServiceImpl.SaveTroopMemberTask.1(this));
    if (this.b) {
      ((ITroopNameHelperService)this.this$0.app.getRuntimeService(ITroopNameHelperService.class, "")).updateTroopName(this.a.troopuin);
    }
    this.c = false;
    TroopMemberInfoServiceImpl.access$200(this.this$0).remove(this);
    this.this$0.runNextSaveTask();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.SaveTroopMemberTask
 * JD-Core Version:    0.7.0.1
 */