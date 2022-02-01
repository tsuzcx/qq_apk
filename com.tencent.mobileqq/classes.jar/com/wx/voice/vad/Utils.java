package com.wx.voice.vad;

import java.util.ArrayList;

public class Utils
{
  public static int finPosinArraylist(ArrayList<Byte> paramArrayList1, ArrayList<Byte> paramArrayList2)
  {
    int i = 0;
    int k;
    for (int j = -1; i <= paramArrayList1.size() - paramArrayList2.size(); j = k)
    {
      k = j;
      if (paramArrayList1.get(i) == paramArrayList2.get(0))
      {
        k = 0;
        while ((k < paramArrayList2.size()) && (paramArrayList1.get(i + k) == paramArrayList2.get(k)))
        {
          if (k == paramArrayList2.size() - 1) {
            j = i;
          }
          k += 1;
        }
        k = j;
      }
      if (k != -1) {
        return k;
      }
      i += 1;
    }
    return j;
  }
  
  public static byte[] toByteArray(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    byte[] arrayOfByte = new byte[j << 1];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      arrayOfByte[(k + 1)] = ((byte)(paramArrayOfShort[i] >> 8));
      arrayOfByte[k] = ((byte)(paramArrayOfShort[i] & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static short[] toShortArray(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length >> 1;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      int k = i * 2;
      int m = paramArrayOfByte[(k + 1)];
      arrayOfShort[i] = ((short)(paramArrayOfByte[k] & 0xFF | m << 8));
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.wx.voice.vad.Utils
 * JD-Core Version:    0.7.0.1
 */