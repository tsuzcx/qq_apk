package com.tencent.mobileqq.facetoface;

public abstract class Face2FaceUserData
{
  public int e = 1;
  public String f;
  
  public Face2FaceUserData(int paramInt, String paramString)
  {
    this.e = paramInt;
    this.f = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool4 = paramObject instanceof Face2FaceUserData;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (bool4)
    {
      paramObject = (Face2FaceUserData)paramObject;
      String str = this.f;
      if (str == null)
      {
        bool1 = bool2;
        if (this.e == paramObject.e)
        {
          bool1 = bool2;
          if (paramObject.f == null) {
            bool1 = true;
          }
        }
        return bool1;
      }
      bool1 = bool3;
      if (this.e == paramObject.e)
      {
        bool1 = bool3;
        if (str.equals(paramObject.f)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceUserData
 * JD-Core Version:    0.7.0.1
 */