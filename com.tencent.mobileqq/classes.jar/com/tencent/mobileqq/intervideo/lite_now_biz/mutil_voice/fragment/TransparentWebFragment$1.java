package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.fragment;

import android.content.Context;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import java.util.Map;

class TransparentWebFragment$1
  extends BaseLiteJSModule
{
  TransparentWebFragment$1(TransparentWebFragment paramTransparentWebFragment, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  @NewJavascriptInterface
  public void closeTransparentWebview(Map<String, String> paramMap)
  {
    this.a.dismissAllowingStateLoss();
  }
  
  public String getName()
  {
    return "ui";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.fragment.TransparentWebFragment.1
 * JD-Core Version:    0.7.0.1
 */