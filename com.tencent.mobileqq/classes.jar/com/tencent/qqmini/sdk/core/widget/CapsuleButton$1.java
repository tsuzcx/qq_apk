package com.tencent.qqmini.sdk.core.widget;

import android.widget.TextView;
import bgkm;

class CapsuleButton$1
  implements Runnable
{
  CapsuleButton$1(CapsuleButton paramCapsuleButton) {}
  
  public void run()
  {
    if ((CapsuleButton.a() > 0) && (CapsuleButton.a(this.this$0) != null))
    {
      CapsuleButton.a(this.this$0).setVisibility(0);
      bgkm.a(CapsuleButton.a(this.this$0), 7, CapsuleButton.a(), 0);
      return;
    }
    CapsuleButton.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.CapsuleButton.1
 * JD-Core Version:    0.7.0.1
 */