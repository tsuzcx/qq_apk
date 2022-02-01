package com.tencent.widget;

import java.util.Formatter;

final class TCWNumberPicker$1
  implements TCWNumberPicker.Formatter
{
  final StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  final Formatter jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder);
  final Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[1];
  
  public String a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfJavaLangObject[0] = Integer.valueOf(paramInt);
    StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder.delete(0, localStringBuilder.length());
    this.jdField_a_of_type_JavaUtilFormatter.format("%02d", this.jdField_a_of_type_ArrayOfJavaLangObject);
    return this.jdField_a_of_type_JavaUtilFormatter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker.1
 * JD-Core Version:    0.7.0.1
 */