package com.tencent.qmsp.sdk.f;

public class e
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      Object localObject = new char[paramArrayOfByte.length * 2];
      int i = 0;
      try
      {
        while (i < paramArrayOfByte.length)
        {
          int k = paramArrayOfByte[i];
          int j = i * 2;
          localObject[(j + 1)] = a[(k & 0xF)];
          k = (byte)(k >>> 4);
          localObject[(j + 0)] = a[(k & 0xF)];
          i += 1;
        }
        return new String((char[])localObject);
      }
      catch (Exception paramArrayOfByte)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" === bytes2HexStr error === ");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        g.a("Qp.b2h", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.e
 * JD-Core Version:    0.7.0.1
 */