package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.net.URLEncoder;

final class FastWebDislikeUtils$1
  implements Runnable
{
  FastWebDislikeUtils$1(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext) {}
  
  public void run()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    String str2 = "https://post.mp.qq.com/jubao/index?";
    Object localObject = str2;
    String str1;
    if (localAbsBaseArticleInfo != null) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://post.mp.qq.com/jubao/index?");
        ((StringBuilder)localObject).append("articleId=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
        ((StringBuilder)localObject).append("&puin=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mSubscribeID);
        ((StringBuilder)localObject).append("&url=");
        ((StringBuilder)localObject).append(URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleContentUrl, "utf-8"));
        ((StringBuilder)localObject).append("&key=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
        ((StringBuilder)localObject).append("&type=7&_wv=3");
        localObject = ((StringBuilder)localObject).toString();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str1 = str2;
      }
    }
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidContentContext, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebDislikeUtils.1
 * JD-Core Version:    0.7.0.1
 */