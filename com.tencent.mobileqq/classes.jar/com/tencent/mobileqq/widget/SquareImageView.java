package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqui.R.styleable;

public class SquareImageView
  extends URLImageView
{
  public static final String b = "SquareImageView";
  private float jdField_a_of_type_Float = 1.0F;
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  protected final Path a;
  protected final RectF a;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = -1;
  private int c = 20;
  private int d = -1;
  
  public SquareImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bs);
    this.jdField_a_of_type_Float = paramContext.getFloat(R.styleable.bF, 1.0F);
    this.jdField_b_of_type_Float = paramContext.getFloat(R.styleable.bG, 0.0F);
    this.jdField_b_of_type_Int = paramContext.getColor(R.styleable.bB, -1);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(R.styleable.bC);
    this.c = paramContext.getDimensionPixelSize(R.styleable.bD, 40);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.bE, 0);
    paramContext.recycle();
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())
      {
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        int i = this.jdField_a_of_type_Int;
        localPath.addRoundRect(localRectF, i, i, Path.Direction.CW);
      }
      if (Build.VERSION.SDK_INT >= 18) {
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      }
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = this.d;
    if (i != -1)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(false);
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.onDraw(paramCanvas);
    Paint localPaint;
    Object localObject;
    if (this.jdField_b_of_type_Int != -1)
    {
      localPaint = new Paint();
      localPaint.setColor(this.jdField_b_of_type_Int);
      localObject = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      i = this.jdField_a_of_type_Int;
      paramCanvas.drawRoundRect((RectF)localObject, i, i, localPaint);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localPaint = new Paint(1);
      localPaint.setTextSize(this.c);
      localPaint.setColor(-1);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localObject = localPaint.getFontMetricsInt();
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, getMeasuredWidth() / 2, (getMeasuredHeight() - ((Paint.FontMetricsInt)localObject).ascent - ((Paint.FontMetricsInt)localObject).descent) / 2, localPaint);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
    paramInt1 = getMeasuredWidth();
    setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * 1.0F / this.jdField_a_of_type_Float + (int)this.jdField_b_of_type_Float), 1073741824));
  }
  
  public void setCircleBgColor(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public void setFilterColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setFilterText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    requestLayout();
  }
  
  public void setFilterTextSize(int paramInt)
  {
    this.c = paramInt;
    requestLayout();
  }
  
  public void setImageScale(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 0.0F) {
      this.jdField_a_of_type_Float = paramFloat1;
    }
    this.jdField_b_of_type_Float = paramFloat2;
    requestLayout();
  }
  
  public void setRoundRect(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SquareImageView
 * JD-Core Version:    0.7.0.1
 */