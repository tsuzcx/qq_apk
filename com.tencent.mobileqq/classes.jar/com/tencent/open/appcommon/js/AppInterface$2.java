package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import bfjb;
import bfpl;

public class AppInterface$2
  implements Runnable
{
  AppInterface$2(AppInterface paramAppInterface, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void run()
  {
    Resources localResources = this.this$0.activity.getResources();
    bfpl localbfpl = new bfpl(this.this$0.activity);
    localbfpl.a(2131691724, this.a, true);
    localbfpl.b(2131691725, this.a, true);
    localbfpl.a(localResources.getString(2131691728));
    localbfpl.b(localResources.getString(2131691713));
    localbfpl.setCancelable(false);
    localbfpl.setOnDismissListener(new bfjb(this));
    if ((this.this$0.activity != null) && (!this.this$0.activity.isFinishing())) {
      localbfpl.show();
    }
    this.this$0.tipDialog = localbfpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface.2
 * JD-Core Version:    0.7.0.1
 */