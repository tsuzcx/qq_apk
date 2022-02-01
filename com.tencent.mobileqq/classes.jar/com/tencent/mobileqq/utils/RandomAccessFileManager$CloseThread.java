package com.tencent.mobileqq.utils;

import bhro;
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
            localbhro2 = (bhro)RandomAccessFileManager.a(this.this$0).get(arrayOfString[j]);
            bhro localbhro1;
            for (??? = localbhro2.jdField_b_of_type_Bhro;; localObject3 = localbhro1)
            {
              localbhro1 = ((bhro)???).jdField_b_of_type_Bhro;
              if (((bhro)???).jdField_a_of_type_Int != 0) {
                break;
              }
              long l1 = System.currentTimeMillis();
              long l2 = ((bhro)???).jdField_b_of_type_Long;
              if (l1 - l2 <= 1000L) {
                break;
              }
              try
              {
                ((bhro)???).jdField_a_of_type_JavaIoRandomAccessFile.close();
                if (QLog.isColorLevel()) {
                  QLog.d("AppleMojiHandler", 2, "file " + arrayOfString[j] + "[" + ((bhro)???).jdField_a_of_type_Long + "]" + " close by Thread:" + Thread.currentThread().getId());
                }
                RandomAccessFileManager.a(this.this$0, localbhro2, (bhro)???, arrayOfString[j], RandomAccessFileManager.a(this.this$0));
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
        bhro localbhro2;
        continue;
        int j = 0;
        continue;
        if (localbhro2 == localInterruptedException) {
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RandomAccessFileManager.CloseThread
 * JD-Core Version:    0.7.0.1
 */