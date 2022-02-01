package com.tencent.mobileqq.profilecard.bussiness.achievement;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfileAchievementComponent$2
  implements Runnable
{
  ProfileAchievementComponent$2(ProfileAchievementComponent paramProfileAchievementComponent) {}
  
  public void run()
  {
    if (ProfileAchievementComponent.access$100(this.this$0) != null)
    {
      int i = ((View)ProfileAchievementComponent.access$200(this.this$0)).getTop();
      if ((i >= 0) && (ProfileAchievementComponent.access$300(this.this$0) != null)) {
        ProfileAchievementComponent.access$400(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent.2
 * JD-Core Version:    0.7.0.1
 */