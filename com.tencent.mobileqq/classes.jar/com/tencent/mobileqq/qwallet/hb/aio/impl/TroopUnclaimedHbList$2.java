package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;

class TroopUnclaimedHbList$2
  implements View.OnClickListener
{
  TroopUnclaimedHbList$2(TroopUnclaimedHbList paramTroopUnclaimedHbList) {}
  
  public void onClick(View paramView)
  {
    TroopUnclaimedHbList.a(this.a, true);
    if (TroopUnclaimedHbList.a(this.a) != null) {
      QWalletTools.a(TroopUnclaimedHbList.a(this.a), TroopUnclaimedHbList.a(this.a).getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.back", "", "");
    }
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.2
 * JD-Core Version:    0.7.0.1
 */