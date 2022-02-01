package com.tencent.mobileqq.utils.palette;

class ContainerHelpers
{
  static final int[] a = new int[0];
  static final long[] b = new long[0];
  static final Object[] c = new Object[0];
  
  static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt1 -= 1;
    int i = 0;
    while (i <= paramInt1)
    {
      int j = i + paramInt1 >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2) {
        i = j + 1;
      } else if (k > paramInt2) {
        paramInt1 = j - 1;
      } else {
        return j;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.palette.ContainerHelpers
 * JD-Core Version:    0.7.0.1
 */