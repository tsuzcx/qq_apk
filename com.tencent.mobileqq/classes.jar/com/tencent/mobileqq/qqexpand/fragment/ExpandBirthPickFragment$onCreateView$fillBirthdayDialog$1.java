package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.widget.FillBirthdayDialog.OnConfirmListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/fragment/ExpandBirthPickFragment$onCreateView$fillBirthdayDialog$1", "Lcom/tencent/mobileqq/qqexpand/widget/FillBirthdayDialog$OnConfirmListener;", "onCancel", "", "onConfirm", "newBirthday", "", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandBirthPickFragment$onCreateView$fillBirthdayDialog$1
  implements FillBirthdayDialog.OnConfirmListener
{
  public void a()
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("birthdate", paramInt);
    ExpandFlutterIPCClient.a().a("METHOD_SET_BIRTH_DATE", (Bundle)localObject);
    localObject = this.a.getActivity();
    if (localObject != null) {
      ((FragmentActivity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandBirthPickFragment.onCreateView.fillBirthdayDialog.1
 * JD-Core Version:    0.7.0.1
 */