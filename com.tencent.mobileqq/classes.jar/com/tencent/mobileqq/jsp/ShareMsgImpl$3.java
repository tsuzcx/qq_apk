package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class ShareMsgImpl$3
  implements Runnable
{
  ShareMsgImpl$3(ShareMsgImpl paramShareMsgImpl, String paramString1, String paramString2, int paramInt, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    int j = 0;
    int i = 0;
    Object localObject = this.this$0.jdField_a_of_type_AndroidAppActivity;
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.this$0.a((Activity)localObject);
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener == null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener = new ShareMsgImpl.3.1(this);
      WXShareHelper.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$WXShareListener);
    }
    if ((this.jdField_a_of_type_Int == 1) && (this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener == null))
    {
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener = new ShareMsgImpl.3.2(this);
      WxShareHelperFromReadInjoy.a().a(this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
    }
    this.this$0.b = String.valueOf(System.currentTimeMillis());
    localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if ("audio".equals(this.c))
    {
      localWXShareHelper = WXShareHelper.a();
      str1 = this.this$0.b;
      str2 = this.d;
      str3 = this.e;
      str4 = this.b;
      if ("2".equals(this.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        localWXShareHelper.a(str1, str2, (Bitmap)localObject, str3, str4, i, this.f);
        return;
        i = 1;
      }
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      this.this$0.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new ShareMsgImpl.3.3(this, (Bitmap)localObject));
      return;
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    String str1 = this.this$0.b;
    String str2 = this.d;
    String str3 = this.e;
    String str4 = this.b;
    if ("2".equals(this.jdField_a_of_type_JavaLangString)) {}
    for (i = j;; i = 1)
    {
      localWXShareHelper.b(str1, str2, (Bitmap)localObject, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.3
 * JD-Core Version:    0.7.0.1
 */