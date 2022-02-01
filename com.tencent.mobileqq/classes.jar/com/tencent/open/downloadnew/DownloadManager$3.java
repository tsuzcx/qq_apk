package com.tencent.open.downloadnew;

import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.AppNotificationManager.NoticeIdentity;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManager$3
  implements Runnable
{
  DownloadManager$3(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    Object localObject1 = AppUtil.b(CommonDataAdapter.a().b());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = AppNotificationManager.a().b();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          AppNotificationManager.NoticeIdentity localNoticeIdentity = (AppNotificationManager.NoticeIdentity)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localNoticeIdentity != null)
          {
            Object localObject2 = this.this$0.d(localNoticeIdentity.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.h(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != DownloadManager.b(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                AppNotificationManager.a().a(localNoticeIdentity.a);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.3
 * JD-Core Version:    0.7.0.1
 */