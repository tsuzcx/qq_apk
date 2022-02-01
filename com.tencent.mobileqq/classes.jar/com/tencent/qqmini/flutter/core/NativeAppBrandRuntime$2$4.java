package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.miniapp.core.EventListener;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;
import org.json.JSONObject;

class NativeAppBrandRuntime$2$4
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$4(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    paramReply = (Map)paramMap.get("data");
    paramMap = (String)paramReply.get("event");
    if ("invokeMiniProgramAPI".equals(paramMap))
    {
      int i = ((Integer)paramReply.get("pageID")).intValue();
      NativeAppBrandRuntime.access$300(this.this$1.this$0).onWebViewEvent("onWebInvokeAppService", (String)paramReply.get("param"), i);
    }
    paramReply = new JSONObject(paramReply).toString();
    NativeAppBrandRuntime.access$400(this.this$1.this$0).onWebViewNativeRequest(paramMap, paramReply, this.this$1.this$0.getJsService(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.4
 * JD-Core Version:    0.7.0.1
 */