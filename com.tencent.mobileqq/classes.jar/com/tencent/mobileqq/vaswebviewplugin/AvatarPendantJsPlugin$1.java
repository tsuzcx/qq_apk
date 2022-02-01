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
      if (this.this$0.browserApp != null)
      {
        localObject = this.this$0.browserApp.getEntityManagerFactory(null).createEntityManager();
        ExtensionInfo localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).find(ExtensionInfo.class, this.this$0.browserApp.getAccount());
        ((EntityManager)localObject).close();
        localJSONObject.put("result", 0);
        if (localExtensionInfo == null) {
          localJSONObject.put("id", 0L);
        } else {
          localJSONObject.put("id", localExtensionInfo.pendantId);
        }
        if (this.this$0.mRuntime != null)
        {
          localObject = this.this$0.mRuntime.d();
          if (localObject != null)
          {
            ((Activity)localObject).runOnUiThread(new AvatarPendantJsPlugin.1.1(this, localJSONObject));
            return;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFaceAddon failed: ");
        ((StringBuilder)localObject).append(localJSONException.getMessage());
        QLog.e("AvatarPendantJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
      String str = localJSONException.getMessage();
      if (this.this$0.mRuntime != null)
      {
        localObject = this.this$0.mRuntime.d();
        if (localObject != null) {
          ((Activity)localObject).runOnUiThread(new AvatarPendantJsPlugin.1.2(this, str));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */