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
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (paramBoolean)
    {
      FriendsManager localFriendsManager = (FriendsManager)this.a.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      int j = 1;
      ExtensionInfo localExtensionInfo = localFriendsManager.a(paramString2, true);
      int i = 0;
      Object localObject = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        localObject = new ExtensionInfo();
        ((ExtensionInfo)localObject).uin = paramString2;
        i = 1;
      }
      if (((ExtensionInfo)localObject).lastIceBreakChatTs < paramLong.longValue())
      {
        ((ExtensionInfo)localObject).lastIceBreakChatTs = paramLong.longValue();
        i = j;
      }
      if (i != 0) {
        localFriendsManager.a((ExtensionInfo)localObject);
      }
      if (IceBreakingMng.a(this.a) == null) {
        localObject = null;
      } else {
        localObject = (OnIceBreakChangeListener)IceBreakingMng.a(this.a).get();
      }
      if (localObject != null) {
        ((OnIceBreakChangeListener)localObject).a(paramBoolean, paramString1, paramString2, paramLong);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.1
 * JD-Core Version:    0.7.0.1
 */