import android.database.DataSetObserver;
import com.tencent.av.ui.funchat.filter.EffectCycleViewPager;

class mnu
  extends DataSetObserver
{
  mnu(mnt parammnt, EffectCycleViewPager paramEffectCycleViewPager) {}
  
  public void onChanged()
  {
    this.jdField_a_of_type_Mnt.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.jdField_a_of_type_Mnt.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnu
 * JD-Core Version:    0.7.0.1
 */