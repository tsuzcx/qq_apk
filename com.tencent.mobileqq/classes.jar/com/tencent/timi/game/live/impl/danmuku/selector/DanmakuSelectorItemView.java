package com.tencent.timi.game.live.impl.danmuku.selector;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorItemView;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgView", "Landroid/view/View;", "danmakuEffectsPAGView", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorPagView;", "danmakuEffectsTv", "Landroid/widget/TextView;", "refreshUI", "", "select", "", "showType", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuSelectorItemView
  extends FrameLayout
{
  private View a;
  private TextView b;
  private DanmakuSelectorPagView c;
  
  @JvmOverloads
  public DanmakuSelectorItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public DanmakuSelectorItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public DanmakuSelectorItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new View(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(LayoutExKt.b(39), LayoutExKt.b(39));
    paramAttributeSet.topMargin = LayoutExKt.b(10);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    paramContext.setBackgroundResource(2130853045);
    addView(paramContext);
    paramContext = new TextView(getContext());
    paramAttributeSet = new FrameLayout.LayoutParams(LayoutExKt.b(39), LayoutExKt.b(39));
    paramAttributeSet.topMargin = LayoutExKt.b(10);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    paramContext.setGravity(17);
    paramContext.setTextColor(Color.parseColor("#DBE4EB"));
    paramContext.setTextSize(1, 14.0F);
    this.b = paramContext;
    addView((View)paramContext);
    paramContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context");
    paramContext = new DanmakuSelectorPagView(paramContext, null, 0, 6, null);
    paramAttributeSet = new FrameLayout.LayoutParams(LayoutExKt.b(39), LayoutExKt.b(39));
    paramAttributeSet.topMargin = LayoutExKt.b(10);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    this.c = paramContext;
    addView((View)paramContext);
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject != null)
    {
      if (paramInt == 0) {
        i = 0;
      } else {
        i = 8;
      }
      ((TextView)localObject).setVisibility(i);
    }
    localObject = this.c;
    if (localObject != null)
    {
      if (paramInt != 0) {
        i = j;
      } else {
        i = 8;
      }
      ((DanmakuSelectorPagView)localObject).setVisibility(i);
    }
    localObject = this.c;
    if (localObject != null) {
      ((DanmakuSelectorPagView)localObject).a();
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        localObject = this.b;
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)"普");
        }
      }
      else
      {
        localObject = this.c;
        if (localObject != null) {
          ((DanmakuSelectorPagView)localObject).a("tg_danmaku_ktv.pag");
        }
      }
    }
    else
    {
      localObject = this.c;
      if (localObject != null) {
        ((DanmakuSelectorPagView)localObject).a("tg_danmaku_big.pag");
      }
    }
    localObject = this.a;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorItemView
 * JD-Core Version:    0.7.0.1
 */