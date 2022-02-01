package com.tencent.tar.jni;

import android.graphics.Point;
import java.util.ArrayList;

public final class ARScanInfo$QBMatrix
{
  ArrayList<Point> a = new ArrayList();
  
  public ARScanInfo$QBMatrix(ArrayList<Point> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > this.a.size() - 1) && (paramInt1 < 0)) {
      return 0;
    }
    if (paramInt2 == 0) {
      return ((Point)this.a.get(paramInt1)).x;
    }
    return ((Point)this.a.get(paramInt1)).y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tar.jni.ARScanInfo.QBMatrix
 * JD-Core Version:    0.7.0.1
 */