package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.gamecenter.ui.CornerImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "Lcom/tencent/mobileqq/gamecenter/ui/CornerImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setRadius", "", "leftTop", "", "rightTop", "rightBottom", "leftBottom", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class RoundCornerImageView
  extends CornerImageView
{
  @JvmOverloads
  public RoundCornerImageView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public RoundCornerImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public RoundCornerImageView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void setRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super.setRadius(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */