import android.content.Context;
import android.widget.GridView;
import com.tencent.biz.troopgift.GridListViewPager;

public class oyw
  extends GridView
{
  public oyw(GridListViewPager paramGridListViewPager, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyw
 * JD-Core Version:    0.7.0.1
 */