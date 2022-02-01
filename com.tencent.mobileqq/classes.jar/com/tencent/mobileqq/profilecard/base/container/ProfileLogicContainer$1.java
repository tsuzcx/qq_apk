package com.tencent.mobileqq.profilecard.base.container;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.utils.ProfilePAUtils;

class ProfileLogicContainer$1
  extends FriendListObserver
{
  ProfileLogicContainer$1(ProfileLogicContainer paramProfileLogicContainer) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (((ProfileCardInfo)ProfileLogicContainer.access$300(this.this$0)).allInOne.uin != null) && (ProfilePAUtils.isPaTypeFriend(((ProfileCardInfo)ProfileLogicContainer.access$400(this.this$0)).allInOne)))
    {
      paramString1 = ((IFriendDataService)ProfileLogicContainer.access$500(this.this$0).getRuntimeService(IFriendDataService.class, "all")).getFriend(((ProfileCardInfo)ProfileLogicContainer.access$600(this.this$0)).allInOne.uin);
      if (paramString1 != null)
      {
        if (paramString1.remark != null) {
          paramString1 = paramString1.remark;
        } else {
          paramString1 = "";
        }
        if (ProfileLogicContainer.access$700(this.this$0) != null) {
          ProfileLogicContainer.access$800(this.this$0).setRemark(paramString1);
        }
      }
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (((ProfileCardInfo)ProfileLogicContainer.access$000(this.this$0)).allInOne.uin.equals(String.valueOf(paramObject))))
    {
      ProfileCardUtils.notifyUser(2, 2131691465);
      ProfileLogicContainer.access$100(this.this$0).finish();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    ProfileLogicContainer.access$200(this.this$0, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileLogicContainer.1
 * JD-Core Version:    0.7.0.1
 */