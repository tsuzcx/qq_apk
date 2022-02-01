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
    if (FastWebShareUtils.b(this.this$0).isShowing()) {
      FastWebShareUtils.b(this.this$0).dismiss();
    }
    FastWebShareUtils.a(this.this$0, String.valueOf(System.currentTimeMillis()));
    Object localObject = (Bitmap)this.a.remove("image");
    if (this.b) {
      WxShareHelperFromReadInjoy.getInstance().shareMiniProgram(FastWebShareUtils.a(this.this$0), this.c, (Bitmap)localObject, this.d, this.e, this.f);
    } else if (ReadInJoyHelper.L(ReadInJoyUtils.b()) == 1) {
      WXShareHelper.a().a(FastWebShareUtils.a(this.this$0), this.c, (Bitmap)localObject, this.d, this.e, "2".equals(this.g) ^ true);
    } else {
      WxShareHelperFromReadInjoy.getInstance().shareWebPage(FastWebShareUtils.a(this.this$0), this.c, (Bitmap)localObject, this.d, this.e, "2".equals(this.g) ^ true);
    }
    localObject = this.h.getApplication().getApplicationContext();
    String str = this.i;
    int m;
    if ("2".equals(this.g)) {
      m = 4;
    } else {
      m = 5;
    }
    FastWebShareUtils.a((Context)localObject, str, m, this.j);
    ReportUtil.a(this.h.getApplication().getApplicationContext(), this.h, this.j, this.k, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils.2
 * JD-Core Version:    0.7.0.1
 */