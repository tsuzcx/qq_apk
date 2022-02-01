package com.tencent.mobileqq.kandian.repo.comment;

import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ControlParam;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqMsgInfo;

class RIJUpvoteAndCommentHandler$1
  implements Runnable
{
  RIJUpvoteAndCommentHandler$1(RIJUpvoteAndCommentHandler paramRIJUpvoteAndCommentHandler, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    if ("-1".equals(this.a))
    {
      localObject1 = "mFeedId != 0 ";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mFeedId = ");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(" and mFeedType =");
      ((StringBuilder)localObject1).append(this.b);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = localObject1;
    if (this.c != -1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" and mChannelID =");
      ((StringBuilder)localObject2).append(this.c);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("request0x8c8UpdateUpvoteAndComment selection:");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("RIJUpvoteAndCommentHandler", 1, ((StringBuilder)localObject1).toString());
    }
    QLog.d("RIJUpvoteAndCommentHandler", 1, new Object[] { "req 8c8, feedsId = ", this.a, ", feedsType = ", Integer.valueOf(this.b) });
    Object localObject3 = RIJUpvoteAndCommentHandler.a(this.this$0).query(BaseArticleInfo.class, true, (String)localObject2, null, null, null, "mRecommendSeq desc", null);
    if (localObject3 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("no soical feeds to update feedsid:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("RIJUpvoteAndCommentHandler", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = new ConcurrentHashMap();
    localObject2 = new oidb_cmd0x8c8.ReqBody();
    ((oidb_cmd0x8c8.ReqBody)localObject2).uint64_uin.set(Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue());
    ((oidb_cmd0x8c8.ReqBody)localObject2).uint32_version.set(1);
    ArrayList localArrayList = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    do
    {
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject3).next();
      Object localObject4 = new oidb_cmd0x8c8.ReqMsgInfo();
      ((oidb_cmd0x8c8.ReqMsgInfo)localObject4).uint64_feeds_id.set(localAbsBaseArticleInfo.mFeedId);
      ((oidb_cmd0x8c8.ReqMsgInfo)localObject4).uint32_business_id.set((int)localAbsBaseArticleInfo.businessId);
      if (localAbsBaseArticleInfo.mSocialFeedInfo != null) {
        ((oidb_cmd0x8c8.ReqMsgInfo)localObject4).uint32_feeds_style.set(localAbsBaseArticleInfo.mSocialFeedInfo.b);
      }
      ((oidb_cmd0x8c8.ReqMsgInfo)localObject4).feeds_type.set(localAbsBaseArticleInfo.mFeedType);
      if ((localAbsBaseArticleInfo.mFeedType == 14) && (localAbsBaseArticleInfo.mTopicRecommendFeedsInfo != null) && (localAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g != null))
      {
        Iterator localIterator = localAbsBaseArticleInfo.mTopicRecommendFeedsInfo.g.iterator();
        while (localIterator.hasNext())
        {
          TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next();
          ((oidb_cmd0x8c8.ReqMsgInfo)localObject4).rpt_topic_id.add(Integer.valueOf(localTopicRecommendInfo.a));
        }
      }
      localArrayList.add(localObject4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mFeedId);
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mFeedType);
      ((StringBuilder)localObject4).append(localAbsBaseArticleInfo.mChannelID);
      ((ConcurrentHashMap)localObject1).put(((StringBuilder)localObject4).toString(), localAbsBaseArticleInfo);
    } while (localArrayList.size() < 100);
    ((oidb_cmd0x8c8.ReqBody)localObject2).rpt_msg_info_list.set(localArrayList);
    ((oidb_cmd0x8c8.ReqBody)localObject2).control_req_param.set(new oidb_cmd0x8c8.ControlParam());
    ((oidb_cmd0x8c8.ReqBody)localObject2).control_req_param.uint32_need_follow_status.set(1);
    localObject2 = ReadInJoyOidbHelper.a("OidbSvc.0x8c8", 2248, 0, ((oidb_cmd0x8c8.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject2).addAttribute("0x8c8_retry_times", Integer.valueOf(0));
    ((ToServiceMsg)localObject2).addAttribute("0x8c8_articleMap", localObject1);
    ((ToServiceMsg)localObject2).addAttribute("isUpdateByAccount", Boolean.valueOf(this.d));
    RIJUpvoteAndCommentHandler.b(this.this$0).sendPbReq((ToServiceMsg)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.RIJUpvoteAndCommentHandler.1
 * JD-Core Version:    0.7.0.1
 */