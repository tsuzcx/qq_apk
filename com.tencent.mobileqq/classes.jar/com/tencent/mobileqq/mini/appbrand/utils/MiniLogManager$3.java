package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;

final class MiniLogManager$3
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new File(MiniLog.getMiniLogFolderPath());
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        if (localObject != null)
        {
          if (localObject.length == 0) {
            return;
          }
          int m = localObject.length;
          int i = 0;
          while (i < m)
          {
            File[] arrayOfFile1 = localObject[i].listFiles();
            if ((arrayOfFile1 != null) && (arrayOfFile1.length != 0))
            {
              int n = arrayOfFile1.length;
              int j = 0;
              while (j < n)
              {
                File[] arrayOfFile2 = arrayOfFile1[j].listFiles();
                if ((arrayOfFile2 != null) && (arrayOfFile2.length != 0))
                {
                  Arrays.sort(arrayOfFile2, MiniLogManager.access$300());
                  long l = MiniLogManager.access$400();
                  String str1 = MiniLogManager.access$500();
                  int i1 = arrayOfFile2.length;
                  int k = 0;
                  while (k < i1)
                  {
                    File localFile = arrayOfFile2[k];
                    if (!localFile.getName().contains("log"))
                    {
                      String str2;
                      StringBuilder localStringBuilder;
                      if ((l <= localFile.lastModified()) && (localFile.lastModified() <= System.currentTimeMillis() + 3600000L))
                      {
                        if ((localFile.getName().endsWith(".log")) && ((localFile.lastModified() < System.currentTimeMillis() - 3600000L) || (localFile.getName().contains(str1))) && (MiniLogManager.access$600(localFile)))
                        {
                          localFile.delete();
                          if (QLog.isColorLevel())
                          {
                            str2 = MiniLogManager.access$100();
                            localStringBuilder = new StringBuilder();
                            localStringBuilder.append("compress log success ");
                            localStringBuilder.append(localFile.getName());
                            QLog.d(str2, 2, localStringBuilder.toString());
                          }
                        }
                      }
                      else
                      {
                        localFile.delete();
                        if (QLog.isColorLevel())
                        {
                          str2 = MiniLogManager.access$100();
                          localStringBuilder = new StringBuilder();
                          localStringBuilder.append("del expires log ");
                          localStringBuilder.append(localFile.getName());
                          QLog.d(str2, 2, localStringBuilder.toString());
                        }
                      }
                    }
                    k += 1;
                  }
                }
                j += 1;
              }
            }
            i += 1;
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MiniLogManager.access$100(), 2, localException, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.3
 * JD-Core Version:    0.7.0.1
 */