package com.tencent.timi.game.ui.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/ui/widget/CommonDialog$Builder$build$1$2"}, k=3, mv={1, 1, 16})
final class CommonDialog$Builder$build$$inlined$apply$lambda$2
  implements View.OnClickListener
{
  CommonDialog$Builder$build$$inlined$apply$lambda$2(CommonDialog paramCommonDialog, CommonDialog.Builder paramBuilder) {}
  
  public final void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = CommonDialog.Builder.c(this.b);
    if (localOnClickListener != null) {
      localOnClickListener.onClick((DialogInterface)this.a, -2);
    }
    if (CommonDialog.Builder.d(this.b)) {
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.CommonDialog.Builder.build..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */