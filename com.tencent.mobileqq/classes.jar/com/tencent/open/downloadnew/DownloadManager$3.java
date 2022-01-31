package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bfbm;
import bfms;
import bfok;
import bfpw;
import bfpx;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(bfok parambfok) {}
  
  public void run()
  {
    Object localObject1 = bfms.b(bfbm.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = bfpw.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          bfpx localbfpx = (bfpx)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localbfpx != null)
          {
            Object localObject2 = this.this$0.a(localbfpx.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.a(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != bfok.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                bfpw.a().a(localbfpx.a);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.3
 * JD-Core Version:    0.7.0.1
 */