package com.tencent.mobileqq.utils;

import bahm;
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
            localbahm2 = (bahm)RandomAccessFileManager.a(this.this$0).get(arrayOfString[j]);
            bahm localbahm1;
            for (??? = localbahm2.jdField_b_of_type_Bahm;; localObject3 = localbahm1)
            {
              localbahm1 = ((bahm)???).jdField_b_of_type_Bahm;
              if (((bahm)???).jdField_a_of_type_Int != 0) {
                break;
              }
              long l1 = System.currentTimeMillis();
              long l2 = ((bahm)???).jdField_b_of_type_Long;
              if (l1 - l2 <= 1000L) {
                break;
              }
              try
              {
                ((bahm)???).jdField_a_of_type_JavaIoRandomAccessFile.close();
                if (QLog.isColorLevel()) {
                  QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((bahm)???).jdField_a_of_type_Long + "]" + " close by Thread:" + Thread.currentThread().getId());
                }
                RandomAccessFileManager.a(this.this$0, localbahm2, (bahm)???, arrayOfString[j], RandomAccessFileManager.a(this.this$0));
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
        bahm localbahm2;
        continue;
        int j = 0;
        continue;
        if (localbahm2 == localInterruptedException) {
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