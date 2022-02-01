package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bhpc;
import biam;
import biby;
import bidk;
import bidl;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(biby parambiby) {}
  
  public void run()
  {
    Object localObject1 = biam.b(bhpc.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = bidk.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          bidl localbidl = (bidl)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localbidl != null)
          {
            Object localObject2 = this.this$0.a(localbidl.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.a(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != biby.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                bidk.a().a(localbidl.a);
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