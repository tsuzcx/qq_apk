import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.9.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.9.1.1.1;
import com.tencent.viola.core.ViolaEnvironment;

public class rnk
  implements azwa
{
  public rnk(ViolaBaseView.9.1 param1) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    if (ViolaBaseView.a(this.a.a.a) == 0.0D)
    {
      ViolaBaseView.a(this.a.a.a, paramDouble);
      ViolaBaseView.a(this.a.a.a).addReportData(ViolaEnvironment.KEY_FRAME_PAGE, String.format("%.2f", new Object[] { Double.valueOf(ViolaBaseView.a(this.a.a.a)) }));
    }
    new Handler().postDelayed(new ViolaBaseView.9.1.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rnk
 * JD-Core Version:    0.7.0.1
 */