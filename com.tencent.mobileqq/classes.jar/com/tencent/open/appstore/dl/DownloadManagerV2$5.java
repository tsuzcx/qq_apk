package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bfgi;
import bfln;
import bflo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bfgi parambfgi) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bfln.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bflo localbflo = (bflo)localConcurrentHashMap.get((String)localIterator.next());
        if (localbflo != null)
        {
          Object localObject = bfgi.a(this.this$0, localbflo.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bfgi.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bfln.a().a(localbflo.a);
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