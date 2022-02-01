package com.tencent.mobileqq.mini.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class AuthDialog$4
  implements View.OnClickListener
{
  AuthDialog$4(AuthDialog paramAuthDialog) {}
  
  public void onClick(View paramView)
  {
    this.this$0.getData().putBoolean("key_once_sub_cb1", AuthDialog.access$100(this.this$0).isChecked());
    this.this$0.getData().putBoolean("key_once_sub_cb2", AuthDialog.access$300(this.this$0).isChecked());
    this.this$0.getData().putBoolean("key_once_sub_cb3", AuthDialog.access$500(this.this$0).isChecked());
    this.this$0.getData().putBoolean("key_once_sub_cb_maintain", AuthDialog.access$900(this.this$0).isChecked());
    this.this$0.setConfirm(true);
    this.this$0.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog.4
 * JD-Core Version:    0.7.0.1
 */