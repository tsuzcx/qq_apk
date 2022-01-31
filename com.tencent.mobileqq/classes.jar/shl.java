import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.4;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class shl
  implements wxt
{
  public shl(ReadInjoyWebShareHelper.4 param4, Bitmap paramBitmap) {}
  
  public void a(Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    int k = paramBundle.getInt("readinjoy_to_wx_config");
    if (QLog.isColorLevel()) {
      QLog.d("WebShareHelper", 2, "config = " + k);
    }
    if (k == 0)
    {
      paramBundle = WxShareHelperFromReadInjoy.a();
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.this$0.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.jdField_a_of_type_JavaLangString;
      localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      str3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.b;
      str4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.c;
      if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        paramBundle.a(str1, str2, localBitmap, str3, str4, i);
        return;
        i = 1;
      }
    }
    paramBundle = WXShareHelper.a();
    String str1 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.this$0.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.jdField_a_of_type_JavaLangString;
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.b;
    String str4 = this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.c;
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$4.jdField_a_of_type_Boolean) {}
    for (i = j;; i = 1)
    {
      paramBundle.b(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     shl
 * JD-Core Version:    0.7.0.1
 */