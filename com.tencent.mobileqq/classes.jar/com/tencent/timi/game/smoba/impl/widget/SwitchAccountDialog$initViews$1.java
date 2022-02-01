package com.tencent.timi.game.smoba.impl.widget;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class SwitchAccountDialog$initViews$1
  implements View.OnClickListener
{
  SwitchAccountDialog$initViews$1(SwitchAccountDialog paramSwitchAccountDialog) {}
  
  public final void onClick(View paramView)
  {
    SwitchAccountDialog localSwitchAccountDialog = this.a;
    SwitchAccountDialog.a(localSwitchAccountDialog, ((SmobaAccountSelectView)localSwitchAccountDialog.findViewById(2131446111)).getCurrentSelectedAccount());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.widget.SwitchAccountDialog.initViews.1
 * JD-Core Version:    0.7.0.1
 */