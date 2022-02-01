package com.tencent.mobileqq.kandian.biz.pts.component;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ComponentPolymericViewJumpUrlGenerator
{
  @Nullable
  public static String a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    String str1;
    if (paramInt == 79) {
      str1 = a(paramAbsBaseArticleInfo);
    } else {
      str1 = "";
    }
    if ((!RIJItemViewTypeUtils.a(paramAbsBaseArticleInfo)) && (!RIJItemViewTypeUtils.g(paramAbsBaseArticleInfo)) && (paramInt != 77) && (paramInt != 78))
    {
      if ((RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo)) || (paramInt == 76)) {
        str1 = c(paramAbsBaseArticleInfo);
      }
    }
    else {
      str1 = b(paramAbsBaseArticleInfo);
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = d(paramAbsBaseArticleInfo);
    }
    return str2;
  }
  
  @Nullable
  private static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null) && (!paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.isEmpty()))
    {
      paramAbsBaseArticleInfo = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.get(0)).c;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ComponentPolymericView TYPE_NEW_POLYMERIC_CONTAINER_TOPIC jump account url =");
        localStringBuilder.append(paramAbsBaseArticleInfo);
        QLog.d("PolymericSmallVideo", 2, localStringBuilder.toString());
      }
      return paramAbsBaseArticleInfo;
    }
    QLog.e("HorizontalListView", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
    return null;
  }
  
  private static String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {}
    try
    {
      l = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label21:
      Object localObject;
      break label21;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("generateWithSubscribeID() failed! ");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeID);
    QLog.e("HorizontalListView", 1, ((StringBuilder)localObject).toString());
    l = 0L;
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append(ReadInJoyConstants.l);
    paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l).getBytes(), 2));
    localObject = paramAbsBaseArticleInfo.toString();
    paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("ComponentPolymericView PGC jump account url =");
      paramAbsBaseArticleInfo.append((String)localObject);
      paramAbsBaseArticleInfo.append(" uin = ");
      paramAbsBaseArticleInfo.append(l);
      QLog.d("PolymericSmallVideo", 2, paramAbsBaseArticleInfo.toString());
      return localObject;
      paramAbsBaseArticleInfo = "";
    }
    return paramAbsBaseArticleInfo;
  }
  
  private static String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
    {
      long l = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append(ReadInJoyConstants.h);
      paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l).getBytes(), 2));
      String str = paramAbsBaseArticleInfo.toString();
      paramAbsBaseArticleInfo = str;
      if (QLog.isColorLevel())
      {
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append("ComponentPolymericView UGC jump account url =");
        paramAbsBaseArticleInfo.append(str);
        paramAbsBaseArticleInfo.append(" uin = ");
        paramAbsBaseArticleInfo.append(l);
        QLog.d("PolymericSmallVideo", 2, paramAbsBaseArticleInfo.toString());
        return str;
      }
    }
    else
    {
      paramAbsBaseArticleInfo = "";
    }
    return paramAbsBaseArticleInfo;
  }
  
  private static String d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeID)) {}
    try
    {
      l = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l;
      label21:
      Object localObject;
      break label21;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("generateByDefault() failed! ");
    ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mSubscribeID);
    QLog.e("HorizontalListView", 1, ((StringBuilder)localObject).toString());
    l = 0L;
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append(ReadInJoyConstants.l);
    paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l).getBytes(), 2));
    localObject = paramAbsBaseArticleInfo.toString();
    paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
    if (QLog.isColorLevel())
    {
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("ComponentPolymericView empty url jump account url =");
      paramAbsBaseArticleInfo.append((String)localObject);
      paramAbsBaseArticleInfo.append(" mSubscribeID = ");
      paramAbsBaseArticleInfo.append(l);
      QLog.d("PolymericSmallVideo", 2, paramAbsBaseArticleInfo.toString());
      return localObject;
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
      {
        l = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(ReadInJoyConstants.h);
        paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l).getBytes(), 2));
        localObject = paramAbsBaseArticleInfo.toString();
        paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
        if (QLog.isColorLevel())
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("ComponentPolymericView empty url jump account url =");
          paramAbsBaseArticleInfo.append((String)localObject);
          paramAbsBaseArticleInfo.append(" mUGCFeedsInfo.cuin = ");
          paramAbsBaseArticleInfo.append(l);
          QLog.d("PolymericSmallVideo", 2, paramAbsBaseArticleInfo.toString());
          return localObject;
        }
      }
      else if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null))
      {
        l = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
        paramAbsBaseArticleInfo = new StringBuilder();
        paramAbsBaseArticleInfo.append(ReadInJoyConstants.h);
        paramAbsBaseArticleInfo.append(Base64Util.encodeToString(String.valueOf(l).getBytes(), 2));
        localObject = paramAbsBaseArticleInfo.toString();
        paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
        if (QLog.isColorLevel())
        {
          paramAbsBaseArticleInfo = new StringBuilder();
          paramAbsBaseArticleInfo.append("ComponentPolymericView empty url jump account url =");
          paramAbsBaseArticleInfo.append((String)localObject);
          paramAbsBaseArticleInfo.append(" mMasterUser.uin = ");
          paramAbsBaseArticleInfo.append(l);
          QLog.d("PolymericSmallVideo", 2, paramAbsBaseArticleInfo.toString());
          return localObject;
        }
      }
      else
      {
        paramAbsBaseArticleInfo = "";
      }
    }
    return paramAbsBaseArticleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericViewJumpUrlGenerator
 * JD-Core Version:    0.7.0.1
 */