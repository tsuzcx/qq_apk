package com.tencent.mobileqq.vas.troopkeyword;

import QC.UniLoginCheckRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import java.lang.ref.WeakReference;

class TroopKeywordManager$MyBusinessObserver
  implements BusinessObserver
{
  private WeakReference<TroopKeywordManager> a;
  
  public TroopKeywordManager$MyBusinessObserver(TroopKeywordManager paramTroopKeywordManager)
  {
    this.a = new WeakReference(paramTroopKeywordManager);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    TroopKeywordManager localTroopKeywordManager = (TroopKeywordManager)this.a.get();
    if (localTroopKeywordManager == null) {
      return;
    }
    if ((paramObject instanceof UniLoginCheckRsp)) {
      localTroopKeywordManager.a(((UniLoginCheckRsp)paramObject).stKeyWord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager.MyBusinessObserver
 * JD-Core Version:    0.7.0.1
 */