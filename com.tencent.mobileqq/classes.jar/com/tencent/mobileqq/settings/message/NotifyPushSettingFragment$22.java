package com.tencent.mobileqq.settings.message;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.widget.FormSwitchItem;

class NotifyPushSettingFragment$22
  implements Handler.Callback
{
  NotifyPushSettingFragment$22(NotifyPushSettingFragment paramNotifyPushSettingFragment) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        case 10002: 
        case 10003: 
        default: 
          bool = false;
          return bool;
        }
      }
      finally {}
      boolean bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingFragment.f(this.a).setChecked(bool);
      break label119;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingFragment.a(this.a, paramMessage);
      break label119;
      NotifyPushSettingFragment.g(this.a).setChecked(((Boolean)paramMessage.obj).booleanValue());
      label119:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.22
 * JD-Core Version:    0.7.0.1
 */