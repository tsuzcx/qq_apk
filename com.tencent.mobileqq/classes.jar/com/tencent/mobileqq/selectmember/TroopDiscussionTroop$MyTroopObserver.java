package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class TroopDiscussionTroop$MyTroopObserver
  extends TroopObserver
{
  protected TroopDiscussionTroop$MyTroopObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (TroopDiscussionTroop.a(this.a) != null) {
      TroopDiscussionTroop.a(this.a).a();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateTroopList ");
      localStringBuilder.append(paramBoolean);
      QLog.d("TroopDiscussionTroop", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new TroopDiscussionTroop.MyTroopObserver.1(this), 500L);
    }
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */