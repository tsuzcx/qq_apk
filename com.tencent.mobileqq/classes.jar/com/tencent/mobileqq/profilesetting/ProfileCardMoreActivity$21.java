package com.tencent.mobileqq.profilesetting;

import android.os.Message;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ProfileCardMoreActivity$21
  extends MqqHandler
{
  ProfileCardMoreActivity$21(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    if (paramMessage.what != 36)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TEST more info message handler: ");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
      return;
    }
    if (((String)paramMessage.obj).equals(this.a.b.uin))
    {
      int i = paramMessage.arg1;
      boolean bool2 = false;
      boolean bool1;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1 != this.a.n.a())
      {
        this.a.n.setOnCheckedChangeListener(null);
        localObject = this.a.n;
        bool1 = bool2;
        if (paramMessage.arg1 == 1) {
          bool1 = true;
        }
        ((FormSwitchItem)localObject).setChecked(bool1);
        this.a.n.setOnCheckedChangeListener(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.21
 * JD-Core Version:    0.7.0.1
 */