package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

class TroopUnclaimedHbList$1
  implements View.OnClickListener
{
  TroopUnclaimedHbList$1(TroopUnclaimedHbList paramTroopUnclaimedHbList) {}
  
  public void onClick(View paramView)
  {
    TroopUnclaimedHbList.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.TroopUnclaimedHbList.1
 * JD-Core Version:    0.7.0.1
 */