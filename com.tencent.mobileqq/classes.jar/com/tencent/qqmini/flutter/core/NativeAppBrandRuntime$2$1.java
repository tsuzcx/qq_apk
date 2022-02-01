package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;

class NativeAppBrandRuntime$2$1
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$1(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    paramMap = (String)((Map)paramMap.get("data")).get("filePath");
    paramReply.reply(((MiniAppFileManager)this.this$1.this$0.getManager(MiniAppFileManager.class)).getAbsolutePath(paramMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.1
 * JD-Core Version:    0.7.0.1
 */