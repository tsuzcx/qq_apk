package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.homework.IHomeworkHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.qphone.base.util.QLog;

final class HWTroopUtils$1
  implements TroopManager.ITroopMemberInfoCallBack
{
  HWTroopUtils$1(String paramString1, String paramString2, boolean paramBoolean, QQAppInterface paramQQAppInterface, HWTroopUtils.OnHomeworkTroopIdentityCheckListener paramOnHomeworkTroopIdentityCheckListener) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkHomeworkTroopIdentity. troopUin=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", memberUin=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", level=");
      String str = "";
      Object localObject;
      if (paramTroopMemberInfo == null) {
        localObject = "";
      } else {
        localObject = Integer.valueOf(paramTroopMemberInfo.level);
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", reqMemberInfo=");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(", hwIdentity=");
      if (paramTroopMemberInfo == null) {
        localObject = str;
      } else {
        localObject = Integer.valueOf(paramTroopMemberInfo.hwIdentity);
      }
      localStringBuilder.append(localObject);
      QLog.i("hw_troop", 2, localStringBuilder.toString());
    }
    if ((paramTroopMemberInfo != null) || (this.jdField_a_of_type_Boolean)) {}
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      long l2 = Long.parseLong(this.b);
      ((ITroopMemberCardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER)).a(l1, l2, true);
      return;
    }
    catch (NumberFormatException paramTroopMemberInfo)
    {
      label207:
      break label207;
    }
    if (QLog.isColorLevel()) {
      QLog.d("hw_troop", 2, new Object[] { "checkIdentity NumberFormatException,info.troopuin=", this.jdField_a_of_type_JavaLangString, ", memberuin=", this.b });
    }
    return;
    if (!((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).hasHomeworkTroopIdentity(paramTroopMemberInfo.hwIdentity))
    {
      ((IHomeworkHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopHomeworkHandlerName())).a(this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
    HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHWTroopUtils$OnHomeworkTroopIdentityCheckListener, paramTroopMemberInfo.level);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.HWTroopUtils.1
 * JD-Core Version:    0.7.0.1
 */