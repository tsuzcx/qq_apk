import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class owr
  implements View.OnClickListener
{
  owr(owq paramowq, ouo paramouo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d("GuideHelper", 1, "getBottomGuideView : " + owq.a(this.jdField_a_of_type_Owq));
    owq.a(this.jdField_a_of_type_Owq, "0X8009FEA", this.jdField_a_of_type_Ouo.a);
    pay.a(this.jdField_a_of_type_AndroidContentContext, owq.a(this.jdField_a_of_type_Owq));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     owr
 * JD-Core Version:    0.7.0.1
 */