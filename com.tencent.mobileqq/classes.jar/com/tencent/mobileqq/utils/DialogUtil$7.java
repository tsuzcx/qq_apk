package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class DialogUtil$7
  implements View.OnClickListener
{
  DialogUtil$7(QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(View paramView)
  {
    QQCustomDialog localQQCustomDialog = this.a;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil.7
 * JD-Core Version:    0.7.0.1
 */