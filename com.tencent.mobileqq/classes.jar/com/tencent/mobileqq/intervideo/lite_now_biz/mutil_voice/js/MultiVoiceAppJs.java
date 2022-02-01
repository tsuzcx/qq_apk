package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.js;

import android.content.Context;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.js.NowAppJs;
import com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.event.MultiVoicePageEvent;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public class MultiVoiceAppJs
  extends NowAppJs
{
  public MultiVoiceAppJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramWebView, paramContext, paramJsBizAdapter);
  }
  
  @NewJavascriptInterface
  public void enableFloatingWindow(Map<String, String> paramMap)
  {
    getJsBizAdapter().getModuleEvent().post(new MultiVoicePageEvent(1));
  }
  
  @NewJavascriptInterface
  public void pageReady(Map<String, String> paramMap)
  {
    getJsBizAdapter().getModuleEvent().post(new MultiVoicePageEvent(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.js.MultiVoiceAppJs
 * JD-Core Version:    0.7.0.1
 */