package org.apache.commons.lang;

import java.util.Random;

public class RandomStringUtils
{
  private static final Random RANDOM = new Random();
  
  public static String random(int paramInt)
  {
    return random(paramInt, false, false);
  }
  
  public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null, RANDOM);
  }
  
  public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar)
  {
    return random(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramArrayOfChar, RANDOM);
  }
  
  public static String random(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom)
  {
    if (paramInt1 == 0) {
      return "";
    }
    if (paramInt1 >= 0)
    {
      int j = paramInt2;
      int k = paramInt3;
      if (paramInt2 == 0)
      {
        j = paramInt2;
        k = paramInt3;
        if (paramInt3 == 0)
        {
          paramInt2 = 123;
          paramInt3 = 32;
          j = paramInt3;
          k = paramInt2;
          if (!paramBoolean1)
          {
            j = paramInt3;
            k = paramInt2;
            if (!paramBoolean2)
            {
              j = 0;
              k = 2147483647;
            }
          }
        }
      }
      char[] arrayOfChar = new char[paramInt1];
      paramInt3 = k - j;
      label284:
      for (;;)
      {
        paramInt2 = paramInt1 - 1;
        if (paramInt1 == 0) {
          break;
        }
        int i;
        if (paramArrayOfChar == null) {
          i = (char)(paramRandom.nextInt(paramInt3) + j);
        } else {
          i = paramArrayOfChar[(paramRandom.nextInt(paramInt3) + j)];
        }
        if (((paramBoolean1) && (Character.isLetter(i))) || ((paramBoolean2) && (Character.isDigit(i))) || ((!paramBoolean1) && (!paramBoolean2))) {
          if ((i >= 56320) && (i <= 57343))
          {
            if (paramInt2 != 0)
            {
              arrayOfChar[paramInt2] = i;
              paramInt1 = paramInt2 - 1;
              arrayOfChar[paramInt1] = ((char)(paramRandom.nextInt(128) + 55296));
              break label284;
            }
          }
          else if ((i >= 55296) && (i <= 56191))
          {
            if (paramInt2 != 0)
            {
              arrayOfChar[paramInt2] = ((char)(paramRandom.nextInt(128) + 56320));
              paramInt1 = paramInt2 - 1;
              arrayOfChar[paramInt1] = i;
              break label284;
            }
          }
          else if ((i < 56192) || (i > 56319))
          {
            arrayOfChar[paramInt2] = i;
            paramInt1 = paramInt2;
            break label284;
          }
        }
        paramInt1 = paramInt2 + 1;
      }
      return new String(arrayOfChar);
    }
    paramArrayOfChar = new StringBuffer();
    paramArrayOfChar.append("Requested random string length ");
    paramArrayOfChar.append(paramInt1);
    paramArrayOfChar.append(" is less than 0.");
    paramArrayOfChar = new IllegalArgumentException(paramArrayOfChar.toString());
    for (;;)
    {
      throw paramArrayOfChar;
    }
  }
  
  public static String random(int paramInt, String paramString)
  {
    if (paramString == null) {
      return random(paramInt, 0, 0, false, false, null, RANDOM);
    }
    return random(paramInt, paramString.toCharArray());
  }
  
  public static String random(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return random(paramInt, 0, 0, paramBoolean1, paramBoolean2);
  }
  
  public static String random(int paramInt, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null) {
      return random(paramInt, 0, 0, false, false, null, RANDOM);
    }
    return random(paramInt, 0, paramArrayOfChar.length, false, false, paramArrayOfChar, RANDOM);
  }
  
  public static String randomAlphabetic(int paramInt)
  {
    return random(paramInt, true, false);
  }
  
  public static String randomAlphanumeric(int paramInt)
  {
    return random(paramInt, true, true);
  }
  
  public static String randomAscii(int paramInt)
  {
    return random(paramInt, 32, 127, false, false);
  }
  
  public static String randomNumeric(int paramInt)
  {
    return random(paramInt, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.RandomStringUtils
 * JD-Core Version:    0.7.0.1
 */