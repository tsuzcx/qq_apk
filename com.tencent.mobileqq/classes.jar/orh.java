import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;

public class orh
  implements View.OnClickListener
{
  public orh(SlideTabViewPager paramSlideTabViewPager) {}
  
  public void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag();
    this.a.setTab(paramView.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orh
 * JD-Core Version:    0.7.0.1
 */