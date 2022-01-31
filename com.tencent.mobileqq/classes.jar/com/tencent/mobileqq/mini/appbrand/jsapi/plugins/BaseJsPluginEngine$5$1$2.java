package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.widget.AuthDialog;

class BaseJsPluginEngine$5$1$2
  implements View.OnClickListener
{
  BaseJsPluginEngine$5$1$2(BaseJsPluginEngine.5.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.this$2.this$1.this$0.authDialog != null)
    {
      this.this$2.this$1.this$0.authDialog.setConfirm(true);
      this.this$2.this$1.this$0.authDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.5.1.2
 * JD-Core Version:    0.7.0.1
 */