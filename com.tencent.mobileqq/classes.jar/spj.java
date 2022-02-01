import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class spj
  implements View.OnClickListener
{
  spj(spi paramspi) {}
  
  public void onClick(View paramView)
  {
    spi.a(true, -1, spi.a(this.a));
    if (spi.a(this.a) != null) {
      spi.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     spj
 * JD-Core Version:    0.7.0.1
 */