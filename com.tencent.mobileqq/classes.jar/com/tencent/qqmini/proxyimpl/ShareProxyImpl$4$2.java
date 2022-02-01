package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;

class ShareProxyImpl$4$2
  implements Runnable
{
  ShareProxyImpl$4$2(ShareProxyImpl.4 param4, long paramLong, String paramString) {}
  
  public void run()
  {
    long l = this.a;
    if ((l != -100070004L) && (l != -1000710003L))
    {
      QQToast.makeText(this.c.a, 1, 2131891804, 1).show();
      return;
    }
    DialogUtil.a(this.c.a, 233, this.c.a.getString(2131916547), this.b, new ShareProxyImpl.4.2.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.2
 * JD-Core Version:    0.7.0.1
 */