package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

class FlutterTextUtils
{
  public static final int CANCEL_TAG = 917631;
  public static final int CARRIAGE_RETURN = 13;
  public static final int COMBINING_ENCLOSING_KEYCAP = 8419;
  public static final int LINE_FEED = 10;
  public static final int ZERO_WIDTH_JOINER = 8205;
  private final FlutterJNI flutterJNI;
  
  public FlutterTextUtils(FlutterJNI paramFlutterJNI)
  {
    this.flutterJNI = paramFlutterJNI;
  }
  
  public int getOffsetAfter(CharSequence paramCharSequence, int paramInt)
  {
    int i4 = paramCharSequence.length();
    int n = i4 - 1;
    if (paramInt >= n) {
      return i4;
    }
    int k = Character.codePointAt(paramCharSequence, paramInt);
    int j = Character.charCount(k);
    int m = paramInt + j;
    int i = 0;
    if (m == 0) {
      return 0;
    }
    if (k == 10)
    {
      i = j;
      if (Character.codePointAt(paramCharSequence, m) == 13) {
        i = j + 1;
      }
      return paramInt + i;
    }
    if (isRegionalIndicatorSymbol(k))
    {
      if (m < n)
      {
        if (!isRegionalIndicatorSymbol(Character.codePointAt(paramCharSequence, m))) {
          return m;
        }
        k = paramInt;
        while ((k > 0) && (isRegionalIndicatorSymbol(Character.codePointBefore(paramCharSequence, paramInt))))
        {
          k -= Character.charCount(Character.codePointBefore(paramCharSequence, paramInt));
          i += 1;
        }
        k = j;
        if (i % 2 == 0) {
          k = j + 2;
        }
        return paramInt + k;
      }
      return m;
    }
    i = j;
    if (isKeycapBase(k)) {
      i = j + Character.charCount(k);
    }
    if (k == 8419)
    {
      k = Character.codePointBefore(paramCharSequence, m);
      j = m + Character.charCount(k);
      if ((j < i4) && (isVariationSelector(k)))
      {
        m = Character.codePointAt(paramCharSequence, j);
        j = i;
        if (isKeycapBase(m)) {
          j = i + (Character.charCount(k) + Character.charCount(m));
        }
      }
      else
      {
        j = i;
        if (isKeycapBase(k)) {
          j = i + Character.charCount(k);
        }
      }
      return paramInt + j;
    }
    j = i;
    if (isEmoji(k))
    {
      int i2 = 0;
      j = k;
      n = 0;
      int i3 = i;
      label651:
      do
      {
        int i1 = n;
        i = i3;
        if (n != 0)
        {
          i = i3 + (Character.charCount(j) + i2 + 1);
          i1 = 0;
        }
        if (isEmojiModifier(j))
        {
          j = i;
          break;
        }
        n = i1;
        k = m;
        if (m < i4)
        {
          i2 = Character.codePointAt(paramCharSequence, m);
          m += Character.charCount(i2);
          if (i2 == 8419)
          {
            k = Character.codePointBefore(paramCharSequence, m);
            j = m + Character.charCount(k);
            if ((j < i4) && (isVariationSelector(k)))
            {
              m = Character.codePointAt(paramCharSequence, j);
              j = i;
              if (isKeycapBase(m)) {
                j = i + (Character.charCount(k) + Character.charCount(m));
              }
            }
            else
            {
              j = i;
              if (isKeycapBase(k)) {
                j = i + Character.charCount(k);
              }
            }
            return paramInt + j;
          }
          if (isEmojiModifier(i2)) {}
          while (isVariationSelector(i2))
          {
            j = i + (Character.charCount(i2) + 0);
            break;
          }
          n = i1;
          j = i2;
          k = m;
          if (i2 == 8205)
          {
            j = Character.codePointAt(paramCharSequence, m);
            k = m + Character.charCount(j);
            if ((k < i4) && (isVariationSelector(j)))
            {
              j = Character.codePointAt(paramCharSequence, k);
              i1 = Character.charCount(j);
              m = k + Character.charCount(j);
              k = j;
              n = 1;
              break label651;
            }
            n = 1;
          }
        }
        i1 = 0;
        m = k;
        k = j;
        if (m >= i4)
        {
          j = i;
          break;
        }
        j = i;
        if (n == 0) {
          break;
        }
        i3 = i;
        j = k;
        i2 = i1;
      } while (isEmoji(k));
      j = i;
    }
    return paramInt + j;
  }
  
  public int getOffsetBefore(CharSequence paramCharSequence, int paramInt)
  {
    int j = 1;
    int i4 = 0;
    if (paramInt <= 1) {
      return 0;
    }
    int i1 = Character.codePointBefore(paramCharSequence, paramInt);
    int i = Character.charCount(i1);
    int n = paramInt - i;
    if (n == 0) {
      return 0;
    }
    if (i1 == 10)
    {
      j = i;
      if (Character.codePointBefore(paramCharSequence, n) == 13) {
        j = i + 1;
      }
      return paramInt - j;
    }
    if (isRegionalIndicatorSymbol(i1))
    {
      m = Character.codePointBefore(paramCharSequence, n);
      k = n - Character.charCount(m);
      while ((k > 0) && (isRegionalIndicatorSymbol(m)))
      {
        m = Character.codePointBefore(paramCharSequence, k);
        k -= Character.charCount(m);
        j += 1;
      }
      k = i;
      if (j % 2 == 0) {
        k = i + 2;
      }
      return paramInt - k;
    }
    if (i1 == 8419)
    {
      k = Character.codePointBefore(paramCharSequence, n);
      j = n - Character.charCount(k);
      if ((j > 0) && (isVariationSelector(k)))
      {
        m = Character.codePointBefore(paramCharSequence, j);
        j = i;
        if (isKeycapBase(m)) {
          j = i + (Character.charCount(k) + Character.charCount(m));
        }
      }
      else
      {
        j = i;
        if (isKeycapBase(k)) {
          j = i + Character.charCount(k);
        }
      }
      return paramInt - j;
    }
    int m = i1;
    int k = i;
    j = n;
    if (i1 == 917631)
    {
      j = n;
      for (;;)
      {
        m = Character.codePointBefore(paramCharSequence, j);
        j -= Character.charCount(m);
        if ((j <= 0) || (!isTagSpecChar(m))) {
          break;
        }
        i += Character.charCount(m);
      }
      if (!isEmoji(m)) {
        return paramInt - 2;
      }
      k = i + Character.charCount(m);
    }
    n = m;
    i = k;
    i1 = j;
    if (isVariationSelector(m))
    {
      n = Character.codePointBefore(paramCharSequence, j);
      if (!isEmoji(n)) {
        return paramInt - k;
      }
      i = k + Character.charCount(n);
      i1 = j - i;
    }
    j = i;
    if (isEmoji(n))
    {
      m = i1;
      int i2 = 0;
      j = n;
      n = 0;
      int i3 = i;
      label702:
      do
      {
        i1 = n;
        k = i3;
        if (n != 0)
        {
          k = i3 + (Character.charCount(j) + i2 + 1);
          i1 = 0;
        }
        if (isEmojiModifier(j))
        {
          j = Character.codePointBefore(paramCharSequence, m);
          n = m - Character.charCount(j);
          m = j;
          i = i4;
          if (n > 0)
          {
            m = j;
            i = i4;
            if (isVariationSelector(j))
            {
              m = Character.codePointBefore(paramCharSequence, n);
              if (!isEmoji(m)) {
                return paramInt - k;
              }
              i = Character.charCount(m);
              Character.charCount(m);
            }
          }
          j = k;
          if (!isEmojiModifierBase(m)) {
            break;
          }
          j = k + (i + Character.charCount(m));
          break;
        }
        n = i1;
        i = j;
        j = m;
        if (m > 0)
        {
          i2 = Character.codePointBefore(paramCharSequence, m);
          m -= Character.charCount(i2);
          n = i1;
          i = i2;
          j = m;
          if (i2 == 8205)
          {
            i = Character.codePointBefore(paramCharSequence, m);
            j = m - Character.charCount(i);
            if ((j > 0) && (isVariationSelector(i)))
            {
              i = Character.codePointBefore(paramCharSequence, j);
              i1 = Character.charCount(i);
              m = j - Character.charCount(i);
              n = 1;
              break label702;
            }
            n = 1;
          }
        }
        i1 = 0;
        m = j;
        if (m == 0)
        {
          j = k;
          break;
        }
        j = k;
        if (n == 0) {
          break;
        }
        i3 = k;
        j = i;
        i2 = i1;
      } while (isEmoji(i));
      j = k;
    }
    return paramInt - j;
  }
  
  public boolean isEmoji(int paramInt)
  {
    return this.flutterJNI.nativeFlutterTextUtilsIsEmoji(paramInt);
  }
  
  public boolean isEmojiModifier(int paramInt)
  {
    return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifier(paramInt);
  }
  
  public boolean isEmojiModifierBase(int paramInt)
  {
    return this.flutterJNI.nativeFlutterTextUtilsIsEmojiModifierBase(paramInt);
  }
  
  public boolean isKeycapBase(int paramInt)
  {
    return ((48 <= paramInt) && (paramInt <= 57)) || (paramInt == 35) || (paramInt == 42);
  }
  
  public boolean isRegionalIndicatorSymbol(int paramInt)
  {
    return this.flutterJNI.nativeFlutterTextUtilsIsRegionalIndicator(paramInt);
  }
  
  public boolean isTagSpecChar(int paramInt)
  {
    return (917536 <= paramInt) && (paramInt <= 917630);
  }
  
  public boolean isVariationSelector(int paramInt)
  {
    return this.flutterJNI.nativeFlutterTextUtilsIsVariationSelector(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.editing.FlutterTextUtils
 * JD-Core Version:    0.7.0.1
 */