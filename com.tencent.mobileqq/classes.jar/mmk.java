import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mmk
  implements View.OnClickListener
{
  mmk(mmf parammmf) {}
  
  public void onClick(View paramView)
  {
    if ((mmf.a(this.a) != null) && (mmf.a(this.a).isShown())) {
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      mmf.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */