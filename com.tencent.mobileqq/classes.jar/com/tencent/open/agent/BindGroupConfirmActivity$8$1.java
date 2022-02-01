package com.tencent.open.agent;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class BindGroupConfirmActivity$8$1
  implements DialogInterface.OnClickListener
{
  BindGroupConfirmActivity$8$1(BindGroupConfirmActivity.8 param8) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.a.this$0.u.cancel();
      this.a.this$0.finish();
      return;
    }
    try
    {
      ForwardSdkShareOption.a(this.a.this$0, true, "action_game_bind_group", Long.valueOf(this.a.this$0.n).longValue(), -1, this.a.a);
    }
    catch (Exception paramDialogInterface)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAlertDlg error = ");
      localStringBuilder.append(paramDialogInterface);
      QLog.e("BindGroupConfirmActivity", 1, localStringBuilder.toString());
    }
    this.a.this$0.u.cancel();
    BindGroupConfirmActivity.a(this.a.this$0, -1);
    BindGroupConfirmActivity.a(this.a.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.8.1
 * JD-Core Version:    0.7.0.1
 */