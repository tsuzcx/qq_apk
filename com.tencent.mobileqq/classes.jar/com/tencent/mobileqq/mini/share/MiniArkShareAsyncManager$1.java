package com.tencent.mobileqq.mini.share;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

final class MiniArkShareAsyncManager$1
  implements Runnable
{
  MiniArkShareAsyncManager$1(String paramString) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).a().createEntityManager();
      if (localObject != null)
      {
        Entity localEntity = ((EntityManager)localObject).find(MiniProgramArkShareLocalImageEntity.class, "localPath = ?", new String[] { this.val$filePath });
        if (localEntity != null)
        {
          if (!((EntityManager)localObject).remove(localEntity)) {
            break label90;
          }
          QLog.d("MiniArkShareAsyncManage [miniappArkShare]", 2, "removeArkShareLocalImageDatabaseEntity: remove record for " + this.val$filePath);
        }
      }
    }
    return;
    label90:
    QLog.e("MiniArkShareAsyncManage [miniappArkShare]", 2, new Object[] { "removeArkShareLocalImageDatabaseEntity", " remove error for " + this.val$filePath });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */