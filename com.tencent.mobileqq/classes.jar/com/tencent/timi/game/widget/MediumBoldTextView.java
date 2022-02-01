package com.tencent.timi.game.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.timi_game.impl.R.styleable;

public class MediumBoldTextView
  extends AppCompatTextView
{
  public boolean a = true;
  private float b = 0.9F;
  
  public MediumBoldTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MediumBoldTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediumBoldTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bF, paramInt, 0);
    this.b = paramContext.getFloat(R.styleable.bG, 0.9F);
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a)
    {
      TextPaint localTextPaint = getPaint();
      localTextPaint.setStrokeWidth(this.b);
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.widget.MediumBoldTextView
 * JD-Core Version:    0.7.0.1
 */