package com.tencent.mobileqq.forward;

import android.util.Pair;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ForwardPreviewTroopMemberController$2
  extends TroopObserver
{
  ForwardPreviewTroopMemberController$2(ForwardPreviewTroopMemberController paramForwardPreviewTroopMemberController) {}
  
  public void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.i("Forward.Preview.Dialog", 2, i);
      if ((ForwardPreviewTroopMemberController.a(this.a).equals(paramString)) && (ForwardPreviewTroopMemberController.a(this.a) != null))
      {
        this.a.e();
        ForwardPreviewTroopMemberController.a(this.a).a(paramList);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.2
 * JD-Core Version:    0.7.0.1
 */