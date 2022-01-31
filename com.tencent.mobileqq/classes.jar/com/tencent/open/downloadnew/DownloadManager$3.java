package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bcxm;
import bdiw;
import bdkp;
import bdmb;
import bdmc;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManager$3
  implements Runnable
{
  public DownloadManager$3(bdkp parambdkp) {}
  
  public void run()
  {
    Object localObject1 = bdiw.b(bcxm.a().a());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).contains(":")))
    {
      localObject1 = bdmb.a().a();
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          bdmc localbdmc = (bdmc)((ConcurrentHashMap)localObject1).get((String)localIterator.next());
          if (localbdmc != null)
          {
            Object localObject2 = this.this$0.a(localbdmc.b);
            if ((localObject2 != null) && (!TextUtils.isEmpty(((DownloadInfo)localObject2).d)))
            {
              localObject2 = this.this$0.a(((DownloadInfo)localObject2).d);
              if ((localObject2 != null) && (4 != bdkp.a(((TMAssistantDownloadTaskInfo)localObject2).mState))) {
                bdmb.a().a(localbdmc.a);
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