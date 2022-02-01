package com.tencent.mobileqq.kandian.repo.feeds.entity;

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

public class ExtraBiuBriefInfo
{
  public ArrayList<ExtraBiuBriefInfo.BiuBriefInfoItem> a;
  articlesummary.AggregatedList b;
  
  public static ExtraBiuBriefInfo a(articlesummary.AggregatedList paramAggregatedList)
  {
    if ((paramAggregatedList != null) && (paramAggregatedList.rpt_article_summary.has()))
    {
      ExtraBiuBriefInfo localExtraBiuBriefInfo = new ExtraBiuBriefInfo();
      Object localObject = paramAggregatedList.rpt_article_summary.get();
      localExtraBiuBriefInfo.a = new ArrayList(((List)localObject).size());
      localExtraBiuBriefInfo.b = paramAggregatedList;
      paramAggregatedList = ((List)localObject).iterator();
      while (paramAggregatedList.hasNext())
      {
        localObject = (articlesummary.ArticleSummary)paramAggregatedList.next();
        articlesummary.FeedsInfo localFeedsInfo = (articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject).msg_feeds_info.get();
        ExtraBiuBriefInfo.BiuBriefInfoItem localBiuBriefInfoItem = new ExtraBiuBriefInfo.BiuBriefInfoItem();
        localBiuBriefInfoItem.a = ((articlesummary.ArticleSummary)localObject).msg_feeds_info.msg_social_feeds_info.uint64_feeds_id.get();
        localBiuBriefInfoItem.c = ((articlesummary.ArticleSummary)localObject).uint64_algorithm_id.get();
        if (localFeedsInfo.feeds_type.has()) {
          localBiuBriefInfoItem.b = localFeedsInfo.feeds_type.get();
        }
        if (((articlesummary.ArticleSummary)localObject).uint32_strategy_id.has()) {
          localBiuBriefInfoItem.d = ((articlesummary.ArticleSummary)localObject).uint32_strategy_id.get();
        }
        if (((articlesummary.ArticleSummary)localObject).uint64_recommend_seq.has()) {
          localBiuBriefInfoItem.e = ((articlesummary.ArticleSummary)localObject).uint64_recommend_seq.get();
        }
        localExtraBiuBriefInfo.a.add(localBiuBriefInfoItem);
      }
      return localExtraBiuBriefInfo;
    }
    return null;
  }
  
  public byte[] a()
  {
    return ((articlesummary.AggregatedList)this.b.get()).toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ExtraBiuBriefInfo
 * JD-Core Version:    0.7.0.1
 */