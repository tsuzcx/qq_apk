package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bdfu;
import bdmf;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bdmf localbdmf = new bdmf(this.this$0.activity);
    localbdmf.a(2131691668, this.a, true);
    localbdmf.b(2131691669, this.a, true);
    localbdmf.a(localResources.getString(2131691672));
    localbdmf.b(localResources.getString(2131691657));
    localbdmf.setCancelable(false);
    localbdmf.setOnDismissListener(new bdfu(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbdmf.show();
    }
    this.this$0.tipDialog = localbdmf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */