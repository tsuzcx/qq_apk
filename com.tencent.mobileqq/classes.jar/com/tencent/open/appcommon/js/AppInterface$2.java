package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bdff;
import bdlq;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bdlq localbdlq = new bdlq(this.this$0.activity);
    localbdlq.a(2131691668, this.a, true);
    localbdlq.b(2131691669, this.a, true);
    localbdlq.a(localResources.getString(2131691672));
    localbdlq.b(localResources.getString(2131691657));
    localbdlq.setCancelable(false);
    localbdlq.setOnDismissListener(new bdff(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbdlq.show();
    }
    this.this$0.tipDialog = localbdlq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */