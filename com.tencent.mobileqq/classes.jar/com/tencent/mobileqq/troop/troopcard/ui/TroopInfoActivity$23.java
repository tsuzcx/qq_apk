package com.tencent.mobileqq.troop.troopcard.ui;

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
    if (this.a.i != null)
    {
      this.a.f.newTroopName = this.a.i.getTroopDisplayName();
      this.a.d();
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
          if (!Utils.a(localTroopInfo.troopuin, this.a.f.troopUin)) {
            localObject = null;
          }
        }
        i += 1;
      }
      if (localObject != null)
      {
        paramArrayList = this.a;
        paramArrayList.i = localObject;
        paramArrayList.f.updateForTroopInfo(localObject, this.a.H.getCurrentAccountUin());
        this.a.J.sendEmptyMessage(4);
      }
    }
  }
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.a.i != null) && (this.a.i.troopuin != null) && (this.a.i.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.a.i.troopowneruin = paramTroopInfo.troopowneruin;
      this.a.i.troopname = paramTroopInfo.troopname;
      this.a.i.troopface = paramTroopInfo.troopface;
      this.a.i.troopmemo = paramTroopInfo.troopmemo;
      this.a.i.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.a.i.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.a.i.location = paramTroopInfo.location;
      this.a.i.grade = paramTroopInfo.grade;
      this.a.i.school = paramTroopInfo.school;
      this.a.i.strLocation = paramTroopInfo.strLocation;
      this.a.i.troopLat = paramTroopInfo.troopLat;
      this.a.i.troopLon = paramTroopInfo.troopLon;
      this.a.i.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.a.i.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.a.i.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.a.i.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.a.i.isNewTroop = paramTroopInfo.isNewTroop;
      this.a.i.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.a.i.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.a.i.mTags = paramTroopInfo.mTags;
      if (TextUtils.isEmpty(this.a.i.mRichFingerMemo))
      {
        this.a.i.mRichFingerMemo = this.a.i.fingertroopmemo;
      }
      else
      {
        this.a.i.mRichFingerMemo = HttpUtil.removeHtmlTags(this.a.i.mRichFingerMemo);
        this.a.i.mRichFingerMemo = HttpUtil.unEscape(this.a.i.mRichFingerMemo);
      }
      paramTroopInfo = this.a;
      paramTroopInfo.r = paramTroopInfo.i.troopTypeExt;
      this.a.f.updateForTroopInfo(this.a.i, this.a.H.getCurrentAccountUin());
      if (this.a.r != this.a.f.troopTypeExt) {
        this.a.J.sendEmptyMessage(8);
      }
      if ((this.a.i != null) && (this.a.f.isMember))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ThreadManager.post(new TroopInfoActivity.23.1(this, this.a.i), 8, null, true);
      }
      this.a.J.post(new TroopInfoActivity.23.2(this));
      this.a.J.sendEmptyMessage(4);
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (!Utils.a(paramString, this.a.f.troopUin)) {
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
      paramString = ((ITroopInfoService)this.a.H.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(paramString);
      if (paramString != null)
      {
        localObject = this.a;
        ((TroopInfoActivity)localObject).i = paramString;
        ((TroopInfoActivity)localObject).f.updateForTroopInfo(paramString, this.a.H.getCurrentAccountUin());
        this.a.J.sendEmptyMessage(4);
      }
    }
  }
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.f != null) && (!TextUtils.isEmpty(this.a.f.troopUin)) && (this.a.f.troopUin.equals(paramString1)))
    {
      if (this.a.i != null) {
        this.a.i.mTags = paramString2;
      }
      this.a.f.troopTags = TroopInfo.getTags(paramString2);
      this.a.J.sendEmptyMessage(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.23
 * JD-Core Version:    0.7.0.1
 */