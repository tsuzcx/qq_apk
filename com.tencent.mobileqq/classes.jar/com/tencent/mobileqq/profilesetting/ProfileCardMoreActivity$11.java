package com.tencent.mobileqq.profilesetting;

import android.text.TextUtils;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.qphone.base.util.QLog;

class ProfileCardMoreActivity$11
  extends IntimateInfoObserver
{
  ProfileCardMoreActivity$11(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.a.uin)))
    {
      if (paramBoolean) {
        ProfileCardMoreActivity.a(this.a);
      }
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "ProfileCard onDisbandIntimateRelationship");
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.a.uin)))
    {
      if (paramBoolean1) {
        ProfileCardMoreActivity.a(this.a);
      }
      return;
    }
    QLog.d("intimate_relationship", 1, String.format("ProfileCard onDisbandIntimateRelationship, friendUin: %s", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity.11
 * JD-Core Version:    0.7.0.1
 */