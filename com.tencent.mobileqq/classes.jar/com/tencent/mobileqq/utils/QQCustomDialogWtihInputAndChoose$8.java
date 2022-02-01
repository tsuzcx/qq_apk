package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QQCustomDialogWtihInputAndChoose$8
  implements View.OnClickListener
{
  QQCustomDialogWtihInputAndChoose$8(QQCustomDialogWtihInputAndChoose paramQQCustomDialogWtihInputAndChoose, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    String str = this.this$0.getInputValue();
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      if (this.val$nl != null)
      {
        this.val$nl.onClick(this.this$0, 1);
        this.this$0.hideChooseList();
      }
      try
      {
        if (this.this$0.isShowing()) {
          this.this$0.dismiss();
        }
        label60:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.this$0.chooseList == null) || (this.this$0.chooseList.size() <= 0)) {
          continue;
        }
        int i = 0;
        while ((i < this.this$0.chooseList.size()) && (!str.equals(this.this$0.chooseList.get(i)))) {
          i += 1;
        }
      }
      catch (Exception localException)
      {
        break label60;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.8
 * JD-Core Version:    0.7.0.1
 */