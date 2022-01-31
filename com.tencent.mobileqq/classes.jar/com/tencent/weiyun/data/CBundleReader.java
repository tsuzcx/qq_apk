package com.tencent.weiyun.data;

import com.tencent.weiyun.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CBundleReader
{
  public static native void deleteBundle(long paramLong);
  
  public static native boolean getBoolean(long paramLong, String paramString, boolean paramBoolean);
  
  private static native byte getByte(long paramLong, String paramString, byte paramByte);
  
  private static native byte[] getByteArray(long paramLong, String paramString);
  
  private static native String getCharArray(long paramLong, String paramString);
  
  public static native double getDouble(long paramLong, String paramString, double paramDouble);
  
  public static String getHexString(long paramLong, String paramString)
  {
    paramString = getByteArray(paramLong, paramString);
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = Arrays.copyOf(paramString, paramString.length)) {
      return Utils.bytes2HexStr(paramString);
    }
  }
  
  public static native int getInt(long paramLong, String paramString, int paramInt);
  
  public static native long getLong(long paramLong1, String paramString, long paramLong2);
  
  public static native long[] getLongArray(long paramLong, String paramString);
  
  public static String getString(long paramLong, String paramString)
  {
    paramString = getByteArray(paramLong, paramString);
    if (paramString == null) {}
    for (paramString = new byte[0];; paramString = Arrays.copyOf(paramString, paramString.length)) {
      return new String(paramString);
    }
  }
  
  private static native Object[] getStringArray(long paramLong, String paramString);
  
  private static List<String> getStringList(long paramLong, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = getStringArray(paramLong, paramString);
    if (paramString != null)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        byte[] arrayOfByte = paramString[i];
        if ((arrayOfByte instanceof byte[]))
        {
          arrayOfByte = (byte[])arrayOfByte;
          localArrayList.add(new String(Arrays.copyOf(arrayOfByte, arrayOfByte.length)));
        }
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.data.CBundleReader
 * JD-Core Version:    0.7.0.1
 */