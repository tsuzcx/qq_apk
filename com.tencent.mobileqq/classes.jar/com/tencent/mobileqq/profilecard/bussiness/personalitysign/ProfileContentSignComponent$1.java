package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;

class ProfileContentSignComponent$1
  extends FriendListObserver
{
  ProfileContentSignComponent$1(ProfileContentSignComponent paramProfileContentSignComponent) {}
  
  public void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if ((ProfileContentSignComponent.access$000(this.this$0) != null) && (((ProfileCardInfo)ProfileContentSignComponent.access$200(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(ProfileContentSignComponent.access$100(this.this$0).getCurrentAccountUin())))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)ProfileContentSignComponent.access$300(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(ProfileContentSignComponent.access$400(this.this$0).getCurrentAccountUin());
      if (localExtensionInfo != null) {
        ProfileContentSignComponent.access$500(this.this$0, localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    FriendsManager localFriendsManager;
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (ProfileContentSignComponent.access$600(this.this$0) != null))
    {
      localFriendsManager = (FriendsManager)ProfileContentSignComponent.access$700(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (!TextUtils.equals(((ProfileCardInfo)ProfileContentSignComponent.access$800(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramArrayOfString[i])) {
          break label144;
        }
        paramArrayOfString = localFriendsManager.a(((ProfileCardInfo)ProfileContentSignComponent.access$900(this.this$0)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        if (paramArrayOfString != null)
        {
          ((ProfileCardInfo)ProfileContentSignComponent.access$1000(this.this$0)).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = ExtensionRichStatus.a(paramArrayOfString);
          ProfileContentSignComponent.access$1200(this.this$0, ((ProfileCardInfo)ProfileContentSignComponent.access$1100(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      return;
      label144:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.1
 * JD-Core Version:    0.7.0.1
 */