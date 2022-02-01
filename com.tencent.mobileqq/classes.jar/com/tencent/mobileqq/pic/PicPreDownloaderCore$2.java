package com.tencent.mobileqq.pic;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class PicPreDownloaderCore$2
  implements Runnable
{
  PicPreDownloaderCore$2(PicPreDownloaderCore paramPicPreDownloaderCore, int paramInt) {}
  
  public void run()
  {
    synchronized (PicPreDownloaderCore.a(this.this$0))
    {
      Object localObject1 = PicPreDownloaderCore.a(this.this$0).iterator();
      int k = 0;
      int j = 0;
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        PicReq localPicReq = (PicReq)((Iterator)localObject1).next();
        int m = localPicReq.f;
        if (m != 3)
        {
          if (m != 4)
          {
            k += 1;
            localPicReq.e = localPicReq.f;
            this.this$0.a.put(localPicReq.a.g, Integer.valueOf(localPicReq.e));
            PicPreDownloaderCore.d(this.this$0).add(0, localPicReq);
          }
          else
          {
            i += 1;
            localPicReq.e = localPicReq.f;
            this.this$0.a.put(localPicReq.a.g, Integer.valueOf(localPicReq.e));
            PicPreDownloaderCore.b(this.this$0).add(0, localPicReq);
          }
        }
        else
        {
          j += 1;
          localPicReq.e = localPicReq.f;
          this.this$0.a.put(localPicReq.a.g, Integer.valueOf(localPicReq.e));
          PicPreDownloaderCore.c(this.this$0).add(0, localPicReq);
        }
        localPicReq.e = localPicReq.f;
        this.this$0.a.put(localPicReq.a.g, Integer.valueOf(localPicReq.e));
      }
      PicPreDownloaderCore.a(this.this$0).clear();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clearAIORequests(): totalCount=");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(" countOfC2C=");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" countOfDiscussion=");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" countOfGroup=");
        ((StringBuilder)localObject1).append(k);
        QLog.d("PIC_TAG_PRELOAD", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.2
 * JD-Core Version:    0.7.0.1
 */