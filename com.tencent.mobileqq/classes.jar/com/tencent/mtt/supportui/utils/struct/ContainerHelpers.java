package com.tencent.mtt.supportui.utils.struct;

class ContainerHelpers
{
  static final int[] a = new int[0];
  static final long[] b = new long[0];
  static final Object[] c = new Object[0];
  
  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = paramInt1 - 1;
    paramInt1 = i;
    i = j;
    while (paramInt1 <= i)
    {
      j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2) {
        paramInt1 = j + 1;
      } else if (k > paramInt2) {
        i = j - 1;
      } else {
        return j;
      }
    }
    return paramInt1 ^ 0xFFFFFFFF;
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  public static int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.supportui.utils.struct.ContainerHelpers
 * JD-Core Version:    0.7.0.1
 */