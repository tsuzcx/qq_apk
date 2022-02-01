package com.tencent.mobileqq.richstatus;

import android.widget.RelativeLayout;
import com.tencent.widget.XListView;

class SignatureHistoryFragment$21
  implements Runnable
{
  SignatureHistoryFragment$21(SignatureHistoryFragment paramSignatureHistoryFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.a.smoothScrollBy(this.a - (this.b - this.c), 100);
    if (this.d) {
      SignatureHistoryFragment.m(this.this$0).addOnLayoutChangeListener(this.this$0.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureHistoryFragment.21
 * JD-Core Version:    0.7.0.1
 */