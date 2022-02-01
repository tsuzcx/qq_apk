package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.liveroom.LiveRoomProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class LiveRoomBusinessPlugin
  extends WebViewPlugin
{
  public LiveRoomBusinessPlugin()
  {
    this.mPluginNameSpace = "gflivesdk";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("openView".equals(paramString3)) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("LiveRoomBusinessPlugin", 2, "openView");
        }
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramString2 = paramString1.optString("viewType");
        paramJsBridgeListener = paramString1.optString("callback");
        if ("activity".equals(paramString2))
        {
          paramString1 = paramString1.optString("url");
          paramString2 = this.mRuntime.a();
          if ((paramString2 != null) && (paramString1 != null) && (!paramString1.isEmpty()))
          {
            LiveRoomProxyActivity.open(paramString2, paramString1, "BusinessPlugin openView");
            callJs(paramJsBridgeListener, new String[] { "{\"result\":0}" });
          }
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LiveRoomBusinessPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
        }
      }
    }
    for (;;)
    {
      return false;
      if ("checkSDKInstalled".equals(paramString3))
      {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          if ((!LiveRoomHelper.getPluginInstalledInTool()) || (TextUtils.isEmpty(LiveRoomHelper.getPluginVersionInTool()))) {
            break;
          }
          callJs(paramJsBridgeListener, new String[] { "{\"result\":0,\"version\":\"" + LiveRoomHelper.getPluginVersionInTool() + "\"}" });
          return true;
        }
        catch (JSONException paramJsBridgeListener) {}
        if (QLog.isColorLevel()) {
          QLog.d("LiveRoomBusinessPlugin", 2, paramJsBridgeListener.getMessage(), paramJsBridgeListener);
        }
      }
    }
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), new LiveRoomBusinessPlugin.1(this, paramJsBridgeListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.LiveRoomBusinessPlugin
 * JD-Core Version:    0.7.0.1
 */