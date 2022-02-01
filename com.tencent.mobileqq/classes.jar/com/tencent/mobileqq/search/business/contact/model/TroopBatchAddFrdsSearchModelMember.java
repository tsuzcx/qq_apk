package com.tencent.mobileqq.search.business.contact.model;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;

public class TroopBatchAddFrdsSearchModelMember
  extends ContactSearchModelTroopMember
{
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  String jdField_a_of_type_JavaLangString;
  
  public TroopBatchAddFrdsSearchModelMember(AppInterface paramAppInterface, int paramInt, TroopMemberInfo paramTroopMemberInfo, String paramString)
  {
    super(paramAppInterface, paramInt, paramTroopMemberInfo);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = paramTroopMemberInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public CharSequence a()
  {
    if (SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin)) {
      return HardCodeUtil.a(2131715034);
    }
    if (SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin, false)) {
      return HardCodeUtil.a(2131715035);
    }
    return null;
  }
  
  public void a(View paramView)
  {
    Context localContext = paramView.getContext();
    if ((paramView.getId() == 2131376477) && (this.b == 23))
    {
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).addFriend(localContext, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo, this.jdField_a_of_type_JavaLangString, false);
      return;
    }
    if (this.b == 23)
    {
      Intent localIntent = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(localContext, null);
      localIntent.putExtra("troopUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin);
      localIntent.putExtra("memberUin", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin);
      localIntent.putExtra("fromFlag", 1);
      localIntent.putExtra("selfSet_leftViewText", paramView.getContext().getString(2131719952));
      localIntent.putExtra("custom_leftbackbutton_name", paramView.getContext().getString(2131690706));
      ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).joinFriendProfileIntentWithTroopMemberCardIntent(localContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localIntent, 9);
    }
  }
  
  public String c()
  {
    return SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt);
    localStringBuilder.append(HardCodeUtil.a(2131715036));
    return localStringBuilder.toString();
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt < 0) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.commonFrdCnt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.contact.model.TroopBatchAddFrdsSearchModelMember
 * JD-Core Version:    0.7.0.1
 */