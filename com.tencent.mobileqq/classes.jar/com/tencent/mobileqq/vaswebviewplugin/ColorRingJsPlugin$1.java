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
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (this.this$0.mBrowserApp != null)
      {
        Object localObject = this.this$0.mBrowserApp.getEntityManagerFactory(null).createEntityManager();
        ExtensionInfo localExtensionInfo = (ExtensionInfo)((EntityManager)localObject).find(ExtensionInfo.class, this.this$0.mBrowserApp.getAccount());
        ((EntityManager)localObject).close();
        localJSONObject.put("result", 0);
        localObject = new JSONObject();
        if (localExtensionInfo == null) {
          ((JSONObject)localObject).put("currentId", 0);
        } else if (this.val$type.equals("colorring")) {
          ((JSONObject)localObject).put("currentId", localExtensionInfo.colorRingId);
        } else if (this.val$type.equals("comering")) {
          ((JSONObject)localObject).put("currentId", localExtensionInfo.commingRingId);
        }
        localJSONObject.put("data", localObject);
      }
      this.this$0.mActivity.runOnUiThread(new ColorRingJsPlugin.1.1(this, localJSONObject));
      return;
    }
    catch (JSONException localJSONException)
    {
      String str = localJSONException.getMessage();
      this.this$0.mActivity.runOnUiThread(new ColorRingJsPlugin.1.2(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */