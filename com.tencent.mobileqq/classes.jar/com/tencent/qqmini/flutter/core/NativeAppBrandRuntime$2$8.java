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
    paramMap = (Map)paramMap.get("data");
    String str = paramMap.get("event").toString();
    Integer localInteger = (Integer)paramMap.get("pageID");
    if (paramMap.containsKey("dataForEvent")) {
      paramReply = (Map)paramMap.get("dataForEvent");
    } else {
      paramReply = null;
    }
    paramMap = localInteger;
    if (localInteger == null)
    {
      paramMap = localInteger;
      if (paramReply != null)
      {
        paramMap = localInteger;
        if (paramReply.containsKey("pageID")) {
          paramMap = (Integer)paramReply.get("pageID");
        }
      }
    }
    if (paramReply != null) {
      paramReply = new JSONObject(paramReply).toString();
    } else {
      paramReply = "null";
    }
    NativeAppBrandRuntime.access$800(this.this$1.this$0).onWebViewEvent(str, paramReply, paramMap.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.8
 * JD-Core Version:    0.7.0.1
 */