import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mme
  implements View.OnClickListener
{
  mme(mlz parammlz) {}
  
  public void onClick(View paramView)
  {
    if ((mlz.a(this.a) != null) && (mlz.a(this.a).isShown())) {
      this.a.e();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      mlz.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mme
 * JD-Core Version:    0.7.0.1
 */