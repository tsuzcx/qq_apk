import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJUpvoteAndCommentHandler.1;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJUpvoteAndCommentHandler.2;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJUpvoteAndCommentHandler.3;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.common.app.AppInterface;
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

public class qjf
  extends qii
{
  public qjf(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  private void a(long paramLong, int paramInt, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_Qep.a().c(paramInt).values().iterator();
    while (localIterator.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
      if ((localArticleInfo != null) && (localArticleInfo.mFeedId == paramLong) && (localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null))
      {
        rsh localrsh = localArticleInfo.mTopicRecommendFeedsInfo;
        if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (localrsh != null) && (localrsh.a != null))
        {
          Object localObject = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
          if (((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject).msg_topic_recommend_info.has())
          {
            localObject = ((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject).msg_topic_recommend_info.get();
            paramInt = 0;
            while ((paramInt < ((List)localObject).size()) && (paramInt < localrsh.a.size()))
            {
              oidb_cmd0x8c8.TopicRecommendInfo localTopicRecommendInfo = (oidb_cmd0x8c8.TopicRecommendInfo)((List)localObject).get(paramInt);
              rsj localrsj = (rsj)localrsh.a.get(paramInt);
              if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
                localrsj.b = localTopicRecommendInfo.uint32_number_of_participants.get();
              }
              paramInt += 1;
            }
          }
        }
        localArticleInfo.invalidateProteusTemplateBean();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if ((paramArticleInfo2.mFeedId != paramArticleInfo1.mFeedId) && (paramArticleInfo2.mSocialFeedInfo != null))
    {
      int j = 0;
      int i = j;
      if (paramArticleInfo2.mSocialFeedInfo.h != 2)
      {
        i = j;
        if (paramArticleInfo1.mSocialFeedInfo.h == 2) {
          i = 1;
        }
      }
      paramArticleInfo2.mSocialFeedInfo.h = paramArticleInfo1.mSocialFeedInfo.h;
      this.jdField_a_of_type_Qep.a(paramArticleInfo2);
      paramArticleInfo1 = this.jdField_a_of_type_Qep.a().a(paramArticleInfo2, (int)paramArticleInfo2.mChannelID);
      if ((i != 0) && (paramArticleInfo1 != null)) {
        paramArticleInfo1.isNeedShowBtnWhenFollowed = true;
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo, int paramInt)
  {
    if (paramArticleInfo == null) {}
    int i;
    do
    {
      do
      {
        return;
        if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.a != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.a.size() > 0))
        {
          a(paramArticleInfo.mFeedId, paramInt, paramSocializeFeedsInfo);
          this.jdField_a_of_type_Qep.a(paramArticleInfo);
          return;
        }
      } while (paramArticleInfo.mSocialFeedInfo == null);
      i = paramArticleInfo.mSocialFeedInfo.h;
      paramArticleInfo.mSocialFeedInfo.a(paramSocializeFeedsInfo);
      this.jdField_a_of_type_Qep.a(paramArticleInfo);
      paramSocializeFeedsInfo = this.jdField_a_of_type_Qep.a().a(paramArticleInfo, paramInt);
    } while (paramSocializeFeedsInfo == null);
    if ((i != 2) && (paramArticleInfo.mSocialFeedInfo.h == 2)) {
      paramSocializeFeedsInfo.isNeedShowBtnWhenFollowed = true;
    }
    paramSocializeFeedsInfo.invalidateProteusTemplateBean();
  }
  
  private void a(ToServiceMsg paramToServiceMsg)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("0x8c8_retry_times")).intValue();
    if (i < 0)
    {
      paramToServiceMsg.addAttribute("0x8c8_retry_times", Integer.valueOf(i + 1));
      this.jdField_a_of_type_Qep.a(paramToServiceMsg);
      return;
    }
    QLog.d("RIJUpvoteAndCommentHandler", 1, "retry times:" + i + " exceeds");
  }
  
  private void a(ConcurrentMap<Long, ArticleInfo> paramConcurrentMap, long paramLong, int paramInt, List<Long> paramList)
  {
    ArticleInfo localArticleInfo;
    if (paramConcurrentMap != null)
    {
      Iterator localIterator = paramConcurrentMap.values().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localArticleInfo = (ArticleInfo)localIterator.next();
      } while ((localArticleInfo.mFeedId != paramLong) || (localArticleInfo.mFeedType != paramInt));
    }
    for (;;)
    {
      if (localArticleInfo != null)
      {
        paramConcurrentMap.remove(Long.valueOf(localArticleInfo.mRecommendSeq));
        this.jdField_a_of_type_Qep.a().a(Integer.valueOf(0), localArticleInfo);
        paramList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
      return;
      localArticleInfo = null;
    }
  }
  
  private void a(oidb_cmd0x8c8.RspBody paramRspBody, ConcurrentHashMap<String, ArticleInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    if ((!paramRspBody.rpt_social_feeds_info.has()) || (paramRspBody.rpt_social_feeds_info.get() == null)) {
      return;
    }
    paramRspBody = paramRspBody.rpt_social_feeds_info.get();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJUpvoteAndCommentHandler.2(this, paramRspBody, paramConcurrentHashMap, paramBoolean));
  }
  
  private boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramArticleInfo.publishUin != 0L)
    {
      localObject = "publishUin = " + paramArticleInfo.publishUin;
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, (String)localObject, null, null, null, "mRecommendSeq desc", null);
      if (localObject == null)
      {
        QLog.d("RIJUpvoteAndCommentHandler", 1, "no soical feeds to update article.publishUin:" + paramArticleInfo.publishUin);
        bool1 = false;
      }
    }
    else
    {
      return bool1;
    }
    Object localObject = ((List)localObject).iterator();
    for (;;)
    {
      bool1 = bool2;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      a(paramArticleInfo, (ArticleInfo)((Iterator)localObject).next());
    }
  }
  
  private void b(ConcurrentMap<Long, ArticleInfo> paramConcurrentMap, long paramLong, int paramInt, List<Long> paramList)
  {
    ArticleInfo localArticleInfo;
    if (paramConcurrentMap != null)
    {
      Iterator localIterator = paramConcurrentMap.values().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localArticleInfo = (ArticleInfo)localIterator.next();
      } while ((localArticleInfo.mFeedId != paramLong) || (localArticleInfo.mFeedType != paramInt));
    }
    for (;;)
    {
      if (localArticleInfo != null)
      {
        paramConcurrentMap.remove(Long.valueOf(localArticleInfo.mRecommendSeq));
        this.jdField_a_of_type_Qep.a().a(Integer.valueOf(70), localArticleInfo);
        paramList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
      return;
      localArticleInfo = null;
    }
  }
  
  private void b(oidb_cmd0x8c8.RspBody paramRspBody, ConcurrentHashMap<String, ArticleInfo> paramConcurrentHashMap, boolean paramBoolean)
  {
    paramRspBody = paramRspBody.rpt_del_feeds_info_list.get();
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJUpvoteAndCommentHandler.3(this, paramRspBody, paramConcurrentHashMap));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x8c8.RspBody localRspBody = new oidb_cmd0x8c8.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, localRspBody);
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
      QLog.d("RIJUpvoteAndCommentHandler", 1, "handle0x8c8UpdateUpvoteAndComment error! msg=" + paramToServiceMsg);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJUpvoteAndCommentHandler.1(this, paramString, paramInt1, paramInt2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjf
 * JD-Core Version:    0.7.0.1
 */