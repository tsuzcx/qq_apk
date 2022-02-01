package cooperation.vip.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FileBannerTianshuManger$4$2
  implements View.OnClickListener
{
  FileBannerTianshuManger$4$2(FileBannerTianshuManger.4 param4) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.h.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.4.2
 * JD-Core Version:    0.7.0.1
 */