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
    this.d = (paramString + "_" + paramInt1 + "_" + paramInt2);
  }
  
  private static String a(int paramInt, String paramString)
  {
    return "flutter_face_path_" + paramInt + "_" + paramString;
  }
  
  private static String a(int paramInt1, String paramString, int paramInt2)
  {
    return "flutter_face_bmp_" + paramInt1 + "_" + paramString + "_" + paramInt2;
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
    return "DecodeRequest{faceType=" + this.jdField_a_of_type_Int + ", faceUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", faceShape=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.DecodeRequest
 * JD-Core Version:    0.7.0.1
 */