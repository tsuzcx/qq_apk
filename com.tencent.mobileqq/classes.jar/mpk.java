import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mpk
  implements View.OnClickListener
{
  mpk(mpj parammpj) {}
  
  public void onClick(View paramView)
  {
    this.a.a(true, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpk
 * JD-Core Version:    0.7.0.1
 */