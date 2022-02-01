package com.tencent.mobileqq.vas.ui;

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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;

public class CoolTextView
  extends TextView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private CoolTextView.CoolBuilder jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder = new CoolTextView.CoolBuilder();
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
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable == null) {
      return;
    }
    localURLDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    setCompoundDrawables(this.jdField_a_of_type_ComTencentImageURLDrawable, null, null, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    URLDrawable localURLDrawable = this.jdField_b_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable == null) {
      return;
    }
    localURLDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
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
    paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_Float, getPaint());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    float f1 = Layout.getDesiredWidth(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_d_of_type_JavaLangString, getPaint());
    paramInt1 = this.jdField_a_of_type_Int;
    int i = (int)f1;
    setMeasuredDimension(paramInt1 + i + ViewUtils.a(7.5F), Math.max(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int));
    paramInt1 = Math.abs(this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    paramInt2 = this.jdField_c_of_type_Int + paramInt1;
    i = this.jdField_a_of_type_Int + i + ViewUtils.a(7.5F);
    Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left = 10;
    ((Rect)localObject).right = i;
    int j = this.jdField_d_of_type_Int;
    ((Rect)localObject).top = (paramInt1 - j);
    ((Rect)localObject).bottom = (paramInt2 + j);
    localObject = this.jdField_a_of_type_AndroidGraphicsRect;
    ((Rect)localObject).left = (this.jdField_a_of_type_Int + 5);
    ((Rect)localObject).top = (paramInt1 - j);
    ((Rect)localObject).right = i;
    ((Rect)localObject).bottom = (paramInt2 + j);
    localObject = getPaint().getFontMetrics();
    f1 = (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F;
    float f2 = ((Paint.FontMetrics)localObject).bottom;
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.centerY() + (f1 - f2));
  }
  
  public void setCoolBuilder(CoolTextView.CoolBuilder paramCoolBuilder)
  {
    if (paramCoolBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder = paramCoolBuilder;
    }
    this.jdField_a_of_type_Int = ViewUtils.a(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = ViewUtils.a(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_b_of_type_Int);
    this.jdField_c_of_type_Int = ViewUtils.a(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_b_of_type_JavaLangString))
    {
      paramCoolBuilder = new ApngOptions();
      paramCoolBuilder.a(URLDrawableHelperConstants.a);
      paramCoolBuilder.a(new int[] { 9 });
      this.jdField_a_of_type_ComTencentImageURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_b_of_type_JavaLangString, paramCoolBuilder);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_c_of_type_JavaLangString)) {
      this.jdField_b_of_type_ComTencentImageURLDrawable = VasApngUtil.getRegionUrlDrawable(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_c_of_type_JavaLangString, getResources().getDisplayMetrics().densityDpi);
    } else {
      this.jdField_b_of_type_ComTencentImageURLDrawable = null;
    }
    setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_d_of_type_Int);
    try
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_a_of_type_JavaLangString)) {
        setTextColor(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqVasUiCoolTextView$CoolBuilder.jdField_a_of_type_JavaLangString));
      } else {
        setTextColor(getResources().getColor(2131167056));
      }
    }
    catch (Exception paramCoolBuilder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QID_LOG,color_parse,");
      localStringBuilder.append(paramCoolBuilder.getMessage());
      QLog.d("CoolTextView", 2, localStringBuilder.toString());
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.CoolTextView
 * JD-Core Version:    0.7.0.1
 */