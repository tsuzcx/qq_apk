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
    Object localObject = this.b.getInputValue();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (this.b.o != null) && (this.b.o.size() > 0))
    {
      int i = 0;
      while ((i < this.b.o.size()) && (!((String)localObject).equals(this.b.o.get(i)))) {
        i += 1;
      }
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((DialogInterface.OnClickListener)localObject).onClick(this.b, 1);
      this.b.a();
    }
    try
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      label129:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.8
 * JD-Core Version:    0.7.0.1
 */