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
      this.a.a.jdField_b_of_type_Long = paramFastWebArticleInfo.jdField_b_of_type_Long;
      if (paramFastWebArticleInfo.a > this.a.a.a) {
        this.a.a.a = paramFastWebArticleInfo.a;
      }
      this.a.a.jdField_b_of_type_Boolean = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update fastweb info, rowkey : ");
      localStringBuilder.append(paramFastWebArticleInfo.j);
      localStringBuilder.append(",  commentCnt : ");
      localStringBuilder.append(paramFastWebArticleInfo.jdField_b_of_type_Long);
      localStringBuilder.append(", readCnt :");
      localStringBuilder.append(paramFastWebArticleInfo.a);
      QLog.d("Q.readinjoy.fast_web", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new FastWebArticleInfoUtils.1.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebArticleInfoUtils.1.1
 * JD-Core Version:    0.7.0.1
 */