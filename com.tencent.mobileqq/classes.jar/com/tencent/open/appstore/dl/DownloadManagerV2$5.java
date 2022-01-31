package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bdgv;
import bdmb;
import bdmc;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$5
  implements Runnable
{
  public DownloadManagerV2$5(bdgv parambdgv) {}
  
  public void run()
  {
    ConcurrentHashMap localConcurrentHashMap = bdmb.a().a();
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        bdmc localbdmc = (bdmc)localConcurrentHashMap.get((String)localIterator.next());
        if (localbdmc != null)
        {
          Object localObject = bdgv.a(this.this$0, localbdmc.b);
          if ((localObject != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject).d)))
          {
            localObject = this.this$0.a(((DownloadInfo)localObject).d);
            if ((localObject != null) && (4 != bdgv.a(((TMAssistantDownloadTaskInfo)localObject).mState))) {
              bdmb.a().a(localbdmc.a);
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