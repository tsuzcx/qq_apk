package com.tencent.mobileqq.nearby.verify;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;

class FaceVerifyWebFragment$2
  implements DialogInterface.OnClickListener
{
  FaceVerifyWebFragment$2(FaceVerifyWebFragment paramFaceVerifyWebFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IUIToolsApi)QRoute.api(IUIToolsApi.class)).openPermissionActivity(this.a.getActivity());
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.verify.FaceVerifyWebFragment.2
 * JD-Core Version:    0.7.0.1
 */