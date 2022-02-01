package com.tencent.mobileqq.kandian.base.view.widget;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

public class ReadInjoyBePraisedDialog
  extends Dialog
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131437798) && (i != 2131448351)) {
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInjoyBePraisedDialog
 * JD-Core Version:    0.7.0.1
 */