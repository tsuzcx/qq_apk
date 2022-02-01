package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.widget.PopupWindow;

class TroopUnclaimedHbList$HbListItem$1
  implements QQWalletHbItemApiImpl.HbItemClickListener
{
  TroopUnclaimedHbList$HbListItem$1(TroopUnclaimedHbList.HbListItem paramHbListItem) {}
  
  public void a(int paramInt)
  {
    if (((paramInt == 1) || (paramInt == 10) || (paramInt == 15)) && (this.a.f.a != null)) {
      this.a.f.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.HbListItem.1
 * JD-Core Version:    0.7.0.1
 */