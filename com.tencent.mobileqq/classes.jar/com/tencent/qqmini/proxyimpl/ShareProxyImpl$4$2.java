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
    long l = this.jdField_a_of_type_Long;
    if ((l != -100070004L) && (l != -1000710003L))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$4.a, 1, 2131694174, 1).a();
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$4.a, 233, this.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$4.a.getString(2131719012), this.jdField_a_of_type_JavaLangString, new ShareProxyImpl.4.2.1(this), null).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.4.2
 * JD-Core Version:    0.7.0.1
 */