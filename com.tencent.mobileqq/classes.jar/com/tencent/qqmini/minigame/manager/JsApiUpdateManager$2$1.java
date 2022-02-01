package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;

class JsApiUpdateManager$2$1
  implements Runnable
{
  JsApiUpdateManager$2$1(JsApiUpdateManager.2 param2) {}
  
  public void run()
  {
    if (this.this$0.val$fileManager != null) {
      this.this$0.val$fileManager.deleteTmpFileNeed2DeleteAsync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager.2.1
 * JD-Core Version:    0.7.0.1
 */