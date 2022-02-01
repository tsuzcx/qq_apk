package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class URLTextImageView
  extends URLImageView
{
  public String G;
  Paint H;
  int I;
  public int J = 0;
  float K = 0.0F;
  int L = 2131165875;
  
  public URLTextImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public URLTextImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public URLTextImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!TextUtils.isEmpty(this.G))
    {
      if (this.H == null)
      {
        this.H = new Paint(1);
        this.H.setColor(getContext().getResources().getColor(this.L));
        this.H.setTextAlign(Paint.Align.CENTER);
      }
      if (this.J != this.H.getTextSize())
      {
        this.H.setTextSize(this.J);
        Paint.FontMetricsInt localFontMetricsInt = this.H.getFontMetricsInt();
        this.I = ((getHeight() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top);
      }
      int i = this.I;
      float f = this.K;
      if (f != 0.0F) {
        i = (int)(f * getHeight());
      }
      paramCanvas.drawText(this.G, getWidth() / 2, i, this.H);
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.L = paramInt;
    Paint localPaint = this.H;
    if (localPaint != null) {
      localPaint.setColor(getContext().getResources().getColor(this.L));
    }
  }
  
  public void setTextSize(int paramInt)
  {
    this.J = paramInt;
  }
  
  public void setTopPercent(float paramFloat)
  {
    this.K = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.URLTextImageView
 * JD-Core Version:    0.7.0.1
 */