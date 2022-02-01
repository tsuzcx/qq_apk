package com.tencent.mobileqq.troop.troopcard;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class TroopInfoActivity$23
  extends TroopObserver
{
  TroopInfoActivity$23(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
      this.a.c();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject = null;
      int i = 0;
      while ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null)
        {
          localObject = localTroopInfo;
        }
        else
        {
          localObject = localTroopInfo;
          if (!Utils.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
        i += 1;
      }
      if (localObject != null)
      {
        paramArrayList = this.a;
        paramArrayList.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localObject;
        paramArrayList.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(localObject, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin = paramTroopInfo.troopowneruin;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = paramTroopInfo.troopname;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopface = paramTroopInfo.troopface;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmemo = paramTroopInfo.troopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.location = paramTroopInfo.location;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.grade = paramTroopInfo.grade;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.school = paramTroopInfo.school;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.strLocation = paramTroopInfo.strLocation;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLat = paramTroopInfo.troopLat;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLon = paramTroopInfo.troopLon;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = paramTroopInfo.isNewTroop;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTags = paramTroopInfo.mTags;
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo;
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = HttpUtil.removeHtmlTags(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo);
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = HttpUtil.unEscape(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo);
      }
      paramTroopInfo = this.a;
      paramTroopInfo.jdField_a_of_type_Int = paramTroopInfo.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_Int != this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ThreadManager.post(new TroopInfoActivity.23.1(this, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo), 8, null, true);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.post(new TroopInfoActivity.23.2(this));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetTroopInfoResult|uin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("Q.troopinfo", 2, ((StringBuilder)localObject).toString());
      }
      paramString = ((ITroopInfoService)this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
      if (paramString != null)
      {
        localObject = this.a;
        ((TroopInfoActivity)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramString;
        ((TroopInfoActivity)localObject).jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(paramString, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      }
    }
  }
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin.equals(paramString1)))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTags = paramString2;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.23
 * JD-Core Version:    0.7.0.1
 */