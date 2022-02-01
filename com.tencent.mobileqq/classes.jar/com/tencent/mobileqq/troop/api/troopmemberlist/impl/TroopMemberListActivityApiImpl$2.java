package com.tencent.mobileqq.troop.api.troopmemberlist.impl;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.troop.api.troopmemberlist.IFriendListObserverForAddFrdProxy;

class TroopMemberListActivityApiImpl$2
  extends FriendListObserver
{
  TroopMemberListActivityApiImpl$2(TroopMemberListActivityApiImpl paramTroopMemberListActivityApiImpl, IFriendListObserverForAddFrdProxy paramIFriendListObserverForAddFrdProxy) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      IFriendListObserverForAddFrdProxy localIFriendListObserverForAddFrdProxy = this.a;
      if (localIFriendListObserverForAddFrdProxy != null) {
        localIFriendListObserverForAddFrdProxy.a(paramBoolean, paramString, paramInt);
      }
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      IFriendListObserverForAddFrdProxy localIFriendListObserverForAddFrdProxy = this.a;
      if (localIFriendListObserverForAddFrdProxy != null) {
        localIFriendListObserverForAddFrdProxy.a(paramBoolean1, paramBoolean2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopmemberlist.impl.TroopMemberListActivityApiImpl.2
 * JD-Core Version:    0.7.0.1
 */