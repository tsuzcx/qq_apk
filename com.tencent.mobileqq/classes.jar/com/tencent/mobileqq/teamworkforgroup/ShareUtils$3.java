package com.tencent.mobileqq.teamworkforgroup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.teamwork.IShareUtils.SharePanelListener;

class ShareUtils$3
  implements DialogInterface.OnDismissListener
{
  ShareUtils$3(ShareUtils paramShareUtils) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (ShareUtils.d(this.a) != null) {
      ShareUtils.d(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.3
 * JD-Core Version:    0.7.0.1
 */