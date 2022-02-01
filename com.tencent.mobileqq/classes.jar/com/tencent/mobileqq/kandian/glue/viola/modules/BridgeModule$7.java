package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class BridgeModule$7
  implements DialogInterface.OnCancelListener
{
  BridgeModule$7(BridgeModule paramBridgeModule, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    int i = this.a;
    if ((i == 4) || (i == 11)) {
      this.h.reportVideoShareClick(this.b, this.c, this.d, -1, -1, true, this.a, this.e, this.f, this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.7
 * JD-Core Version:    0.7.0.1
 */