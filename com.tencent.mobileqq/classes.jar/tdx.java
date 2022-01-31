import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class tdx
  extends Handler
{
  public tdx(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          return;
        }
      }
      finally {}
      boolean bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.g(this.a).setChecked(bool);
      continue;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.a(this.a, paramMessage);
      continue;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.b(this.a, paramMessage);
      continue;
      bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.h(this.a).setChecked(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdx
 * JD-Core Version:    0.7.0.1
 */