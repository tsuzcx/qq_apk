package com.tencent.mobileqq.fts.v2.tokenizer.cn;

import com.tencent.mobileqq.fts.v2.tokenizer.Token;
import com.tencent.mobileqq.fts.v2.tokenizer.Tokenizer;
import java.io.Reader;

public final class ChineseTokenizer
  extends Tokenizer
{
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private final char[] e = new char['ÿ'];
  private final char[] f = new char[1024];
  private int g;
  private int h;
  private int i = -1;
  
  public ChineseTokenizer(Reader paramReader)
  {
    this.a = paramReader;
  }
  
  private final void a(char paramChar)
  {
    if (this.g == 0) {
      this.h = (this.b - 1);
    }
    char[] arrayOfChar = this.e;
    int j = this.g;
    this.g = (j + 1);
    arrayOfChar[j] = Character.toLowerCase(paramChar);
  }
  
  private final Token b()
  {
    if (this.g > 0)
    {
      int j = Character.getType(this.e[0]);
      String str1;
      if ((j != 1) && (j != 2))
      {
        if (j != 5)
        {
          if (j != 9) {
            str1 = "other";
          } else {
            str1 = "num";
          }
        }
        else {
          str1 = "cn";
        }
      }
      else {
        str1 = "en";
      }
      String str2 = new String(this.e, 0, this.g);
      j = this.h;
      return new Token(str2, j, this.g + j, str1);
    }
    return null;
  }
  
  public final Token a()
  {
    this.g = 0;
    this.h = this.b;
    label210:
    do
    {
      char c1;
      do
      {
        do
        {
          this.b += 1;
          if (this.c >= this.d)
          {
            this.d = this.a.read(this.f);
            this.c = 0;
          }
          if (this.d == -1)
          {
            this.i = -1;
            return b();
          }
          char[] arrayOfChar = this.f;
          j = this.c;
          this.c = (j + 1);
          c1 = arrayOfChar[j];
          j = Character.getType(c1);
          if ((j == 1) || (j == 2)) {
            break label280;
          }
          if (j == 5) {
            break label210;
          }
          if (j == 9) {
            break;
          }
        } while (this.g <= 0);
        return b();
        j = this.i;
        if (j == -1)
        {
          this.i = 0;
        }
        else if (j != 0)
        {
          this.i = 0;
          if (this.g > 0)
          {
            this.c -= 1;
            this.b -= 1;
            return b();
          }
        }
        a(c1);
      } while (this.g != 255);
      return b();
      int j = this.i;
      if (j == -1)
      {
        this.i = 2;
      }
      else if (j != 2)
      {
        this.i = 2;
        if (this.g > 0)
        {
          this.c -= 1;
          this.b -= 1;
          return b();
        }
      }
      a(c1);
      return b();
      j = this.i;
      if (j == -1)
      {
        this.i = 1;
      }
      else if (j != 1)
      {
        this.i = 1;
        if (this.g > 0)
        {
          this.c -= 1;
          this.b -= 1;
          return b();
        }
      }
      a(c1);
    } while (this.g != 255);
    label280:
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.tokenizer.cn.ChineseTokenizer
 * JD-Core Version:    0.7.0.1
 */