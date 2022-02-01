package com.tencent.timi.game.live.impl.danmuku.selector;

import androidx.recyclerview.widget.DiffUtil.ItemCallback;
import com.tencent.mobileqq.pb.PBInt32Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.TextShowInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$DanmakuEffectsSelectorAdapter$danmakuShowTypeDiff$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$DanmakuSelectDataBean;", "areContentsTheSame", "", "p0", "p1", "areItemsTheSame", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuSelectorView$DanmakuEffectsSelectorAdapter$danmakuShowTypeDiff$1
  extends DiffUtil.ItemCallback<DanmakuSelectorView.DanmakuSelectDataBean>
{
  public boolean a(@NotNull DanmakuSelectorView.DanmakuSelectDataBean paramDanmakuSelectDataBean1, @NotNull DanmakuSelectorView.DanmakuSelectDataBean paramDanmakuSelectDataBean2)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuSelectDataBean1, "p0");
    Intrinsics.checkParameterIsNotNull(paramDanmakuSelectDataBean2, "p1");
    return true;
  }
  
  public boolean b(@NotNull DanmakuSelectorView.DanmakuSelectDataBean paramDanmakuSelectDataBean1, @NotNull DanmakuSelectorView.DanmakuSelectDataBean paramDanmakuSelectDataBean2)
  {
    Intrinsics.checkParameterIsNotNull(paramDanmakuSelectDataBean1, "p0");
    Intrinsics.checkParameterIsNotNull(paramDanmakuSelectDataBean2, "p1");
    return (paramDanmakuSelectDataBean1.a() == paramDanmakuSelectDataBean2.a()) && (paramDanmakuSelectDataBean1.b().show_type.get() == paramDanmakuSelectDataBean2.b().show_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView.DanmakuEffectsSelectorAdapter.danmakuShowTypeDiff.1
 * JD-Core Version:    0.7.0.1
 */