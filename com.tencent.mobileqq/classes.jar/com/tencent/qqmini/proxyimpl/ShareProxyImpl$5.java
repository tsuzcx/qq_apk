package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

class ShareProxyImpl$5
  implements Runnable
{
  ShareProxyImpl$5(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, InnerShareData paramInnerShareData) {}
  
  public void run()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.a);
    localQQProgressDialog.a(HardCodeUtil.a(2131900884));
    localQQProgressDialog.show();
    ThreadManager.excute(new ShareProxyImpl.5.1(this, localQQProgressDialog), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.5
 * JD-Core Version:    0.7.0.1
 */