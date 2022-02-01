import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nri
  implements View.OnClickListener
{
  nri(nre paramnre) {}
  
  public void onClick(View paramView)
  {
    this.a.a(this.a.a, this.a.a.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nri
 * JD-Core Version:    0.7.0.1
 */