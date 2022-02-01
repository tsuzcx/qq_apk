package com.tencent.mobileqq.facetoface;

public class Face2FaceGroupProfile
  extends Face2FaceUserData
{
  public String a;
  public String b;
  public String c;
  public String d;
  
  public Face2FaceGroupProfile(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(2, paramString1);
    this.a = paramString2;
    this.b = paramString3;
    this.c = paramString4;
    this.d = paramString5;
    if (this.b == null) {
      this.b = "";
    }
    if (this.e == null) {
      this.e = "";
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof Face2FaceGroupProfile))
    {
      paramObject = (Face2FaceGroupProfile)paramObject;
      bool1 = bool2;
      if (this.b.equals(paramObject.b))
      {
        bool1 = bool2;
        if (this.e.equals(paramObject.e)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return this.e + "_" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceGroupProfile
 * JD-Core Version:    0.7.0.1
 */