package com.tencent.mobileqq.text;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.GetChars;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.SmallEmojiSpan;
import com.tencent.mobileqq.vas.ColorSpan;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ColorNickText
  implements GetChars, Spannable, CharSequence, Cloneable
{
  private int jdField_a_of_type_Int;
  public String a;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<ColorNickText.SpanInfo> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  public ColorNickText(CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramCharSequence == null)
    {
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_JavaLangString = "";
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      paramInt = (int)(paramInt * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
      Object localObject = new StringBuilder(paramCharSequence);
      a(0, ((StringBuilder)localObject).length(), paramInt, (StringBuilder)localObject);
      this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      if (!QQText.IS_FXXKED_MTK) {
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      }
      if ((paramCharSequence instanceof Spanned))
      {
        localObject = (Spanned)paramCharSequence;
        int k = paramCharSequence.length();
        paramCharSequence = ((Spanned)localObject).getSpans(0, paramCharSequence.length(), Object.class);
        paramInt = 0;
        while (paramInt < paramCharSequence.length)
        {
          int j = ((Spanned)localObject).getSpanStart(paramCharSequence[paramInt]);
          int m = ((Spanned)localObject).getSpanEnd(paramCharSequence[paramInt]);
          int n = ((Spanned)localObject).getSpanFlags(paramCharSequence[paramInt]);
          int i = j;
          if (j < 0) {
            i = 0;
          }
          j = m;
          if (m > k) {
            j = k;
          }
          setSpan(paramCharSequence[paramInt], i - 0, j - 0, n);
          paramInt += 1;
        }
      }
    }
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    int k = paramStringBuilder.length();
    while (paramInt1 < paramInt2)
    {
      if ((paramStringBuilder.charAt(paramInt1) == '<') && (paramInt1 < k - 2))
      {
        int i2 = paramStringBuilder.charAt(paramInt1 + 1);
        int j;
        int i;
        if ((i2 == 36) && (paramInt1 < k - 3))
        {
          j = paramStringBuilder.charAt(paramInt1 + 2);
          if (QQText.IS_FXXKED_MTK) {
            paramStringBuilder.replace(paramInt1 + 1, paramInt1 + 3, "##");
          }
          for (;;)
          {
            if ((j == 255) || (j == 511) || (j == 250)) {
              break label203;
            }
            if (paramStringBuilder.charAt(paramInt1 + 3) != '>') {
              break label651;
            }
            j = QQSysFaceUtil.convertToLocal(j);
            i = j;
            if (j == 250) {
              i = 10;
            }
            if (!QQSysFaceUtil.isValidFaceId(i)) {
              break label651;
            }
            a(new EmoticonSpan(i, paramInt3, 1), paramInt1, paramInt1 + 4, 33);
            paramInt1 += 4;
            break;
            if (j == 10) {
              paramStringBuilder.setCharAt(paramInt1 + 2, 'ú');
            }
          }
          label203:
          if ((j >= 255) && (paramInt1 + 6 < k))
          {
            if (paramStringBuilder.charAt(paramInt1 + 6) == '>')
            {
              char[] arrayOfChar = new char[3];
              arrayOfChar[0] = paramStringBuilder.charAt(paramInt1 + 3);
              arrayOfChar[1] = paramStringBuilder.charAt(paramInt1 + 4);
              arrayOfChar[2] = ((char)(paramStringBuilder.charAt(paramInt1 + 5) & 0xFF));
              i = 0;
              if (i < 3)
              {
                if (arrayOfChar[i] == 'ú') {
                  arrayOfChar[i] = '\n';
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (arrayOfChar[i] == 'þ') {
                    arrayOfChar[i] = '\r';
                  }
                }
              }
              boolean bool;
              if (j == 511)
              {
                bool = true;
                a(new SmallEmojiSpan(arrayOfChar, paramInt3, true, bool), paramInt1, paramInt1 + 7, 33);
                i = 2;
                label375:
                if (i >= 5) {
                  break label451;
                }
                if (paramStringBuilder.charAt(paramInt1 + i) != '\n') {
                  break label422;
                }
                paramStringBuilder.setCharAt(paramInt1 + i, 'ú');
              }
              for (;;)
              {
                i += 1;
                break label375;
                bool = false;
                break;
                if (paramStringBuilder.charAt(paramInt1 + i) == '\r') {
                  paramStringBuilder.setCharAt(paramInt1 + i, 'þ');
                }
              }
              paramInt1 += 7;
            }
          }
          else if (j == 250)
          {
            if (QQText.IS_FXXKED_MTK) {
              paramStringBuilder.replace(paramInt1 + 1, paramInt1 + 3, "##");
            }
            a(new EmoticonSpan(10, paramInt3, 1), paramInt1, paramInt1 + 4, 33);
            paramInt1 += 4;
          }
        }
        else
        {
          label422:
          label451:
          if (((i2 == 37) || (i2 == 38)) && (paramInt1 < k - 6))
          {
            j = paramStringBuilder.charAt(paramInt1 + 2);
            int m = paramStringBuilder.charAt(paramInt1 + 3);
            int n = paramStringBuilder.charAt(paramInt1 + 4);
            int i1 = paramStringBuilder.charAt(paramInt1 + 5);
            i = 3;
            if (i2 == 38) {
              i = 2;
            }
            a(new ColorSpan(i, (i1 & 0xFF) + ((j << 24) + 0 + (m << 16 & 0xFF0000) + (n << 8 & 0xFF00))), paramInt1, paramInt1 + 7, 33);
            paramInt1 += 7;
            continue;
          }
        }
      }
      label651:
      paramInt1 += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
    paramObject = new ColorNickText.SpanInfo(paramInt1, paramInt2, paramInt3);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramObject);
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " has end before start");
    }
    int i = length();
    if ((paramInt1 > i) || (paramInt2 > i)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " ends beyond length " + i);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_b_of_type_JavaLangString);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.jdField_b_of_type_JavaLangString.charAt(paramInt);
  }
  
  public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    this.jdField_b_of_type_JavaLangString.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < i) {}
    while (i < 0) {
      return -1;
    }
    return ((ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).b;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < i) {}
    while (i < 0) {
      return 0;
    }
    return ((ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).c;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < i) {}
    while (i < 0) {
      return -1;
    }
    return ((ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramClass.isInstance(localObject))
      {
        ColorNickText.SpanInfo localSpanInfo = (ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if ((localSpanInfo.jdField_a_of_type_Int >= paramInt1) && (localSpanInfo.b <= paramInt2)) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, localArrayList.size());
    paramInt1 = j;
    while (paramInt1 < localArrayList.size())
    {
      paramClass[paramInt1] = localArrayList.get(paramInt1);
      paramInt1 += 1;
    }
    return paramClass;
  }
  
  public int length()
  {
    return this.jdField_b_of_type_JavaLangString.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramClass = this.jdField_a_of_type_JavaUtilArrayList.get(k);
      ColorNickText.SpanInfo localSpanInfo = (ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(k);
      int i = paramInt2;
      if (((Class)localObject).isInstance(paramClass))
      {
        int j = paramInt2;
        if (localSpanInfo.jdField_a_of_type_Int > paramInt1)
        {
          j = paramInt2;
          if (localSpanInfo.jdField_a_of_type_Int < paramInt2) {
            j = localSpanInfo.jdField_a_of_type_Int;
          }
        }
        i = j;
        if (localSpanInfo.b > paramInt1)
        {
          i = j;
          if (localSpanInfo.b < j) {
            i = localSpanInfo.b;
          }
        }
      }
      k += 1;
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  public void removeSpan(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    if (i >= 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      ColorNickText.SpanInfo localSpanInfo = (ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.remove(i);
      b(paramObject, localSpanInfo.jdField_a_of_type_Int, localSpanInfo.b);
    }
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    a("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c = charAt(paramInt1 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c = charAt(paramInt2 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c + ")");
        }
      }
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    ColorNickText.SpanInfo localSpanInfo;
    if ((i > 0) && (this.jdField_b_of_type_JavaUtilArrayList.size() > i))
    {
      localSpanInfo = (ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      int j = localSpanInfo.jdField_a_of_type_Int;
      int k = localSpanInfo.b;
      localSpanInfo.jdField_a_of_type_Int = paramInt1;
      localSpanInfo.b = paramInt2;
      localSpanInfo.c = paramInt3;
      a(paramObject, j, k, paramInt1, paramInt2);
    }
    if (i < 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
      localSpanInfo = new ColorNickText.SpanInfo(paramInt1, paramInt2, paramInt3);
      this.jdField_b_of_type_JavaUtilArrayList.add(localSpanInfo);
      a(paramObject, paramInt1, paramInt2);
    }
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    if ((Build.VERSION.SDK_INT >= 26) && (i == 0) && (paramInt1 == length())) {
      return this;
    }
    return this.jdField_b_of_type_JavaLangString.substring(i, paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.ColorNickText
 * JD-Core Version:    0.7.0.1
 */