package com.tencent.mobileqq.profilecard.bussiness.troop;

import aagb;
import android.text.TextUtils;
import anvx;
import azrb;
import bacf;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;

public class ProfileTroopMemInfoComponent$3
  implements Runnable
{
  public ProfileTroopMemInfoComponent$3(bacf parambacf, azrb paramazrb) {}
  
  public void run()
  {
    Object localObject = bacf.a(this.this$0, this.a);
    if (localObject != null)
    {
      localObject = anvx.a(2131707907) + aagb.a(((MessageRecord)localObject).time, true, false, true).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.a.b = ((String)localObject);
      }
      if (bacf.h(this.this$0) != null) {
        break label82;
      }
    }
    label82:
    while (!bacf.i(this.this$0).isResume())
    {
      return;
      localObject = null;
      break;
    }
    bacf.l(this.this$0).runOnUiThread(new ProfileTroopMemInfoComponent.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3
 * JD-Core Version:    0.7.0.1
 */