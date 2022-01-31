package com.tencent.mobileqq.utils;

import bbir;
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
          if (!RandomAccessFileManager.a(this.this$0).isEmpty()) {}
        }
        Object localObject3;
        synchronized (RandomAccessFileManager.b(this.this$0))
        {
          RandomAccessFileManager.a(this.this$0, null);
          return;
          String[] arrayOfString = new String[RandomAccessFileManager.a(this.this$0).size()];
          ??? = RandomAccessFileManager.a(this.this$0).keySet().iterator();
          int i = 0;
          while (((Iterator)???).hasNext())
          {
            arrayOfString[i] = ((String)((Iterator)???).next());
            i += 1;
          }
          if (j < i)
          {
            localbbir2 = (bbir)RandomAccessFileManager.a(this.this$0).get(arrayOfString[j]);
            bbir localbbir1;
            for (??? = localbbir2.jdField_b_of_type_Bbir;; localObject3 = localbbir1)
            {
              localbbir1 = ((bbir)???).jdField_b_of_type_Bbir;
              if (((bbir)???).jdField_a_of_type_Int != 0) {
                break;
              }
              long l1 = System.currentTimeMillis();
              long l2 = ((bbir)???).jdField_b_of_type_Long;
              if (l1 - l2 <= 1000L) {
                break;
              }
              try
              {
                ((bbir)???).jdField_a_of_type_JavaIoRandomAccessFile.close();
                if (QLog.isColorLevel()) {
                  QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((bbir)???).jdField_a_of_type_Long + "]" + " close by Thread:" + Thread.currentThread().getId());
                }
                RandomAccessFileManager.a(this.this$0, localbbir2, (bbir)???, arrayOfString[j], RandomAccessFileManager.a(this.this$0));
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  localIOException.printStackTrace();
                }
              }
              localObject2 = finally;
              throw localObject2;
            }
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        bbir localbbir2;
        continue;
        int j = 0;
        continue;
        if (localbbir2 == localInterruptedException) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager.CloseThread
 * JD-Core Version:    0.7.0.1
 */