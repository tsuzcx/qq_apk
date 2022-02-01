package com.tencent.qidian;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QidianProfileCardActivity$4
  implements View.OnClickListener
{
  QidianProfileCardActivity$4(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    QidianProfileCardActivity localQidianProfileCardActivity = this.a;
    ProfileCardUtil.a(localQidianProfileCardActivity, localQidianProfileCardActivity.jdField_a_of_type_AndroidWidgetImageView, this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.4
 * JD-Core Version:    0.7.0.1
 */