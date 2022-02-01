package com.tencent.mobileqq.troop.filemanager.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import java.util.List;

class TroopMemberListRefresher$1
  extends TroopObserver
{
  TroopMemberListRefresher$1(TroopMemberListRefresher paramTroopMemberListRefresher) {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.b)) && (!this.a.b.equals(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      if (this.a.d == null) {
        return;
      }
      ThreadManager.post(new TroopMemberListRefresher.1.1(this), 5, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher.1
 * JD-Core Version:    0.7.0.1
 */