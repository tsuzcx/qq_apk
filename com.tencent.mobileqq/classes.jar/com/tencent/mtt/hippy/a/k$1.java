package com.tencent.mtt.hippy.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class k$1
  implements DialogInterface.OnClickListener
{
  k$1(k paramk, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      k.a(this.b).a(true ^ this.a);
      this.b.b();
      return;
    }
    this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.a.k.1
 * JD-Core Version:    0.7.0.1
 */