package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopAppServiceImpl$3
  implements Runnable
{
  TroopAppServiceImpl$3(TroopAppServiceImpl paramTroopAppServiceImpl, ArrayList paramArrayList, EntityManager paramEntityManager, int paramInt) {}
  
  public void run()
  {
    if (this.a != null)
    {
      Object localObject1 = TableBuilder.getTableNameSafe(TroopAIOAppInfo.class);
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = this.b.query(TroopAIOAppInfo.class);
        localObject3 = this.this$0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("before delete type:");
        localStringBuilder.append(this.c);
        TroopAppServiceImpl.access$000((TroopAppServiceImpl)localObject3, ".troop.troop_appVASH", localStringBuilder.toString(), (List)localObject2);
      }
      this.b.delete((String)localObject1, "groupType=?", new String[] { String.valueOf(this.c) });
      if (QLog.isColorLevel())
      {
        localObject1 = this.b.query(TroopAIOAppInfo.class);
        localObject2 = this.this$0;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("before update after delete type:");
        ((StringBuilder)localObject3).append(this.c);
        TroopAppServiceImpl.access$000((TroopAppServiceImpl)localObject2, ".troop.troop_appVASH", ((StringBuilder)localObject3).toString(), (List)localObject1);
      }
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopAIOAppInfo)((Iterator)localObject1).next();
        ((TroopAIOAppInfo)localObject2).setStatus(1000);
        TroopAppServiceImpl.access$100(this.this$0, this.b, (Entity)localObject2);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = this.b.query(TroopAIOAppInfo.class);
        localObject2 = this.this$0;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("after update type:");
        ((StringBuilder)localObject3).append(this.c);
        TroopAppServiceImpl.access$000((TroopAppServiceImpl)localObject2, ".troop.troop_appVASH", ((StringBuilder)localObject3).toString(), (List)localObject1);
      }
    }
    this.b.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */