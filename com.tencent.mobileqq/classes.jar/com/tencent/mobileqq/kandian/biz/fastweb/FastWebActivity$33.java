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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" isSucc ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("  useWebView :");
    ((StringBuilder)localObject).append(paramBoolean2);
    ((StringBuilder)localObject).append("  data : ");
    ((StringBuilder)localObject).append(paramFastWebArticleInfo);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("FastWebActivity", 1, (String)localObject);
    if ((paramBoolean1) && (!paramBoolean2) && (paramFastWebArticleInfo != null))
    {
      TimeUtil.b("fast_web_show_light_house_2");
      paramBoolean1 = bool;
    }
    else
    {
      paramBoolean1 = false;
    }
    if (paramFastWebArticleInfo != null) {
      FastWebActivity.a(this.a, paramFastWebArticleInfo);
    }
    FastWebActivity.g(this.a, paramBoolean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.33
 * JD-Core Version:    0.7.0.1
 */