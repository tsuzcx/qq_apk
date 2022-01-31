import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ltb
  implements Runnable
{
  public ltb(ArticleInfoModule paramArticleInfoModule, boolean paramBoolean, List paramList1, List paramList2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() != 1) || (this.b == null) || (this.b.isEmpty())) {
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "###onGetVideoRealtimeReplaceList: reqArticleList  szie != 1 or articleInfoList is empty.");
        }
      }
      long l2;
      StringBuilder localStringBuilder;
      Object localObject2;
      long l1;
      Object localObject3;
      do
      {
        do
        {
          return;
          l2 = ((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue();
          localStringBuilder = new StringBuilder("\n");
          localObject1 = this.b.iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ArticleInfo)((Iterator)localObject1).next();
            localStringBuilder.append("实时替换 article【" + i + "】 id : " + ((ArticleInfo)localObject2).mArticleID + " seq : " + ((ArticleInfo)localObject2).mRecommendSeq + " title : " + ReadInJoyUtils.d(((ArticleInfo)localObject2).mTitle) + " , groupID : " + ((ArticleInfo)localObject2).mGroupId + " algorithmID : " + ((ArticleInfo)localObject2).mAlgorithmID + " strategyId : " + ((ArticleInfo)localObject2).mStrategyId);
            if (QLog.isColorLevel()) {
              if (((ArticleInfo)localObject2).mSocialFeedInfo != null)
              {
                localStringBuilder.append(" " + ((ArticleInfo)localObject2).mSocialFeedInfo);
                localStringBuilder.append("\n");
              }
            }
            for (;;)
            {
              i += 1;
              break;
              localStringBuilder.append("\n");
              continue;
              localStringBuilder.append("\n");
            }
          }
          QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList success=" + this.jdField_a_of_type_Boolean + " channelId=" + this.jdField_a_of_type_Int + ", reqArticleID: " + l2 + localStringBuilder.toString());
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int));
          localObject2 = ((List)localObject1).iterator();
          l1 = -1L;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int), (Long)localObject3);
            if (l2 == localArticleInfo.mArticleID)
            {
              l1 = ((Long)localObject3).longValue();
              QLog.i("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList find the original article seq：" + localObject3 + ", reqArticleID: " + l2 + ", title : " + ReadInJoyUtils.d(localArticleInfo.mTitle));
            }
          }
        } while (l1 == -1L);
        if (QLog.isColorLevel())
        {
          localStringBuilder.setLength(0);
          localStringBuilder.append("current seq list >>").append("\n");
          i = 0;
          while (i < ((List)localObject1).size())
          {
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int), (Long)((List)localObject1).get(i));
            localStringBuilder.append("article [" + i + "] seq : " + ((List)localObject1).get(i) + ", id : " + ((ArticleInfo)localObject2).mArticleID + " title : " + ReadInJoyUtils.d(((ArticleInfo)localObject2).mTitle));
            localStringBuilder.append("\n");
            i += 1;
          }
          QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
        }
        localObject2 = (ConcurrentHashMap)ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule).get(Integer.valueOf(this.jdField_a_of_type_Int));
      } while (localObject2 == null);
      int k = ((List)localObject1).size();
      int j = this.b.size();
      int i = 0;
      boolean bool;
      while (i < k)
      {
        long l3 = ((Long)((List)localObject1).get(i)).longValue();
        if (((0xFFFFFF00 & l1) == (0xFFFFFF00 & l3)) && (l3 >= l1))
        {
          localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(l3));
          ((ArticleInfo)localObject3).mRecommendSeq = (j + l3);
          ((ConcurrentHashMap)localObject2).remove(Long.valueOf(l3));
          bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Long.valueOf(((ArticleInfo)localObject3).mArticleID));
          ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, Integer.valueOf(this.jdField_a_of_type_Int), (ArticleInfo)localObject3, true, bool);
        }
        i += 1;
      }
      i = j - 1;
      while (i >= 0)
      {
        localObject1 = (ArticleInfo)this.b.get(i);
        ((ArticleInfo)localObject1).mRecommendSeq = (j + l1 - 1L - i);
        bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Long.valueOf(((ArticleInfo)localObject1).mArticleID));
        ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, Integer.valueOf(this.jdField_a_of_type_Int), (ArticleInfo)localObject1, true, bool);
        i -= 1;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int));
      if (QLog.isColorLevel())
      {
        localStringBuilder.setLength(0);
        localStringBuilder.append("new seq list >>").append("\n");
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int), (Long)((List)localObject1).get(i));
          localStringBuilder.append("article [" + i + "] seq : " + ((List)localObject1).get(i) + ", id : " + ((ArticleInfo)localObject2).mArticleID + " title : " + ReadInJoyUtils.d(((ArticleInfo)localObject2).mTitle));
          localStringBuilder.append("\n");
          i += 1;
        }
        QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
      }
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, l2, (List)localObject1, this.b);
      return;
    }
    QLog.e("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltb
 * JD-Core Version:    0.7.0.1
 */