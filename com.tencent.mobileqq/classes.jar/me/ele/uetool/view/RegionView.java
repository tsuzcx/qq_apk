package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class RegionView
  extends View
{
  private Paint paint = new RegionView.1(this);
  private RectF rectF;
  
  public RegionView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RegionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RegionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void drawRegion(RectF paramRectF)
  {
    this.rectF = paramRectF;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.rectF != null) {
      paramCanvas.drawRect(this.rectF, this.paint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.view.RegionView
 * JD-Core Version:    0.7.0.1
 */