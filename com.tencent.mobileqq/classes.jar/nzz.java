import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nzz
  implements View.OnClickListener
{
  nzz(nzu paramnzu) {}
  
  public void onClick(View paramView)
  {
    this.a.d(this.a.b());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzz
 * JD-Core Version:    0.7.0.1
 */