package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.open.downloadnew.MyAppDialog;

class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    MyAppDialog localMyAppDialog = new MyAppDialog(this.this$0.activity);
    localMyAppDialog.a(2131691708, this.a, true);
    localMyAppDialog.b(2131691709, this.a, true);
    localMyAppDialog.a(localResources.getString(2131691712));
    localMyAppDialog.b(localResources.getString(2131691697));
    localMyAppDialog.setCancelable(false);
    localMyAppDialog.setOnDismissListener(new AppInterface.2.1(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localMyAppDialog.show();
    }
    this.this$0.tipDialog = localMyAppDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */