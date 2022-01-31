package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MixSearchApiPlugin
  extends WebViewPlugin
{
  public static final String a = MixSearchApiPlugin.class.getSimpleName();
  
  public MixSearchApiPlugin()
  {
    this.mPluginNameSpace = "MixSearchWeb";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {
      return false;
    }
    if (!"MixSearchWeb".equals(paramString2)) {
      return false;
    }
    if (("setSearchBarWord".equals(paramString3)) && ((this.mRuntime.a() instanceof MixSearchWebFragment))) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        ((MixSearchWebFragment)this.mRuntime.a()).a(paramJsBridgeListener.optString("searchWord"), paramJsBridgeListener.optString("placeholder"));
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.e(a, 1, "handleJsRequest: e = " + paramJsBridgeListener);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MixSearchApiPlugin
 * JD-Core Version:    0.7.0.1
 */