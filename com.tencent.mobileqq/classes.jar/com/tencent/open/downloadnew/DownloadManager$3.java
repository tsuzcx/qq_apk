package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bjjo;
import bjva;
import bjwq;
import bjyc;
import bjyd;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(bjwq parambjwq) {}
  
  public void run()
  {
    Object localObject1 = bjva.b(bjjo.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = bjyc.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          bjyd localbjyd = (bjyd)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localbjyd != null)
          {
            Object localObject2 = this.this$0.a(localbjyd.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.a(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != bjwq.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                bjyc.a().a(localbjyd.a);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.3
 * JD-Core Version:    0.7.0.1
 */