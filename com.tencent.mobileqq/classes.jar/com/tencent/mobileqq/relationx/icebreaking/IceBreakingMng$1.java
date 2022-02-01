package com.tencent.mobileqq.relationx.icebreaking;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

class IceBreakingMng$1
  extends FriendListObserver
{
  IceBreakingMng$1(IceBreakingMng paramIceBreakingMng) {}
  
  public void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    int j = 1;
    FriendsManager localFriendsManager;
    int i;
    Object localObject;
    if (paramBoolean)
    {
      localFriendsManager = (FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      ExtensionInfo localExtensionInfo = localFriendsManager.a(paramString2, true);
      i = 0;
      localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = paramString2;
        i = 1;
      }
      if (((ExtensionInfo)localObject).lastIceBreakChatTs >= paramLong.longValue()) {
        break label153;
      }
      ((ExtensionInfo)localObject).lastIceBreakChatTs = paramLong.longValue();
      i = j;
    }
    label153:
    for (;;)
    {
      if (i != 0) {
        localFriendsManager.a((ExtensionInfo)localObject);
      }
      if (IceBreakingMng.a(this.a) == null) {}
      for (localObject = null;; localObject = (OnIceBreakChangeListener)IceBreakingMng.a(this.a).get())
      {
        if (localObject != null) {
          ((OnIceBreakChangeListener)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.1
 * JD-Core Version:    0.7.0.1
 */