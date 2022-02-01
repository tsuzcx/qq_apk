package com.tencent.mobileqq.pic;

import azjx;
import azke;
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
    int k = 0;
    for (;;)
    {
      int j;
      int i;
      azke localazke;
      synchronized (PicPreDownloaderCore.a(this.this$0))
      {
        Iterator localIterator = PicPreDownloaderCore.a(this.this$0).iterator();
        j = 0;
        i = 0;
        if (!localIterator.hasNext()) {
          break label310;
        }
        localazke = (azke)localIterator.next();
        switch (localazke.f)
        {
        case 4: 
          k += 1;
          localazke.e = localazke.f;
          this.this$0.a.put(localazke.a.g, Integer.valueOf(localazke.e));
          PicPreDownloaderCore.d(this.this$0).add(0, localazke);
          localazke.e = localazke.f;
          this.this$0.a.put(localazke.a.g, Integer.valueOf(localazke.e));
        }
      }
      i += 1;
      localazke.e = localazke.f;
      this.this$0.a.put(localazke.a.g, Integer.valueOf(localazke.e));
      PicPreDownloaderCore.b(this.this$0).add(0, localazke);
      continue;
      j += 1;
      localazke.e = localazke.f;
      this.this$0.a.put(localazke.a.g, Integer.valueOf(localazke.e));
      PicPreDownloaderCore.c(this.this$0).add(0, localazke);
      continue;
      label310:
      PicPreDownloaderCore.a(this.this$0).clear();
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "clearAIORequests(): totalCount=" + this.a + " countOfC2C=" + i + " countOfDiscussion=" + j + " countOfGroup=" + k);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloaderCore.2
 * JD-Core Version:    0.7.0.1
 */