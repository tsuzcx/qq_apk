package me.ele.uetool.colorpicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class RoundView
  extends View
{
  private int h;
  private boolean isChosen = false;
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
    this.paint_round.setColor(Color.parseColor("#ffffff"));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawCircle(this.h, this.w, this.h - 8, this.mPaint);
    if (this.isChosen) {
      paramCanvas.drawCircle(this.h, this.w, this.h - 2, this.paint_round);
    }
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
    invalidate();
  }
  
  public void setChosen(boolean paramBoolean)
  {
    this.isChosen = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.colorpicker.RoundView
 * JD-Core Version:    0.7.0.1
 */