package com.tencent.mobileqq.fts.v2.tokenizer.cjk;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v2.tokenizer.Token;
import com.tencent.mobileqq.fts.v2.tokenizer.Tokenizer;
import java.io.Reader;

public final class CJKTokenizer
  extends Tokenizer
{
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private final char[] f = new char['ÿ'];
  private final char[] g = new char[1024];
  private String h = "word";
  private boolean i = false;
  
  public CJKTokenizer(Reader paramReader, int paramInt)
  {
    this.a = paramReader;
    this.b = paramInt;
  }
  
  public final Token a()
  {
    int n = this.c;
    int m;
    label8:
    int i1;
    for (;;)
    {
      m = 0;
      label444:
      label592:
      label638:
      do
      {
        this.c += 1;
        if (this.d >= this.e)
        {
          this.e = this.a.read(this.g);
          this.d = 0;
        }
        if (this.e == -1) {
          if (m > 0)
          {
            i1 = n;
            if (this.i != true) {
              break label662;
            }
            this.i = false;
          }
        }
        for (;;)
        {
          m = 0;
          i1 = n;
          break label662;
          return null;
          Object localObject = this.g;
          i1 = this.d;
          this.d = (i1 + 1);
          int k = localObject[i1];
          localObject = Character.UnicodeBlock.of(k);
          if ((localObject != Character.UnicodeBlock.BASIC_LATIN) && (localObject != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
          {
            if (Character.isLetter(k))
            {
              if (m == 0)
              {
                n = this.c - 1;
                this.f[m] = k;
                this.h = "double";
                m += 1;
                break label8;
              }
              if ((!TextUtils.equals(this.h, "letter")) && (!TextUtils.equals(this.h, "digit")))
              {
                localObject = this.f;
                i1 = m + 1;
                localObject[m] = k;
                this.h = "double";
                if (i1 == 2)
                {
                  this.c -= 1;
                  this.d -= 1;
                  this.i = true;
                  m = i1;
                  i1 = n;
                  break label662;
                }
                m = i1;
                break label8;
              }
              this.c -= 1;
              this.d -= 1;
              i1 = n;
              break label662;
            }
            if (m <= 0) {
              break label8;
            }
            i1 = n;
            if (this.i != true) {
              break label662;
            }
            this.i = false;
            break;
          }
          int j = k;
          char c1;
          if (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            c1 = (char)(k - 65248);
          }
          if (Character.isLetter(c1))
          {
            if (m == 0)
            {
              i1 = this.c - 1;
            }
            else
            {
              if (TextUtils.equals(this.h, "double")) {
                break label444;
              }
              i1 = n;
              if (TextUtils.equals(this.h, "digit")) {
                break label444;
              }
            }
            localObject = this.f;
            n = m + 1;
            localObject[m] = Character.toLowerCase(c1);
            this.h = "letter";
            if (n == 255)
            {
              m = n;
              break label662;
            }
            m = n;
            n = i1;
            break label8;
            this.c -= 1;
            this.d -= 1;
            this.h = "letter";
            i1 = n;
            if (this.i != true) {
              break label662;
            }
            this.i = false;
            continue;
          }
          if (!Character.isDigit(c1)) {
            break label638;
          }
          if (m == 0)
          {
            i1 = this.c - 1;
          }
          else
          {
            if (TextUtils.equals(this.h, "double")) {
              break label592;
            }
            i1 = n;
            if (TextUtils.equals(this.h, "letter")) {
              break label592;
            }
          }
          localObject = this.f;
          n = m + 1;
          localObject[m] = Character.toLowerCase(c1);
          this.h = "digit";
          if (n == 255)
          {
            m = n;
            break label662;
          }
          m = n;
          n = i1;
          break label8;
          this.c -= 1;
          this.d -= 1;
          this.h = "digit";
          i1 = n;
          if (this.i != true) {
            break label662;
          }
          this.i = false;
        }
      } while (m <= 0);
      i1 = n;
      if (this.i != true) {
        break;
      }
      this.i = false;
    }
    label662:
    if ((i1 == this.b - 1) && (m == 0)) {
      return null;
    }
    return new Token(new String(this.f, 0, m), i1, m + i1, this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.tokenizer.cjk.CJKTokenizer
 * JD-Core Version:    0.7.0.1
 */