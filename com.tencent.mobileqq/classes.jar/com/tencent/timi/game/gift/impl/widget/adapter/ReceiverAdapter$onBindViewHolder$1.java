package com.tencent.timi.game.gift.impl.widget.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.gift.api.ReceiverInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ReceiverAdapter$onBindViewHolder$1
  implements View.OnClickListener
{
  ReceiverAdapter$onBindViewHolder$1(ReceiverAdapter paramReceiverAdapter, ReceiverInfoModel paramReceiverInfoModel) {}
  
  public final void onClick(View paramView)
  {
    ReceiverAdapter localReceiverAdapter = this.a;
    ReceiverInfoModel localReceiverInfoModel = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localReceiverInfoModel, "receiverInfoModel");
    ReceiverAdapter.a(localReceiverAdapter, localReceiverInfoModel);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.widget.adapter.ReceiverAdapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */