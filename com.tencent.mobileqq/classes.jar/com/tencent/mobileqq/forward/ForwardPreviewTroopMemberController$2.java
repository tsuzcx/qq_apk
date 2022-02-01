package com.tencent.mobileqq.forward;

import android.util.Pair;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ForwardPreviewTroopMemberController$2
  extends TroopObserver
{
  ForwardPreviewTroopMemberController$2(ForwardPreviewTroopMemberController paramForwardPreviewTroopMemberController) {}
  
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
    QLog.i("Forward.Preview.Dialog", 2, localStringBuilder.toString());
    if ((ForwardPreviewTroopMemberController.a(this.a).equals(paramString)) && (ForwardPreviewTroopMemberController.a(this.a) != null))
    {
      this.a.e();
      ForwardPreviewTroopMemberController.a(this.a).a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.2
 * JD-Core Version:    0.7.0.1
 */