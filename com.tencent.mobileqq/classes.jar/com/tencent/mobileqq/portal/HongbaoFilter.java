package com.tencent.mobileqq.portal;

import android.opengl.GLES20;
import java.util.HashMap;

public class HongbaoFilter
{
  public static int c = 0;
  public static int d = 1;
  public static int e = 2;
  public static int f = 3;
  public int a = 0;
  public int b = 0;
  public HashMap<String, Integer> g = new HashMap();
  private int[] h = new int[1];
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    a(paramFloat1, "percent1");
    a(paramFloat2, "percent2");
    a(paramFloat3, "percent3");
    a(paramFloat4, "percent4");
    a(paramFloat5, "percent5");
    a(paramFloat6, "percent6");
    a(paramFloat7, "percent7");
  }
  
  private void a(float paramFloat, String paramString)
  {
    int i = ((Integer)this.g.get(paramString)).intValue();
    if (i >= 0) {
      GLES20.glUniform1f(i, paramFloat);
    }
  }
  
  private void b(int paramInt)
  {
    float f1 = new float[] { 1.0F, 1.0F, 0.95F, 0.9F }[paramInt];
    if (paramInt == f) {
      f1 = 1.1F;
    } else if (paramInt == e) {
      f1 = 1.0F;
    }
    a(f1, "quality");
    a(0.0F, "add_red");
    a(0.0F, "red_m");
    a(0.0F, "green_m");
    a(0.0F, "blue_m");
  }
  
  public void a(int paramInt)
  {
    float f3;
    float f4;
    float f2;
    if (paramInt == d)
    {
      f3 = 0.455F;
      f4 = 0.17F;
      f2 = 0.177F;
    }
    float f5;
    for (float f1 = 0.2F;; f1 = 0.0F)
    {
      f5 = 0.0F;
      break label89;
      if (paramInt == e)
      {
        f3 = 0.62F;
        f4 = 0.375F;
        f2 = 0.07F;
        f1 = 0.125F;
        f5 = 0.26F;
        break label89;
      }
      if (paramInt == f)
      {
        f3 = 0.824F;
        f4 = 0.461F;
        f2 = 0.152F;
        break;
      }
      f3 = 0.0F;
      f4 = 0.0F;
      f2 = 0.0F;
    }
    label89:
    a(0.0F, f3, f4, f2, 0.0F, f1, f5);
    b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongbaoFilter
 * JD-Core Version:    0.7.0.1
 */