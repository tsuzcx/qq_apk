package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URLEncoder;

class FastWebActivity$18
  implements Runnable
{
  FastWebActivity$18(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.this$0.a;
    String str2 = "https://post.mp.qq.com/jubao/index?";
    Object localObject = str2;
    String str1;
    if (localAbsBaseArticleInfo != null) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://post.mp.qq.com/jubao/index?");
        ((StringBuilder)localObject).append("articleId=");
        ((StringBuilder)localObject).append(this.this$0.a.mArticleID);
        ((StringBuilder)localObject).append("&puin=");
        ((StringBuilder)localObject).append(this.this$0.a.mSubscribeID);
        ((StringBuilder)localObject).append("&url=");
        ((StringBuilder)localObject).append(URLEncoder.encode(this.this$0.a.mArticleContentUrl, "utf-8"));
        ((StringBuilder)localObject).append("&key=");
        ((StringBuilder)localObject).append(this.this$0.a.innerUniqueID);
        ((StringBuilder)localObject).append("&type=7&_wv=3");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.18
 * JD-Core Version:    0.7.0.1
 */