package com.tencent.mobileqq.troopshare;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class TroopShareUtility$6
  extends QidianBusinessObserver
{
  TroopShareUtility$6(TroopShareUtility paramTroopShareUtility) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.a.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onQidianGroupInfo start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin != null))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_Int != -1) && (this.a.b != -1))
      {
        if ((paramBoolean) && (paramHashMap != null))
        {
          Object localObject = (String)paramHashMap.get("uin");
          if (!this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin.equals(localObject))
          {
            this.a.b();
            return;
          }
          paramHashMap = (String)paramHashMap.get("url");
          localObject = this.a;
          ((TroopShareUtility)localObject).jdField_a_of_type_JavaLangString = paramHashMap;
          int i = ((TroopShareUtility)localObject).jdField_a_of_type_Int;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 4) {
                    return;
                  }
                  this.a.b();
                  TroopShareUtility.g(this.a);
                  return;
                }
                this.a.b();
                TroopShareUtility.c(this.a);
                return;
              }
              this.a.b();
              TroopShareUtility.d(this.a);
              return;
            }
            this.a.b();
            TroopShareUtility.f(this.a);
            return;
          }
          paramHashMap = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
          localObject = this.a;
          ((TroopShareUtility)localObject).c = paramHashMap.getAvatarAddress("", ((TroopShareUtility)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0);
          this.a.b();
          TroopShareUtility.e(this.a);
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.a.jdField_a_of_type_Int, false);
        }
        this.a.b();
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131692928), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        paramHashMap = this.a;
        paramHashMap.jdField_a_of_type_Int = -1;
        paramHashMap.b = -1;
      }
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.6
 * JD-Core Version:    0.7.0.1
 */