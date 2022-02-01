package com.tencent.mobileqq.profilecard.bussiness.accountlevel;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qphone.base.util.QLog;

class ProfileAccountLevelComponent$1
  extends CardObserver
{
  ProfileAccountLevelComponent$1(ProfileAccountLevelComponent paramProfileAccountLevelComponent) {}
  
  public void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("onGetAllowSeeLoginDays isSuccess=%s isAllow=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    if ((paramBoolean1) && (TextUtils.equals(paramString, ((ProfileCardInfo)ProfileAccountLevelComponent.access$000(this.this$0)).a.a)))
    {
      ProfileAccountLevelComponent.access$102(this.this$0, paramBoolean2);
      this.this$0.updateDarenView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.accountlevel.ProfileAccountLevelComponent.1
 * JD-Core Version:    0.7.0.1
 */