import android.database.DataSetObserver;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

class kcv
  extends DataSetObserver
{
  kcv(kcu paramkcu, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Kcu.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Kcu.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kcv
 * JD-Core Version:    0.7.0.1
 */