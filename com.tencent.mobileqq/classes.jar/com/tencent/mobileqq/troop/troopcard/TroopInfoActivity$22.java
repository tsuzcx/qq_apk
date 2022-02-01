package com.tencent.mobileqq.troop.troopcard;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class TroopInfoActivity$22
  extends TroopModifyObserver
{
  TroopInfoActivity$22(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, String.valueOf(paramLong))) {
      return;
    }
    if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
    {
      this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
      if (paramTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
      }
      if (paramBoolean)
      {
        this.a.a(2131693391, 2);
        return;
      }
      this.a.a(2131693390, 1);
      TroopInfoActivity.a(this.a, paramInt);
      return;
    }
    if ((paramBoolean) && (paramTroopInfo != null))
    {
      TroopInfoActivity localTroopInfoActivity = this.a;
      localTroopInfoActivity.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
      if ((localTroopInfoActivity.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.size() == 0))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (paramBoolean))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 2) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = 3;
      } else {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt;
      }
      localObject = (ITroopInfoService)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      TroopInfo localTroopInfo = ((ITroopInfoService)localObject).getTroopInfo(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      if (localTroopInfo != null)
      {
        localTroopInfo.troopname = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
        localTroopInfo.dwGroupClassExt = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt;
        localTroopInfo.mGroupClassExtText = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopClassExtText;
        localTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
        localTroopInfo.hasSetNewTroopName = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName;
        localTroopInfo.strLocation = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation;
        localTroopInfo.troopLat = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat;
        localTroopInfo.troopLon = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon;
        localTroopInfo.location = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.location;
        localTroopInfo.grade = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.grade;
        localTroopInfo.school = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.school;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append("\n");
            localStringBuffer.append(localStringBuilder.toString());
          }
          localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
          localTroopInfo.mTags = localStringBuffer.toString();
        }
        ((ITroopInfoService)localObject).saveTroopInfo(localTroopInfo);
      }
    }
    if ((this.a.jdField_a_of_type_Int == 0) || (1 == this.a.jdField_a_of_type_Int)) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.a.b, "", "");
    }
    Object localObject = this.a;
    TroopInfoActivity.a((TroopInfoActivity)localObject, paramBoolean, paramLong, paramString, 0L, ((TroopInfoActivity)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super.a(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramString1))
    {
      this.a.p();
      if (paramBoolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName = true;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName = paramString2;
        if ((!this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) || (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName)) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName = paramString2;
        }
        this.a.c();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName = true;
        if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop = false;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName;
          this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop;
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
        }
      }
      else
      {
        paramString1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString1 = HardCodeUtil.a(2131701959);
        }
        QQToast.a(this.a, 1, paramString1, 0).b(this.a.getTitleBarHeight());
        if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
          this.a.c();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopinfo", 2, paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.22
 * JD-Core Version:    0.7.0.1
 */