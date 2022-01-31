import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lpz
  implements Runnable
{
  public lpz(ArticleInfoModule paramArticleInfoModule, long paramLong1, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, List paramList1, boolean paramBoolean2, long paramLong2, List paramList2) {}
  
  public void run()
  {
    boolean bool3 = false;
    boolean bool1;
    StringBuilder localStringBuilder;
    int i;
    if (this.jdField_a_of_type_Long == -1L)
    {
      bool1 = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ArrayOfByte);
      if (!this.jdField_a_of_type_Boolean) {
        break label453;
      }
      localStringBuilder = new StringBuilder("\n");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label311;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      label72:
      if (!((Iterator)localObject).hasNext()) {
        break label311;
      }
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      localStringBuilder.append("article【" + i + "】 id : " + localArticleInfo.mArticleID + " seq : " + localArticleInfo.mRecommendSeq + " title : " + ReadInJoyUtils.c(localArticleInfo.mTitle) + " , groupID : " + localArticleInfo.mGroupId + " algorithmID : " + localArticleInfo.mAlgorithmID + " strategyId : " + localArticleInfo.mStrategyId + " businessID : " + localArticleInfo.businessId + " businessName :" + localArticleInfo.businessName);
      if (!QLog.isColorLevel()) {
        break label300;
      }
      if (localArticleInfo.mSocialFeedInfo == null) {
        break label289;
      }
      localStringBuilder.append(" " + localArticleInfo.mSocialFeedInfo);
      localStringBuilder.append("\n");
    }
    for (;;)
    {
      i += 1;
      break label72;
      bool1 = false;
      break;
      label289:
      localStringBuilder.append("\n");
      continue;
      label300:
      localStringBuilder.append("\n");
    }
    label311:
    Object localObject = new StringBuilder().append("handleRefreshChannel success=").append(this.jdField_a_of_type_Boolean).append(" channelId=").append(this.jdField_a_of_type_Int).append(" noMoreData=").append(this.jdField_b_of_type_Boolean).append(" beginRecommendSeq=").append(this.jdField_a_of_type_Long).append(" endRecommendSeq=").append(this.jdField_b_of_type_Long).append(" isInMsgTab : ");
    boolean bool2 = bool3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a != null)
    {
      bool2 = bool3;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a instanceof QQAppInterface)) {
        bool2 = true;
      }
    }
    QLog.i("ArticleInfoModule", 1, bool2 + " isRefresh : " + bool1 + ", " + localStringBuilder.toString());
    label453:
    if (bool1)
    {
      ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_b_of_type_JavaUtilList);
      return;
    }
    ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpz
 * JD-Core Version:    0.7.0.1
 */