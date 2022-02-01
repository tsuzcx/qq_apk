package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.tencent.mobileqq.kandian.api.R.styleable;

class TickerView$StyledAttributes
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = -16777216;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  
  TickerView$StyledAttributes(TickerView paramTickerView, Resources paramResources)
  {
    this.jdField_d_of_type_Float = TypedValue.applyDimension(2, 12.0F, paramResources.getDisplayMetrics());
    this.jdField_a_of_type_Int = 8388611;
  }
  
  void a(TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_Int = paramTypedArray.getInt(R.styleable.i, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = paramTypedArray.getColor(R.styleable.k, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Float = paramTypedArray.getFloat(R.styleable.l, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = paramTypedArray.getFloat(R.styleable.m, this.jdField_b_of_type_Float);
    this.jdField_c_of_type_Float = paramTypedArray.getFloat(R.styleable.n, this.jdField_c_of_type_Float);
    this.jdField_a_of_type_JavaLangString = paramTypedArray.getString(R.styleable.j);
    this.jdField_c_of_type_Int = paramTypedArray.getColor(R.styleable.h, this.jdField_c_of_type_Int);
    this.jdField_d_of_type_Float = paramTypedArray.getDimension(R.styleable.f, this.jdField_d_of_type_Float);
    this.jdField_d_of_type_Int = paramTypedArray.getInt(R.styleable.g, this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView.StyledAttributes
 * JD-Core Version:    0.7.0.1
 */