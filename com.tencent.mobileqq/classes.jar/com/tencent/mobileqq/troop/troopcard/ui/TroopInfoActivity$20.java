package com.tencent.mobileqq.troop.troopcard.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.observer.TempFriendListObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$20
  extends TempFriendListObserver
{
  TroopInfoActivity$20(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      if (!Utils.a(paramString, this.a.f.troopowneruin)) {
        return;
      }
      this.a.h = false;
      String str = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getFriendDisplayName(this.a.H, this.a.f.troopowneruin);
      if (!TextUtils.isEmpty(str))
      {
        this.a.f.troopOwnerNick = str;
        this.a.J.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateFriendInfo|uin = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", tmpNickName = ");
        localStringBuilder.append(str);
        QLog.i("Q.troopinfo", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 3) {
      a((String)paramObject, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.20
 * JD-Core Version:    0.7.0.1
 */