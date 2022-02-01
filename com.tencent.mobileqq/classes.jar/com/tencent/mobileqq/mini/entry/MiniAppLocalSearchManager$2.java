package com.tencent.mobileqq.mini.entry;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class MiniAppLocalSearchManager$2
  implements Runnable
{
  MiniAppLocalSearchManager$2(MiniAppLocalSearchManager paramMiniAppLocalSearchManager, MiniAppLocalSearchEntity paramMiniAppLocalSearchEntity) {}
  
  public void run()
  {
    Object localObject1 = MiniAppLocalSearchManager.access$000();
    if (localObject1 == null)
    {
      QLog.e("MiniAppLocalSearchManager", 2, "updateDataToDB, app is null.");
      return;
    }
    localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    if (localObject1 != null)
    {
      Object localObject2 = MiniAppLocalSearchEntity.class.getSimpleName();
      Object localObject3 = this.val$netResult.appId;
      Object localObject4 = this.val$netResult.appId;
      localObject2 = ((EntityManager)localObject1).query(MiniAppLocalSearchEntity.class, (String)localObject2, false, "appId = ?", new String[] { localObject3 }, null, null, null, (String)localObject4);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MiniAppLocalSearchEntity)((Iterator)localObject2).next();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("updateDataDbFromNetResult  : ");
          ((StringBuilder)localObject4).append(this.val$netResult.desc);
          QLog.i("MiniAppLocalSearchManager", 2, ((StringBuilder)localObject4).toString());
          ((MiniAppLocalSearchEntity)localObject3).desc = this.val$netResult.desc;
          MiniAppLocalSearchManager.access$100(this.this$0, (EntityManager)localObject1, (Entity)localObject3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.2
 * JD-Core Version:    0.7.0.1
 */