import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class myg
  extends BroadcastReceiver
{
  myg(mya parammya) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel()) {
      QLog.d("FloatWindowController", 2, "onReceive action: " + paramContext + "  process_name:" + paramIntent);
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk")))
    {
      i = 1;
      if (!"mqq.intent.action.QQ_BACKGROUND".equals(paramContext)) {
        break label120;
      }
      if ((paramIntent != null) && (paramIntent.equals("com.tencent.mobileqq")))
      {
        this.a.a(false);
        this.a.a = false;
        mya.a(this.a, false);
      }
    }
    label120:
    while (!"mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      return;
      i = 0;
      break;
    }
    if (i == 0)
    {
      this.a.a = true;
      this.a.a(true);
      mya.a(this.a, false);
      return;
    }
    if (mya.b(this.a))
    {
      mya.a(this.a, true);
      return;
    }
    this.a.a = true;
    mya.a(this.a).a = true;
    mya.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myg
 * JD-Core Version:    0.7.0.1
 */