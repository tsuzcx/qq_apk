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
  private ArrayList<String> b = new ArrayList();
  private ArrayList<Integer> c = new ArrayList();
  private ArrayList<CharSequence> d = new ArrayList();
  private String e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private TextPaint n;
  private boolean o;
  private CharSequence p;
  
  EllipsizingTextView$EllipsizingHelper(EllipsizingTextView paramEllipsizingTextView) {}
  
  private float a(int paramInt, TextUtils.TruncateAt paramTruncateAt)
  {
    int i1 = c() - (int)this.n.measureText("...");
    if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE)
    {
      int i2 = this.m;
      if (i2 <= 0) {
        return i1 / 2;
      }
      if (paramInt == 1)
      {
        if (i1 < i2) {
          return i1;
        }
        return i2;
      }
      if (i1 < i2) {
        return 0.0F;
      }
      return i1 - i2;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.END)
    {
      paramInt = this.m;
      if (paramInt <= 0) {
        return i1;
      }
      if (i1 < paramInt) {
        paramInt = i1;
      } else {
        paramInt = i1 - paramInt;
      }
      return paramInt;
    }
    return i1;
  }
  
  private int a(String paramString)
  {
    return (int)this.n.measureText(paramString, 0, paramString.length());
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
      this.n.getTextWidths(String.valueOf(c1), paramString);
      return (int)Math.ceil(paramString[0]);
    }
    return 0;
  }
  
  private String b(int paramInt)
  {
    int i3 = (int)a(0, TextUtils.TruncateAt.MIDDLE);
    int i4 = this.e.length();
    int i1 = paramInt;
    int i2 = 0;
    while (i1 < i4)
    {
      i2 += a(this.e, i1);
      if (i2 > i3) {
        break;
      }
      i1 += 1;
    }
    return this.e.substring(paramInt, i1);
  }
  
  private void b()
  {
    this.b.clear();
    this.c.clear();
    this.d.clear();
    int i5 = c();
    Object localObject1;
    if (i5 <= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("lineWidth=");
        ((StringBuilder)localObject1).append(i5);
        QLog.i("EllipsizingTextView", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    int i1 = 0;
    int i3 = 0;
    int i2 = 0;
    while (i1 < this.e.length())
    {
      if (this.e.charAt(i1) == '\n')
      {
        this.b.add(this.e.substring(i3, i1));
        if (EllipsizingTextView.b(this.a)) {
          this.d.add(this.p.subSequence(i3, i1));
        }
        this.c.add(Integer.valueOf(i2));
        i3 = i1 + 1;
        i2 = 0;
      }
      else
      {
        int i4 = a(this.e.substring(i3, i1 + 1));
        if (i4 > i5)
        {
          this.b.add(this.e.substring(i3, i1));
          if (EllipsizingTextView.b(this.a)) {
            this.d.add(this.p.subSequence(i3, i1));
          }
          this.c.add(Integer.valueOf(i2));
          if (this.b.size() >= this.e.length()) {
            return;
          }
          i2 = 0;
          i3 = i1;
          i1 -= 1;
        }
        else if (i1 == this.e.length() - 1)
        {
          localObject1 = this.b;
          Object localObject2 = this.e;
          ((ArrayList)localObject1).add(((String)localObject2).substring(i3, ((String)localObject2).length()));
          if (EllipsizingTextView.b(this.a))
          {
            localObject1 = this.d;
            localObject2 = this.p;
            ((ArrayList)localObject1).add(((CharSequence)localObject2).subSequence(i3, ((CharSequence)localObject2).length()));
          }
          this.c.add(Integer.valueOf(i4));
        }
        else
        {
          i2 = i4;
        }
      }
      i1 += 1;
    }
  }
  
  private int c()
  {
    return this.f - this.k - this.i;
  }
  
  private String c(int paramInt)
  {
    int i3 = (int)a(1, TextUtils.TruncateAt.MIDDLE);
    int i1 = paramInt;
    int i2 = 0;
    while (i1 > 0)
    {
      i2 += a(this.e, i1);
      if (i2 > i3) {
        break;
      }
      i1 -= 1;
    }
    return this.e.substring(i1 + 1, paramInt + 1);
  }
  
  private String d(int paramInt)
  {
    int i3 = this.e.length();
    int i4 = (int)a(1, TextUtils.TruncateAt.END);
    int i1 = paramInt;
    int i2 = 0;
    while ((i1 < i3) && (i2 <= i4))
    {
      i2 += a(this.e, i1);
      i1 += 1;
    }
    i1 -= 1;
    if (i1 < paramInt) {
      return "";
    }
    if (i1 > i3) {
      return this.e.substring(paramInt, i3);
    }
    return this.e.substring(paramInt, i1);
  }
  
  public int a()
  {
    return this.b.size();
  }
  
  public int a(int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 <= paramInt)
    {
      i2 += ((String)this.b.get(i1)).length();
      i1 += 1;
    }
    if (i2 <= 0) {
      return 0;
    }
    return i2 - 1;
  }
  
  public void a(Canvas paramCanvas, TextUtils.TruncateAt paramTruncateAt)
  {
    int i1 = this.h;
    int i2;
    if ((i1 > 0) && (i1 <= this.b.size())) {
      i2 = this.h;
    } else {
      i2 = this.b.size();
    }
    int i4 = c();
    Object localObject1 = null;
    int i3 = 0;
    while (i3 < i2)
    {
      String str = (String)this.b.get(i3);
      Object localObject2 = localObject1;
      if (EllipsizingTextView.b(this.a))
      {
        localObject2 = localObject1;
        if (this.d.size() > i3) {
          localObject2 = (CharSequence)this.d.get(i3);
        }
      }
      i1 = ((Integer)this.c.get(i3)).intValue();
      if (paramTruncateAt == TextUtils.TruncateAt.END)
      {
        if ((i2 >= 2) && (i3 == i2 - 1) && (i3 < this.b.size() - 1))
        {
          i1 = a(i2 - 2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(d(i1 + 1));
          ((StringBuilder)localObject1).append("...");
          str = ((StringBuilder)localObject1).toString();
          localObject1 = str;
          if (this.o)
          {
            i1 = (i4 - a(str)) / 2;
            localObject1 = str;
            break label625;
          }
        }
        else if ((i3 == i2 - 1) && (i3 < this.b.size() - 1))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(d(0));
          ((StringBuilder)localObject1).append("...");
          str = ((StringBuilder)localObject1).toString();
          localObject1 = str;
          if (this.o)
          {
            i1 = (i4 - a(str)) / 2;
            localObject1 = str;
            break label625;
          }
        }
        else
        {
          localObject1 = str;
          if (this.o)
          {
            i1 = (i4 - i1) / 2;
            localObject1 = str;
            break label625;
          }
        }
      }
      else
      {
        localObject1 = str;
        if (paramTruncateAt == TextUtils.TruncateAt.MIDDLE) {
          if ((i2 >= 2) && (i3 == i2 - 1) && (i3 < this.b.size() - 1))
          {
            i1 = a(i2 - 2);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(b(i1 + 1));
            ((StringBuilder)localObject1).append("...");
            ((StringBuilder)localObject1).append(c(this.e.length() - 1));
            str = ((StringBuilder)localObject1).toString();
            localObject1 = str;
            if (this.o)
            {
              i1 = (i4 - a(str)) / 2;
              localObject1 = str;
              break label625;
            }
          }
          else if ((i3 == i2 - 1) && (i3 < this.b.size() - 1))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(b(0));
            ((StringBuilder)localObject1).append("...");
            ((StringBuilder)localObject1).append(c(this.e.length() - 1));
            str = ((StringBuilder)localObject1).toString();
            localObject1 = str;
            if (this.o)
            {
              i1 = (i4 - a(str)) / 2;
              localObject1 = str;
              break label625;
            }
          }
          else
          {
            localObject1 = str;
            if (this.o)
            {
              i1 = (i4 - i1) / 2;
              localObject1 = str;
              break label625;
            }
          }
        }
      }
      i1 = 0;
      label625:
      if ((EllipsizingTextView.b(this.a)) && (localObject2 != null))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("text is ");
          ((StringBuilder)localObject1).append(((CharSequence)localObject2).toString());
          ((StringBuilder)localObject1).append("and i is");
          ((StringBuilder)localObject1).append(i3);
          ((StringBuilder)localObject1).append(" offset: ");
          ((StringBuilder)localObject1).append(i1);
          QLog.d("EllipsizingTextView", 2, ((StringBuilder)localObject1).toString());
        }
        if (i3 == 0) {
          paramCanvas.translate(this.i + i1, 0.0F);
        } else {
          paramCanvas.translate(0.0F, this.g);
        }
        new StaticLayout((CharSequence)localObject2, this.n, paramCanvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false).draw(paramCanvas);
      }
      else
      {
        paramCanvas.drawText((String)localObject1, this.i + i1, this.n.getTextSize() + this.g * i3 + this.j, this.n);
      }
      i3 += 1;
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
      this.p = paramCharSequence;
      if (EllipsizingTextView.a(this.a)) {
        if ((paramCharSequence instanceof SpannableString)) {
          EllipsizingTextView.a(this.a, true);
        } else if ((paramCharSequence instanceof SpannedString)) {
          EllipsizingTextView.a(this.a, true);
        }
      }
      this.e = paramCharSequence.toString();
      this.n = paramTextView.getPaint();
      this.f = paramTextView.getMeasuredWidth();
      this.g = paramTextView.getLineHeight();
      this.i = paramTextView.getPaddingLeft();
      this.j = paramTextView.getPaddingTop();
      this.k = paramTextView.getPaddingRight();
      this.l = paramTextView.getPaddingBottom();
      this.h = paramInt1;
      this.m = paramInt2;
      this.o = paramBoolean;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.EllipsizingTextView.EllipsizingHelper
 * JD-Core Version:    0.7.0.1
 */