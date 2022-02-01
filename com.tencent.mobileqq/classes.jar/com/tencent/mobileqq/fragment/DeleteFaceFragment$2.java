package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DeleteFaceFragment$2
  implements View.OnClickListener
{
  DeleteFaceFragment$2(DeleteFaceFragment paramDeleteFaceFragment, FragmentActivity paramFragmentActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800A320", "0X800A320", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://accounts.qq.com/face/delete");
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 1001);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment.2
 * JD-Core Version:    0.7.0.1
 */