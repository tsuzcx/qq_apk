package com.tencent.mobileqq.guild.audio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.guild.impl.R.styleable;
import com.tencent.mobileqq.utils.ViewUtils;

public class RoundCornerLayout
  extends RelativeLayout
{
  private final Paint a = new Paint();
  private final float[] b;
  
  public RoundCornerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bZ);
    paramInt = paramContext.getInt(R.styleable.cb, 0);
    int i = paramContext.getInt(R.styleable.ca, 0);
    int j = paramContext.getInt(R.styleable.cd, 0);
    int k = paramContext.getInt(R.styleable.cc, 0);
    float f2 = paramInt;
    float f1 = ViewUtils.dip2px(f2);
    f2 = ViewUtils.dip2px(f2);
    float f4 = j;
    float f3 = ViewUtils.dip2px(f4);
    f4 = ViewUtils.dip2px(f4);
    float f6 = k;
    float f5 = ViewUtils.dip2px(f6);
    f6 = ViewUtils.dip2px(f6);
    float f7 = i;
    this.b = new float[] { f1, f2, f3, f4, f5, f6, ViewUtils.dip2px(f7), ViewUtils.dip2px(f7) };
    paramContext.recycle();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    Path localPath1 = new Path();
    localPath1.addRoundRect(new RectF(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom()), this.b, Path.Direction.CW);
    float f1 = i;
    float f2 = j;
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, f1, f2), null, 31);
    super.dispatchDraw(paramCanvas);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(localPath1, this.a);
    }
    else
    {
      this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      Path localPath2 = new Path();
      localPath2.addRect(0.0F, 0.0F, f1, f2, Path.Direction.CW);
      localPath2.op(localPath1, Path.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath2, this.a);
    }
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.RoundCornerLayout
 * JD-Core Version:    0.7.0.1
 */