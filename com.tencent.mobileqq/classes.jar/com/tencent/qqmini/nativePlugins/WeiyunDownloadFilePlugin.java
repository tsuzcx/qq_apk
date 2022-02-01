package com.tencent.qqmini.nativePlugins;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class WeiyunDownloadFilePlugin
  extends BaseJsPlugin
{
  private WeiyunNativeBusiness.WeiyunDownloadBussiness a;
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      localObject = new JSONObject(paramRequestEvent.jsonParams);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      label14:
      break label14;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Failed to parse jsonParams=");
    ((StringBuilder)localObject).append(paramRequestEvent.jsonParams);
    QLog.e("[mini] WeiyunDownloadFilePlugin", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  @JsEvent({"weiyunDownload"})
  public void weiyunDownload(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = a(paramRequestEvent);
      if (localObject != null)
      {
        JSONObject localJSONObject = new JSONObject(((JSONObject)localObject).optString("data"));
        localObject = localJSONObject.getString("action");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          boolean bool = ((String)localObject).equals("createDownloadTask");
          if ((bool) || (((String)localObject).equals("pauseDownloadTask")) || (((String)localObject).equals("cancelDownloadTask")))
          {
            QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "create weiyun Download");
            if (this.a == null) {
              this.a = new WeiyunNativeBusiness.WeiyunDownloadBussiness(this.mMiniAppContext);
            }
            localJSONObject = new JSONObject(localJSONObject.getString("data"));
            bool = ((String)localObject).equals("createDownloadTask");
            if (bool)
            {
              if (this.a.a(localJSONObject))
              {
                this.a.a(localJSONObject, localJSONObject.getString("file_id"), paramRequestEvent);
                paramRequestEvent.ok();
                return;
              }
              paramRequestEvent.fail("download params illegal.");
              return;
            }
            if (((String)localObject).equals("pauseDownloadTask"))
            {
              QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "pause weiyun Download");
              this.a.a(localJSONObject.getString("file_id"), paramRequestEvent);
              return;
            }
            if (((String)localObject).equals("cancelDownloadTask"))
            {
              QLog.d("[mini] WeiyunDownloadFilePlugin", 2, "cacel weiyun Download");
              this.a.b(localJSONObject.getString("file_id"), paramRequestEvent);
              return;
            }
          }
        }
      }
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.WeiyunDownloadFilePlugin
 * JD-Core Version:    0.7.0.1
 */