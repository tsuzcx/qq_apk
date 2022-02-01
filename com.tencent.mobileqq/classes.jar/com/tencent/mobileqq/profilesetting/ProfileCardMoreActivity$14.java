package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class ProfileCardMoreActivity$14
  implements Runnable
{
  ProfileCardMoreActivity$14(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    try
    {
      i = this.this$0.a(this.this$0.a.uin);
    }
    catch (Exception localException)
    {
      int i;
      label21:
      ProfileCardMoreActivity localProfileCardMoreActivity;
      break label21;
    }
    i = -1;
    localProfileCardMoreActivity = this.this$0;
    localProfileCardMoreActivity.b = false;
    localProfileCardMoreActivity.app.runOnUiThread(new ProfileCardMoreActivity.14.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.14
 * JD-Core Version:    0.7.0.1
 */