import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mnb
  implements View.OnClickListener
{
  mnb(mmw parammmw) {}
  
  public void onClick(View paramView)
  {
    if ((mmw.a(this.a) != null) && (mmw.a(this.a).isShown())) {
      this.a.e();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      mmw.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnb
 * JD-Core Version:    0.7.0.1
 */