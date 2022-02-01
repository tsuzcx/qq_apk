package com.tencent.timi.game.liveroom.impl.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LiveDialog$1
  implements View.OnClickListener
{
  LiveDialog$1(LiveDialog paramLiveDialog) {}
  
  public final void onClick(View paramView)
  {
    DialogInterface.OnClickListener localOnClickListener = LiveDialog.a(this.a);
    if (localOnClickListener != null) {
      localOnClickListener.onClick((DialogInterface)this.a, -2);
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.LiveDialog.1
 * JD-Core Version:    0.7.0.1
 */