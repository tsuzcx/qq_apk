package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;

public class TitledImageView
  extends AnyScaleTypeImageView
{
  private int jdField_a_of_type_Int = -16777216;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Layout jdField_a_of_type_AndroidTextLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
  private TransformationMethod jdField_a_of_type_AndroidTextMethodTransformationMethod;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private int b = -1;
  private int c = 10;
  private int d = 10;
  
  public TitledImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextMethodTransformationMethod = SingleLineTransformationMethod.getInstance();
  }
  
  public TitledImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextMethodTransformationMethod = SingleLineTransformationMethod.getInstance();
  }
  
  public TitledImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextMethodTransformationMethod = SingleLineTransformationMethod.getInstance();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      float f = getMeasuredHeight() - this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() - this.c * 2;
      paramCanvas.save();
      paramCanvas.clipRect(0.0F, f, getMeasuredWidth(), getMeasuredHeight());
      if (this.jdField_a_of_type_AndroidGraphicsPath != null) {
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidTextTextPaint);
      }
      paramCanvas.translate(0.0F + this.c, f + this.c);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.b);
      if (this.jdField_a_of_type_AndroidTextLayout != null) {
        this.jdField_a_of_type_AndroidTextLayout.draw(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getMeasuredHeight();
    paramInt2 = getMeasuredWidth();
    if ((paramInt1 < 1) || (paramInt2 < 1)) {}
    float f2;
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      float f1 = paramInt1 - this.c * 2 - this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
      f2 = paramInt2;
      float f3 = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, f1);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2, f1);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2, f3 - this.d);
      localObject = new RectF(f2 - this.d * 2, f3 - this.d * 2, f2, f3);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo((RectF)localObject, 0.0F, 90.0F, false);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.d + 0.0F, f3);
      localObject = new RectF(0.0F, f3 - this.d * 2, this.d * 2 + 0.0F, f3);
      this.jdField_a_of_type_AndroidGraphicsPath.arcTo((RectF)localObject, 90.0F, 90.0F, true);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, f1);
      this.jdField_a_of_type_AndroidGraphicsPath.close();
    } while (this.jdField_a_of_type_JavaLangCharSequence == null);
    Object localObject = this.jdField_a_of_type_AndroidTextMethodTransformationMethod.getTransformation(this.jdField_a_of_type_JavaLangCharSequence, this);
    paramInt1 = (int)Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint);
    this.jdField_a_of_type_AndroidTextLayout = new DynamicLayout(this.jdField_a_of_type_JavaLangCharSequence, (CharSequence)localObject, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.5F, false, TextUtils.TruncateAt.END, (int)(f2 - this.c * 2));
  }
  
  public void setTextBackground(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setTextPadding(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.jdField_a_of_type_JavaLangCharSequence instanceof QQText))
    {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = new QQText(paramCharSequence, 1, 16);
  }
  
  public void settextBgRadius(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.TitledImageView
 * JD-Core Version:    0.7.0.1
 */