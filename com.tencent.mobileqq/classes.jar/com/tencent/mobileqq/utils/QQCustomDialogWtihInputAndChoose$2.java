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
    if (paramView != this.a.r)
    {
      if (this.a.r != null) {
        this.a.r.findViewById(2131437273).setVisibility(8);
      }
      TextView localTextView = (TextView)paramView.findViewById(2131437274);
      this.a.a(localTextView.getText().toString());
      paramView.findViewById(2131437273).setVisibility(0);
      this.a.r = paramView;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.2
 * JD-Core Version:    0.7.0.1
 */