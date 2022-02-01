import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ogx
  implements View.OnClickListener
{
  ogx(ogs paramogs) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToGrantPermission");
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    if (Build.VERSION.SDK_INT >= 23) {
      if (localBaseActivity.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION")) {
        ogs.a(this.a, true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localBaseActivity.requestPermissions(new ogy(this, localBaseActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      continue;
      ogs.a(this.a, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogx
 * JD-Core Version:    0.7.0.1
 */