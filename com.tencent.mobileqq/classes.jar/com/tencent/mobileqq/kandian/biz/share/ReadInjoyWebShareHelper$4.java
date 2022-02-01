package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.kandian.biz.detail.web.IReadInJoyWebViewPlugin;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

class ReadInjoyWebShareHelper$4
  implements Runnable
{
  ReadInjoyWebShareHelper$4(ReadInjoyWebShareHelper paramReadInjoyWebShareHelper, boolean paramBoolean1, Map paramMap, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    Object localObject = ReadInjoyWebShareHelper.a(this.this$0).a();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      ReadInjoyWebShareHelper.c(this.this$0);
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener == null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener = new ReadInjoyWebShareHelper.4.1(this);
        ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).addObserver(this.this$0.jdField_a_of_type_ComTencentMobileqqKandianBizShareApiIWxShareHelperFromReadInjoy$WXShareHelperFromReadInjoyListener);
      }
      this.this$0.jdField_a_of_type_JavaLangString = String.valueOf(System.currentTimeMillis());
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
      {
        ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareToMiniProgramWithPath(this.this$0.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.jdField_b_of_type_JavaLangString, this.c, this.d);
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new ReadInjoyWebShareHelper.4.2(this, (Bitmap)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInjoyWebShareHelper.4
 * JD-Core Version:    0.7.0.1
 */