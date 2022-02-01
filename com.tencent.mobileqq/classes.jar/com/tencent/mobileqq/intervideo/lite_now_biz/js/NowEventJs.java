package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class NowEventJs
  extends AppJavascriptInterface
{
  private static final String CMD_NAME = "event";
  private static final String TAG = "NowEventJs";
  private Map<String, String> callbackMap;
  private CustomWebView customWebView;
  
  public NowEventJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter, Map<String, String> paramMap)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
    this.callbackMap = paramMap;
  }
  
  @NewJavascriptInterface
  public void addEventListener(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    paramMap = (String)paramMap.get("callback");
    this.callbackMap.put(str, paramMap);
  }
  
  public String getName()
  {
    return "event";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowEventJs
 * JD-Core Version:    0.7.0.1
 */