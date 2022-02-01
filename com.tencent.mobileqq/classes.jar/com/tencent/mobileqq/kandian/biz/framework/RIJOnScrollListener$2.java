package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.biz.pubaccount.util.FeedExposureHelper.Range;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class RIJOnScrollListener$2
  extends FeedExposureHelper
{
  RIJOnScrollListener$2(RIJOnScrollListener paramRIJOnScrollListener, RIJDataManager paramRIJDataManager) {}
  
  public AbsBaseArticleInfo a(int paramInt)
  {
    Object localObject = this.a.a().v().d();
    int i;
    if (localObject != null) {
      i = ((ListView)localObject).getHeaderViewsCount();
    } else {
      i = 0;
    }
    int j = paramInt - i;
    if (j >= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getArticleInfo] position = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", headViewCount = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", articleInfo = ");
        ((StringBuilder)localObject).append(this.a.c(j));
        QLog.i("RIJOnScrollListener", 2, ((StringBuilder)localObject).toString());
      }
      return this.a.c(j);
    }
    return null;
  }
  
  public void a(FeedExposureHelper.Range paramRange)
  {
    if (paramRange != null) {
      RIJReportDataCollectionManager.a(paramRange, this.a.a().v().d().getHeaderViewsCount(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJOnScrollListener.2
 * JD-Core Version:    0.7.0.1
 */