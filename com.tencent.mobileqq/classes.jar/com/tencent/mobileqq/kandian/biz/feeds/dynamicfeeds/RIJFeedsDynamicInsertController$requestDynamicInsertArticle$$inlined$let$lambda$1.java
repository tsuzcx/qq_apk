package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertController$requestDynamicInsertArticle$1$1", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertModule$Companion$IFeedsDynamicInsertCallback;", "insert", "", "feedsInsertArticle", "Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/data/RIJFeedsInsertArticle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertController$requestDynamicInsertArticle$$inlined$let$lambda$1
  implements RIJFeedsDynamicInsertModule.Companion.IFeedsDynamicInsertCallback
{
  RIJFeedsDynamicInsertController$requestDynamicInsertArticle$$inlined$let$lambda$1(int paramInt, String paramString, RIJFeedsInsertAction paramRIJFeedsInsertAction, RIJFeedsDynamicInsertController.IWatchInfoCallback paramIWatchInfoCallback) {}
  
  public void a(@Nullable RIJFeedsInsertArticle paramRIJFeedsInsertArticle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqSource: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", rowkey: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", articles from server: ");
    String str;
    if (paramRIJFeedsInsertArticle != null) {
      str = paramRIJFeedsInsertArticle.b();
    } else {
      str = null;
    }
    localStringBuilder.append(str);
    QLog.d("RIJFeedsDynamicInsertController", 1, localStringBuilder.toString());
    if (RIJFeedsDynamicInsertController.access$needRecordAction(RIJFeedsDynamicInsertController.INSTANCE, paramRIJFeedsInsertArticle, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJFeedsInsertAction))
    {
      QLog.d("RIJFeedsDynamicInsertController", 1, "requestDynamicInsertArticle needrecord");
      RIJFeedsDynamicInsertRecordAction.a.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsRIJFeedsInsertAction.a());
    }
    RIJFeedsDynamicInsertController.access$getWatchInfo(RIJFeedsDynamicInsertController.INSTANCE, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertController$IWatchInfoCallback, paramRIJFeedsInsertArticle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.requestDynamicInsertArticle..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */