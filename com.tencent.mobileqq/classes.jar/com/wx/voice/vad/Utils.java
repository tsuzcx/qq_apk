package com.wx.voice.vad;

import java.util.ArrayList;

public class Utils
{
  public static int finPosinArraylist(ArrayList<Byte> paramArrayList1, ArrayList<Byte> paramArrayList2)
  {
    int k = 0;
    int i = -1;
    int j = i;
    if (k <= paramArrayList1.size() - paramArrayList2.size())
    {
      j = i;
      if (paramArrayList1.get(k) == paramArrayList2.get(0))
      {
        j = 0;
        label39:
        if (j >= paramArrayList2.size()) {
          break label103;
        }
        if (paramArrayList1.get(k + j) == paramArrayList2.get(j)) {
          break label72;
        }
      }
    }
    label72:
    label103:
    for (j = i;; j = i)
    {
      if (j != -1)
      {
        return j;
        if (j == paramArrayList2.size() - 1) {
          i = k;
        }
        j += 1;
        break label39;
      }
      k += 1;
      i = j;
      break;
    }
  }
  
  public static byte[] toByteArray(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    byte[] arrayOfByte = new byte[j << 1];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i * 2 + 1)] = ((byte)(paramArrayOfShort[i] >> 8));
      arrayOfByte[(i * 2)] = ((byte)(paramArrayOfShort[i] & 0xFF));
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
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2 + 1)] << 8 | paramArrayOfByte[(i * 2)] & 0xFF));
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.wx.voice.vad.Utils
 * JD-Core Version:    0.7.0.1
 */