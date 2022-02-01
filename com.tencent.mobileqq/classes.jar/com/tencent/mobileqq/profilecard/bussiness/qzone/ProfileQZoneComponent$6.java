package com.tencent.mobileqq.profilecard.bussiness.qzone;

import android.os.Message;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.util.WeakReferenceHandler;

class ProfileQZoneComponent$6
  implements Runnable
{
  ProfileQZoneComponent$6(ProfileQZoneComponent paramProfileQZoneComponent) {}
  
  public void run()
  {
    int j = 0;
    ProfileCardInfo localProfileCardInfo = (ProfileCardInfo)ProfileQZoneComponent.access$100(this.this$0);
    Object localObject = (FriendsManager)ProfileQZoneComponent.access$200(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label162;
      }
      localObject = new Card();
    }
    label162:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (ProfileQZoneComponent.access$300(this.this$0) != null) {
          ProfileQZoneComponent.access$300(this.this$0).sendMessage(localMessage);
        }
        i = j;
        if (localProfileCardInfo.a != null) {
          i = localProfileCardInfo.a.h;
        }
        ProfileQZoneComponent.access$400(this.this$0, i);
        return;
        localObject = ((FriendsManager)localObject).a(localProfileCardInfo.a.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.qzone.ProfileQZoneComponent.6
 * JD-Core Version:    0.7.0.1
 */