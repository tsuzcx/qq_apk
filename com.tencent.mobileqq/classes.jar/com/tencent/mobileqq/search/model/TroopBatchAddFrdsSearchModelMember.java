package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.utils.ContactUtils;

public class TroopBatchAddFrdsSearchModelMember
  extends ContactSearchModelTroopMember
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo;
  String jdField_a_of_type_JavaLangString;
  
  public TroopBatchAddFrdsSearchModelMember(QQAppInterface paramQQAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramQQAppInterface, paramInt, paramTroopMemberInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(View paramView)
  {
    if ((paramView.getId() == 2131368974) && (this.b == 23)) {
      TroopAddFrdsInnerFrame.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo, this.jdField_a_of_type_JavaLangString, false);
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
      } while (this.b != 23);
      localIntent = new Intent(paramView.getContext(), FriendProfileCardActivity.class);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin);
      localIntent.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
      localIntent.putExtra("fromFlag", 1);
      localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131433123));
      localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131433712));
      localIntent = TroopMemberCardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localIntent);
    } while (localIntent == null);
    ((Activity)paramView.getContext()).startActivity(localIntent);
  }
  
  public CharSequence c()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin)) {
      return "已添加";
    }
    if (localFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin, false)) {
      return "等待验证";
    }
    return null;
  }
  
  public String c()
  {
    return ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.memberuin);
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt <= 0) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt + "位共同好友";
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt < 0) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.commonFrdCnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.TroopBatchAddFrdsSearchModelMember
 * JD-Core Version:    0.7.0.1
 */