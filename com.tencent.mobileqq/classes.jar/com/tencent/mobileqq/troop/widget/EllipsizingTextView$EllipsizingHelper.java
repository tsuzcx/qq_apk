package com.tencent.mobileqq.troop.widget;

import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class EllipsizingTextView$EllipsizingHelper
{
  private int jdField_a_of_type_Int;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList<Integer> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int;
  private ArrayList<CharSequence> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  EllipsizingTextView$EllipsizingHelper(EllipsizingTextView paramEllipsizingTextView) {}
  
  private float a(int paramInt, TextUtils.TruncateAt paramTruncateAt)
  {
    int i = b() - (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("...");
    if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE)
    {
      int j = this.h;
      if (j <= 0) {
        return i / 2;
      }
      if (paramInt == 1)
      {
        if (i < j) {
          return i;
        }
        return j;
      }
      if (i < j) {
        return 0.0F;
      }
      return i - j;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.END)
    {
      paramInt = this.h;
      if (paramInt <= 0) {
        return i;
      }
      if (i < paramInt) {
        paramInt = i;
      } else {
        paramInt = i - paramInt;
      }
      return paramInt;
    }
    return i;
  }
  
  private int a(String paramString)
  {
    return (int)this.jdField_a_of_type_AndroidTextTextPaint.measureText(paramString, 0, paramString.length());
  }
  
  private int a(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramInt >= 0))
    {
      if (paramInt > paramString.length() - 1) {
        return 0;
      }
      char c1 = paramString.charAt(paramInt);
      paramString = new float[1];
      this.jdField_a_of_type_AndroidTextTextPaint.getTextWidths(String.valueOf(c1), paramString);
      return (int)Math.ceil(paramString[0]);
    }
    return 0;
  }
  
  private String a(int paramInt)
  {
    int k = (int)a(0, TextUtils.TruncateAt.MIDDLE);
    int m = this.jdField_a_of_type_JavaLangString.length();
    int i = paramInt;
    int j = 0;
    while (i < m)
    {
      j += a(this.jdField_a_of_type_JavaLangString, i);
      if (j > k) {
        break;
      }
      i += 1;
    }
    return this.jdField_a_of_type_JavaLangString.substring(paramInt, i);
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    int n = b();
    Object localObject1;
    if (n <= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lineWidth=");
        ((StringBuilder)localObject1).append(n);
        QLog.i("EllipsizingTextView", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaLangString.length())
    {
      if (this.jdField_a_of_type_JavaLangString.charAt(i) == '\n')
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(k, i));
        if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) {
          this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i));
        }
        this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
        k = i + 1;
        j = 0;
      }
      else
      {
        int m = a(this.jdField_a_of_type_JavaLangString.substring(k, i + 1));
        if (m > n)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangString.substring(k, i));
          if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) {
            this.jdField_c_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(k, i));
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(j));
          if (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.jdField_a_of_type_JavaLangString.length()) {
            return;
          }
          j = 0;
          k = i;
          i -= 1;
        }
        else if (i == this.jdField_a_of_type_JavaLangString.length() - 1)
        {
          localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
          Object localObject2 = this.jdField_a_of_type_JavaLangString;
          ((ArrayList)localObject1).add(((String)localObject2).substring(k, ((String)localObject2).length()));
          if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView))
          {
            localObject1 = this.jdField_c_of_type_JavaUtilArrayList;
            localObject2 = this.jdField_a_of_type_JavaLangCharSequence;
            ((ArrayList)localObject1).add(((CharSequence)localObject2).subSequence(k, ((CharSequence)localObject2).length()));
          }
          this.jdField_b_of_type_JavaUtilArrayList.add(Integer.valueOf(m));
        }
        else
        {
          j = m;
        }
      }
      i += 1;
    }
  }
  
  private int b()
  {
    return this.jdField_a_of_type_Int - this.f - this.d;
  }
  
  private String b(int paramInt)
  {
    int k = (int)a(1, TextUtils.TruncateAt.MIDDLE);
    int i = paramInt;
    int j = 0;
    while (i > 0)
    {
      j += a(this.jdField_a_of_type_JavaLangString, i);
      if (j > k) {
        break;
      }
      i -= 1;
    }
    return this.jdField_a_of_type_JavaLangString.substring(i + 1, paramInt + 1);
  }
  
  private String c(int paramInt)
  {
    int k = this.jdField_a_of_type_JavaLangString.length();
    int m = (int)a(1, TextUtils.TruncateAt.END);
    int i = paramInt;
    int j = 0;
    while ((i < k) && (j <= m))
    {
      j += a(this.jdField_a_of_type_JavaLangString, i);
      i += 1;
    }
    i -= 1;
    if (i < paramInt) {
      return "";
    }
    if (i > k) {
      return this.jdField_a_of_type_JavaLangString.substring(paramInt, k);
    }
    return this.jdField_a_of_type_JavaLangString.substring(paramInt, i);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i <= paramInt)
    {
      j += ((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).length();
      i += 1;
    }
    if (j <= 0) {
      return 0;
    }
    return j - 1;
  }
  
  public void a(Canvas paramCanvas, TextUtils.TruncateAt paramTruncateAt)
  {
    int i = this.jdField_c_of_type_Int;
    int j;
    if ((i > 0) && (i <= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      j = this.jdField_c_of_type_Int;
    } else {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    int m = b();
    Object localObject1 = null;
    int k = 0;
    while (k < j)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(k);
      Object localObject2 = localObject1;
      if (EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView))
      {
        localObject2 = localObject1;
        if (this.jdField_c_of_type_JavaUtilArrayList.size() > k) {
          localObject2 = (CharSequence)this.jdField_c_of_type_JavaUtilArrayList.get(k);
        }
      }
      i = ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(k)).intValue();
      if (paramTruncateAt == TextUtils.TruncateAt.END)
      {
        if ((j >= 2) && (k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
        {
          i = a(j - 2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(c(i + 1));
          ((StringBuilder)localObject1).append("...");
          str = ((StringBuilder)localObject1).toString();
          localObject1 = str;
          if (this.jdField_a_of_type_Boolean)
          {
            i = (m - a(str)) / 2;
            localObject1 = str;
            break label625;
          }
        }
        else if ((k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(c(0));
          ((StringBuilder)localObject1).append("...");
          str = ((StringBuilder)localObject1).toString();
          localObject1 = str;
          if (this.jdField_a_of_type_Boolean)
          {
            i = (m - a(str)) / 2;
            localObject1 = str;
            break label625;
          }
        }
        else
        {
          localObject1 = str;
          if (this.jdField_a_of_type_Boolean)
          {
            i = (m - i) / 2;
            localObject1 = str;
            break label625;
          }
        }
      }
      else
      {
        localObject1 = str;
        if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE) {
          if ((j >= 2) && (k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
          {
            i = a(j - 2);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(a(i + 1));
            ((StringBuilder)localObject1).append("...");
            ((StringBuilder)localObject1).append(b(this.jdField_a_of_type_JavaLangString.length() - 1));
            str = ((StringBuilder)localObject1).toString();
            localObject1 = str;
            if (this.jdField_a_of_type_Boolean)
            {
              i = (m - a(str)) / 2;
              localObject1 = str;
              break label625;
            }
          }
          else if ((k == j - 1) && (k < this.jdField_a_of_type_JavaUtilArrayList.size() - 1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(a(0));
            ((StringBuilder)localObject1).append("...");
            ((StringBuilder)localObject1).append(b(this.jdField_a_of_type_JavaLangString.length() - 1));
            str = ((StringBuilder)localObject1).toString();
            localObject1 = str;
            if (this.jdField_a_of_type_Boolean)
            {
              i = (m - a(str)) / 2;
              localObject1 = str;
              break label625;
            }
          }
          else
          {
            localObject1 = str;
            if (this.jdField_a_of_type_Boolean)
            {
              i = (m - i) / 2;
              localObject1 = str;
              break label625;
            }
          }
        }
      }
      i = 0;
      label625:
      if ((EllipsizingTextView.b(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) && (localObject2 != null))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("text is ");
          ((StringBuilder)localObject1).append(((CharSequence)localObject2).toString());
          ((StringBuilder)localObject1).append("and i is");
          ((StringBuilder)localObject1).append(k);
          ((StringBuilder)localObject1).append(" offset: ");
          ((StringBuilder)localObject1).append(i);
          QLog.d("EllipsizingTextView", 2, ((StringBuilder)localObject1).toString());
        }
        if (k == 0) {
          paramCanvas.translate(this.d + i, 0.0F);
        } else {
          paramCanvas.translate(0.0F, this.jdField_b_of_type_Int);
        }
        new StaticLayout((CharSequence)localObject2, this.jdField_a_of_type_AndroidTextTextPaint, paramCanvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
      }
      else
      {
        paramCanvas.drawText((String)localObject1, this.d + i, this.jdField_a_of_type_AndroidTextTextPaint.getTextSize() + this.jdField_b_of_type_Int * k + this.e, this.jdField_a_of_type_AndroidTextTextPaint);
      }
      k += 1;
      localObject1 = localObject2;
    }
  }
  
  public void a(CharSequence paramCharSequence, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramCharSequence != null)
    {
      if (paramTextView == null) {
        return;
      }
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
      if (EllipsizingTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView)) {
        if ((paramCharSequence instanceof SpannableString)) {
          EllipsizingTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView, true);
        } else if ((paramCharSequence instanceof SpannedString)) {
          EllipsizingTextView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView, true);
        }
      }
      this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
      this.jdField_a_of_type_AndroidTextTextPaint = paramTextView.getPaint();
      this.jdField_a_of_type_Int = paramTextView.getMeasuredWidth();
      this.jdField_b_of_type_Int = paramTextView.getLineHeight();
      this.d = paramTextView.getPaddingLeft();
      this.e = paramTextView.getPaddingTop();
      this.f = paramTextView.getPaddingRight();
      this.g = paramTextView.getPaddingBottom();
      this.jdField_c_of_type_Int = paramInt1;
      this.h = paramInt2;
      this.jdField_a_of_type_Boolean = paramBoolean;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView.EllipsizingHelper
 * JD-Core Version:    0.7.0.1
 */