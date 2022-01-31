package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bexd;
import bfij;
import bfkb;
import bfln;
import bflo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(bfkb parambfkb) {}
  
  public void run()
  {
    Object localObject1 = bfij.b(bexd.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = bfln.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          bflo localbflo = (bflo)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localbflo != null)
          {
            Object localObject2 = this.this$0.a(localbflo.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.a(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != bfkb.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                bfln.a().a(localbflo.a);
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