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
    int n = 0;
    int i = 0;
    int i3 = paramCharSequence.length();
    int i1 = i3 - 1;
    if (paramInt >= i1) {
      i = i3;
    }
    int k;
    int j;
    int m;
    do
    {
      return i;
      k = Character.codePointAt(paramCharSequence, paramInt);
      j = Character.charCount(k);
      m = paramInt + j;
    } while (m == 0);
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
      if ((m >= i1) || (!isRegionalIndicatorSymbol(Character.codePointAt(paramCharSequence, m)))) {
        return m;
      }
      k = paramInt;
      i = n;
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
    i = j;
    if (isKeycapBase(k)) {
      i = j + Character.charCount(k);
    }
    if (k == 8419)
    {
      k = Character.codePointBefore(paramCharSequence, m);
      j = m + Character.charCount(k);
      if ((j < i3) && (isVariationSelector(k)))
      {
        m = Character.codePointAt(paramCharSequence, j);
        j = i;
        if (isKeycapBase(m)) {
          j = i + (Character.charCount(k) + Character.charCount(m));
        }
      }
      for (;;)
      {
        return paramInt + j;
        j = i;
        if (isKeycapBase(k)) {
          j = i + Character.charCount(k);
        }
      }
    }
    int i2;
    if (isEmoji(k))
    {
      i2 = 0;
      j = m;
      n = 0;
      i1 = i;
      m = n;
      i = i1;
      if (n != 0)
      {
        i = Character.charCount(k) + i2 + 1 + i1;
        m = 0;
      }
      if (isEmojiModifier(k)) {
        j = i;
      }
    }
    for (;;)
    {
      return paramInt + j;
      n = j;
      if (j < i3)
      {
        i1 = Character.codePointAt(paramCharSequence, j);
        j += Character.charCount(i1);
        if (i1 == 8419)
        {
          k = Character.codePointBefore(paramCharSequence, j);
          j = Character.charCount(k) + j;
          if ((j < i3) && (isVariationSelector(k)))
          {
            m = Character.codePointAt(paramCharSequence, j);
            j = i;
            if (isKeycapBase(m)) {
              j = i + (Character.charCount(k) + Character.charCount(m));
            }
          }
          for (;;)
          {
            return paramInt + j;
            j = i;
            if (isKeycapBase(k)) {
              j = i + Character.charCount(k);
            }
          }
        }
        if (isEmojiModifier(i1))
        {
          j = i + (Character.charCount(i1) + 0);
          continue;
        }
        if (isVariationSelector(i1))
        {
          j = i + (Character.charCount(i1) + 0);
          continue;
        }
        k = i1;
        n = j;
        if (i1 == 8205)
        {
          n = Character.codePointAt(paramCharSequence, j);
          m = Character.charCount(n) + j;
          if ((m < i3) && (isVariationSelector(n)))
          {
            k = Character.codePointAt(paramCharSequence, m);
            n = Character.charCount(k);
            m += Character.charCount(k);
            i1 = 1;
            j = i;
            if (m >= i3) {
              continue;
            }
            j = i;
            if (i1 == 0) {
              continue;
            }
            j = i;
            if (!isEmoji(k)) {
              continue;
            }
            i2 = n;
            j = m;
            n = i1;
            i1 = i;
            break;
          }
          k = 1;
          j = n;
        }
      }
      for (;;)
      {
        i1 = k;
        n = 0;
        k = j;
        break;
        i1 = m;
        j = k;
        m = n;
        k = i1;
      }
      j = i;
    }
  }
  
  public int getOffsetBefore(CharSequence paramCharSequence, int paramInt)
  {
    int j = 1;
    int i3 = 0;
    if (paramInt <= 1) {}
    int i1;
    int i;
    int k;
    do
    {
      return 0;
      i1 = Character.codePointBefore(paramCharSequence, paramInt);
      i = Character.charCount(i1);
      k = paramInt - i;
    } while (k == 0);
    if (i1 == 10)
    {
      j = i;
      if (Character.codePointBefore(paramCharSequence, k) == 13) {
        j = i + 1;
      }
      return paramInt - j;
    }
    int m;
    if (isRegionalIndicatorSymbol(i1))
    {
      m = Character.codePointBefore(paramCharSequence, k);
      k -= Character.charCount(m);
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
      m = Character.codePointBefore(paramCharSequence, k);
      j = k - Character.charCount(m);
      if ((j > 0) && (isVariationSelector(m)))
      {
        k = Character.codePointBefore(paramCharSequence, j);
        j = i;
        if (isKeycapBase(k)) {
          j = i + (Character.charCount(m) + Character.charCount(k));
        }
      }
      for (;;)
      {
        return paramInt - j;
        j = i;
        if (isKeycapBase(m)) {
          j = i + Character.charCount(m);
        }
      }
    }
    if (i1 == 917631)
    {
      j = Character.codePointBefore(paramCharSequence, k);
      m = k - Character.charCount(j);
      k = j;
      j = m;
      m = i;
      i = k;
      while ((j > 0) && (isTagSpecChar(i)))
      {
        m += Character.charCount(i);
        i = Character.codePointBefore(paramCharSequence, j);
        j -= Character.charCount(i);
      }
      if (!isEmoji(i)) {
        return paramInt - 2;
      }
      m += Character.charCount(i);
      i1 = i;
    }
    for (;;)
    {
      int n = i1;
      i = m;
      k = j;
      if (isVariationSelector(i1))
      {
        n = Character.codePointBefore(paramCharSequence, j);
        if (!isEmoji(n)) {
          return paramInt - m;
        }
        i = m + Character.charCount(n);
        k = j - i;
      }
      m = i;
      int i2;
      if (isEmoji(n))
      {
        i2 = 0;
        j = k;
        k = n;
        n = 0;
      }
      for (i1 = i;; i1 = i)
      {
        m = n;
        i = i1;
        if (n != 0)
        {
          i = Character.charCount(k) + i2 + 1 + i1;
          m = 0;
        }
        if (isEmojiModifier(k))
        {
          m = Character.codePointBefore(paramCharSequence, j);
          n = j - Character.charCount(m);
          k = m;
          j = i3;
          if (n > 0)
          {
            k = m;
            j = i3;
            if (isVariationSelector(m))
            {
              k = Character.codePointBefore(paramCharSequence, n);
              if (!isEmoji(k)) {
                return paramInt - i;
              }
              j = Character.charCount(k);
              Character.charCount(k);
            }
          }
          m = i;
          if (isEmojiModifierBase(k)) {
            m = i + (Character.charCount(k) + j);
          }
        }
        do
        {
          do
          {
            do
            {
              return paramInt - m;
              n = k;
              k = j;
              if (j <= 0) {
                break label764;
              }
              i1 = Character.codePointBefore(paramCharSequence, j);
              j -= Character.charCount(i1);
              n = i1;
              k = j;
              if (i1 != 8205) {
                break label764;
              }
              m = Character.codePointBefore(paramCharSequence, j);
              j -= Character.charCount(m);
              if ((j <= 0) || (!isVariationSelector(m))) {
                break;
              }
              k = Character.codePointBefore(paramCharSequence, j);
              n = Character.charCount(k);
              j -= Character.charCount(k);
              i1 = 1;
              m = i;
            } while (j == 0);
            m = i;
          } while (i1 == 0);
          m = i;
        } while (!isEmoji(k));
        i2 = n;
        n = i1;
      }
      n = 1;
      for (;;)
      {
        i1 = n;
        k = m;
        n = 0;
        break;
        label764:
        j = m;
        m = n;
        n = j;
        j = k;
      }
      m = i;
      j = k;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugin.editing.FlutterTextUtils
 * JD-Core Version:    0.7.0.1
 */