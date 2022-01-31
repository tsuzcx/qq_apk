package com.tencent.mobileqq.mini.share;

import awbv;
import awbw;
import awbx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
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
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      if (localObject != null)
      {
        awbv localawbv = ((awbw)localObject).a(MiniProgramArkShareLocalImageEntity.class, "localPath = ?", new String[] { this.val$filePath });
        if (localawbv != null)
        {
          if (!((awbw)localObject).b(localawbv)) {
            break label90;
          }
          QLog.d("MiniArkShareAsyncManage", 2, "removeArkShareLocalImageDatabaseEntity: remove record for " + this.val$filePath);
        }
      }
    }
    return;
    label90:
    QLog.e("MiniArkShareAsyncManage", 2, new Object[] { "removeArkShareLocalImageDatabaseEntity", " remove error for " + this.val$filePath });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */