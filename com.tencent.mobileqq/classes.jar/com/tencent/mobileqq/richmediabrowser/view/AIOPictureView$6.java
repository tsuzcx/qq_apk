package com.tencent.mobileqq.richmediabrowser.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;

class AIOPictureView$6
  implements DialogInterface.OnCancelListener
{
  AIOPictureView$6(AIOPictureView paramAIOPictureView) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.n) {
      ((IBrowserDepend)QRoute.api(IBrowserDepend.class)).reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "6", "", "", "", "", 0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOPictureView.6
 * JD-Core Version:    0.7.0.1
 */