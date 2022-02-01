package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UtfEncodingKt
{
  @NotNull
  public static final byte[] stringsToBytes(@NotNull String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    int k = paramArrayOfString.length;
    int n = 0;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfString[i].length();
      i += 1;
    }
    byte[] arrayOfByte = new byte[j];
    int i1 = paramArrayOfString.length;
    j = 0;
    for (i = 0; j < i1; i = k)
    {
      String str = paramArrayOfString[j];
      int i2 = str.length() - 1;
      k = i;
      if (i2 >= 0)
      {
        k = 0;
        int m;
        for (;;)
        {
          m = i + 1;
          arrayOfByte[i] = ((byte)str.charAt(k));
          if (k == i2) {
            break;
          }
          k += 1;
          i = m;
        }
        k = m;
      }
      j += 1;
    }
    j = n;
    if (i == arrayOfByte.length) {
      j = 1;
    }
    if (_Assertions.ENABLED)
    {
      if (j != 0) {
        return arrayOfByte;
      }
      throw ((Throwable)new AssertionError("Should have reached the end"));
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.UtfEncodingKt
 * JD-Core Version:    0.7.0.1
 */