package com.tencent.mobileqq.mini.entry;

import awge;
import awgf;
import awgg;
import com.tencent.common.app.AppInterface;
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
    if (localObject1 == null) {
      QLog.e("MiniAppLocalSearchManager", 2, "updateDataToDB, app is null.");
    }
    for (;;)
    {
      return;
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      if (localObject1 != null)
      {
        Object localObject2 = MiniAppLocalSearchEntity.class.getSimpleName();
        Object localObject3 = this.val$netResult.appId;
        String str = this.val$netResult.appId;
        localObject2 = ((awgf)localObject1).a(MiniAppLocalSearchEntity.class, (String)localObject2, false, "appId = ?", new String[] { localObject3 }, null, null, null, str);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (MiniAppLocalSearchEntity)((Iterator)localObject2).next();
            QLog.i("MiniAppLocalSearchManager", 2, "updateDataDbFromNetResult  : " + this.val$netResult.desc);
            ((MiniAppLocalSearchEntity)localObject3).desc = this.val$netResult.desc;
            MiniAppLocalSearchManager.access$100(this.this$0, (awgf)localObject1, (awge)localObject3);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppLocalSearchManager.2
 * JD-Core Version:    0.7.0.1
 */