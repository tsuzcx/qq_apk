package com.tencent.mobileqq.troop.troopcard;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopaudit.api.ITroopAuditHandler;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$12
  implements Runnable
{
  TroopInfoActivity$12(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.troopinfo", 2, "init mTroopInfoData == null");
      }
      return;
    }
    boolean bool2 = TextUtils.isEmpty(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
    boolean bool1 = true;
    if (!bool2)
    {
      localObject1 = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getFriendDisplayName(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin)))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopOwnerNick = ((String)localObject1);
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      else
      {
        localObject2 = null;
        localObject3 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
        if (localObject3 == null)
        {
          localObject3 = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberInfo(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
          localObject1 = localObject2;
          if (localObject3 != null) {
            if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).friendnick))
            {
              localObject1 = ((TroopMemberInfo)localObject3).friendnick;
            }
            else
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(((TroopMemberInfo)localObject3).troopnick)) {
                localObject1 = ((TroopMemberInfo)localObject3).troopnick;
              }
            }
          }
        }
        else if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).nick))
        {
          localObject1 = ((TroopMemberCardInfo)localObject3).nick;
        }
        else
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(((TroopMemberCardInfo)localObject3).name)) {
            localObject1 = ((TroopMemberCardInfo)localObject3).name;
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopOwnerNick = ((String)localObject1);
          this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
        }
        else
        {
          this.this$0.c = true;
          ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getFriendInfo(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin);
        }
      }
    }
    Object localObject1 = (ITroopMngHandler)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
    if (localObject1 != null)
    {
      if ((!this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 2) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 101) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 102) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 103) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 104) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 105) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 106) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 112) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 113))
      {
        ((ITroopMngHandler)localObject1).a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
      }
      else if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
      {
        localObject1 = (ITroopInfoHandler)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
        localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa != 28) {
          bool1 = false;
        }
        ((ITroopInfoHandler)localObject1).a((String)localObject2, bool1);
      }
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).refreshTroopFace(this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopinfo", 2, "init(),getTroopMemberCard,getMutiTroopInfo,refreshTroopFace");
    }
    localObject1 = GroupCatalogTool.a(BaseApplication.getContext());
    Object localObject2 = this.this$0;
    localObject1 = ((GroupCatalogTool)localObject1).a((Context)localObject2, Long.toString(((TroopInfoActivity)localObject2).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt));
    if (localObject1 != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopClass = ((GroupCatalogBean)localObject1).a();
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    localObject1 = (ITroopInfoHandler)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
    localObject2 = (ITroopSettingHandler)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopSettingHandlerName());
    Object localObject3 = (ITroopAuditHandler)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAuditHandlerName());
    if ((localObject2 != null) && (localObject1 != null) && (localObject3 != null))
    {
      ((ITroopInfoHandler)localObject1).d(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      ((ITroopAuditHandler)localObject3).a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 115) {
        ((ITroopSettingHandler)localObject2).a(this.this$0.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.12
 * JD-Core Version:    0.7.0.1
 */