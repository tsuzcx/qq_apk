package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.entry.AECameraEntry;

class AEProviderContainerView$1
  implements View.OnClickListener
{
  AEProviderContainerView$1(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      StoryReportor.a("clk_filter", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
      if (AEProviderContainerView.a(this.a) != 0)
      {
        AEProviderContainerView.a(this.a);
        if (AECameraEntry.k(((Activity)this.a.getContext()).getIntent()))
        {
          AEReportUtils.b(12, null);
          continue;
          StoryReportor.a("clk_beauty", StoryReportor.b(CaptureReportUtil.a), 0, false, new String[0]);
          if (AEProviderContainerView.a(this.a) != 1)
          {
            AEProviderContainerView.b(this.a);
            if (AECameraEntry.k(((Activity)this.a.getContext()).getIntent())) {
              AEReportUtils.b(11, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView.1
 * JD-Core Version:    0.7.0.1
 */