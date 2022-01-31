package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$19
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$19(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public String run()
  {
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$path) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$path, this.val$callbackId);
    }
    Object localObject1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$path);
    Object localObject3 = new File((String)localObject1);
    if (!((File)localObject3).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$path, this.val$callbackId);
    }
    boolean bool = this.this$0.jsPluginEngine instanceof GameJsPluginEngine;
    Object localObject2;
    if ((this.val$recursive) && (((File)localObject3).isDirectory()))
    {
      try
      {
        localObject3 = FileUtils.getStatsByDir((String)localObject1);
        if (localObject3 == null) {
          break label393;
        }
        if ("statSync".equals(this.val$event)) {
          return ((JSONObject)localObject3).toString();
        }
        if (bool)
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("stats", localObject3);
            return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject1, this.val$callbackId);
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              GameLog.getInstance().e("[mini] FileJsPlugin", "stat error:", localJSONException1);
            }
          }
        }
        localObject2 = FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, localJSONException1, this.val$callbackId);
      }
      catch (Exception localException)
      {
        QLog.e("[mini] FileJsPlugin", 1, " API_STAT error : " + localException);
        return "";
      }
      return localObject2;
    }
    else
    {
      JSONObject localJSONObject = FileUtils.getStats((String)localObject2);
      if (localJSONObject != null)
      {
        if ("statSync".equals(this.val$event)) {
          return localJSONObject.toString();
        }
        if (bool)
        {
          localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("stats", localJSONObject);
            return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject2, this.val$callbackId);
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              GameLog.getInstance().e("[mini] FileJsPlugin", "stat error:", localJSONException2);
            }
          }
        }
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, localJSONException2, this.val$callbackId);
      }
    }
    label393:
    return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.19
 * JD-Core Version:    0.7.0.1
 */