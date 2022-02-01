package com.tencent.mobileqq.mini.share;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

final class MiniProgramOpenSdkUtil$2
  implements Runnable
{
  MiniProgramOpenSdkUtil$2(MiniProgramOpenSdkUtil.TimeOutInfo paramTimeOutInfo, Context paramContext) {}
  
  public void run()
  {
    MiniProgramOpenSdkUtil.TimeOutInfo localTimeOutInfo = this.val$outInfo;
    localTimeOutInfo.isTimeout = true;
    try
    {
      if ((localTimeOutInfo.progressDialog != null) && (this.val$outInfo.progressDialog.isShowing())) {
        this.val$outInfo.progressDialog.dismiss();
      }
      QQToast.a(this.val$context, HardCodeUtil.a(2131692110), 0).b(this.val$context.getResources().getDimensionPixelSize(2131299168));
      MiniProgramOpenSdkUtil.access$100(this.val$context);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forwardShare timeoutRunnable has Exception");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("MiniProgramOpenSdkUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil.2
 * JD-Core Version:    0.7.0.1
 */