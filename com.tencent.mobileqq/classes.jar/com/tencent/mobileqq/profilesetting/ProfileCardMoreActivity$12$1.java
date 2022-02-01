package com.tencent.mobileqq.profilesetting;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;

class ProfileCardMoreActivity$12$1
  implements Runnable
{
  ProfileCardMoreActivity$12$1(ProfileCardMoreActivity.12 param12) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem = this.a.a.f;
    String str;
    if (TextUtils.isEmpty(this.a.a.w)) {
      str = "";
    } else {
      str = this.a.a.w;
    }
    localFormSimpleItem.setRightText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.12.1
 * JD-Core Version:    0.7.0.1
 */