package com.tencent.mobileqq.facetoface;

public class Face2FaceUserProfile
  extends Face2FaceUserData
{
  public String a;
  public int b;
  public int c;
  public String d;
  public long g = 0L;
  
  public Face2FaceUserProfile(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    super(2, paramString1);
    this.a = paramString2;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceUserProfile
 * JD-Core Version:    0.7.0.1
 */