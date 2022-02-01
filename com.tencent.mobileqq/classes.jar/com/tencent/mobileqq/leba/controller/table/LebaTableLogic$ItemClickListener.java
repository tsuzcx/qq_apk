package com.tencent.mobileqq.leba.controller.table;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class LebaTableLogic$ItemClickListener
  implements View.OnClickListener
{
  WeakReference<LebaTableLogic> a;
  
  public LebaTableLogic$ItemClickListener(LebaTableLogic paramLebaTableLogic)
  {
    this.a = new WeakReference(paramLebaTableLogic);
  }
  
  public void onClick(View paramView)
  {
    LebaTableLogic localLebaTableLogic = (LebaTableLogic)this.a.get();
    if (localLebaTableLogic == null) {
      QLog.i("Q.lebatab.LebaTableLogic", 1, "logic == null");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (LebaTableLogic.a(localLebaTableLogic) != null)
      {
        LebaViewItem localLebaViewItem = localLebaTableLogic.a(paramView);
        if ((localLebaViewItem != null) && (localLebaTableLogic.a != null))
        {
          LebaClickReportInfo localLebaClickReportInfo = new LebaClickReportInfo();
          localLebaClickReportInfo.jdField_a_of_type_Boolean = true;
          localLebaClickReportInfo.jdField_a_of_type_Long = localLebaViewItem.jdField_a_of_type_Long;
          localLebaClickReportInfo.jdField_a_of_type_Int = (paramView.getId() + 1);
          if ((paramView instanceof RedTouch))
          {
            localLebaClickReportInfo.b = LebaConstant.a((RedTouch)paramView);
            localLebaClickReportInfo.c = LebaConstant.b((RedTouch)paramView);
          }
          localLebaTableLogic.a.a(paramView, localLebaViewItem, localLebaClickReportInfo);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.table.LebaTableLogic.ItemClickListener
 * JD-Core Version:    0.7.0.1
 */