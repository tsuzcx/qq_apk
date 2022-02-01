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
  static int u;
  private static final BoringLayout.Metrics v = new BoringLayout.Metrics();
  boolean a;
  boolean b;
  CharSequence c;
  Layout d;
  List<CharSequence> e;
  List<Layout> f;
  Point g = new Point(-1, -1);
  Point h = new Point(0, 0);
  float i;
  int j = -16777216;
  int k = 0;
  int l = 0;
  TextPaint m = new TextPaint(1);
  boolean n;
  boolean o;
  BoringLayout.Metrics p;
  float q = 1.0F;
  int r = 0;
  int s = 0;
  boolean t = false;
  
  public Tag()
  {
    this.m.setTypeface(Typeface.SANS_SERIF);
  }
  
  private static int a(Layout paramLayout)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramLayout.getLineCount())
    {
      i2 = Math.max((int)(paramLayout.getLineMax(i1) + 0.5F), i2);
      i1 += 1;
    }
    return i2;
  }
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length() * 2);
    int i1 = 0;
    while (i1 < paramCharSequence.length())
    {
      localStringBuilder.append(paramCharSequence.charAt(i1));
      if (i1 != paramCharSequence.length() - 1) {
        localStringBuilder.append('\n');
      }
      i1 += 1;
    }
    return localStringBuilder.toString().subSequence(0, localStringBuilder.length());
  }
  
  public static void a(int paramInt)
  {
    u = paramInt;
  }
  
  private int c(int paramInt)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMeasureHorizontal text:");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(" hasImg:");
      if (this.s == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" ems:");
      ((StringBuilder)localObject1).append(this.l);
      QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
    }
    int i1;
    if (this.s == 2) {
      i1 = this.l;
    } else {
      i1 = 0;
    }
    if (TagUtil.a()) {
      i2 = 0;
    } else {
      i2 = i1;
    }
    int i5 = u;
    int i4 = View.MeasureSpec.getMode(paramInt);
    int i6 = View.MeasureSpec.getSize(paramInt);
    Object localObject1 = v;
    localObject1 = BoringLayout.isBoring(this.c, this.m, null);
    if (localObject1 != null) {
      this.p = ((BoringLayout.Metrics)localObject1);
    }
    if ((localObject1 != null) && (localObject1 != v)) {
      i1 = ((BoringLayout.Metrics)localObject1).width;
    } else {
      i1 = (int)Math.ceil(Layout.getDesiredWidth(this.c, this.m));
    }
    int i3 = i1;
    if (i2 > 0) {
      i3 = Math.min(i1, c() * i2);
    }
    if (i4 != -2147483648)
    {
      i1 = i3;
      if (i4 == 1073741824) {}
    }
    for (;;)
    {
      break;
      i1 = this.s;
      if (i1 == 2) {
        i1 = Math.min(i6 - i5 * 3, i3);
      } else if (i1 == 1) {
        i1 = Math.min(i6 - i5 * 2, i3);
      } else {
        i1 = Math.min(i6, i3);
      }
    }
    i4 = Math.max(i1, 0);
    if (i4 <= 0) {
      return 0;
    }
    this.d = a(i4, (BoringLayout.Metrics)localObject1, i4, this.c, 0.92F);
    if ((i2 <= 0) && (this.d.getLineCount() > 1))
    {
      this.i *= 0.8F;
      this.m.setTextSize(this.i);
      if (QLog.isColorLevel()) {
        QLog.i("Tag", 2, "onMeasureHorizontal maxEms=0 another round");
      }
      return c(paramInt);
    }
    i3 = i2;
    Object localObject2;
    if (i2 == 0)
    {
      i3 = i2;
      if (this.d.getLineCount() > 1)
      {
        if (i4 % c() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        i3 = i4 / c();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onMeasureHorizontal baseEms:");
          ((StringBuilder)localObject2).append(i3);
          ((StringBuilder)localObject2).append(" hasExtra:");
          ((StringBuilder)localObject2).append(bool);
          QLog.i("Tag", 2, ((StringBuilder)localObject2).toString());
        }
        i2 = i3;
        if (bool) {
          i2 = i3 + 1;
        }
        i3 = i2;
      }
    }
    while ((i3 > 1) && (this.d.getLineCount() > 1))
    {
      i3 -= 1;
      if (QLog.isDebugVersion())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onMeasureHorizontal ems--");
        ((StringBuilder)localObject2).append(i3);
        QLog.i("Tag", 4, ((StringBuilder)localObject2).toString());
      }
      i2 = i3 * c();
      if (i2 > i1) {
        break;
      }
      localObject2 = a(i2, (BoringLayout.Metrics)localObject1, i2, this.c, 0.92F);
      if (((Layout)localObject2).getLineCount() != this.d.getLineCount()) {
        break;
      }
      this.d = ((Layout)localObject2);
    }
    if (this.d.getLineCount() >= 1)
    {
      i2 = a(this.d);
      i1 = i2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onMeasureHorizontal want:");
        ((StringBuilder)localObject1).append(i4);
        ((StringBuilder)localObject1).append(" actual:");
        ((StringBuilder)localObject1).append(i2);
        QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
        i1 = i2;
      }
    }
    else
    {
      i1 = i4;
    }
    i3 = this.d.getHeight() - this.r;
    i4 = this.s;
    if (i4 == 1) {}
    for (int i2 = i5 * 2;; i2 = i5 * 3 + i3)
    {
      i2 = i1 + i2;
      break;
      i2 = i1;
      if (i4 != 2) {
        break;
      }
    }
    if (i2 > i6)
    {
      this.i *= 0.8F;
      this.m.setTextSize(this.i);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onMeasureHorizontal width oversize.another round ");
        ((StringBuilder)localObject1).append(this.c);
        QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
      }
      return c(paramInt);
    }
    if (this.s > 0) {
      this.h.set(i2, i3 + i5 * 2);
    } else {
      this.h.set(i2, i3);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onMeasureHorizontal w:");
      ((StringBuilder)localObject1).append(this.h.x);
      ((StringBuilder)localObject1).append(" h:");
      ((StringBuilder)localObject1).append(this.h.y);
      QLog.i("Tag", 2, ((StringBuilder)localObject1).toString());
    }
    return this.h.y;
  }
  
  private int d(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasureVertical text:");
      ((StringBuilder)localObject).append(this.c);
      QLog.i("Tag", 2, ((StringBuilder)localObject).toString());
    }
    int i1 = this.s;
    int i2 = 0;
    if (i1 == 2) {
      i1 = this.l;
    } else {
      i1 = 0;
    }
    int i4 = u;
    int i5 = View.MeasureSpec.getMode(paramInt);
    int i6 = View.MeasureSpec.getSize(paramInt);
    if (this.e == null)
    {
      paramInt = 1;
      if (i1 > 0) {
        if (this.c.length() % i1 > 0) {
          paramInt = 1 + this.c.length() / i1;
        } else {
          paramInt = this.c.length() / i1;
        }
      }
      this.e = new ArrayList(paramInt);
    }
    if ((i1 > 0) && (this.c.length() > i1))
    {
      i3 = this.c.length() / i1;
      paramInt = i3;
      if (this.c.length() % i1 > 0) {
        paramInt = i3 + 1;
      }
      i3 = Math.min(i1, this.c.length() / paramInt + this.c.length() % paramInt);
      paramInt = 0;
    }
    while (paramInt < this.c.length())
    {
      i1 = paramInt + i3;
      if (i1 >= this.c.length())
      {
        localObject = this.e;
        CharSequence localCharSequence = this.c;
        ((List)localObject).add(localCharSequence.subSequence(paramInt, localCharSequence.length()));
      }
      else
      {
        this.e.add(this.c.subSequence(paramInt, i1));
        paramInt = i1;
        continue;
        this.e.add(this.c);
      }
    }
    paramInt = 2147483647;
    if ((i5 == 1073741824) || (i5 == -2147483648)) {
      paramInt = i6 - i4 * 2;
    }
    int i3 = e(paramInt);
    i1 = 0;
    paramInt = i2;
    while (paramInt < this.f.size())
    {
      i1 = Math.max(((Layout)this.f.get(paramInt)).getHeight(), i1);
      paramInt += 1;
    }
    paramInt = i1 - this.r;
    i1 = this.s;
    if (i1 > 0)
    {
      if (i1 == 2)
      {
        paramInt += i3;
        i1 = i4 * 3;
      }
      else
      {
        i1 = i4 * 2;
      }
      this.h.set(i3 + i4 * 2, paramInt + i1);
    }
    else
    {
      this.h.set(i3, paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMeasureVertical w:");
      ((StringBuilder)localObject).append(this.h.x);
      ((StringBuilder)localObject).append(" h:");
      ((StringBuilder)localObject).append(this.h.y);
      QLog.i("Tag", 2, ((StringBuilder)localObject).toString());
    }
    return this.h.y;
  }
  
  private int e(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList(this.e.size());
    ArrayList localArrayList2 = new ArrayList(this.e.size());
    if (this.f == null) {
      this.f = new ArrayList(this.e.size());
    }
    int i4 = 0;
    int i2 = 0;
    int i1 = 0;
    int i3;
    Object localObject;
    for (;;)
    {
      i3 = i4;
      if (i2 >= this.e.size()) {
        break;
      }
      localObject = a((CharSequence)this.e.get(i2));
      i3 = (int)Math.ceil(Layout.getDesiredWidth((CharSequence)localObject, this.m));
      i1 += i3;
      if (((i1 >= paramInt) && (i2 < this.e.size() - 1)) || ((i2 == this.e.size() - 1) && (i1 > paramInt)))
      {
        this.i *= 0.5F;
        float f1 = this.i;
        if (f1 < 1.0F) {
          return paramInt;
        }
        this.m.setTextSize(f1);
        return e(paramInt);
      }
      localArrayList1.add(Integer.valueOf(i3));
      localArrayList2.add(localObject);
      i2 += 1;
    }
    while (i3 < localArrayList2.size())
    {
      localObject = (CharSequence)localArrayList2.get(i3);
      localObject = a(((Integer)localArrayList1.get(i3)).intValue(), null, ((Integer)localArrayList1.get(i3)).intValue(), (CharSequence)localObject, 0.87F);
      this.f.add(localObject);
      i3 += 1;
    }
    return i1;
  }
  
  protected Layout a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2, CharSequence paramCharSequence, float paramFloat)
  {
    Layout.Alignment localAlignment = Layout.Alignment.ALIGN_NORMAL;
    if ((paramCharSequence instanceof Spannable)) {
      return new DynamicLayout(paramCharSequence, this.m, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
    BoringLayout.Metrics localMetrics = paramMetrics;
    if (paramMetrics == v)
    {
      paramMetrics = BoringLayout.isBoring(paramCharSequence, this.m, this.p);
      localMetrics = paramMetrics;
      if (paramMetrics != null)
      {
        this.p = paramMetrics;
        localMetrics = paramMetrics;
      }
    }
    if (localMetrics != null)
    {
      if (localMetrics.width <= paramInt1) {
        return BoringLayout.make(paramCharSequence, this.m, paramInt1, localAlignment, paramFloat, 0.0F, localMetrics, false);
      }
      return new StaticLayout(paramCharSequence, this.m, paramInt1, localAlignment, paramFloat, 0.0F, false);
    }
    return new StaticLayout(paramCharSequence, this.m, paramInt1, localAlignment, paramFloat, 0.0F, false);
  }
  
  public void a()
  {
    this.g.set(-1, -1);
    this.h.set(0, 0);
    this.d = null;
    List localList = this.f;
    if (localList != null) {
      localList.clear();
    }
    localList = this.e;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public int b(int paramInt)
  {
    int i1 = this.m.getFontMetricsInt().top;
    this.r = ((int)((this.m.getFontMetricsInt().ascent - i1) * 0.5F));
    if (this.b) {
      return c(paramInt);
    }
    return d(paramInt);
  }
  
  public boolean b()
  {
    if (this.b)
    {
      if (this.d == null) {
        break label77;
      }
    }
    else
    {
      List localList = this.f;
      if ((localList == null) || (localList.size() <= 0)) {
        break label77;
      }
    }
    if ((this.g.x >= 0) && (this.g.y >= 0) && (this.h.x > 0) && (this.h.y > 0)) {
      return true;
    }
    label77:
    return false;
  }
  
  public int c()
  {
    return this.m.getFontMetricsInt(null);
  }
  
  public int d()
  {
    int i2 = this.h.x;
    int i1 = this.h.y;
    int i3 = u;
    int i4 = this.s;
    if (i4 == 2)
    {
      if (this.b) {
        return i2 - (i1 - i3 * 2 + i3 * 3);
      }
    }
    else
    {
      i1 = i2;
      if (i4 != 1) {
        return i1;
      }
    }
    i1 = i2 - i3 * 2;
    return i1;
  }
  
  public int e()
  {
    int i1 = this.h.x;
    int i2 = this.h.y;
    int i3 = u;
    int i4 = this.s;
    if (i4 == 2)
    {
      if (!this.b) {
        return i2 - (i1 - i3 * 2 + i3 * 3);
      }
    }
    else
    {
      i1 = i2;
      if (i4 != 1) {
        return i1;
      }
    }
    i1 = i2 - i3 * 2;
    return i1;
  }
  
  public Point f()
  {
    if (this.n) {
      return new Point(0, 0);
    }
    return new Point(this.g.x + (int)(this.h.x * 0.5F), this.g.y + (int)(this.h.y * 0.5F));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("texts:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" w:");
    localStringBuilder.append(this.h.x);
    localStringBuilder.append(" h:");
    localStringBuilder.append(this.h.y);
    localStringBuilder.append(" textSize:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(" cord.x:");
    localStringBuilder.append(this.g.x);
    localStringBuilder.append(" cord.y:");
    localStringBuilder.append(this.g.y);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.Tag
 * JD-Core Version:    0.7.0.1
 */