import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;

public class rkt
  implements View.OnClickListener
{
  public rkt(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      ArkAppDataReport.c(this.a.app, ArkFullScreenAppActivity.a(this.a).a, ArkAppDataReport.c);
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rkt
 * JD-Core Version:    0.7.0.1
 */