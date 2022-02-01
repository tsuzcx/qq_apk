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
    try
    {
      int i = paramMessage.what;
      if (i != 10000)
      {
        if (i != 10001)
        {
          if (i != 10004) {
            return false;
          }
          NotifyPushSettingFragment.g(this.a).setChecked(((Boolean)paramMessage.obj).booleanValue());
        }
        else
        {
          paramMessage = (String)paramMessage.obj;
          NotifyPushSettingFragment.a(this.a, paramMessage);
        }
      }
      else
      {
        boolean bool = ((Boolean)paramMessage.obj).booleanValue();
        NotifyPushSettingFragment.f(this.a).setChecked(bool);
      }
      return true;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NotifyPushSettingFragment.22
 * JD-Core Version:    0.7.0.1
 */