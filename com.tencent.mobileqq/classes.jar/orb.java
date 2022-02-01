import com.tencent.biz.widgets.TabLayout;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class orb
  implements HorizontalListView.OnScrollStateChangedListener
{
  orb(oqy paramoqy) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 4098) {
      oqy.a(this.a).setOverScrollMode(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orb
 * JD-Core Version:    0.7.0.1
 */