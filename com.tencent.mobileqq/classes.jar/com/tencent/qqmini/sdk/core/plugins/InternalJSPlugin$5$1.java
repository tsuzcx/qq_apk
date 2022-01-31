package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import bgkd;
import bgxk;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

class InternalJSPlugin$5$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$5$1(InternalJSPlugin.5 param5) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(this.this$1.val$appParameter);
        if (!bool) {
          try
          {
            paramDialogInterface = new JSONObject(this.this$1.val$appParameter);
            if ((paramDialogInterface.has("path")) && (!TextUtils.isEmpty(paramDialogInterface.optString("path"))))
            {
              paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(paramDialogInterface.optString("path")));
              if (paramDialogInterface == null) {
                break label320;
              }
              paramDialogInterface.setPackage(this.this$1.val$packageName);
              paramDialogInterface.addFlags(67108864);
              paramDialogInterface.putExtra("big_brother_source_key", "biz_src_miniapp");
              if (paramDialogInterface.resolveActivity(this.this$1.val$activity.getPackageManager()) == null) {
                break;
              }
              this.this$1.val$activity.startActivity(paramDialogInterface);
              this.this$1.val$req.a();
              bgxk.a(this.this$1.this$0.mMiniAppInfo, null, "launchapp", "openapp", null);
              return;
            }
            localIntent = this.this$1.val$pm.getLaunchIntentForPackage(this.this$1.val$packageName);
            paramDialogInterface = localIntent;
            if (localIntent == null) {
              continue;
            }
            localIntent.putExtra("appParameter", this.this$1.val$appParameter);
            paramDialogInterface = localIntent;
            continue;
          }
          catch (Throwable paramDialogInterface)
          {
            QMLog.e("InternalJSPlugin", "parameter error,", paramDialogInterface);
            Intent localIntent = this.this$1.val$pm.getLaunchIntentForPackage(this.this$1.val$packageName);
            paramDialogInterface = localIntent;
            if (localIntent == null) {
              continue;
            }
            localIntent.putExtra("appParameter", this.this$1.val$appParameter);
            paramDialogInterface = localIntent;
            continue;
          }
        }
        paramDialogInterface = this.this$1.val$pm.getLaunchIntentForPackage(this.this$1.val$packageName);
      }
      catch (Throwable paramDialogInterface)
      {
        QMLog.e("InternalJSPlugin", "dialog click error,", paramDialogInterface);
        this.this$1.val$req.b();
        return;
      }
    }
    this.this$1.val$req.b();
    return;
    label320:
    this.this$1.val$req.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.5.1
 * JD-Core Version:    0.7.0.1
 */