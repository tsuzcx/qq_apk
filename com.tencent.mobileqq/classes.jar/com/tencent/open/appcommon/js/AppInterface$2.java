package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import biqk;
import biws;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    biws localbiws = new biws(this.this$0.activity);
    localbiws.a(2131691460, this.a, true);
    localbiws.b(2131691461, this.a, true);
    localbiws.a(localResources.getString(2131691464));
    localbiws.b(localResources.getString(2131691449));
    localbiws.setCancelable(false);
    localbiws.setOnDismissListener(new biqk(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbiws.show();
    }
    this.this$0.tipDialog = localbiws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */