package com.tencent.mobileqq.trooponline;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.text.ColorNickText;

class TroopOnlineMemberListAdapter$TmiCallBackForName
  implements TroopManager.ITroopMemberInfoCallBack
{
  public TroopOnlineMemberListAdapter.ViewHolder a;
  
  private TroopOnlineMemberListAdapter$TmiCallBackForName(TroopOnlineMemberListAdapter paramTroopOnlineMemberListAdapter) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    TroopOnlineMemberListAdapter.ViewHolder localViewHolder = this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder;
    if ((localViewHolder != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(localViewHolder.jdField_a_of_type_JavaLangString, paramTroopMemberInfo.memberuin)))
    {
      paramTroopMemberInfo = new ColorNickText(((TroopManager)this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter.a.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).a();
      this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramTroopMemberInfo);
      if (AppSetting.d) {
        TroopOnlineMemberListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter, this.jdField_a_of_type_ComTencentMobileqqTrooponlineTroopOnlineMemberListAdapter$ViewHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberListAdapter.TmiCallBackForName
 * JD-Core Version:    0.7.0.1
 */