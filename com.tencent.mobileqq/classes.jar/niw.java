import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class niw
  implements View.OnClickListener
{
  public niw(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void onClick(View paramView)
  {
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, "mExitBtn " + AvGameLoadingActivity.a(this.a) + " bExitEnable " + AvGameLoadingActivity.d(this.a) + "mExit" + AvGameLoadingActivity.b(this.a));
    if (AvGameLoadingActivity.b(this.a) != null)
    {
      long l = njk.a(AvGameLoadingActivity.b(this.a));
      AvGameLoadingActivity.a(this.a, l);
    }
    bcef.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
    if (AvGameLoadingActivity.a(this.a) == 9) {
      bcef.b(null, "dc00898", "", "", "0X800B4A0", "0X800B4A0", 0, 0, "", "", "", "");
    }
    if (AvGameLoadingActivity.d(this.a))
    {
      AVGameNodeReportUtil.b(1);
      this.a.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "mExitBtn click but not enabled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */