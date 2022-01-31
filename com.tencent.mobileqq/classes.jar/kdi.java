import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.av.AVLog;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

public class kdi
  implements ViewPager.OnPageChangeListener
{
  private int jdField_a_of_type_Int;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  
  public kdi(EffectCycleViewPager paramEffectCycleViewPager, ViewPager.OnPageChangeListener paramOnPageChangeListener, int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.getCount() - 1) {
        break label57;
      }
      AVLog.c("EffectCycleViewPager", "onPageScrollStateChanged 00:1");
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.setCurrentItem(1, false);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
      }
      return;
      label57:
      if (this.jdField_a_of_type_Int == 0)
      {
        AVLog.c("EffectCycleViewPager", "onPageScrollStateChanged 11:" + (this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.getCount() - 2));
        this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.setCurrentItem(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.getCount() - 2, false);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    AVLog.c("EffectCycleViewPager", "onPageSelected:" + paramInt);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectCycleViewPager.a.a(paramInt);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdi
 * JD-Core Version:    0.7.0.1
 */