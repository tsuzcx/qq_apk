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
      NearbyProfileDisplayTribePanel.k(this.a).setText(String.format(HardCodeUtil.a(2131905132), new Object[] { Long.valueOf(paramLong) }));
      return;
    }
    NearbyProfileDisplayTribePanel.k(this.a).setText(HardCodeUtil.a(2131905223));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.12
 * JD-Core Version:    0.7.0.1
 */