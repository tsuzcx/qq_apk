import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.AggregatedList;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;

public class qks
{
  public ArrayList<qkt> a;
  articlesummary.AggregatedList a;
  
  public static qks a(articlesummary.AggregatedList paramAggregatedList)
  {
    if ((paramAggregatedList != null) && (paramAggregatedList.rpt_article_summary.has()))
    {
      qks localqks = new qks();
      Object localObject = paramAggregatedList.rpt_article_summary.get();
      localqks.jdField_a_of_type_JavaUtilArrayList = new ArrayList(((List)localObject).size());
      localqks.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$AggregatedList = paramAggregatedList;
      paramAggregatedList = ((List)localObject).iterator();
      while (paramAggregatedList.hasNext())
      {
        localObject = (articlesummary.ArticleSummary)paramAggregatedList.next();
        articlesummary.FeedsInfo localFeedsInfo = (articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject).msg_feeds_info.get();
        qkt localqkt = new qkt();
        localqkt.jdField_a_of_type_Long = ((articlesummary.ArticleSummary)localObject).msg_feeds_info.msg_social_feeds_info.uint64_feeds_id.get();
        localqkt.jdField_b_of_type_Long = ((articlesummary.ArticleSummary)localObject).uint64_algorithm_id.get();
        if (localFeedsInfo.feeds_type.has()) {
          localqkt.jdField_a_of_type_Int = localFeedsInfo.feeds_type.get();
        }
        if (((articlesummary.ArticleSummary)localObject).uint32_strategy_id.has()) {
          localqkt.jdField_b_of_type_Int = ((articlesummary.ArticleSummary)localObject).uint32_strategy_id.get();
        }
        if (((articlesummary.ArticleSummary)localObject).uint64_recommend_seq.has()) {
          localqkt.c = ((articlesummary.ArticleSummary)localObject).uint64_recommend_seq.get();
        }
        localqks.jdField_a_of_type_JavaUtilArrayList.add(localqkt);
      }
      return localqks;
    }
    return null;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mExtraBiuBriefInfo != null) && (!paramBaseArticleInfo.isExtraBiuExpanded) && (paramBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList != null) && (!paramBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public static boolean b(BaseArticleInfo paramBaseArticleInfo)
  {
    return (paramBaseArticleInfo.mExtraBiuBriefInfo != null) && (paramBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList != null) && (!paramBaseArticleInfo.mExtraBiuBriefInfo.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public byte[] a()
  {
    return ((articlesummary.AggregatedList)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$AggregatedList.get()).toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qks
 * JD-Core Version:    0.7.0.1
 */