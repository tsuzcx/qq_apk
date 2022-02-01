package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;

class QShareUtils$1
  implements Runnable
{
  QShareUtils$1(QShareUtils paramQShareUtils, Map paramMap, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean2, int paramInt, String paramString6, String paramString7) {}
  
  public void run()
  {
    QShareUtils.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if (this.jdField_a_of_type_Boolean)
    {
      WxShareHelperFromReadInjoy.getInstance().shareToMiniProgramWithPathAndId(QShareUtils.a(this.this$0), this.jdField_a_of_type_JavaLangString, (Bitmap)localObject1, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.e);
      return;
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    int i = 0;
    if (bool)
    {
      localObject2 = (IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class);
      str1 = QShareUtils.a(this.this$0);
      str2 = this.jdField_a_of_type_JavaLangString;
      str3 = this.jdField_b_of_type_JavaLangString;
      str4 = this.c;
      if (this.jdField_a_of_type_Int == 9) {
        i = 0;
      } else {
        i = 1;
      }
      ((IWxShareHelperFromReadInjoy)localObject2).shareVideo(str1, str2, (Bitmap)localObject1, str3, str4, i);
      return;
    }
    if (((this.jdField_a_of_type_Int == 9) && (this.f.contains("wx_friend"))) || ((this.jdField_a_of_type_Int == 10) && (this.f.contains("wx_line"))))
    {
      localObject1 = WXShareHelper.a();
      localObject2 = this.g;
      if (this.jdField_a_of_type_Int != 9) {
        i = 1;
      }
      ((WXShareHelper)localObject1).a((String)localObject2, i, QShareUtils.a(this.this$0));
      return;
    }
    Object localObject2 = WXShareHelper.a();
    String str1 = QShareUtils.a(this.this$0);
    String str2 = this.jdField_a_of_type_JavaLangString;
    String str3 = this.jdField_b_of_type_JavaLangString;
    String str4 = this.c;
    if (this.jdField_a_of_type_Int == 9) {
      i = 0;
    } else {
      i = 1;
    }
    ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.QShareUtils.1
 * JD-Core Version:    0.7.0.1
 */