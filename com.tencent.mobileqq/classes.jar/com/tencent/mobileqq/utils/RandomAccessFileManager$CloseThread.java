package com.tencent.mobileqq.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class RandomAccessFileManager$CloseThread
  implements Runnable
{
  RandomAccessFileManager$CloseThread(RandomAccessFileManager paramRandomAccessFileManager) {}
  
  public void run()
  {
    try
    {
      for (;;)
      {
        Thread.sleep(1000L);
        synchronized (RandomAccessFileManager.a(this.this$0))
        {
          if (RandomAccessFileManager.b(this.this$0).isEmpty()) {
            synchronized (RandomAccessFileManager.c(this.this$0))
            {
              RandomAccessFileManager.a(this.this$0, null);
              return;
            }
          }
          String[] arrayOfString = new String[RandomAccessFileManager.b(this.this$0).size()];
          ??? = RandomAccessFileManager.b(this.this$0).keySet().iterator();
          int i = 0;
          while (((Iterator)???).hasNext())
          {
            arrayOfString[i] = ((String)((Iterator)???).next());
            i += 1;
          }
          if (j < i)
          {
            localFileEntry2 = (RandomAccessFileManager.FileEntry)RandomAccessFileManager.b(this.this$0).get(arrayOfString[j]);
            ??? = localFileEntry2.e;
            localFileEntry1 = ((RandomAccessFileManager.FileEntry)???).e;
            if (((RandomAccessFileManager.FileEntry)???).b != 0) {
              break label349;
            }
            long l1 = System.currentTimeMillis();
            long l2 = ((RandomAccessFileManager.FileEntry)???).f;
            if (l1 - l2 <= 1000L) {
              break label349;
            }
            try
            {
              ((RandomAccessFileManager.FileEntry)???).a.close();
              if (QLog.isColorLevel()) {
                QLog.d("AppleMojiHandler", 2, new Object[] { "file ", arrayOfString[j], "[", Long.valueOf(((RandomAccessFileManager.FileEntry)???).c), "]", " close by Thread:", Long.valueOf(Thread.currentThread().getId()) });
              }
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
            RandomAccessFileManager.a(this.this$0, localFileEntry2, (RandomAccessFileManager.FileEntry)???, arrayOfString[j], RandomAccessFileManager.b(this.this$0));
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        RandomAccessFileManager.FileEntry localFileEntry2;
        RandomAccessFileManager.FileEntry localFileEntry1;
        continue;
        int j = 0;
        continue;
        label349:
        if (localFileEntry2 == localInterruptedException) {
          j += 1;
        } else {
          Object localObject3 = localFileEntry1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager.CloseThread
 * JD-Core Version:    0.7.0.1
 */