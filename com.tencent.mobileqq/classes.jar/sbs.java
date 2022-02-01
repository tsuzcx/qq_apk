import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sbs
  implements View.OnClickListener
{
  sbs(sbr paramsbr) {}
  
  public void onClick(View paramView)
  {
    sbr.a(this.a).onAction(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbs
 * JD-Core Version:    0.7.0.1
 */