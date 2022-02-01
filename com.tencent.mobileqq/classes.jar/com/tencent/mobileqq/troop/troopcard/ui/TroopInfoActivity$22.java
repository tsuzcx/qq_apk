package com.tencent.mobileqq.troop.troopcard.ui;

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
    if (!Utils.a(this.a.f.troopUin, String.valueOf(paramLong))) {
      return;
    }
    if ((this.a.j != null) && (this.a.j.contains(Integer.valueOf(paramInt))))
    {
      this.a.j.remove(Integer.valueOf(paramInt));
      if (paramTroopInfo != null) {
        this.a.i = paramTroopInfo;
      }
      if (paramBoolean)
      {
        this.a.a(2131890940, 2);
        return;
      }
      this.a.a(2131890939, 1);
      TroopInfoActivity.a(this.a, paramInt);
      return;
    }
    if ((paramBoolean) && (paramTroopInfo != null))
    {
      TroopInfoActivity localTroopInfoActivity = this.a;
      localTroopInfoActivity.i = paramTroopInfo;
      if ((localTroopInfoActivity.j == null) || (this.a.j.size() == 0))
      {
        this.a.f.updateForTroopInfo(paramTroopInfo, this.a.H.getCurrentAccountUin());
        this.a.J.sendEmptyMessage(4);
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString)
  {
    if ((this.a.i != null) && (paramBoolean))
    {
      if (this.a.f.troopTypeExt == 2) {
        this.a.i.troopTypeExt = 3;
      } else {
        this.a.i.troopTypeExt = this.a.f.troopTypeExt;
      }
      localObject = (ITroopInfoService)this.a.H.getRuntimeService(ITroopInfoService.class, "");
      TroopInfo localTroopInfo = ((ITroopInfoService)localObject).getTroopInfo(this.a.f.troopUin);
      if (localTroopInfo != null)
      {
        localTroopInfo.troopname = this.a.f.troopName;
        localTroopInfo.dwGroupClassExt = this.a.f.dwGroupClassExt;
        localTroopInfo.mGroupClassExtText = this.a.f.mTroopClassExtText;
        localTroopInfo.mRichFingerMemo = this.a.f.mRichFingerMemo;
        localTroopInfo.hasSetNewTroopName = this.a.f.hasSetNewTroopName;
        localTroopInfo.strLocation = this.a.f.troopLocation;
        localTroopInfo.troopLat = this.a.f.troopLat;
        localTroopInfo.troopLon = this.a.f.troopLon;
        localTroopInfo.location = this.a.f.location;
        localTroopInfo.grade = this.a.f.grade;
        localTroopInfo.school = this.a.f.school;
        if ((this.a.f.troopTags != null) && (this.a.f.troopTags.size() > 0))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Iterator localIterator = this.a.f.troopTags.iterator();
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
    if ((this.a.r == 0) || (1 == this.a.r)) {
      ReportController.b(this.a.H, "P_CliOper", "Grp_create", "", "edit_data", "ordinary_suc", 0, 0, this.a.f.troopUin, this.a.A, "", "");
    }
    Object localObject = this.a;
    TroopInfoActivity.a((TroopInfoActivity)localObject, paramBoolean, paramLong, paramString, 0L, ((TroopInfoActivity)localObject).f.dwGroupClassExt);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super.a(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.f.troopUin, paramString1))
    {
      this.a.r();
      if (paramBoolean)
      {
        this.a.f.hasSetNewTroopName = true;
        this.a.f.troopName = paramString2;
        if ((!this.a.f.isNewTroop) || (this.a.f.hasSetNewTroopName)) {
          this.a.f.newTroopName = paramString2;
        }
        this.a.d();
        this.a.f.hasSetNewTroopName = true;
        if (this.a.f.hasSetNewTroopHead) {
          this.a.f.isNewTroop = false;
        }
        if (this.a.i != null)
        {
          this.a.i.troopname = this.a.f.troopName;
          this.a.i.hasSetNewTroopName = this.a.f.hasSetNewTroopName;
          this.a.i.isNewTroop = this.a.f.isNewTroop;
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.a.i, this.a.H, this.a.f.isMember);
        }
      }
      else
      {
        paramString1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString1 = HardCodeUtil.a(2131899973);
        }
        QQToast.makeText(this.a, 1, paramString1, 0).show(this.a.getTitleBarHeight());
        if (this.a.i != null)
        {
          this.a.f.troopName = this.a.i.getTroopDisplayName();
          this.a.d();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopinfo", 2, paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.22
 * JD-Core Version:    0.7.0.1
 */