package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bcbe;
import bchp;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bchp localbchp = new bchp(this.this$0.activity);
    localbchp.a(2131626084, this.a, true);
    localbchp.b(2131626085, this.a, true);
    localbchp.a(localResources.getString(2131626089));
    localbchp.b(localResources.getString(2131626081));
    localbchp.setCancelable(false);
    localbchp.setOnDismissListener(new bcbe(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbchp.show();
    }
    this.this$0.tipDialog = localbchp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */