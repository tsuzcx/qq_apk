package com.tencent.mobileqq.mini.entry;

import atmo;
import atmp;
import atmq;
import atmr;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$9
  implements Runnable
{
  MiniAppUserAppInfoListManager$9(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, atmo paramatmo) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "saveToDB, app is null.");
    }
    atmp localatmp;
    do
    {
      return;
      localatmp = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while ((localatmp == null) || (this.val$entity == null));
    localObject1 = localatmp.a();
    ((atmr)localObject1).a();
    try
    {
      MiniAppUserAppInfoListManager.access$1100(this.this$0, localatmp, this.val$entity);
      ((atmr)localObject1).c();
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
      ((atmr)localObject1).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.9
 * JD-Core Version:    0.7.0.1
 */