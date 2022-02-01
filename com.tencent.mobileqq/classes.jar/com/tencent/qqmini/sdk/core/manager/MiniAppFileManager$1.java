package com.tencent.qqmini.sdk.core.manager;

import com.tencent.qqmini.sdk.core.utils.FileUtils;

class MiniAppFileManager$1
  implements Runnable
{
  MiniAppFileManager$1(MiniAppFileManager paramMiniAppFileManager) {}
  
  public void run()
  {
    FileUtils.delete(MiniAppFileManager.access$000(this.this$0, 0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.MiniAppFileManager.1
 * JD-Core Version:    0.7.0.1
 */