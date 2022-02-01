import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ome
  implements View.OnClickListener
{
  ome(omc paramomc, omf paramomf) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Omc.a, omf.c(this.jdField_a_of_type_Omf));
    ocd.a(null, "CliOper", "", omf.c(this.jdField_a_of_type_Omf), "0X80078A8", "0X80078A8", 0, 0, "", "", "", ozs.e(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ome
 * JD-Core Version:    0.7.0.1
 */