package com.tencent.mobileqq.profile.PersonalityLabel;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class PersonalityLabelGalleryActivity$12
  extends FriendListObserver
{
  PersonalityLabelGalleryActivity$12(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onUpdateFriendInfo refresh UI uin:" + paramString + " suc:" + paramBoolean);
    }
    if ((paramBoolean) && (TextUtils.equals(PersonalityLabelGalleryActivity.a(this.a), paramString)) && (!PersonalityLabelGalleryActivity.a(this.a)))
    {
      PersonalityLabelGalleryActivity.a(this.a, ContactUtils.a(this.a.app, PersonalityLabelGalleryActivity.a(this.a)));
      if (!TextUtils.equals(PersonalityLabelGalleryActivity.a(this.a), PersonalityLabelGalleryActivity.b(this.a))) {
        PersonalityLabelGalleryActivity.d(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.12
 * JD-Core Version:    0.7.0.1
 */