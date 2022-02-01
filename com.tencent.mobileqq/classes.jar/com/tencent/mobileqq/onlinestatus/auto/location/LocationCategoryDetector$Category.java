package com.tencent.mobileqq.onlinestatus.auto.location;

import androidx.annotation.NonNull;

public class LocationCategoryDetector$Category
{
  private int a;
  private int b;
  private String c;
  private String d;
  
  public LocationCategoryDetector$Category(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.a = paramInt1;
    this.d = paramString1;
    this.c = paramString2;
    this.b = paramInt2;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    int j = this.b;
    if (i >= j) {
      paramArrayOfString = paramArrayOfString[(j - 1)];
    } else {
      paramArrayOfString = null;
    }
    return (paramArrayOfString != null) && (paramArrayOfString.equals(this.c));
  }
  
  public int a()
  {
    return this.a;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Category [statusId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", displayName=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", detectName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", level=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.auto.location.LocationCategoryDetector.Category
 * JD-Core Version:    0.7.0.1
 */