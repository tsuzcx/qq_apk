package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bisa;
import bixd;
import bixe;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bisa parambisa) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bixd.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bixe localbixe = (bixe)localConcurrentHashMap.get((String)localIterator.next());
        if (localbixe != null)
        {
          Object localObject = bisa.a(this.this$0, localbixe.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bisa.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bixd.a().a(localbixe.a);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.5
 * JD-Core Version:    0.7.0.1
 */