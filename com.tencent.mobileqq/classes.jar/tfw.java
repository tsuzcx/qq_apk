import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.widget.QQTabWidget.onTabWidgetTouchMoveListener;
import com.tencent.qphone.base.util.QLog;

public class tfw
  implements QQTabWidget.onTabWidgetTouchMoveListener
{
  public tfw(MainFragment paramMainFragment) {}
  
  public void a()
  {
    int i = GesturePWDUtils.getGesturePWDState(MainFragment.a(this.a).getApp(), MainFragment.a(this.a).getCurrentAccountUin());
    int j = GesturePWDUtils.getGesturePWDMode(MainFragment.a(this.a).getApp(), MainFragment.a(this.a).getCurrentAccountUin());
    if ((i == 2) && (j == 20))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mainactivity", 2, "gesturepwd manual move.");
      }
      ((SplashActivity)this.a.getActivity()).startUnlockActivity();
      this.a.getActivity().overridePendingTransition(2131034134, 2131034131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfw
 * JD-Core Version:    0.7.0.1
 */