package com.tencent.timi.game.profile.impl.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class CPDDProfileDialogImpl$addOperationView$1
  implements View.OnClickListener
{
  CPDDProfileDialogImpl$addOperationView$1(CPDDProfileDialogImpl paramCPDDProfileDialogImpl) {}
  
  public final void onClick(View paramView)
  {
    if (NoDoubleClickUtils.a())
    {
      Logger.c("CPDDProfileDialog", "kaiheiClick double clicked!");
    }
    else
    {
      CPDDProfileClickListener localCPDDProfileClickListener = CPDDProfileDialogImpl.a(this.a);
      if (localCPDDProfileClickListener != null) {
        localCPDDProfileClickListener.b((ProfileDialog)this.a);
      }
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.CPDDProfileDialogImpl.addOperationView.1
 * JD-Core Version:    0.7.0.1
 */