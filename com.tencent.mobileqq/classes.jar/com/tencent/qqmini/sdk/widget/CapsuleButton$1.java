package com.tencent.qqmini.sdk.widget;

import android.widget.TextView;
import com.tencent.qqmini.sdk.core.utils.CustomWidgetUtil;

class CapsuleButton$1
  implements Runnable
{
  CapsuleButton$1(CapsuleButton paramCapsuleButton) {}
  
  public void run()
  {
    if ((CapsuleButton.access$000() > 0) && (CapsuleButton.access$100(this.this$0) != null))
    {
      CapsuleButton.access$200(this.this$0).setVisibility(0);
      CustomWidgetUtil.updateCustomNoteTxt(CapsuleButton.access$200(this.this$0), 7, CapsuleButton.access$000(), 0);
      return;
    }
    CapsuleButton.access$200(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.CapsuleButton.1
 * JD-Core Version:    0.7.0.1
 */