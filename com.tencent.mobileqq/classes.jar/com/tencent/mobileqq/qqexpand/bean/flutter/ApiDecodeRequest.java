package com.tencent.mobileqq.qqexpand.bean.flutter;

public class ApiDecodeRequest
{
  public String bitmapKey;
  public String faceId;
  public int faceShape;
  public int faceType;
  public String faceUin;
  public String pathKey;
  
  public ApiDecodeRequest(int paramInt1, String paramString, int paramInt2)
  {
    this.faceType = paramInt1;
    this.faceUin = paramString;
    this.faceShape = paramInt2;
    this.bitmapKey = getBitmapKey(this.faceType, this.faceUin, this.faceShape);
    this.pathKey = getPathKey(this.faceType, this.faceUin);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    this.faceId = localStringBuilder.toString();
  }
  
  public static String[] getAllFaceShapePathKeys(int paramInt, String paramString)
  {
    return new String[] { getPathKey(paramInt, paramString) };
  }
  
  private static String getBitmapKey(int paramInt1, String paramString, int paramInt2)
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
  
  private static String getPathKey(int paramInt, String paramString)
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
    localStringBuilder.append(this.faceType);
    localStringBuilder.append(", faceUin='");
    localStringBuilder.append(this.faceUin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", faceShape=");
    localStringBuilder.append(this.faceShape);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.flutter.ApiDecodeRequest
 * JD-Core Version:    0.7.0.1
 */