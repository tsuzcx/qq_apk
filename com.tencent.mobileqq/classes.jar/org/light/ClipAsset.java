package org.light;

import android.graphics.Matrix;

public class ClipAsset
{
  public static int PHOTO = 1;
  public static int VIDEO = 0;
  public long duration;
  public Matrix matrix = new Matrix();
  public String path;
  
  public int type()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.ClipAsset
 * JD-Core Version:    0.7.0.1
 */