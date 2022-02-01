import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment;
import java.util.ArrayList;

public class rjv
  extends FragmentPagerAdapter
{
  public rjv(SelectVideoTabFragment paramSelectVideoTabFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    return SelectVideoTabFragment.a(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return (Fragment)SelectVideoTabFragment.a(this.a).get(paramInt);
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return SelectVideoTabFragment.a(this.a).getString(SelectVideoTabFragment.a()[paramInt]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjv
 * JD-Core Version:    0.7.0.1
 */