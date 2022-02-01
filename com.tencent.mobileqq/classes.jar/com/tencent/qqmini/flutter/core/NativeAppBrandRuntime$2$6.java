package com.tencent.qqmini.flutter.core;

import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqmini.miniapp.util.URL;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;

class NativeAppBrandRuntime$2$6
  implements NativeAppBrandRuntime.TissueEventHandler
{
  NativeAppBrandRuntime$2$6(NativeAppBrandRuntime.2 param2) {}
  
  public void on(Map paramMap, BasicMessageChannel.Reply paramReply)
  {
    paramMap = (Map)paramMap.get("data");
    String str2 = paramMap.get("path").toString();
    paramReply = (Integer)paramMap.get("pageID");
    String str1 = (String)paramMap.get("openType");
    if (paramMap.containsKey("query")) {}
    for (paramMap = (Map)paramMap.get("query");; paramMap = null)
    {
      paramMap = new URL(str2, paramMap);
      NativeAppBrandRuntime.access$600(this.this$1.this$0).onAppRouteDone(str1, paramMap.getFullUrl(), paramReply.intValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.2.6
 * JD-Core Version:    0.7.0.1
 */