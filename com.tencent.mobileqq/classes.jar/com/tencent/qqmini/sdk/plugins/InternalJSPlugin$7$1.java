package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.report.InnerAppReportDc4239;

class InternalJSPlugin$7$1
  implements DialogInterface.OnClickListener
{
  InternalJSPlugin$7$1(InternalJSPlugin.7 param7) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = InternalJSPlugin.access$900(this.this$1.this$0, this.this$1.val$appParameter, this.this$1.val$pm, this.this$1.val$packageName);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.setPackage(this.this$1.val$packageName);
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.putExtra("big_brother_source_key", "biz_src_miniapp");
      if (paramDialogInterface.resolveActivity(this.this$1.val$activity.getPackageManager()) != null)
      {
        this.this$1.val$activity.startActivity(paramDialogInterface);
        paramDialogInterface = InternalJSPlugin.access$700(this.this$1.this$0, 0);
        this.this$1.val$req.ok(paramDialogInterface);
        InnerAppReportDc4239.innerAppReport(InternalJSPlugin.access$1000(this.this$1.this$0), null, "launchapp", "openapp", null);
        return;
      }
      paramDialogInterface = InternalJSPlugin.access$700(this.this$1.this$0, -1);
      this.this$1.val$req.fail(paramDialogInterface, "");
      return;
    }
    paramDialogInterface = InternalJSPlugin.access$700(this.this$1.this$0, -1);
    this.this$1.val$req.fail(paramDialogInterface, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */