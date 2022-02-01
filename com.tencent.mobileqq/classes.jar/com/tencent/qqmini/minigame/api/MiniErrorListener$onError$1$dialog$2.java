package com.tencent.qqmini.minigame.api;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class MiniErrorListener$onError$1$dialog$2
  implements DialogInterface.OnClickListener
{
  public static final 2 INSTANCE = new 2();
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniErrorListener.onError.1.dialog.2
 * JD-Core Version:    0.7.0.1
 */