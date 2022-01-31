package org.libpag.reporter;

import java.io.File;
import java.io.FileInputStream;

class Reporter$1
  implements Runnable
{
  Reporter$1(Reporter paramReporter) {}
  
  public void run()
  {
    byte[] arrayOfByte;
    int m;
    int j;
    for (;;)
    {
      int i;
      File localFile;
      FileInputStream localFileInputStream;
      StringBuilder localStringBuilder;
      try
      {
        File[] arrayOfFile = Reporter.access$000(this.this$0).listFiles();
        int k = arrayOfFile.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        localFile = arrayOfFile[i];
        if ((!localFile.exists()) || (!localFile.isFile())) {
          break label151;
        }
        localFileInputStream = new FileInputStream(localFile);
        arrayOfByte = new byte[1024];
        localStringBuilder = new StringBuilder();
        m = localFileInputStream.read(arrayOfByte);
        if (m == -1) {
          break label128;
        }
        j = 0;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        Reporter.access$200(this.this$0);
        return;
      }
      localStringBuilder.append(new String(arrayOfByte, 0, m));
      continue;
      label128:
      localFileInputStream.close();
      localFile.delete();
      Reporter.access$100(this.this$0, localStringBuilder.toString());
      label151:
      i += 1;
    }
    while (j < m)
    {
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ 0xFFFFFFE9));
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.libpag.reporter.Reporter.1
 * JD-Core Version:    0.7.0.1
 */