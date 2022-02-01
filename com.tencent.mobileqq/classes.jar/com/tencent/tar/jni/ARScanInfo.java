package com.tencent.tar.jni;

import android.graphics.Point;
import java.util.ArrayList;

public class ARScanInfo
{
  public ARScanInfo.QBMatrix a;
  public boolean a;
  
  public static ARScanInfo a(boolean paramBoolean, ArrayList<Point> paramArrayList)
  {
    ARScanInfo localARScanInfo = new ARScanInfo();
    localARScanInfo.jdField_a_of_type_Boolean = paramBoolean;
    localARScanInfo.jdField_a_of_type_ComTencentTarJniARScanInfo$QBMatrix = new ARScanInfo.QBMatrix(paramArrayList);
    return localARScanInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tar.jni.ARScanInfo
 * JD-Core Version:    0.7.0.1
 */