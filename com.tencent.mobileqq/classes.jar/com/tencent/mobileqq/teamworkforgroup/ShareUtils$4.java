package com.tencent.mobileqq.teamworkforgroup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.teamwork.IShareUtils.SharePanelListener;

class ShareUtils$4
  implements DialogInterface.OnKeyListener
{
  ShareUtils$4(ShareUtils paramShareUtils) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (ShareUtils.d(this.a) != null)) {
      ShareUtils.d(this.a).a();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.4
 * JD-Core Version:    0.7.0.1
 */