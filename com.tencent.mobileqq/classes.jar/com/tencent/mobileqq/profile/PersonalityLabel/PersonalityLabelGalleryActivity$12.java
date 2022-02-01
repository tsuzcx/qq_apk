package com.tencent.mobileqq.profile.PersonalityLabel;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

class PersonalityLabelGalleryActivity$12
  extends FriendListObserver
{
  PersonalityLabelGalleryActivity$12(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateFriendInfo refresh UI uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" suc:");
      localStringBuilder.append(paramBoolean);
      QLog.i("PersonalityLabelGalleryActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (TextUtils.equals(PersonalityLabelGalleryActivity.h(this.a), paramString)) && (!PersonalityLabelGalleryActivity.i(this.a)))
    {
      paramString = this.a;
      PersonalityLabelGalleryActivity.b(paramString, ContactUtils.a(paramString.app, PersonalityLabelGalleryActivity.h(this.a)));
      if (!TextUtils.equals(PersonalityLabelGalleryActivity.h(this.a), PersonalityLabelGalleryActivity.p(this.a))) {
        PersonalityLabelGalleryActivity.q(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.12
 * JD-Core Version:    0.7.0.1
 */