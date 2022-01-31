import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

public class lpq
  implements Runnable
{
  public lpq(ArticleInfoModule paramArticleInfoModule, List paramList, ConcurrentHashMap paramConcurrentHashMap, boolean paramBoolean) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.a();
    localEntityTransaction.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      oidb_cmd0x8c8.FeedsInfo localFeedsInfo = (oidb_cmd0x8c8.FeedsInfo)localIterator.next();
      Object localObject2;
      long l;
      for (;;)
      {
        try
        {
          if ((!localFeedsInfo.has()) || (localFeedsInfo.get() == null) || (!localFeedsInfo.msg_social_fees_info.has()) || (localFeedsInfo.msg_social_fees_info.get() == null)) {
            break;
          }
          localObject2 = (oidb_cmd0x8c8.SocializeFeedsInfo)localFeedsInfo.msg_social_fees_info.get();
          if (!((oidb_cmd0x8c8.SocializeFeedsInfo)localObject2).uint64_feeds_id.has()) {
            break label153;
          }
          l = ((oidb_cmd0x8c8.SocializeFeedsInfo)localObject2).uint64_feeds_id.get();
          if (l != 0L) {
            break label158;
          }
          QLog.d("ArticleInfoModule", 1, "convertPBToInfo failed feedsInfo feedsId == 0");
        }
        catch (Exception localException)
        {
          QLog.d("ArticleInfoModule", 1, "handle0x8c8UpdateUpvoteAndComment merge failed ", localException);
        }
        break;
        label153:
        l = 0L;
      }
      label158:
      if (!localException.feeds_type.has())
      {
        QLog.d("ArticleInfoModule", 1, "convertPBToInfo failed feedsInfo feeds_type == null");
      }
      else
      {
        int i = localException.feeds_type.get();
        Object localObject1 = l + "" + i;
        ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get((String)localObject1 + 0);
        if (localArticleInfo != null) {
          ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, localArticleInfo, (oidb_cmd0x8c8.SocializeFeedsInfo)localObject2, 0);
        }
        localObject1 = (ArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get((String)localObject1 + 70);
        if (localObject1 != null) {
          ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, (ArticleInfo)localObject1, (oidb_cmd0x8c8.SocializeFeedsInfo)localObject2, 70);
        }
        if ((this.jdField_a_of_type_Boolean) && (localObject1 != null) && (((ArticleInfo)localObject1).mSocialFeedInfo != null) && (((ArticleInfo)localObject1).publishUin != 0L))
        {
          localObject2 = "publishUin = " + ((ArticleInfo)localObject1).publishUin;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.a(ArticleInfo.class, true, (String)localObject2, null, null, null, "mRecommendSeq desc", null);
          if (localObject2 == null)
          {
            QLog.d("ArticleInfoModule", 1, "no soical feeds to update article.publishUin:" + ((ArticleInfo)localObject1).publishUin);
            return;
          }
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localArticleInfo = (ArticleInfo)((Iterator)localObject2).next();
            if ((localArticleInfo.mFeedId != ((ArticleInfo)localObject1).mFeedId) && (localArticleInfo.mSocialFeedInfo != null))
            {
              int j = 0;
              i = j;
              if (localArticleInfo.mSocialFeedInfo.h != 2)
              {
                i = j;
                if (((ArticleInfo)localObject1).mSocialFeedInfo.h == 2) {
                  i = 1;
                }
              }
              localArticleInfo.mSocialFeedInfo.h = ((ArticleInfo)localObject1).mSocialFeedInfo.h;
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localArticleInfo);
              localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localArticleInfo, 70);
              if ((i != 0) && (localArticleInfo != null)) {
                localArticleInfo.isNeedShowBtnWhenFollowed = true;
              }
            }
          }
        }
      }
    }
    localEntityTransaction.c();
    localEntityTransaction.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpq
 * JD-Core Version:    0.7.0.1
 */