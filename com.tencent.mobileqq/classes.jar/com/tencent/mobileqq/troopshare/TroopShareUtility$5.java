package com.tencent.mobileqq.troopshare;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopShareUtility$5
  extends TroopBusinessObserver
{
  TroopShareUtility$5(TroopShareUtility paramTroopShareUtility) {}
  
  public void onTroopShareLink(boolean paramBoolean, TroopShareResp paramTroopShareResp)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin == null) || (paramTroopShareResp == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramTroopShareResp.jdField_a_of_type_JavaLangString))) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
      }
    }
    label455:
    label636:
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_Int != -1) && (this.a.jdField_b_of_type_Int != -1))
      {
        if ((!paramBoolean) || (paramTroopShareResp.jdField_a_of_type_Int != 0)) {
          break label455;
        }
        if (paramTroopShareResp.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_JavaLangString = paramTroopShareResp.jdField_b_of_type_JavaLangString;
          if (this.a.jdField_b_of_type_Int != 0)
          {
            if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
              continue;
            }
            ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          }
        }
        else
        {
          this.a.jdField_b_of_type_JavaLangString = paramTroopShareResp.jdField_b_of_type_JavaLangString;
          if (this.a.jdField_b_of_type_Int != 1)
          {
            if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
              continue;
            }
            ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
            return;
          }
        }
        switch (this.a.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          break label636;
        }
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        return;
        this.a.b();
        TroopShareUtility.c(this.a);
        continue;
        this.a.b();
        TroopShareUtility.d(this.a);
        continue;
        paramTroopShareResp = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
        this.a.c = paramTroopShareResp.getAvatarAddress("", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0);
        this.a.b();
        TroopShareUtility.e(this.a);
        continue;
        this.a.b();
        TroopShareUtility.f(this.a);
        continue;
        this.a.b();
        TroopShareUtility.g(this.a);
        continue;
        if ((paramTroopShareResp.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 0))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if ((!paramTroopShareResp.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 1))
        {
          if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            break;
          }
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.a.jdField_a_of_type_Int, false);
        }
        this.a.b();
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131692968), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.jdField_b_of_type_Int = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.5
 * JD-Core Version:    0.7.0.1
 */