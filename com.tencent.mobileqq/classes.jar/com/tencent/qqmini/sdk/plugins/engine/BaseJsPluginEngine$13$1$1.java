package com.tencent.qqmini.sdk.plugins.engine;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.widget.AuthDialog;

class BaseJsPluginEngine$13$1$1
  implements View.OnClickListener
{
  BaseJsPluginEngine$13$1$1(BaseJsPluginEngine.13.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.a.e.i.authDialog != null)
    {
      this.a.e.i.authDialog.setConfirm(true);
      this.a.e.i.authDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.13.1.1
 * JD-Core Version:    0.7.0.1
 */