import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sdp
  implements View.OnClickListener
{
  sdp(sdn paramsdn, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to recommend feeds");
      sgr.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 2130772315);
      this.jdField_a_of_type_Sdn.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdp
 * JD-Core Version:    0.7.0.1
 */