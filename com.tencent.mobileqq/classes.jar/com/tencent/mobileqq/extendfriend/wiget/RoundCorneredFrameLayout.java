package com.tencent.mobileqq.extendfriend.wiget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class RoundCorneredFrameLayout
  extends FrameLayout
{
  public int a = 6;
  
  @TargetApi(11)
  public RoundCorneredFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  @TargetApi(11)
  public RoundCorneredFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = AIOUtils.dp2px(a(paramContext, paramAttributeSet), paramContext.getResources());
  }
  
  int a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.roundCornerViewDefinedAttr);
    int i = paramContext.getInt(0, 6);
    paramContext.recycle();
    return i;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    Path localPath = new Path();
    localPath.moveTo(0.0F, this.a);
    localPath.arcTo(new RectF(0.0F, 0.0F, this.a * 2, this.a * 2), -180.0F, 90.0F);
    localPath.lineTo(i - this.a, 0.0F);
    localPath.arcTo(new RectF(i - this.a * 2, 0.0F, i, this.a * 2), -90.0F, 90.0F);
    localPath.lineTo(i, j - this.a);
    localPath.arcTo(new RectF(i - this.a * 2, j - this.a * 2, i, j), 0.0F, 90.0F);
    localPath.lineTo(this.a, j);
    localPath.arcTo(new RectF(0.0F, j - this.a * 2, this.a * 2, j), 90.0F, 90.0F);
    localPath.lineTo(0.0F, this.a);
    localPath.close();
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.RoundCorneredFrameLayout
 * JD-Core Version:    0.7.0.1
 */