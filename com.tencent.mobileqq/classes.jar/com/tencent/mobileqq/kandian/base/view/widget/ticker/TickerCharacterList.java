package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TickerCharacterList
{
  private final int a;
  private final char[] b;
  private String c;
  private final Map<Character, Integer> d;
  
  TickerCharacterList(String paramString)
  {
    int j = 0;
    if (!paramString.contains(Character.toString('\000')))
    {
      this.c = paramString;
      paramString = paramString.toCharArray();
      int k = paramString.length;
      this.a = k;
      this.d = new HashMap(k);
      int i = 0;
      while (i < k)
      {
        this.d.put(Character.valueOf(paramString[i]), Integer.valueOf(i));
        i += 1;
      }
      this.b = new char[k * 2 + 1];
      this.b[0] = '\000';
      for (i = j; i < k; i = j)
      {
        char[] arrayOfChar = this.b;
        j = i + 1;
        arrayOfChar[j] = paramString[i];
        arrayOfChar[(k + 1 + i)] = paramString[i];
      }
      return;
    }
    paramString = new IllegalArgumentException("You cannot include TickerUtils.EMPTY_CHAR in the character list.");
    for (;;)
    {
      throw paramString;
    }
  }
  
  private int a(char paramChar)
  {
    if (paramChar == 0) {
      return 0;
    }
    if (this.d.containsKey(Character.valueOf(paramChar))) {
      return ((Integer)this.d.get(Character.valueOf(paramChar))).intValue() + 1;
    }
    return -1;
  }
  
  TickerCharacterList.CharacterIndices a(char paramChar1, char paramChar2, int paramInt)
  {
    int j = a(paramChar1);
    int k = a(paramChar2);
    if ((j >= 0) && (k >= 0))
    {
      int i;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            i = j;
            paramInt = k;
          }
          else if (paramChar2 == 0)
          {
            paramInt = this.b.length;
            i = j;
          }
          else
          {
            i = j;
            paramInt = k;
            if (k < j)
            {
              paramInt = k + this.a;
              i = j;
            }
          }
        }
        else
        {
          i = j;
          paramInt = k;
          if (j < k)
          {
            i = j + this.a;
            paramInt = k;
          }
        }
      }
      else
      {
        i = j;
        paramInt = k;
        if (paramChar1 != 0)
        {
          i = j;
          paramInt = k;
          if (paramChar2 != 0)
          {
            int m;
            if (k < j)
            {
              m = this.a;
              i = j;
              paramInt = k;
              if (m - j + k < j - k)
              {
                paramInt = k + m;
                i = j;
              }
            }
            else
            {
              i = j;
              paramInt = k;
              if (j < k)
              {
                m = this.a;
                i = j;
                paramInt = k;
                if (m - k + j < k - j)
                {
                  i = j + m;
                  paramInt = k;
                }
              }
            }
          }
        }
      }
      return new TickerCharacterList.CharacterIndices(this, i, paramInt);
    }
    return null;
  }
  
  Set<Character> a()
  {
    return this.d.keySet();
  }
  
  char[] b()
  {
    return this.b;
  }
  
  String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerCharacterList
 * JD-Core Version:    0.7.0.1
 */