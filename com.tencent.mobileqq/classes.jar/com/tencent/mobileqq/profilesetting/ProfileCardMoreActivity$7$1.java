package com.tencent.mobileqq.profilesetting;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;

class ProfileCardMoreActivity$7$1
  implements Runnable
{
  ProfileCardMoreActivity$7$1(ProfileCardMoreActivity.7 param7) {}
  
  public void run()
  {
    FormSimpleItem localFormSimpleItem = this.a.a.a;
    String str;
    if (TextUtils.isEmpty(this.a.a.c)) {
      str = "";
    } else {
      str = this.a.a.c;
    }
    localFormSimpleItem.setRightText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.7.1
 * JD-Core Version:    0.7.0.1
 */