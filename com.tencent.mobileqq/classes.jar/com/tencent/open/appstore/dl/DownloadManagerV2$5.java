package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.AppNotificationManager.NoticeIdentity;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManagerV2$5
  implements Runnable
{
  DownloadManagerV2$5(DownloadManagerV2 paramDownloadManagerV2) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = AppNotificationManager.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        AppNotificationManager.NoticeIdentity localNoticeIdentity = (AppNotificationManager.NoticeIdentity)localConcurrentHashMap.get((String)localIterator.next());
        if (localNoticeIdentity != null)
        {
          Object localObject = DownloadManagerV2.a(this.this$0, localNoticeIdentity.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != DownloadManagerV2.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              AppNotificationManager.a().a(localNoticeIdentity.a);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.5
 * JD-Core Version:    0.7.0.1
 */