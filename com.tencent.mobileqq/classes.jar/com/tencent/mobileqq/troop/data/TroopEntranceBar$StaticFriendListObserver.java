package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import java.lang.ref.WeakReference;
import java.util.List;

final class TroopEntranceBar$StaticFriendListObserver
  extends AvatarObserver
{
  WeakReference<TroopEntranceBar> a;
  
  private TroopEntranceBar$StaticFriendListObserver(TroopEntranceBar paramTroopEntranceBar)
  {
    this.a = new WeakReference(paramTroopEntranceBar);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    TroopEntranceBar localTroopEntranceBar = (TroopEntranceBar)this.a.get();
    if ((localTroopEntranceBar != null) && (paramBoolean) && (paramString != null) && (localTroopEntranceBar.q != null) && (localTroopEntranceBar.q.size() > 0) && (paramString.equals(((TroopInfo)localTroopEntranceBar.q.get(0)).troopuin))) {
      localTroopEntranceBar.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.StaticFriendListObserver
 * JD-Core Version:    0.7.0.1
 */