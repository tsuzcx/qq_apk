import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

public class mmr
  extends PagerAdapter
{
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  
  public mmr(EffectCycleViewPager paramEffectCycleViewPager, PagerAdapter paramPagerAdapter)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    paramPagerAdapter.registerDataSetObserver(new mms(this, paramEffectCycleViewPager));
  }
  
  int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() - 1;
    }
    if (paramInt == this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount() + 1) {
      return 0;
    }
    return paramInt - 1;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    int i = a(paramInt);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.remove(paramInt);
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.destroyItem(paramViewGroup, i, paramObject);
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
    if (i > 0) {
      return i + 2;
    }
    return 0;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = a(paramInt);
    paramViewGroup = (View)this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.instantiateItem(paramViewGroup, i);
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.isViewFromObject(paramView, paramObject);
  }
  
  public void notifyDataSetChanged()
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.setCurrentItem(1);
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mmr
 * JD-Core Version:    0.7.0.1
 */