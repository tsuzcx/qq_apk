package com.tencent.mobileqq.search.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.utils.ContactUtils;

public class TroopBatchAddFrdsSearchModelMember
  extends ContactSearchModelTroopMember
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  String jdField_a_of_type_JavaLangString;
  
  public TroopBatchAddFrdsSearchModelMember(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramQQAppInterface, paramInt, paramTroopMemberInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131376990) && (this.b == 23)) {
      TroopAddFrdsInnerFrame.a(localContext, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo, this.jdField_a_of_type_JavaLangString, false);
    }
    while (this.b != 23) {
      return;
    }
    Intent localIntent = new Intent(localContext, FriendProfileCardActivity.class);
    localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin);
    localIntent.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin);
    localIntent.putExtra("fromFlag", 1);
    localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131720219));
    localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131690778));
    TroopMemberCardUtils.a(localContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent, 9);
  }
  
  public CharSequence c()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin)) {
      return HardCodeUtil.a(2131715111);
    }
    if (localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, false)) {
      return HardCodeUtil.a(2131715112);
    }
    return null;
  }
  
  public String c()
  {
    return ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin);
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt <= 0) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt + HardCodeUtil.a(2131715113);
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt < 0) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember
 * JD-Core Version:    0.7.0.1
 */