package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.MessageObserver;

class ProfileCardMoreActivity$5
  extends MessageObserver
{
  ProfileCardMoreActivity$5(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, false);
    }
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.5
 * JD-Core Version:    0.7.0.1
 */