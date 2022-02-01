package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.FileUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

class MiniAppFileManager$3
  implements Runnable
{
  MiniAppFileManager$3(MiniAppFileManager paramMiniAppFileManager) {}
  
  public void run()
  {
    String str = MiniAppFileManager.access$000(this.this$0, 1);
    try
    {
      MiniAppFileManager.access$300(this.this$0).set(FileUtils.getFileOrFolderSize(str));
      label23:
      MiniAppFileManager.access$400(this.this$0).countDown();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.3
 * JD-Core Version:    0.7.0.1
 */