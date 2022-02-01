package com.tencent.mobileqq.text;

import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NickWrapper$NickString
{
  private String a;
  private List<NickWrapper.TextUnit> b;
  
  private NickWrapper$NickString()
  {
    this.a = "";
    this.b = new ArrayList();
  }
  
  public NickWrapper$NickString(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.a = str;
    this.b = new ArrayList();
    a(new StringBuilder(this.a), paramInt);
  }
  
  private NickString a(NickWrapper.TextUnit paramTextUnit)
  {
    if (paramTextUnit != null) {
      this.b.add(paramTextUnit);
    }
    this.a = c();
    return this;
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int m = this.a.length();
    int n = this.a.length();
    int i1 = (int)(paramInt * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    int i = 0;
    while (i < n)
    {
      if ((paramStringBuilder.charAt(i) == '<') && (i < m - 2))
      {
        int k = i + 1;
        paramInt = paramStringBuilder.charAt(k);
        if ((paramInt == 36) && (i < m - 3))
        {
          int i2 = i + 2;
          int j = paramStringBuilder.charAt(i2);
          boolean bool = QQText.IS_FXXKED_MTK;
          paramInt = 10;
          if (bool) {
            paramStringBuilder.replace(k, i + 3, "##");
          } else if (j == 10) {
            paramStringBuilder.setCharAt(i2, 'ú');
          }
          char[] arrayOfChar;
          if (j < QQSysFaceUtil.maxServerId())
          {
            k = i + 3;
            if (paramStringBuilder.charAt(k) == '>')
            {
              j = QQSysFaceUtil.convertToLocal(j);
              if (j != 250) {
                paramInt = j;
              }
              if (paramInt >= EmotcationConstants.VALID_SYS_EMOTCATION_COUNT) {
                break label849;
              }
              j = i + 4;
              a(new NickWrapper.QQEmojiTextUnit(paramStringBuilder.substring(i, j), paramInt, i1));
              paramInt = j;
            }
            else
            {
              if (paramStringBuilder.charAt(i + 6) != '>') {
                break label849;
              }
              arrayOfChar = new char[3];
              arrayOfChar[0] = paramStringBuilder.charAt(k);
              arrayOfChar[1] = paramStringBuilder.charAt(i + 4);
              arrayOfChar[2] = ((char)(paramStringBuilder.charAt(i + 5) & 0xFF));
              paramInt = 0;
              while (paramInt < 3)
              {
                if (arrayOfChar[paramInt] == 'ú') {
                  arrayOfChar[paramInt] = '\n';
                } else if (arrayOfChar[paramInt] == 'þ') {
                  arrayOfChar[paramInt] = '\r';
                }
                paramInt += 1;
              }
              k = i + 7;
              a(new NickWrapper.QQSmallEmojiTextUnit(paramStringBuilder.substring(i, k), j, i1));
              j = 2;
              for (;;)
              {
                paramInt = k;
                if (j >= 5) {
                  break;
                }
                paramInt = i + j;
                if (paramStringBuilder.charAt(paramInt) == '\n') {
                  paramStringBuilder.setCharAt(paramInt, 'ú');
                } else if (paramStringBuilder.charAt(paramInt) == '\r') {
                  paramStringBuilder.setCharAt(paramInt, 'þ');
                }
                j += 1;
              }
            }
          }
          else
          {
            if (j >= 255)
            {
              paramInt = i + 6;
              if (paramInt < m)
              {
                if (paramStringBuilder.charAt(paramInt) != '>') {
                  break label849;
                }
                arrayOfChar = new char[3];
                arrayOfChar[0] = paramStringBuilder.charAt(i + 3);
                arrayOfChar[1] = paramStringBuilder.charAt(i + 4);
                arrayOfChar[2] = ((char)(paramStringBuilder.charAt(i + 5) & 0xFF));
                paramInt = 0;
                while (paramInt < 3)
                {
                  if (arrayOfChar[paramInt] == 'ú') {
                    arrayOfChar[paramInt] = '\n';
                  } else if (arrayOfChar[paramInt] == 'þ') {
                    arrayOfChar[paramInt] = '\r';
                  }
                  paramInt += 1;
                }
                k = i + 7;
                a(new NickWrapper.QQSmallEmojiTextUnit(paramStringBuilder.substring(i, k), j, i1));
                j = 2;
                for (;;)
                {
                  paramInt = k;
                  if (j >= 5) {
                    break;
                  }
                  paramInt = i + j;
                  if (paramStringBuilder.charAt(paramInt) == '\n') {
                    paramStringBuilder.setCharAt(paramInt, 'ú');
                  } else if (paramStringBuilder.charAt(paramInt) == '\r') {
                    paramStringBuilder.setCharAt(paramInt, 'þ');
                  }
                  j += 1;
                }
              }
            }
            if (j != 250) {
              break label849;
            }
            if (QQText.IS_FXXKED_MTK) {
              paramStringBuilder.replace(k, i + 3, "##");
            }
            paramInt = i + 4;
            a(new NickWrapper.QQEmojiTextUnit(paramStringBuilder.substring(i, paramInt), 10, i1));
          }
        }
        else
        {
          if (((paramInt != 37) && (paramInt != 38)) || (i >= m - 6)) {
            break label849;
          }
          paramInt = i + 7;
          a(new NickWrapper.QQColorTextUnit(paramStringBuilder.substring(i, paramInt)));
        }
      }
      else
      {
        if ((!Character.isHighSurrogate(paramStringBuilder.charAt(i))) || (i > m - 2) || (!Character.isSurrogatePair(paramStringBuilder.charAt(i), paramStringBuilder.charAt(i + 1))) || (!d(paramStringBuilder.toString().codePointAt(i)))) {
          break label829;
        }
        paramInt = i + 2;
        a(new NickWrapper.EmojiTextUnit(paramStringBuilder.substring(i, paramInt)));
      }
      i = paramInt;
      continue;
      label829:
      a(new NickWrapper.NormalTextUnit(String.valueOf(paramStringBuilder.charAt(i))));
      label849:
      i += 1;
    }
  }
  
  private static boolean d(int paramInt)
  {
    return ((paramInt >= 9728) && (paramInt <= 10175)) || (paramInt == 12349) || (paramInt == 8265) || (paramInt == 8252) || ((paramInt >= 8192) && (paramInt <= 8207)) || ((paramInt >= 8232) && (paramInt <= 8239)) || (paramInt == 8287) || ((paramInt >= 8293) && (paramInt <= 8303)) || ((paramInt >= 8448) && (paramInt <= 8527)) || ((paramInt >= 8960) && (paramInt <= 9215)) || ((paramInt >= 11008) && (paramInt <= 11263)) || ((paramInt >= 10496) && (paramInt <= 10623)) || ((paramInt >= 12800) && (paramInt <= 13055)) || ((paramInt >= 55296) && (paramInt <= 57343)) || ((paramInt >= 57344) && (paramInt <= 63743)) || ((paramInt >= 65024) && (paramInt <= 65039)) || (paramInt >= 65536);
  }
  
  public float a(Paint paramPaint)
  {
    float f = 0.0F;
    int i = 0;
    while (i < a())
    {
      f += a(i).a(paramPaint);
      i += 1;
    }
    return f;
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  @NonNull
  public NickWrapper.TextUnit a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (NickWrapper.TextUnit)this.b.get(paramInt);
    }
    throw new IndexOutOfBoundsException("NickString index error");
  }
  
  public NickString b(int paramInt)
  {
    NickString localNickString = new NickString();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      NickWrapper.TextUnit localTextUnit = (NickWrapper.TextUnit)localIterator.next();
      if (localTextUnit.b() == paramInt) {
        localNickString.a(localTextUnit);
      }
    }
    return localNickString;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      NickWrapper.TextUnit localTextUnit = (NickWrapper.TextUnit)localIterator.next();
      if ((localTextUnit.b() == 0) || (localTextUnit.b() == 1)) {
        localStringBuilder.append(localTextUnit.a());
      }
    }
    return localStringBuilder.toString();
  }
  
  public NickString c(int paramInt)
  {
    NickString localNickString = new NickString();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      NickWrapper.TextUnit localTextUnit = (NickWrapper.TextUnit)localIterator.next();
      if (localTextUnit.b() != paramInt) {
        localNickString.a(localTextUnit);
      }
    }
    return localNickString;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((NickWrapper.TextUnit)localIterator.next()).a());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.NickWrapper.NickString
 * JD-Core Version:    0.7.0.1
 */