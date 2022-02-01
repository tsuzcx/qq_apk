package com.tencent.mobileqq.leba.controller.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.report.LebaDaTong;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LebaListController$1
  implements View.OnClickListener
{
  LebaListController$1(LebaListController paramLebaListController) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    LebaViewItem localLebaViewItem = (LebaViewItem)LebaListController.a(this.a).getItem(i);
    if (localLebaViewItem == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    else
    {
      if ((paramView instanceof RedTouch)) {
        LebaDaTong.a(paramView, LebaConstant.a((RedTouch)paramView));
      }
      LebaListController.a(this.a).c();
      if (LebaListController.b(this.a) != null) {
        if (localLebaViewItem.h == 2) {
          LebaListController.b(this.a).a(paramView, localLebaViewItem);
        } else {
          LebaListController.b(this.a).a(paramView, localLebaViewItem, i);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListController.1
 * JD-Core Version:    0.7.0.1
 */