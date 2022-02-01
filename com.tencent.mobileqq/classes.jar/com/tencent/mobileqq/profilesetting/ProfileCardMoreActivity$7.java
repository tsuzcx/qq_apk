package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class ProfileCardMoreActivity$7
  extends GPServiceObserver
{
  protected void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProUserProfileInfo paramIGProUserProfileInfo)
  {
    if ((!this.b.isDestroyed()) && (!this.b.isFinishing())) {
      this.b.runOnUiThread(new ProfileCardMoreActivity.7.1(this, paramInt, paramIGProUserProfileInfo));
    }
    this.a.deleteObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.7
 * JD-Core Version:    0.7.0.1
 */