package com.tencent.qidian;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QidianProfileCardActivity$4
  implements View.OnClickListener
{
  QidianProfileCardActivity$4(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    ProfileCardUtil.a(this.a, this.a.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.4
 * JD-Core Version:    0.7.0.1
 */