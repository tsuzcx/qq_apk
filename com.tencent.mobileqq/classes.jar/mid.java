import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mid
  implements View.OnClickListener
{
  mid(mhw parammhw) {}
  
  public void onClick(View paramView)
  {
    if (!mhw.a(this.a))
    {
      this.a.c();
      mhw.a(this.a).a.f(0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mid
 * JD-Core Version:    0.7.0.1
 */