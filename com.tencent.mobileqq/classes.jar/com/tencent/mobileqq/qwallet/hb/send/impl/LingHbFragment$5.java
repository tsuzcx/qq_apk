package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.view.View;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView.OnVisibilityChangeListener;

class LingHbFragment$5
  implements ChooseItemView.OnVisibilityChangeListener
{
  LingHbFragment$5(LingHbFragment paramLingHbFragment) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.a.findViewById(R.id.aw).setVisibility(8);
      return;
    }
    this.a.a.findViewById(R.id.aw).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.LingHbFragment.5
 * JD-Core Version:    0.7.0.1
 */