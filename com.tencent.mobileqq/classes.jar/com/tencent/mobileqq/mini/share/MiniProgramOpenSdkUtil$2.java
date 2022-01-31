package com.tencent.mobileqq.mini.share;

import alpo;
import android.content.Context;
import android.content.res.Resources;
import bepp;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

final class MiniProgramOpenSdkUtil$2
  implements Runnable
{
  MiniProgramOpenSdkUtil$2(MiniProgramOpenSdkUtil.TimeOutInfo paramTimeOutInfo, Context paramContext) {}
  
  public void run()
  {
    this.val$outInfo.isTimeout = true;
    try
    {
      if ((this.val$outInfo.progressDialog != null) && (this.val$outInfo.progressDialog.isShowing())) {
        this.val$outInfo.progressDialog.dismiss();
      }
      QQToast.a(this.val$context, alpo.a(2131692307), 0).b(this.val$context.getResources().getDimensionPixelSize(2131298914));
      if (((this.val$context instanceof JumpActivity)) && (!((JumpActivity)this.val$context).isFinishing())) {
        MiniProgramOpenSdkUtil.access$100(this.val$context);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniProgramOpenSdkUtil", 1, "forwardShare timeoutRunnable has Exception" + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.2
 * JD-Core Version:    0.7.0.1
 */