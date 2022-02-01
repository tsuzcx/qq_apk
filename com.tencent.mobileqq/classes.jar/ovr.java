import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ovr
  implements View.OnClickListener
{
  ovr(ovq paramovq, otp paramotp, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d("GuideHelper", 1, "getBottomGuideView : " + ovq.a(this.jdField_a_of_type_Ovq));
    ovq.a(this.jdField_a_of_type_Ovq, "0X8009FEA", this.jdField_a_of_type_Otp.a);
    ozs.a(this.jdField_a_of_type_AndroidContentContext, ovq.a(this.jdField_a_of_type_Ovq));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovr
 * JD-Core Version:    0.7.0.1
 */