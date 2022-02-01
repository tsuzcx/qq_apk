package com.tencent.mobileqq.mini.widget;

import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class AuthDialog$1
  implements CompoundButton.OnCheckedChangeListener
{
  AuthDialog$1(AuthDialog paramAuthDialog) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((AuthDialog.access$000(this.this$0).getVisibility() == 0) && (AuthDialog.access$100(this.this$0).isChecked())) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (AuthDialog.access$200(this.this$0).getVisibility() == 0)
    {
      i = j;
      if (AuthDialog.access$300(this.this$0).isChecked()) {
        i = j + 1;
      }
    }
    int j = i;
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
      return;
    }
    AuthDialog.access$600(this.this$0).setEnabled(false);
    AuthDialog.access$600(this.this$0).setTextColor(Color.parseColor("#8e909d"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.AuthDialog.1
 * JD-Core Version:    0.7.0.1
 */