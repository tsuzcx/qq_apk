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
      this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ap).setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(R.id.ap).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawHbFragment.6
 * JD-Core Version:    0.7.0.1
 */