import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.tencent.mobileqq.activity.FontSettingActivity;
import java.util.ArrayList;

public class ssa
  extends PagerAdapter
{
  public ssa(FontSettingActivity paramFontSettingActivity) {}
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)this.a.a.get(paramInt));
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)this.a.a.get(paramInt), 0);
    return this.a.a.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssa
 * JD-Core Version:    0.7.0.1
 */