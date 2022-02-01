package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bhwy;
import bicz;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bicz localbicz = new bicz(this.this$0.activity);
    localbicz.a(2131691507, this.a, true);
    localbicz.b(2131691508, this.a, true);
    localbicz.a(localResources.getString(2131691511));
    localbicz.b(localResources.getString(2131691496));
    localbicz.setCancelable(false);
    localbicz.setOnDismissListener(new bhwy(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbicz.show();
    }
    this.this$0.tipDialog = localbicz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */