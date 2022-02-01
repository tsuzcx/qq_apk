import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mgv
  implements View.OnClickListener
{
  public mgv(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mgv
 * JD-Core Version:    0.7.0.1
 */