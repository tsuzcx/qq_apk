import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.widget.AbsListView;

public class qzw
  implements bfob
{
  public qzw(DailyTitleBarSwitcher paramDailyTitleBarSwitcher) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= 1) && (this.a.getVisibility() == 0))
    {
      paramAbsListView = paramAbsListView.getChildAt(0);
      if (paramAbsListView != null)
      {
        paramInt1 = paramAbsListView.getHeight();
        paramInt2 = paramAbsListView.getTop();
        if ((paramInt1 != 0) && (paramInt2 != 0))
        {
          float f = paramInt2 * -1.0F / paramInt1;
          DailyTitleBarSwitcher.a(this.a, DailyTitleBarSwitcher.a(this.a).getInterpolation(f));
          return;
        }
        DailyTitleBarSwitcher.a(this.a, 0.0F);
        return;
      }
      DailyTitleBarSwitcher.a(this.a, 0.0F);
      return;
    }
    DailyTitleBarSwitcher.a(this.a, 1.0F);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.setLayerType(0, null);
      return;
    }
    this.a.setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzw
 * JD-Core Version:    0.7.0.1
 */