package com.tencent.msfmqpsdkbridge;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;

class MSFIntChkStrike$4
  implements Runnable
{
  MSFIntChkStrike$4(MSFIntChkStrike paramMSFIntChkStrike, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, String paramString3, String paramString4, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    try
    {
      bhpc localbhpc = bhlq.a(BaseActivity.sTopActivity, 230, this.val$fstrTitle, this.val$fstrWording, this.val$fonConfirm, this.val$fonCancel);
      if (localbhpc == null) {
        return;
      }
      localbhpc.setNegativeButton(this.val$fstrCancelText, this.val$fonCancel);
      localbhpc.setPositiveButton(this.val$fstrConfirmText, this.val$fonConfirm);
      localbhpc.setOnDismissListener(this.val$fonDismissListener);
      localbhpc.setCancelable(false);
      localbhpc.show();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    MSFIntChkStrike.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike.4
 * JD-Core Version:    0.7.0.1
 */