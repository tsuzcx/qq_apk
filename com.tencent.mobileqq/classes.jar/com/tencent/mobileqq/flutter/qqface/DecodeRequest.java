package com.tencent.mobileqq.flutter.qqface;

public class DecodeRequest
{
  public String a;
  public int b;
  public int c;
  public String d;
  public String e;
  public String f;
  
  public DecodeRequest(int paramInt1, String paramString, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramString;
    this.c = paramInt2;
    this.d = a(this.b, this.a, this.c);
    this.e = c(this.b, this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    this.f = localStringBuilder.toString();
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
    return new String[] { c(paramInt, paramString) };
  }
  
  private static String c(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flutter_face_path_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecodeRequest{faceType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", faceUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceShape=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.DecodeRequest
 * JD-Core Version:    0.7.0.1
 */