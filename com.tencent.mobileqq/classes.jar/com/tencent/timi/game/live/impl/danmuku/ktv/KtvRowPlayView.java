package com.tencent.timi.game.live.impl.danmuku.ktv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.timi.game.ex.LayoutExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvRowPlayView;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ktvPlayController", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayController;", "ktvPlayViewList", "", "Lcom/tencent/timi/game/live/impl/danmuku/ktv/KtvPlayView;", "offerKtv", "", "ktv", "", "release", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class KtvRowPlayView
  extends LinearLayout
{
  private final List<KtvPlayView> a;
  private final KtvPlayController b;
  
  @JvmOverloads
  public KtvRowPlayView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public KtvRowPlayView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public KtvRowPlayView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = new KtvPlayView(paramContext, null, 0, 6, null);
    paramAttributeSet = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "context");
    paramAttributeSet = new KtvPlayView(paramAttributeSet, null, 0, 6, null);
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    this.a = CollectionsKt.listOf(new KtvPlayView[] { paramContext, paramAttributeSet, new KtvPlayView(localContext, null, 0, 6, null) });
    this.b = new KtvPlayController();
    setOrientation(1);
    addView((View)this.a.get(0), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, LayoutExKt.b(16)));
    paramContext = (View)this.a.get(1);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, LayoutExKt.b(16));
    paramAttributeSet.topMargin = LayoutExKt.b(2);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = (View)this.a.get(2);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, LayoutExKt.b(16));
    paramAttributeSet.topMargin = LayoutExKt.b(2);
    addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.ktv.KtvRowPlayView
 * JD-Core Version:    0.7.0.1
 */