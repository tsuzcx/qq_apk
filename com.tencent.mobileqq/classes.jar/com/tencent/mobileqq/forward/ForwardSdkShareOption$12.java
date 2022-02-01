package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DirectForwardActivity;

class ForwardSdkShareOption$12
  implements DialogInterface.OnDismissListener
{
  ForwardSdkShareOption$12(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.a.a instanceof DirectForwardActivity)) {
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.12
 * JD-Core Version:    0.7.0.1
 */