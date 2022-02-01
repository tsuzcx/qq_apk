package com.tencent.mobileqq.troopshare;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TroopShareUtility$6
  extends QidianBusinessObserver
{
  TroopShareUtility$6(TroopShareUtility paramTroopShareUtility) {}
  
  public void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.a.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) || (this.a.jdField_a_of_type_Int == -1) || (this.a.b == -1)) {
      return;
    }
    if ((paramBoolean) && (paramHashMap != null))
    {
      String str = (String)paramHashMap.get("uin");
      if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(str))
      {
        this.a.b();
        return;
      }
      paramHashMap = (String)paramHashMap.get("url");
      this.a.jdField_a_of_type_JavaLangString = paramHashMap;
      switch (this.a.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
        paramHashMap = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        this.a.c = paramHashMap.getAvatarAddress("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        TroopShareUtility.e(this.a);
        return;
      case 3: 
        this.a.b();
        TroopShareUtility.c(this.a);
        return;
      case 2: 
        this.a.b();
        TroopShareUtility.d(this.a);
        return;
      case 1: 
        this.a.b();
        TroopShareUtility.f(this.a);
        return;
      }
      this.a.b();
      TroopShareUtility.g(this.a);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.a.jdField_a_of_type_Int, false);
    }
    this.a.b();
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692968), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
    this.a.jdField_a_of_type_Int = -1;
    this.a.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.6
 * JD-Core Version:    0.7.0.1
 */