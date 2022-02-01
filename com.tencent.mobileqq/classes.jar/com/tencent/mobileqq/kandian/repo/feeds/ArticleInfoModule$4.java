package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.repo.daily.PreLoader;
import com.tencent.mobileqq.kandian.repo.feeds.api.impl.FeedsRefreshUtilImpl;
import com.tencent.mobileqq.kandian.repo.feeds.api.impl.FeedsRefreshUtilImpl.Companion;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.RIJRefreshTopicInfoHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class ArticleInfoModule$4
  implements Runnable
{
  ArticleInfoModule$4(ArticleInfoModule paramArticleInfoModule, long paramLong1, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, List paramList1, boolean paramBoolean2, long paramLong2, List paramList2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long;
    boolean bool3 = false;
    boolean bool1;
    if (l == -1L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ArrayOfByte);
    ArticleInfoModule.a(this.this$0).a(this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject2 = ArticleInfoModule.a(this.this$0).a(this.jdField_a_of_type_Int);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ConcurrentHashMap();
      }
      localObject2 = new StringBuilder("\n");
      Object localObject3 = this.jdField_a_of_type_JavaUtilList;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        int i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject3).next();
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("article【");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("】 id : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mArticleID);
          ((StringBuilder)localObject4).append(" seq : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mRecommendSeq);
          ((StringBuilder)localObject4).append(" title : ");
          ((StringBuilder)localObject4).append(ReadInJoyStringUtils.b(localAbsBaseArticleInfo.mTitle));
          ((StringBuilder)localObject4).append(" , groupID : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mGroupId);
          ((StringBuilder)localObject4).append(" rowkey : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.innerUniqueID);
          ((StringBuilder)localObject4).append(", mFeedType : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mFeedType);
          ((StringBuilder)localObject4).append(" feeedCookie : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mFeedCookie);
          ((StringBuilder)localObject4).append(", mFeedID : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mFeedId);
          ((StringBuilder)localObject4).append(" algorithmID : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mAlgorithmID);
          ((StringBuilder)localObject4).append(" strategyId : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mStrategyId);
          ((StringBuilder)localObject4).append(" businessID : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.businessId);
          ((StringBuilder)localObject4).append(" businessName :");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.businessName);
          ((StringBuilder)localObject4).append(" commentShareUrl : ");
          ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.commentShareUrl);
          ((StringBuilder)localObject2).append(((StringBuilder)localObject4).toString());
          if (localAbsBaseArticleInfo.mSocialFeedInfo != null)
          {
            localObject4 = localAbsBaseArticleInfo.mSocialFeedInfo;
            StringBuilder localStringBuilder;
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" ");
              localStringBuilder.append(localObject4);
              ((StringBuilder)localObject2).append(localStringBuilder.toString());
              ((StringBuilder)localObject2).append("\n");
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("SocialFeedInfo: mFeedId: ");
              localStringBuilder.append(((SocializeFeedsInfo)localObject4).jdField_a_of_type_Long);
              localStringBuilder.append(" mFeedStatus: ");
              localStringBuilder.append(((SocializeFeedsInfo)localObject4).k);
              localStringBuilder.append(" mFollowStatus: ");
              localStringBuilder.append(((SocializeFeedsInfo)localObject4).h);
              ((StringBuilder)localObject2).append(localStringBuilder.toString());
              ((StringBuilder)localObject2).append("\n");
            }
          }
          else
          {
            ((StringBuilder)localObject2).append("\n");
          }
          if ((RIJFeedsType.F(localAbsBaseArticleInfo)) && (!((ConcurrentMap)localObject1).containsKey(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq)))) {
            ((ConcurrentMap)localObject1).put(Long.valueOf(localAbsBaseArticleInfo.mRecommendSeq), Boolean.valueOf(false));
          }
          i += 1;
        }
        if (((ConcurrentMap)localObject1).size() > 0) {
          ArticleInfoModule.a(this.this$0).a(this.jdField_a_of_type_Int, (ConcurrentMap)localObject1);
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRefreshChannel success=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(" channelId=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" noMoreData=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject1).append(" beginRecommendSeq=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject1).append(" endRecommendSeq=");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
      ((StringBuilder)localObject1).append(" isInMsgTab : ");
      boolean bool2 = bool3;
      if (ArticleInfoModule.a(this.this$0) != null)
      {
        bool2 = bool3;
        if ((ArticleInfoModule.b(this.this$0) instanceof QQAppInterface)) {
          bool2 = true;
        }
      }
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append(" isRefresh : ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(((StringBuilder)localObject2).toString());
      QLog.i("ArticleInfoModule", 1, ((StringBuilder)localObject1).toString());
      ArticleInfoModule.a(this.jdField_a_of_type_JavaUtilList);
    }
    PreLoader.a().a(this.jdField_a_of_type_JavaUtilList);
    ArticleInfoModule.a(this.this$0).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
    if (bool1)
    {
      ArticleInfoModule.a(this.this$0).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg);
      ArticleInfoModule.a(this.this$0, this.jdField_a_of_type_JavaUtilList);
    }
    else
    {
      ArticleInfoModule.a(this.this$0, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
    }
    FeedsRefreshUtilImpl.Companion.a(this.jdField_a_of_type_Int, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule.4
 * JD-Core Version:    0.7.0.1
 */