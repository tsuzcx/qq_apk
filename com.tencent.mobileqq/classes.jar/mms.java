import android.database.DataSetObserver;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

class mms
  extends DataSetObserver
{
  mms(mmr parammmr, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Mmr.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Mmr.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mms
 * JD-Core Version:    0.7.0.1
 */