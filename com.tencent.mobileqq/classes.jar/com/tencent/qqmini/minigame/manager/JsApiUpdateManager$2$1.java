package com.tencent.qqmini.minigame.manager;

import com.tencent.qqmini.minigame.GameJsPluginEngine;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

class JsApiUpdateManager$2$1
  implements Runnable
{
  JsApiUpdateManager$2$1(JsApiUpdateManager.2 param2) {}
  
  public void run()
  {
    if ((this.this$0.val$gameJsPluginEngine != null) && (this.this$0.val$gameJsPluginEngine.getRuntime() != null)) {
      ((MiniAppFileManager)this.this$0.val$gameJsPluginEngine.getRuntime().getManager(MiniAppFileManager.class)).deleteTmpFileNeed2DeleteAsync();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager.2.1
 * JD-Core Version:    0.7.0.1
 */