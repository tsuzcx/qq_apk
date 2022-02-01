package cooperation.qzone.share;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QZoneShareActivity$6
  implements View.OnClickListener
{
  QZoneShareActivity$6(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void onClick(View paramView)
  {
    QZoneShareActivity.access$700(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.6
 * JD-Core Version:    0.7.0.1
 */