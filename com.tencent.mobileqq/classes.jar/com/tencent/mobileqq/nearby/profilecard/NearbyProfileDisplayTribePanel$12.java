package com.tencent.mobileqq.nearby.profilecard;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;

class NearbyProfileDisplayTribePanel$12
  extends TroopGiftCallback
{
  NearbyProfileDisplayTribePanel$12(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      NearbyProfileDisplayTribePanel.c(this.a).setText(String.format(HardCodeUtil.a(2131707307), new Object[] { Long.valueOf(paramLong) }));
      return;
    }
    NearbyProfileDisplayTribePanel.c(this.a).setText(HardCodeUtil.a(2131707405));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.12
 * JD-Core Version:    0.7.0.1
 */