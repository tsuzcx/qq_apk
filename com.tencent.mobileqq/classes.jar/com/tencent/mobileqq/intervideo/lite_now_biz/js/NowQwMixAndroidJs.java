package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.config.AppSetting;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NowQwMixAndroidJs
  extends AppJavascriptInterface
{
  private static final String CMD_NAME = "qw_mix_android";
  private static final String TAG = "NowQwMixAndroidJs";
  private CustomWebView customWebView;
  
  public NowQwMixAndroidJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
  }
  
  public String getName()
  {
    return "qw_mix_android";
  }
  
  @NewJavascriptInterface
  public void get_now_version(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("callback");
    String str = AppSetting.h();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("msg", str);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get_now_version error: ");
      localStringBuilder.append(localJSONException);
      QLog.e("NowQwMixAndroidJs", 1, localStringBuilder.toString());
    }
    this.customWebView.callJs(paramMap, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQwMixAndroidJs
 * JD-Core Version:    0.7.0.1
 */