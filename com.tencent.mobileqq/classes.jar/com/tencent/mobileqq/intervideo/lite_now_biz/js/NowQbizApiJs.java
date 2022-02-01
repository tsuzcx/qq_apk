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

public class NowQbizApiJs
  extends AppJavascriptInterface
{
  private static final String CMD_NAME = "qbizApi";
  private static final String TAG = "NowQbizApiJs";
  private CustomWebView customWebView;
  
  public NowQbizApiJs(WebView paramWebView, Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramWebView, paramJsBizAdapter);
    if ((paramWebView instanceof CustomWebView)) {
      this.customWebView = ((CustomWebView)paramWebView);
    }
  }
  
  public String getName()
  {
    return "qbizApi";
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
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNetworkType error: ");
      localStringBuilder.append(localJSONException);
      QLog.e("NowQbizApiJs", 1, localStringBuilder.toString());
    }
    this.customWebView.callJs(paramMap, new String[] { localJSONObject.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQbizApiJs
 * JD-Core Version:    0.7.0.1
 */