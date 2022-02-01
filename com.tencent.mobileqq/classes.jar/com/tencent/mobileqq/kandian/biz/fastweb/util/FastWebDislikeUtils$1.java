package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

final class FastWebDislikeUtils$1
  implements Runnable
{
  FastWebDislikeUtils$1(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext) {}
  
  public void run()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
    String str2 = "https://web.kandian.qq.com/tpl/kdReport?pgyid=2021";
    Object localObject = str2;
    String str1;
    if (localAbsBaseArticleInfo != null) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://web.kandian.qq.com/tpl/kdReport?pgyid=2021");
        ((StringBuilder)localObject).append("&rowkey=");
        ((StringBuilder)localObject).append(this.a.innerUniqueID);
        ((StringBuilder)localObject).append("&type=content");
        localObject = ((StringBuilder)localObject).toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str1 = str2;
      }
    }
    ReadInJoyUtils.a(this.b, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils.1
 * JD-Core Version:    0.7.0.1
 */