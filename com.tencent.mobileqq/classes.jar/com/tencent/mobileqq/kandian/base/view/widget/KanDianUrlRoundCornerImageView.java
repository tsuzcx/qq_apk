package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;

public class KanDianUrlRoundCornerImageView
  extends KandianUrlImageView
{
  private int a = 0;
  
  public KanDianUrlRoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KanDianUrlRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KanDianUrlRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a > 0)
    {
      Path localPath = new Path();
      RectF localRectF = new RectF(new Rect(0, 0, getWidth(), getHeight()));
      int i = this.a;
      localPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      if (Build.VERSION.SDK_INT >= 28) {
        paramCanvas.clipPath(localPath);
      } else {
        paramCanvas.clipPath(localPath, Region.Op.REPLACE);
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */