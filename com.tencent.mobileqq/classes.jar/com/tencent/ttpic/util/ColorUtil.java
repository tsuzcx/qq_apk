package com.tencent.ttpic.util;

import android.graphics.Color;

public class ColorUtil
{
  public static int hex2Int(String paramString)
  {
    return Color.parseColor(paramString);
  }
  
  public static int[] hex2Rgb(String paramString)
  {
    return int2Rgb(hex2Int(paramString));
  }
  
  public static String int2Hex(int paramInt)
  {
    return String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) });
  }
  
  public static int[] int2Rgb(int paramInt)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    int[] tmp13_9 = tmp9_5;
    tmp13_9[2] = 0;
    tmp13_9;
    int i = Color.red(paramInt);
    int j = Color.green(paramInt);
    paramInt = Color.blue(paramInt);
    arrayOfInt[0] = i;
    arrayOfInt[1] = j;
    arrayOfInt[2] = paramInt;
    return arrayOfInt;
  }
  
  public static String rgb2Hex(int[] paramArrayOfInt)
  {
    String str = "#";
    int j = 0;
    if (j < paramArrayOfInt.length)
    {
      int k = paramArrayOfInt[j];
      int i;
      if (k < 0) {
        i = 0;
      }
      for (;;)
      {
        String[] arrayOfString = new String[16];
        arrayOfString[0] = "0";
        arrayOfString[1] = "1";
        arrayOfString[2] = "2";
        arrayOfString[3] = "3";
        arrayOfString[4] = "4";
        arrayOfString[5] = "5";
        arrayOfString[6] = "6";
        arrayOfString[7] = "7";
        arrayOfString[8] = "8";
        arrayOfString[9] = "9";
        arrayOfString[10] = "A";
        arrayOfString[11] = "B";
        arrayOfString[12] = "C";
        arrayOfString[13] = "D";
        arrayOfString[14] = "E";
        arrayOfString[15] = "F";
        k = i / 16;
        str = str + arrayOfString[k] + arrayOfString[(i % 16)];
        j += 1;
        break;
        i = k;
        if (k > 255) {
          i = 255;
        }
      }
    }
    return str;
  }
  
  public static int rgb2Int(int[] paramArrayOfInt)
  {
    return Color.rgb(paramArrayOfInt[0], paramArrayOfInt[1], paramArrayOfInt[2]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.ColorUtil
 * JD-Core Version:    0.7.0.1
 */