package com.tencent.mobileqq.pluspanel.appinfo;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GroupPublicClassChatAppInfo$1
  implements ActionSheet.OnButtonClickListener
{
  GroupPublicClassChatAppInfo$1(GroupPublicClassChatAppInfo paramGroupPublicClassChatAppInfo, ActionSheet paramActionSheet, PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      GroupPublicClassChatAppInfo.access$100(this.jdField_a_of_type_ComTencentMobileqqPluspanelAppinfoGroupPublicClassChatAppInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      return;
    }
    GroupPublicClassChatAppInfo.access$000(this.jdField_a_of_type_ComTencentMobileqqPluspanelAppinfoGroupPublicClassChatAppInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioPluspanelPlusPanelViewModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupPublicClassChatAppInfo.1
 * JD-Core Version:    0.7.0.1
 */