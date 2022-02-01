package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import me.ele.uetool.util.Util;

public class RoundView
  extends View
{
  private int h;
  private Paint mPaint;
  private Paint paint_round;
  private int w;
  
  public RoundView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mPaint = new Paint(1);
    this.paint_round = new Paint(1);
    this.paint_round.setStyle(Paint.Style.STROKE);
    this.paint_round.setStrokeWidth(6.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawCircle(this.h, this.w, this.h - 8, this.mPaint);
    paramCanvas.drawCircle(this.h, this.w, this.h - 2, this.paint_round);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (getHeight() / 2);
    this.w = (getWidth() / 2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mPaint.setColor(paramInt);
    if (Util.isColdColor(paramInt)) {
      this.paint_round.setColor(Color.parseColor("#ffffff"));
    }
    for (;;)
    {
      invalidate();
      return;
      this.paint_round.setColor(Color.parseColor("#000000"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.RoundView
 * JD-Core Version:    0.7.0.1
 */