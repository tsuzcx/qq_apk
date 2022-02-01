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
    label72:
    int j;
    try
    {
      File[] arrayOfFile = Reporter.access$000(this.this$0).listFiles();
      int k = arrayOfFile.length;
      int i = 0;
      File localFile;
      FileInputStream localFileInputStream;
      StringBuilder localStringBuilder;
      int m;
      if (i < k)
      {
        localFile = arrayOfFile[i];
        if ((localFile.exists()) && (localFile.isFile()))
        {
          localFileInputStream = new FileInputStream(localFile);
          arrayOfByte = new byte[1024];
          localStringBuilder = new StringBuilder();
          m = localFileInputStream.read(arrayOfByte);
          if (m != -1) {
            j = 0;
          }
        }
      }
      while (j >= m)
      {
        localStringBuilder.append(new String(arrayOfByte, 0, m));
        break label72;
        localFileInputStream.close();
        localFile.delete();
        Reporter.access$100(this.this$0, localStringBuilder.toString());
        i += 1;
        break;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Reporter.access$200(this.this$0);
      return;
    }
    for (;;)
    {
      arrayOfByte[j] = ((byte)(arrayOfByte[j] ^ 0xFFFFFFE9));
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.reporter.Reporter.1
 * JD-Core Version:    0.7.0.1
 */