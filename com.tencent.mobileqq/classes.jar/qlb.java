import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qlb
  implements View.OnClickListener
{
  qlb(qla paramqla) {}
  
  public void onClick(View paramView)
  {
    spn.a((Activity)qla.a(this.a).getContext());
    spn.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlb
 * JD-Core Version:    0.7.0.1
 */