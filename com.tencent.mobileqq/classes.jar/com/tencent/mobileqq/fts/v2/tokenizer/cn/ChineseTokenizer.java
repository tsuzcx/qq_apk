package com.tencent.mobileqq.fts.v2.tokenizer.cn;

import com.tencent.mobileqq.fts.v2.tokenizer.Token;
import com.tencent.mobileqq.fts.v2.tokenizer.Tokenizer;
import java.io.Reader;

public final class ChineseTokenizer
  extends Tokenizer
{
  private int jdField_a_of_type_Int = 0;
  private final char[] jdField_a_of_type_ArrayOfChar = new char['ÿ'];
  private int jdField_b_of_type_Int = 0;
  private final char[] jdField_b_of_type_ArrayOfChar = new char[1024];
  private int c = 0;
  private int d;
  private int e;
  private int f = -1;
  
  public ChineseTokenizer(Reader paramReader)
  {
    this.jdField_a_of_type_JavaIoReader = paramReader;
  }
  
  private final void a(char paramChar)
  {
    if (this.d == 0) {
      this.e = (this.jdField_a_of_type_Int - 1);
    }
    char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
    int i = this.d;
    this.d = (i + 1);
    arrayOfChar[i] = Character.toLowerCase(paramChar);
  }
  
  private final Token b()
  {
    if (this.d > 0)
    {
      int i = Character.getType(this.jdField_a_of_type_ArrayOfChar[0]);
      String str1;
      if ((i != 1) && (i != 2))
      {
        if (i != 5)
        {
          if (i != 9) {
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
      String str2 = new String(this.jdField_a_of_type_ArrayOfChar, 0, this.d);
      i = this.e;
      return new Token(str2, i, this.d + i, str1);
    }
    return null;
  }
  
  public final Token a()
  {
    this.d = 0;
    this.e = this.jdField_a_of_type_Int;
    label210:
    do
    {
      char c1;
      do
      {
        do
        {
          this.jdField_a_of_type_Int += 1;
          if (this.jdField_b_of_type_Int >= this.c)
          {
            this.c = this.jdField_a_of_type_JavaIoReader.read(this.jdField_b_of_type_ArrayOfChar);
            this.jdField_b_of_type_Int = 0;
          }
          if (this.c == -1)
          {
            this.f = -1;
            return b();
          }
          char[] arrayOfChar = this.jdField_b_of_type_ArrayOfChar;
          i = this.jdField_b_of_type_Int;
          this.jdField_b_of_type_Int = (i + 1);
          c1 = arrayOfChar[i];
          i = Character.getType(c1);
          if ((i == 1) || (i == 2)) {
            break label280;
          }
          if (i == 5) {
            break label210;
          }
          if (i == 9) {
            break;
          }
        } while (this.d <= 0);
        return b();
        i = this.f;
        if (i == -1)
        {
          this.f = 0;
        }
        else if (i != 0)
        {
          this.f = 0;
          if (this.d > 0)
          {
            this.jdField_b_of_type_Int -= 1;
            this.jdField_a_of_type_Int -= 1;
            return b();
          }
        }
        a(c1);
      } while (this.d != 255);
      return b();
      int i = this.f;
      if (i == -1)
      {
        this.f = 2;
      }
      else if (i != 2)
      {
        this.f = 2;
        if (this.d > 0)
        {
          this.jdField_b_of_type_Int -= 1;
          this.jdField_a_of_type_Int -= 1;
          return b();
        }
      }
      a(c1);
      return b();
      i = this.f;
      if (i == -1)
      {
        this.f = 1;
      }
      else if (i != 1)
      {
        this.f = 1;
        if (this.d > 0)
        {
          this.jdField_b_of_type_Int -= 1;
          this.jdField_a_of_type_Int -= 1;
          return b();
        }
      }
      a(c1);
    } while (this.d != 255);
    label280:
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.tokenizer.cn.ChineseTokenizer
 * JD-Core Version:    0.7.0.1
 */