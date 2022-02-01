package com.tencent.mobileqq.fts.v2.tokenizer.cjk;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v2.tokenizer.Token;
import com.tencent.mobileqq.fts.v2.tokenizer.Tokenizer;
import java.io.Reader;

public final class CJKTokenizer
  extends Tokenizer
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "word";
  private boolean jdField_a_of_type_Boolean = false;
  private final char[] jdField_a_of_type_ArrayOfChar = new char['ÿ'];
  private int jdField_b_of_type_Int = 0;
  private final char[] jdField_b_of_type_ArrayOfChar = new char[1024];
  private int c = 0;
  private int d = 0;
  
  public CJKTokenizer(Reader paramReader, int paramInt)
  {
    this.jdField_a_of_type_JavaIoReader = paramReader;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final Token a()
  {
    int m = this.jdField_b_of_type_Int;
    int k;
    label8:
    int n;
    for (;;)
    {
      k = 0;
      label444:
      label592:
      label638:
      do
      {
        this.jdField_b_of_type_Int += 1;
        if (this.c >= this.d)
        {
          this.d = this.jdField_a_of_type_JavaIoReader.read(this.jdField_b_of_type_ArrayOfChar);
          this.c = 0;
        }
        if (this.d == -1) {
          if (k > 0)
          {
            n = m;
            if (this.jdField_a_of_type_Boolean != true) {
              break label662;
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
        for (;;)
        {
          k = 0;
          n = m;
          break label662;
          return null;
          Object localObject = this.jdField_b_of_type_ArrayOfChar;
          n = this.c;
          this.c = (n + 1);
          int j = localObject[n];
          localObject = Character.UnicodeBlock.of(j);
          if ((localObject != Character.UnicodeBlock.BASIC_LATIN) && (localObject != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
          {
            if (Character.isLetter(j))
            {
              if (k == 0)
              {
                m = this.jdField_b_of_type_Int - 1;
                this.jdField_a_of_type_ArrayOfChar[k] = j;
                this.jdField_a_of_type_JavaLangString = "double";
                k += 1;
                break label8;
              }
              if ((!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "letter")) && (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "digit")))
              {
                localObject = this.jdField_a_of_type_ArrayOfChar;
                n = k + 1;
                localObject[k] = j;
                this.jdField_a_of_type_JavaLangString = "double";
                if (n == 2)
                {
                  this.jdField_b_of_type_Int -= 1;
                  this.c -= 1;
                  this.jdField_a_of_type_Boolean = true;
                  k = n;
                  n = m;
                  break label662;
                }
                k = n;
                break label8;
              }
              this.jdField_b_of_type_Int -= 1;
              this.c -= 1;
              n = m;
              break label662;
            }
            if (k <= 0) {
              break label8;
            }
            n = m;
            if (this.jdField_a_of_type_Boolean != true) {
              break label662;
            }
            this.jdField_a_of_type_Boolean = false;
            break;
          }
          int i = j;
          char c1;
          if (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            c1 = (char)(j - 65248);
          }
          if (Character.isLetter(c1))
          {
            if (k == 0)
            {
              n = this.jdField_b_of_type_Int - 1;
            }
            else
            {
              if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "double")) {
                break label444;
              }
              n = m;
              if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "digit")) {
                break label444;
              }
            }
            localObject = this.jdField_a_of_type_ArrayOfChar;
            m = k + 1;
            localObject[k] = Character.toLowerCase(c1);
            this.jdField_a_of_type_JavaLangString = "letter";
            if (m == 255)
            {
              k = m;
              break label662;
            }
            k = m;
            m = n;
            break label8;
            this.jdField_b_of_type_Int -= 1;
            this.c -= 1;
            this.jdField_a_of_type_JavaLangString = "letter";
            n = m;
            if (this.jdField_a_of_type_Boolean != true) {
              break label662;
            }
            this.jdField_a_of_type_Boolean = false;
            continue;
          }
          if (!Character.isDigit(c1)) {
            break label638;
          }
          if (k == 0)
          {
            n = this.jdField_b_of_type_Int - 1;
          }
          else
          {
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "double")) {
              break label592;
            }
            n = m;
            if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "letter")) {
              break label592;
            }
          }
          localObject = this.jdField_a_of_type_ArrayOfChar;
          m = k + 1;
          localObject[k] = Character.toLowerCase(c1);
          this.jdField_a_of_type_JavaLangString = "digit";
          if (m == 255)
          {
            k = m;
            break label662;
          }
          k = m;
          m = n;
          break label8;
          this.jdField_b_of_type_Int -= 1;
          this.c -= 1;
          this.jdField_a_of_type_JavaLangString = "digit";
          n = m;
          if (this.jdField_a_of_type_Boolean != true) {
            break label662;
          }
          this.jdField_a_of_type_Boolean = false;
        }
      } while (k <= 0);
      n = m;
      if (this.jdField_a_of_type_Boolean != true) {
        break;
      }
      this.jdField_a_of_type_Boolean = false;
    }
    label662:
    if ((n == this.jdField_a_of_type_Int - 1) && (k == 0)) {
      return null;
    }
    return new Token(new String(this.jdField_a_of_type_ArrayOfChar, 0, k), n, k + n, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.tokenizer.cjk.CJKTokenizer
 * JD-Core Version:    0.7.0.1
 */