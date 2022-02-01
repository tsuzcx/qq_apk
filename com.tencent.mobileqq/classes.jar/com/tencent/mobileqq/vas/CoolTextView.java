package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.annotation.Nullable;
import bhmw;
import bhoo;
import bhop;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class CoolTextView
  extends TextView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private bhmw jdField_a_of_type_Bhmw = new bhmw();
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  URLDrawable jdField_b_of_type_ComTencentImageURLDrawable;
  int c;
  int d;
  
  public CoolTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CoolTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    setCompoundDrawables(this.jdField_a_of_type_ComTencentImageURLDrawable, null, null, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_ComTencentImageURLDrawable == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentImageURLDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
    this.jdField_b_of_type_ComTencentImageURLDrawable.draw(paramCanvas);
  }
  
  protected void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      localMarginLayoutParams.setMargins(paramInt1, paramInt3, paramInt2, paramInt4);
      setLayoutParams(localMarginLayoutParams);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.onDraw(paramCanvas);
    paramCanvas.drawText(this.jdField_a_of_type_Bhmw.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_Float, getPaint());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f = Layout.getDesiredWidth(this.jdField_a_of_type_Bhmw.jdField_d_of_type_JavaLangString, getPaint());
    setMeasuredDimension(this.jdField_a_of_type_Int + (int)f + ViewUtils.dip2px(7.5F), Math.max(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
    paramInt1 = Math.abs(this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    paramInt2 = this.jdField_c_of_type_Int + paramInt1;
    int i = this.jdField_a_of_type_Int;
    i = (int)f + i + ViewUtils.dip2px(7.5F);
    this.jdField_b_of_type_AndroidGraphicsRect.left = 10;
    this.jdField_b_of_type_AndroidGraphicsRect.right = i;
    this.jdField_b_of_type_AndroidGraphicsRect.top = (paramInt1 - this.jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = (this.jdField_d_of_type_Int + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRect.left = (this.jdField_a_of_type_Int + 5);
    this.jdField_a_of_type_AndroidGraphicsRect.top = (paramInt1 - this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsRect.right = i;
    this.jdField_a_of_type_AndroidGraphicsRect.bottom = (this.jdField_d_of_type_Int + paramInt2);
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    this.jdField_a_of_type_Float = ((localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.bottom + this.jdField_a_of_type_AndroidGraphicsRect.centerY());
  }
  
  public void setCoolBuilder(bhmw parambhmw)
  {
    if (parambhmw != null) {
      this.jdField_a_of_type_Bhmw = parambhmw;
    }
    this.jdField_a_of_type_Int = ViewUtils.dip2px(this.jdField_a_of_type_Bhmw.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = ViewUtils.dip2px(this.jdField_a_of_type_Bhmw.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = ViewUtils.dip2px(this.jdField_a_of_type_Bhmw.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bhmw.jdField_b_of_type_JavaLangString))
    {
      parambhmw = new bhop();
      parambhmw.a(URLDrawableHelper.TRANSPARENT);
      parambhmw.a(new int[] { 9 });
      this.jdField_a_of_type_ComTencentImageURLDrawable = bhoo.a(this.jdField_a_of_type_Bhmw.jdField_b_of_type_JavaLangString, parambhmw);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Bhmw.jdField_c_of_type_JavaLangString)) {
      this.jdField_b_of_type_ComTencentImageURLDrawable = VasApngUtil.getRegionUrlDrawable(this.jdField_a_of_type_Bhmw.jdField_c_of_type_JavaLangString, getResources().getDisplayMetrics().densityDpi);
    }
    setTextSize(1, this.jdField_a_of_type_Bhmw.jdField_d_of_type_Int);
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bhmw.jdField_a_of_type_JavaLangString)) {
        setTextColor(Color.parseColor(this.jdField_a_of_type_Bhmw.jdField_a_of_type_JavaLangString));
      }
      a();
      return;
    }
    catch (Exception parambhmw)
    {
      for (;;)
      {
        QLog.d("CoolTextView", 2, "QID_LOG,color_parse," + parambhmw.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.CoolTextView
 * JD-Core Version:    0.7.0.1
 */