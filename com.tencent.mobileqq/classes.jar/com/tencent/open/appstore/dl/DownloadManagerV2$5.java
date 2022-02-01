package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bjjq;
import bjom;
import bjon;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bjjq parambjjq) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bjom.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bjon localbjon = (bjon)localConcurrentHashMap.get((String)localIterator.next());
        if (localbjon != null)
        {
          Object localObject = bjjq.a(this.this$0, localbjon.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bjjq.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bjom.a().a(localbjon.a);
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