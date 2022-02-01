package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import aoql;
import aqpv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

class DesktopDataManager$16
  implements Runnable
{
  DesktopDataManager$16(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    AppInterface localAppInterface = MiniAppUtils.getAppInterface();
    if (localAppInterface == null)
    {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable, app is null.");
      return;
    }
    try
    {
      Object localObject2 = new DesktopDataManager.16.1(this, DesktopDataManager.access$2600(this.this$0, localAppInterface));
      this.this$0.runOnMainThread((Runnable)localObject2);
      localObject2 = localAppInterface.getEntityManagerFactory().createEntityManager().query(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, null, null, null, null, null, null);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          MiniAppRedDotEntity localMiniAppRedDotEntity = (MiniAppRedDotEntity)((Iterator)localObject2).next();
          if ((localMiniAppRedDotEntity != null) && (!TextUtils.isEmpty(localMiniAppRedDotEntity.appId))) {
            DesktopDataManager.access$2800(this.this$0).put(localMiniAppRedDotEntity.appId, Integer.valueOf(localMiniAppRedDotEntity.wnsPushRedDotNum));
          }
        }
      }
      DesktopDataManager.access$2900(this.this$0);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable error,", localThrowable);
      return;
    }
    Object localObject1 = (aoql)localThrowable.getBusinessHandler(148);
    if (localObject1 != null) {
      ((aoql)localObject1).c();
    }
    localObject1 = aqpv.a("miniappgetpskeydomain", "qzone.qq.com");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.d("DesktopDataManager", 1, "getPskeyDomain : " + (String)localObject1);
      localObject1 = ((String)localObject1).split(",");
      if (localObject1.length > 0)
      {
        localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).GetPskey(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 16L, (String[])localObject1, new DesktopDataManager.16.2(this));
        if ((localObject1 != null) && (!TextUtils.isEmpty(((Ticket)localObject1).getPSkey("qzone.qq.com")))) {
          QLog.d("DesktopDataManager", 1, "pskey success.");
        }
      }
    }
    DesktopDataManager.access$3002(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.16
 * JD-Core Version:    0.7.0.1
 */