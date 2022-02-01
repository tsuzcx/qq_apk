package com.tencent.qqmini.sdk.plugins.engine;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.widget.AuthDialog;

class BaseJsPluginEngine$11
  implements View.OnClickListener
{
  BaseJsPluginEngine$11(BaseJsPluginEngine paramBaseJsPluginEngine) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.authDialog != null)
    {
      this.this$0.authDialog.setConfirm(true);
      this.this$0.authDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.engine.BaseJsPluginEngine.11
 * JD-Core Version:    0.7.0.1
 */