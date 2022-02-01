package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bjsz;
import bjyc;
import bjyd;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bjsz parambjsz) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bjyc.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bjyd localbjyd = (bjyd)localConcurrentHashMap.get((String)localIterator.next());
        if (localbjyd != null)
        {
          Object localObject = bjsz.a(this.this$0, localbjyd.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bjsz.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bjyc.a().a(localbjyd.a);
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