package com.tencent.mobileqq.profilecard.bussiness.troop;

import aaud;
import android.text.TextUtils;
import anzj;
import azxr;
import bahr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.MessageRecord;

public class ProfileTroopMemInfoComponent$3
  implements Runnable
{
  public ProfileTroopMemInfoComponent$3(bahr parambahr, azxr paramazxr) {}
  
  public void run()
  {
    Object localObject = bahr.a(this.this$0, this.a);
    if (localObject != null)
    {
      localObject = anzj.a(2131707328) + aaud.a(((MessageRecord)localObject).time, true, false, true).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.a.b = ((String)localObject);
      }
      if (bahr.h(this.this$0) != null) {
        break label82;
      }
    }
    label82:
    while (!bahr.i(this.this$0).isResume())
    {
      return;
      localObject = null;
      break;
    }
    bahr.l(this.this$0).runOnUiThread(new ProfileTroopMemInfoComponent.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.ProfileTroopMemInfoComponent.3
 * JD-Core Version:    0.7.0.1
 */