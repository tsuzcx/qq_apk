import android.database.DataSetObserver;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

class mpm
  extends DataSetObserver
{
  mpm(mpl parammpl, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Mpl.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Mpl.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mpm
 * JD-Core Version:    0.7.0.1
 */