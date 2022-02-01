package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.Map;
import mqq.app.MobileQQ;

class FastWebShareUtils$2
  implements Runnable
{
  FastWebShareUtils$2(FastWebShareUtils paramFastWebShareUtils, Map paramMap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, AppInterface paramAppInterface, String paramString6, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void run()
  {
    if (FastWebShareUtils.a(this.this$0).isShowing()) {
      FastWebShareUtils.a(this.this$0).dismiss();
    }
    FastWebShareUtils.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject = (Bitmap)this.jdField_a_of_type_JavaUtilMap.remove("image");
    if (this.jdField_a_of_type_Boolean) {
      WxShareHelperFromReadInjoy.getInstance().shareMiniProgram(FastWebShareUtils.a(this.this$0), this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.b, this.c, this.d);
    } else if (ReadInJoyHelper.n(ReadInJoyUtils.a()) == 1) {
      WXShareHelper.a().a(FastWebShareUtils.a(this.this$0), this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.b, this.c, "2".equals(this.e) ^ true);
    } else {
      WxShareHelperFromReadInjoy.getInstance().shareWebPage(FastWebShareUtils.a(this.this$0), this.jdField_a_of_type_JavaLangString, (Bitmap)localObject, this.b, this.c, "2".equals(this.e) ^ true);
    }
    localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext();
    String str = this.f;
    int i;
    if ("2".equals(this.e)) {
      i = 4;
    } else {
      i = 5;
    }
    FastWebShareUtils.a((Context)localObject, str, i, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    ReportUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_Int, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils.2
 * JD-Core Version:    0.7.0.1
 */