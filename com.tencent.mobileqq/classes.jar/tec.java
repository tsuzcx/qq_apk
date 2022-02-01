import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tec
  implements View.OnClickListener
{
  public tec(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onClick(View paramView)
  {
    SlideActiveAnimController.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tec
 * JD-Core Version:    0.7.0.1
 */