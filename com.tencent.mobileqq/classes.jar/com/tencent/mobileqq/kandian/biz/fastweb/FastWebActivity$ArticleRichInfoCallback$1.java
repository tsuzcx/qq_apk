package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.FastWebShareInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$ArticleRichInfoCallback$1
  implements Runnable
{
  FastWebActivity$ArticleRichInfoCallback$1(FastWebActivity.ArticleRichInfoCallback paramArticleRichInfoCallback, boolean paramBoolean, FastWebShareInfo paramFastWebShareInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.a) && (this.b != null))
    {
      FastWebShareUtils localFastWebShareUtils = FastWebActivity.X(this.e.a);
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.e.a.g;
      int i = this.c;
      FastWebActivity localFastWebActivity = this.e.a;
      String str = this.d;
      if (FastWebActivity.t(this.e.a)) {
        localObject = "0X8008994";
      } else {
        localObject = "0X800898D";
      }
      localFastWebShareUtils.a(localAbsBaseArticleInfo, i, localFastWebActivity, str, (String)localObject, this.b.a(this.c), FastWebActivity.U(this.e.a), FastWebActivity.V(this.e.a), FastWebActivity.W(this.e.a));
      return;
    }
    QRUtils.a(1, 2131886094);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shareJson get false ! action : ");
    ((StringBuilder)localObject).append(this.c);
    QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.ArticleRichInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */