package com.tencent.mobileqq.mini.entry;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class MiniAppUserAppInfoListManager$5
  implements Runnable
{
  MiniAppUserAppInfoListManager$5(MiniAppUserAppInfoListManager paramMiniAppUserAppInfoListManager) {}
  
  public void run()
  {
    Object localObject1 = MiniAppUtils.getAppInterface();
    if (localObject1 == null)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "initLocalDataRunnable, app is null.");
      return;
    }
    try
    {
      Object localObject3 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager();
      if (localObject3 != null)
      {
        Object localObject4 = ((EntityManager)localObject3).query(MiniAppEntity.class, MiniAppEntity.class.getSimpleName(), false, null, null, null, null, "position asc", null);
        StringBuilder localStringBuilder = new StringBuilder();
        if (localObject4 != null) {
          try
          {
            if (((MiniAppUserAppInfoListManager.access$500(this.this$0).size() > 0) || (MiniAppUserAppInfoListManager.access$600(this.this$0).size() > 0)) && (MiniAppUserAppInfoListManager.access$700(this.this$0) != null))
            {
              MiniAppUserAppInfoListManager.access$800(this.this$0).clear();
              localObject1 = ((List)localObject4).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (MiniAppEntity)((Iterator)localObject1).next();
                if ((localObject3 != null) && (((MiniAppEntity)localObject3).appInfo != null))
                {
                  localObject3 = ((MiniAppEntity)localObject3).createFromBuffer(((MiniAppEntity)localObject3).appInfo);
                  if (localObject3 != null) {
                    MiniAppUserAppInfoListManager.access$800(this.this$0).add(localObject3);
                  }
                }
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("initLocalDataRunnable, has get server data, top list size: ");
              ((StringBuilder)localObject1).append(MiniAppUserAppInfoListManager.access$600(this.this$0).size());
              ((StringBuilder)localObject1).append(", user list size: ");
              ((StringBuilder)localObject1).append(MiniAppUserAppInfoListManager.access$500(this.this$0).size());
              ((StringBuilder)localObject1).append(", mDbCacheAppList size: ");
              ((StringBuilder)localObject1).append(MiniAppUserAppInfoListManager.access$800(this.this$0).size());
              QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject1).toString());
              return;
            }
            if (MiniAppUserAppInfoListManager.access$500(this.this$0).size() + MiniAppUserAppInfoListManager.access$600(this.this$0).size() == ((List)localObject4).size())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("initLocalDataRunnable, has init. mUsedAppList size: ");
              ((StringBuilder)localObject1).append(MiniAppUserAppInfoListManager.access$500(this.this$0).size());
              ((StringBuilder)localObject1).append(", mTopAppList size: ");
              ((StringBuilder)localObject1).append(MiniAppUserAppInfoListManager.access$600(this.this$0).size());
              QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject1).toString());
              return;
            }
            Object localObject5 = ((List)localObject4).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              Object localObject6 = (MiniAppEntity)((Iterator)localObject5).next();
              if ((localObject6 != null) && (((MiniAppEntity)localObject6).appInfo != null))
              {
                localObject6 = ((MiniAppEntity)localObject6).createFromBuffer(((MiniAppEntity)localObject6).appInfo);
                if (localObject6 != null)
                {
                  if (((MiniAppInfo)localObject6).topType == 1) {
                    MiniAppUserAppInfoListManager.access$600(this.this$0).add(localObject6);
                  } else {
                    MiniAppUserAppInfoListManager.access$500(this.this$0).add(localObject6);
                  }
                  localStringBuilder.append(((MiniAppInfo)localObject6).position);
                  localStringBuilder.append(":");
                  localStringBuilder.append(((MiniAppInfo)localObject6).name);
                  localStringBuilder.append(", ");
                }
              }
            }
            MiniAppUserAppInfoListManager.access$800(this.this$0).clear();
            MiniAppUserAppInfoListManager.access$800(this.this$0).addAll(MiniAppUserAppInfoListManager.access$600(this.this$0));
            MiniAppUserAppInfoListManager.access$800(this.this$0).addAll(MiniAppUserAppInfoListManager.access$500(this.this$0));
            MiniAppUtils.updateMiniAppList(8);
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("initLocalDataRunnable, tempList size=");
            ((StringBuilder)localObject5).append(((List)localObject4).size());
            ((StringBuilder)localObject5).append(", mUsedAppList size=");
            ((StringBuilder)localObject5).append(MiniAppUserAppInfoListManager.access$500(this.this$0).size());
            ((StringBuilder)localObject5).append(", DB cache app List = [");
            ((StringBuilder)localObject5).append(localStringBuilder.toString());
            ((StringBuilder)localObject5).append("]");
            QLog.e("MiniAppUserAppInfoListManager", 1, ((StringBuilder)localObject5).toString());
          }
          finally {}
        } else {
          QLog.e("MiniAppUserAppInfoListManager", 1, "initLocalDataRunnable, tempList is null.");
        }
        localObject3 = ((EntityManager)localObject3).query(MiniAppRedDotEntity.class, MiniAppRedDotEntity.class.getSimpleName(), false, null, null, null, null, null, null);
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (MiniAppRedDotEntity)((Iterator)localObject3).next();
            if ((localObject4 != null) && (!TextUtils.isEmpty(((MiniAppRedDotEntity)localObject4).appId))) {
              MiniAppUserAppInfoListManager.access$900(this.this$0).put(((MiniAppRedDotEntity)localObject4).appId, Integer.valueOf(((MiniAppRedDotEntity)localObject4).wnsPushRedDotNum));
            }
          }
        }
      }
      AppletsHandler localAppletsHandler = (AppletsHandler)localObject2.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
      if (localAppletsHandler != null)
      {
        localAppletsHandler.c();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppUserAppInfoListManager", 1, "initLocalDataRunnable error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager.5
 * JD-Core Version:    0.7.0.1
 */