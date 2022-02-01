package com.tencent.mobileqq.kandian.repo.fastweb;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FastWebArticleInfoUtils$1$1
  implements FastWebModule.FastWebContentGetCallback
{
  FastWebArticleInfoUtils$1$1(FastWebArticleInfoUtils.1 param1) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean1) && (paramFastWebArticleInfo != null))
    {
      this.a.b.d = paramFastWebArticleInfo.d;
      if (paramFastWebArticleInfo.c > this.a.b.c) {
        this.a.b.c = paramFastWebArticleInfo.c;
      }
      this.a.b.w = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update fastweb info, rowkey : ");
      localStringBuilder.append(paramFastWebArticleInfo.q);
      localStringBuilder.append(",  commentCnt : ");
      localStringBuilder.append(paramFastWebArticleInfo.d);
      localStringBuilder.append(", readCnt :");
      localStringBuilder.append(paramFastWebArticleInfo.c);
      QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new FastWebArticleInfoUtils.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebArticleInfoUtils.1.1
 * JD-Core Version:    0.7.0.1
 */