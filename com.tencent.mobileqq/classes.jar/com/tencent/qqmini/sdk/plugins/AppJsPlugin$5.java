package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class AppJsPlugin$5
  implements AsyncResult
{
  AppJsPlugin$5(AppJsPlugin paramAppJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = paramJSONObject.optString("packageName");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.val$req.fail("server error,packageName = null");
        QMLog.w("AppJsPlugin", "check failed, server error");
        return;
      }
      Iterator localIterator = AppJsPlugin.access$200(this.this$0).getContext().getPackageManager().getInstalledPackages(0).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        paramJSONObject = (PackageInfo)localIterator.next();
      } while ((paramJSONObject.packageName == null) || (!paramJSONObject.packageName.equals(localObject)));
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        if (paramJSONObject != null)
        {
          ((JSONObject)localObject).put("installed", 1);
          this.val$req.ok((JSONObject)localObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        this.val$req.fail("isMicroAppInstalled exception");
        QMLog.w("AppJsPlugin", "isMicroAppInstalled exception:", paramJSONObject);
        return;
      }
      ((JSONObject)localObject).put("installed", 0);
      continue;
      this.val$req.fail("check failed, server error");
      QMLog.w("AppJsPlugin", "check failed, server error");
      return;
      paramJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */