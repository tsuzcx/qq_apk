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
  public static final HashMap<String, SpannableString> a = new HashMap();
  public String b = null;
  public String c = null;
  public int d = 2147483647;
  public int e = 0;
  public int f = -1;
  protected String g = "";
  protected String h = "";
  private ArrayList<String> i = null;
  private int j = -97212;
  
  public SingleLineHotwordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setSingleLine();
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, TextPaint paramTextPaint, String paramString3)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int m = 0;
    int n = 0;
    int k = m;
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
      int i1 = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      k = m;
      if (i1 != -1)
      {
        int i2 = paramString1.length();
        float f1 = paramTextPaint.measureText(paramString1, 0, i2);
        float f2 = paramInt;
        if (f1 <= f2) {
          return 0;
        }
        if (i1 == 0) {}
        float[] arrayOfFloat;
        do
        {
          return 2;
          arrayOfFloat = new float[i2];
          paramTextPaint.getTextWidths(paramString1, 0, i2, arrayOfFloat);
          k = (int)(f2 - paramTextPaint.measureText("…"));
          paramInt = k;
          if (!TextUtils.isEmpty(paramString3)) {
            paramInt = (int)(k - paramTextPaint.measureText(paramString3));
          }
          int i3 = paramString2.length();
          m = 0;
          k = 0;
          while (m < i3 + i1)
          {
            k = (int)(k + arrayOfFloat[m]);
            m += 1;
          }
          m = i1;
        } while (k < paramInt);
        while (m < i2)
        {
          n = (int)(n + arrayOfFloat[m]);
          m += 1;
        }
        if (n < paramInt) {
          return 1;
        }
        k = 3;
      }
    }
    return k;
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
    int k = 0;
    while (k < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(k);
      if (!TextUtils.isEmpty(str2))
      {
        int m = str1.indexOf(str2.toLowerCase());
        if (m > -1) {
          paramString.setSpan(new ForegroundColorSpan(paramInt), m, str2.length() + m, 33);
        }
      }
      k += 1;
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
      int i2 = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      if (i2 == -1) {
        return paramString1;
      }
      int i1 = paramString1.length();
      float[] arrayOfFloat = new float[i1];
      int n = 0;
      paramTextPaint.getTextWidths(paramString1, 0, i1, arrayOfFloat);
      int k;
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
        k = (int)(paramInt1 + paramTextPaint.measureText("…"));
        paramInt1 = 0;
        while (paramInt1 < i1)
        {
          k = (int)(k + arrayOfFloat[paramInt1]);
          if (k > paramInt2) {
            break label221;
          }
          paramInt1 += 1;
        }
        paramInt1 = i1;
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
        k = 1;
        int m;
        if (paramInt1 == 1)
        {
          k = (int)(0 + paramTextPaint.measureText("…"));
          paramInt1 = i1 - 1;
          for (;;)
          {
            m = n;
            if (paramInt1 <= 0) {
              break;
            }
            k = (int)(k + arrayOfFloat[paramInt1]);
            if (k > paramInt2)
            {
              m = paramInt1 + 1;
              break;
            }
            paramInt1 -= 1;
          }
          paramString2 = new StringBuilder();
          paramString2.append("…");
          paramString2.append(paramString1.substring(m, i1));
          return paramString2.toString();
        }
        str = paramString1;
        if (paramInt1 == 3)
        {
          m = paramString2.length() + i2;
          paramInt1 = (int)(0 + (paramTextPaint.measureText("…") * 2.0F + paramTextPaint.measureText(paramString1.substring(i2, m))));
          n = i2;
          while ((n > 0) && (m < i1))
          {
            if (k != 0)
            {
              paramInt1 = (int)(paramInt1 + arrayOfFloat[(n - 1)]);
              if (paramInt1 >= paramInt2) {
                break;
              }
              n -= 1;
            }
            else
            {
              paramInt1 = (int)(paramInt1 + arrayOfFloat[m]);
              if (paramInt1 >= paramInt2) {
                break;
              }
              m += 1;
            }
            k ^= 0x1;
          }
          paramString2 = new StringBuilder();
          paramString2.append("…");
          paramString2.append(paramString1.substring(n, m));
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
      int m = paramArrayList.size();
      int k = 0;
      while (k < m)
      {
        String str2 = (String)paramArrayList.get(k);
        String str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2.toLowerCase();
        }
        localStringBuilder.append(str1);
        if (k != m - 1) {
          localStringBuilder.append("|");
        } else {
          localStringBuilder.append("]");
        }
        k += 1;
      }
    }
    localStringBuilder.append("&&text=[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    return localStringBuilder.toString().toLowerCase();
  }
  
  public static void a()
  {
    HashMap localHashMap = a;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    int m = -1;
    int k = m;
    Object localObject;
    if (!bool)
    {
      k = m;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject = paramString1.toLowerCase();
        if (paramInt == 1)
        {
          if (!paramString2.toLowerCase().contains((CharSequence)localObject))
          {
            k = m;
            break label112;
          }
          if ((paramString3 == null) || (!paramString3.toLowerCase().contains((CharSequence)localObject)))
          {
            if ((paramString4 != null) && (paramString4.toLowerCase().contains((CharSequence)localObject)))
            {
              k = 2;
              break label112;
            }
            k = 3;
            break label112;
          }
        }
        k = 1;
      }
    }
    label112:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTargetType targetType = ");
      ((StringBuilder)localObject).append(k);
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
    return k;
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
    if (TextUtils.isEmpty(this.g)) {
      return;
    }
    Object localObject = this.i;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      localObject = (String)this.i.get(0);
    } else {
      localObject = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    if (this.b == null)
    {
      this.b = this.g;
      this.c = null;
    }
    long l = System.currentTimeMillis();
    if (a.containsKey(this.h))
    {
      localObject = (SpannableString)a.get(this.h);
    }
    else
    {
      paramInt1 = getWidth();
      TextPaint localTextPaint = getPaint();
      paramInt2 = a(this.b, (String)localObject, paramInt1, localTextPaint, this.c);
      String str = a(paramInt2, this.b, (String)localObject, paramInt1, localTextPaint, this.c);
      localObject = a(str, this.i, this.j);
      a.put(this.h, localObject);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("type = ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(", displayText = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", text = ");
        localStringBuilder.append(this.g);
        localStringBuilder.append(", viewWidth = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", new = ");
        localStringBuilder.append(localTextPaint.measureText(str));
        localStringBuilder.append(", old = ");
        localStringBuilder.append(localTextPaint.measureText(this.g));
        localStringBuilder.append(", onLayout t = ");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.d("SingleLineHotwordTextView", 2, localStringBuilder.toString());
      }
    }
    super.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
  }
  
  public void setContentType(int paramInt1, int paramInt2)
  {
    this.d = paramInt2;
    this.e = paramInt1;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setContentType text = ");
      ((StringBuilder)localObject1).append(this.g);
      QLog.d("SingleLineHotwordTextView", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = this.g;
    this.b = ((String)localObject2);
    this.c = null;
    if (paramInt1 == 1)
    {
      localObject1 = FileUtil.a((String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramInt1 = ((String)localObject2).toLowerCase().lastIndexOf(((String)localObject1).toLowerCase());
        if (paramInt1 > -1)
        {
          this.b = ((String)localObject2).substring(0, paramInt1);
          this.c = ((String)localObject1);
          if (((String)localObject1).length() > 1) {
            this.c = ((String)localObject1).substring(1);
          }
        }
        localObject1 = this.i;
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          localObject1 = (String)this.i.get(0);
        } else {
          localObject1 = null;
        }
        this.f = a((String)localObject1, (String)localObject2, this.b, this.c, this.e);
        paramInt1 = this.f;
        if (paramInt1 == 3)
        {
          localObject1 = new StringBuffer(this.b);
          ((StringBuffer)localObject1).append(".");
          ((StringBuffer)localObject1).append(this.c);
          this.b = ((StringBuffer)localObject1).toString();
          this.c = null;
        }
        else
        {
          this.c = a(this.c, (String)localObject1, this.d, paramInt1);
          if (this.f == 2)
          {
            localObject2 = this.i;
            if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0) && (localObject1 != null) && (((String)localObject1).length() > this.d))
            {
              this.i.remove(0);
              this.i.add(0, this.c);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setContentType name = ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(", extension = ");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("SingleLineHotwordTextView", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void setHotword(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = this.i;
      if (paramString != null)
      {
        paramString.clear();
        this.i = null;
      }
    }
    else
    {
      this.i = new ArrayList();
      this.i.add(paramString);
    }
  }
  
  public void setHotword(ArrayList<String> paramArrayList, int paramInt)
  {
    this.i = paramArrayList;
    this.j = paramInt;
  }
  
  public void setHotwords(ArrayList<String> paramArrayList)
  {
    this.i = paramArrayList;
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
    this.g = paramCharSequence.toString();
    this.b = null;
    this.c = null;
    this.d = 2147483647;
    this.e = 0;
    this.f = -1;
    this.h = a(this.g, this.i);
    if (a.containsKey(this.h))
    {
      super.setText((SpannableString)a.get(this.h), paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView
 * JD-Core Version:    0.7.0.1
 */