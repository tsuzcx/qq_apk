package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.FormSwitchItem;

class ProfileCardMoreActivity$9
  extends CardObserver
{
  ProfileCardMoreActivity$9(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  public void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
  
  public void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.a.equals(paramString)) {
      return;
    }
    this.a.f();
    if (paramBoolean)
    {
      this.a.notifyUser(2131690824, 2);
      return;
    }
    this.a.notifyUser(2131690822, 1);
  }
  
  public void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.d.a()))
    {
      this.a.d.setOnCheckedChangeListener(null);
      this.a.d.setChecked(paramBoolean2);
      this.a.d.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.9
 * JD-Core Version:    0.7.0.1
 */