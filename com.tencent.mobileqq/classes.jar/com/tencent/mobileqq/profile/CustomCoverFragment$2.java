package com.tencent.mobileqq.profile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import androidx.fragment.app.FragmentActivity;

class CustomCoverFragment$2
  implements DialogInterface.OnCancelListener
{
  CustomCoverFragment$2(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CustomCoverFragment.2
 * JD-Core Version:    0.7.0.1
 */