package com.tencent.mobileqq.hotpic;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class DiskStorageManager$TouchCallable
  implements Runnable
{
  private final File a;
  
  public DiskStorageManager$TouchCallable(DiskStorageManager paramDiskStorageManager, File paramFile)
  {
    this.a = paramFile;
  }
  
  public void run()
  {
    try
    {
      DiskStorageManager.a(this.this$0, this.a);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      QLog.d("DiskStorageManager", 2, "IO exception run error in background", localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.DiskStorageManager.TouchCallable
 * JD-Core Version:    0.7.0.1
 */