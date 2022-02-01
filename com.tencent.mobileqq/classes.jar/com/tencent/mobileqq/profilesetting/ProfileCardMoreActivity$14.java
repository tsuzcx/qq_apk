package com.tencent.mobileqq.profilesetting;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.widget.FormSwitchItem;

class ProfileCardMoreActivity$14
  extends CardObserver
{
  ProfileCardMoreActivity$14(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onGetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.q.a()))
    {
      this.a.q.setOnCheckedChangeListener(null);
      this.a.q.setChecked(paramBoolean2);
      this.a.q.setOnCheckedChangeListener(this.a);
    }
  }
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.b.uin.equals(paramString)) {
      return;
    }
    this.a.k();
    if (paramBoolean)
    {
      this.a.notifyUser(2131887672, 2);
      return;
    }
    this.a.notifyUser(2131887670, 1);
  }
  
  protected void onSetBabyQSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2 != this.a.q.a()))
    {
      this.a.q.setOnCheckedChangeListener(null);
      this.a.q.setChecked(paramBoolean2);
      this.a.q.setOnCheckedChangeListener(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.14
 * JD-Core Version:    0.7.0.1
 */