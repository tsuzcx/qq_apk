import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sli
  implements View.OnClickListener
{
  sli(slh paramslh) {}
  
  public void onClick(View paramView)
  {
    slh.a(true, -1, slh.a(this.a));
    if (slh.a(this.a) != null) {
      slh.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sli
 * JD-Core Version:    0.7.0.1
 */