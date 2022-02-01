package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class QIdentityCircleLayout
  extends FrameLayout
{
  private Path a = new Path();
  private final float b = 0.75F;
  private final float c = 0.55F;
  private int d;
  private int e;
  
  public QIdentityCircleLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIdentityCircleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIdentityCircleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    float f = ScreenUtil.getInstantScreenWidth(getContext());
    int i = (int)(f / 0.75F);
    this.d = ((int)(f * 0.55F));
    this.e = ((int)(i * 0.55F));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    paramCanvas.clipPath(this.a);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    paramCanvas.clipPath(this.a);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.d, this.e);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.d, -2147483648), View.MeasureSpec.makeMeasureSpec(this.e, -2147483648));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = Math.min(paramInt1, paramInt2);
    this.a.reset();
    RectF localRectF = new RectF((paramInt1 - paramInt3) / 2.0F, (paramInt2 - paramInt3) / 2.0F, (paramInt1 + paramInt3) / 2.0F, (paramInt2 + paramInt3) / 2.0F);
    Path localPath = this.a;
    float f = paramInt3 / 2.0F;
    localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
    this.a.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.QIdentityCircleLayout
 * JD-Core Version:    0.7.0.1
 */