package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.ResultReceiver;

class ForwardChooseFriendOption$1
  implements DialogInterface.OnClickListener
{
  ForwardChooseFriendOption$1(ForwardChooseFriendOption paramForwardChooseFriendOption, int paramInt, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.c.a != null)
    {
      paramDialogInterface = this.c.b(this.a, this.b);
      this.c.a.send(0, paramDialogInterface);
    }
    if (this.c.s != null)
    {
      this.c.s.setResult(1);
      this.c.s.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardChooseFriendOption.1
 * JD-Core Version:    0.7.0.1
 */