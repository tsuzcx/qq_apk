import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class okx
  implements View.OnClickListener
{
  okx(okv paramokv, oky paramoky) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Okv.a, oky.c(this.jdField_a_of_type_Oky));
    oat.a(null, "CliOper", "", oky.c(this.jdField_a_of_type_Oky), "0X80078A8", "0X80078A8", 0, 0, "", "", "", pha.e(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okx
 * JD-Core Version:    0.7.0.1
 */