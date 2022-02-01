package com.tencent.mobileqq.qwallet.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class QWalletTools$5
  implements View.OnTouchListener
{
  private float b = 1.0F;
  
  QWalletTools$5(float paramFloat) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.b = paramView.getAlpha();
      paramView.setAlpha(this.a);
    }
    else if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3))
    {
      if (paramMotionEvent.getAction() == 2)
      {
        int i = (int)paramMotionEvent.getRawX();
        int j = (int)paramMotionEvent.getRawY();
        if (!QWalletTools.a(paramView, i, j)) {
          paramView.setAlpha(1.0F);
        }
      }
    }
    else
    {
      paramView.setAlpha(this.b);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletTools.5
 * JD-Core Version:    0.7.0.1
 */