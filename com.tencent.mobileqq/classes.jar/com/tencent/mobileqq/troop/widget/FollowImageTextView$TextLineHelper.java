package com.tencent.mobileqq.troop.widget;

import android.graphics.Canvas;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FollowImageTextView$TextLineHelper
{
  private List<FollowImageTextView.Line> a = new ArrayList();
  private CharSequence b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private TextPaint j;
  private FollowImageTextView k;
  
  public FollowImageTextView$TextLineHelper(FollowImageTextView paramFollowImageTextView)
  {
    this.k = paramFollowImageTextView;
  }
  
  private int a(CharSequence paramCharSequence)
  {
    return (int)this.j.measureText(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private void a()
  {
    this.a.clear();
    int i3 = b();
    Object localObject;
    if (i3 <= 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("lineWidth=");
        ((StringBuilder)localObject).append(i3);
        QLog.i("FollowImageTextView", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    int i4 = this.b.length();
    int m = 0;
    int i1 = 0;
    int n = 0;
    while (m < i4)
    {
      if (this.b.charAt(m) == '\n')
      {
        localObject = new FollowImageTextView.Line(null);
        ((FollowImageTextView.Line)localObject).b = i1;
        ((FollowImageTextView.Line)localObject).c = (m - 1);
        ((FollowImageTextView.Line)localObject).d = n;
        ((FollowImageTextView.Line)localObject).a = this.b.subSequence(i1, m);
        this.a.add(localObject);
        i1 = m + 1;
        n = 0;
      }
      else
      {
        int i2 = a(this.b.subSequence(i1, m + 1));
        if (i2 > i3)
        {
          localObject = new FollowImageTextView.Line(null);
          ((FollowImageTextView.Line)localObject).b = i1;
          ((FollowImageTextView.Line)localObject).c = (m - 1);
          ((FollowImageTextView.Line)localObject).d = n;
          ((FollowImageTextView.Line)localObject).a = this.b.subSequence(i1, m);
          this.a.add(localObject);
          if (this.a.size() >= i4) {
            break;
          }
          n = 0;
          i1 = m;
          m -= 1;
        }
        else if (m == i4 - 1)
        {
          localObject = new FollowImageTextView.Line(null);
          ((FollowImageTextView.Line)localObject).b = i1;
          ((FollowImageTextView.Line)localObject).c = (m - 1);
          ((FollowImageTextView.Line)localObject).d = i2;
          ((FollowImageTextView.Line)localObject).a = this.b.subSequence(i1, i4);
          this.a.add(localObject);
        }
        else
        {
          n = i2;
        }
      }
      m += 1;
    }
    if (FollowImageTextView.e(this.k) != null) {
      FollowImageTextView.e(this.k).a(this.a.size());
    }
  }
  
  private int b()
  {
    return this.c - this.h - this.f;
  }
  
  public void a(int paramInt)
  {
    FollowImageTextView.FirstTextView localFirstTextView = FollowImageTextView.d(this.k);
    this.b = localFirstTextView.getText();
    this.j = localFirstTextView.getPaint();
    this.c = localFirstTextView.getMeasuredWidth();
    this.d = localFirstTextView.getLineHeight();
    this.f = localFirstTextView.getPaddingLeft();
    this.g = localFirstTextView.getPaddingTop();
    this.h = localFirstTextView.getPaddingRight();
    this.i = localFirstTextView.getPaddingBottom();
    this.e = paramInt;
    a();
  }
  
  public void a(Canvas paramCanvas)
  {
    int n = this.a.size();
    int m = this.e;
    if ((m > 0) && (m < n)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0) {
      n = this.e;
    }
    int i1 = 0;
    while (i1 < n)
    {
      CharSequence localCharSequence = ((FollowImageTextView.Line)this.a.get(i1)).a;
      float f1 = this.j.getTextSize();
      paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), this.f + 0, f1 + this.d * i1 + this.g, this.j);
      i1 += 1;
    }
    if ((m != 0) && (n < this.a.size()))
    {
      paramCanvas = (FollowImageTextView.Line)this.a.get(n);
      m = this.b.length();
      if ((paramCanvas.b > -1) && (paramCanvas.b < m))
      {
        paramCanvas = this.b.subSequence(paramCanvas.b, m);
        FollowImageTextView.f(this.k).setText(paramCanvas);
        FollowImageTextView.a(this.k, true);
        return;
      }
      FollowImageTextView.a(this.k, false);
      return;
    }
    FollowImageTextView.a(this.k, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FollowImageTextView.TextLineHelper
 * JD-Core Version:    0.7.0.1
 */