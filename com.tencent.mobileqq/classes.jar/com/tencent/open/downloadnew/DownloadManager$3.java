package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bizw;
import bjlo;
import bjna;
import bjom;
import bjon;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(bjna parambjna) {}
  
  public void run()
  {
    Object localObject1 = bjlo.b(bizw.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = bjom.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          bjon localbjon = (bjon)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localbjon != null)
          {
            Object localObject2 = this.this$0.a(localbjon.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.a(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != bjna.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                bjom.a().a(localbjon.a);
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