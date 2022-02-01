package com.tencent.mobileqq.guild.mainframe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.utils.ViewUtils;

public class GuildRoundRectLayout
  extends FrameLayout
{
  private float a = ViewUtils.dpToPx(1.0F);
  
  public GuildRoundRectLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public GuildRoundRectLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GuildRoundRectLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Path localPath = new Path();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    float f = this.a;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
    paramCanvas.save();
    paramCanvas.clipPath(localPath, Region.Op.INTERSECT);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.GuildRoundRectLayout
 * JD-Core Version:    0.7.0.1
 */