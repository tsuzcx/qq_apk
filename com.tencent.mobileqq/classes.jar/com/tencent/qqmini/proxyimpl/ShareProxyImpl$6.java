package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqmini.sdk.launcher.model.InnerShareData;

class ShareProxyImpl$6
  implements Runnable
{
  ShareProxyImpl$6(ShareProxyImpl paramShareProxyImpl, Activity paramActivity, InnerShareData paramInnerShareData) {}
  
  public void run()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity);
    localQQProgressDialog.a(HardCodeUtil.a(2131702774));
    localQQProgressDialog.show();
    ThreadManager.excute(new ShareProxyImpl.6.1(this, localQQProgressDialog), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.6
 * JD-Core Version:    0.7.0.1
 */