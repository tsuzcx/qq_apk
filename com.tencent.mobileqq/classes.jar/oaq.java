import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class oaq
  implements View.OnClickListener
{
  oaq(oap paramoap) {}
  
  public void onClick(View paramView)
  {
    this.a.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oaq
 * JD-Core Version:    0.7.0.1
 */