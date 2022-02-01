package com.tencent.qqmini.sdk.widget;

import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AuthDialog$1
  implements CompoundButton.OnCheckedChangeListener
{
  AuthDialog$1(AuthDialog paramAuthDialog) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((AuthDialog.access$000(this.this$0).getVisibility() == 0) && (AuthDialog.access$100(this.this$0).isChecked())) {}
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (AuthDialog.access$200(this.this$0).getVisibility() == 0)
      {
        i = j;
        if (AuthDialog.access$300(this.this$0).isChecked()) {
          i = j + 1;
        }
      }
      j = i;
      if (AuthDialog.access$400(this.this$0).getVisibility() == 0)
      {
        j = i;
        if (AuthDialog.access$500(this.this$0).isChecked()) {
          j = i + 1;
        }
      }
      if (j > 0)
      {
        AuthDialog.access$600(this.this$0).setEnabled(true);
        AuthDialog.access$600(this.this$0).setTextColor(-1);
      }
      for (;;)
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        AuthDialog.access$600(this.this$0).setEnabled(false);
        AuthDialog.access$600(this.this$0).setTextColor(Color.parseColor("#8e909d"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.AuthDialog.1
 * JD-Core Version:    0.7.0.1
 */