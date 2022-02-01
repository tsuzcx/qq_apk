package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;

class ProfileCardMoreActivity$10
  extends MessageObserver
{
  ProfileCardMoreActivity$10(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.b.uin != null) && (this.a.b.uin.equals(paramString))) {
      this.a.a(paramBoolean, false);
    }
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.b.uin != null) && (this.a.b.uin.equals(paramString))) {
      this.a.a(paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.10
 * JD-Core Version:    0.7.0.1
 */