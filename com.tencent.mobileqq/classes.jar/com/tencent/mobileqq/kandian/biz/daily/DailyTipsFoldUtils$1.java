package com.tencent.mobileqq.kandian.biz.daily;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class DailyTipsFoldUtils$1
  implements Runnable
{
  DailyTipsFoldUtils$1(ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    QLog.i("DailyTipsFoldUtils", 2, "[foldDailyTips], smoothScroll.");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    Object localObject = this.a;
    localObject = ((ReadInJoyXListView)localObject).getChildAt(((ReadInJoyXListView)localObject).getHeaderViewsCount());
    localValueAnimator.addUpdateListener(new DailyTipsFoldUtils.1.1(this, (View)localObject, ((View)localObject).getHeight()));
    localValueAnimator.addListener(new DailyTipsFoldUtils.1.2(this, (View)localObject));
    localValueAnimator.start();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A577", "0X800A577", 0, 0, RIJQQAppInterfaceUtil.a(), "", "", RIJTransMergeKanDianReport.a().build(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyTipsFoldUtils.1
 * JD-Core Version:    0.7.0.1
 */