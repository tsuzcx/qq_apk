package com.tencent.mobileqq.microapp.sdk;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;

class MiniAppBridgeActivity$1
  implements DialogInterface.OnDismissListener
{
  MiniAppBridgeActivity$1(MiniAppBridgeActivity paramMiniAppBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (MiniAppBridgeActivity.access$000(this.this$0) != null) {
      return;
    }
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing())) {
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity.1
 * JD-Core Version:    0.7.0.1
 */