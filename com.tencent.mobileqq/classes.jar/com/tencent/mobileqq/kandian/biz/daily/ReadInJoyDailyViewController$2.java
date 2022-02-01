package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule.LoadMorePreDealListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReadInJoyDailyViewController$2
  implements ArticleInfoModule.LoadMorePreDealListener
{
  ReadInJoyDailyViewController$2(ReadInJoyDailyViewController paramReadInJoyDailyViewController, ArticleInfoModule paramArticleInfoModule) {}
  
  private long a(List<AbsBaseArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    long l = 0L;
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      if (l < localAbsBaseArticleInfo.mRecommendSeq) {
        l = localAbsBaseArticleInfo.mRecommendSeq;
      }
    }
    return l;
  }
  
  public List<AbsBaseArticleInfo> a(int paramInt, List<AbsBaseArticleInfo> paramList1, List<AbsBaseArticleInfo> paramList2)
  {
    if ((DailyModeConfigHandler.c(paramInt)) && (paramList2 != null) && (paramList1 != null))
    {
      if (paramList2.isEmpty()) {
        return null;
      }
      long l = a(paramList2);
      if (l < 1000L)
      {
        paramList1 = new StringBuilder();
        paramList1.append("onPreDeal : ");
        paramList1.append(l);
        QLog.d("ReadInJoyDailyViewController", 1, paramList1.toString());
        return null;
      }
      paramList2 = new ArrayList();
      if (!ReadInJoyDailyViewController.a())
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList1.next();
          if ((localAbsBaseArticleInfo.mRecommendSeq > 0L) && (localAbsBaseArticleInfo.mRecommendSeq < 1000L))
          {
            localAbsBaseArticleInfo.mRecommendSeq += l;
            paramList2.add(localAbsBaseArticleInfo);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPreDeal : ");
            localStringBuilder.append(l);
            localStringBuilder.append("  seq: ");
            localStringBuilder.append(localAbsBaseArticleInfo.mRecommendSeq);
            QLog.d("ReadInJoyDailyViewController", 1, localStringBuilder.toString());
          }
        }
      }
      RIJSPUtils.a(ReadInJoyDailyViewController.a(), Boolean.valueOf(true));
      ReadInJoyDailyViewController.a(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.a(null);
      return paramList2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController.2
 * JD-Core Version:    0.7.0.1
 */