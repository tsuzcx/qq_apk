import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nzc
  implements View.OnClickListener
{
  nzc(nyy paramnyy) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    nyy.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzc
 * JD-Core Version:    0.7.0.1
 */