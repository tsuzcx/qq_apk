package cooperation.qqfav.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationDetailActivity$3
  implements View.OnClickListener
{
  LocationDetailActivity$3(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    LocationDetailActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.3
 * JD-Core Version:    0.7.0.1
 */