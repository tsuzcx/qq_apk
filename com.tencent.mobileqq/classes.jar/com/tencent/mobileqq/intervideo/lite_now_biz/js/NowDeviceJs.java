package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.content.Context;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.litepages.room.webmodule.js.AppJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.mobileqq.litelivesdk.utils.network.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NowDeviceJs
  extends AppJavascriptInterface
{
  private static final String CMD_NAME = "device";
  private static final String TAG = "NowDeviceJs";
  private CustomWebView customWebView;
  
  public NowDeviceJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
  }
  
  public String getName()
  {
    return "device";
  }
  
  @NewJavascriptInterface
  public void getNetworkType(Map<String, String> paramMap)
  {
    int i = NetworkUtil.a(BaseApplicationImpl.getContext());
    paramMap = (String)paramMap.get("callback");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", i);
      this.customWebView.callJs(paramMap, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("NowDeviceJs", 1, "getNetworkType error: " + localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowDeviceJs
 * JD-Core Version:    0.7.0.1
 */