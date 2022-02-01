import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pfr
  implements View.OnClickListener
{
  pfr(pfq parampfq, pdp parampdp, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QLog.d("GuideHelper", 1, "getBottomGuideView : " + pfq.a(this.jdField_a_of_type_Pfq));
    pfq.a(this.jdField_a_of_type_Pfq, "0X8009FEA", this.jdField_a_of_type_Pdp.a);
    pkh.a(this.jdField_a_of_type_AndroidContentContext, pfq.a(this.jdField_a_of_type_Pfq));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfr
 * JD-Core Version:    0.7.0.1
 */