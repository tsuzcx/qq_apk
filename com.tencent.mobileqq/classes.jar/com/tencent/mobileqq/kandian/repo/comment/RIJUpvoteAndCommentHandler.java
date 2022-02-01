package com.tencent.mobileqq.kandian.repo.comment;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.handler.RIJBaseArticleInfoHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;

public class RIJUpvoteAndCommentHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJUpvoteAndCommentHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private void a(long paramLong, int paramInt, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().c(paramInt).values().iterator();
    while (localIterator.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)localIterator.next();
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mFeedId == paramLong) && (localAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (localAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a != null))
      {
        TopicRecommendFeedsInfo localTopicRecommendFeedsInfo = localAbsBaseArticleInfo.mTopicRecommendFeedsInfo;
        if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (localTopicRecommendFeedsInfo != null) && (localTopicRecommendFeedsInfo.a != null))
        {
          Object localObject = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
          if (((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject).msg_topic_recommend_info.has())
          {
            localObject = ((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject).msg_topic_recommend_info.get();
            paramInt = 0;
            while ((paramInt < ((List)localObject).size()) && (paramInt < localTopicRecommendFeedsInfo.a.size()))
            {
              oidb_cmd0x8c8.TopicRecommendInfo localTopicRecommendInfo = (oidb_cmd0x8c8.TopicRecommendInfo)((List)localObject).get(paramInt);
              TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo1 = (TopicRecommendFeedsInfo.TopicRecommendInfo)localTopicRecommendFeedsInfo.a.get(paramInt);
              if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
                localTopicRecommendInfo1.b = localTopicRecommendInfo.uint32_number_of_participants.get();
              }
              paramInt += 1;
            }
          }
        }
        localAbsBaseArticleInfo.invalidateProteusTemplateBean();
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    if ((paramAbsBaseArticleInfo2.mFeedId != paramAbsBaseArticleInfo1.mFeedId) && (paramAbsBaseArticleInfo2.mSocialFeedInfo != null))
    {
      int j = 0;
      int i = j;
      if (paramAbsBaseArticleInfo2.mSocialFeedInfo.h != 2)
      {
        i = j;
        if (paramAbsBaseArticleInfo1.mSocialFeedInfo.h == 2) {
          i = 1;
        }
      }
      paramAbsBaseArticleInfo2.mSocialFeedInfo.h = paramAbsBaseArticleInfo1.mSocialFeedInfo.h;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.updateEntity(paramAbsBaseArticleInfo2);
      paramAbsBaseArticleInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(paramAbsBaseArticleInfo2, (int)paramAbsBaseArticleInfo2.mChannelID);
      if ((i != 0) && (paramAbsBaseArticleInfo1 != null)) {
        paramAbsBaseArticleInfo1.isNeedShowBtnWhenFollowed = true;
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo, int paramInt)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (((paramAbsBaseArticleInfo.mFeedType == 11) || (paramAbsBaseArticleInfo.mFeedType == 14)) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a != null) && (paramAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0))
    {
      a(paramAbsBaseArticleInfo.mFeedId, paramInt, paramSocializeFeedsInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.updateEntity(paramAbsBaseArticleInfo);
      return;
    }
    if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
    {
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
      SocializeFeedsInfoUtils.a(paramAbsBaseArticleInfo.mSocialFeedInfo, paramSocializeFeedsInfo);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.updateEntity(paramAbsBaseArticleInfo);
      paramSocializeFeedsInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(paramAbsBaseArticleInfo, paramInt);
      if (paramSocializeFeedsInfo != null)
      {
        if ((i != 2) && (paramAbsBaseArticleInfo.mSocialFeedInfo.h == 2)) {
          paramSocializeFeedsInfo.isNeedShowBtnWhenFollowed = true;
        }
        paramSocializeFeedsInfo.invalidateProteusTemplateBean();
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("0x8c8_retry_times")).intValue();
    if (i < 0)
    {
      paramToServiceMsg.addAttribute("0x8c8_retry_times", Integer.valueOf(i + 1));
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReq(paramToServiceMsg);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("retry times:");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append(" exceeds");
    QLog.d("RIJUpvoteAndCommentHandler", 1, paramToServiceMsg.toString());
  }
  
  private void a(ConcurrentMap<Long, AbsBaseArticleInfo> paramConcurrentMap, long paramLong, int paramInt, List<Long> paramList)
  {
    if (paramConcurrentMap != null)
    {
      Object localObject2 = null;
      Iterator localIterator = paramConcurrentMap.values().iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbsBaseArticleInfo)localIterator.next();
      } while ((((AbsBaseArticleInfo)localObject1).mFeedId != paramLong) || (((AbsBaseArticleInfo)localObject1).mFeedType != paramInt));
      if (localObject1 != null)
      {
        paramConcurrentMap.remove(Long.valueOf(((AbsBaseArticleInfo)localObject1).mRecommendSeq));
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(Integer.valueOf(0), (AbsBaseArticleInfo)localObject1);
        paramList.add(Long.valueOf(((AbsBaseArticleInfo)localObject1).mRecommendSeq));
      }
    }
  }
  
  private void a(oidb_cmd0x8c8.RspBody paramRspBody, ConcurrentHashMap<String, AbsBaseArticleInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    if (paramRspBody.rpt_social_feeds_info.has())
    {
      if (paramRspBody.rpt_social_feeds_info.get() == null) {
        return;
      }
      paramRspBody = paramRspBody.rpt_social_feeds_info.get();
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJUpvoteAndCommentHandler.2(this, paramRspBody, paramConcurrentHashMap, paramBoolean));
    }
  }
  
  private boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.publishUin != 0L)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("publishUin = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.publishUin);
      localObject = ((StringBuilder)localObject).toString();
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(BaseArticleInfo.class, true, (String)localObject, null, null, null, "mRecommendSeq desc", null);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("no soical feeds to update article.publishUin:");
        ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.publishUin);
        QLog.d("RIJUpvoteAndCommentHandler", 1, ((StringBuilder)localObject).toString());
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramAbsBaseArticleInfo, (AbsBaseArticleInfo)((Iterator)localObject).next());
      }
    }
    return true;
  }
  
  private void b(ConcurrentMap<Long, AbsBaseArticleInfo> paramConcurrentMap, long paramLong, int paramInt, List<Long> paramList)
  {
    if (paramConcurrentMap != null)
    {
      Object localObject2 = null;
      Iterator localIterator = paramConcurrentMap.values().iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (AbsBaseArticleInfo)localIterator.next();
      } while ((((AbsBaseArticleInfo)localObject1).mFeedId != paramLong) || (((AbsBaseArticleInfo)localObject1).mFeedType != paramInt));
      if (localObject1 != null)
      {
        paramConcurrentMap.remove(Long.valueOf(((AbsBaseArticleInfo)localObject1).mRecommendSeq));
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a().a(Integer.valueOf(70), (AbsBaseArticleInfo)localObject1);
        paramList.add(Long.valueOf(((AbsBaseArticleInfo)localObject1).mRecommendSeq));
      }
    }
  }
  
  private void b(oidb_cmd0x8c8.RspBody paramRspBody, ConcurrentHashMap<String, AbsBaseArticleInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    paramRspBody = paramRspBody.rpt_del_feeds_info_list.get();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJUpvoteAndCommentHandler.3(this, paramRspBody, paramConcurrentHashMap));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x8c8.RspBody localRspBody = new oidb_cmd0x8c8.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    try
    {
      paramFromServiceMsg = (ConcurrentHashMap)paramToServiceMsg.getAttribute("0x8c8_articleMap");
      boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isUpdateByAccount")).booleanValue();
      if (i == 0)
      {
        QLog.d("RIJUpvoteAndCommentHandler", 1, "handle0x8c8UpvoteAction result OK");
        a(localRspBody, paramFromServiceMsg, bool);
        if ((localRspBody.rpt_del_feeds_info_list.has()) && (localRspBody.rpt_del_feeds_info_list.get() != null)) {
          b(localRspBody, paramFromServiceMsg, bool);
        }
      }
      else
      {
        a(paramToServiceMsg);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handle0x8c8UpdateUpvoteAndComment error! msg=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.d("RIJUpvoteAndCommentHandler", 1, paramFromServiceMsg.toString());
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated())
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) {
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJUpvoteAndCommentHandler.1(this, paramString, paramInt1, paramInt2, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.RIJUpvoteAndCommentHandler
 * JD-Core Version:    0.7.0.1
 */