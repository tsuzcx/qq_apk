package com.tencent.mobileqq.profile.stickynote.vas;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.VasH5PayUtil;

class StickyNoteVasAdapter$3
  implements DialogInterface.OnClickListener
{
  StickyNoteVasAdapter$3(StickyNoteVasAdapter paramStickyNoteVasAdapter, Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str;
    if (StickyNoteVasAdapter.d(this.e).b == 1) {
      str = "&g_ch=suixintie&actId=460973&isAskFriendPay=0";
    } else if (StickyNoteVasAdapter.d(this.e).b == 2) {
      str = "&g_ch=扩列装扮&actId=466499&isAskFriendPay=0";
    } else {
      str = "";
    }
    Activity localActivity = (Activity)this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(str);
    VasH5PayUtil.a(localActivity, localStringBuilder.toString(), this.c, this.d, 0);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.vas.StickyNoteVasAdapter.3
 * JD-Core Version:    0.7.0.1
 */