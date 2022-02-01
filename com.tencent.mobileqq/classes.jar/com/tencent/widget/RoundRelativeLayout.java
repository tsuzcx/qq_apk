package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.av.utils.api.IUIToolsTempApi;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class RoundRelativeLayout
  extends RelativeLayout
{
  private float a = 16.0F;
  private Path b;
  private RectF c;
  
  public RoundRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public RoundRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    Object localObject = this.b;
    RectF localRectF = this.c;
    float f = this.a;
    ((Path)localObject).addRoundRect(localRectF, f, f, Path.Direction.CW);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("roundLayoutRadius ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("RoundRelativeLayout", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    this.a = ((IUIToolsTempApi)QRoute.api(IUIToolsTempApi.class)).dp2px(getContext(), paramInt);
    setWillNotDraw(false);
    this.b = new Path();
    this.c = new RectF();
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = ((IUIToolsTempApi)QRoute.api(IUIToolsTempApi.class)).dp2px(getContext(), 16.0F);
    setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.round_rect_corner_image);
      if (paramContext != null)
      {
        this.a = paramContext.getDimensionPixelSize(0, 0);
        paramContext.recycle();
      }
    }
    this.b = new Path();
    this.c = new RectF();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.a > 0.0F) && (this.b != null))
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.clipPath(this.b);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    RectF localRectF = this.c;
    if (localRectF == null) {
      return;
    }
    localRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    a();
  }
  
  public void setRoundLayoutRadius(float paramFloat)
  {
    this.a = paramFloat;
    a();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */