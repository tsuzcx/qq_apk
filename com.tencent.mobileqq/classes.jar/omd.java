import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;

class omd
  implements View.OnClickListener
{
  omd(omc paramomc, View paramView) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Omc.a).a(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omd
 * JD-Core Version:    0.7.0.1
 */