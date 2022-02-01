package com.tencent.qqmini.proxyimpl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;

class X5UpdateGuard$3
  implements DialogInterface.OnClickListener
{
  X5UpdateGuard$3(X5UpdateGuard paramX5UpdateGuard, IMiniAppContext paramIMiniAppContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("minisdk_X5UpdateGuard", 2, "confirm");
    X5UpdateGuard.e(this.b).postDelayed(X5UpdateGuard.d(this.b), 15000L);
    QbSdk.setTbsListener(this.b);
    TbsDownloader.startDownload(this.a.getContext(), true);
    if (X5UpdateGuard.f(this.b) == null) {
      X5UpdateGuard.a(this.b, new X5UpdateGuard.LoadingDialog(this.a.getAttachedActivity()));
    }
    X5UpdateGuard.f(this.b).a(HardCodeUtil.a(2131903843));
    if (!X5UpdateGuard.f(this.b).isShowing()) {
      X5UpdateGuard.f(this.b).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.X5UpdateGuard.3
 * JD-Core Version:    0.7.0.1
 */