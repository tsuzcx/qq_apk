import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ovm
  implements View.OnClickListener
{
  ovm(ovk paramovk, ovn paramovn) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Ovk.a, ovn.c(this.jdField_a_of_type_Ovn));
    olh.a(null, "CliOper", "", ovn.c(this.jdField_a_of_type_Ovn), "0X80078A8", "0X80078A8", 0, 0, "", "", "", pqf.a(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovm
 * JD-Core Version:    0.7.0.1
 */