package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View.MeasureSpec;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class Tag
{
  private static final BoringLayout.Metrics jdField_b_of_type_AndroidTextBoringLayout$Metrics = new BoringLayout.Metrics();
  static int f;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = -16777216;
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point(-1, -1);
  BoringLayout.Metrics jdField_a_of_type_AndroidTextBoringLayout$Metrics;
  Layout jdField_a_of_type_AndroidTextLayout;
  TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  CharSequence jdField_a_of_type_JavaLangCharSequence;
  List<CharSequence> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float = 1.0F;
  int jdField_b_of_type_Int = 0;
  Point jdField_b_of_type_AndroidGraphicsPoint = new Point(0, 0);
  List<Layout> jdField_b_of_type_JavaUtilList;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 0;
  boolean jdField_e_of_type_Boolean = false;
  
  public Tag()
  {
    this.d = 0;
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.SANS_SERIF);
  }
  
  private static int a(Layout paramLayout)
  {
    int i = 0;
    int j = 0;
    while (i < paramLayout.getLineCount())
    {
      j = Math.max((int)(paramLayout.getLineMax(i) + 0.5F), j);
      i += 1;
    }
    return j;
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() * 2);
    int i = 0;
    while (i < paramCharSequence.length())
    {
      localStringBuilder.append(paramCharSequence.charAt(i));
      if (i != paramCharSequence.length() - 1) {
        localStringBuilder.append('\n');
      }
      i += 1;
    }
    return localStringBuilder.toString().subSequence(0, localStringBuilder.length());
  }
  
  public static void a(int paramInt)
  {
    f = paramInt;
  }
  
  private int b(int paramInt)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMeasureHorizontal text:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence);
      ((StringBuilder)localObject1).append(" hasImg:");
      if (this.jdField_e_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" ems:");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Int);
      QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
    }
    int i;
    if (this.jdField_e_of_type_Int == 2) {
      i = this.jdField_c_of_type_Int;
    } else {
      i = 0;
    }
    if (TagUtil.a()) {
      j = 0;
    } else {
      j = i;
    }
    int n = f;
    int m = View.MeasureSpec.getMode(paramInt);
    int i1 = View.MeasureSpec.getSize(paramInt);
    Object localObject1 = jdField_b_of_type_AndroidTextBoringLayout$Metrics;
    localObject1 = BoringLayout.isBoring(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, null);
    if (localObject1 != null) {
      this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = ((BoringLayout.Metrics)localObject1);
    }
    if ((localObject1 != null) && (localObject1 != jdField_b_of_type_AndroidTextBoringLayout$Metrics)) {
      i = ((BoringLayout.Metrics)localObject1).width;
    } else {
      i = (int)Math.ceil(Layout.getDesiredWidth(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint));
    }
    int k = i;
    if (j > 0) {
      k = Math.min(i, a() * j);
    }
    if (m != -2147483648)
    {
      i = k;
      if (m == 1073741824) {}
    }
    for (;;)
    {
      break;
      i = this.jdField_e_of_type_Int;
      if (i == 2) {
        i = Math.min(i1 - n * 3, k);
      } else if (i == 1) {
        i = Math.min(i1 - n * 2, k);
      } else {
        i = Math.min(i1, k);
      }
    }
    m = Math.max(i, 0);
    if (m <= 0) {
      return 0;
    }
    this.jdField_a_of_type_AndroidTextLayout = a(m, (BoringLayout.Metrics)localObject1, m, this.jdField_a_of_type_JavaLangCharSequence, 0.92F);
    if ((j <= 0) && (this.jdField_a_of_type_AndroidTextLayout.getLineCount() > 1))
    {
      this.jdField_a_of_type_Float *= 0.8F;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      if (QLog.isColorLevel()) {
        QLog.i("Tag", 2, "onMeasureHorizontal maxEms=0 another round");
      }
      return b(paramInt);
    }
    k = j;
    Object localObject2;
    if (j == 0)
    {
      k = j;
      if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() > 1)
      {
        if (m % a() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        k = m / a();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onMeasureHorizontal baseEms:");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(" hasExtra:");
          ((StringBuilder)localObject2).append(bool);
          QLog.i("Tag", 2, ((StringBuilder)localObject2).toString());
        }
        j = k;
        if (bool) {
          j = k + 1;
        }
        k = j;
      }
    }
    while ((k > 1) && (this.jdField_a_of_type_AndroidTextLayout.getLineCount() > 1))
    {
      k -= 1;
      if (QLog.isDebugVersion())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onMeasureHorizontal ems--");
        ((StringBuilder)localObject2).append(k);
        QLog.i("Tag", 4, ((StringBuilder)localObject2).toString());
      }
      j = k * a();
      if (j > i) {
        break;
      }
      localObject2 = a(j, (BoringLayout.Metrics)localObject1, j, this.jdField_a_of_type_JavaLangCharSequence, 0.92F);
      if (((Layout)localObject2).getLineCount() != this.jdField_a_of_type_AndroidTextLayout.getLineCount()) {
        break;
      }
      this.jdField_a_of_type_AndroidTextLayout = ((Layout)localObject2);
    }
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() >= 1)
    {
      j = a(this.jdField_a_of_type_AndroidTextLayout);
      i = j;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onMeasureHorizontal want:");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(" actual:");
        ((StringBuilder)localObject1).append(j);
        QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    else
    {
      i = m;
    }
    k = this.jdField_a_of_type_AndroidTextLayout.getHeight() - this.d;
    m = this.jdField_e_of_type_Int;
    if (m == 1) {}
    for (int j = n * 2;; j = n * 3 + k)
    {
      j = i + j;
      break;
      j = i;
      if (m != 2) {
        break;
      }
    }
    if (j > i1)
    {
      this.jdField_a_of_type_Float *= 0.8F;
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onMeasureHorizontal width oversize.another round ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangCharSequence);
        QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
      }
      return b(paramInt);
    }
    if (this.jdField_e_of_type_Int > 0) {
      this.jdField_b_of_type_AndroidGraphicsPoint.set(j, k + n * 2);
    } else {
      this.jdField_b_of_type_AndroidGraphicsPoint.set(j, k);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMeasureHorizontal w:");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_AndroidGraphicsPoint.x);
      ((StringBuilder)localObject1).append(" h:");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_AndroidGraphicsPoint.y);
      QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
    }
    return this.jdField_b_of_type_AndroidGraphicsPoint.y;
  }
  
  private int c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasureVertical text:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangCharSequence);
      QLog.i("Tag", 2, ((StringBuilder)localObject).toString());
    }
    int i = this.jdField_e_of_type_Int;
    int j = 0;
    if (i == 2) {
      i = this.jdField_c_of_type_Int;
    } else {
      i = 0;
    }
    int m = f;
    int n = View.MeasureSpec.getMode(paramInt);
    int i1 = View.MeasureSpec.getSize(paramInt);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      paramInt = 1;
      if (i > 0) {
        if (this.jdField_a_of_type_JavaLangCharSequence.length() % i > 0) {
          paramInt = 1 + this.jdField_a_of_type_JavaLangCharSequence.length() / i;
        } else {
          paramInt = this.jdField_a_of_type_JavaLangCharSequence.length() / i;
        }
      }
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramInt);
    }
    if ((i > 0) && (this.jdField_a_of_type_JavaLangCharSequence.length() > i))
    {
      k = this.jdField_a_of_type_JavaLangCharSequence.length() / i;
      paramInt = k;
      if (this.jdField_a_of_type_JavaLangCharSequence.length() % i > 0) {
        paramInt = k + 1;
      }
      k = Math.min(i, this.jdField_a_of_type_JavaLangCharSequence.length() / paramInt + this.jdField_a_of_type_JavaLangCharSequence.length() % paramInt);
      paramInt = 0;
    }
    while (paramInt < this.jdField_a_of_type_JavaLangCharSequence.length())
    {
      i = paramInt + k;
      if (i >= this.jdField_a_of_type_JavaLangCharSequence.length())
      {
        localObject = this.jdField_a_of_type_JavaUtilList;
        CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
        ((List)localObject).add(localCharSequence.subSequence(paramInt, localCharSequence.length()));
      }
      else
      {
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(paramInt, i));
        paramInt = i;
        continue;
        this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaLangCharSequence);
      }
    }
    paramInt = 2147483647;
    if ((n == 1073741824) || (n == -2147483648)) {
      paramInt = i1 - m * 2;
    }
    int k = d(paramInt);
    i = 0;
    paramInt = j;
    while (paramInt < this.jdField_b_of_type_JavaUtilList.size())
    {
      i = Math.max(((Layout)this.jdField_b_of_type_JavaUtilList.get(paramInt)).getHeight(), i);
      paramInt += 1;
    }
    paramInt = i - this.d;
    i = this.jdField_e_of_type_Int;
    if (i > 0)
    {
      if (i == 2)
      {
        paramInt += k;
        i = m * 3;
      }
      else
      {
        i = m * 2;
      }
      this.jdField_b_of_type_AndroidGraphicsPoint.set(k + m * 2, paramInt + i);
    }
    else
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.set(k, paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasureVertical w:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsPoint.x);
      ((StringBuilder)localObject).append(" h:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsPoint.y);
      QLog.i("Tag", 2, ((StringBuilder)localObject).toString());
    }
    return this.jdField_b_of_type_AndroidGraphicsPoint.y;
  }
  
  private int d(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    }
    int m = 0;
    int j = 0;
    int i = 0;
    int k;
    Object localObject;
    for (;;)
    {
      k = m;
      if (j >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      localObject = a((CharSequence)this.jdField_a_of_type_JavaUtilList.get(j));
      k = (int)Math.ceil(Layout.getDesiredWidth((CharSequence)localObject, this.jdField_a_of_type_AndroidTextTextPaint));
      i += k;
      if (((i >= paramInt) && (j < this.jdField_a_of_type_JavaUtilList.size() - 1)) || ((j == this.jdField_a_of_type_JavaUtilList.size() - 1) && (i > paramInt)))
      {
        this.jdField_a_of_type_Float *= 0.5F;
        float f1 = this.jdField_a_of_type_Float;
        if (f1 < 1.0F) {
          return paramInt;
        }
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(f1);
        return d(paramInt);
      }
      localArrayList1.add(Integer.valueOf(k));
      localArrayList2.add(localObject);
      j += 1;
    }
    while (k < localArrayList2.size())
    {
      localObject = (CharSequence)localArrayList2.get(k);
      localObject = a(((Integer)localArrayList1.get(k)).intValue(), null, ((Integer)localArrayList1.get(k)).intValue(), (CharSequence)localObject, 0.87F);
      this.jdField_b_of_type_JavaUtilList.add(localObject);
      k += 1;
    }
    return i;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt(null);
  }
  
  public int a(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt().top;
    this.d = ((int)((this.jdField_a_of_type_AndroidTextTextPaint.getFontMetricsInt().ascent - i) * 0.5F));
    if (this.jdField_b_of_type_Boolean) {
      return b(paramInt);
    }
    return c(paramInt);
  }
  
  public Point a()
  {
    if (this.jdField_c_of_type_Boolean) {
      return new Point(0, 0);
    }
    return new Point(this.jdField_a_of_type_AndroidGraphicsPoint.x + (int)(this.jdField_b_of_type_AndroidGraphicsPoint.x * 0.5F), this.jdField_a_of_type_AndroidGraphicsPoint.y + (int)(this.jdField_b_of_type_AndroidGraphicsPoint.y * 0.5F));
  }
  
  protected Layout a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, CharSequence paramCharSequence, float paramFloat)
  {
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    if ((paramCharSequence instanceof Spannable)) {
      return new DynamicLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
    BoringLayout.Metrics localMetrics = paramMetrics;
    if (paramMetrics == jdField_b_of_type_AndroidTextBoringLayout$Metrics)
    {
      paramMetrics = BoringLayout.isBoring(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_AndroidTextBoringLayout$Metrics);
      localMetrics = paramMetrics;
      if (paramMetrics != null)
      {
        this.jdField_a_of_type_AndroidTextBoringLayout$Metrics = paramMetrics;
        localMetrics = paramMetrics;
      }
    }
    if (localMetrics != null)
    {
      if (localMetrics.width <= paramInt1) {
        return BoringLayout.make(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, localMetrics, false);
      }
      return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
    return new StaticLayout(paramCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, paramFloat, 0.0F, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPoint.set(-1, -1);
    this.jdField_b_of_type_AndroidGraphicsPoint.set(0, 0);
    this.jdField_a_of_type_AndroidTextLayout = null;
    List localList = this.jdField_b_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
    localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidTextLayout == null) {
        break label77;
      }
    }
    else
    {
      List localList = this.jdField_b_of_type_JavaUtilList;
      if ((localList == null) || (localList.size() <= 0)) {
        break label77;
      }
    }
    if ((this.jdField_a_of_type_AndroidGraphicsPoint.x >= 0) && (this.jdField_a_of_type_AndroidGraphicsPoint.y >= 0) && (this.jdField_b_of_type_AndroidGraphicsPoint.x > 0) && (this.jdField_b_of_type_AndroidGraphicsPoint.y > 0)) {
      return true;
    }
    label77:
    return false;
  }
  
  public int b()
  {
    int j = this.jdField_b_of_type_AndroidGraphicsPoint.x;
    int i = this.jdField_b_of_type_AndroidGraphicsPoint.y;
    int k = f;
    int m = this.jdField_e_of_type_Int;
    if (m == 2)
    {
      if (this.jdField_b_of_type_Boolean) {
        return j - (i - k * 2 + k * 3);
      }
    }
    else
    {
      i = j;
      if (m != 1) {
        return i;
      }
    }
    i = j - k * 2;
    return i;
  }
  
  public int c()
  {
    int i = this.jdField_b_of_type_AndroidGraphicsPoint.x;
    int j = this.jdField_b_of_type_AndroidGraphicsPoint.y;
    int k = f;
    int m = this.jdField_e_of_type_Int;
    if (m == 2)
    {
      if (!this.jdField_b_of_type_Boolean) {
        return j - (i - k * 2 + k * 3);
      }
    }
    else
    {
      i = j;
      if (m != 1) {
        return i;
      }
    }
    i = j - k * 2;
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("texts:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append(" w:");
    localStringBuilder.append(this.jdField_b_of_type_AndroidGraphicsPoint.x);
    localStringBuilder.append(" h:");
    localStringBuilder.append(this.jdField_b_of_type_AndroidGraphicsPoint.y);
    localStringBuilder.append(" textSize:");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" cord.x:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPoint.x);
    localStringBuilder.append(" cord.y:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsPoint.y);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.Tag
 * JD-Core Version:    0.7.0.1
 */