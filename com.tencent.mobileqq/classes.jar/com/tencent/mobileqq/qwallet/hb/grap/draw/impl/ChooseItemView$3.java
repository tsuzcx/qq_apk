package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Collections;
import java.util.List;

class ChooseItemView$3
  implements View.OnClickListener
{
  ChooseItemView$3(ChooseItemView paramChooseItemView) {}
  
  public void onClick(View paramView)
  {
    if ((ChooseItemView.a(this.a) != null) && (ChooseItemView.a(this.a).size() > 1))
    {
      Collections.shuffle(ChooseItemView.a(this.a));
      this.a.a.a(ChooseItemView.b(this.a));
    }
    if (ChooseItemView.a(this.a) != null) {
      ChooseItemView.a(this.a).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.ChooseItemView.3
 * JD-Core Version:    0.7.0.1
 */