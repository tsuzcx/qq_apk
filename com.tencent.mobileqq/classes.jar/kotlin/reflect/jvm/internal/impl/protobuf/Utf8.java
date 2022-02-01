package kotlin.reflect.jvm.internal.impl.protobuf;

final class Utf8
{
  private static int incompleteStateFor(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65)) {
      return paramInt1 ^ paramInt2 << 8;
    }
    return -1;
  }
  
  private static int incompleteStateFor(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 <= -12) && (paramInt2 <= -65) && (paramInt3 <= -65)) {
      return paramInt1 ^ paramInt2 << 8 ^ paramInt3 << 16;
    }
    return -1;
  }
  
  private static int incompleteStateFor(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[(paramInt1 - 1)];
    paramInt2 -= paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 == 2) {
          return incompleteStateFor(i, paramArrayOfByte[paramInt1], paramArrayOfByte[(paramInt1 + 1)]);
        }
        throw new AssertionError();
      }
      return incompleteStateFor(i, paramArrayOfByte[paramInt1]);
    }
    return incompleteStateFor(i);
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte)
  {
    return isValidUtf8(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static boolean isValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return partialIsValidUtf8(paramArrayOfByte, paramInt1, paramInt2) == 0;
  }
  
  public static int partialIsValidUtf8(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (paramInt1 != 0)
    {
      if (paramInt2 >= paramInt3) {
        return paramInt1;
      }
      int n = (byte)paramInt1;
      if (n < -32)
      {
        if (n >= -62)
        {
          paramInt1 = paramInt2 + 1;
          if (paramArrayOfByte[paramInt2] <= -65) {
            break label293;
          }
        }
        return -1;
      }
      if (n < -16)
      {
        j = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        paramInt1 = j;
        i = paramInt2;
        if (j == 0)
        {
          i = paramInt2 + 1;
          paramInt1 = paramArrayOfByte[paramInt2];
          if (i >= paramInt3) {
            return incompleteStateFor(n, paramInt1);
          }
        }
        if ((paramInt1 <= -65) && ((n != -32) || (paramInt1 >= -96)) && ((n != -19) || (paramInt1 < -96)))
        {
          paramInt1 = i + 1;
          if (paramArrayOfByte[i] <= -65) {
            break label293;
          }
        }
        return -1;
      }
      i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
      int j = 0;
      if (i == 0)
      {
        k = paramInt2 + 1;
        int m = paramArrayOfByte[paramInt2];
        i = m;
        paramInt2 = j;
        paramInt1 = k;
        if (k >= paramInt3) {
          return incompleteStateFor(n, m);
        }
      }
      else
      {
        j = (byte)(paramInt1 >> 16);
        paramInt1 = paramInt2;
        paramInt2 = j;
      }
      int k = paramInt2;
      j = paramInt1;
      if (paramInt2 == 0)
      {
        j = paramInt1 + 1;
        k = paramArrayOfByte[paramInt1];
        if (j >= paramInt3) {
          return incompleteStateFor(n, i, k);
        }
      }
      if ((i <= -65) && ((n << 28) + (i + 112) >> 30 == 0) && (k <= -65))
      {
        i = j + 1;
        if (paramArrayOfByte[j] <= -65) {}
      }
      else
      {
        return -1;
      }
    }
    paramInt1 = i;
    label293:
    return partialIsValidUtf8(paramArrayOfByte, paramInt1, paramInt3);
  }
  
  public static int partialIsValidUtf8(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while ((paramInt1 < paramInt2) && (paramArrayOfByte[paramInt1] >= 0)) {
      paramInt1 += 1;
    }
    if (paramInt1 >= paramInt2) {
      return 0;
    }
    return partialIsValidUtf8NonAscii(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static int partialIsValidUtf8NonAscii(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    label207:
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        return 0;
      }
      int i = paramInt1 + 1;
      int j = paramArrayOfByte[paramInt1];
      paramInt1 = i;
      if (j < 0) {
        if (j < -32)
        {
          if (i >= paramInt2) {
            return j;
          }
          if (j >= -62)
          {
            paramInt1 = i + 1;
            if (paramArrayOfByte[i] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else if (j < -16)
        {
          if (i >= paramInt2 - 1) {
            return incompleteStateFor(paramArrayOfByte, i, paramInt2);
          }
          int k = i + 1;
          paramInt1 = paramArrayOfByte[i];
          if ((paramInt1 <= -65) && ((j != -32) || (paramInt1 >= -96)) && ((j != -19) || (paramInt1 < -96)))
          {
            paramInt1 = k + 1;
            if (paramArrayOfByte[k] <= -65) {}
          }
          else
          {
            return -1;
          }
        }
        else
        {
          if (i >= paramInt2 - 2) {
            return incompleteStateFor(paramArrayOfByte, i, paramInt2);
          }
          paramInt1 = i + 1;
          i = paramArrayOfByte[i];
          if ((i <= -65) && ((j << 28) + (i + 112) >> 30 == 0))
          {
            i = paramInt1 + 1;
            if (paramArrayOfByte[paramInt1] <= -65)
            {
              paramInt1 = i + 1;
              if (paramArrayOfByte[i] <= -65) {
                break label207;
              }
            }
          }
          return -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.Utf8
 * JD-Core Version:    0.7.0.1
 */