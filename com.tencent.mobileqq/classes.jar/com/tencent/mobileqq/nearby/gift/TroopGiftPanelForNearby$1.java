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
    NearbyFlowerManager.a("gift_store", "suc_one", this.a.a(), TroopGiftPanelForNearby.a(this.a) + "", "", "");
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onGetThrowGiftResult() onError errorCode = " + paramInt + ", errorMsg = " + paramString);
    }
    if (paramInt == 20007) {
      QQToast.a(TroopGiftPanelForNearby.a(this.a), HardCodeUtil.a(2131715281), 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
    }
    for (;;)
    {
      NearbyFlowerManager.a("gift_store", "fail_one", this.a.a(), TroopGiftPanelForNearby.b(this.a) + "", "", "");
      return;
      QQToast.a(TroopGiftPanelForNearby.b(this.a), HardCodeUtil.a(2131715278), 0).b(this.a.getResources().getDimensionPixelSize(2131299166));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby.1
 * JD-Core Version:    0.7.0.1
 */