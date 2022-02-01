package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;

class RIJOnScrollListener$1
  implements Runnable
{
  RIJOnScrollListener$1(RIJOnScrollListener paramRIJOnScrollListener) {}
  
  public void run()
  {
    if ((((IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class)).checkAndReportAdExposure(this.this$0.e.a().v(), (Activity)this.this$0.e.a().A(), true)) && (this.this$0.e.a().b() != null)) {
      this.this$0.e.a().b().a(this.this$0.e.a().v(), (Activity)this.this$0.e.a().A());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJOnScrollListener.1
 * JD-Core Version:    0.7.0.1
 */