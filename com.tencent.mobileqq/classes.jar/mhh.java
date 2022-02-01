import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mhh
  implements View.OnClickListener
{
  mhh(mha parammha) {}
  
  public void onClick(View paramView)
  {
    if (!mha.a(this.a))
    {
      this.a.c();
      mha.a(this.a).a.f(0L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhh
 * JD-Core Version:    0.7.0.1
 */