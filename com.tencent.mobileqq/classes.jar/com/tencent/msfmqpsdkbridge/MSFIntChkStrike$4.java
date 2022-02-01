package com.tencent.msfmqpsdkbridge;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

class MSFIntChkStrike$4
  implements Runnable
{
  MSFIntChkStrike$4(MSFIntChkStrike paramMSFIntChkStrike, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, String paramString3, String paramString4, DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void run()
  {
    try
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseActivity.sTopActivity, 230, this.val$fstrTitle, this.val$fstrWording, this.val$fonConfirm, this.val$fonCancel);
      if (localQQCustomDialog == null) {
        return;
      }
      localQQCustomDialog.setNegativeButton(this.val$fstrCancelText, this.val$fonCancel);
      localQQCustomDialog.setPositiveButton(this.val$fstrConfirmText, this.val$fonConfirm);
      localQQCustomDialog.setOnDismissListener(this.val$fonDismissListener);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.show();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    MSFIntChkStrike.access$102(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFIntChkStrike.4
 * JD-Core Version:    0.7.0.1
 */