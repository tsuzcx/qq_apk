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
    if (TroopUnclaimedHbList.b(this.a) != null) {
      TroopUnclaimedHbList.b(this.a).setVisibility(8);
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (TroopUnclaimedHbList.e(this.a) != null) {
        TroopUnclaimedHbList.e(this.a).setVisibility(0);
      }
      if (TroopUnclaimedHbList.f(this.a) != null) {
        TroopUnclaimedHbList.f(this.a).setVisibility(8);
      }
      if (TroopUnclaimedHbList.c(this.a) != null) {
        TroopUnclaimedHbList.c(this.a).a(paramList);
      }
      if (TroopUnclaimedHbList.g(this.a) != null) {
        TroopUnclaimedHbList.g(this.a).start();
      }
    }
    else
    {
      if (TroopUnclaimedHbList.e(this.a) != null) {
        TroopUnclaimedHbList.e(this.a).setVisibility(8);
      }
      if (TroopUnclaimedHbList.f(this.a) != null)
      {
        TroopUnclaimedHbList.f(this.a).setVisibility(0);
        TroopUnclaimedHbList.f(this.a).setText(HardCodeUtil.a(R.string.dk));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.6
 * JD-Core Version:    0.7.0.1
 */