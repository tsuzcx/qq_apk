package com.tencent.timi.game.profile.impl.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/CPDDProfileDialogImpl$addOperationView$viewClickListener$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class CPDDProfileDialogImpl$addOperationView$viewClickListener$1
  implements View.OnClickListener
{
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    if (!NoDoubleClickUtils.a())
    {
      int i = paramView.getId();
      CPDDProfileClickListener localCPDDProfileClickListener;
      if (i == 2131439645)
      {
        localCPDDProfileClickListener = CPDDProfileDialogImpl.a(this.a);
        if (localCPDDProfileClickListener != null) {
          localCPDDProfileClickListener.a((ProfileDialog)this.a);
        }
        this.a.dismiss();
      }
      else if (i == 2131439647)
      {
        localCPDDProfileClickListener = CPDDProfileDialogImpl.a(this.a);
        if (localCPDDProfileClickListener != null) {
          localCPDDProfileClickListener.a();
        }
        this.a.dismiss();
      }
      else if (i == 2131439653)
      {
        localCPDDProfileClickListener = CPDDProfileDialogImpl.a(this.a);
        if (localCPDDProfileClickListener != null) {
          localCPDDProfileClickListener.b();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.CPDDProfileDialogImpl.addOperationView.viewClickListener.1
 * JD-Core Version:    0.7.0.1
 */