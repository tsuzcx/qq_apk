import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qvq
  implements View.OnClickListener
{
  qvq(qvp paramqvp) {}
  
  public void onClick(View paramView)
  {
    szn.a((Activity)qvp.a(this.a).getContext());
    szn.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qvq
 * JD-Core Version:    0.7.0.1
 */