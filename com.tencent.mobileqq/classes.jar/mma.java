import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mma
  implements View.OnClickListener
{
  mma(mlz parammlz) {}
  
  public void onClick(View paramView)
  {
    mlz.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mma
 * JD-Core Version:    0.7.0.1
 */