package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;

class ColorRingJsPlugin$1
  implements Runnable
{
  ColorRingJsPlugin$1(ColorRingJsPlugin paramColorRingJsPlugin, String paramString1, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject;
      ExtensionInfo localExtensionInfo;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.this$0.mBrowserApp != null)
        {
          localObject = this.this$0.mBrowserApp.getEntityManagerFactory(null).createEntityManager();
          localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).find(ExtensionInfo.class, this.this$0.mBrowserApp.getAccount());
          ((EntityManager)localObject).close();
          localJSONObject.put("result", 0);
          localObject = new JSONObject();
          if (localExtensionInfo == null)
          {
            ((JSONObject)localObject).put("currentId", 0);
            localJSONObject.put("data", localObject);
          }
        }
        else
        {
          this.this$0.mActivity.runOnUiThread(new ColorRingJsPlugin.1.1(this, localJSONObject));
          return;
        }
        if (this.val$type.equals("colorring"))
        {
          ((JSONObject)localObject).put("currentId", localExtensionInfo.colorRingId);
          continue;
        }
        String str;
        if (!this.val$type.equals("comering")) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        str = localJSONException.getMessage();
        this.this$0.mActivity.runOnUiThread(new ColorRingJsPlugin.1.2(this, str));
        return;
      }
      ((JSONObject)localObject).put("currentId", localExtensionInfo.commingRingId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */