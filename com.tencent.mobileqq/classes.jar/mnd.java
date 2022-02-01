import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mnd
  implements View.OnClickListener
{
  mnd(mnc parammnc) {}
  
  public void onClick(View paramView)
  {
    mnc.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnd
 * JD-Core Version:    0.7.0.1
 */