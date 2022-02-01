import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogw
  implements View.OnClickListener
{
  ogw(ogs paramogs) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToRefresh");
    ogs.a(this.a, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogw
 * JD-Core Version:    0.7.0.1
 */