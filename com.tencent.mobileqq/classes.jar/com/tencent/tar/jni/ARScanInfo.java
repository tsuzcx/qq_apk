package com.tencent.tar.jni;

import android.graphics.Point;
import java.util.ArrayList;

public class ARScanInfo
{
  public boolean a;
  public ARScanInfo.QBMatrix b;
  
  public static ARScanInfo a(boolean paramBoolean, ArrayList<Point> paramArrayList)
  {
    ARScanInfo localARScanInfo = new ARScanInfo();
    localARScanInfo.a = paramBoolean;
    localARScanInfo.b = new ARScanInfo.QBMatrix(paramArrayList);
    return localARScanInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tar.jni.ARScanInfo
 * JD-Core Version:    0.7.0.1
 */