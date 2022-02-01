package com.tencent.mobileqq.flutter.qqface;

public class DecodeRequest
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  
  public DecodeRequest(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
    this.c = a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    this.d = localStringBuilder.toString();
  }
  
  private static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flutter_face_path_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flutter_face_bmp_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public static String[] a(int paramInt, String paramString)
  {
    return new String[] { a(paramInt, paramString, 1), a(paramInt, paramString, 2), a(paramInt, paramString, 3) };
  }
  
  public static String[] b(int paramInt, String paramString)
  {
    return new String[] { a(paramInt, paramString) };
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecodeRequest{faceType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", faceUin='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceShape=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.DecodeRequest
 * JD-Core Version:    0.7.0.1
 */