package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bhyo;
import bidk;
import bidl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bhyo parambhyo) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bidk.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bidl localbidl = (bidl)localConcurrentHashMap.get((String)localIterator.next());
        if (localbidl != null)
        {
          Object localObject = bhyo.a(this.this$0, localbidl.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bhyo.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bidk.a().a(localbidl.a);
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