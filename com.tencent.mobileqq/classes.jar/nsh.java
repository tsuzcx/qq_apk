import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class nsh
  implements View.OnClickListener
{
  nsh(nsc paramnsc) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToGrantPermission");
    paramView = (BaseActivity)paramView.getContext();
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramView.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION"))
      {
        nsc.a(this.a, true);
        return;
      }
      paramView.requestPermissions(new nsi(this, paramView), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    nsc.a(this.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsh
 * JD-Core Version:    0.7.0.1
 */