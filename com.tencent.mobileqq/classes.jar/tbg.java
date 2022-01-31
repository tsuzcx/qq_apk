import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.util.List;

public class tbg
  implements ViewPager.OnPageChangeListener
{
  public tbg(WSHomeFragment paramWSHomeFragment) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 1) {
      WSHomeFragment.b(this.a, true);
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        paramInt = 0;
        while (paramInt < WSHomeFragment.a(this.a).size())
        {
          Fragment localFragment = (Fragment)WSHomeFragment.a(this.a).get(paramInt);
          if ((localFragment instanceof WSBaseHomeFragment)) {
            ((WSBaseHomeFragment)localFragment).a(WSHomeFragment.a);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((!WSHomeFragment.a(this.a)) || (WSHomeFragment.a(this.a) == null) || (WSHomeFragment.b(this.a) == null)) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      WSHomeFragment.a(this.a).b(paramFloat, true);
      WSHomeFragment.b(this.a).a(paramFloat, true);
      return;
    }
    WSHomeFragment.a(this.a).a(paramFloat, true);
    WSHomeFragment.b(this.a).b(paramFloat, true);
  }
  
  public void onPageSelected(int paramInt)
  {
    WSHomeFragment.a = paramInt;
    WSHomeFragment.a(this.a, true);
    if (WSHomeFragment.a == 0)
    {
      tlv.c("focus");
      localWSPublicAccReport = WSPublicAccReport.getInstance();
      if (WSHomeFragment.a(this.a) == null)
      {
        paramInt = 0;
        localWSPublicAccReport.reportAttentionClick(paramInt);
        WSHomeFragment.a(this.a, 0);
        WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
        WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
      }
    }
    while (WSHomeFragment.a != 1) {
      for (;;)
      {
        WSPublicAccReport localWSPublicAccReport;
        return;
        paramInt = WSHomeFragment.a(this.a).a();
      }
    }
    tlv.c("feeds");
    WSPublicAccReport.getInstance().reportRecommendClick();
    WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
    WSPublicAccReport.getInstance().reportPageVisitExit("focus");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbg
 * JD-Core Version:    0.7.0.1
 */