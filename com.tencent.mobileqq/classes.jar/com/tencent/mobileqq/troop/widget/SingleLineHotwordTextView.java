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
  public static final HashMap<String, SpannableString> a;
  public int a;
  public String a;
  private ArrayList<String> a;
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
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 2147483647;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_d_of_type_Int = -97212;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    setSingleLine();
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, TextPaint paramTextPaint, String paramString3)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int j = 0;
    int k = 0;
    int i = j;
    if (!bool)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return 0;
      }
      paramString1 = new StringBuilder(paramString1);
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1.append(".");
        paramString1.append(paramString3);
      }
      paramString1 = paramString1.toString();
      int m = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      i = j;
      if (m != -1)
      {
        int n = paramString1.length();
        float f1 = paramTextPaint.measureText(paramString1, 0, n);
        float f2 = paramInt;
        if (f1 <= f2) {
          return 0;
        }
        if (m == 0) {}
        float[] arrayOfFloat;
        do
        {
          return 2;
          arrayOfFloat = new float[n];
          paramTextPaint.getTextWidths(paramString1, 0, n, arrayOfFloat);
          i = (int)(f2 - paramTextPaint.measureText("…"));
          paramInt = i;
          if (!TextUtils.isEmpty(paramString3)) {
            paramInt = (int)(i - paramTextPaint.measureText(paramString3));
          }
          int i1 = paramString2.length();
          j = 0;
          i = 0;
          while (j < i1 + m)
          {
            i = (int)(i + arrayOfFloat[j]);
            j += 1;
          }
          j = m;
        } while (i < paramInt);
        while (j < n)
        {
          k = (int)(k + arrayOfFloat[j]);
          j += 1;
        }
        if (k < paramInt) {
          return 1;
        }
        i = 3;
      }
    }
    return i;
  }
  
  public static SpannableString a(String paramString, ArrayList<String> paramArrayList, int paramInt)
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
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      paramString1 = new StringBuilder(paramString1);
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString1.append(".");
        paramString1.append(paramString3);
      }
      paramString1 = paramString1.toString();
      int n = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      if (n == -1) {
        return paramString1;
      }
      int m = paramString1.length();
      float[] arrayOfFloat = new float[m];
      int k = 0;
      paramTextPaint.getTextWidths(paramString1, 0, m, arrayOfFloat);
      int i;
      if (paramInt1 == 2)
      {
        paramString2 = new StringBuilder();
        paramString2.append(".");
        paramString2.append(paramString3);
        paramString2 = paramString2.toString();
        if (!TextUtils.isEmpty(paramString3))
        {
          paramString1 = paramString1.substring(0, paramString1.lastIndexOf(paramString2));
          paramInt1 = (int)(0 + paramTextPaint.measureText(paramString2));
        }
        else
        {
          paramInt1 = 0;
        }
        i = (int)(paramInt1 + paramTextPaint.measureText("…"));
        paramInt1 = 0;
        while (paramInt1 < m)
        {
          i = (int)(i + arrayOfFloat[paramInt1]);
          if (i > paramInt2) {
            break label221;
          }
          paramInt1 += 1;
        }
        paramInt1 = m;
        label221:
        paramTextPaint = new StringBuilder();
        paramTextPaint.append(paramString1.substring(0, paramInt1));
        paramTextPaint.append("…");
        paramString1 = paramTextPaint.toString();
        str = paramString1;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramTextPaint = new StringBuilder();
          paramTextPaint.append(paramString1);
          paramTextPaint.append(paramString2);
          return paramTextPaint.toString();
        }
      }
      else
      {
        i = 1;
        int j;
        if (paramInt1 == 1)
        {
          i = (int)(0 + paramTextPaint.measureText("…"));
          paramInt1 = m - 1;
          for (;;)
          {
            j = k;
            if (paramInt1 <= 0) {
              break;
            }
            i = (int)(i + arrayOfFloat[paramInt1]);
            if (i > paramInt2)
            {
              j = paramInt1 + 1;
              break;
            }
            paramInt1 -= 1;
          }
          paramString2 = new StringBuilder();
          paramString2.append("…");
          paramString2.append(paramString1.substring(j, m));
          return paramString2.toString();
        }
        str = paramString1;
        if (paramInt1 == 3)
        {
          j = paramString2.length() + n;
          paramInt1 = (int)(0 + (paramTextPaint.measureText("…") * 2.0F + paramTextPaint.measureText(paramString1.substring(n, j))));
          k = n;
          while ((k > 0) && (j < m))
          {
            if (i != 0)
            {
              paramInt1 = (int)(paramInt1 + arrayOfFloat[(k - 1)]);
              if (paramInt1 >= paramInt2) {
                break;
              }
              k -= 1;
            }
            else
            {
              paramInt1 = (int)(paramInt1 + arrayOfFloat[j]);
              if (paramInt1 >= paramInt2) {
                break;
              }
              j += 1;
            }
            i ^= 0x1;
          }
          paramString2 = new StringBuilder();
          paramString2.append("…");
          paramString2.append(paramString1.substring(k, j));
          paramString2.append("…");
          str = paramString2.toString();
        }
      }
    }
    return str;
  }
  
  protected static String a(String paramString, ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("key=[");
    if (paramArrayList != null)
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        String str2 = (String)paramArrayList.get(i);
        String str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2.toLowerCase();
        }
        localStringBuilder.append(str1);
        if (i != j - 1) {
          localStringBuilder.append("|");
        } else {
          localStringBuilder.append("]");
        }
        i += 1;
      }
    }
    localStringBuilder.append("&&text=[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    return localStringBuilder.toString().toLowerCase();
  }
  
  public static void a()
  {
    HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int j = -1;
    int i = j;
    Object localObject;
    if (!bool)
    {
      i = j;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString1.toLowerCase();
        if (paramInt == 1)
        {
          if (!paramString2.toLowerCase().contains((CharSequence)localObject))
          {
            i = j;
            break label112;
          }
          if ((paramString3 == null) || (!paramString3.toLowerCase().contains((CharSequence)localObject)))
          {
            if ((paramString4 != null) && (paramString4.toLowerCase().contains((CharSequence)localObject)))
            {
              i = 2;
              break label112;
            }
            i = 3;
            break label112;
          }
        }
        i = 1;
      }
    }
    label112:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTargetType targetType = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", hotword = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", text = ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", fileName = ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", extension = ");
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append(", contentType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SingleLineHotwordTextView", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramString2 == null) {
      return paramString1;
    }
    if (paramString1.length() <= paramInt1) {
      return paramString1;
    }
    paramInt2 = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
    if (paramInt2 == -1)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1.substring(0, paramInt1));
      paramString2.append("…");
      return paramString2.toString();
    }
    String str = paramString1;
    if (paramString2.length() < paramString1.length())
    {
      if (paramString2.length() + paramInt2 == paramString1.length())
      {
        paramString2 = new StringBuilder();
        paramString2.append("…");
        paramString2.append(paramString1.substring(paramString1.length() - paramInt1, paramString1.length()));
        return paramString2.toString();
      }
      if (paramInt2 == 0)
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1.substring(0, paramInt2 + paramInt1));
        paramString2.append("…");
        return paramString2.toString();
      }
      if (paramString1.length() - paramInt2 > paramInt1 - 1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("…");
        paramString2.append(paramString1.substring(paramInt2, paramInt1 + paramInt2));
        paramString2.append("…");
        return paramString2.toString();
      }
      paramString2 = new StringBuilder();
      paramString2.append("….");
      paramString2.append(paramString1.substring(paramString1.length() - paramInt1, paramString1.length()));
      str = paramString2.toString();
    }
    return str;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = null;
    }
    long l = System.currentTimeMillis();
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_d_of_type_JavaLangString))
    {
      localObject = (SpannableString)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_d_of_type_JavaLangString);
    }
    else
    {
      paramInt1 = getWidth();
      TextPaint localTextPaint = getPaint();
      paramInt2 = a(this.jdField_a_of_type_JavaLangString, (String)localObject, paramInt1, localTextPaint, this.jdField_b_of_type_JavaLangString);
      String str = a(paramInt2, this.jdField_a_of_type_JavaLangString, (String)localObject, paramInt1, localTextPaint, this.jdField_b_of_type_JavaLangString);
      localObject = a(str, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      jdField_a_of_type_JavaUtilHashMap.put(this.jdField_d_of_type_JavaLangString, localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("type = ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", displayText = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", text = ");
        localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
        localStringBuilder.append(", viewWidth = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", new = ");
        localStringBuilder.append(localTextPaint.measureText(str));
        localStringBuilder.append(", old = ");
        localStringBuilder.append(localTextPaint.measureText(this.jdField_c_of_type_JavaLangString));
        localStringBuilder.append(", onLayout t = ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("SingleLineHotwordTextView", 2, localStringBuilder.toString());
      }
    }
    super.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
  }
  
  public void setContentType(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt1;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setContentType text = ");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_JavaLangString);
      QLog.d("SingleLineHotwordTextView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.jdField_c_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = ((String)localObject2);
    this.jdField_b_of_type_JavaLangString = null;
    if (paramInt1 == 1)
    {
      localObject1 = FileUtil.a((String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramInt1 = ((String)localObject2).toLowerCase().lastIndexOf(((String)localObject1).toLowerCase());
        if (paramInt1 > -1)
        {
          this.jdField_a_of_type_JavaLangString = ((String)localObject2).substring(0, paramInt1);
          this.jdField_b_of_type_JavaLangString = ((String)localObject1);
          if (((String)localObject1).length() > 1) {
            this.jdField_b_of_type_JavaLangString = ((String)localObject1).substring(1);
          }
        }
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        } else {
          localObject1 = null;
        }
        this.jdField_c_of_type_Int = a((String)localObject1, (String)localObject2, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
        paramInt1 = this.jdField_c_of_type_Int;
        if (paramInt1 == 3)
        {
          localObject1 = new StringBuffer(this.jdField_a_of_type_JavaLangString);
          ((StringBuffer)localObject1).append(".");
          ((StringBuffer)localObject1).append(this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_JavaLangString = ((StringBuffer)localObject1).toString();
          this.jdField_b_of_type_JavaLangString = null;
        }
        else
        {
          this.jdField_b_of_type_JavaLangString = a(this.jdField_b_of_type_JavaLangString, (String)localObject1, this.jdField_a_of_type_Int, paramInt1);
          if (this.jdField_c_of_type_Int == 2)
          {
            localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (localObject1 != null) && (((String)localObject1).length() > this.jdField_a_of_type_Int))
            {
              this.jdField_a_of_type_JavaUtilArrayList.remove(0);
              this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_b_of_type_JavaLangString);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setContentType name = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", extension = ");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("SingleLineHotwordTextView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void setHotword(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramString != null)
      {
        paramString.clear();
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  public void setHotword(ArrayList<String> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setHotwords(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setText text = ");
      localStringBuilder.append(paramCharSequence);
      QLog.d("SingleLineHotwordTextView", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView
 * JD-Core Version:    0.7.0.1
 */