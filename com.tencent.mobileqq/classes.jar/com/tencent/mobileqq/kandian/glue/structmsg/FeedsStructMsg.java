package com.tencent.mobileqq.kandian.glue.structmsg;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FeedsStructMsg
{
  public static String a(AppInterface paramAppInterface, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramAppInterface = localStringBuilder;
    if (paramAbsBaseArticleInfo.mFeedType != 17)
    {
      paramAppInterface = localStringBuilder;
      if (paramAbsBaseArticleInfo.mFeedType != 16)
      {
        paramAppInterface = localStringBuilder;
        if (paramAbsBaseArticleInfo.mFeedType != 19) {
          if (paramAbsBaseArticleInfo.mFeedType == 18)
          {
            paramAppInterface = localStringBuilder;
          }
          else if ((paramAbsBaseArticleInfo.mFeedType != 4) && (paramAbsBaseArticleInfo.mFeedType != 5))
          {
            if (RIJItemViewTypeUtils.e(paramAbsBaseArticleInfo))
            {
              paramAppInterface = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a, null);
              if (paramAppInterface != null) {
                paramAppInterface = paramAppInterface.nick;
              } else {
                paramAppInterface = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getDefaultNickName();
              }
              localStringBuilder.append(paramAppInterface);
              localStringBuilder.append(" Biu了");
              paramAppInterface = localStringBuilder;
            }
            else if (paramAbsBaseArticleInfo.mFeedType == 28)
            {
              localStringBuilder = new StringBuilder(HardCodeUtil.a(2131708749));
              paramAppInterface = localStringBuilder;
              if (paramAbsBaseArticleInfo.hotWordInfo.a != null)
              {
                int j;
                for (int i = 0;; i = j)
                {
                  paramAppInterface = localStringBuilder;
                  if (i >= paramAbsBaseArticleInfo.hotWordInfo.a.size()) {
                    break;
                  }
                  j = i + 1;
                  localStringBuilder.append(j);
                  localStringBuilder.append(".");
                  localStringBuilder.append(((HotWordItem)paramAbsBaseArticleInfo.hotWordInfo.a.get(i)).jdField_a_of_type_JavaLangString);
                  localStringBuilder.append("  ");
                }
              }
            }
            else
            {
              localStringBuilder.append(paramAbsBaseArticleInfo.mSubscribeName);
              paramAppInterface = localStringBuilder;
            }
          }
          else if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle))
          {
            paramAppInterface = localStringBuilder;
            if (QLog.isColorLevel())
            {
              QLog.d("FeedsStructMsg", 2, "articleInfo.mTitle is null");
              paramAppInterface = localStringBuilder;
            }
          }
          else
          {
            paramAppInterface = ((IReadInJoyUserInfoModule)QRoute.api(IReadInJoyUserInfoModule.class)).getSingleKDUserInfo(paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.a, null);
            if (paramAppInterface != null) {
              paramAppInterface = paramAppInterface.nick;
            } else {
              paramAppInterface = ReadInJoyUserInfoModule.a();
            }
            localStringBuilder.append(paramAppInterface);
            paramAppInterface = localStringBuilder;
          }
        }
      }
    }
    return paramAppInterface.toString();
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str = "";
    if (paramAbsBaseArticleInfo == null) {
      return "";
    }
    Object localObject1 = str;
    for (;;)
    {
      try
      {
        if (paramAbsBaseArticleInfo.mFeedType != 17)
        {
          localObject1 = str;
          if (paramAbsBaseArticleInfo.mFeedType != 16)
          {
            localObject1 = str;
            if (paramAbsBaseArticleInfo.mFeedType != 19)
            {
              localObject1 = str;
              if (paramAbsBaseArticleInfo.mFeedType != 18)
              {
                localObject1 = str;
                if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle))
                {
                  localObject1 = str;
                  if (paramAbsBaseArticleInfo.isSocialFeed())
                  {
                    localObject1 = str;
                    paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString;
                    break label322;
                  }
                }
                localObject1 = str;
                paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mTitle;
                break label322;
              }
            }
          }
        }
        localObject1 = str;
        if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo == null) {
          break label325;
        }
        localObject1 = str;
        if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a == null) {
          break label325;
        }
        localObject1 = str;
        if (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() <= 0) {
          break label325;
        }
        localObject1 = str;
        localObject2 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).c;
        localObject1 = str;
        localObject3 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).jdField_a_of_type_JavaLangString;
        localObject1 = str;
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = str;
        localStringBuilder.append((String)localObject2);
        localObject1 = str;
        localStringBuilder.append((String)localObject3);
        localObject1 = str;
        localStringBuilder.append((String)localObject2);
        localObject1 = str;
        localStringBuilder.append(" ");
        localObject1 = str;
        localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
        localObject1 = str;
        paramAbsBaseArticleInfo = localStringBuilder.toString();
      }
      catch (Throwable paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
        QLog.d("FeedsStructMsg", 1, "createStructingMsgBriefSuffix throw Throwable, create failed.");
        localObject2 = localObject1;
      }
      localObject1 = paramAbsBaseArticleInfo;
      Object localObject2 = paramAbsBaseArticleInfo;
      if (QLog.isColorLevel())
      {
        localObject1 = paramAbsBaseArticleInfo;
        QLog.d("FeedsStructMsg", 2, new Object[] { "createStructingMsgBriefSuffix suffix = ", paramAbsBaseArticleInfo });
        return paramAbsBaseArticleInfo;
      }
      return localObject2;
      label322:
      continue;
      label325:
      localObject2 = "";
      Object localObject3 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg
 * JD-Core Version:    0.7.0.1
 */