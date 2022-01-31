package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class SingleLineHotwordTextView
  extends TextView
{
  public static final HashMap a;
  public int a;
  public String a;
  private ArrayList a;
  public int b;
  public String b;
  public int c;
  protected String c;
  private int d;
  protected String d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public SingleLineHotwordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2147483647;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -97212;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    setSingleLine();
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, TextPaint paramTextPaint, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    paramString1 = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.append(".").append(paramString3);
    }
    paramString1 = paramString1.toString();
    int k = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
    if (k != -1)
    {
      int m = paramString1.length();
      if (paramTextPaint.measureText(paramString1, 0, m) <= paramInt) {
        return 0;
      }
      if (k == 0) {
        return 2;
      }
      float[] arrayOfFloat = new float[m];
      paramTextPaint.getTextWidths(paramString1, 0, m, arrayOfFloat);
      int i = (int)(paramInt - paramTextPaint.measureText("…"));
      paramInt = i;
      if (!TextUtils.isEmpty(paramString3)) {
        paramInt = (int)(i - paramTextPaint.measureText(paramString3));
      }
      int n = paramString2.length();
      i = 0;
      int j = 0;
      while (i < k + n)
      {
        j = (int)(j + arrayOfFloat[i]);
        i += 1;
      }
      if (j < paramInt) {
        return 2;
      }
      j = 0;
      i = k;
      while (i < m)
      {
        j = (int)(j + arrayOfFloat[i]);
        i += 1;
      }
      if (j < paramInt) {
        return 1;
      }
      return 3;
    }
    return 0;
  }
  
  public static SpannableString a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new SpannableString(paramString);
    if (TroopUtils.a(paramArrayList)) {
      return paramString;
    }
    String str1 = paramString.toString().toLowerCase();
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i);
      if (!TextUtils.isEmpty(str2))
      {
        int j = str1.indexOf(str2.toLowerCase());
        if (j > -1) {
          paramString.setSpan(new ForegroundColorSpan(paramInt), j, str2.length() + j, 33);
        }
      }
      i += 1;
    }
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, TextPaint paramTextPaint, String paramString3)
  {
    int k = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str1;
    int j;
    do
    {
      return paramString1;
      paramString1 = new StringBuilder(paramString1);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1.append(".").append(paramString3);
      }
      str1 = paramString1.toString();
      j = str1.toLowerCase().indexOf(paramString2.toLowerCase());
      paramString1 = str1;
    } while (j == -1);
    int n = str1.length();
    float[] arrayOfFloat = new float[n];
    paramTextPaint.getTextWidths(str1, 0, n, arrayOfFloat);
    String str2;
    if (paramInt1 == 2)
    {
      str2 = "." + paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        break label549;
      }
      paramString1 = str1.substring(0, str1.lastIndexOf(str2));
    }
    for (paramInt1 = (int)(0 + paramTextPaint.measureText(str2));; paramInt1 = 0)
    {
      int i = (int)(paramInt1 + paramTextPaint.measureText("…"));
      paramInt1 = 0;
      label179:
      if (paramInt1 < n)
      {
        i = (int)(i + arrayOfFloat[paramInt1]);
        if (i <= paramInt2) {}
      }
      for (;;)
      {
        paramString2 = paramString1.substring(0, paramInt1) + "…";
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString3)) {
          break;
        }
        return paramString2 + str2;
        paramInt1 += 1;
        break label179;
        if (paramInt1 == 1)
        {
          i = (int)(0 + paramTextPaint.measureText("…"));
          paramInt1 = n - 1;
          for (;;)
          {
            j = k;
            if (paramInt1 > 0)
            {
              i = (int)(i + arrayOfFloat[paramInt1]);
              if (i > paramInt2) {
                j = paramInt1 + 1;
              }
            }
            else
            {
              return "…" + str1.substring(j, n);
            }
            paramInt1 -= 1;
          }
        }
        paramString1 = str1;
        if (paramInt1 != 3) {
          break;
        }
        i = paramString2.length() + j;
        paramInt1 = (int)(0 + (paramTextPaint.measureText("…") * 2.0F + paramTextPaint.measureText(str1.substring(j, i))));
        k = 1;
        if ((j > 0) && (i < n))
        {
          int m;
          if (k != 0)
          {
            paramInt1 = (int)(paramInt1 + arrayOfFloat[(j - 1)]);
            if (paramInt1 >= paramInt2) {
              break label510;
            }
            m = j - 1;
            j = i;
            i = m;
            label449:
            if (k != 0) {
              break label504;
            }
          }
          label504:
          for (k = 1;; k = 0)
          {
            m = i;
            i = j;
            j = m;
            break;
            paramInt1 = (int)(paramInt1 + arrayOfFloat[i]);
            if (paramInt1 >= paramInt2) {
              break label510;
            }
            m = j;
            j = i + 1;
            i = m;
            break label449;
          }
        }
        label510:
        return "…" + str1.substring(j, i) + "…";
        paramInt1 = n;
      }
      label549:
      paramString1 = str1;
    }
  }
  
  protected static String a(String paramString, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("key=[");
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      int i = 0;
      if (i < j)
      {
        String str2 = (String)paramArrayList.get(i);
        String str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2.toLowerCase();
        }
        localStringBuilder.append(str1);
        if (i != j - 1) {
          localStringBuilder.append("|");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append("]");
        }
      }
    }
    return ("&&text=[" + paramString + "]").toLowerCase();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  protected int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    int j = -1;
    int i = j;
    String str;
    if (!TextUtils.isEmpty(paramString1))
    {
      i = j;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString1.toLowerCase();
        if (paramInt != 1) {
          break label187;
        }
        if (paramString2.toLowerCase().contains(str)) {
          break label135;
        }
        i = j;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingleLineHotwordTextView", 2, "getTargetType targetType = " + i + ", hotword = " + paramString1 + ", text = " + paramString2 + ", fileName = " + paramString3 + ", extension = " + paramString4 + ", contentType = " + paramInt);
      }
      return i;
      label135:
      if ((paramString3 != null) && (paramString3.toLowerCase().contains(str)))
      {
        i = 1;
      }
      else if ((paramString4 != null) && (paramString4.toLowerCase().contains(str)))
      {
        i = 2;
      }
      else
      {
        i = 3;
        continue;
        label187:
        i = 1;
      }
    }
  }
  
  public String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    String str;
    if (paramString1 == null) {
      str = null;
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString1;
        } while (paramString2 == null);
        str = paramString1;
      } while (paramString1.length() <= paramInt1);
      paramInt2 = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      if (paramInt2 == -1) {
        return paramString1.substring(0, paramInt1) + "…";
      }
      str = paramString1;
    } while (paramString2.length() >= paramString1.length());
    if (paramString2.length() + paramInt2 == paramString1.length()) {
      return "…" + paramString1.substring(paramString1.length() - paramInt1, paramString1.length());
    }
    if (paramInt2 == 0) {
      return paramString1.substring(0, paramInt2 + paramInt1) + "…";
    }
    if (paramString1.length() - paramInt2 > paramInt1 - 1) {
      return "…" + paramString1.substring(paramInt2, paramInt2 + paramInt1) + "…";
    }
    return "…." + paramString1.substring(paramString1.length() - paramInt1, paramString1.length());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    Object localObject;
    label52:
    long l;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label127;
      }
      if (this.jdField_a_of_type_JavaLangString == null)
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
        this.jdField_b_of_type_JavaLangString = null;
      }
      l = System.currentTimeMillis();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_d_of_type_JavaLangString)) {
        break label129;
      }
      localObject = (SpannableString)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
    }
    for (;;)
    {
      super.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      return;
      localObject = null;
      break label52;
      label127:
      break;
      label129:
      paramInt1 = getWidth();
      TextPaint localTextPaint = getPaint();
      paramInt2 = a(this.jdField_a_of_type_JavaLangString, (String)localObject, paramInt1, localTextPaint, this.jdField_b_of_type_JavaLangString);
      String str = a(paramInt2, this.jdField_a_of_type_JavaLangString, (String)localObject, paramInt1, localTextPaint, this.jdField_b_of_type_JavaLangString);
      localObject = a(str, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_JavaLangString, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("SingleLineHotwordTextView", 2, "type = " + paramInt2 + ", displayText = " + str + ", text = " + this.jdField_c_of_type_JavaLangString + ", viewWidth = " + paramInt1 + ", new = " + localTextPaint.measureText(str) + ", old = " + localTextPaint.measureText(this.jdField_c_of_type_JavaLangString) + ", onLayout t = " + (System.currentTimeMillis() - l));
      }
    }
  }
  
  public void setContentType(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("SingleLineHotwordTextView", 2, "setContentType text = " + this.jdField_c_of_type_JavaLangString);
    }
    String str2 = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = str2;
    this.jdField_b_of_type_JavaLangString = null;
    String str1;
    if (paramInt1 == 1)
    {
      str1 = FileUtil.a(str2);
      if (!TextUtils.isEmpty(str1))
      {
        paramInt1 = str2.toLowerCase().lastIndexOf(str1.toLowerCase());
        if (paramInt1 > -1)
        {
          this.jdField_a_of_type_JavaLangString = str2.substring(0, paramInt1);
          this.jdField_b_of_type_JavaLangString = str1;
          if (str1.length() > 1) {
            this.jdField_b_of_type_JavaLangString = str1.substring(1);
          }
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label273;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_c_of_type_Int = a(str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
        if (this.jdField_c_of_type_Int != 3) {
          break label278;
        }
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "." + this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingleLineHotwordTextView", 2, "setContentType name = " + this.jdField_a_of_type_JavaLangString + ", extension = " + this.jdField_b_of_type_JavaLangString);
      }
      return;
      label273:
      str1 = null;
      break;
      label278:
      this.jdField_b_of_type_JavaLangString = a(this.jdField_b_of_type_JavaLangString, str1, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
      if ((this.jdField_c_of_type_Int == 2) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (str1 != null) && (str1.length() > this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  public void setHotword(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void setHotword(ArrayList paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setHotwords(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingleLineHotwordTextView", 2, "setText text = " + paramCharSequence);
    }
    this.jdField_c_of_type_JavaLangString = paramCharSequence.toString();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 2147483647;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_JavaLangString = a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList);
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_d_of_type_JavaLangString))
    {
      super.setText((SpannableString)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString), paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView
 * JD-Core Version:    0.7.0.1
 */