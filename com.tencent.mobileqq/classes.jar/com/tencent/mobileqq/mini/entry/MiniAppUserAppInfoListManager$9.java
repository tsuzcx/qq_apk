package com.tencent.mobileqq.mini.entry;

import auko;
import aukp;
import aukq;
import aukr;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$9
  implements Runnable
{
  MiniAppUserAppInfoListManager$9(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, auko paramauko) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "saveToDB, app is null.");
    }
    aukp localaukp;
    do
    {
      return;
      localaukp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while ((localaukp == null) || (this.val$entity == null));
    localObject1 = localaukp.a();
    ((aukr)localObject1).a();
    try
    {
      MiniAppUserAppInfoListManager.access$1100(this.this$0, localaukp, this.val$entity);
      ((aukr)localObject1).c();
      QLog.w("MiniAppUserAppInfoListManager", 2, "saveToDB, appInfo: " + this.val$entity);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppUserAppInfoListManager", 2, "saveToDB exception: ", localException);
      }
      return;
    }
    finally
    {
      ((aukr)localObject1).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.9
 * JD-Core Version:    0.7.0.1
 */