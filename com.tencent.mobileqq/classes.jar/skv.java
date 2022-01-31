import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import java.util.Iterator;
import java.util.List;

public class skv
  implements ViewPager.OnPageChangeListener
{
  private skv(ViewPagerCompat paramViewPagerCompat) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (ViewPagerCompat.a(this.a) != null)
    {
      Iterator localIterator = ViewPagerCompat.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (ViewPagerCompat.a(this.a) != null)
    {
      Iterator localIterator = ViewPagerCompat.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    if (ViewPagerCompat.a(this.a) != null)
    {
      Iterator localIterator = ViewPagerCompat.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageSelected(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     skv
 * JD-Core Version:    0.7.0.1
 */