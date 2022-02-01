package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IRedPacketManager;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import java.util.List;

class TroopUnclaimedHbList$5
  implements PopupWindow.OnDismissListener
{
  TroopUnclaimedHbList$5(TroopUnclaimedHbList paramTroopUnclaimedHbList) {}
  
  public void onDismiss()
  {
    ((IRedPacketManager)QRoute.api(IRedPacketManager.class)).onActiveAccount();
    if ((TroopUnclaimedHbList.c(this.a) != null) && (TroopUnclaimedHbList.HbListAdapter.a(TroopUnclaimedHbList.c(this.a)) != null))
    {
      TroopUnclaimedHbList.HbListAdapter.a(TroopUnclaimedHbList.c(this.a)).clear();
      TroopUnclaimedHbList.c(this.a).notifyDataSetChanged();
    }
    if ((!TroopUnclaimedHbList.d(this.a)) && (TroopUnclaimedHbList.a(this.a) != null)) {
      QWalletTools.a(TroopUnclaimedHbList.a(this.a), TroopUnclaimedHbList.a(this.a).getCurrentAccountUin(), 2, "", 0L, 162, "aio.hongbaolist.keyback", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.5
 * JD-Core Version:    0.7.0.1
 */