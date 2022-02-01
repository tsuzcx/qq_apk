import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class onp
  implements View.OnClickListener
{
  onp(onn paramonn, onq paramonq) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Onn.a, onq.c(this.jdField_a_of_type_Onq));
    odq.a(null, "CliOper", "", onq.c(this.jdField_a_of_type_Onq), "0X80078A8", "0X80078A8", 0, 0, "", "", "", pay.f(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onp
 * JD-Core Version:    0.7.0.1
 */