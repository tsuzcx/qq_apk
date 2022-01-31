import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqstory.playvideo.MyVideoVisibilityDialog;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;

public class nlu
  implements ViewPager.OnPageChangeListener
{
  public nlu(MyVideoVisibilityDialog paramMyVideoVisibilityDialog) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.a.a.setSelectedTab(paramInt, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlu
 * JD-Core Version:    0.7.0.1
 */