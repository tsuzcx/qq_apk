package com.tencent.mobileqq.profilecard.bussiness.achievement;

import com.tencent.mobileqq.profilecard.bussiness.achievement.handler.LifeAchievementObserver;
import com.tencent.qphone.base.util.QLog;

class ProfileAchievementComponent$1
  extends LifeAchievementObserver
{
  ProfileAchievementComponent$1(ProfileAchievementComponent paramProfileAchievementComponent) {}
  
  protected void onPraiseLifeAchievement(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAchievementComponent", 2, String.format("onPraiseLifeAchievement isSuccess=%s actionType=%s achievementId=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    ProfileAchievementComponent.access$000(this.this$0, paramBoolean, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.ProfileAchievementComponent.1
 * JD-Core Version:    0.7.0.1
 */