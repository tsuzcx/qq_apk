import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebShareUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;
import mqq.app.MobileQQ;

public class mrw
  implements Runnable
{
  public mrw(FastWebShareUtils paramFastWebShareUtils, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, AppInterface paramAppInterface, String paramString5, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    int j = 0;
    int i = 0;
    if (FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils).isShowing()) {
      FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils).dismiss();
    }
    FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils, String.valueOf(System.currentTimeMillis()));
    Object localObject1 = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    Object localObject2;
    String str1;
    String str2;
    String str3;
    String str4;
    if (ReadInJoyHelper.u(ReadInJoyUtils.a()) == 1)
    {
      localObject2 = WXShareHelper.a();
      str1 = FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils);
      str2 = this.jdField_a_of_type_JavaLangString;
      str3 = this.b;
      str4 = this.c;
      if ("2".equals(this.d))
      {
        ((WXShareHelper)localObject2).b(str1, str2, (Bitmap)localObject1, str3, str4, i);
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext();
        localObject2 = this.e;
        if (!"2".equals(this.d)) {
          break label242;
        }
      }
    }
    label242:
    for (i = 4;; i = 5)
    {
      FastWebShareUtils.a((Context)localObject1, (String)localObject2, i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
      i = 1;
      break;
      localObject2 = WxShareHelperFromReadInjoy.a();
      str1 = FastWebShareUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebShareUtils);
      str2 = this.jdField_a_of_type_JavaLangString;
      str3 = this.b;
      str4 = this.c;
      if ("2".equals(this.d)) {}
      for (i = j;; i = 1)
      {
        ((WxShareHelperFromReadInjoy)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mrw
 * JD-Core Version:    0.7.0.1
 */