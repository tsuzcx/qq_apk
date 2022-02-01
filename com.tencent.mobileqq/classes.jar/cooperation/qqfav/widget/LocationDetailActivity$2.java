package cooperation.qqfav.widget;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.QfavUtil;
import mqq.app.AppRuntime;

class LocationDetailActivity$2
  extends FavoriteActionSheet
{
  LocationDetailActivity$2(LocationDetailActivity paramLocationDetailActivity, Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, paramActions, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    if (LocationDetailActivity.a(this.a))
    {
      QfavUtil.a(true);
      if (LocationDetailActivity.a(this.a) != null) {
        LocationDetailActivity.a(this.a).setVisibility(8);
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity.2
 * JD-Core Version:    0.7.0.1
 */