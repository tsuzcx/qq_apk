package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class ShareMsgImpl$3
  implements Runnable
{
  ShareMsgImpl$3(ShareMsgImpl paramShareMsgImpl, String paramString1, String paramString2, int paramInt, Map paramMap, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_AndroidAppActivity;
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
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
      if ((this.jdField_a_of_type_Int == 1) && (this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener == null))
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener = new ShareMsgImpl.3.2(this);
        ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).addObserver(this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
      }
      this.this$0.b = String.valueOf(System.currentTimeMillis());
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
      if ("audio".equals(this.c))
      {
        WXShareHelper.a().a(this.this$0.b, this.d, (Bitmap)localObject, this.e, this.b, "2".equals(this.jdField_a_of_type_JavaLangString) ^ true, this.f);
        return;
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        this.this$0.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new ShareMsgImpl.3.3(this, (Bitmap)localObject));
        return;
      }
      WXShareHelper.a().a(this.this$0.b, this.d, (Bitmap)localObject, this.e, this.b, "2".equals(this.jdField_a_of_type_JavaLangString) ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.3
 * JD-Core Version:    0.7.0.1
 */