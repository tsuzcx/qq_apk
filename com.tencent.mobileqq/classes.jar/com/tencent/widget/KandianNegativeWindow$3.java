package com.tencent.widget;

import bklj;
import com.tencent.qphone.base.util.QLog;

public class KandianNegativeWindow$3
  implements Runnable
{
  public KandianNegativeWindow$3(bklj parambklj, StringBuilder paramStringBuilder, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append("x:" + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  y:" + this.b);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  mTriangleHeight:" + this.this$0.h);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  mScreenWidth:" + this.this$0.i);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  mTriangleHeight:" + this.this$0.j);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  mWindowWidth:" + this.this$0.k);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  mChildrenItemHeight:" + this.this$0.m);
    this.jdField_a_of_type_JavaLangStringBuilder.append("  isNormal:" + this.jdField_a_of_type_Boolean);
    QLog.d("KandianNegativeWindow", 1, "calculatePosition," + this.jdField_a_of_type_JavaLangStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow.3
 * JD-Core Version:    0.7.0.1
 */