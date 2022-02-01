import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qdn
  implements View.OnClickListener
{
  qdn(qdm paramqdm) {}
  
  public void onClick(View paramView)
  {
    sgr.a((Activity)qdm.a(this.a).getContext());
    sgr.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qdn
 * JD-Core Version:    0.7.0.1
 */