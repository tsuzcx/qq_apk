package com.tencent.mtt.hippy.bridge;

import android.text.TextUtils;
import java.io.File;

public class HippyBridgeImpl$b
  implements Runnable
{
  private String b;
  private long c;
  
  public HippyBridgeImpl$b(HippyBridgeImpl paramHippyBridgeImpl, String paramString, long paramLong)
  {
    this.b = paramString;
    this.c = paramLong;
  }
  
  public void a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isFile()) {
          localFile.delete();
        }
        for (;;)
        {
          i += 1;
          break;
          if (localFile.isDirectory()) {
            a(localFile);
          }
        }
      }
    }
    paramFile.delete();
  }
  
  public void run()
  {
    try
    {
      if (TextUtils.isEmpty(this.b)) {
        return;
      }
      File localFile = new File(this.b.substring(0, this.b.lastIndexOf(File.separator)));
      a(localFile);
      localFile.mkdirs();
      new File(this.b).createNewFile();
      this.a.runNativeRunnable(this.b, this.c, HippyBridgeImpl.access$100(this.a), null);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl.b
 * JD-Core Version:    0.7.0.1
 */