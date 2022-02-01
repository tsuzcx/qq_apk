package com.tencent.mobileqq.winkpublish.queue;

import com.tencent.mobileqq.qcircle.api.IDbCacheService;
import com.tencent.mobileqq.qcircle.api.db.IDBManagerWrapper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.mobileqq.winkpublish.db.queue.AUploadTaskCacheData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AUploadTaskCacheManager
{
  private static final String a;
  private String b = "";
  private final AUploadTaskCacheManager.CacheHolder c = new AUploadTaskCacheManager.CacheHolder();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2_AUploadTaskCacheManager]");
    a = localStringBuilder.toString();
  }
  
  public AUploadTaskCacheManager()
  {
    this(AUploadCommonSetting.a().getTaskCacheName());
  }
  
  public AUploadTaskCacheManager(String paramString)
  {
    this.b = paramString;
  }
  
  private void a(AUploadTaskCacheManager.CacheHolder paramCacheHolder)
  {
    if (paramCacheHolder == null) {
      return;
    }
    long l = LoginData.a().b();
    if ((l != paramCacheHolder.a) || (paramCacheHolder.b == null) || (paramCacheHolder.b.isClosed()))
    {
      paramCacheHolder.a = l;
      paramCacheHolder.b = ((IDbCacheService)QRoute.api(IDbCacheService.class)).getCacheManager(AUploadTaskCacheData.class, l, this.b);
      paramCacheHolder.b.addCloseListener(paramCacheHolder.c);
    }
  }
  
  public ArrayList<IQueueTask> a()
  {
    a(this.c);
    ArrayList localArrayList2 = this.c.b.queryData();
    if (localArrayList2 != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      int j = localArrayList2.size();
      int i = 0;
      for (;;)
      {
        localObject1 = localArrayList1;
        if (i >= j) {
          break;
        }
        Object localObject2 = (AUploadTaskCacheData)localArrayList2.get(i);
        if ((localObject2 != null) && (((AUploadTaskCacheData)localObject2).getQueueTask() != null))
        {
          localObject1 = ((AUploadTaskCacheData)localObject2).getQueueTask();
          if (!((IQueueTask)localObject1).isNullTask())
          {
            if (((IQueueTask)localObject1).getState() != 6) {
              ((IQueueTask)localObject1).setState(2);
            }
            localArrayList1.add(((AUploadTaskCacheData)localObject2).getQueueTask());
          }
          else
          {
            c((IQueueTask)localObject1);
            localObject2 = a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("remove null task, id:");
            localStringBuilder.append(((IQueueTask)localObject1).getTaskId());
            QLog.w((String)localObject2, 1, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    Object localObject1 = null;
    return localObject1;
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (!paramIQueueTask.isNullTask())
    {
      a(this.c);
      this.c.b.saveData(new AUploadTaskCacheData(paramIQueueTask), 1);
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("save null task, id:");
    localStringBuilder.append(paramIQueueTask.getTaskId());
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void b(IQueueTask paramIQueueTask)
  {
    a(this.c);
    this.c.b.updateData(new AUploadTaskCacheData(paramIQueueTask), "client_key=?", new String[] { paramIQueueTask.getCacheKey() });
  }
  
  public void c(IQueueTask paramIQueueTask)
  {
    a(this.c);
    this.c.b.deleteData("client_key=?", new String[] { paramIQueueTask.getCacheKey() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.AUploadTaskCacheManager
 * JD-Core Version:    0.7.0.1
 */