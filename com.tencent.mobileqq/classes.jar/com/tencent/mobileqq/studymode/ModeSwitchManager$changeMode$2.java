package com.tencent.mobileqq.studymode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"}, k=3, mv={1, 1, 16})
final class ModeSwitchManager$changeMode$2
  implements DialogInterface.OnDismissListener
{
  ModeSwitchManager$changeMode$2(ModeSwitchManager paramModeSwitchManager, int paramInt1, int paramInt2) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = ((Iterable)ModeSwitchManager.a(this.a)).iterator();
    while (paramDialogInterface.hasNext()) {
      ((ModeSwitchManager.OnModeChangeResultCallback)paramDialogInterface.next()).c(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeSwitchManager.changeMode.2
 * JD-Core Version:    0.7.0.1
 */