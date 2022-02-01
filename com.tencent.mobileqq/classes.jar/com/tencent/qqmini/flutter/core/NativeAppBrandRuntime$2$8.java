package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.miniapp.core.EventListener;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;
import org.json.JSONObject;

class NativeAppBrandRuntime$2$8
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$8(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    paramReply = (Map)paramMap.get("data");
    String str = paramReply.get("event").toString();
    Object localObject = (Integer)paramReply.get("pageID");
    paramMap = null;
    if (paramReply.containsKey("dataForEvent")) {
      paramMap = (Map)paramReply.get("dataForEvent");
    }
    paramReply = (BasicMessageChannel.Reply)localObject;
    if (localObject == null)
    {
      paramReply = (BasicMessageChannel.Reply)localObject;
      if (paramMap != null)
      {
        paramReply = (BasicMessageChannel.Reply)localObject;
        if (paramMap.containsKey("pageID")) {
          paramReply = (Integer)paramMap.get("pageID");
        }
      }
    }
    localObject = "null";
    if (paramMap != null) {
      localObject = new JSONObject(paramMap).toString();
    }
    NativeAppBrandRuntime.access$700(this.this$1.this$0).onWebViewEvent(str, (String)localObject, paramReply.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.8
 * JD-Core Version:    0.7.0.1
 */