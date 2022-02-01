package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQCustomDialogWtihInputAndChoose$2
  implements View.OnClickListener
{
  QQCustomDialogWtihInputAndChoose$2(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.a) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.a != null) {
        this.a.a.findViewById(2131370453).setVisibility(8);
      }
      TextView localTextView = (TextView)paramView.findViewById(2131370454);
      this.a.a(localTextView.getText().toString());
      paramView.findViewById(2131370453).setVisibility(0);
      this.a.a = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.2
 * JD-Core Version:    0.7.0.1
 */