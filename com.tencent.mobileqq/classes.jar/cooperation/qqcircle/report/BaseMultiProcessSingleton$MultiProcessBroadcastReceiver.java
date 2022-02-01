package cooperation.qqcircle.report;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class BaseMultiProcessSingleton$MultiProcessBroadcastReceiver
  extends BroadcastReceiver
{
  private BaseMultiProcessSingleton$MultiProcessBroadcastReceiver(BaseMultiProcessSingleton paramBaseMultiProcessSingleton) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_multi_process_singleton")))
    {
      paramContext = paramIntent.getBundleExtra("key_process_data_update_");
      if (paramContext == null) {
        return;
      }
      BaseMultiProcessSingleton.access$100(this.this$0, paramContext);
      BaseMultiProcessSingleton.access$200(this.this$0, paramContext);
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive  bundle = ");
      paramIntent.append(paramContext.toString());
      QLog.i("BaseMultiProcessSingleton", 1, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.BaseMultiProcessSingleton.MultiProcessBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */