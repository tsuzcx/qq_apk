package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bdhk;
import bdmq;
import bdmr;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bdhk parambdhk) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bdmq.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bdmr localbdmr = (bdmr)localConcurrentHashMap.get((String)localIterator.next());
        if (localbdmr != null)
        {
          Object localObject = bdhk.a(this.this$0, localbdmr.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bdhk.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bdmq.a().a(localbdmr.a);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.5
 * JD-Core Version:    0.7.0.1
 */