package com.tencent.mobileqq.profilecard.bussiness.troop;

import amtj;
import android.text.TextUtils;
import aymg;
import ayxi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;
import zqq;

public class ProfileTroopMemInfoComponent$3
  implements Runnable
{
  public ProfileTroopMemInfoComponent$3(ayxi paramayxi, aymg paramaymg) {}
  
  public void run()
  {
    Object localObject = ayxi.a(this.this$0, this.a);
    if (localObject != null)
    {
      localObject = amtj.a(2131707560) + zqq.a(((MessageRecord)localObject).time, true, false, true).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.a.b = ((String)localObject);
      }
      if (ayxi.h(this.this$0) != null) {
        break label82;
      }
    }
    label82:
    while (!ayxi.i(this.this$0).isResume())
    {
      return;
      localObject = null;
      break;
    }
    ayxi.l(this.this$0).runOnUiThread(new ProfileTroopMemInfoComponent.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3
 * JD-Core Version:    0.7.0.1
 */