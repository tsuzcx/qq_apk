import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;

public class opn
  implements View.OnClickListener
{
  public opn(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag();
    this.a.setTab(paramView.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opn
 * JD-Core Version:    0.7.0.1
 */