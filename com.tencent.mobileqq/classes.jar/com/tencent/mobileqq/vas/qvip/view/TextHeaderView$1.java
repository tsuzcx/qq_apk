package com.tencent.mobileqq.vas.qvip.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TextHeaderView$1
  implements View.OnClickListener
{
  TextHeaderView$1(TextHeaderView paramTextHeaderView, Activity paramActivity, int paramInt, QQVipMsgInfo paramQQVipMsgInfo) {}
  
  public void onClick(View paramView)
  {
    TextHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqVasQvipViewTextHeaderView, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasQvipQQVipMsgInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.view.TextHeaderView.1
 * JD-Core Version:    0.7.0.1
 */