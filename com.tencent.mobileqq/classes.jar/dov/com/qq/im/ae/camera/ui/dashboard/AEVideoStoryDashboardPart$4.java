package dov.com.qq.im.ae.camera.ui.dashboard;

import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEVideoStoryDashboardPart$4
  implements CompoundButton.OnCheckedChangeListener
{
  AEVideoStoryDashboardPart$4(AEVideoStoryDashboardPart paramAEVideoStoryDashboardPart) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    RecyclerView localRecyclerView = AEVideoStoryDashboardPart.c(this.a);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRecyclerView.setVisibility(i);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.4
 * JD-Core Version:    0.7.0.1
 */