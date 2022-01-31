package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.widget.AuthDialog;

class BaseJsPluginEngine$6
  implements View.OnClickListener
{
  BaseJsPluginEngine$6(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onClick(View paramView)
  {
    this.this$0.authDialog.setRefuse(true);
    this.this$0.authDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine.6
 * JD-Core Version:    0.7.0.1
 */