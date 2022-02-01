package com.tencent.timi.game.live.impl.danmuku.selector;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.AsyncListDiffer;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import trpc.yes.common.GameDataServerOuterClass.TextShowInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class DanmakuSelectorView$DanmakuEffectsSelectorAdapter$onBindViewHolder$1
  implements View.OnClickListener
{
  DanmakuSelectorView$DanmakuEffectsSelectorAdapter$onBindViewHolder$1(DanmakuSelectorView.DanmakuEffectsSelectorAdapter paramDanmakuEffectsSelectorAdapter, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    DanmakuSelectorView.a(DanmakuSelectorView.DanmakuEffectsSelectorAdapter.a(this.a), ((DanmakuSelectorView.DanmakuSelectDataBean)DanmakuSelectorView.DanmakuEffectsSelectorAdapter.b(this.a).getCurrentList().get(this.b)).b().show_type.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView.DanmakuEffectsSelectorAdapter.onBindViewHolder.1
 * JD-Core Version:    0.7.0.1
 */