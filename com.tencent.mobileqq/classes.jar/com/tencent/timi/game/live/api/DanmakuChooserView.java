package com.tencent.timi.game.live.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/live/api/DanmakuChooserView;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setOnDanmakuTypeChooseListener", "", "onDanmakuTypeChooseListener", "Lcom/tencent/timi/game/live/api/DanmakuChooserView$OnDanmakuTypeChooseListener;", "showDanmakuChooser", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "show", "", "tryShowDanmakuChooser", "OnDanmakuTypeChooseListener", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class DanmakuChooserView
  extends LinearLayout
{
  @JvmOverloads
  public DanmakuChooserView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public DanmakuChooserView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public DanmakuChooserView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(@NotNull LifecycleOwner paramLifecycleOwner, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramLifecycleOwner, "lifecycleOwner");
  }
  
  public void setOnDanmakuTypeChooseListener(@NotNull DanmakuChooserView.OnDanmakuTypeChooseListener paramOnDanmakuTypeChooseListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnDanmakuTypeChooseListener, "onDanmakuTypeChooseListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.api.DanmakuChooserView
 * JD-Core Version:    0.7.0.1
 */