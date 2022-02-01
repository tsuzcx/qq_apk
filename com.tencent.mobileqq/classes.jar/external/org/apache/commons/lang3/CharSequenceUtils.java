package external.org.apache.commons.lang3;

public class CharSequenceUtils
{
  static int indexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof String))
    {
      i = ((String)paramCharSequence).indexOf(paramInt1, paramInt2);
      return i;
    }
    int j = paramCharSequence.length();
    int i = paramInt2;
    if (paramInt2 < 0) {
      i = 0;
    }
    paramInt2 = i;
    for (;;)
    {
      if (paramInt2 >= j) {
        break label63;
      }
      i = paramInt2;
      if (paramCharSequence.charAt(paramInt2) == paramInt1) {
        break;
      }
      paramInt2 += 1;
    }
    label63:
    return -1;
  }
  
  static int indexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().indexOf(paramCharSequence2.toString(), paramInt);
  }
  
  static int lastIndexOf(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int j = -1;
    if ((paramCharSequence instanceof String)) {
      i = ((String)paramCharSequence).lastIndexOf(paramInt1, paramInt2);
    }
    int k;
    do
    {
      return i;
      k = paramCharSequence.length();
      i = j;
    } while (paramInt2 < 0);
    int i = paramInt2;
    if (paramInt2 >= k) {
      i = k - 1;
    }
    paramInt2 = i;
    for (;;)
    {
      i = j;
      if (paramInt2 < 0) {
        break;
      }
      if (paramCharSequence.charAt(paramInt2) == paramInt1) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
  }
  
  static int lastIndexOf(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().lastIndexOf(paramCharSequence2.toString(), paramInt);
  }
  
  static boolean regionMatches(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
      return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
    }
    return paramCharSequence1.toString().regionMatches(paramBoolean, paramInt1, paramCharSequence2.toString(), paramInt2, paramInt3);
  }
  
  public static CharSequence subSequence(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence == null) {
      return null;
    }
    return paramCharSequence.subSequence(paramInt, paramCharSequence.length());
  }
  
  static char[] toCharArray(CharSequence paramCharSequence)
  {
    Object localObject;
    if ((paramCharSequence instanceof String))
    {
      localObject = ((String)paramCharSequence).toCharArray();
      return localObject;
    }
    int j = paramCharSequence.length();
    char[] arrayOfChar = new char[paramCharSequence.length()];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfChar;
      if (i >= j) {
        break;
      }
      arrayOfChar[i] = paramCharSequence.charAt(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.CharSequenceUtils
 * JD-Core Version:    0.7.0.1
 */