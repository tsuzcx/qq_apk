import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mpl
  implements View.OnClickListener
{
  mpl(mpj parammpj) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpl
 * JD-Core Version:    0.7.0.1
 */