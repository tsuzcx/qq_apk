import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class rfg
  extends BroadcastReceiver
{
  public rfg(DoraemonAPIReporterProxy paramDoraemonAPIReporterProxy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.a;
    if (paramContext == null) {}
    do
    {
      return;
      str1 = paramIntent.getAction();
      if ("com.tencent.mobileqq.Doraemon.monitor.update".equals(str1))
      {
        str1 = paramIntent.getStringExtra("key");
        int i = paramIntent.getIntExtra("type", 0);
        String str2 = paramIntent.getStringExtra("appid");
        String str3 = paramIntent.getStringExtra("api");
        long l1 = paramIntent.getLongExtra("remain", 0L);
        long l2 = paramIntent.getLongExtra("time", 0L);
        if (QLog.isColorLevel()) {
          QLog.d("DoraemonOpenAPI.report", 2, "receive update key=" + str1 + ", api=" + str3 + ", remain=" + l1 + ", exp=" + l2);
        }
        ThreadManager.getUIHandler().post(new rfh(this, paramContext, str1, i, str2, str3, l1, l2));
        return;
      }
    } while (!"com.tencent.mobileqq.Doraemon.monitor.update_batch".equals(str1));
    String str1 = paramIntent.getStringExtra("key");
    paramIntent.getIntExtra("type", 0);
    paramIntent.getStringExtra("appid");
    try
    {
      paramIntent = (HashMap)paramIntent.getSerializableExtra("map");
      if (QLog.isColorLevel()) {
        QLog.d("DoraemonOpenAPI.report", 2, "receive update all key=" + str1);
      }
      ThreadManager.getUIHandler().post(new rfi(this, paramContext, str1, paramIntent));
      return;
    }
    catch (ClassCastException paramContext)
    {
      QLog.e("DoraemonOpenAPI.report", 1, "illegal data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rfg
 * JD-Core Version:    0.7.0.1
 */