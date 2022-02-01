package com.tencent.mobileqq.richstatus;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class SignatureHistoryFragment$14
  implements View.OnTouchListener
{
  SignatureHistoryFragment$14(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getY() < paramView.findViewById(2131379883).getHeight() + AIOUtils.b(30.0F, paramView.getResources()))
      {
        SignatureHistoryFragment.a(this.a, true);
        return false;
      }
      SignatureHistoryFragment.a(this.a, false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.14
 * JD-Core Version:    0.7.0.1
 */