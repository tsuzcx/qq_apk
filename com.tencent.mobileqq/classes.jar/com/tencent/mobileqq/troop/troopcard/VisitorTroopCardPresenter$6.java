package com.tencent.mobileqq.troop.troopcard;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

class VisitorTroopCardPresenter$6
  extends TroopMngObserver
{
  VisitorTroopCardPresenter$6(VisitorTroopCardPresenter paramVisitorTroopCardPresenter) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      if (VisitorTroopCardPresenter.a(this.a) != null) {
        bool = true;
      }
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerFailed. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (VisitorTroopCardPresenter.a(this.a) != null)
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      VisitorTroopCardPresenter.a(this.a).a(paramInt1, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      boolean bool = false;
      String str;
      if (TextUtils.isEmpty(paramString)) {
        str = "";
      } else {
        str = paramString;
      }
      if (VisitorTroopCardPresenter.a(this.a) != null) {
        bool = true;
      }
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, new Object[] { "onTroopManagerSuccess. reqType=", Integer.valueOf(paramInt1), ", result=", Integer.valueOf(paramInt2), ", troopUin=", str, ", hasTroopInfoData=", Boolean.valueOf(bool) });
    }
    if (VisitorTroopCardPresenter.a(this.a) != null)
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      VisitorTroopCardPresenter.a(this.a).a(paramInt1, paramInt2, paramString);
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("onGetAddTroopWebInfo url=%s", new Object[] { paramString }));
    }
    if (VisitorTroopCardPresenter.a(this.a) == null) {
      return;
    }
    VisitorTroopCardPresenter.a(this.a).d(paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (VisitorTroopCardPresenter.a(this.a) != null)
    {
      if (VisitorTroopCardPresenter.a(this.a) == null) {
        return;
      }
      VisitorTroopCardPresenter.a(this.a).a(paramBoolean, paramLong, paramTroopInfo);
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTroopRankSwitchUpdate. troopUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isSucc = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", tId");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",time = ");
      localStringBuilder.append(paramLong);
      QLog.d("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, localStringBuilder.toString());
    }
    if ((VisitorTroopCardPresenter.a(this.a) != null) && (!TextUtils.isEmpty(VisitorTroopCardPresenter.a(this.a).troopUin)) && (!TextUtils.isEmpty(paramString)) && (VisitorTroopCardPresenter.a(this.a).troopUin.equals(paramString)))
    {
      if (paramBoolean) {
        return;
      }
      VisitorTroopCardPresenter.a(this.a).a(paramBoolean, paramString, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardPresenter.6
 * JD-Core Version:    0.7.0.1
 */