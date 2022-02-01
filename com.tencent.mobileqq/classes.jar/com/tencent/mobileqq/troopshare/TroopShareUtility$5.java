package com.tencent.mobileqq.troopshare;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.troop.troopmanager.api.TroopManagerBizObserver;
import com.tencent.mobileqq.troop.troopshare.TroopShareResp;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopShareUtility$5
  extends TroopManagerBizObserver
{
  TroopShareUtility$5(TroopShareUtility paramTroopShareUtility) {}
  
  public void onTroopShareLink(boolean paramBoolean, TroopShareResp paramTroopShareResp)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopmanagerApiTroopManagerBizObserver);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShareUtility", 2, "onTroopShareLink start");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin != null) && (paramTroopShareResp != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin.equals(paramTroopShareResp.jdField_a_of_type_JavaLangString)))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.a.jdField_a_of_type_Int != -1) && (this.a.jdField_b_of_type_Int != -1)) {
        if ((paramBoolean) && (paramTroopShareResp.jdField_a_of_type_Int == 0))
        {
          if (paramTroopShareResp.jdField_a_of_type_Boolean)
          {
            this.a.jdField_a_of_type_JavaLangString = paramTroopShareResp.jdField_b_of_type_JavaLangString;
            if (this.a.jdField_b_of_type_Int != 0) {
              if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
                ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
              }
            }
          }
          else
          {
            this.a.jdField_b_of_type_JavaLangString = paramTroopShareResp.jdField_b_of_type_JavaLangString;
            if (this.a.jdField_b_of_type_Int != 1)
            {
              if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
                ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
              }
              return;
            }
          }
          int i = this.a.jdField_a_of_type_Int;
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4)
                  {
                    this.a.b();
                    TroopShareUtility.g(this.a);
                  }
                }
                else
                {
                  this.a.b();
                  TroopShareUtility.c(this.a);
                }
              }
              else
              {
                this.a.b();
                TroopShareUtility.d(this.a);
              }
            }
            else
            {
              this.a.b();
              TroopShareUtility.f(this.a);
            }
          }
          else
          {
            paramTroopShareResp = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
            TroopShareUtility localTroopShareUtility = this.a;
            localTroopShareUtility.c = paramTroopShareResp.getAvatarAddress("", localTroopShareUtility.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0);
            this.a.b();
            TroopShareUtility.e(this.a);
          }
        }
        else
        {
          if ((paramTroopShareResp.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 0))
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
              ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
            }
            return;
          }
          if ((!paramTroopShareResp.jdField_a_of_type_Boolean) && (this.a.jdField_b_of_type_Int != 1))
          {
            if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
              ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
            }
            return;
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility$OnShareListener.a(this.a.jdField_a_of_type_Int, false);
          }
          this.a.b();
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131692928), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
          paramTroopShareResp = this.a;
          paramTroopShareResp.jdField_a_of_type_Int = -1;
          paramTroopShareResp.jdField_b_of_type_Int = -1;
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
      }
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
      ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.5
 * JD-Core Version:    0.7.0.1
 */