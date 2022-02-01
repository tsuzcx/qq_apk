package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/ui/widget/TimiRoundImageView;", "Lcom/tencent/timi/game/ui/widget/rc/RCImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class TimiRoundImageView
  extends RCImageView
{
  public TimiRoundImageView(@Nullable Context paramContext)
  {
    super(paramContext);
  }
  
  public TimiRoundImageView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TimiRoundImageView(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setRadius(getMeasuredWidth() / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.TimiRoundImageView
 * JD-Core Version:    0.7.0.1
 */