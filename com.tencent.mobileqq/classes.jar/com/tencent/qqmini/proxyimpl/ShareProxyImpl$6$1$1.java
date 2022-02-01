package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ShareProxyImpl$6$1$1
  implements URLDrawable.URLDrawableListener
{
  ShareProxyImpl$6$1$1(ShareProxyImpl.6.1 param1) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("ShareProxyImpl", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getFileInLocal();
    if ((paramURLDrawable != null) && (paramURLDrawable.exists())) {}
    for (int i = 1;; i = 0)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      if (i == 0) {
        QQToast.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$6.jdField_a_of_type_AndroidAppActivity, 1, HardCodeUtil.a(2131702776), 1).b(this.a.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$6.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299166));
      }
      if (i == 0) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$6.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.isLocalPic = true;
      this.a.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$6.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData.sharePicPath = paramURLDrawable.getPath();
      ShareProxyImpl.a(this.a.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$6.this$0, this.a.jdField_a_of_type_ComTencentQqminiProxyimplShareProxyImpl$6.jdField_a_of_type_ComTencentQqminiSdkLauncherModelInnerShareData);
      return;
    }
    QLog.e("ShareProxyImpl", 1, "shareNetworkPicMessage failed, because of picture downloadFailed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareProxyImpl.6.1.1
 * JD-Core Version:    0.7.0.1
 */