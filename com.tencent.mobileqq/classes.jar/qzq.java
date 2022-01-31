import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class qzq
  implements View.OnClickListener
{
  qzq(qzo paramqzo, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to recommend feeds");
      rcb.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(0, 2130772289);
      this.jdField_a_of_type_Qzo.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzq
 * JD-Core Version:    0.7.0.1
 */