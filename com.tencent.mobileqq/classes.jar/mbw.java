import android.database.DataSetObserver;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

class mbw
  extends DataSetObserver
{
  mbw(mbv parammbv, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Mbv.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Mbv.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbw
 * JD-Core Version:    0.7.0.1
 */