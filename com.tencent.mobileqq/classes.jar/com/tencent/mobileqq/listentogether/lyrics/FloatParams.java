package com.tencent.mobileqq.listentogether.lyrics;

import android.graphics.Paint.Align;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class FloatParams
{
  public int a;
  public Paint.Align a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h = false;
  public int i;
  
  public FloatParams()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 0;
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_e_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    return (this.jdField_e_of_type_Int == this.jdField_f_of_type_Int) && (TextUtils.equals(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString)) && (this.jdField_e_of_type_Int != 0) && (this.jdField_b_of_type_JavaLangString != null);
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return (paramInt == this.jdField_e_of_type_Int) && (TextUtils.equals(paramString, this.jdField_b_of_type_JavaLangString)) && (paramInt != 0) && (paramString != null);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_f_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public boolean b(int paramInt, String paramString)
  {
    return (paramInt == this.jdField_f_of_type_Int) && (TextUtils.equals(paramString, this.jdField_c_of_type_JavaLangString)) && (paramInt != 0) && (paramString != null);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FloatParams[\niconCenterX:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\niconCenterY:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\nalignRight:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\nuserClosed:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append("\nalbumUrl:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\nshowIcon:");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append("\nisForeground:");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    localStringBuilder.append("\ntmpGoneForSomePage:");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    localStringBuilder.append("\ncurrentListenType:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\ncurrentListenUin:");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\ncurrentAIOType:");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("\ncurrentAIOUin:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\ntextNeedCenter:");
    localStringBuilder.append(this.jdField_e_of_type_Boolean);
    localStringBuilder.append("\nshowIconValueChanged:");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    localStringBuilder.append("\n]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.FloatParams
 * JD-Core Version:    0.7.0.1
 */