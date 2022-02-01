import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qjl
  implements View.OnClickListener
{
  qjl(qjk paramqjk) {}
  
  public void onClick(View paramView)
  {
    smd.a((Activity)qjk.a(this.a).getContext());
    smd.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjl
 * JD-Core Version:    0.7.0.1
 */