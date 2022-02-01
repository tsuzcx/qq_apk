package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.view.View;
import com.tencent.mobileqq.qqpay.ui.R.id;

class DrawHbFragment$6
  implements ChooseItemView.OnVisibilityChangeListener
{
  DrawHbFragment$6(DrawHbFragment paramDrawHbFragment, View paramView) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.findViewById(R.id.aw).setVisibility(8);
      return;
    }
    this.a.findViewById(R.id.aw).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawHbFragment.6
 * JD-Core Version:    0.7.0.1
 */