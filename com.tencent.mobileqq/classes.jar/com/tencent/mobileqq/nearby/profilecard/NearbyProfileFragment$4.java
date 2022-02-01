package com.tencent.mobileqq.nearby.profilecard;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopGiftCallback;

class NearbyProfileFragment$4
  extends TroopGiftCallback
{
  NearbyProfileFragment$4(NearbyProfileFragment paramNearbyProfileFragment) {}
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      NearbyProfileFragment.a(this.a).setText(String.format(HardCodeUtil.a(2131707334), new Object[] { Long.valueOf(paramLong) }));
      return;
    }
    NearbyProfileFragment.a(this.a).setText(HardCodeUtil.a(2131707296));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileFragment.4
 * JD-Core Version:    0.7.0.1
 */