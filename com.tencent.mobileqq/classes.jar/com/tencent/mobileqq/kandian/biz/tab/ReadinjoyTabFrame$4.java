package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.util.api.IQIMShortVideoUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.qroute.QRoute;

class ReadinjoyTabFrame$4
  implements View.OnClickListener
{
  ReadinjoyTabFrame$4(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    RIJTabFrameDeliverPopupUtil.a(paramView, ReadinjoyTabFrame.c(paramView), false);
    if (BaseApplicationImpl.sProcessId != 9) {
      ((IQIMShortVideoUtil)QRoute.api(IQIMShortVideoUtil.class)).preLoadPeakProcess(BaseApplicationImpl.getContext());
    }
    RIJFrameworkReportManager.a("1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.4
 * JD-Core Version:    0.7.0.1
 */