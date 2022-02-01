package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.widget.FormSimpleItem;

class ProfileCardMoreActivity$7$1
  implements Runnable
{
  ProfileCardMoreActivity$7$1(ProfileCardMoreActivity.7 param7, int paramInt, IGProUserProfileInfo paramIGProUserProfileInfo) {}
  
  public void run()
  {
    if ((this.a == 0) && (this.b.d() == 2))
    {
      this.c.b.b.gender = 1;
      if ((this.c.b.s != null) && ((this.c.b.s.getTag() instanceof Boolean))) {
        ProfileCardMoreActivity.b(this.c.b, ((Boolean)this.c.b.s.getTag()).booleanValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.7.1
 * JD-Core Version:    0.7.0.1
 */