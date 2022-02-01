package dov.com.qq.im.ae.camera.ui.dashboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;

class AEVideoStoryDashboardPart$1
  implements View.OnClickListener
{
  AEVideoStoryDashboardPart$1(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onClick(View paramView)
  {
    AEVideoStoryDashboardPart.a(this.a).a(655364, new Object[] { "热门玩法", "vt_pag_jiaopiangushi" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.1
 * JD-Core Version:    0.7.0.1
 */