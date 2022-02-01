package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bjrj;
import bjxr;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bjxr localbjxr = new bjxr(this.this$0.activity);
    localbjxr.a(2131691463, this.a, true);
    localbjxr.b(2131691464, this.a, true);
    localbjxr.a(localResources.getString(2131691467));
    localbjxr.b(localResources.getString(2131691452));
    localbjxr.setCancelable(false);
    localbjxr.setOnDismissListener(new bjrj(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbjxr.show();
    }
    this.this$0.tipDialog = localbjxr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */