package com.tencent.mobileqq.nearby.gift;

import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopGiftPanelForNearby$1
  extends TroopGiftCallback
{
  TroopGiftPanelForNearby$1(TroopGiftPanelForNearby paramTroopGiftPanelForNearby) {}
  
  public void a(int paramInt)
  {
    String str = this.a.getTroopUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TroopGiftPanelForNearby.a(this.a));
    localStringBuilder.append("");
    NearbyFlowerManager.a("gift_store", "suc_one", str, localStringBuilder.toString(), "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetThrowGiftResult() onError errorCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", errorMsg = ");
      localStringBuilder.append(paramString);
      QLog.d("zivonchen", 2, localStringBuilder.toString());
    }
    if (paramInt == 20007) {
      QQToast.makeText(TroopGiftPanelForNearby.b(this.a), HardCodeUtil.a(2131912687), 0).show(this.a.getResources().getDimensionPixelSize(2131299920));
    } else {
      QQToast.makeText(TroopGiftPanelForNearby.c(this.a), HardCodeUtil.a(2131912684), 0).show(this.a.getResources().getDimensionPixelSize(2131299920));
    }
    paramString = this.a.getTroopUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TroopGiftPanelForNearby.d(this.a));
    localStringBuilder.append("");
    NearbyFlowerManager.a("gift_store", "fail_one", paramString, localStringBuilder.toString(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby.1
 * JD-Core Version:    0.7.0.1
 */