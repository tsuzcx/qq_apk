package com.tencent.mobileqq.search.base.widget;

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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.impl.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class RoundRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 16.0F;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  
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
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f = this.jdField_a_of_type_Float;
    ((Path)localObject).addRoundRect(localRectF, f, f, Path.Direction.CW);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("roundLayoutRadius ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
    QLog.i("RoundRelativeLayout", 2, ((StringBuilder)localObject).toString());
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_Float = ((IUIToolsTempApi)QRoute.api(IUIToolsTempApi.class)).dp2px(getContext(), 16.0F);
    setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cu);
      if (paramContext != null)
      {
        this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(R.styleable.a, 0);
        paramContext.recycle();
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Float > 0.0F) && (this.jdField_a_of_type_AndroidGraphicsPath != null))
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.draw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localRectF == null) {
      return;
    }
    localRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    a();
  }
  
  public void setRoundLayoutRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    a();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.widget.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */