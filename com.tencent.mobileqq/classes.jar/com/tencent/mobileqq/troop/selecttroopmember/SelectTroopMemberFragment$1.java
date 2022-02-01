package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SelectTroopMemberFragment$1
  extends TroopBusinessObserver
{
  SelectTroopMemberFragment$1(SelectTroopMemberFragment paramSelectTroopMemberFragment) {}
  
  public void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelectTroopMemberFragment", 2, "onDeleteTroopMember, isSuccess:" + paramBoolean + " errorCode:" + paramInt);
    }
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.getActivity(), this.a.getString(2131691553), 0).a();
      Intent localIntent = new Intent();
      if (paramArrayList != null) {
        localIntent.putStringArrayListExtra("uinList", paramArrayList);
      }
      this.a.getActivity().setResult(-1, localIntent);
      this.a.getActivity().doOnBackPressed();
      return;
    }
    QQToast.a(this.a.getActivity(), this.a.getString(2131691552), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.1
 * JD-Core Version:    0.7.0.1
 */