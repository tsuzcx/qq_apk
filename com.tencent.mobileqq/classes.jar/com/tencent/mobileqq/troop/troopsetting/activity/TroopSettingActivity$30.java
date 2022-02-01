package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopSettingActivity$30
  extends TroopModifyObserver
{
  TroopSettingActivity$30(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (this.a.i == null) {
      return;
    }
    if (!Utils.a(this.a.i.troopUin, String.valueOf(paramLong))) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onModifyTroopInfo isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",mModifyList = ");
      ((StringBuilder)localObject).append(this.a.v);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.v != null) && (this.a.v.contains(Integer.valueOf(paramInt))))
    {
      this.a.v.remove(Integer.valueOf(paramInt));
      if (paramTroopInfo != null) {
        this.a.t = paramTroopInfo;
      }
      if (this.a.n == null)
      {
        paramTroopInfo = this.a;
        paramTroopInfo.n = new QQProgressNotifier(paramTroopInfo);
      }
      if (paramBoolean)
      {
        this.a.n.a(1, this.a.getString(2131890940), 1000);
        return;
      }
      this.a.n.a(2, this.a.getString(2131890939), 1000);
      TroopSettingActivity.c(this.a, paramInt);
      return;
    }
    if ((paramBoolean) && (paramTroopInfo != null))
    {
      localObject = this.a;
      ((TroopSettingActivity)localObject).t = paramTroopInfo;
      if ((((TroopSettingActivity)localObject).v == null) || (this.a.v.size() == 0))
      {
        this.a.i.updateForTroopInfo(paramTroopInfo, TroopSettingActivity.a(this.a).getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "onModifyTroopInfo send MSG_UPDATE_INFO msg");
        }
        this.a.aD.sendEmptyMessage(5);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.equals(this.a.i.troopUin, paramString)) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "onUpdateTroopSearchApproachPageTroopInfoUpdated ");
      }
      this.a.m();
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super.a(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.a.i.troopUin, paramString1))
    {
      this.a.o();
      if (paramBoolean)
      {
        this.a.i.hasSetNewTroopName = true;
        this.a.a(paramString2);
        if ((this.a.isResume()) && (this.a.J))
        {
          this.a.t.isNewTroop = false;
          paramString1 = this.a;
          paramString1.J = false;
          TroopSettingActivity.a(paramString1, paramString1.u ^ true, this.a.i.isNewTroop);
        }
      }
      else
      {
        if (paramInt == 1328) {
          TroopSettingActivity.r(this.a);
        }
        paramString1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          paramString1 = HardCodeUtil.a(2131899973);
        }
        QQToast.makeText(this.a, 1, paramString1, 0).show(this.a.getTitleBarHeight());
        if (this.a.t != null)
        {
          this.a.i.troopName = this.a.t.getTroopDisplayName();
          this.a.f();
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, paramString1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.30
 * JD-Core Version:    0.7.0.1
 */