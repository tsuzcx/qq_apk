package com.tencent.mobileqq.leba.more;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class LebaMoreFragment$2
  implements DialogInterface.OnClickListener
{
  LebaMoreFragment$2(LebaMoreFragment paramLebaMoreFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("LebaMoreFragment", 1, "showTipDialog onClick onCancel");
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.2
 * JD-Core Version:    0.7.0.1
 */