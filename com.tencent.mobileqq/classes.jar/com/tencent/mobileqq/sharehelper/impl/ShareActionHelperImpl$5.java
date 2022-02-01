package com.tencent.mobileqq.sharehelper.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ShareActionHelperImpl$5
  implements Runnable
{
  ShareActionHelperImpl$5(ShareActionHelperImpl paramShareActionHelperImpl, String paramString1, int paramInt, QQProgressDialog paramQQProgressDialog, Map paramMap, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.this$0.dispatchBeforeSharePicToWX(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str = this.b;
    int i;
    if (this.jdField_a_of_type_Int == 9) {
      i = 0;
    } else {
      i = 1;
    }
    localWXShareHelper.a(str, (Bitmap)localObject, i, false, this.c);
    QLog.d("ShareActionHelperImpl", 1, "shareToWeChat success");
    this.this$0.dispatchAfterSharePicToWX(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.5
 * JD-Core Version:    0.7.0.1
 */