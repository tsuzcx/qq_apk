package com.tencent.mobileqq.kandian.biz.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyWebShareHelper$4$2
  implements ITroopMemberApiClientApi.Callback
{
  ReadInjoyWebShareHelper$4$2(ReadInjoyWebShareHelper.4 param4, Bitmap paramBitmap) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("readinjoy_to_wx_config");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("config = ");
      paramBundle.append(i);
      QLog.d("WebShareHelper", 2, paramBundle.toString());
    }
    if (i == 0)
    {
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareWebPage(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.b, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.c, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.jdField_a_of_type_Boolean ^ true);
      return;
    }
    WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.b, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.c, this.jdField_a_of_type_ComTencentMobileqqKandianBizShareReadInjoyWebShareHelper$4.jdField_a_of_type_Boolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.4.2
 * JD-Core Version:    0.7.0.1
 */