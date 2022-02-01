package com.tencent.mobileqq.guild.util;

class QQGuildTextUtils$AsciiHalfCharacterCounter
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private boolean e = false;
  
  private boolean b(char paramChar)
  {
    if (c(paramChar))
    {
      this.e = true;
      return false;
    }
    if (paramChar < '')
    {
      this.c += 1;
      return true;
    }
    this.d += 1;
    return true;
  }
  
  private boolean c()
  {
    return this.e;
  }
  
  private boolean c(char paramChar)
  {
    return paramChar >= '';
  }
  
  float a()
  {
    return this.a + this.b + this.d + this.c * 0.5F;
  }
  
  int a(QQGuildTextUtils.SpanPair paramSpanPair, float paramFloat)
  {
    if (paramFloat < 1.0F)
    {
      this.e = true;
      return 0;
    }
    a(paramSpanPair);
    return paramSpanPair.b - paramSpanPair.a;
  }
  
  int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat)
  {
    float f2 = a();
    float f1 = paramFloat;
    int i = paramInt1;
    while ((i < paramInt2) && (f1 > 0.0F))
    {
      if (f1 >= 1.0F)
      {
        a(paramCharSequence.charAt(i));
        i += 1;
      }
      else
      {
        if (!b(paramCharSequence.charAt(i)))
        {
          this.e = true;
          break;
        }
        i += 1;
      }
      f1 = f2 + paramFloat - a();
    }
    if (f1 <= 0.0F) {
      this.e = true;
    }
    return i - paramInt1;
  }
  
  void a(char paramChar)
  {
    if (paramChar < '')
    {
      this.c += 1;
      return;
    }
    this.d += 1;
  }
  
  void a(QQGuildTextUtils.SpanPair paramSpanPair)
  {
    if (paramSpanPair.c == 0)
    {
      this.a += 1;
      return;
    }
    this.b += 1;
  }
  
  void a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      a(paramCharSequence.charAt(paramInt1));
      paramInt1 += 1;
    }
  }
  
  QQGuildTextUtils.CharacterCountInfo b()
  {
    return new QQGuildTextUtils.CharacterCountInfo(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildTextUtils.AsciiHalfCharacterCounter
 * JD-Core Version:    0.7.0.1
 */