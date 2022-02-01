package com.tencent.mobileqq.richstatus;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class SignatureHistoryFragment$10
  implements View.OnTouchListener
{
  SignatureHistoryFragment$10(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getY() < paramView.findViewById(2131380602).getHeight() + AIOUtils.a(30.0F, paramView.getResources())) {
        SignatureHistoryFragment.a(this.a, true);
      }
    }
    else {
      return false;
    }
    SignatureHistoryFragment.a(this.a, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.10
 * JD-Core Version:    0.7.0.1
 */