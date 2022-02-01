import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mmg
  implements View.OnClickListener
{
  mmg(mmf parammmf) {}
  
  public void onClick(View paramView)
  {
    mmf.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmg
 * JD-Core Version:    0.7.0.1
 */