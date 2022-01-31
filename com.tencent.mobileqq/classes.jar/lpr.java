import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
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
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqMsgInfo;

public class lpr
  implements Runnable
{
  public lpr(ArticleInfoModule paramArticleInfoModule, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_Long == -1L)
    {
      localObject1 = "mFeedId != 0 ";
      if (this.b == -1) {
        break label544;
      }
      localObject1 = (String)localObject1 + " and mChannelID =" + this.b;
    }
    label544:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 1, "request0x8c8UpdateUpvoteAndComment selection:" + (String)localObject1);
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.a(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
      if (localObject3 == null)
      {
        QLog.d("ArticleInfoModule", 1, "no soical feeds to update feedsid:" + this.jdField_a_of_type_Long);
        return;
        localObject1 = "mFeedId = " + String.valueOf(this.jdField_a_of_type_Long) + " and mFeedType =" + this.jdField_a_of_type_Int;
        break;
      }
      localObject1 = new ConcurrentHashMap();
      Object localObject2 = new oidb_cmd0x8c8.ReqBody();
      ((oidb_cmd0x8c8.ReqBody)localObject2).uint64_uin.set(Long.valueOf(ReadInJoyUtils.a()).longValue());
      ((oidb_cmd0x8c8.ReqBody)localObject2).uint32_version.set(1);
      ArrayList localArrayList = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      do
      {
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject3).next();
        oidb_cmd0x8c8.ReqMsgInfo localReqMsgInfo = new oidb_cmd0x8c8.ReqMsgInfo();
        localReqMsgInfo.uint64_feeds_id.set(localArticleInfo.mFeedId);
        localReqMsgInfo.uint32_business_id.set((int)localArticleInfo.businessId);
        if (localArticleInfo.mSocialFeedInfo != null) {
          localReqMsgInfo.uint32_feeds_style.set(localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int);
        }
        localReqMsgInfo.feeds_type.set(localArticleInfo.mFeedType);
        if ((localArticleInfo.mFeedType == 14) && (localArticleInfo.mTopicRecommendFeedsInfo != null) && (localArticleInfo.mTopicRecommendFeedsInfo.a != null))
        {
          Iterator localIterator = localArticleInfo.mTopicRecommendFeedsInfo.a.iterator();
          while (localIterator.hasNext())
          {
            TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo = (TopicRecommendFeedsInfo.TopicRecommendInfo)localIterator.next();
            localReqMsgInfo.rpt_topic_id.add(Integer.valueOf(localTopicRecommendInfo.jdField_a_of_type_Int));
          }
        }
        localArrayList.add(localReqMsgInfo);
        ((ConcurrentHashMap)localObject1).put(localArticleInfo.mFeedId + "" + localArticleInfo.mFeedType + localArticleInfo.mChannelID, localArticleInfo);
      } while (localArrayList.size() < 100);
      ((oidb_cmd0x8c8.ReqBody)localObject2).rpt_msg_info_list.set(localArrayList);
      localObject2 = ReadInJoyOidbHelper.a("OidbSvc.0x8c8", 2248, 0, ((oidb_cmd0x8c8.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject2).addAttribute("0x8c8_retry_times", Integer.valueOf(0));
      ((ToServiceMsg)localObject2).addAttribute("0x8c8_articleMap", localObject1);
      ((ToServiceMsg)localObject2).addAttribute("isUpdateByAccount", Boolean.valueOf(this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a((ToServiceMsg)localObject2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpr
 * JD-Core Version:    0.7.0.1
 */