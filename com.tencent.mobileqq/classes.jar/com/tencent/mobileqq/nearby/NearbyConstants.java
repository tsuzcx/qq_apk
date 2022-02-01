package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant.Nearby;

public abstract interface NearbyConstants
{
  public static final String a = QQNearbyManager.d().getName();
  public static final String b = FaceConstant.Nearby.NEAR_BY_FACE_HANDLER;
  public static final int c = QQNearbyManager.e();
  public static final int d = c;
  public static final int e = d + 1;
  public static final int f = e + 1;
  public static final int g = f + 1;
  public static final int h = g + 1;
  public static final int i = h + 1;
  public static final int j = i + 1;
  public static final int k = j + 1;
  public static final int l = k + 1;
  public static final int m = l + 1;
  public static final String n;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".nearby_hearanim");
    n = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyConstants
 * JD-Core Version:    0.7.0.1
 */