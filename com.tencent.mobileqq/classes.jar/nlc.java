import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class nlc
  extends BroadcastReceiver
{
  nlc(nlb paramnlb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("request_type", 0);
    QLog.i(this.a.c, 2, "receive request" + paramIntent.getExtras());
    switch (i)
    {
    default: 
      return;
    }
    paramContext = new Intent();
    paramContext.setAction("com.tencent.mobileqq.NearbyJsInterface");
    paramContext.putExtra("command_type", 1);
    paramContext.putExtra("data", nlb.a(this.a));
    this.a.a.getApp().sendBroadcast(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlc
 * JD-Core Version:    0.7.0.1
 */