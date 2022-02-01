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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.api.ISmallEmojiSpanService;
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
      return;
    }
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
  
  private static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" ... ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    int n = paramStringBuilder.length();
    while (paramInt1 < paramInt2)
    {
      if ((paramStringBuilder.charAt(paramInt1) == '<') && (paramInt1 < n - 2))
      {
        int k = paramInt1 + 1;
        int i3 = paramStringBuilder.charAt(k);
        int i1;
        int m;
        int j;
        Object localObject;
        if ((i3 == 36) && (paramInt1 < n - 3))
        {
          i1 = paramInt1 + 2;
          m = paramStringBuilder.charAt(i1);
          boolean bool = QQText.IS_FXXKED_MTK;
          j = 10;
          if (bool) {
            paramStringBuilder.replace(k, paramInt1 + 3, "##");
          } else if (m == 10) {
            paramStringBuilder.setCharAt(i1, 'ú');
          }
          if ((m != 255) && (m != 511) && (m != 250))
          {
            if (paramStringBuilder.charAt(paramInt1 + 3) != '>') {
              break label701;
            }
            k = QQSysFaceUtil.convertToLocal(m);
            if (k != 250) {
              j = k;
            }
            if (!QQSysFaceUtil.isValidFaceId(j)) {
              break label701;
            }
            localObject = new EmoticonSpan(j, paramInt3, 1);
            j = paramInt1 + 4;
            a(localObject, paramInt1, j, 33);
          }
          else
          {
            if (m >= 255)
            {
              j = paramInt1 + 6;
              if (j < n)
              {
                if (paramStringBuilder.charAt(j) != '>') {
                  break label701;
                }
                localObject = new char[3];
                localObject[0] = paramStringBuilder.charAt(paramInt1 + 3);
                localObject[1] = paramStringBuilder.charAt(paramInt1 + 4);
                int i = (char)(paramStringBuilder.charAt(paramInt1 + 5) & 0xFF);
                k = 2;
                localObject[2] = i;
                j = 0;
                while (j < 3)
                {
                  if (localObject[j] == 'ú') {
                    localObject[j] = 10;
                  } else if (localObject[j] == 'þ') {
                    localObject[j] = 13;
                  }
                  j += 1;
                }
                ISmallEmojiSpanService localISmallEmojiSpanService = (ISmallEmojiSpanService)QRoute.api(ISmallEmojiSpanService.class);
                if (m == 511) {
                  bool = true;
                } else {
                  bool = false;
                }
                localObject = localISmallEmojiSpanService.createSmallEmojiSpan((char[])localObject, paramInt3, true, bool);
                m = paramInt1 + 7;
                a(localObject, paramInt1, m, 33);
                for (;;)
                {
                  j = m;
                  if (k >= 5) {
                    break;
                  }
                  j = paramInt1 + k;
                  if (paramStringBuilder.charAt(j) == '\n') {
                    paramStringBuilder.setCharAt(j, 'ú');
                  } else if (paramStringBuilder.charAt(j) == '\r') {
                    paramStringBuilder.setCharAt(j, 'þ');
                  }
                  k += 1;
                }
              }
            }
            if (m != 250) {
              break label701;
            }
            if (QQText.IS_FXXKED_MTK) {
              paramStringBuilder.replace(k, paramInt1 + 3, "##");
            }
            localObject = new EmoticonSpan(10, paramInt3, 1);
            j = paramInt1 + 4;
            a(localObject, paramInt1, j, 33);
          }
          paramInt1 = j;
        }
        else
        {
          j = 2;
          if (((i3 == 37) || (i3 == 38)) && (paramInt1 < n - 6))
          {
            k = paramStringBuilder.charAt(paramInt1 + 2);
            m = paramStringBuilder.charAt(paramInt1 + 3);
            i1 = paramStringBuilder.charAt(paramInt1 + 4);
            int i2 = paramStringBuilder.charAt(paramInt1 + 5);
            if (i3 != 38) {
              j = 3;
            }
            localObject = new ColorSpan(j, (k << 24) + 0 + (m << 16 & 0xFF0000) + (i1 << 8 & 0xFF00) + (i2 & 0xFF));
            j = paramInt1 + 7;
            a(localObject, paramInt1, j, 33);
            paramInt1 = j;
            continue;
          }
        }
      }
      label701:
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
    if (paramInt2 >= paramInt1)
    {
      int i = length();
      if ((paramInt1 <= i) && (paramInt2 <= i))
      {
        if ((paramInt1 >= 0) && (paramInt2 >= 0)) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(a(paramInt1, paramInt2));
        localStringBuilder.append(" starts before 0");
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" ");
      localStringBuilder.append(a(paramInt1, paramInt2));
      localStringBuilder.append(" ends beyond length ");
      localStringBuilder.append(i);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(a(paramInt1, paramInt2));
    localStringBuilder.append(" has end before start");
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
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
    if ((paramInt >= 0) && (paramInt <= length())) {
      return this.jdField_b_of_type_JavaLangString.charAt(paramInt);
    }
    return '\000';
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
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < i) {
      return -1;
    }
    if (i < 0) {
      return -1;
    }
    return ((ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).b;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < i) {
      return 0;
    }
    if (i < 0) {
      return 0;
    }
    return ((ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).c;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramObject);
    if (this.jdField_b_of_type_JavaUtilArrayList.size() < i) {
      return -1;
    }
    if (i < 0) {
      return -1;
    }
    return ((ColorNickText.SpanInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
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
        if (c != '\n')
        {
          paramObject = new StringBuilder();
          paramObject.append("PARAGRAPH span must start at paragraph boundary (");
          paramObject.append(paramInt1);
          paramObject.append(" follows ");
          paramObject.append(c);
          paramObject.append(")");
          throw new RuntimeException(paramObject.toString());
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c = charAt(paramInt2 - 1);
        if (c != '\n')
        {
          paramObject = new StringBuilder();
          paramObject.append("PARAGRAPH span must end at paragraph boundary (");
          paramObject.append(paramInt2);
          paramObject.append(" follows ");
          paramObject.append(c);
          paramObject.append(")");
          throw new RuntimeException(paramObject.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.ColorNickText
 * JD-Core Version:    0.7.0.1
 */