package cooperation.qqfav.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationDetailActivity$4
  implements View.OnClickListener
{
  LocationDetailActivity$4(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.4
 * JD-Core Version:    0.7.0.1
 */