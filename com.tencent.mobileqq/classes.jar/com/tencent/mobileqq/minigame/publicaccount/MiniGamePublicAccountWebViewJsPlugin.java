package com.tencent.mobileqq.minigame.publicaccount;

import com.tencent.mobileqq.mini.api.MiniConst.MiniGamePublicAccountWebViewJsPluginConst;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGamePublicAccountWebViewJsPlugin
  extends WebViewPlugin
{
  public static String PLUGIN_NAMESPACE = MiniConst.MiniGamePublicAccountWebViewJsPluginConst.PLUGIN_NAMESPACE;
  private static final String TAG = "MiniGamePublicAccountWebViewJsPlugin";
  
  public MiniGamePublicAccountWebViewJsPlugin()
  {
    this.mPluginNameSpace = PLUGIN_NAMESPACE;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934624L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934624L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      try
      {
        if (paramMap.containsKey("height")) {
          paramString.put("height", paramMap.get("height"));
        }
        dispatchJsEvent("gameFeedsEvent", paramString, null);
        return true;
      }
      catch (ClassCastException paramMap)
      {
        for (;;)
        {
          QLog.e("MiniGamePublicAccountWebViewJsPlugin", 1, "handleEvent error", paramMap);
        }
      }
      catch (JSONException paramMap)
      {
        for (;;)
        {
          QLog.e("MiniGamePublicAccountWebViewJsPlugin", 1, "handleEvent error", paramMap);
        }
      }
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((PLUGIN_NAMESPACE.equals(paramString2)) && (QLog.isColorLevel())) {
      QLog.d("MiniGamePublicAccountWebViewJsPlugin", 1, "pkgName:" + paramString2 + " method:" + paramString3);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */