package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class ProfileCardMoreActivity$19
  implements Runnable
{
  ProfileCardMoreActivity$19(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void run()
  {
    try
    {
      i = this.this$0.c(this.this$0.b.uin);
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
    localProfileCardMoreActivity.z = false;
    localProfileCardMoreActivity.app.runOnUiThread(new ProfileCardMoreActivity.19.1(this, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.19
 * JD-Core Version:    0.7.0.1
 */