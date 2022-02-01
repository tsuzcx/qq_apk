package com.tencent.mobileqq.kandian.glue.viola;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class RIJViolaUtils
{
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    if ((paramAbsBaseArticleInfo.isCardJumpUrlAvailable == 1) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mCardJumpUrl)))
    {
      paramAbsBaseArticleInfo = ViolaBizUtils.d(paramAbsBaseArticleInfo.mCardJumpUrl);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shortContentUrl: ");
        localStringBuilder.append(paramAbsBaseArticleInfo);
        QLog.d("RIJViolaUtils", 2, localStringBuilder.toString());
      }
      if (ViolaAccessHelper.c(paramAbsBaseArticleInfo)) {
        return ViolaAccessHelper.c(paramAbsBaseArticleInfo);
      }
    }
    return null;
  }
  
  public static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)) {
        return null;
      }
      paramAbsBaseArticleInfo = ViolaBizUtils.d(paramAbsBaseArticleInfo.mArticleContentUrl);
      if (ViolaAccessHelper.c(paramAbsBaseArticleInfo))
      {
        String str = ViolaAccessHelper.c(paramAbsBaseArticleInfo);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get viola url from articleContentUrl: ");
          if (str != null) {
            paramAbsBaseArticleInfo = str;
          } else {
            paramAbsBaseArticleInfo = "null";
          }
          localStringBuilder.append(paramAbsBaseArticleInfo);
          QLog.d("RIJViolaUtils", 2, localStringBuilder.toString());
        }
        return str;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.RIJViolaUtils
 * JD-Core Version:    0.7.0.1
 */