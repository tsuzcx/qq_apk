package com.tencent.mobileqq.leba.controller.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class LebaListController$1
  implements View.OnClickListener
{
  LebaListController$1(LebaListController paramLebaListController) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(-1)).intValue();
    LebaViewItem localLebaViewItem = (LebaViewItem)LebaListController.a(this.a).getItem(i);
    if (localLebaViewItem == null) {
      QLog.i("Q.lebatab.LebaListController", 1, "item == null ");
    }
    Map localMap;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localMap = LebaListController.a(this.a).a();
    } while (LebaListController.a(this.a) == null);
    LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
    localLebaClickReportInfo.jdField_a_of_type_Boolean = false;
    localLebaClickReportInfo.jdField_a_of_type_Long = localLebaViewItem.jdField_a_of_type_Long;
    Integer localInteger = null;
    if (localMap != null) {
      localInteger = (Integer)localMap.get(Long.valueOf(localLebaViewItem.jdField_a_of_type_Long));
    }
    if (localInteger == null) {}
    for (i = 0;; i = localInteger.intValue())
    {
      localLebaClickReportInfo.jdField_a_of_type_Int = i;
      if ((paramView instanceof RedTouch)) {
        localLebaClickReportInfo.b = LebaConstant.a((RedTouch)paramView);
      }
      LebaListController.a(this.a).a(paramView, localLebaViewItem, localLebaClickReportInfo);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListController.1
 * JD-Core Version:    0.7.0.1
 */