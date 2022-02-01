package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.os.Message;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

class ProfileQZoneComponent$6
  implements Runnable
{
  ProfileQZoneComponent$6(ProfileQZoneComponent paramProfileQZoneComponent) {}
  
  public void run()
  {
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)ProfileQZoneComponent.access$100(this.this$0);
    Object localObject = (FriendsManager)ProfileQZoneComponent.access$200(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((FriendsManager)localObject).a(localProfileCardInfo.allInOne.uin);
    }
    int j = 0;
    if (localObject == null)
    {
      localObject = new Card();
      i = 1;
    }
    else
    {
      i = 0;
    }
    ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
    ((Card)localObject).strQzoneFeedsDesc = "";
    Message localMessage = Message.obtain();
    localMessage.obj = localObject;
    if (i != 0) {
      localMessage.what = 6;
    } else {
      localMessage.what = 5;
    }
    if (ProfileQZoneComponent.access$300(this.this$0) != null) {
      ProfileQZoneComponent.access$300(this.this$0).sendMessage(localMessage);
    }
    int i = j;
    if (localProfileCardInfo.allInOne != null) {
      i = localProfileCardInfo.allInOne.profileEntryType;
    }
    ProfileQZoneComponent.access$400(this.this$0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.6
 * JD-Core Version:    0.7.0.1
 */