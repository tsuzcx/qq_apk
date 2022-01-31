package com.tencent.mobileqq.mini.entry;

import awbv;
import awbw;
import awbx;
import awby;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class MiniAppUserAppInfoListManager$9
  implements Runnable
{
  MiniAppUserAppInfoListManager$9(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager, awbv paramawbv) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null) {
      QLog.e("MiniAppUserAppInfoListManager", 1, "saveToDB, app is null.");
    }
    awbw localawbw;
    do
    {
      return;
      localawbw = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
    } while ((localawbw == null) || (this.val$entity == null));
    localObject1 = localawbw.a();
    ((awby)localObject1).a();
    try
    {
      MiniAppUserAppInfoListManager.access$1100(this.this$0, localawbw, this.val$entity);
      ((awby)localObject1).c();
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
      ((awby)localObject1).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.9
 * JD-Core Version:    0.7.0.1
 */