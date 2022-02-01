package com.tencent.mobileqq.troop.selecttroopmember;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.HashMap;

class TroopMemberDataProvider$1
  extends Handler
{
  TroopMemberDataProvider$1(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if ((this.a.d != null) && ((paramMessage.obj instanceof HashMap))) {
            this.a.d.a((HashMap)paramMessage.obj);
          }
        }
        else
        {
          paramMessage = this.a;
          paramMessage.g += TroopMemberDataProvider.h;
          if ((this.a.g < 90.0D) && (this.a.j > 0))
          {
            if (this.a.d != null)
            {
              paramMessage = this.a.d;
              i = (int)this.a.g;
              String str = HardCodeUtil.a(2131912871);
              double d1 = this.a.j;
              double d2 = this.a.g;
              Double.isNaN(d1);
              paramMessage.a(i, String.format(str, new Object[] { Integer.valueOf(Math.min((int)(d1 * d2 / 100.0D), this.a.j)), Integer.valueOf(this.a.j) }));
            }
            this.a.k.sendMessageDelayed(this.a.k.obtainMessage(3), 800L);
          }
        }
      }
      else
      {
        this.a.k.removeMessages(3);
        if (this.a.d != null) {
          this.a.d.e();
        }
        TroopMemberDataProvider.a(this.a);
      }
    }
    else if (this.a.d != null) {
      this.a.d.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.1
 * JD-Core Version:    0.7.0.1
 */