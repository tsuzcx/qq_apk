package com.tencent.mobileqq.forward;

import android.util.Pair;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ForwardTroopMemberControllerForMiniPie$2
  extends TroopObserver
{
  ForwardTroopMemberControllerForMiniPie$2(ForwardTroopMemberControllerForMiniPie paramForwardTroopMemberControllerForMiniPie) {}
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetTroopMemberListBy0x787 uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" memberList size: ");
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    localStringBuilder.append(i);
    QLog.i("ForwardTroopMemberControllerForMiniPie", 2, localStringBuilder.toString());
    if ((ForwardTroopMemberControllerForMiniPie.d(this.a).equals(paramString)) && (ForwardTroopMemberControllerForMiniPie.b(this.a) != null))
    {
      ForwardTroopMemberControllerForMiniPie.c(this.a);
      ForwardTroopMemberControllerForMiniPie.b(this.a).a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.2
 * JD-Core Version:    0.7.0.1
 */