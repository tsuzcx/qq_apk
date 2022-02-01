package com.tencent.open.agent;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AuthorityControlFragment$1
  implements View.OnTouchListener
{
  AuthorityControlFragment$1(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3)) {
        paramView.setAlpha(1.0F);
      }
    }
    else {
      paramView.setAlpha(0.5F);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlFragment.1
 * JD-Core Version:    0.7.0.1
 */