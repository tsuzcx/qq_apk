import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;
import com.tencent.mobileqq.activity.GesturePWDManualGuideActivity;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;

public class src
  implements View.OnClickListener
{
  public src(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131364691: 
    case 2131364692: 
    case 2131364695: 
    case 2131364696: 
    default: 
      return;
    case 2131364690: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 20);
      this.a.a();
      return;
    case 2131364694: 
      GesturePWDUtils.setGesturePWDMode(this.a, this.a.app.getCurrentAccountUin(), 21);
      this.a.a();
      return;
    case 2131364693: 
      paramView = new Intent(this.a, GesturePWDManualGuideActivity.class);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, GesturePWDCreateActivity.class);
    this.a.startActivityForResult(paramView, 11);
    this.a.overridePendingTransition(2131034134, 2131034131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     src
 * JD-Core Version:    0.7.0.1
 */