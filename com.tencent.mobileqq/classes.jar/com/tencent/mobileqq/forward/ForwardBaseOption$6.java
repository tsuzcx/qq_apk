package com.tencent.mobileqq.forward;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ForwardBaseOption$6
  implements DialogInterface.OnClickListener
{
  ForwardBaseOption$6(ForwardBaseOption paramForwardBaseOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1) {
        return;
      }
      this.a.q();
      return;
    }
    this.a.p();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardBaseOption.6
 * JD-Core Version:    0.7.0.1
 */