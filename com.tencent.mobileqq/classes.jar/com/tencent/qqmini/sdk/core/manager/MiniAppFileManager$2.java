package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.FileUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class MiniAppFileManager$2
  implements Runnable
{
  MiniAppFileManager$2(MiniAppFileManager paramMiniAppFileManager) {}
  
  public void run()
  {
    String str = MiniAppFileManager.access$000(this.this$0, 2);
    try
    {
      MiniAppFileManager.access$100(this.this$0).set(FileUtils.getFileOrFolderSize(str));
      label23:
      MiniAppFileManager.access$200(this.this$0).countDown();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.2
 * JD-Core Version:    0.7.0.1
 */