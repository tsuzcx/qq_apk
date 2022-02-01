import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mnh
  implements View.OnClickListener
{
  mnh(mnc parammnc) {}
  
  public void onClick(View paramView)
  {
    if ((mnc.a(this.a) != null) && (mnc.a(this.a).isShown())) {
      this.a.b();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      mnc.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnh
 * JD-Core Version:    0.7.0.1
 */