package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;

class ProfileContentSignComponent$1
  extends FriendListObserver
{
  ProfileContentSignComponent$1(ProfileContentSignComponent paramProfileContentSignComponent) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if ((ProfileContentSignComponent.access$000(this.this$0) != null) && (((ProfileCardInfo)ProfileContentSignComponent.access$200(this.this$0)).allInOne.uin.equals(ProfileContentSignComponent.access$100(this.this$0).getCurrentAccountUin())))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)ProfileContentSignComponent.access$300(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(ProfileContentSignComponent.access$400(this.this$0).getCurrentAccountUin());
      if (localExtensionInfo != null) {
        ProfileContentSignComponent.access$500(this.this$0, localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (ProfileContentSignComponent.access$600(this.this$0) != null))
    {
      FriendsManager localFriendsManager = (FriendsManager)ProfileContentSignComponent.access$700(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (TextUtils.equals(((ProfileCardInfo)ProfileContentSignComponent.access$800(this.this$0)).allInOne.uin, paramArrayOfString[i]))
        {
          paramArrayOfString = localFriendsManager.a(((ProfileCardInfo)ProfileContentSignComponent.access$900(this.this$0)).allInOne.uin);
          if (paramArrayOfString == null) {
            break;
          }
          ProfileContentSignComponent.access$1002(this.this$0, ExtensionRichStatus.a(paramArrayOfString));
          paramArrayOfString = this.this$0;
          ProfileContentSignComponent.access$1200(paramArrayOfString, ((ProfileCardInfo)ProfileContentSignComponent.access$1100(paramArrayOfString)).card, false);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.1
 * JD-Core Version:    0.7.0.1
 */