package com.tencent.mobileqq.qqlive.verified;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import androidx.fragment.app.FragmentActivity;

class FaceVerifyWebFragment$3
  implements DialogInterface.OnClickListener
{
  FaceVerifyWebFragment$3(FaceVerifyWebFragment paramFaceVerifyWebFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    FaceVerifyWebFragment.a(this.a, null);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.verified.FaceVerifyWebFragment.3
 * JD-Core Version:    0.7.0.1
 */