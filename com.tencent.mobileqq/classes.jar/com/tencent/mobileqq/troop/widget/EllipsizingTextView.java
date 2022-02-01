package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.filecommon.api.R.styleable;
import com.tencent.theme.ISkinIgnoreTypeface;

public class EllipsizingTextView
  extends TextView
  implements ISkinIgnoreTypeface
{
  private EllipsizingTextView.EllipsizingHelper a;
  private int b = 1;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public EllipsizingTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    this.c = 0;
    this.d = false;
    this.e = false;
    this.f = false;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ac);
      int j = paramContext.getIndexCount();
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.ae) {
          this.c = paramContext.getDimensionPixelOffset(k, this.c);
        } else if (k == R.styleable.af) {
          this.b = paramContext.getInt(k, this.b);
        } else if (k == R.styleable.ad) {
          this.d = paramContext.getBoolean(k, this.d);
        }
        i += 1;
      }
      paramContext.recycle();
    }
    setTypeface(null);
  }
  
  private EllipsizingTextView.EllipsizingHelper getHelper()
  {
    if (this.a == null) {
      this.a = new EllipsizingTextView.EllipsizingHelper(this);
    }
    return this.a;
  }
  
  public void a()
  {
    this.f = true;
  }
  
  public int getLineCount()
  {
    return getHelper().a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = getPaint();
    ((TextPaint)localObject).setColor(getCurrentTextColor());
    ((TextPaint)localObject).drawableState = getDrawableState();
    localObject = getHelper();
    ((EllipsizingTextView.EllipsizingHelper)localObject).a(getText(), this, this.b, this.c, this.d);
    if (getEllipsize() == TextUtils.TruncateAt.END)
    {
      ((EllipsizingTextView.EllipsizingHelper)localObject).a(paramCanvas, TextUtils.TruncateAt.END);
      return;
    }
    if (getEllipsize() == TextUtils.TruncateAt.MIDDLE)
    {
      ((EllipsizingTextView.EllipsizingHelper)localObject).a(paramCanvas, TextUtils.TruncateAt.MIDDLE);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setEndStrWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView
 * JD-Core Version:    0.7.0.1
 */