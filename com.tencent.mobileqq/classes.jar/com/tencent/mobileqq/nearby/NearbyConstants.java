package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant.Nearby;

public abstract interface NearbyConstants
{
  public static final int a;
  public static final String a;
  public static final int b;
  public static final String b;
  public static final int c;
  public static final String c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  
  static
  {
    jdField_a_of_type_JavaLangString = QQNearbyManager.d().getName();
    jdField_b_of_type_JavaLangString = FaceConstant.Nearby.NEAR_BY_FACE_HANDLER;
    jdField_a_of_type_Int = QQNearbyManager.a();
    jdField_b_of_type_Int = jdField_a_of_type_Int;
    jdField_c_of_type_Int = jdField_b_of_type_Int + 1;
    d = jdField_c_of_type_Int + 1;
    e = d + 1;
    f = e + 1;
    g = f + 1;
    h = g + 1;
    i = h + 1;
    j = i + 1;
    k = j + 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".nearby_hearanim");
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyConstants
 * JD-Core Version:    0.7.0.1
 */