package com.tencent.timi.game.api.impl;

import android.content.DialogInterface;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGameApp$hideWaitDialog$1
  implements Runnable
{
  TimiGameApp$hideWaitDialog$1(DialogInterface paramDialogInterface) {}
  
  public final void run()
  {
    try
    {
      LoadingUtils.a.b(this.a);
      this.a.dismiss();
      Logger.a("TimiGameApp_", "hideWaitDialog succeed!");
      return;
    }
    catch (Exception localException)
    {
      Logger.a("TimiGameApp_", "dialog.dismiss error:", (Throwable)localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.hideWaitDialog.1
 * JD-Core Version:    0.7.0.1
 */