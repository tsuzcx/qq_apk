package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bfes;
import bflc;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bflc localbflc = new bflc(this.this$0.activity);
    localbflc.a(2131691723, this.a, true);
    localbflc.b(2131691724, this.a, true);
    localbflc.a(localResources.getString(2131691727));
    localbflc.b(localResources.getString(2131691712));
    localbflc.setCancelable(false);
    localbflc.setOnDismissListener(new bfes(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbflc.show();
    }
    this.this$0.tipDialog = localbflc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */