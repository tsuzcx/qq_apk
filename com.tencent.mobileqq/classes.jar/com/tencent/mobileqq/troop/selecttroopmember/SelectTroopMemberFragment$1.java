package com.tencent.mobileqq.troop.selecttroopmember;

import android.app.Dialog;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class SelectTroopMemberFragment$1
  extends TroopObserver
{
  SelectTroopMemberFragment$1(SelectTroopMemberFragment paramSelectTroopMemberFragment) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDeleteTroopMember, isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SelectTroopMemberFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.a != null) && (this.a.a.isShowing())) {
      this.a.a.dismiss();
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.getBaseActivity(), this.a.getString(2131691474), 0).a();
      localObject = new Intent();
      if (paramArrayList != null) {
        ((Intent)localObject).putStringArrayListExtra("uinList", paramArrayList);
      }
      this.a.getBaseActivity().setResult(-1, (Intent)localObject);
      this.a.getBaseActivity().doOnBackPressed();
      return;
    }
    QQToast.a(this.a.getBaseActivity(), this.a.getString(2131691473), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberFragment.1
 * JD-Core Version:    0.7.0.1
 */