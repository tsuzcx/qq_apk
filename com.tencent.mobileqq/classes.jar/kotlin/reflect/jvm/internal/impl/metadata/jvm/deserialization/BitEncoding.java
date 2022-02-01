package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.jetbrains.annotations.NotNull;

public class BitEncoding
{
  private static final boolean FORCE_8TO7_ENCODING;
  
  static
  {
    try
    {
      str = System.getProperty("kotlin.jvm.serialization.use8to7");
    }
    catch (SecurityException localSecurityException)
    {
      String str;
      label9:
      break label9;
    }
    str = null;
    FORCE_8TO7_ENCODING = "true".equals(str);
  }
  
  private static void addModuloByte(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      $$$reportNull$$$0(4);
    }
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] + paramInt & 0x7F));
      i += 1;
    }
  }
  
  @NotNull
  private static byte[] combineStringArrayIntoBytes(@NotNull String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      $$$reportNull$$$0(11);
    }
    int k = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfString[i].length();
      i += 1;
    }
    byte[] arrayOfByte = new byte[j];
    int m = paramArrayOfString.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      String str = paramArrayOfString[j];
      int n = str.length();
      k = 0;
      while (k < n)
      {
        arrayOfByte[i] = ((byte)str.charAt(k));
        k += 1;
        i += 1;
      }
      j += 1;
    }
    return arrayOfByte;
  }
  
  @NotNull
  private static byte[] decode7to8(@NotNull byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      $$$reportNull$$$0(13);
    }
    int n = paramArrayOfByte.length * 7 / 8;
    byte[] arrayOfByte = new byte[n];
    int k = 0;
    int j = 0;
    int i = 0;
    while (k < n)
    {
      int i1 = paramArrayOfByte[j];
      j += 1;
      int i2 = paramArrayOfByte[j];
      int m = i + 1;
      arrayOfByte[k] = ((byte)(((i1 & 0xFF) >>> i) + ((i2 & (1 << m) - 1) << 7 - i)));
      if (i == 6)
      {
        j += 1;
        i = 0;
      }
      else
      {
        i = m;
      }
      k += 1;
    }
    return arrayOfByte;
  }
  
  @NotNull
  public static byte[] decodeBytes(@NotNull String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      $$$reportNull$$$0(7);
    }
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length > 0)
    {
      arrayOfString = paramArrayOfString;
      if (!paramArrayOfString[0].isEmpty())
      {
        int i = paramArrayOfString[0].charAt(0);
        if (i == 0)
        {
          paramArrayOfString = UtfEncodingKt.stringsToBytes(dropMarker(paramArrayOfString));
          if (paramArrayOfString == null) {
            $$$reportNull$$$0(8);
          }
          return paramArrayOfString;
        }
        arrayOfString = paramArrayOfString;
        if (i == 65535) {
          arrayOfString = dropMarker(paramArrayOfString);
        }
      }
    }
    paramArrayOfString = combineStringArrayIntoBytes(arrayOfString);
    addModuloByte(paramArrayOfString, 127);
    return decode7to8(paramArrayOfString);
  }
  
  @NotNull
  private static String[] dropMarker(@NotNull String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      $$$reportNull$$$0(9);
    }
    paramArrayOfString = (String[])paramArrayOfString.clone();
    paramArrayOfString[0] = paramArrayOfString[0].substring(1);
    if (paramArrayOfString == null) {
      $$$reportNull$$$0(10);
    }
    return paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.BitEncoding
 * JD-Core Version:    0.7.0.1
 */