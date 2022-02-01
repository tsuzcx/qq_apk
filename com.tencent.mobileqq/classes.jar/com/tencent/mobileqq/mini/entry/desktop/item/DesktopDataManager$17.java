package com.tencent.mobileqq.mini.entry.desktop.item;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
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

class DesktopDataManager$17
  implements Runnable
{
  DesktopDataManager$17(DesktopDataManager paramDesktopDataManager) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null)
    {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable, app is null.");
      return;
    }
    try
    {
      Object localObject2 = new DesktopDataManager.17.1(this, DesktopDataManager.access$2600(this.this$0, (AppInterface)localObject1));
      this.this$0.runOnMainThread((Runnable)localObject2);
      localObject2 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager().query(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, null, null, null, null, null, null);
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
      localObject1 = (AppletsHandler)((AppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
      if (localObject1 != null) {
        ((AppletsHandler)localObject1).c();
      }
      localObject1 = MiniAppConfProcessor.a("miniappgetpskeydomain", "qzone.qq.com");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPskeyDomain : ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("DesktopDataManager", 1, ((StringBuilder)localObject2).toString());
        localObject1 = ((String)localObject1).split(",");
        if (localObject1.length > 0)
        {
          localObject1 = ((TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2)).getPskey(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 16L, (String[])localObject1, new DesktopDataManager.17.2(this));
          if ((localObject1 != null) && (!TextUtils.isEmpty(((Ticket)localObject1).getPSkey("qzone.qq.com")))) {
            QLog.d("DesktopDataManager", 1, "pskey success.");
          }
        }
      }
      DesktopDataManager.access$3002(this.this$0, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DesktopDataManager", 1, "initLocalDataRunnable error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.17
 * JD-Core Version:    0.7.0.1
 */