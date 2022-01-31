import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.av.AVLog;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager.FilterTextAdapter;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager.OnEffectFilterChangeListener;
import java.lang.ref.WeakReference;

public class kff
  implements ViewPager.OnPageChangeListener
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public kff(EffectFilterTextPager paramEffectFilterTextPager, EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnEffectFilterChangeListener);
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AVLog.c("EffectFilterTextPager", "onPageScrollStateChanged : " + paramInt);
    if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a(1300);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    AVLog.c("EffectFilterTextPager", "onPageScrollStateChanged onPageSelected : " + paramInt + "|" + EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager));
    if ((EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager) != paramInt) && (this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      FilterItem localFilterItem = this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager.a.a(paramInt);
      if (localFilterItem != null) {
        ((EffectFilterTextPager.OnEffectFilterChangeListener)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramInt, localFilterItem.getId());
      }
      EffectFilterTextPager.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kff
 * JD-Core Version:    0.7.0.1
 */