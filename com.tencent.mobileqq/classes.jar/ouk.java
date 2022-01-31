import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import com.tencent.biz.qqstory.view.EmptySupportViewPager;

public class ouk
  extends DataSetObserver
{
  public ouk(EmptySupportViewPager paramEmptySupportViewPager) {}
  
  public void onChanged()
  {
    PagerAdapter localPagerAdapter = this.a.getAdapter();
    if ((localPagerAdapter != null) && (localPagerAdapter.getCount() > 0))
    {
      this.a.a(8);
      EmptySupportViewPager.a(this.a, 0);
      return;
    }
    this.a.a(0);
    EmptySupportViewPager.b(this.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ouk
 * JD-Core Version:    0.7.0.1
 */