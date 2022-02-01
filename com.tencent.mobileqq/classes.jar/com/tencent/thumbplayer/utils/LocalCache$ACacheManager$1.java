package com.tencent.thumbplayer.utils;

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class LocalCache$ACacheManager$1
  implements Runnable
{
  LocalCache$ACacheManager$1(LocalCache.ACacheManager paramACacheManager) {}
  
  public void run()
  {
    File[] arrayOfFile = this.this$0.cacheDir.listFiles();
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      int j = 0;
      int k = 0;
      int i = 0;
      while (j < m)
      {
        File localFile = arrayOfFile[j];
        k = (int)(k + LocalCache.ACacheManager.access$1600(this.this$0, localFile));
        i += 1;
        LocalCache.ACacheManager.access$1700(this.this$0).put(localFile, Long.valueOf(localFile.lastModified()));
        j += 1;
      }
      LocalCache.ACacheManager.access$1800(this.this$0).set(k);
      LocalCache.ACacheManager.access$1900(this.this$0).set(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.LocalCache.ACacheManager.1
 * JD-Core Version:    0.7.0.1
 */