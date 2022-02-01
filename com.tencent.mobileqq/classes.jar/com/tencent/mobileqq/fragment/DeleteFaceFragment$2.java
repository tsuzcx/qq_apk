package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DeleteFaceFragment$2
  implements View.OnClickListener
{
  DeleteFaceFragment$2(DeleteFaceFragment paramDeleteFaceFragment, QBaseActivity paramQBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    Intent localIntent = new Intent();
    localIntent.putExtra("url", "https://accounts.qq.com/face/delete");
    RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localIntent, "/base/browser", 1001);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment.2
 * JD-Core Version:    0.7.0.1
 */