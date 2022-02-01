package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQToast$2
  implements View.OnClickListener
{
  QQToast$2(QQToast paramQQToast, QQToast.RightActionParams paramRightActionParams, Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    if (this.val$params.onClickListener != null)
    {
      this.val$toast.cancel();
      this.val$params.onClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.2
 * JD-Core Version:    0.7.0.1
 */