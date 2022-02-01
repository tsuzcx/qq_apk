package com.tencent.mobileqq.profile;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class VipProfileCardBaseActivity$1
  extends Handler
{
  VipProfileCardBaseActivity$1(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.a(paramMessage))
    {
      int i = paramMessage.what;
      if (i != 5)
      {
        if (i != 6)
        {
          if (i != 7)
          {
            if (i != 9) {
              return;
            }
            this.a.d();
            return;
          }
          Toast.makeText(this.a.a.getApplicationContext(), 2131695079, 0).show();
          return;
        }
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String)))
        {
          Toast.makeText(this.a.a.getApplicationContext(), (String)paramMessage.obj, 0).show();
          return;
        }
        Toast.makeText(this.a.a.getApplicationContext(), 2131695133, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */