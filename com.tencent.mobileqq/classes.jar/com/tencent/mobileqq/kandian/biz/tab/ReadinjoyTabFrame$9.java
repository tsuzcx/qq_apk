package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

class ReadinjoyTabFrame$9
  implements Runnable
{
  ReadinjoyTabFrame$9(ReadinjoyTabFrame paramReadinjoyTabFrame, ReadInJoyBaseFragment paramReadInJoyBaseFragment) {}
  
  public void run()
  {
    if (this.a.v() != null) {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "FragmentOnStartError", true, NetConnInfoCenter.getServerTimeMillis() - ReadinjoyTabFrame.g(this.this$0), 0L, null, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.9
 * JD-Core Version:    0.7.0.1
 */