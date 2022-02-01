package com.vivo.push.util;

import android.content.Context;

public final class w
  extends b
{
  private static w b;
  
  public static w b()
  {
    try
    {
      if (b == null) {
        b = new w();
      }
      w localw = b;
      return localw;
    }
    finally {}
  }
  
  private static byte[] c(String paramString)
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = null;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        String[] arrayOfString = paramString.split(",");
        localObject1 = localObject2;
        i = arrayOfString.length;
        int j = 0;
        if (i > 0)
        {
          localObject1 = localObject2;
          paramString = new byte[arrayOfString.length];
          localObject1 = paramString;
          i = arrayOfString.length;
          localObject1 = paramString;
          if (j < i)
          {
            localObject1 = paramString;
            paramString[j] = Byte.parseByte(arrayOfString[j].trim());
            j += 1;
            continue;
          }
          return localObject1;
        }
      }
      catch (Exception paramString)
      {
        localStringBuilder = new StringBuilder("getCodeBytes error:");
        localStringBuilder.append(paramString.getMessage());
        o.a("SharePreferenceManager", localStringBuilder.toString());
      }
      int i = 0;
      paramString = localStringBuilder;
    }
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (this.a == null)
      {
        this.a = paramContext;
        a(paramContext, "com.vivo.push_preferences");
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final byte[] c()
  {
    byte[] arrayOfByte2 = c(b("com.vivo.push.secure_cache_iv", ""));
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length > 0) {}
    }
    else
    {
      arrayOfByte1 = new byte[16];
      byte[] tmp29_28 = arrayOfByte1;
      tmp29_28[0] = 34;
      byte[] tmp34_29 = tmp29_28;
      tmp34_29[1] = 32;
      byte[] tmp39_34 = tmp34_29;
      tmp39_34[2] = 33;
      byte[] tmp44_39 = tmp39_34;
      tmp44_39[3] = 37;
      byte[] tmp49_44 = tmp44_39;
      tmp49_44[4] = 33;
      byte[] tmp54_49 = tmp49_44;
      tmp54_49[5] = 34;
      byte[] tmp59_54 = tmp54_49;
      tmp59_54[6] = 32;
      byte[] tmp65_59 = tmp59_54;
      tmp65_59[7] = 33;
      byte[] tmp71_65 = tmp65_59;
      tmp71_65[8] = 33;
      byte[] tmp77_71 = tmp71_65;
      tmp77_71[9] = 33;
      byte[] tmp83_77 = tmp77_71;
      tmp83_77[10] = 34;
      byte[] tmp89_83 = tmp83_77;
      tmp89_83[11] = 41;
      byte[] tmp95_89 = tmp89_83;
      tmp95_89[12] = 35;
      byte[] tmp101_95 = tmp95_89;
      tmp101_95[13] = 32;
      byte[] tmp107_101 = tmp101_95;
      tmp107_101[14] = 32;
      byte[] tmp113_107 = tmp107_101;
      tmp113_107[15] = 32;
      tmp113_107;
    }
    return arrayOfByte1;
  }
  
  public final byte[] d()
  {
    byte[] arrayOfByte2 = c(b("com.vivo.push.secure_cache_key", ""));
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length > 0) {}
    }
    else
    {
      arrayOfByte1 = new byte[16];
      byte[] tmp29_28 = arrayOfByte1;
      tmp29_28[0] = 33;
      byte[] tmp34_29 = tmp29_28;
      tmp34_29[1] = 34;
      byte[] tmp39_34 = tmp34_29;
      tmp39_34[2] = 35;
      byte[] tmp44_39 = tmp39_34;
      tmp44_39[3] = 36;
      byte[] tmp49_44 = tmp44_39;
      tmp49_44[4] = 37;
      byte[] tmp54_49 = tmp49_44;
      tmp54_49[5] = 38;
      byte[] tmp59_54 = tmp54_49;
      tmp59_54[6] = 39;
      byte[] tmp65_59 = tmp59_54;
      tmp65_59[7] = 40;
      byte[] tmp71_65 = tmp65_59;
      tmp71_65[8] = 41;
      byte[] tmp77_71 = tmp71_65;
      tmp77_71[9] = 32;
      byte[] tmp83_77 = tmp77_71;
      tmp83_77[10] = 38;
      byte[] tmp89_83 = tmp83_77;
      tmp89_83[11] = 37;
      byte[] tmp95_89 = tmp89_83;
      tmp95_89[12] = 36;
      byte[] tmp101_95 = tmp95_89;
      tmp101_95[13] = 35;
      byte[] tmp107_101 = tmp101_95;
      tmp107_101[14] = 34;
      byte[] tmp113_107 = tmp107_101;
      tmp113_107[15] = 33;
      tmp113_107;
    }
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.util.w
 * JD-Core Version:    0.7.0.1
 */