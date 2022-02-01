import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pcz
  implements View.OnClickListener
{
  pcz(pcy parampcy, pay parampay, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d("GuideHelper", 1, "getBottomGuideView : " + pcy.a(this.jdField_a_of_type_Pcy));
    pcy.a(this.jdField_a_of_type_Pcy, "0X8009FEA", this.jdField_a_of_type_Pay.a);
    pha.a(this.jdField_a_of_type_AndroidContentContext, pcy.a(this.jdField_a_of_type_Pcy));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcz
 * JD-Core Version:    0.7.0.1
 */