package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bccu;
import bcia;
import bcib;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bccu parambccu) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bcia.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bcib localbcib = (bcib)localConcurrentHashMap.get((String)localIterator.next());
        if (localbcib != null)
        {
          Object localObject = bccu.a(this.this$0, localbcib.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bccu.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bcia.a().a(localbcib.a);
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