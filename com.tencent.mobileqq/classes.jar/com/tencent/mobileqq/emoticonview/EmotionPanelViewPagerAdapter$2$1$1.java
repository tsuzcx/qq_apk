package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.qroute.QRoute;

class EmotionPanelViewPagerAdapter$2$1$1
  implements Runnable
{
  EmotionPanelViewPagerAdapter$2$1$1(EmotionPanelViewPagerAdapter.2.1 param1) {}
  
  public void run()
  {
    ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report("aio", "emojicmtab", "move", new DtReportParamsBuilder().h(((IApolloUtil)QRoute.api(IApolloUtil.class)).getEmoticonPanelFromEntrance()).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */