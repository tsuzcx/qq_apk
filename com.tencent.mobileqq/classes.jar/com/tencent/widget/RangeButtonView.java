package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Point;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import bfve;
import bfvf;
import bfvg;
import bfvh;
import bfvi;
import bfvj;
import bfvk;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangeButtonView
  extends View
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private bfve jdField_a_of_type_Bfve;
  public bfvf a;
  private bfvg jdField_a_of_type_Bfvg;
  private bfvh jdField_a_of_type_Bfvh;
  private bfvj jdField_a_of_type_Bfvj;
  private bfvk jdField_a_of_type_Bfvk;
  private List<bfvi> jdField_a_of_type_JavaUtilList;
  private List<String> b;
  
  public RangeButtonView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RangeButtonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public RangeButtonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Bfvf = new bfvf(this);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RangeButtonView, 0, 0);
    this.jdField_a_of_type_Bfvf.jdField_a_of_type_Float = paramContext.getDimension(0, a(26.0F));
    this.jdField_a_of_type_Bfvf.jdField_b_of_type_Float = paramContext.getDimension(1, a(26.0F));
    this.jdField_a_of_type_Bfvf.f = paramContext.getDimension(8, a(8.0F));
    this.jdField_a_of_type_Bfvf.jdField_a_of_type_Int = paramContext.getColor(7, 17170446);
    this.jdField_a_of_type_Bfvf.jdField_c_of_type_Float = paramContext.getDimension(4, a(24.0F));
    this.jdField_a_of_type_Bfvf.jdField_b_of_type_Int = paramContext.getColor(2, 17170446);
    this.jdField_a_of_type_Bfvf.jdField_d_of_type_Float = paramContext.getDimension(3, a(8.0F));
    this.jdField_a_of_type_Bfvf.e = paramContext.getDimension(5, a(1.0F));
    this.jdField_a_of_type_Bfvf.jdField_d_of_type_Int = paramContext.getResourceId(6, 2130844369);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_Bfvf.jdField_d_of_type_Int);
    if (AppSetting.d)
    {
      this.jdField_a_of_type_Bfvg = new bfvg(this, this);
      ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_Bfvg);
      ViewCompat.setImportantForAccessibility(this, 1);
    }
  }
  
  private float a()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      TextPaint localTextPaint = new TextPaint();
      i = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        localTextPaint.setTextSize(((bfvi)localIterator.next()).jdField_a_of_type_Float);
        Paint.FontMetrics localFontMetrics = localTextPaint.getFontMetrics();
        if (i - Math.abs(localFontMetrics.top) >= 0.0F) {
          break label97;
        }
        i = (int)Math.abs(localFontMetrics.top);
      }
    }
    label97:
    for (;;)
    {
      break;
      return i;
      return a(120.0F);
    }
  }
  
  private float a(float paramFloat)
  {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  public static float a(String paramString, float paramFloat)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(paramFloat);
    return localTextPaint.measureText(paramString);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ArrayList localArrayList = this.jdField_a_of_type_Bfvk.a();
    int i = 0;
    while (i < localArrayList.size())
    {
      Point localPoint = (Point)localArrayList.get(i);
      int j = localPoint.y;
      int k = localPoint.y;
      if ((paramInt2 < j - paramInt4) || (paramInt2 > k + paramInt4)) {
        paramInt1 = -1;
      }
      do
      {
        return paramInt1;
        j = localPoint.x;
        k = localPoint.x;
        if ((paramInt1 <= j - paramInt3) || (paramInt1 >= k + paramInt3)) {
          break;
        }
        paramInt1 = i;
      } while (!paramBoolean);
      this.jdField_a_of_type_Bfvh.a(localPoint.x, localPoint.y);
      return i;
      i += 1;
    }
    return -1;
  }
  
  private float b()
  {
    float f2 = a();
    float f3 = this.jdField_a_of_type_Bfvf.jdField_c_of_type_Float;
    float f4 = this.jdField_a_of_type_Bfvf.jdField_d_of_type_Float;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    for (float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();; f1 = 0.0F) {
      return Math.max(f4, f1) + (f3 + f2);
    }
  }
  
  @TargetApi(14)
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.d) && (this.jdField_a_of_type_Bfvg.dispatchHoverEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Bfvj == null)
    {
      this.jdField_a_of_type_Bfvf.jdField_c_of_type_Int = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_Bfvk = new bfvk((int)(getPaddingLeft() + this.jdField_a_of_type_Bfvf.jdField_a_of_type_Float), (int)(getWidth() - this.jdField_a_of_type_Bfvf.jdField_b_of_type_Float - getPaddingRight()), (int)(this.jdField_a_of_type_Bfvf.f + this.jdField_a_of_type_Bfvf.jdField_c_of_type_Float + a()), this.jdField_a_of_type_Bfvf.jdField_c_of_type_Int);
      this.jdField_a_of_type_Bfvk.a(this.jdField_a_of_type_Bfvf.jdField_d_of_type_Float);
      Object localObject2 = this.jdField_a_of_type_Bfvk.a();
      Object localObject1 = new ArrayList(((ArrayList)localObject2).size());
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(Integer.valueOf(((Point)((Iterator)localObject2).next()).x));
      }
      this.jdField_a_of_type_Bfvj = new bfvj(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Bfvj.a((ArrayList)localObject1, (int)(this.jdField_a_of_type_Bfvf.f + a()));
      localObject1 = (Point)this.jdField_a_of_type_Bfvk.a().get(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Bfvh = new bfvh(((Point)localObject1).x, ((Point)localObject1).y, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    this.jdField_a_of_type_Bfvj.a(paramCanvas, this.jdField_a_of_type_AndroidTextTextPaint);
    this.jdField_a_of_type_Bfvk.a(paramCanvas, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Bfvf);
    this.jdField_a_of_type_Bfvh.a(paramCanvas, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = (int)b();
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == -2147483648)
    {
      paramInt2 = i;
      if (k != -2147483648) {
        break label76;
      }
      paramInt1 = Math.min(j, paramInt1);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = i;
      if (m == 1073741824) {
        break;
      }
      paramInt2 = 0;
      break;
      label76:
      if (k != 1073741824) {
        paramInt1 = (int)(getPaddingTop() + j + this.jdField_a_of_type_Bfvf.f);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    do
    {
      return true;
      if ((this.jdField_a_of_type_Bfvk == null) || (this.jdField_a_of_type_Bfvh == null)) {
        return false;
      }
      i = a((int)f1, (int)f2, this.jdField_a_of_type_Bfvk.a() / 2, this.jdField_a_of_type_Bfvh.a() / 2, true);
    } while ((i == this.jdField_a_of_type_Int) || (i == -1));
    if (this.jdField_a_of_type_Bfve != null) {
      this.jdField_a_of_type_Bfve.a(this.jdField_a_of_type_Int, i);
    }
    this.jdField_a_of_type_Int = i;
    invalidate();
    return true;
  }
  
  public void setContentDescList(List<String> paramList)
  {
    this.b = paramList;
  }
  
  public void setOnChangerListener(bfve parambfve)
  {
    this.jdField_a_of_type_Bfve = parambfve;
  }
  
  public void setThumbPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Bfvk == null) {
      return;
    }
    Point localPoint = (Point)this.jdField_a_of_type_Bfvk.a().get(paramInt);
    this.jdField_a_of_type_Bfvh.a(localPoint.x, localPoint.y);
    invalidate();
  }
  
  public void setTitleData(List<bfvi> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.RangeButtonView
 * JD-Core Version:    0.7.0.1
 */