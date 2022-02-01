package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.base.utils.TimeUtil;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebContentGetCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$33
  implements FastWebModule.FastWebContentGetCallback
{
  FastWebActivity$33(FastWebActivity paramFastWebActivity) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" isSucc ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("  useWebView :");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("  data : ");
    localStringBuilder.append(paramFastWebArticleInfo);
    QLog.d("FastWebActivity", 2, localStringBuilder.toString());
    if ((paramBoolean1) && (!paramBoolean2) && (paramFastWebArticleInfo != null))
    {
      paramBoolean1 = true;
      TimeUtil.b("fast_web_show_light_house_2");
    }
    else
    {
      paramBoolean1 = false;
    }
    if (paramFastWebArticleInfo != null) {
      FastWebActivity.a(this.a, paramFastWebArticleInfo);
    }
    FastWebActivity.c(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.33
 * JD-Core Version:    0.7.0.1
 */