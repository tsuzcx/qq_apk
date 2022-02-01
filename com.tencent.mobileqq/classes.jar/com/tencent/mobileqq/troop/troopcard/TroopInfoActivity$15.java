package com.tencent.mobileqq.troop.troopcard;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopaudit.api.ITroopAuditHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopInfoActivity$15
  implements View.OnClickListener
{
  TroopInfoActivity$15(TroopInfoActivity paramTroopInfoActivity, Dialog paramDialog, long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString) {}
  
  public void onClick(View paramView)
  {
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.finish();
    ((ITroopAuditHandler)this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAuditHandlerName())).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags, this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mPoiId, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.15
 * JD-Core Version:    0.7.0.1
 */