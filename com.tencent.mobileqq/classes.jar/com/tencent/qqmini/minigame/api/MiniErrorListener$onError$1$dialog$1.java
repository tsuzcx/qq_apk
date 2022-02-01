package com.tencent.qqmini.minigame.api;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k=3, mv={1, 1, 16})
final class MiniErrorListener$onError$1$dialog$1
  implements DialogInterface.OnClickListener
{
  MiniErrorListener$onError$1$dialog$1(MiniErrorListener.onError.1 param1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = MiniErrorListener.access$getContext$p(this.this$0.this$0);
    if (paramDialogInterface == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
    ((Activity)paramDialogInterface).finish();
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniErrorListener.onError.1.dialog.1
 * JD-Core Version:    0.7.0.1
 */