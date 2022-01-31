import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;

public class rjr
  implements View.OnClickListener
{
  public rjr(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a("", null);
    ReportController.b(this.a.app, "dc00898", "", "", "0X80077B4", "0X80077B4", 0, 0, "", "", "", "");
    if (Utils.b(AddFriendVerifyActivity.a(this.a))) {
      ReportController.b(this.a.app, "dc00898", "", "", "0X8008275", "0X8008275", 0, 0, "", "", "", "");
    }
    if (!TextUtils.isEmpty(this.a.f)) {
      ReportController.b(this.a.app, "dc00899", "Qidian", "", "0X8008802", "ClickAddFriendButton", 0, 0, "1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjr
 * JD-Core Version:    0.7.0.1
 */