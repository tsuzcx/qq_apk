package com.tencent.mobileqq.qwallet.hb.aio.impl;

import Wallet.RedPackGrapInfo;
import android.animation.Animator;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetAvailableListListener;
import java.util.List;

class TroopUnclaimedHbList$6
  implements IRedPacket.OnGetAvailableListListener
{
  TroopUnclaimedHbList$6(TroopUnclaimedHbList paramTroopUnclaimedHbList) {}
  
  public void OnGetAvailableList(List<RedPackGrapInfo> paramList)
  {
    if (TroopUnclaimedHbList.a(this.a) != null) {
      TroopUnclaimedHbList.a(this.a).setVisibility(8);
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (TroopUnclaimedHbList.a(this.a) != null) {
        TroopUnclaimedHbList.a(this.a).setVisibility(0);
      }
      if (TroopUnclaimedHbList.a(this.a) != null) {
        TroopUnclaimedHbList.a(this.a).setVisibility(8);
      }
      if (TroopUnclaimedHbList.a(this.a) != null) {
        TroopUnclaimedHbList.a(this.a).a(paramList);
      }
      if (TroopUnclaimedHbList.a(this.a) != null) {
        TroopUnclaimedHbList.a(this.a).start();
      }
    }
    else
    {
      if (TroopUnclaimedHbList.a(this.a) != null) {
        TroopUnclaimedHbList.a(this.a).setVisibility(8);
      }
      if (TroopUnclaimedHbList.a(this.a) != null)
      {
        TroopUnclaimedHbList.a(this.a).setVisibility(0);
        TroopUnclaimedHbList.a(this.a).setText(HardCodeUtil.a(R.string.dh));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.6
 * JD-Core Version:    0.7.0.1
 */