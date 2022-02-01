package com.tencent.mobileqq.minigame.jsapi.manager;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;

class JsApiUpdateManager$2$1
  implements Runnable
{
  JsApiUpdateManager$2$1(JsApiUpdateManager.2 param2) {}
  
  public void run()
  {
    MiniAppFileManager.getInstance().deleteTmpFileNeed2DeleteAsync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager.2.1
 * JD-Core Version:    0.7.0.1
 */