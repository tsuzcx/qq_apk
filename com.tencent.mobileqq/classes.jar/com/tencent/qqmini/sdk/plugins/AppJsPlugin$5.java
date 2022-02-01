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
    if (paramBoolean)
    {
      String str = paramJSONObject.optString("packageName");
      if (TextUtils.isEmpty(str))
      {
        this.val$req.fail("server error,packageName = null");
        QMLog.w("AppJsPlugin", "check failed, server error");
        return;
      }
      paramJSONObject = AppJsPlugin.access$200(this.this$0).getContext().getPackageManager().getInstalledPackages(0);
      JSONObject localJSONObject = null;
      Iterator localIterator = paramJSONObject.iterator();
      do
      {
        paramJSONObject = localJSONObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJSONObject = (PackageInfo)localIterator.next();
      } while ((paramJSONObject.packageName == null) || (!paramJSONObject.packageName.equals(str)));
      try
      {
        localJSONObject = new JSONObject();
        if (paramJSONObject != null) {
          localJSONObject.put("installed", 1);
        } else {
          localJSONObject.put("installed", 0);
        }
        this.val$req.ok(localJSONObject);
        return;
      }
      catch (Exception paramJSONObject)
      {
        this.val$req.fail("isMicroAppInstalled exception");
        QMLog.w("AppJsPlugin", "isMicroAppInstalled exception:", paramJSONObject);
        return;
      }
    }
    this.val$req.fail("check failed, server error");
    QMLog.w("AppJsPlugin", "check failed, server error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */