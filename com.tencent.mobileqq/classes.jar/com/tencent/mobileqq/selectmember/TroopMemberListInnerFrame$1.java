package com.tencent.mobileqq.selectmember;

import android.os.Handler;
import android.os.Message;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class TroopMemberListInnerFrame$1
  extends Handler
{
  TroopMemberListInnerFrame$1(TroopMemberListInnerFrame paramTroopMemberListInnerFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 1) && (i != 2))
    {
      Object localObject;
      if (i != 3)
      {
        if (i != 4) {
          return;
        }
        paramMessage = this.a;
        paramMessage.A += TroopMemberListInnerFrame.B;
        if ((this.a.A < 90.0D) && (this.a.a > 0))
        {
          if (this.a.x.getVisibility() == 8) {
            this.a.x.setVisibility(0);
          }
          this.a.y.setProgress((int)this.a.A);
          paramMessage = this.a.z;
          localObject = HardCodeUtil.a(2131912871);
          double d1 = this.a.a;
          double d2 = this.a.A;
          Double.isNaN(d1);
          paramMessage.setText(String.format((String)localObject, new Object[] { Integer.valueOf(Math.min((int)(d1 * d2 / 100.0D), this.a.a)), Integer.valueOf(this.a.a) }));
          this.a.C.sendMessageDelayed(this.a.C.obtainMessage(4), 800L);
        }
      }
      else
      {
        TroopMemberListInnerFrame.a(this.a, paramMessage.arg1);
        this.a.C.removeMessages(4);
        if ((paramMessage.obj instanceof Object[]))
        {
          Object[] arrayOfObject = (Object[])paramMessage.obj;
          if (arrayOfObject.length > 0)
          {
            localObject = (String)arrayOfObject[1];
            if (!((String)localObject).equals(this.a.c))
            {
              if (!QLog.isColorLevel()) {
                return;
              }
              paramMessage = new StringBuilder();
              paramMessage.append("handleMessage, troopUin != mTroopUin, break:");
              paramMessage.append((String)localObject);
              paramMessage.append(",");
              paramMessage.append(this.a.c);
              QLog.d("TroopMemberListInnerFrame.thread", 2, paramMessage.toString());
              return;
            }
            this.a.p = ((Map)arrayOfObject[0]);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage, mIndexedFriends.size=");
          ((StringBuilder)localObject).append(this.a.p.size());
          QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
        }
        if ((this.a.f.mSubType == 1) || (this.a.f.mSubType == 0) || (this.a.f.mSubType == 5))
        {
          localObject = this.a;
          i = TroopMemberListInnerFrame.a((TroopMemberListInnerFrame)localObject, ((TroopMemberListInnerFrame)localObject).p);
          this.a.f.afterMemberFilter(i);
        }
        paramMessage.obj = TroopMemberListInnerFrame.a(this.a);
        TroopMemberListInnerFrame.a(this.a, paramMessage);
        if ((!this.a.m) && (this.a.f.mIsSelectAllMembers))
        {
          paramMessage = this.a;
          paramMessage.m = true;
          paramMessage.l.setChecked(this.a.l.isChecked() ^ true);
          paramMessage = this.a;
          paramMessage.onCheckedChanged(paramMessage.l, this.a.l.isChecked());
        }
      }
    }
    else
    {
      TroopMemberListInnerFrame.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame.1
 * JD-Core Version:    0.7.0.1
 */