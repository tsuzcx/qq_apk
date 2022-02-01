import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ngr
  extends BroadcastReceiver
{
  ngr(ngq paramngq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = true;
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel()) {
      QLog.d("GlobalExitRoomManagement", 2, "onReceive action: " + paramContext + "  process_name:" + paramIntent);
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk")))
    {
      i = 1;
      if (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
        break label94;
      }
      ngq.a(this.a, false);
    }
    label94:
    while (!"mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      return;
      i = 0;
      break;
    }
    paramContext = this.a;
    if (i == 0) {}
    for (;;)
    {
      ngq.a(paramContext, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ngr
 * JD-Core Version:    0.7.0.1
 */