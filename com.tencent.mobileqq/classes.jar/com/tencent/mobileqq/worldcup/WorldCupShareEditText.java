package com.tencent.mobileqq.worldcup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class WorldCupShareEditText
  extends EditText
{
  private Paint a = new Paint(1);
  
  public WorldCupShareEditText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WorldCupShareEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a.setColor(-8618884);
    this.a.setStrokeWidth(AIOUtils.a(1.0F, getResources()));
    this.a.setStyle(Paint.Style.STROKE);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getScrollX();
    int j = getScrollY();
    int k = getWidth();
    int m = getHeight();
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(i + getPaddingLeft(), j + getPaddingTop());
    paramCanvas.drawLine(0.0F, m, k, m, this.a);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.WorldCupShareEditText
 * JD-Core Version:    0.7.0.1
 */