package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class AvatarPendantJsPlugin$1
  implements Runnable
{
  AvatarPendantJsPlugin$1(AvatarPendantJsPlugin paramAvatarPendantJsPlugin, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject;
      if (this.this$0.browserApp != null)
      {
        localObject = this.this$0.browserApp.getEntityManagerFactory(null).createEntityManager();
        ExtensionInfo localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).a(ExtensionInfo.class, this.this$0.browserApp.getAccount());
        ((EntityManager)localObject).a();
        localJSONObject.put("result", 0);
        if (localExtensionInfo == null) {
          localJSONObject.put("id", 0L);
        }
        while (this.this$0.mRuntime != null)
        {
          localObject = this.this$0.mRuntime.a();
          if (localObject == null) {
            break;
          }
          ((Activity)localObject).runOnUiThread(new AvatarPendantJsPlugin.1.1(this, localJSONObject));
          return;
          localJSONObject.put("id", localExtensionInfo.pendantId);
        }
      }
      String str;
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvatarPendantJsPlugin", 2, "getFaceAddon failed: " + localJSONException.getMessage());
      }
      str = localJSONException.getMessage();
      if (this.this$0.mRuntime != null)
      {
        localObject = this.this$0.mRuntime.a();
        if (localObject != null) {
          ((Activity)localObject).runOnUiThread(new AvatarPendantJsPlugin.1.2(this, str));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */