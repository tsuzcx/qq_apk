package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import android.os.Message;

class TroopSettingActivity$27
  extends Handler
{
  TroopSettingActivity$27(TroopSettingActivity paramTroopSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.a.l)
    {
      if (this.a.i == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 15)
        {
          if (i != 20)
          {
            if (i != 5)
            {
              if (i != 6)
              {
                if (i != 17)
                {
                  if (i != 18) {
                    return;
                  }
                  TroopSettingActivity.o(this.a);
                  return;
                }
                TroopSettingActivity.n(this.a);
                return;
              }
              TroopSettingActivity.k(this.a);
              return;
            }
            TroopSettingActivity.l(this.a);
            return;
          }
          TroopSettingActivity.a(this.a, paramMessage);
          return;
        }
        TroopSettingActivity.m(this.a);
        return;
      }
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.27
 * JD-Core Version:    0.7.0.1
 */