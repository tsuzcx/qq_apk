package com.tencent.mobileqq.troop.troopcard;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceHandler;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class VisitorTroopCardFragment$10
  extends TroopEssenceMsgObserver
{
  VisitorTroopCardFragment$10(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, List<TroopCardEssenceMsg> paramList, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetTroopEssenceMsgList troopUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",source = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",msgList size = ");
      int i;
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(",totalNum = ");
      localStringBuilder.append(paramInt2);
      QLog.d("VisitorTroopCardFragment.Activity", 2, localStringBuilder.toString());
    }
    if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) && (paramBoolean) && (paramInt1 == 1))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopEssenceMsgView != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopEssenceMsgView.a(paramList, paramInt2, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "onGetTroopEssenceMsgList mTroopEssenceMsgView  GONE");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopEssenceMsgView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopEssenceMsgView.setVisibility(8);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, TroopInfo paramTroopInfo)
  {
    if (paramBoolean)
    {
      if (!TextUtils.equals(paramString, VisitorTroopCardFragment.a(this.a))) {
        return;
      }
      if ((paramTroopInfo != null) && (paramTroopInfo.mTroopInfoExtObj.essenceSwitch == 1))
      {
        paramString = (ITroopEssenceHandler)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName());
        if (paramString != null) {
          paramString.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment.10
 * JD-Core Version:    0.7.0.1
 */