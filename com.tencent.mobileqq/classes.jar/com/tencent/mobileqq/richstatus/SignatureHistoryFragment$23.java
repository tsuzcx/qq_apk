package com.tencent.mobileqq.richstatus;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class SignatureHistoryFragment$23
  implements View.OnLayoutChangeListener
{
  SignatureHistoryFragment$23(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt2 < paramInt6) && (this.a.c != null))
    {
      paramView = this.a;
      paramInt1 = SignatureHistoryFragment.b(paramView, paramView.c);
      paramInt3 = this.a.c.getHeight();
      if (paramInt1 + paramInt3 > paramInt2) {
        SignatureHistoryFragment.a(this.a, paramInt1, paramInt3, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.23
 * JD-Core Version:    0.7.0.1
 */