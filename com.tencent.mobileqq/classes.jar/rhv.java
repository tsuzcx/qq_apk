import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class rhv
  implements View.OnClickListener
{
  public rhv(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void onClick(View paramView)
  {
    if (ArkFullScreenAppActivity.a(this.a) != null) {
      ArkAppDataReport.c(this.a.app, ArkFullScreenAppActivity.a(this.a).a, ArkAppDataReport.b);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkFullScreenAppActivity", 2, "click to close");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhv
 * JD-Core Version:    0.7.0.1
 */