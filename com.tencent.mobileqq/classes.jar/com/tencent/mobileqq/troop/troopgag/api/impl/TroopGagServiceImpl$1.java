package com.tencent.mobileqq.troop.troopgag.api.impl;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class TroopGagServiceImpl$1
  implements Runnable
{
  TroopGagServiceImpl$1(TroopGagServiceImpl paramTroopGagServiceImpl, TroopMemberInfo paramTroopMemberInfo, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.mApp.getEntityManagerFactory().createEntityManager();
    if (this.a.getStatus() == 1000) {
      ((EntityManager)localObject).persistOrReplace(this.a);
    } else {
      ((EntityManager)localObject).update(this.a);
    }
    ((EntityManager)localObject).close();
    localObject = this.this$0.getTroopMemberGagList(this.b);
    new Handler(Looper.getMainLooper()).post(new TroopGagServiceImpl.1.1(this, (ArrayList)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopgag.api.impl.TroopGagServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */