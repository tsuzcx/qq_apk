package com.tencent.mobileqq.troop.selecttroopmember;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.List;

class TroopMemberDataProvider$2
  extends TroopObserver
{
  TroopMemberDataProvider$2(TroopMemberDataProvider paramTroopMemberDataProvider) {}
  
  public void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.a.a.equals(paramString))) {
      return;
    }
    ThreadManager.post(new TroopMemberDataProvider.2.1(this, paramList), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.TroopMemberDataProvider.2
 * JD-Core Version:    0.7.0.1
 */