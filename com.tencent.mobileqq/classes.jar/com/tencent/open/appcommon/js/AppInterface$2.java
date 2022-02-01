package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bjia;
import bjob;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bjob localbjob = new bjob(this.this$0.activity);
    localbjob.a(2131691592, this.a, true);
    localbjob.b(2131691593, this.a, true);
    localbjob.a(localResources.getString(2131691596));
    localbjob.b(localResources.getString(2131691581));
    localbjob.setCancelable(false);
    localbjob.setOnDismissListener(new bjia(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbjob.show();
    }
    this.this$0.tipDialog = localbjob;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */