package com.tencent.timi.game.live.impl.danmuku.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.timi.game.ex.LayoutExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "danmakuEffectsSelectorAdapter", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorView$DanmakuEffectsSelectorAdapter;", "danmakuSelectorRv", "Landroidx/recyclerview/widget/RecyclerView;", "presenter", "Lcom/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorPresenter;", "attachDanmakuSelectorPresenter", "", "setSelect", "showType", "show", "trySubmitNewList", "Companion", "DanmakuEffectsSelectorAdapter", "DanmakuSelectDataBean", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuSelectorView
  extends LinearLayout
{
  public static final DanmakuSelectorView.Companion a = new DanmakuSelectorView.Companion(null);
  private RecyclerView b;
  private final DanmakuSelectorView.DanmakuEffectsSelectorAdapter c = new DanmakuSelectorView.DanmakuEffectsSelectorAdapter(this);
  private DanmakuSelectorPresenter d;
  
  @JvmOverloads
  public DanmakuSelectorView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public DanmakuSelectorView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public DanmakuSelectorView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    setBackgroundResource(2130852947);
    paramContext = new ImageView(getContext());
    paramAttributeSet = new LinearLayout.LayoutParams(LayoutExKt.b(24), LayoutExKt.b(36));
    paramAttributeSet.topMargin = LayoutExKt.b(12);
    paramAttributeSet.leftMargin = LayoutExKt.b(12);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    paramContext.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramContext.setImageResource(2130852945);
    addView((View)paramContext);
    paramContext = new RecyclerView(getContext());
    paramAttributeSet = new LinearLayout.LayoutParams(-1, -1);
    paramAttributeSet.rightMargin = LayoutExKt.b(12);
    paramContext.setLayoutParams((ViewGroup.LayoutParams)paramAttributeSet);
    this.b = paramContext;
    paramContext.setClipChildren(false);
    addView((View)paramContext);
  }
  
  private final void a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((DanmakuSelectorPresenter)localObject).a();
      if (localObject != null) {}
    }
    else
    {
      localObject = CollectionsKt.emptyList();
    }
    DanmakuSelectorPresenter localDanmakuSelectorPresenter = this.d;
    int i;
    if (localDanmakuSelectorPresenter != null) {
      i = localDanmakuSelectorPresenter.b();
    } else {
      i = -1;
    }
    this.c.a((List)localObject, i);
  }
  
  private final void setSelect(int paramInt)
  {
    DanmakuSelectorPresenter localDanmakuSelectorPresenter = this.d;
    if (localDanmakuSelectorPresenter != null) {
      localDanmakuSelectorPresenter.a(paramInt);
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorView
 * JD-Core Version:    0.7.0.1
 */