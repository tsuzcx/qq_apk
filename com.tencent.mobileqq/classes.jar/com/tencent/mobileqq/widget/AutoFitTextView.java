package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoFitTextView
  extends TextView
{
  private Paint a = new Paint();
  private float b;
  private AutoFitTextView.OnGetMaxWidthCallback c;
  
  public AutoFitTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a.set(getPaint());
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramInt <= 0) {
        return;
      }
      if (this.b == 0.0F) {
        this.b = getTextSize();
      }
      Object localObject = this.c;
      if (localObject != null) {
        paramInt = ((AutoFitTextView.OnGetMaxWidthCallback)localObject).a();
      } else {
        paramInt = getWidth();
      }
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getCompoundDrawablePadding();
      localObject = new Rect();
      this.a.setTextSize(this.b);
      this.a.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
      float f1 = ((Rect)localObject).width();
      float f2 = this.b;
      while (f1 > paramInt - i - j - k)
      {
        f2 -= 1.0F;
        this.a.setTextSize(f2);
        f1 = this.a.measureText(paramString);
      }
      setTextSize(0, f2);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(getText().toString(), getWidth());
  }
  
  public void setOnGetMaxWidthCallback(AutoFitTextView.OnGetMaxWidthCallback paramOnGetMaxWidthCallback)
  {
    this.c = paramOnGetMaxWidthCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoFitTextView
 * JD-Core Version:    0.7.0.1
 */