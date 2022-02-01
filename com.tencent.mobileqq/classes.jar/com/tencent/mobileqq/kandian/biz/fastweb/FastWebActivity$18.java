package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class FastWebActivity$18
  implements Runnable
{
  FastWebActivity$18(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.this$0.g;
    String str2 = "https://web.kandian.qq.com/tpl/kdReport?pgyid=2021";
    Object localObject = str2;
    String str1;
    if (localAbsBaseArticleInfo != null) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://web.kandian.qq.com/tpl/kdReport?pgyid=2021");
        ((StringBuilder)localObject).append("&rowkey=");
        ((StringBuilder)localObject).append(this.this$0.g.innerUniqueID);
        ((StringBuilder)localObject).append("&type=content");
        localObject = ((StringBuilder)localObject).toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str1 = str2;
      }
    }
    ReadInJoyUtils.a(this.this$0, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.18
 * JD-Core Version:    0.7.0.1
 */