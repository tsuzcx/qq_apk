package com.tencent.mobileqq.confess;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopConfessItemBuilder$1
  implements View.OnClickListener
{
  TroopConfessItemBuilder$1(TroopConfessItemBuilder paramTroopConfessItemBuilder, MessageForTroopConfess paramMessageForTroopConfess) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.items != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.items.isEmpty())) {
      TroopConfessUtil.a(this.jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_ComTencentMobileqqConfessTroopConfessItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.getConfessTopicId(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.mTroopConfessMsg.confessorUin), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopConfess.getConfessToUin()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */