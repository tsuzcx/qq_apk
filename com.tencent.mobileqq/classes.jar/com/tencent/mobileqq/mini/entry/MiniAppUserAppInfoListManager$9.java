package com.tencent.mobileqq.mini.entry;

import aukm;
import aukn;
import auko;
import aukp;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$9
  implements Runnable
{
  MiniAppUserAppInfoListManager$9(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, aukm paramaukm) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "saveToDB, app is null.");
    }
    aukn localaukn;
    do
    {
      return;
      localaukn = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while ((localaukn == null) || (this.val$entity == null));
    localObject1 = localaukn.a();
    ((aukp)localObject1).a();
    try
    {
      MiniAppUserAppInfoListManager.access$1100(this.this$0, localaukn, this.val$entity);
      ((aukp)localObject1).c();
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
      ((aukp)localObject1).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.9
 * JD-Core Version:    0.7.0.1
 */