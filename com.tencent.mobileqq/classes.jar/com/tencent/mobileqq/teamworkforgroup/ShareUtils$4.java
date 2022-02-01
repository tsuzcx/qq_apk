package com.tencent.mobileqq.teamworkforgroup;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class ShareUtils$4
  implements DialogInterface.OnKeyListener
{
  ShareUtils$4(ShareUtils paramShareUtils) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (ShareUtils.a(this.a) != null)) {
      ShareUtils.a(this.a).a();
    }
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.4
 * JD-Core Version:    0.7.0.1
 */