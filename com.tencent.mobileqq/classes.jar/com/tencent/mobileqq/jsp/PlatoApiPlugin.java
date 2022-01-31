package com.tencent.mobileqq.jsp;

import android.content.Intent;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.plato.PlatoAppManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class PlatoApiPlugin
  extends WebViewPlugin
{
  private static String a = "PlatoApiPlugin";
  
  public PlatoApiPlugin()
  {
    this.mPluginNameSpace = "plato";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"plato".equals(paramString2)) {
      return false;
    }
    Intent localIntent;
    if (paramString3.equals("openApp")) {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramVarArgs[0]);
        String str1 = localJSONObject.optString("bid");
        Object localObject = "https:" + localJSONObject.optString("backupUrl");
        localJSONObject = localJSONObject.optJSONObject("options");
        localIntent = new Intent();
        localIntent.putExtra("bid", str1);
        localIntent.putExtra("backupUrl", (String)localObject);
        localObject = localJSONObject.keys();
        while ((localObject != null) && (((Iterator)localObject).hasNext()))
        {
          String str2 = (String)((Iterator)localObject).next();
          localIntent.putExtra(str2, localJSONObject.getString(str2));
          continue;
          return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, localJSONException.getMessage());
        }
      }
    }
    for (;;)
    {
      PlatoAppManager.a(this.mRuntime.a(), localJSONException, localIntent);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.PlatoApiPlugin
 * JD-Core Version:    0.7.0.1
 */