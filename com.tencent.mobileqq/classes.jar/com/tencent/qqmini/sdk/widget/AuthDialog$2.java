package com.tencent.qqmini.sdk.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDialog$2
  implements View.OnClickListener
{
  AuthDialog$2(AuthDialog paramAuthDialog) {}
  
  public void onClick(View paramView)
  {
    this.this$0.getData().putBoolean("key_once_sub_cb1", AuthDialog.access$200(this.this$0).isChecked());
    this.this$0.getData().putBoolean("key_once_sub_cb2", AuthDialog.access$300(this.this$0).isChecked());
    this.this$0.getData().putBoolean("key_once_sub_cb3", AuthDialog.access$400(this.this$0).isChecked());
    this.this$0.getData().putBoolean("key_once_sub_cb_maintain", AuthDialog.access$500(this.this$0).isChecked());
    this.this$0.setRefuse(true);
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDialog.2
 * JD-Core Version:    0.7.0.1
 */