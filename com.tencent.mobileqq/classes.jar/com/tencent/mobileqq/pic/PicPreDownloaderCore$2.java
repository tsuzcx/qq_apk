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
    synchronized (PicPreDownloaderCore.b(this.this$0))
    {
      Object localObject1 = PicPreDownloaderCore.b(this.this$0).iterator();
      int m = 0;
      int i = 0;
      int k = 0;
      int j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        PicReq localPicReq = (PicReq)((Iterator)localObject1).next();
        int n = localPicReq.p;
        if (n != 3)
        {
          if (n != 4)
          {
            if (n == 5)
            {
              k += 1;
              localPicReq.o = localPicReq.p;
              this.this$0.a.put(localPicReq.f.n, Integer.valueOf(localPicReq.o));
              PicPreDownloaderCore.c(this.this$0).add(0, localPicReq);
              break label325;
            }
          }
          else
          {
            i += 1;
            localPicReq.o = localPicReq.p;
            this.this$0.a.put(localPicReq.f.n, Integer.valueOf(localPicReq.o));
            PicPreDownloaderCore.e(this.this$0).add(0, localPicReq);
          }
          j += 1;
          localPicReq.o = localPicReq.p;
          this.this$0.a.put(localPicReq.f.n, Integer.valueOf(localPicReq.o));
          PicPreDownloaderCore.f(this.this$0).add(0, localPicReq);
        }
        else
        {
          m += 1;
          localPicReq.o = localPicReq.p;
          this.this$0.a.put(localPicReq.f.n, Integer.valueOf(localPicReq.o));
          PicPreDownloaderCore.d(this.this$0).add(0, localPicReq);
        }
        label325:
        localPicReq.o = localPicReq.p;
        this.this$0.a.put(localPicReq.f.n, Integer.valueOf(localPicReq.o));
      }
      PicPreDownloaderCore.b(this.this$0).clear();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("clearAIORequests(): totalCount=");
        ((StringBuilder)localObject1).append(this.a);
        ((StringBuilder)localObject1).append(" countOfC2C=");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(" countOfDiscussion=");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(" countOfGroup=");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" countOfGuild=");
        ((StringBuilder)localObject1).append(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.2
 * JD-Core Version:    0.7.0.1
 */